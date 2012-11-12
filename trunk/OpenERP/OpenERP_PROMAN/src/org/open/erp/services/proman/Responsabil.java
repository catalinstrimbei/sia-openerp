package org.open.erp.services.proman;

import java.io.Serializable;

import org.open.erp.services.nomgen.Persoana;
/**
 * 
 * @author catalin.strimbei
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Responsabil extends Persoana{
	// Mosteneste: id, cnp, nume, prenume, adresa_email, adresa_postala(str_bloc_nr, codpostal, localitate, tara), adresa_web
	// Local: observatii
	String obsExperienta;
	private Integer idPersoana;
	private String nume;
	private String prenume;

	public String getObsExperienta() {
		return obsExperienta;
	}

	public void setObsExperienta(String obsExperienta) {
		this.obsExperienta = obsExperienta;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPersoana == null) ? 0 : idPersoana.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Responsabil other = (Responsabil) obj;
		if (idPersoana == null) {
			if (other.idPersoana != null)
				return false;
		} else if (!idPersoana.equals(other.idPersoana))
			return false;
		return true;
	}

	public Responsabil(Integer idPersoana, String nume, String prenume,
			String obsExperienta) {
		this.obsExperienta = obsExperienta;
	}

	public Responsabil() {
		super();
	}
	
	
}
