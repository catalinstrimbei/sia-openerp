package org.open.erp.services.productie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.open.erp.services.nommat.Produs;

public class FluxProductie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Integer idFlux;
	Produs produs;
	private List<FazaProductie> faze  = new ArrayList<FazaProductie>();
	
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
