package org.open.erp.services.nommat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UnitateDeMasura {
@Id @GeneratedValue
String id;
String unitateDeMasura;

public UnitateDeMasura(String id, String unitateDeMasura) {
	super();
	this.id = id;
	this.unitateDeMasura = unitateDeMasura;
	
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUnitateDeMasura() {
	return unitateDeMasura;
}
public void setUnitateDeMasura(String unitateDeMasura) {
	this.unitateDeMasura = unitateDeMasura;
}
public UnitateDeMasura() {
	super();
}


}
