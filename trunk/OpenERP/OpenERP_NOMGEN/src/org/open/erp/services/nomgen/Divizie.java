package org.open.erp.services.nomgen;


import javax.persistence.OneToMany;

public class Divizie extends Subdepartament {
String dataInfiintarii;
@OneToMany
Subdepartament parinte;

public String getDataInfiintarii() {
	return dataInfiintarii;
}

public Divizie() {
	super();
	// TODO Auto-generated constructor stub
}


public Subdepartament getParinte() {
	return parinte;
}

public void setParinte(Subdepartament parinte) {
	this.parinte = parinte;
}

public Divizie(String id, String denumire, String descriere,
		Departament parinte, String dataInfiintarii, Subdepartament parinte2) {
	super(id, denumire, descriere, parinte);
	this.dataInfiintarii = dataInfiintarii;
	parinte = parinte2;
}


	
}
