package org.open.erp.services.finplati;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author paraschivgeanina
 *
 */
@Entity
public class Persoana implements Serializable{
	@Id
	@GeneratedValue
	protected Integer idPersoana;
	
	protected String nume;
	protected String prenume;
	protected Integer scorAptitudini;
	
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

	public void setScorAptitudini(Integer scorAptitudini) {
		this.scorAptitudini = scorAptitudini;
	}
	public Integer getScorAptitudini() {
		return this.scorAptitudini;
	}
}
