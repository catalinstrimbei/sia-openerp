package org.open.erp.services.salarizare;

import org.open.erp.services.personal.Angajat;

public class Spor {
	private String denumire;
	private Integer tip;//general sau la nivel de angajat
	private Angajat angajat; //can be null
	private Integer an;
	private Integer luna;
	private Integer modCalcul;//procent sau suma fixa
	private Double  valoare;
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
	
	
}
