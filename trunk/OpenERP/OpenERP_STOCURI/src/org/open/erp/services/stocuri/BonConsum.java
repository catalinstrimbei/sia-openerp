
package org.open.erp.services.stocuri;

import java.util.Date;

import javax.persistence.Entity;

import org.open.erp.services.nomgen.Document;


/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class BonConsum extends Document {
	private Gestionar persoanaPredare;

	public BonConsum() {
		super();
	}

	public BonConsum(Integer idDoc, Date dataDoc, String solicitant,
			Gestionar persoanaPredare) {
		//super(idDoc, dataDoc);
		this.persoanaPredare = persoanaPredare;
	}

	public Gestionar getPersoanaPredare() {
		return persoanaPredare;
	}

	public void setPersoanaPredare(Gestionar persoanaPredare) {
		this.persoanaPredare = persoanaPredare;
	}

	
	

}
