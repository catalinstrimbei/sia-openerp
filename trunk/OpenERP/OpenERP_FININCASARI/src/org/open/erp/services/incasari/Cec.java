package org.open.erp.services.incasari;

/**
 * 
 * @author Echipa FININCASARI

 * 
 * @BusinessObject(Entity)
 * 
 */

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Cec")
@DiscriminatorValue("Cec")
public class Cec extends Incasare {

	private static Long intervalValabilitate;
	private String stare;

	public static Long getIntervalValabilitate() {
		return intervalValabilitate;
	}

	public static void setIntervalValabilitate(Long intervalValabilitate) {
		Cec.intervalValabilitate = intervalValabilitate;
	}

	public String getStare() {
		return stare;
	}

	public void setStare(String stare) {
		this.stare = stare;
	}

	public Cec(Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String sumaInLitere, String seria, Integer numar,
			String locatie, String stare) {
		super(dataEmiterii, avans, dataInregistrarii, suma, sumaInLitere,
				seria, numar, locatie);
		this.stare = stare;
	}

	public Cec(Integer idIncasare, Date dataEmiterii, Boolean avans,
			Date dataInregistrarii, Double suma, String sumaInLitere,
			String seria, Integer numar, String locatie, String stare) {
		super(idIncasare, dataEmiterii, avans, dataInregistrarii, suma,
				sumaInLitere, seria, numar, locatie);
		this.stare = stare;
	}

	public Cec() {
		super();
	}

}
