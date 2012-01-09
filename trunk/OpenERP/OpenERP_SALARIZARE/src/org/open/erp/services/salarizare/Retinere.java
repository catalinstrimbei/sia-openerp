package org.open.erp.services.salarizare;

import java.io.Serializable;

import javax.persistence.Entity;

import org.open.erp.services.personal.Angajat;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.ManyToOne;

@Entity
public class Retinere implements Serializable{
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer idRetinere;
	private String denumire;
	private Integer tip;//general sau la nivel de angajat
	@ManyToOne
	private Angajat angajat; //can be null
	private Integer an;
	private Integer luna;
	private Integer modCalcul;//procent sau suma fixa
	private Double valoare;//procent sau suma fixa
	
	
	public Integer getIdRetinere() {
		return idRetinere;
	}
	public void setIdRetinere(Integer idRetinere) {
		this.idRetinere = idRetinere;
	}
	public Double getValoare() {
		return valoare;
	}
	public void setValoare(Double valoare) {
		this.valoare = valoare;
	}
	public Retinere() {
		super();
	}

	public Retinere(Integer idRetinere, String denumire, Integer tip,
			Angajat angajat, Integer an, Integer luna, Integer modCalcul,
			Double valoare) {
		super();
		this.idRetinere = idRetinere;
		this.denumire = denumire;
		this.tip = tip;
		this.angajat = angajat;
		this.an = an;
		this.luna = luna;
		this.modCalcul = modCalcul;
		this.valoare = valoare;
	}
	public Retinere(String denumire, Integer tip, Angajat angajat, Integer an,
			Integer luna, Integer modCalcul, Double valoare) {
		super();
		this.denumire = denumire;
		this.tip = tip;
		this.angajat = angajat;
		this.an = an;
		this.luna = luna;
		this.modCalcul = modCalcul;
		this.valoare = valoare;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public Integer getTip() {
		return tip;
	}
	public void setTip(Integer tip) {
		this.tip = tip;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idRetinere == null) ? 0 : idRetinere.hashCode());
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
		Retinere other = (Retinere) obj;
		if (idRetinere == null) {
			if (other.idRetinere != null)
				return false;
		} else if (!idRetinere.equals(other.idRetinere))
			return false;
		return true;
	}
	
	
}
