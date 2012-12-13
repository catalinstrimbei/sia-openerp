package org.open.erp.services.finplati;

import java.io.Serializable;

import org.open.erp.services.finplati.Persoana;
/**
 * 
 * @author paraschivgeanina
 * 
 */
public class ResponsabilPlata extends Persoana{

	String obsExperienta;
	public String getObsExperienta() {
		return obsExperienta;
	}

	public void setObsExperienta(String obsExperienta) {
		this.obsExperienta = obsExperienta;
	}

	public ResponsabilPlata(Integer idPersoana, String nume, String prenume,
			String obsExperienta) {
		this.obsExperienta = obsExperienta;
	}

	public ResponsabilPlata() {
		super();
	}	
	
	public ResponsabilPlata(Persoana p) {
		super();
		this.idPersoana = p.idPersoana;
		this.nume = p.nume;
		this.prenume = p.prenume;
		this.scorAptitudini = p.scorAptitudini;
	}
}
