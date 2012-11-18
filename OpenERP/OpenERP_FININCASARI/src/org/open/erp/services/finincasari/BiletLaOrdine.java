package org.open.erp.services.finincasari;

import java.io.Serializable;
import java.sql.Date;


import org.open.erp.services.nomgen.Persoana;

public class BiletLaOrdine extends FinIncasari implements Serializable  {

	
	
	private static final long serialVersionUID = 1L;
	
	private Date dataScadenta;
	private static Long intervalValabilitate;

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
		BiletLaOrdine.intervalValabilitate = intervalValabilitate;
	}
	public String getStare() {
		return stare;
	}

	public void setStare(String stare) {
		this.stare = stare;
	}

	public BiletLaOrdine(Date dataEmitere, Boolean avans,
			Date dataInregistrarii, Double suma, String sumaInLitere,
			String seria, Integer numar, String locatie,
			 Date dataScadenta, Persoana garant,
			String stare) {
		super(dataEmitere, avans, dataInregistrarii, suma, sumaInLitere,
				seria, numar, locatie);
		this.dataScadenta = dataScadenta;
		this.garant = garant;
		this.stare = stare;
	}
	
	public BiletLaOrdine(Integer idIncasare, Date dataEmitere, Boolean avans,
			Date dataInregistrarii, Double suma, String sumaInLitere,
			String seria, Integer numar, String locatie, Date dataScadenta,
			Persoana garant, String stare) {
		super(idIncasare, dataEmitere, avans, dataInregistrarii, suma,
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

	public BiletLaOrdine() {
		super();
	}

	public BiletLaOrdine(java.util.Date dataEmitere, Boolean avans,
			java.util.Date dataInregistrarii, Double suma, String sumaInLitere,
			String seria, Integer numar, String locatie,
			java.util.Date dataScadenta2, Persoana garant2, String stare2) {
		// TODO Auto-generated constructor stub
	}

	public boolean getRollbackOnly() {
		// TODO Auto-generated method stub
		return false;
	}
		



}

