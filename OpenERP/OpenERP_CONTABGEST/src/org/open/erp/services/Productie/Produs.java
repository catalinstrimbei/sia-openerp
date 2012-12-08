package org.open.erp.services.Productie;

import java.util.ArrayList;



public class Produs {
	
	private int idProdus;
	private String denumire;
	private Reteta reteta;
	
	public Produs(int id, String denumire,Reteta reteta)
	{
		this.idProdus=id;
		this.denumire=denumire;
		this.reteta=reteta;
		
	}
	public Produs(int id, String denumire)
	{
		this.idProdus=id;
		this.denumire=denumire;
		
	}
	
	public int getIdProdus() {
		return idProdus;
	}

	public void setIdProdus(int idProdus) {
		this.idProdus = idProdus;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public Reteta getReteta() {
		return reteta;
	}

	public void setReteta(Reteta reteta) {
		this.reteta = reteta;
	}


	

}
