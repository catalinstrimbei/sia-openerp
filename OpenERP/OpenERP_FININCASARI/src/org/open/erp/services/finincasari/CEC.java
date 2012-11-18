package org.open.erp.services.finincasari;

import java.io.Serializable;
import java.sql.Date;

public class CEC extends FinIncasari implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Long intervalValabilitate;
	private String stare;

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

	public CEC(Date dataEmitere, Boolean avans, Date dataInregistrarii,
			Double suma, String sumaInLitere, String seria, Integer numar,
			String locatie, String stare) {
		super(dataEmitere, avans, dataInregistrarii, suma, sumaInLitere,
				seria, numar, locatie);
		this.stare = stare;
	}

	public CEC(Integer idFinIncasari, Date dataEmitere, Boolean avans,
			Date dataInregistrarii, Double suma, String sumaInLitere,
			String seria, Integer numar, String locatie,String stare) {
		super(idFinIncasari,  dataEmitere, avans, dataInregistrarii, suma,
				sumaInLitere, seria, numar, locatie);
		this.stare = stare;
	}
	public CEC() {
		super();
	}
	public CEC(java.util.Date dataEmitere, Boolean avans,
			java.util.Date dataInregistrarii, Double suma, String sumaInLitere,
			String seria, Integer numar, String locatie, String stare2) {
		// TODO Auto-generated constructor stub
	}
	public boolean getRollbackOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
