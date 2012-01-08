package org.open.erp.services.productie;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.open.erp.services.nomgen.Produs;

/**
 * 
 * @author Echipa Productie
 * 
 * @BusinessObject(Entity)
 */
@Entity
public class FluxProductie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	Integer idFlux;
	
	@ManyToOne
	Produs produs;
	
	@OneToMany (mappedBy="FazaProductie", targetEntity= FazaProductie.class, cascade= CascadeType.ALL)
	ArrayList <FazaProductie> faze;
	
	public FluxProductie(Integer idFlux, Produs produs) {
		super();
		this.produs = produs;
		
		this.idFlux=idFlux;
	}
	public FluxProductie() {
		super();
	}
	
	public Integer getIdFlux() {
		return idFlux;
	}
	public void setIdFlux(Integer idFlux) {
		this.idFlux = idFlux;
	}
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public ArrayList<FazaProductie> getFaze() {
		return this.faze;
	}
	
	public void adaugaFaza(FazaProductie faza){
		this.faze.add(faza);
	}
	
	
	
	
	
}
