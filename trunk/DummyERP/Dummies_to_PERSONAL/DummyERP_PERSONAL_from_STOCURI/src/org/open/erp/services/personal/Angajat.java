package org.open.erp.services.personal;
/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class Angajat {
	private Integer marcaAng;
	private String nume;
	private String adresa;
	private String telefon;
	public Angajat() {
		super();
	}
	public Angajat(Integer marcaAng, String nume, String adresa, String telefon) {
		super();
		this.marcaAng = marcaAng;
		this.nume = nume;
		this.adresa = adresa;
		this.telefon = telefon;
	}
	public Integer getMarcaAng() {
		return marcaAng;
	}
	public void setMarcaAng(Integer marcaAng) {
		this.marcaAng = marcaAng;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
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
