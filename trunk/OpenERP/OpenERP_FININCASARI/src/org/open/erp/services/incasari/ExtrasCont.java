package org.open.erp.services.incasari;

/**
 * 
 * @author Echipa FININCASARI
 * 
 * @BusinessObject(Entity)
 * 
 */

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "ExtrasCont")
@DiscriminatorValue("ExtrasCont")
public class ExtrasCont extends Incasare implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
