package org.open.erp.services.vanzari.impl;

/**
 * @author Irina Bogdan
 * 
 *  @BusinessObject(Service)
 *  
 */

import javax.ejb.EJB;
import javax.persistence.EntityManager;

import org.open.erp.services.nomgen.Produs;
//import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.StocuriSrvLocal;
import org.open.erp.services.stocuri.impl.StocuriImpl;
import org.open.erp.services.vanzari.LinieFacturaEmisa;
import org.open.erp.services.vanzari.exceptions.ValoareNegativa;

public class ProcesareFacturaEmisa {

	@EJB(mappedName="StocuriImpl/local")
	public StocuriSrvLocal stocuriSrv = new StocuriImpl();
	
	//private EntityManager em;
	//private RegistruVanzari registruVanzari;

	private LinieFacturaEmisa linie;
	
	public ProcesareFacturaEmisa(){}
	
	/*public ProcesareFacturaEmisa(EntityManager em){
		this.em = em;
	}
	
	public ProcesareFacturaEmisa(EntityManager em, RegistruVanzari reg){
		this.em = em;
		this.registruVanzari = reg;
	}*/
	
	public Double stabilirePret() throws ValoareNegativa{
		Double pret = 0.0;
		Double pretUnitar = 0.0; 
		
		// preluare de la Mk
		Double valoareReducere = 0.0;
		Double procentReducere = 10.0;
		
		Produs produs = (Produs) linie.getMaterial();
		pretUnitar = produs.getPretVanzare();
		//pretUnitar = linie.getProdus().getPretVanzare();
		
		if( procentReducere != 0.0){
			pret = pretUnitar * (1 - 0.01 * procentReducere); 
		} else if(valoareReducere != 0.0){
			pret = pretUnitar - valoareReducere;
		} else
			pret = pretUnitar;
		// Exceptie: pret negativa 
		if( pret < 0)
			throw new ValoareNegativa("Valoare pret negativa");
		//this.pretUnitar = pret;
		return pret;
	}
	
	public void calculeazaPretLinie() throws ValoareNegativa{ // fara TVA
		Double pretLinie = this.stabilirePret() * linie.getCantitate();  
		linie.setPretLinie(pretLinie);		
	}
	
	public void calculeazaTvaLinie() throws ValoareNegativa{
		Produs produs = (Produs) linie.getMaterial();
		Float procTVA = produs.getProcentTVA(); 
		
		Double tva = this.stabilirePret() * linie.getCantitate() * procTVA;
		linie.setTVA(tva);
	}
	
	/*public boolean addProdusInFactura(Produs produs, Double cantitate){
		if( !this.checkDisponibilitateProdus(produs, cantitate))
			return false;
		else {
			LinieFacturaEmisa linie = new LinieFacturaEmisa(produs, cantitate);
			return factura.getProduseFacturate().add(linie);
		}
	}*/
	
	// produsul se afla sau nu in stoc
	public boolean checkDisponibilitateProdus(Produs produs, Double cantitate){
		// conversie Produs catre Material
		Double cantDisponibila = stocuriSrv.verificareStocMaterial(produs);
		if( cantDisponibila <= cantitate)
			return true;
		else
			return false;
	}

	public LinieFacturaEmisa getLinie() {
		return linie;
	}

	public void setLinie(LinieFacturaEmisa linie) {
		this.linie = linie;
	}	
	
}
