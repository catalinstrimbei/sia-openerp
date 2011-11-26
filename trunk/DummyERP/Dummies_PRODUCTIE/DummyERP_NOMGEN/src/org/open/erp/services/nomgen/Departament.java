package org.open.erp.services.nomgen;

public class Departament {

	Integer id;
	String denumire;

	public Departament(Integer id, String denumire) {
		super();
		this.id = id;
		this.denumire = denumire;
		
	}
	public Departament() {
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
