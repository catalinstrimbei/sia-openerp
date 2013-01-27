package org.open.erp.services.nomgen;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Persoana implements Serializable{
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
