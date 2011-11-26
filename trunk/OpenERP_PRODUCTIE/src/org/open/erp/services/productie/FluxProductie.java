package org.open.erp.services.productie;

import java.util.ArrayList;

import org.open.erp.services.nomgen.Produs;

/**
 * 
 * @author Echipa Productie
 * 
 * @BusinessObject(Entity)
 */

public class FluxProductie {

	Produs produs;
	ArrayList <FazaProductie> faze;
	
	public FluxProductie(Produs produs, ArrayList<FazaProductie> faze) {
		super();
		this.produs = produs;
		this.faze = faze;
	}
	public FluxProductie() {
		super();
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
	
	
	
	public void setFaze(ArrayList<FazaProductie> faze) {
		this.faze = faze;
	}
	
	
	
}
