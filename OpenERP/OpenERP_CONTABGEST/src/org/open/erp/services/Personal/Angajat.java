package org.open.erp.services.Personal;

import org.open.erp.services.Salarizare.SalarizareStatPlata;

public class Angajat {

	private String nume;
	
	
	public Angajat(String nume)
	{
		this.setNume(nume);
		
	}


	public String getNume() {
		return nume;
	}


	public void setNume(String nume) {
		this.nume = nume;
	}
	
}
