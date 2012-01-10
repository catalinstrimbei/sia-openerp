package org.open.erp.services.productie;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.Produs;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 * 
 * @author Echipa Productie
 * 
 * @BusinessObject(Entity)
 */
@Entity

public class ComandaProductie extends Document implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	
	Integer idComanda;
	
	@ManyToMany (targetEntity=DummyProdus.class)
	
	DummyProdus produs;
	
	Integer cantitate;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	Date dataComanda;
	
	
	public ComandaProductie(Integer idComanda, DummyProdus produs,
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
	public DummyProdus getProdus() {
		return produs;
	}
	public void setProdus(DummyProdus produs) {
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
