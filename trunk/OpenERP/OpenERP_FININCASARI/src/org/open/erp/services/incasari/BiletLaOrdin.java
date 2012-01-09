package org.open.erp.services.incasari;

import static javax.persistence.TemporalType.DATE;


import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

import org.open.erp.services.nomgen.Persoana;

/**
 * 
 * @author Echipa FININCASARI
 * 
 * @BusinessObject(Entity)
 * 
 */
//comment

@Entity(name="BiletLaOrdin")
@DiscriminatorValue("BiletLaOrdin")
public class BiletLaOrdin extends Incasare {
	
	@Temporal(DATE)
	private Date dataScadenta;
	private static Long intervalValabilitate;
	
	@ManyToOne
	private Persoana garant;
	private String stare;

	public Date getDataScadenta() {
		return dataScadenta;
	}

	public void setDataScadenta(Date dataScadenta) {
		this.dataScadenta = dataScadenta;
	}

	public static Long getIntervalValabilitate() {
		return intervalValabilitate;
	}

	public static void setIntervalValabilitate(Long intervalValabilitate) {
		BiletLaOrdin.intervalValabilitate = intervalValabilitate;
	}

	public String getStare() {
		return stare;
	}

	public void setStare(String stare) {
		this.stare = stare;
	}

	public BiletLaOrdin(Date dataEmiterii, Boolean avans,
			Date dataInregistrarii, Double suma, String sumaInLitere,
			String seria, Integer numar, String locatie,
			 Date dataScadenta, Persoana garant,
			String stare) {
		super(dataEmiterii, avans, dataInregistrarii, suma, sumaInLitere,
				seria, numar, locatie);
		this.dataScadenta = dataScadenta;
		this.garant = garant;
		this.stare = stare;
	}
	
	public BiletLaOrdin(Integer idIncasare, Date dataEmiterii, Boolean avans,
			Date dataInregistrarii, Double suma, String sumaInLitere,
			String seria, Integer numar, String locatie, Date dataScadenta,
			Persoana garant, String stare) {
		super(idIncasare, dataEmiterii, avans, dataInregistrarii, suma,
				sumaInLitere, seria, numar, locatie);
		this.dataScadenta = dataScadenta;
		this.garant = garant;
		this.stare = stare;
	}

	public Persoana getGarant() {
		return garant;
	}

	public void setGarant(Persoana garant) {
		this.garant = garant;
	}

	public BiletLaOrdin() {
		super();
		
	}



}
