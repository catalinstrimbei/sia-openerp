package org.open.erp.services.incasari;

import java.util.Date;

import org.open.erp.services.personal.Angajat;


public class Chitanta extends Incasare {

	public Angajat getCasier() {
		return casier;
	}

	public void setCasier(Angajat casier) {
		this.casier = casier;
	}

	private Angajat casier;

	public Chitanta(Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String sumaInLitere, String seria, String numar,
			String locatie, Angajat casier) {
		super(dataEmiterii, avans, dataInregistrarii, suma, sumaInLitere,
				seria, numar, locatie);
		this.casier = casier;
	}








}
