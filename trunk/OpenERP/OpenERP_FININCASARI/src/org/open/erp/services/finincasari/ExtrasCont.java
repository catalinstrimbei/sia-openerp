package org.open.erp.services.finincasari;

import java.io.Serializable;
import java.sql.Date;


public class ExtrasCont  extends FinIncasari implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public ExtrasCont(Date dataEmitere, Boolean avans, Date dataInregistrarii,
			Double suma, String sumaInLitere, String seria, Integer numar,
			String locatie) {
		super(dataEmitere, avans, dataInregistrarii, suma, sumaInLitere, seria, numar,
				locatie);
	
	}

	public ExtrasCont() {
		super();

	}

	public ExtrasCont(java.util.Date dataEmitere, Boolean avans,
			java.util.Date dataInregistrarii, Double suma, String sumaInLitere,
			String seria, Integer numar, String locatie) {
		// TODO Auto-generated constructor stub
	}

	public boolean getRollbackOnly() {
		// TODO Auto-generated method stub
		return false;
	}




}
