package org.open.erp.services.nomgen;

public class PersoanaFizica extends Persoana {
	 String sex;
	 String mail;
	 String statutInCompanie;
	 String stareCivila;
	 String dataNastere;
	 String telefon;
	 Adresa adresa;
	 
	public String getSex() {
		return sex;
	}
	public PersoanaFizica(Integer id, String nume) {
		super(id, nume);
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getStatutInCompanie() {
		return statutInCompanie;
	}
	public void setStatutInCompanie(String statutInCompanie) {
		this.statutInCompanie = statutInCompanie;
	}
	public String getStareCivila() {
		return stareCivila;
	}
	public void setStareCivila(String stareCivila) {
		this.stareCivila = stareCivila;
	}
	public String getDataNastere() {
		return dataNastere;
	}
	public void setDataNastere(String dataNastere) {
		this.dataNastere = dataNastere;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	public PersoanaFizica(Integer id, String nume,  String sex,
			String mail, String statutInCompanie, String stareCivila,
			String dataNastere, String telefon, Adresa adresa) {
		super(id, nume);
		this.sex = sex;
		this.mail = mail;
		this.statutInCompanie = statutInCompanie;
		this.stareCivila = stareCivila;
		this.dataNastere = dataNastere;
		this.telefon = telefon;
		this.adresa = adresa;
	}
	public PersoanaFizica() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 


}
