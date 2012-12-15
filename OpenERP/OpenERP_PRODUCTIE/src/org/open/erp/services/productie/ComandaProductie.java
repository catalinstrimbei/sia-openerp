package org.open.erp.services.productie;

import java.io.Serializable;
import java.util.Date;

import org.open.erp.services.nomgen.Document;


public class ComandaProductie extends Document implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Document idComanda;
	Produs produs;
	Integer cantitate;
	Date dataComanda;
	
	public ComandaProductie(Produs produs,
			Integer cantitate, Date dataComanda) {
		super();
		this.produs = produs;
		this.cantitate = cantitate;
		this.dataComanda = dataComanda;
	}
	public ComandaProductie() {
		super();
	}
	public Document getIdComanda() {
		return idComanda;
	}
	public void setIdComanda(Document idComanda) {
		this.idComanda = idComanda;
	}
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public Integer getCantitate() {
		return cantitate;
	}
	public void setCantitate(Integer cantitate) {
		this.cantitate = cantitate;
	}
	public Date getDataComanda() {
		return dataComanda;
	}
	public void setDataComanda(Date dataComanda) {
		this.dataComanda = dataComanda;
	}
}
