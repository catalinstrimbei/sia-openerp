package org.open.erp.services.nomgen;

public class Material {

	Integer Id;
	String Denumire;
	public Material(Integer id, String denumire) {
		super();
		Id = id;
		Denumire = denumire;
	}
	public Material() {
		super();
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getDenumire() {
		return Denumire;
	}
	public void setDenumire(String denumire) {
		Denumire = denumire;
	}
	
	
	
}
