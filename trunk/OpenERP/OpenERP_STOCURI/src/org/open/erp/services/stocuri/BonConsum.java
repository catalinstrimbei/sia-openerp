
package org.open.erp.services.stocuri;

import java.util.Date;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.personal.Angajat;

/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
public class BonConsum extends Document {
	private Angajat persoanaPredare;

	public BonConsum() {
		super();
	}

	public BonConsum(Integer idDoc, Date dataDoc, String solicitant,
			Angajat persoanaPredare) {
		super(idDoc, dataDoc);
		this.persoanaPredare = persoanaPredare;
	}

	public Angajat getPersoanaPredare() {
		return persoanaPredare;
	}

	public void setPersoanaPredare(Angajat persoanaPredare) {
		this.persoanaPredare = persoanaPredare;
	}

	
	

}
