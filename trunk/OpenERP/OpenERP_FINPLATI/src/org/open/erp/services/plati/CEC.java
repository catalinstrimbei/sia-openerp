package org.open.erp.services.plati;

/**
 * 
 * @author Echipa FINPLATI
 * 
 * @BusinessObject(Entity)
 * 
 */

import java.util.Date;

public class CEC extends Plata{
	private static Long intervalValabilitate;
	private String stare;

	public CEC(Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String seria, Integer numar,
			String locatie, String stare) {
		super(dataEmiterii, avans, dataInregistrarii, suma,
				seria, numar, locatie);
		this.stare = stare;
	}
	
	public static Long getIntervalValabilitate() {
		return intervalValabilitate;
	}
	
	public static void setIntervalValabilitate(Long intervalValabilitate) {
	CEC.intervalValabilitate = intervalValabilitate;
	}

	public String getStare() {
	return stare;
	}

	public void setStare(String stare) {
	this.stare = stare;
	}
}