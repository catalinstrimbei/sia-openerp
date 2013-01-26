package org.open.erp.services.vanzari.impl;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hamcrest.core.Is;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.StocuriSrvLocal;
import org.open.erp.services.vanzari.ArticolComanda;
import org.open.erp.services.vanzari.Avize;
import org.open.erp.services.vanzari.Comenzi;
import org.open.erp.services.vanzari.DispozitiiLivrare;
import org.open.erp.services.vanzari.Facturi;
import org.open.erp.services.vanzari.LiniiAviz;
import org.open.erp.services.vanzari.LiniiDispozitieLivrare;
import org.open.erp.services.vanzari.LiniiFactura;
import org.open.erp.services.vanzari.OfertePret;
import org.open.erp.services.vanzari.Persoana;
import org.open.erp.services.vanzari.Produse;
import org.open.erp.services.vanzari.VanzariSrv;
import org.open.erp.services.vanzari.VanzariSrvLocal;

/**
 * 
 * @ApplicationServiceImplementation
 *
 */

/**
 * @author Ionela
 *
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)

public class VanzariImpl implements VanzariSrv, VanzariSrvLocal{
	

	//private NomenclatoareSrv nomencaltoareSrv;
	//private StocuriSrv stocuriSrv;
	//private PersonalSrv personalSrv;
	
	//Dependente resurse proprii
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(VanzariImpl.class.getName());
	private RegistruVanzari registruVanzari;
	
	//Dependente resurse injectate
	@PersistenceContext(unitName="OpenERP_VANZARI")
	private EntityManager em;
	
	
	@Resource
	private SessionContext sessionContext;
	
	
	@EJB(lookup="java:global/OpenERP_STOCURI/StocuriImpl!org.open.erp.services.stocuri.StocuriSrvLocal")
	private StocuriSrvLocal stocuriSrv;
	
	
	//Initializare
	public VanzariImpl(){	}
	@PostConstruct
	public void init(){
		if(this.registruVanzari==null)
			registruVanzari=new RegistruVanzari(em);
	}
	
	
	
	//Implementare actiuni serviciu VanzariSRV
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	
	
	@Override
	public Comenzi creareComanda(Integer idComanda, Date data,
			List<ArticolComanda> articole) {
		logger.debug("II.1 Creare comanda");
		
		Comenzi creareComanda=new Comenzi(1, new Date(), articole);
		
		return creareComanda;
	}


	

	@Override
	public void setStocuri(StocuriSrv stocuriSrv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OfertePret creareOfertePret(Integer idOfertaPret, Produse produs,
			Date dataValabilitate, Date dataeminiteri, String observatii) {
			logger.debug("I.1 Creare oferta de pret");
	
			OfertePret ofertaPret= new OfertePret(1, produs, new Date(), new Date(), observatii);
	 
		return ofertaPret;
	}

	

	@Override
	public OfertePret getOfertaDePret(Integer idOfertaPret) {
		// TODO Auto-generated method stub
		return registruVanzari.getOfertaDePret(idOfertaPret);
	}
	
	
	
	@Override
	public List<OfertePret> getOferte() {
		List<OfertePret> oferte = registruVanzari.getToateOfertele();
		if (oferte.isEmpty())
			logger.debug("Returner 0 oferte!");
		else
			logger.debug("Returner " + oferte.size() + " oferte!");
		return oferte;
	}
	
	
	
	@Override
	public OfertePret salvareOferta(OfertePret oferta) throws Exception {
		if (oferta.getProdus()== null){
			//logger.debug(">>>>>>>>>>>> Selectare produs: " + nommatSrv);	
			
			logger.debug("Produsul pentru care se face oferta este: " + oferta.getProdus());			
		}
		
		/* Actiune tranzactionala ... */
		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Creare/salvare proiect - TRANZACTIE ANULATA");
		}else{
			oferta = this.registruVanzari.salveazaOferta(oferta);
			//em.persist(proiectNou);
		}
		
		logger.debug(">>>>>>>>>>>> END salvare oferta");
		return oferta;
	}
	
	
	
	@Override
	public Facturi creareFactura(Integer idFactura, Date data,
			Persoana responsabil, Avize aviz, Comenzi comanda,
			List<LiniiFactura> liniiFactura) {
		logger.debug("V.1 Creare factura");
		Facturi factura=new Facturi(1,new Date(), responsabil, aviz, comanda, liniiFactura);
		
		return factura;
	}

	@Override
	public Avize creareAviz(Integer idAviz, Date date, Persoana responsabil,
			Comenzi comanda, List<LiniiAviz> liniiAviz) {
		Avize aviz=new Avize(1, new Date(), responsabil, comanda, liniiAviz);
		return aviz;
	}

	@Override
	public DispozitiiLivrare creareDispozitieLivrare(
			Integer idDispozitieLivrare, Date data, Persoana responsabil,
			Comenzi comanda, List<LiniiDispozitieLivrare> liniiDispozitieLivrare) {
		logger.debug("III.1 Creare dispozitie livrare");
		DispozitiiLivrare dispozitie=new DispozitiiLivrare(1, new Date(), responsabil, comanda, liniiDispozitieLivrare);
		return dispozitie;
	}

	@Override
	public double getValoareFact(Integer id) {
		Double valoare = 0.0;
		Facturi factura = new Facturi();
		
		List<LiniiFactura> liniiFactura = factura.getLiniiFacturiByIdFactura(factura.getIdFactura());
		
		for (LiniiFactura linie: liniiFactura){
			
			valoare = valoare + linie.valoareLinieFactura();
		}
		
		return valoare;
	}

		
}
