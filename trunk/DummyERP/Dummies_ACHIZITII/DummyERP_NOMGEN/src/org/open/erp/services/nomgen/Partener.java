package org.open.erp.services.nomgen;

public class Partener {
	public Integer idPartener;
	public String cui;
	public String denumire;
	public String adresa;
	public String telefon;
	public Persoana persContact;
	public Integer getIdPartener() {
		return idPartener;
	}
	public void setIdPartener(Integer idPartener) {
		this.idPartener = idPartener;
	}
	public String getCUI() {
		return cui;
	}
	public Partener(String cUI, String denumire, String adresa, String telefon,
			Persoana persContact) {
		super();
		cui = cUI;
		this.denumire = denumire;
		this.adresa = adresa;
		this.telefon = telefon;
		this.persContact = persContact;
	}
	public void setCUI(String cUI) {
		cui = cUI;
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
	public Persoana getPersContact() {
		return persContact;
	}
	public void setPersContact(Persoana persContact) {
		this.persContact = persContact;
	}

}
