package org.open.erp.services.nommat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ListaCaracteristici {
@Id @GeneratedValue
String id;
String listaCaracteristici;

public ListaCaracteristici(String id, String listaCaracteristici) {
	super();
	this.id = id;
	this.listaCaracteristici = listaCaracteristici;
	
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getListaCaracteristici() {
	return listaCaracteristici;
}

public void setListaCaracteristici(String listaCaracteristici) {
	this.listaCaracteristici = listaCaracteristici;
}

public ListaCaracteristici() {
	super();
}


}
