package org.open.erp.services.vanzari.impl;

/**
 * @author Irina Bogdan
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.ContabilizareSrvLocal;
import org.open.erp.services.ctbgen.StareDocument;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.ctbgen.impl.ContabilizareSrvImpl;
import org.open.erp.services.nomgen.Produs;
//import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.StocuriSrvLocal;
import org.open.erp.services.stocuri.impl.StocuriImpl;
import org.open.erp.services.vanzari.*;
import org.open.erp.services.vanzari.exceptions.ValoareNegativa;

@Stateful
public class VanzariImpl implements VanzariSrvLocal, VanzariSrvRemote{
	
	/* Dependente proprii */
	private static Logger logger = Logger.getLogger(VanzariImpl.class.getName());
	private RegistruVanzari registruVanzari;
	
	private ProcesareComanda procesareComanda = new ProcesareComanda();
	private ProcesareFacturaEmisa procesareFactura = new ProcesareFacturaEmisa();
	
	/* Dependente resurse injectate */
	@EJB(mappedName="StocuriImpl/local")
	public StocuriSrvLocal stocuriSrv = new StocuriImpl();
	@EJB(mappedName="ContabilizareSrvImpl/local")
	public ContabilizareSrvLocal contabilizareSrv = new ContabilizareSrvImpl();
	
	@PersistenceContext(unitName="OpenERP_VANZARI")
	private EntityManager em;
	@Resource
	private SessionContext sessionContext;	
	
	/* Initializare */
	public VanzariImpl(){}
	@PostConstruct
	public void init(){
		logger.debug(">>>>>>>>>>>> Exista em? " + em);		
		logger.debug(">>>>>>>>>>>> Exista stocuriSrv? " + stocuriSrv);
		logger.debug(">>>>>>>>>>>> Exista caontabSrv? " + contabilizareSrv);
		
		if (this.registruVanzari == null)
			registruVanzari = new RegistruVanzari(em);
		
		//procesareComanda = new ProcesareComanda(em, registruVanzari);
		//procesareFactura = new ProcesareFacturaEmisa(em, registruVanzari);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Comanda inregistrareComanda(Produs[] produs, Double[] cant, Client client) {
		logger.debug(">>>>>>>>>>>> START Creare comanda");
		Comanda comanda = new Comanda(1, new Date(), client, Comanda.PENDING);
		procesareComanda.setComanda(comanda);
		
		for(int i=0; i<produs.length; i++){
			if( !procesareComanda.addProdusInComanda(produs[i], cant[i])){
				logger.debug("Produsul nu a fost adaugat in comanda");			
			}
		}
		logger.debug(">>>>>>>>>>>> END Creare comanda");
		
		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Creare comanda - TRANZACTIE ANULATA");
		}else{
			try{
				comanda = procesareComanda.getComanda();
				comanda = this.registruVanzari.salveazaComanda(comanda);
			} catch(Exception e){
				logger.debug("Probleme procesare comanda");
			}
		}
		//return procesareComanda.getComanda();
		return comanda;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public FacturaEmisa facturareProduse(Comanda comanda, Client client, Vanzator vanzator) {
		logger.debug(">>>>>>>>>>>> START Creare factura");
		
		FacturaEmisa factura = new FacturaEmisa(1, client, vanzator, FacturaEmisa.NEPLATITA);
		factura.setNrComanda(comanda.getNrComanda());
		factura.setDataDoc(new Date());
		
		//procesareFactura.setFactura(factura);
		
		// preia liniile din comanda si le trece in factura
		Boolean prodAdaugat = false;
		Iterator<LinieComanda> iterator = comanda.getProduseComandate().iterator();
		while(iterator.hasNext()){
			LinieComanda linieComanda = iterator.next();
			LinieFacturaEmisa linieFactura = new LinieFacturaEmisa();
			prodAdaugat = procesareFactura.checkDisponibilitateProdus(linieComanda.getProdus(), linieComanda.getCantitate());
			if( prodAdaugat){
				try{
					//linieFactura.setProdus(linieComanda.getProdus());
					linieFactura.setMaterial(linieComanda.getProdus());
					linieFactura.setCantitate(linieComanda.getCantitate());
					//linieFactura.setCantitateFacturata(linieComanda.getCantitate());
					procesareFactura.setLinie(linieFactura);
					procesareFactura.calculeazaPretLinie();
					procesareFactura.calculeazaTvaLinie();
					linieFactura = procesareFactura.getLinie();
					// adaugare linie
					factura.addLinie(linieFactura);
					
				} catch(ValoareNegativa e){
					logger.debug("Probleme procesare factura");
				}
			}
		}
		
		factura.calculeazaValoareFactura();
		factura.calculeazaTvaFactura();
		
		// actualizare Sold client in momentul emiterii facturii
		this.actualizeazaSoldClient(factura, client);
		
		this.actulizareStoc(1, factura); // iesire din stoc
		
		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Creare factura - TRANZACTIE ANULATA");
		}else{
			try{
				factura = this.registruVanzari.salveazaFactura(factura);
			} catch(Exception e){
				logger.debug("Probleme procesare factura");
			}
		}
		
		//this.inregistrareFactura(factura);
		logger.debug(">>>>>>>>>>>> END Creare factura");
		return factura;
	}
	
	@Override
	public Integer inregistrareFactura(FacturaEmisa factura){
		Integer result = 0;
		try{
			//ArrayList<LinieDocument> liniiDoc = (ArrayList<LinieFacturaEmisa>) factura.getProduseFacturate();
			result = contabilizareSrv.jurnalizareVanzare(factura.getDataDoc(), factura.getValoareTotalaFactura(), factura.getValoareTva(), factura.getNrDoc(), factura.getClient().getId(), factura.getLiniiDocument() , StareDocument.NOU, 1);
		} catch(CtbException e){	
		}
		return result;
	}
	
	@Override
	public void actulizareStoc(Integer mod, FacturaEmisa factura){
		switch(mod){
		case 1:
			stocuriSrv.iesireStoc(factura); break;
		case 2:
			//stocuriSrv.intrareInStoc(factura); break;
		}
	}
	
	@Override
	public void actualizeazaSoldClient(FacturaEmisa factura, Client client){
		Double suma = factura.getValoareTotalaFactura() + factura.getValoareTva();
		client.setSoldClient(client.getSoldClient() + suma);
	}

	@Override
	public ArrayList<FacturaEmisa> getFacturiClient(Client client) {
		Vanzator vanzator = new Vanzator();
		
		FacturaEmisa factura = new FacturaEmisa();
		factura.setIdFactura(1);
		factura.setClient(client);
		factura.setVanzator(vanzator);
		factura.setPlatita(FacturaEmisa.NEPLATITA);
		
		ArrayList<FacturaEmisa> facturi = new ArrayList<FacturaEmisa>();
		facturi.add(factura);
		return facturi;
	}

	@Override
	public void returProduse(FacturaEmisa factura) {
		if( factura.isReturnable()){
			this.actulizareStoc(2, factura); // intrare in stoc
			//this.inregistrareFactura(factura);
		}
	}


		
	
}
