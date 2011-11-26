package org.open.erp.services.incasari;

import java.util.Date;

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
			Double suma, String sumaInLitere, String seria, String numar,
			String locatie, String stare) {
		super(dataEmiterii, avans, dataInregistrarii, suma, sumaInLitere,
				seria, numar, locatie);
		this.stare = stare;
	}




}
