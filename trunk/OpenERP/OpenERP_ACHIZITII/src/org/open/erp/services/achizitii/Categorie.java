package org.open.erp.services.achizitii;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;
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
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
	 * 
	 */
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String cat;
private String denumire;
@OneToMany(mappedBy = "categorieArticol", cascade = CascadeType.ALL)
private List<Furnizor> furnizoriCategorie=new ArrayList<Furnizor>();

@OneToMany(mappedBy = "categorieArticol", cascade = CascadeType.ALL)
private List<Articol> articole = new ArrayList<Articol>();

public void addFurnizor(Furnizor furn) {
    this.getFurnizoriCategorie().add(furn);   
}

public Categorie() {
	super();
}

public String getCat() {
	return cat;
}

public void setCat(String cat) {
	this.cat = cat;
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
public Long getId() {
	return id;
}
public void setId(Long id) {
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
