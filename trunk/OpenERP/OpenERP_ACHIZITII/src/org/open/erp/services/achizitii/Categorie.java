package org.open.erp.services.achizitii;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */

@Entity
@Table(name="Categorii")
public class Categorie implements Serializable {

public long getId_cat() {
		return id_cat;
	}

	public void setId_cat(long id_cat) {
		this.id_cat = id_cat;
	}

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id_cat;
private String denumire;
@OneToMany(mappedBy = "categorieArticol", cascade = CascadeType.ALL,targetEntity=Furnizor.class)
private List<Furnizor> furnizoriCategorie=new ArrayList<Furnizor>();

@OneToMany(cascade = CascadeType.ALL, mappedBy = "categorieArticol")
private List<Articol> articole = new ArrayList<Articol>();

public void addFurnizor(Furnizor furn) {
    this.getFurnizoriCategorie().add(furn);   
}

public Categorie() {
	super();
}


public void removeFurnizor(Furnizor furn) {
    this.getFurnizoriCategorie().remove(furn);    
}
public void addArticol(Articol art) {
    this.getArticole().add(art);   
}

public void removeArticol(Articol art) {
    this.getArticole().remove(art);    
}

public List<Articol> getArticole() {
	return articole;
}

public void setArticole(List<Articol> articole) {
	this.articole = articole;
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

public Categorie(String denumire, List<Furnizor> furnizoriCategorie) {
	super();
	this.denumire = denumire;
	this.furnizoriCategorie = furnizoriCategorie;
}


}
