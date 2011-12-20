package org.open.erp.services.achizitii;

import org.open.erp.services.nomgen.Partener;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */

public class Furnizor extends Partener {
private Integer cont;
private String CUI;
private String denumire;
private String adresa;
private String telefon;

public Integer getCont() {
	return cont;
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
