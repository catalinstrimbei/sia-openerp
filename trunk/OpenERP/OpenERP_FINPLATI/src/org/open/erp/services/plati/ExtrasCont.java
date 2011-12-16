package org.open.erp.services.plati;

import java.util.Date;
import org.open.erp.services.plati.Plata;

public class ExtrasCont extends Plata {

	public ExtrasCont(Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String seria, Integer numar,
			String locatie) {
		super(dataEmiterii, avans, dataInregistrarii, suma,
				seria, numar, locatie);
	}

}