package org.open.erp.services.achizitii;

import org.open.erp.services.nomgen.PersoanaJuridica;

public class Furnizori extends PersoanaJuridica{
	
	private String denumire;
	private String persoanaContact;
	
	
	public Furnizori() {
		super();
	}


	public Furnizori(String denumire, String persoanaContact) {
		super();
		this.denumire = denumire;
		this.persoanaContact = persoanaContact;
	}


	public String getDenumire() {
		return denumire;
	}


	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}


	public String getPersoanaContact() {
		return persoanaContact;
	}


	public void setPersoanaContact(String persoanaContact) {
		this.persoanaContact = persoanaContact;
	}
	
	
}
