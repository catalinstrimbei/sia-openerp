package org.open.erp.services.achizitii;
import java.util.ArrayList;
import java.util.List;

import org.open.erp.services.nomgen.LinieDocument;
/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Categorie {
private Integer id;
private String denumire;
private List<Furnizor> furnizoriCategorie=new ArrayList<Furnizor>();


public void addFurnizor(Furnizor furn) {
    this.getFurnizoriCategorie().add(furn);   
}

public void removeFurnizor(Furnizor furn) {
    this.getFurnizoriCategorie().remove(furn);    
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
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Categorie(String denumire, List<Furnizor> furnizoriCategorie) {
	super();
	this.denumire = denumire;
	this.furnizoriCategorie = furnizoriCategorie;
}
public Categorie(Integer id, String denumire, List<Furnizor> furnizoriCategorie) {
	super();
	this.id = id;
	this.denumire = denumire;
	this.furnizoriCategorie = furnizoriCategorie;
}

public Categorie(Integer id, String denumire) {
	super();
	this.id = id;
	this.denumire = denumire;
}


}
