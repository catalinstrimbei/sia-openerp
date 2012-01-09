package org.open.erp.services.plati;

/**
 * 
 * @author Echipa FINPLATI
 * 
 * @BusinessObject(Entity)
 * 
 */

import java.io.Serializable;
import java.util.Date;
import org.open.erp.services.plati.Plata;

public class ExtrasCont extends Plata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExtrasCont(Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String seria, Integer numar,
			String locatie) {
		super(dataEmiterii, avans, dataInregistrarii, suma,
				seria, numar, locatie);
	}

}