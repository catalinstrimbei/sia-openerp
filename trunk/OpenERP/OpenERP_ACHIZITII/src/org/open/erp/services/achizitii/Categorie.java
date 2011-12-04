package org.open.erp.services.achizitii;
import java.util.ArrayList;
import java.util.List;

public class Categorie {
private String id;
private String denumire;
private List<Furnizor> furnizoriCategorie=new ArrayList<Furnizor>();
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
public List<Furnizor> getFurnizoriCategorie() {
	return furnizoriCategorie;
}
public void setFurnizoriCategorie(List<Furnizor> furnizoriCategorie) {
	this.furnizoriCategorie = furnizoriCategorie;
}
public Categorie(String id, String denumire) {
	super();
	this.id = id;
	this.denumire = denumire;
}
public Categorie(String id, String denumire, List<Furnizor> furnizoriCategorie) {
	super();
	this.id = id;
	this.denumire = denumire;
	this.furnizoriCategorie = furnizoriCategorie;
}


}
