package org.open.erp.services.incasari;

/**
 * 
 * @author Echipa FININCASARI
 * 
 * @BusinessObject(Entity)
 * 
 */

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.open.erp.services.personal.Angajat;

@Entity(name = "Chitanta")
@DiscriminatorValue("Chitanta")
public class Chitanta extends Incasare implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Angajat getCasier() {
		return casier;
	}

	public void setCasier(Angajat casier) {
		this.casier = casier;
	}

	@ManyToOne
	private Angajat casier;

	public Chitanta(Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String sumaInLitere, String seria, Integer numar,
			String locatie, Angajat casier) {
		super(dataEmiterii, avans, dataInregistrarii, suma, sumaInLitere,
				seria, numar, locatie);
		this.casier = casier;
	}

	public Chitanta(Integer idIncasare, Date dataEmiterii, Boolean avans,
			Date dataInregistrarii, Double suma, String sumaInLitere,
			String seria, Integer numar, String locatie, Angajat casier) {
		super(idIncasare, dataEmiterii, avans, dataInregistrarii, suma,
				sumaInLitere, seria, numar, locatie);
		this.casier = casier;
	}

	public Chitanta() {
		super();
	}

}
