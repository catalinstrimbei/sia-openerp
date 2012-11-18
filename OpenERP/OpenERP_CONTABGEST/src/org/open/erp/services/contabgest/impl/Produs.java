package org.open.erp.services.contabgest.impl;

import java.util.ArrayList;

public class Produs {
	
	private int idProdus;
	private String denumire;
	private String unitateMasura;      //in ce se masoara produsul respectiv(ex: Kg, bucati, litri)

	public ArrayList <Activitate> stagiiProductie = new ArrayList<Activitate>();

	public Produs(int id, String denumire,String unitateMasura,ArrayList<Activitate> stagii)
	{
		this.idProdus=id;
		this.denumire=denumire;
		this.unitateMasura=unitateMasura;
		this.stagiiProductie=stagii;
		
	}
	public ArrayList<Activitate> getStagiiProductie() {
		return stagiiProductie;
	}
	public void setStagiiProductie(ArrayList<Activitate> stagiiProductie) {
		this.stagiiProductie = stagiiProductie;
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

	public String getUnitateMasura() {
		return unitateMasura;
	}

	public void setUnitateMasura(String unitateMasura) {
		this.unitateMasura = unitateMasura;
	}
	
	

}
