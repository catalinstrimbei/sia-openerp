package org.open.erp.services.plati;

/**
 * 
 * @author Echipa FINPLATI
 * 
 * @BusinessObject(Entity)
 * 
 */

import java.io.Serializable;
import java.util.Date;

import javax.persistence.ManyToOne;

import org.open.erp.services.plati.Plata;
import org.open.erp.services.personal.Angajat;

public class Chitanta extends Plata implements Serializable{

	public Angajat getCasier() {
		return casier;
	}

	public void setCasier(Angajat casier) {
		this.casier = casier;
	}
	
	@ManyToOne
	private Angajat casier;

	public Chitanta(Integer idPlata, Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String seria, Integer numar,
			String locatie, Angajat casier) {
		super(idPlata, dataEmiterii, avans, dataInregistrarii, suma,
				seria, numar, locatie);
		this.casier = casier;
	}
}