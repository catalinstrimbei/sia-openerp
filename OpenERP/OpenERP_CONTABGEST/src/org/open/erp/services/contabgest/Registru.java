package org.open.erp.services.contabgest;

import java.util.ArrayList;

public class Registru {

	private int id;
	private ArrayList<CalculCost> lista=new ArrayList<CalculCost>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<CalculCost> getLista() {
		return lista;
	}
	public void setLista(ArrayList<CalculCost> lista) {
		this.lista = lista;
	} 
			
}
