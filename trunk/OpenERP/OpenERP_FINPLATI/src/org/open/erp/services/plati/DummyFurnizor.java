package org.open.erp.services.plati;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import static javax.persistence.CascadeType.ALL;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class DummyFurnizor implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -7847586831319450149L;
/**
 * 
 */
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int idFurnizor_generat;
	private int idFurnizor;
@OneToMany(mappedBy="furnizor", cascade = ALL)
private List<FacturaPrimita> facturiFurnizor=new ArrayList<FacturaPrimita>();
private Integer cont;
private String CUI;
private String denumire;
private String telefon;
private String adresa;

@ManyToOne@JoinColumn(name="id_cat")
private DummyCategorie categorieArticol;



public List<FacturaPrimita> getFacturiFurnizor() {
	return facturiFurnizor;
}

public void setFacturiFurnizor(List<FacturaPrimita> facturiFurnizor) {
	this.facturiFurnizor = facturiFurnizor;
}
public Integer getCont() {
	return cont;
}



public DummyCategorie getCategorieArticol() {
	return categorieArticol;
}

public void setCategorieArticol(DummyCategorie categorieArticol) {
	this.categorieArticol = categorieArticol;
}


public DummyFurnizor() {
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

public DummyFurnizor(Integer cont,
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

public String getAdresa() {
	return adresa;
}

public void setAdresa(String adresa) {
	this.adresa = adresa;
}

public void setIdFurnizor(int idFurnizor) {
	this.idFurnizor = idFurnizor;
}

public DummyFurnizor(int idFurnizor, Integer cont, String cUI, String denumire,
		String telefon, String adresa, DummyCategorie categorieArticol) {
	super();
	this.idFurnizor = idFurnizor;
	this.cont = cont;
	CUI = cUI;
	this.denumire = denumire;
	this.telefon = telefon;
	this.adresa = adresa;
	this.categorieArticol = categorieArticol;
}





}
