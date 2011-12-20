package org.open.erp.services.productie;

import org.open.erp.services.nomgen.Produs;

import java.util.*;

/**
 * 
 * @author Echipa Productie
 * 
 * @BusinessObject(Entity)
 */

public class ComandaProductie {

	Integer idComanda;
	Produs produs;
	Integer cantitate;
	Date dataComanda;
	
	
	public ComandaProductie(Integer idComanda, Produs produs,
			Integer cantitate, Date dataComanda) {
		super();
		this.idComanda = idComanda;
		this.produs = produs;
		this.cantitate = cantitate;
		this.dataComanda = dataComanda;
	}
	public ComandaProductie() {
		super();
	}
	public Integer getIdComanda() {
		return idComanda;
	}
	public void setIdComanda(Integer idComanda) {
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
