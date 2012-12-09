package org.open.erp.services.vanzari;

import org.open.erp.services.personal.Personal;

public class Responsabil extends Personal{
	// Mosteneste: id, cnp, nume, prenume, adresa_email, adresa_postala(str_bloc_nr, codpostal, localitate, tara), adresa_web
		// Local: observatii
	String Observatii;

	

	public String getObservatii() {
		return Observatii;
	}

	public void setObservatii(String observatii) {
		Observatii = observatii;
	}

	public Responsabil(Integer marca, String nume, String prenume,
			String serieBI, String nrBI, String ocupatie, String observatii) {
		super(marca, nume, prenume, serieBI, nrBI, ocupatie);
		Observatii = observatii;
	}

	public Responsabil() {
		super();
	}

	
	
	

}
