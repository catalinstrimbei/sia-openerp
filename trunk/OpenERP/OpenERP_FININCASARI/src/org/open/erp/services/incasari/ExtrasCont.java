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

@Entity(name = "ExtrasCont")
@DiscriminatorValue("ExtrasCont")
public class ExtrasCont extends Incasare {

	public ExtrasCont(Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String sumaInLitere, String seria, Integer numar,
			String locatie) {
		super(dataEmiterii, avans, dataInregistrarii, suma, sumaInLitere,
				seria, numar, locatie);

	}

	public ExtrasCont() {
		super();

	}

}
