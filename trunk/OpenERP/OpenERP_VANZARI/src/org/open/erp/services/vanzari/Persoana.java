package org.open.erp.services.vanzari;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Persoana {
	
	
	@Id
	Integer idPersoana;
	String nume;
	String Prenume;
	String functie;
	public Persoana(Integer idPersoana, String nume, String prenume,
			String functie) {
		super();
		this.idPersoana = idPersoana;
		this.nume = nume;
		Prenume = prenume;
		this.functie = functie;
	}
	public Persoana() {
		super();
	}
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
		return Prenume;
	}
	public void setPrenume(String prenume) {
		Prenume = prenume;
	}
	public String getFunctie() {
		return functie;
	}
	public void setFunctie(String functie) {
		this.functie = functie;
	}
	
	

}
