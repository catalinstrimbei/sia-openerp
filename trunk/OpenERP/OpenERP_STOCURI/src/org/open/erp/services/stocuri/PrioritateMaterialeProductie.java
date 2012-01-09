package org.open.erp.services.stocuri;

import java.util.Date;

import javax.persistence.Entity;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.Persoana;

/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */

@Entity
public class PrioritateMaterialeProductie extends Document {

	private Document comMatariale;
	private Integer prioritate;
	private String inchisa;

	public Integer getPrioritate() {
		return prioritate;
	}

	public PrioritateMaterialeProductie(Integer nrDocument, Date dataDocument,
			Persoana persoana, String observatie, Document comMatariale,
			Integer prioritate, String inchisa) {
		super(nrDocument, dataDocument, persoana, observatie);
		this.comMatariale = comMatariale;
		this.prioritate = prioritate;
		this.inchisa = inchisa;
	}

	public void setPrioritate(Integer prioritate) {
		this.prioritate = prioritate;
	}

	public PrioritateMaterialeProductie(Integer idDoc, Date dataDoc,
			String solicitant) {
		super(idDoc, dataDoc);
	}

	public PrioritateMaterialeProductie(Integer idDoc, Date dataDoc,
			String solicitant, Document comanda, String inchisa) {
		super(idDoc, dataDoc);
		this.comMatariale = comanda;
		this.inchisa = inchisa;
	}

	public Document getComMatariale() {
		return comMatariale;
	}

	public void setComMatariale(Document comanda) {
		this.comMatariale = comanda;
	}

	public String getInchisa() {
		return inchisa;
	}

	public void setInchisa(String inchisa) {
		this.inchisa = inchisa;
	}

}
