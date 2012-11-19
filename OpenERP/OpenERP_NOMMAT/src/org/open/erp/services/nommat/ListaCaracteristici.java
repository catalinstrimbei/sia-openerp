package org.open.erp.services.nommat;

public class ListaCaracteristici {
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
