package org.open.erp.services.salarizare;

import org.open.erp.services.personal.Angajat;
/**
 * 
 * @author ionut.hrubaru
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Pontaj {
	private Integer an;
	private Integer luna;
	private Angajat angajat;
	private Double oreLucrate;
	private Double oreSuplimentare;
	private Double oreConcediu;
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
	public Angajat getAngajat() {
		return angajat;
	}
	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}
	public Double getOreLucrate() {
		return oreLucrate;
	}
	public Pontaj(Angajat angajat, Integer an, Integer luna, Double oreLucrate,
			Double oreSuplimentare, Double oreConcediu) {
		super();
		this.an = an;
		this.luna = luna;
		this.angajat = angajat;
		this.oreLucrate = oreLucrate;
		this.oreSuplimentare = oreSuplimentare;
		this.oreConcediu = oreConcediu;
	}
	public Pontaj() {
		super();
	}
	public void setOreLucrate(Double oreLucrate) {
		this.oreLucrate = oreLucrate;
	}
	public Double getOreSuplimentare() {
		return oreSuplimentare;
	}
	public void setOreSuplimentare(Double oreSuplimentare) {
		this.oreSuplimentare = oreSuplimentare;
	}
	public Double getOreConcediu() {
		return oreConcediu;
	}
	public void setOreConcediu(Double oreConcediu) {
		this.oreConcediu = oreConcediu;
	}
	
	
}
