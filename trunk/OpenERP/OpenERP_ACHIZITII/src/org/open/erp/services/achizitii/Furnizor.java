package org.open.erp.services.achizitii;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity

public class Furnizor implements Serializable {


/**
	 * 
	 */
	private static final long serialVersionUID = 2019369183120390764L;
	@Id@GeneratedValue
	private int idFurnizor;
@OneToMany(mappedBy="furnizor")
private List<Factura> facturiFurnizor=new ArrayList<Factura>();
private Integer cont;
private String CUI;
private String denumire;
private String telefon;
private String adresa;

@ManyToOne@JoinColumn(name="id_cat")
private Categorie categorieArticol;



public List<Factura> getFacturiFurnizor() {
	return facturiFurnizor;
}

public void setFacturiFurnizor(List<Factura> facturiFurnizor) {
	this.facturiFurnizor = facturiFurnizor;
}
public Integer getCont() {
	return cont;
}



public Categorie getCategorieArticol() {
	return categorieArticol;
}

public void setCategorieArticol(Categorie categorieArticol) {
	this.categorieArticol = categorieArticol;
}


public Furnizor() {
	super();
}
public void setCont(Integer cont) {
	this.cont = cont;
}


public String getCUI() {
	return CUI;
}

public void setCUI(String cUI) {
	CUI = cUI;
}

public String getDenumire() {
	return denumire;
}

public void setDenumire(String denumire) {
	this.denumire = denumire;
}



public String getTelefon() {
	return telefon;
}

public void setTelefon(String telefon) {
	this.telefon = telefon;
}

public Furnizor(Integer cont,
		String cUI, String denumire, String telefon) {
	super();
	this.cont = cont;
	CUI = cUI;
	this.denumire = denumire;
	this.telefon = telefon;
}

public int getIdFurnizor() {
	return idFurnizor;
}

public void setIdFurnizor(Integer idFurnizor) {
	this.idFurnizor = idFurnizor;
}





}
