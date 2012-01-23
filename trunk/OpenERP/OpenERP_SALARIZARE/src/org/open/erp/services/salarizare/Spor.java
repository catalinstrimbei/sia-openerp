package org.open.erp.services.salarizare;

import java.io.Serializable;

import javax.persistence.Entity;

import org.open.erp.services.personal.Angajat;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;

@Entity
public class Spor implements Serializable{
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer idSpor;
	private String denumire;
	private Integer tip;//general sau la nivel de angajat
	
	@ManyToOne
	private Angajat angajat; //can be null
	private Integer an;
	private Integer luna;
	private Integer modCalcul;//procent sau suma fixa
	private Double  valoare;
	
	
	public Integer getIdSpor() {
		return idSpor;
	}
	public void setIdSpor(Integer idSpor) {
		this.idSpor = idSpor;
	}
	public Double getValoare() {
		return valoare;
	}
	public void setValoare(Double valoare) {
		this.valoare = valoare;
	}
	public Spor() {
		super();
	}
	public Spor(String denumire, Integer tip, Integer an,
			Integer luna, Angajat angajat, Integer modCalcul, Double valoare) {
		super();
		this.denumire = denumire;
		this.tip = tip;
		this.angajat = angajat;
		this.an = an;
		this.luna = luna;
		this.modCalcul = modCalcul;
		this.valoare = valoare;
	}
	
	
	public Spor(Integer idSpor, String denumire, Integer tip, 
			Integer an, Integer luna, Angajat angajat,Integer modCalcul, Double valoare) {
		super();
		this.idSpor = idSpor;
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
		result = prime * result + ((idSpor == null) ? 0 : idSpor.hashCode());
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
		Spor other = (Spor) obj;
		if (idSpor == null) {
			if (other.idSpor != null)
				return false;
		} else if (!idSpor.equals(other.idSpor))
			return false;
		return true;
	}
	
	
}
