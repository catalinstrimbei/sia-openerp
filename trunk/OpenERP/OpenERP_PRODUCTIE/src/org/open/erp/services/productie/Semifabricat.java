package org.open.erp.services.productie;

import java.util.*;

import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.Produs;

/**
 * 
 * @author Echipa Productie
 * 
 * @BusinessObject(Entity)
 */

public class Semifabricat extends Produs{

	
	String semifabricat;
	ArrayList <Material> listaMateriale;
	Semifabricat semifabricatContinut;
	
	public Semifabricat(String semifabricat,
			ArrayList<Material> listaMateriale,
			Semifabricat semifabricatContinut) {
		super();
		this.semifabricat = semifabricat;
		this.listaMateriale = listaMateriale;
		this.semifabricatContinut = semifabricatContinut;
	}
	public Semifabricat() {
		super();
	}
	public String getSemifabricat() {
		return semifabricat;
	}
	public void setSemifabricat(String semifabricat) {
		this.semifabricat = semifabricat;
	}
	public ArrayList<Material> getListaMateriale() {
		return listaMateriale;
	}
	public void setListaMateriale(ArrayList<Material> listaMateriale) {
		this.listaMateriale = listaMateriale;
	}
	public Semifabricat getSemifabricatContinut() {
		return semifabricatContinut;
	}
	public void setSemifabricatContinut(Semifabricat semifabricatContinut) {
		this.semifabricatContinut = semifabricatContinut;
	}
	
	
	
	
}
