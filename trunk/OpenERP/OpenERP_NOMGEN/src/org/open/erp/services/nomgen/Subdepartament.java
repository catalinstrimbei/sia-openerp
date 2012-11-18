package org.open.erp.services.nomgen;

public class Subdepartament extends Departament {
	String descriere;
	Departament parinte;

	public String getDescriere() {
		return descriere;
	}

	public Departament getParinte() {
		return parinte;
	}

	public void setParinte(Departament parinte) {
		this.parinte = parinte;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	 public Subdepartament(String id, String denumire, String descriere,
			Departament parinte) {
		super(id, denumire);
		this.descriere = descriere;
		this.parinte = parinte;
	}

	public Subdepartament() {
		// TODO Auto-generated constructor stub
	}
	

}
