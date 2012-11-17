package org.open.erp.services.vanzari;

import org.open.erp.services.personal.Personal;

public class Responsabil extends Personal{
	// Mosteneste: id, cnp, nume, prenume, adresa_email, adresa_postala(str_bloc_nr, codpostal, localitate, tara), adresa_web
		// Local: observatii
	String observatii;
	private Integer idPersoana;
	private String nume;
	private String prenume;
	
	
	public String getObservatii() {
		return observatii;
	}
	public void setObservatii(String observatii) {
		this.observatii = observatii;
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
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	
	


}
