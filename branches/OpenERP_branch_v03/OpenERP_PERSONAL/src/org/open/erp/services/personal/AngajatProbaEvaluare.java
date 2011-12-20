package org.open.erp.services.personal;

import java.util.List;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
public class AngajatProbaEvaluare {
	private Angajat			angajat;
	private	String			rezultat;
	private String			observatii;
	private ProbaEvaluare	probaEvaluare;
	public Angajat getAngajat() {
		return angajat;
	}
	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}
	public String getRezultat() {
		return rezultat;
	}
	public void setRezultat(String rezultat) {
		this.rezultat = rezultat;
	}
	public String getObservatii() {
		return observatii;
	}
	public void setObservatii(String observatii) {
		this.observatii = observatii;
	}
	public ProbaEvaluare getProbaEvaluare() {
		return probaEvaluare;
	}
	public void setProbaEvaluare(ProbaEvaluare probaEvaluare) {
		this.probaEvaluare = probaEvaluare;
	}
	public AngajatProbaEvaluare(Angajat angajat, String rezultat,
			String observatii, ProbaEvaluare probaEvaluare) {
		super();
		this.angajat = angajat;
		this.rezultat = rezultat;
		this.observatii = observatii;
		this.probaEvaluare = probaEvaluare;
	}

	
	
}
