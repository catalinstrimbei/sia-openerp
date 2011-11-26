package org.open.erp.services.nomgen;

/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class Persoana {
	public Integer idPersoana;
	public String nume;
	public String prenume;
	public Integer getIdPersoana() {
		return idPersoana;
	}
	public void setIdPersoana(Integer idPersoana) {
		this.idPersoana = idPersoana;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public Persoana(Integer idPersoana, String nume, String prenume) {
		super();
		this.idPersoana = idPersoana;
		this.nume = nume;
		this.prenume = prenume;
	}
	public Persoana() {
		super();
	}
	
	
	
}
