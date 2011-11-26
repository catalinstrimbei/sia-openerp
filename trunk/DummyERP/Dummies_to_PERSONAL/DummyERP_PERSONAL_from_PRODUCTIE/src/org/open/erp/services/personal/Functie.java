package org.open.erp.services.personal;

public class Functie {

	Integer id;
	String denumire;
	public Functie(Integer id, String denumire) {
		super();
		this.id = id;
		this.denumire = denumire;
	}
	public Functie() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	
	
}
