package org.open.erp.services.contabgest.impl;

public  class CalculCost {

	private int id;
	private Produs produs;
	
	public  double costFinal() //returneaza costul final al produsului
	{
		return 10;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produs getProdus() {
		return produs;
	}

	public void setProdus(Produs produs) {
		this.produs = produs;
	}
}
