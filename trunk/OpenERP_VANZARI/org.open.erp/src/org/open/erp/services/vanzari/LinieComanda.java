package org.open.erp.services.vanzari;

import org.open.erp.services.exceptions.ValoareNegativa;
import org.open.erp.services.stocuri.ArticolStoc;

/*
 * @author Irina Bogdan
 * 
 * @BusinessObject(DummyEntity)
 */

public class LinieComanda {
	public static final Integer STOC_DISPONIBIL = 1;
	public static final Integer STOC_INDISPONIBIL = 0;
	
	// Integer nrComanda;
	// Intger nrLinie;
	String idProdus;
	String numeProdus;
	String idCategorie;
	String descriere;
	Float cantitate;
	Double pretUnitar;
	Float procentTva;
	Integer status;
	
	Float valoareReducere;
	Float procentReducere;
	//Float cantitateMinRedusa;
	
	public LinieComanda(){}
	
	public LinieComanda(String _idProdus, String _idCategorie, Float _cantitate){
		if( _idProdus != null) {
			this.idProdus = _idProdus;
			this.idCategorie = _idCategorie;
			this.cantitate = _cantitate;
		}
	}
	
	public void checkAndUpdateStatus(){
		// if req Q exists in ArticolStoc Q -> upadate status 
		Float cantDisponibila = ArticolStoc.getProductQuantityById(this.idProdus);
		if( cantDisponibila >= this.cantitate){
			this.status = LinieComanda.STOC_DISPONIBIL;
		} else {
			this.status = LinieComanda.STOC_INDISPONIBIL;
		}
	}
	
	// metoda comuna pr comanda / factura
	public void preluareReducere(){
		// find in product_reduction DB if any reduction is set to the current product
		Float valoareReducere = (float)0.0;
		Float procentReducere = (float)10;
		this.valoareReducere = valoareReducere;
		this.procentReducere = procentReducere;
	}
	
	public Double getPretRedus() throws ValoareNegativa{
		Double pretRedus = 0.0;
		if( this.procentReducere != 0){
			pretRedus = this.pretUnitar * (1 - 0.01 * this.procentReducere); 
		} else if(this.valoareReducere != 0){
			pretRedus = this.pretUnitar - this.valoareReducere;
		}
		// Exceptie: pretRedus negativa !!!!!!
		if( pretRedus < 0)
			throw new ValoareNegativa("Pret cu valoare nagativa");
		return pretRedus;
	}
	
	public Double getValoareLinie() throws ValoareNegativa{
		Double pretLinie = 0.0;
		if( this.getPretRedus() != 0)
			pretLinie = this.getPretRedus() * this.cantitate;
		else
			pretLinie = this.getPretUnitar() * this.cantitate;
		return pretLinie;
	}
	
	public Double getTvaLinie() throws ValoareNegativa{
		Double tvaLinie = 0.0;
		tvaLinie = this.getValoareLinie() * this.procentTva;
		return tvaLinie;
	}
	
	public Double getValoareRedusa() throws ValoareNegativa{
		Double valRedusa = 0.0;
		if( this.getPretRedus() != 0){
			valRedusa = (this.pretUnitar - this.getPretRedus()) * this.cantitate;
		}
		// Exceptie: valRedusa negativa !!!!!!
		if( valRedusa < 0)
			throw new ValoareNegativa("Valoare calculata negativa");
		return valRedusa; 
	}
		
	public boolean setCantitate(Float cantitate) {
		// verificare cantitate BD
		//  de la Stocuri !!!!!!!!!!!
		if( cantitate <= ArticolStoc.getProductQuantityById(this.idProdus)){
			this.cantitate = cantitate;
			return true;
		} else{
			this.cantitate = (float)0.0;
			return false;
		}
	}
	
	
	public String getIdProdus() {
		return idProdus;
	}
	public void setIdProdus(String idProdus) {
		this.idProdus = idProdus;
	}
	public String getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Float getCantitate() {
		return cantitate;
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

	public Float getProcentTva() {
		return procentTva;
	}

	public void setProcentTva(Float procentTva) {
		this.procentTva = procentTva;
	}

	public Float getValoareReducere() {
		return valoareReducere;
	}

	public void setValoareReducere(Float valoareReducere) {
		this.valoareReducere = valoareReducere;
	}

	public Float getProcentReducere() {
		return procentReducere;
	}

	public void setProcentReducere(Float procentReducere) {
		this.procentReducere = procentReducere;
	}
}
