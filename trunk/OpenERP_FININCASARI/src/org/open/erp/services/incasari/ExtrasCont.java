package org.open.erp.services.incasari;

import java.util.Date;

public class ExtrasCont extends Incasare {

	public ExtrasCont(Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String sumaInLitere, String seria, String numar,
			String locatie) {
		super(dataEmiterii, avans, dataInregistrarii, suma, sumaInLitere,
				seria, numar, locatie);
	}

}
