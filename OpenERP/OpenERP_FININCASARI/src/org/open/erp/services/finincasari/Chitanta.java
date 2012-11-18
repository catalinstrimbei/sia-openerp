package org.open.erp.services.finincasari;

import java.io.Serializable;
import java.sql.Date;

import org.open.erp.services.personal.Angajat;

public class Chitanta extends FinIncasari implements Serializable {

private static final long serialVersionUID = 1L;
	
	
	
	private Angajat casier;

	
	public Angajat getCasier() {
		return casier;
	}
	public void setCasier(Angajat casier) {
		this.casier = casier;
	}


	
	public Chitanta(Date dataEmitere, Boolean avans, Date dataInregistrarii,
			Double suma, String sumaInLitere, String seria, Integer numar,
			String locatie) {
		super(dataEmitere, avans, dataInregistrarii, suma, sumaInLitere, seria, numar,
				locatie);
		// TODO Auto-generated constructor stub
	}
	public Chitanta(Integer idFinIncasari, Date dataEmitere, Boolean avans,
			Date dataInregistrarii, Double suma, String sumaInLitere,
			String seria, Integer numar, String locatie) {
		super(idFinIncasari, dataEmitere, avans, dataInregistrarii, suma, sumaInLitere,
				seria, numar, locatie);
		// TODO Auto-generated constructor stub
	}
	public Chitanta(Date dataEmitere, Boolean avans, Date dataInregistrarii,
			Double suma, String sumaInLitere, String seria, Integer numar,
			String locatie, Angajat casier) {
		super(dataEmitere, avans, dataInregistrarii, suma, sumaInLitere, seria,
				numar, locatie);
		this.casier = casier;
	}
	public Chitanta() {
		super();
	}
	public Chitanta(java.util.Date dataEmitere, Boolean avans,
			java.util.Date dataInregistrarii, Double sumaIncasata,
			String sumaIncasataLitere, String seria, Integer numar,
			String locatie, Angajat casier2) {
		// TODO Auto-generated constructor stub
	}
	public boolean getRollbackOnly() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	

}
