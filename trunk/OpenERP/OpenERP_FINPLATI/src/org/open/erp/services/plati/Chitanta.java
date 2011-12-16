package org.open.erp.services.plati;

import java.util.Date;

import org.open.erp.services.plati.Plata;
import org.open.erp.services.personal.Angajat;

public class Chitanta extends Plata {

	public Angajat getCasier() {
		return casier;
	}

	public void setCasier(Angajat casier) {
		this.casier = casier;
	}

	private Angajat casier;

	public Chitanta(Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String seria, Integer numar,
			String locatie, Angajat casier) {
		super(dataEmiterii, avans, dataInregistrarii, suma,
				seria, numar, locatie);
		this.casier = casier;
	}
}