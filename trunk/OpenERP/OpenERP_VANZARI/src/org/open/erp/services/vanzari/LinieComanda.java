package org.open.erp.services.vanzari;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.vanzari.exceptions.ValoareNegativa;

/**
 * @author Irina Bogdan
 * 
 * @BusinessObject(Entity)
 */

@Entity @IdClass(LinieComandaId.class)
public class LinieComanda implements Serializable {
	public static final Integer STOC_DISPONIBIL = 1;
	public static final Integer STOC_INDISPONIBIL = 0;
	
	@Id @GeneratedValue
	Integer nrComanda;
	@Id @GeneratedValue
	Integer nrLinie;
	@ManyToOne
	Produs produs;
	Double cantitate;
	Double pretLinie;
	Double tvaLinie;
	Integer status;

	
public LinieComanda(){
	produs = new Produs();
	
}
	
	public LinieComanda(Produs _produs, Double _cantitate){
		if( _produs != null) {
			this.produs = _produs;
			this.cantitate = _cantitate;
		}
	}
		
	public Double getValoareLinieFaraTVA() throws ValoareNegativa{
		return this.getProdus().getPretVanzare() * this.cantitate;
	}
	
	public Double getValoareLinieCuTVA() throws ValoareNegativa{
		return this.getValoareLinieFaraTVA() * (1 + this.getProdus().getProcentTVA());
	}
	
	public Double getTvaLinie() throws ValoareNegativa{
		Double tvaLinie = 0.0;
		tvaLinie = this.getValoareLinieFaraTVA() * this.getProdus().getProcentTVA();
		return tvaLinie;
	}
	
	public Integer getNrLinie() {
		return nrLinie;
	}

	public void setNrLinie(Integer nrLinie) {
		this.nrLinie = nrLinie;
	}

	public Double getPretLinie() {
		return pretLinie;
	}

	public void setPretLinie(Double pretLinie) {
		this.pretLinie = pretLinie;
	}

	public void setTvaLinie(Double tvaLinie) {
		this.tvaLinie = tvaLinie;
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

	public Produs getProdus() {
		return produs;
	}

	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	
}
