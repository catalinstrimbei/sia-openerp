package org.open.erp.services.nomgen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Departament {
	@Id @GeneratedValue
String id;
String denumire;


public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getDenumire() {
	return denumire;
}
public void setDenumire(String denumire) {
	this.denumire = denumire;
}

public Departament(String id, String denumire) {
	super();
	this.id = id;
	this.denumire = denumire;
	
}
public Departament() {
	super();
}


}
