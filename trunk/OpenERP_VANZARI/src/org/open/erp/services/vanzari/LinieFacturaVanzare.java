package org.open.erp.services.vanzari;

import org.open.erp.services.exceptions.ValoareNegativa;
import org.open.erp.services.stocuri.ArticolStoc;

/*
 * @author Irina Bogdan
 * 
 * @BusinessObject(DummyEntity)
 */

public class LinieFacturaVanzare {
	// Integer idFactura;
	Integer idLinieFactura;
	String idProdus;
	String numeProdus;
	Double pretUnitar;
	Double pretLinie;
	Float cantitateFacturata;
	String unitateMasura;
	Double tvaLinie;
	Double cotaTva;
	
	public LinieFacturaVanzare(){}
	
	public LinieFacturaVanzare(String _idProdus, Float _cant){
		this.idProdus = _idProdus;
		this.cantitateFacturata = _cant;
	}
	
	/* <- de la Stocuri
	public void preluareProprietati(){
		// prealua proprietati din BD
		System.out.println(this.idProdus);
		this.numeProdus = "Lapte batut";
		this.pretUnitar = (double)10;
		this.unitateMasura = "buc";
		this.cotaTva = 0.24;
	} */
	
	public void stabilirePret() throws ValoareNegativa{
		// find in product_reduction DB if any reduction is set to the current product
		Float valoareReducere = (float)0.0;
		Float procentReducere = (float)10;
		// -- till now same as LinieComanda.preluareReducere
		
		// !!!!!!!!!!!!!!!!!! 
		pretUnitar = ArticolStoc.getProductPriceById(this.idProdus);
				
		Double pret = 0.0;
		if( procentReducere != 0){
			pret = pretUnitar * (1 - 0.01 * procentReducere); 
		} else if(valoareReducere != 0){
			pret = pretUnitar - valoareReducere;
		} else
			pret = pretUnitar;
		// Exceptie: pret negativa 
		if( pret < 0)
			throw new ValoareNegativa("Valoare pret negativa");
		this.pretUnitar = pret;
	}
	
	public void calculeazaPretLinie(){
		Double pretLinie = this.pretUnitar * this.cantitateFacturata;
		this.pretLinie = pretLinie;		
	}
	
	public void calculeazaTvaLinie(){
		Double tva = this.pretUnitar * this.cantitateFacturata * this.cotaTva;
		this.tvaLinie = tva;
	}
	
	public Integer getIdLinieFactura() {
		return idLinieFactura;
	}
	public void setIdLinieFactura(Integer idLinieFactura) {
		this.idLinieFactura = idLinieFactura;
	}
	public String getIdProdus() {
		return idProdus;
	}
	public void setIdProdus(String idProdus) {
		this.idProdus = idProdus;
	}
	public String getNumeProdus() {
		return numeProdus;
	}
	public void setNumeProdus(String numeProdus) {
		this.numeProdus = numeProdus;
	}
	
	public Double getPretUnitar() {
		return pretUnitar;
	}

	public void setPretUnitar(Double pretUnitar) {
		this.pretUnitar = pretUnitar;
	}

	public Double getPretLinie() {
		return pretLinie;
	}

	public void setPretLinie(Double pretLinie) {
		this.pretLinie = pretLinie;
	}

	public Float getCantitateFacturata() {
		return cantitateFacturata;
	}
	public void setCantitateFacturata(Float cantitateFacturata) {
		this.cantitateFacturata = cantitateFacturata;
	}
	public Double getTvaLinie() {
		return tvaLinie;
	}
	public void setTvaLinie(Double tvaLinie) {
		this.tvaLinie = tvaLinie;
	}

	public Double getCotaTva() {
		return cotaTva;
	}

	public void setCotaTva(Double cotaTva) {
		this.cotaTva = cotaTva;
	}
	
}
