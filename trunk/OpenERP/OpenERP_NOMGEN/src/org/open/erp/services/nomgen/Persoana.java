package org.open.erp.services.nomgen;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Persoana {
	@Id @GeneratedValue
 Integer id;
 String nume;
 

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNume() {
	return nume;
}
public void setNume(String nume) {
	this.nume = nume;
}


public Persoana(Integer id, String nume) {
	super();
	this.id = id;
	this.nume = nume;

}

public Persoana() {
	super();
}


}
