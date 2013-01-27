package org.open.erp.services.salarizare;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

import org.open.erp.services.personal.Angajat;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Sporuri implements Serializable{

	
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer cod_Spor;
	private String denumire_Spor;
	private Integer tip_Spor;
	private Integer an;
	private Integer luna;
	@ManyToOne
	private Angajat angajat;
	private Integer modCalcul;
	private Double  valoare;

	public Integer getCod_Spor() {
		return cod_Spor;
	}


	public void setCod_Spor(Integer cod_Spor) {
		this.cod_Spor = cod_Spor;
	}


	public String getDenumire_Spor() {
		return denumire_Spor;
	}


	public void setDenumire_Spor(String denumire_Spor) {
		this.denumire_Spor = denumire_Spor;
	}


	public Integer getTip_Spor() {
		return tip_Spor;
	}


	public void setTip_Spor(Integer tip_Spor) {
		this.tip_Spor = tip_Spor;
	}


	public Integer getLuna() {
		return luna;
	}


	public void setLuna(Integer luna) {
		this.luna = luna;
	}


	public Integer getModCalcul() {
		return modCalcul;
	}


	public void setModCalcul(Integer modCalcul) {
		this.modCalcul = modCalcul;
	}


	public Double getValoare() {
		return valoare;
	}


	public void setValoare(Double valoare) {
		this.valoare = valoare;
	}


	public Angajat getAngajat() {
		return angajat;
	}


	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}


	public Integer getAn() {
		return an;
	}


	public void setAn(Integer an) {
		this.an = an;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((an == null) ? 0 : an.hashCode());
		result = prime * result + ((angajat == null) ? 0 : angajat.hashCode());
		result = prime * result
				+ ((cod_Spor == null) ? 0 : cod_Spor.hashCode());
		result = prime * result
				+ ((denumire_Spor == null) ? 0 : denumire_Spor.hashCode());
		result = prime * result + ((luna == null) ? 0 : luna.hashCode());
		result = prime * result
				+ ((modCalcul == null) ? 0 : modCalcul.hashCode());
		result = prime * result
				+ ((tip_Spor == null) ? 0 : tip_Spor.hashCode());
		result = prime * result + ((valoare == null) ? 0 : valoare.hashCode());
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
		Sporuri other = (Sporuri) obj;
		if (an == null) {
			if (other.an != null)
				return false;
		} else if (!an.equals(other.an))
			return false;
		if (angajat == null) {
			if (other.angajat != null)
				return false;
		} else if (!angajat.equals(other.angajat))
			return false;
		if (cod_Spor == null) {
			if (other.cod_Spor != null)
				return false;
		} else if (!cod_Spor.equals(other.cod_Spor))
			return false;
		if (denumire_Spor == null) {
			if (other.denumire_Spor != null)
				return false;
		} else if (!denumire_Spor.equals(other.denumire_Spor))
			return false;
		if (luna == null) {
			if (other.luna != null)
				return false;
		} else if (!luna.equals(other.luna))
			return false;
		if (modCalcul == null) {
			if (other.modCalcul != null)
				return false;
		} else if (!modCalcul.equals(other.modCalcul))
			return false;
		if (tip_Spor == null) {
			if (other.tip_Spor != null)
				return false;
		} else if (!tip_Spor.equals(other.tip_Spor))
			return false;
		if (valoare == null) {
			if (other.valoare != null)
				return false;
		} else if (!valoare.equals(other.valoare))
			return false;
		return true;
	}


	public Sporuri(Integer cod_Spor, String denumire_Spor, Integer tip_Spor,
			Integer an, Integer luna, Angajat angajat, Integer modCalcul,
			Double valoare) {
		super();
		this.cod_Spor = cod_Spor;
		this.denumire_Spor = denumire_Spor;
		this.tip_Spor = tip_Spor;
		this.an = an;
		this.luna = luna;
		this.angajat = angajat;
		this.modCalcul = modCalcul;
		this.valoare = valoare;
	}


}