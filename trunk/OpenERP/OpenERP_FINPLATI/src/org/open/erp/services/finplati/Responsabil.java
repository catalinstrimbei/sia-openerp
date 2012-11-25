package org.open.erp.services.finplati;

import java.io.Serializable;

import org.open.erp.services.finplati.Persoana;
/**
 * 
 * @author paraschivgeanina
 * 
 */
public class Responsabil extends Persoana{

	String obsExperienta;
	public String getObsExperienta() {
		return obsExperienta;
	}

	public void setObsExperienta(String obsExperienta) {
		this.obsExperienta = obsExperienta;
	}

	public Responsabil(Integer idPersoana, String nume, String prenume,
			String obsExperienta) {
		this.obsExperienta = obsExperienta;
	}

	public Responsabil() {
		super();
	}	
	
	public Responsabil(Persoana p) {
		super();
		this.idPersoana = p.idPersoana;
		this.nume = p.nume;
		this.prenume = p.prenume;
		this.scorAptitudini = p.scorAptitudini;
	}
}
