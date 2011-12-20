package org.open.erp.services.stocuri;

import java.util.Date;

import org.open.erp.services.nomgen.Document;


/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */


public class PrioritateMaterialeProductie extends Document  {
	private Document comMatariale;
	private String inchisa;
	public PrioritateMaterialeProductie(Integer idDoc, Date dataDoc,
			String solicitant) {
		super(idDoc, dataDoc);
	}
	public PrioritateMaterialeProductie(Integer idDoc, Date dataDoc,
			String solicitant, Document comanda,
			String inchisa) {
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
