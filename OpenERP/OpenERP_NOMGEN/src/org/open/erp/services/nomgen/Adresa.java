package org.open.erp.services.nomgen;

public class Adresa {
String id;
String localitate;
String judet;
String tara;
String strada;
String codPostal;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getLocalitate() {
	return localitate;
}
public void setLocalitate(String localitate) {
	this.localitate = localitate;
}
public String getJudet() {
	return judet;
}
public void setJudet(String judet) {
	this.judet = judet;
}
public String getTara() {
	return tara;
}
public void setTara(String tara) {
	this.tara = tara;
}
public String getStrada() {
	return strada;
}
public void setStrada(String strada) {
	this.strada = strada;
}
public String getCodPostal() {
	return codPostal;
}
public void setCodPostal(String codPostal) {
	this.codPostal = codPostal;
}
public Adresa(String id, String localitate, String judet, String tara,
		String strada, String codPostal) {
	super();
	this.id = id;
	this.localitate = localitate;
	this.judet = judet;
	this.tara = tara;
	this.strada = strada;
	this.codPostal = codPostal;
}
public Adresa() {
	super();
}


}
