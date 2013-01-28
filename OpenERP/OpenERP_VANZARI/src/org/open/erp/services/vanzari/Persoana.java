package org.open.erp.services.vanzari;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Persoana implements Serializable{
	
	
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
		Persoana other = (Persoana) obj;
		if (idPersoana == null) {
			if (other.idPersoana != null)
				return false;
		} else if (!idPersoana.equals(other.idPersoana))
			return false;
		return true;
	}
	
	

}
