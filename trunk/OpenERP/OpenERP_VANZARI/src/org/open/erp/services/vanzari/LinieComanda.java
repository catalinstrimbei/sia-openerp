package org.open.erp.services.vanzari;

import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.vanzari.exceptions.ValoareNegativa;

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
	Produs produs;
	
	Double cantitate;
	//Double pretLinie;
	Integer status;
	
	Float valoareReducere;
	Float procentReducere;
	//Float cantitateMinRedusa;
	
public LinieComanda(){}
	
	public LinieComanda(Produs _produs, Double _cantitate){
		if( _produs != null) {
			this.produs = _produs;
			this.cantitate = _cantitate;
		}
	}
	
	/*// metoda comuna pr comanda / factura
	public void preluareReducere(){
		// find in product_reduction DB if any reduction is set to the current product
		Float valoareReducere = (float)0.0;
		Float procentReducere = (float)10;
		this.valoareReducere = valoareReducere;
		this.procentReducere = procentReducere;
	}*/
	
	public Double getPretRedusFaraTVA() throws ValoareNegativa{
		Double pretRedus = 0.0;
		if( this.getProcentReducere() != 0){
			pretRedus = this.getProdus().getPretVanzare() * (1 - 0.01 * this.getProcentReducere()); 
		} else if(this.getValoareReducere() != 0){
			pretRedus = this.getProdus().getPretVanzare() - this.getValoareReducere();
		}
		// Exceptie: pretRedus negativa
		if( pretRedus < 0)
			throw new ValoareNegativa("Pret cu valoare nagativa");
		return pretRedus;
	}
	
	public Double getValoareLinieFaraTVA() throws ValoareNegativa{
		Double pretLinie = 0.0;
		if( this.getPretRedusFaraTVA() != 0)
			pretLinie = this.getPretRedusFaraTVA() * this.cantitate;
		else
			pretLinie = this.getProdus().getPretVanzare() * this.cantitate;
		return pretLinie;
	}
	
	public Double getValoareLinieCuTVA() throws ValoareNegativa{
		return this.getValoareLinieFaraTVA() * (1 + this.getProdus().getProcentTVA());
	}
	
	public Double getTvaLinie() throws ValoareNegativa{
		Double tvaLinie = 0.0;
		tvaLinie = this.getValoareLinieFaraTVA() * this.getProdus().getProcentTVA();
		return tvaLinie;
	}
	
	public Double getValoareRedusa() throws ValoareNegativa{
		Double valRedusa = 0.0;
		if( this.getPretRedusFaraTVA() != 0){
			valRedusa = (this.getProdus().getPretVanzare() - this.getPretRedusFaraTVA()) * this.cantitate;
		}
		// Exceptie: valRedusa negativa
		if( valRedusa < 0)
			throw new ValoareNegativa("Valoare calculata negativa");
		return valRedusa; 
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Double getCantitate() {
		return cantitate;
	}

	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
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

	public Produs getProdus() {
		return produs;
	}

	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	
}
