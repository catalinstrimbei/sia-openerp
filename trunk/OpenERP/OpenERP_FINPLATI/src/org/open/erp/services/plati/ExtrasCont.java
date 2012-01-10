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

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.open.erp.services.plati.Plata;

@Entity(name = "ExtrasCont")
@DiscriminatorValue("ExtrasCont")
public class ExtrasCont extends Plata implements Serializable{

	public ExtrasCont(Integer idPlata, Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String seria, Integer numar,
			String locatie) {
		super(idPlata, dataEmiterii, avans, dataInregistrarii, suma,
				seria, numar, locatie);
	}

	public ExtrasCont() {
		super();
	}
}