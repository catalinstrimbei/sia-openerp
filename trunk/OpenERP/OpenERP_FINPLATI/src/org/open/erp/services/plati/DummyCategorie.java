package org.open.erp.services.plati;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.Table;
/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */

@Entity
public class DummyCategorie implements Serializable {



private static final long serialVersionUID = 4766008004517409356L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id_cat_generat;
private long id_cat;
private String denumire;
@OneToMany(mappedBy = "categorieArticol", cascade = CascadeType.ALL,targetEntity=DummyFurnizor.class)
private Collection<DummyFurnizor> furnizoriCategorie = new ArrayList<DummyFurnizor>();

@OneToMany(cascade = CascadeType.ALL, mappedBy = "categorieArticol")
private List<DummyArticol> articole = new ArrayList<DummyArticol>();
/**
 * 
 * @param furn
 */
public void addFurnizor(DummyFurnizor furn) {
    this.getFurnizoriCategorie().add(furn);   
}

public DummyCategorie() {
	super();
}
public long getId_cat() {
	return id_cat;
}

public void setId_cat(long id_cat) {
	this.id_cat = id_cat;
}

public void removeFurnizor(DummyFurnizor furn) {
    this.getFurnizoriCategorie().remove(furn);    
}
public void addArticol(DummyArticol art) {
    this.getArticole().add(art);   
}

public void removeArticol(DummyArticol art) {
    this.getArticole().remove(art);    
}

public List<DummyArticol> getArticole() {
	return articole;
}

public void setArticole(List<DummyArticol> articole) {
	this.articole = articole;
}

public String getDenumire() {
	return denumire;
}
public void setDenumire(String denumire) {
	this.denumire = denumire;
}
public Collection<DummyFurnizor> getFurnizoriCategorie() {
	return furnizoriCategorie;
}
public void setFurnizoriCategorie(List<DummyFurnizor> furnizoriCategorie) {
	this.furnizoriCategorie = furnizoriCategorie;
}

public DummyCategorie(String denumire, List<DummyFurnizor> furnizoriCategorie) {
	super();
	this.denumire = denumire;
	this.furnizoriCategorie = furnizoriCategorie;
}

public DummyCategorie(long id_cat, String denumire) {
	super();
	this.id_cat = id_cat;
	this.denumire = denumire;
}


}
