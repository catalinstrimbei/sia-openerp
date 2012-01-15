package org.open.erp.services.achizitii;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Persoana;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
@AttributeOverride(name = "id", column = @Column(table = "Furnizor", name = "furnizor_id"))
public class Furnizor extends Persoana implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@OneToMany(mappedBy="furnizor")
private List<Factura> facturiFurnizor=new ArrayList<Factura>();

public List<Factura> getFacturiFurnizor() {
	return facturiFurnizor;
}



public void setFacturiFurnizor(List<Factura> facturiFurnizor) {
	this.facturiFurnizor = facturiFurnizor;
}



private Integer cont;
private String CUI;
private String denumire;
private String adresa;
private String telefon;

@ManyToOne@JoinColumn(name="id_cat")
private Categorie categorieArticol;
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

public String getAdresa() {
	return adresa;
}

public void setAdresa(String adresa) {
	this.adresa = adresa;
}

public String getTelefon() {
	return telefon;
}

public void setTelefon(String telefon) {
	this.telefon = telefon;
}



public Furnizor(Integer id, Departament dep, String adresa,
		List<String> telefoane, List<String> emailuri, String cUI,
		String denumire, String adresa2, String telefon) {
	super(id, dep, adresa, telefoane, emailuri);
	CUI = cUI;
	this.denumire = denumire;
	adresa = adresa2;
	this.telefon = telefon;
}

}
