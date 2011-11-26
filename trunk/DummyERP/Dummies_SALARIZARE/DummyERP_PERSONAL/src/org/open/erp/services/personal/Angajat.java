package org.open.erp.services.personal;

import java.util.Date;

import org.open.erp.services.nomgen.Persoana;

public class Angajat extends Persoana {
	private Date dataAngajare ;
    private Double salarBaza;
    private Integer numarCopii;
    private Double tarifOrar;
    
	public Double getTarifOrar() {
		return tarifOrar;
	}

	public void setTarifOrar(Double tarifOrar) {
		this.tarifOrar = tarifOrar;
	}

	public Double getSalarBaza() {
		return salarBaza;
	}

	public void setSalarBaza(Double salarBaza) {
		this.salarBaza = salarBaza;
	}

	public Angajat(Integer idPersoana, String nume, String prenume,
			Date dataAngajare, Double salarBaza, Double tarifOrar, Integer numarCopii
			) {
		super(idPersoana, nume, prenume);
		this.dataAngajare = dataAngajare;
		this.salarBaza = salarBaza;
		this.numarCopii = numarCopii;
		this.tarifOrar = tarifOrar;
	}

	public Integer getNumarCopii() {
		return numarCopii;
	}

	public void setNumarCopii(Integer numarCopii) {
		this.numarCopii = numarCopii;
	}

	public Angajat() {
		super();
	}

	public Angajat(Integer idPersoana, String nume, String prenume,
			Date dataAngajare) {
		super(idPersoana, nume, prenume);
		this.dataAngajare = dataAngajare;
	}

	public Date getDataAngajare() {
		return dataAngajare;
	}

	public void setDataAngajare(Date dataAngajare) {
		this.dataAngajare = dataAngajare;
	}
}
