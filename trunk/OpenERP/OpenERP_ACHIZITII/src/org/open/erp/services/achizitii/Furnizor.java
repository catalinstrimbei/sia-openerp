package org.open.erp.services.achizitii;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Entity;
import org.open.erp.services.nomgen.Partener;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class Furnizor extends Partener implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private String furnizor_id;
@OneToMany(mappedBy="furnizor")
private List<Factura> facturiFurnizor=new ArrayList<Factura>();
private Integer id;
private Integer cont;
private String CUI;
private String denumire;
private String adresa;
private String telefon;
@ManyToMany(mappedBy="trimisaLaFurnizori")
private List<CerereOferta> cereriPerFurnizor=new ArrayList<CerereOferta>();
@ManyToMany@JoinColumn(name="cerereoferta") 
private CerereOferta cerereOferta;
@ManyToOne@JoinColumn(name="cat")
private Categorie categorieArticol;
public Integer getCont() {
	return cont;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Categorie getCategorieArticol() {
	return categorieArticol;
}

public void setCategorieArticol(Categorie categorieArticol) {
	this.categorieArticol = categorieArticol;
}

public Furnizor(Integer id, Integer idPersoana, Date dataAfilierii,
		Integer durataAfilierii) {
	super(id, idPersoana, dataAfilierii, durataAfilierii);
}
public Furnizor() {
	super();
}
public void setCont(Integer cont) {
	this.cont = cont;
}

public Furnizor(Integer id, Integer idPersoana, Integer durataAfilierii,
		Integer cont, String cUI, String denumire, String adresa, String telefon) {
	super(id, idPersoana, durataAfilierii);
	this.cont = cont;
	CUI = cUI;
	this.denumire = denumire;
	this.adresa = adresa;
	this.telefon = telefon;
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

}
