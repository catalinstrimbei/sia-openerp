package org.open.erp.services.contabgest;

import java.util.ArrayList;

public  class Registru {

	private int id;
	private static ArrayList<CalculCost> lista=new ArrayList<CalculCost>();
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
	
	public static void addLista(CalculCost c)
	{
		Registru.lista.add(c);
	}
	
	//costuriTotale useCase 4
	public double calculeazaCost()
	{
		double s=0;
		for (int i = 0; i < lista.size(); i++)
			s=s+this.lista.get(i).costFinal();
		return s;
	}
}
			
