package org.open.erp.services.productie;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.personal.Functie;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

	@ManyToOne (targetEntity=Document.class)
	@JoinColumn(name = "nrDocument", insertable=false, updatable=false)
	private Document idComanda;
	
	@ManyToOne (targetEntity=Produs.class)
	@JoinColumn (name="id")
	Produs produs;
	
	Integer cantitate;
	
	@Temporal(javax.persistence.TemporalType.DATE)
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
