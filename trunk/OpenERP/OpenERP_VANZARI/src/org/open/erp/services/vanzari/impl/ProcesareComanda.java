package org.open.erp.services.vanzari.impl;

/**
 * @author Irina Bogdan
 * 
 * @BusinessObject(Service)
 *  
 */

import java.util.Date;
import javax.ejb.EJB;
import javax.persistence.EntityManager;

import java.util.Iterator;

//import org.open.erp.services.marketing.MarketingManagementSrv;
import org.open.erp.services.marketing.MarketingManagementSrvLocal;
import org.open.erp.services.marketing.impl.MarketingManagementImpl;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.productie.ComandaProductie;
//import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.ProductieSrvLocal;
import org.open.erp.services.productie.impl.ProductieImpl;
//import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.StocuriSrvLocal;
import org.open.erp.services.vanzari.Comanda;
import org.open.erp.services.vanzari.LinieComanda;
import org.open.erp.services.vanzari.exceptions.ValoareNegativa;
import org.open.erp.services.stocuri.impl.StocuriImpl;

public class ProcesareComanda {

	@EJB(mappedName="StocuriImpl/local")
	public StocuriSrvLocal stocuriSrv = new StocuriImpl();
	@EJB(mappedName="MarketingManagementImpl/local")
	public MarketingManagementSrvLocal mkSrv = new MarketingManagementImpl();
	@EJB(mappedName="ProductieImpl/local")
	public ProductieSrvLocal prodSrv = new ProductieImpl();
	
	//private EntityManager em;
	//private RegistruVanzari registruVanzari;
	
	public Comanda comanda;
	
	public ProcesareComanda(){} 
	
	/*public ProcesareComanda(EntityManager em){
		this.em = em;
	}
	
	public ProcesareComanda(EntityManager em, RegistruVanzari reg){
		this.em = em;
		this.registruVanzari = reg;
	}*/
	
	public LinieComanda gasesteProdusComandat(Produs produs){
		LinieComanda produsComandat = new LinieComanda();
		if( !comanda.getProduseComandate().isEmpty()){
			Iterator<LinieComanda> iterator = comanda.getProduseComandate().iterator();
			while(produsComandat.getProdus().getDenumire() == null && iterator.hasNext()){
				LinieComanda linie = iterator.next();
				if( linie.getProdus().equals(produs)){
					produsComandat = linie;
				}
			}
		}
		//System.out.println(produsComandat.toString());
		return produsComandat;
	}
	
	// Adauga produs nou sau incrementeaza cantitatea daca deja exista
	public boolean addProdusInComanda(Produs produs, Double cantitate){
		if( !this.checkDisponibilitateProdus(produs, cantitate)){
			return false;
		} else {
			LinieComanda produsComandat = this.gasesteProdusComandat(produs);
			if( produsComandat.getProdus().getDenumire() == null){
				boolean rez = false;
				try{
						Double pretFinal = this.getPretProdusFinal(produs);
						produs.setPretVanzare(pretFinal);
						LinieComanda linie = new LinieComanda(produs, cantitate);
						//linie.setProdus(produs)
						rez = comanda.getProduseComandate().add(linie);
					}catch(ValoareNegativa val){
						// logger
					}
				return rez;
			}
			else{
				//System.out.println("cantitate modif");
				double cant_ = produsComandat.getCantitate() + cantitate;
				//System.out.println(cant_);
				produsComandat.setCantitate(cant_);
				return true;
			}
		}
	}

	public boolean removeProdusDinComanda(Produs produs){
		LinieComanda produsComandat = this.gasesteProdusComandat(produs);
		if( produsComandat == null)
			return false;
		else
			return comanda.getProduseComandate().remove(produsComandat);
	}
	
	// update produs din comanda
	 public boolean updateProdusDinComanda(Produs produs, Double cantitate){
		 return this.addProdusInComanda(produs, cantitate);
	}
	
	// produsul se afla sau nu in stoc
	public boolean checkDisponibilitateProdus(Produs produs, Double cantitate){
		// conversie Produs catre Material
		Double cantDisponibila = stocuriSrv.verificareStocMaterial(produs);
		if( cantDisponibila >= cantitate)
			return true;
		else{
			// lansare Comanda daca prod nu e in stoc 
			try{
				//DummyProdus dummyProd = new DummyProdus(produs.getId(), produs.getDenumire(), produs.getUM(), new Date(), produs.getTermenValabilitate());
				ComandaProductie comprod = new ComandaProductie(1, produs, cantitate.intValue(), new Date());
				prodSrv.lansareComandaProductie(comprod, produs);
			} catch(Exception ex){
				
			}
			return false;
		}
	}
	
	public Double getPretProdusFinal(Produs produs) throws ValoareNegativa{
		Double pretFinal = 0.0;
		//pretFinal = (double) mkSrv.getPretFinalByProdus(produs);
		org.open.erp.services.marketing.DummyProdus dummyProd = new org.open.erp.services.marketing.DummyProdus(produs.getIdMaterial(), produs.getDenumire(), produs.getUM(), new Date(), produs.getTermenValabilitate());
		//pretFinal = mkSrv.getPretFinalByProdus(dummyProd);
		mkSrv.getPretFinalByProdus(dummyProd);
		if( pretFinal <= 0)
			throw new ValoareNegativa();
		return pretFinal;
	}	
	
	public Double getValoareLinieFaraTVA(Produs produs, Double cantitate) throws ValoareNegativa{
		return getPretProdusFinal(produs) * cantitate;
	}
	
	public Double getValoareLinieCuTVA(Produs produs, Double cantitate) throws ValoareNegativa{
		return getValoareLinieFaraTVA(produs, cantitate) * (1 + 0.21);
	}
	
	public Double getTvaLinie(Produs produs, Double cantitate) throws ValoareNegativa{
		return getValoareLinieFaraTVA(produs, cantitate) * 0.21;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}
}
