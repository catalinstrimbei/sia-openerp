package org.open.erp.services.productie;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.open.erp.services.nommat.Material;


@Entity
public class FluxProductie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	Integer idFlux;
	
	@ManyToOne (targetEntity=Produs.class)
	@JoinColumn(name="id")
	Produs produs;
	
	@OneToMany(mappedBy="flux",targetEntity=FazaProductie.class, cascade = ALL, fetch = EAGER)
	private List<FazaProductie> faze  = new ArrayList<FazaProductie>();
	
	@OneToOne
	FazaProductie faza;
	
	
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
	
	
	public void adaugaFaza(FazaProductie faza){
		this.faza=faza;
	}
	
	public List<FazaProductie> getFaze() {
		faze.add(faza);
		return this.faze;
	}
	
	
}
