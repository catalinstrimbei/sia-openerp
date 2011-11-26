package org.open.erp.services.stocuri;

import java.util.Date;


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
		super(idDoc, dataDoc, solicitant);
	}
	public PrioritateMaterialeProductie(Integer idDoc, Date dataDoc,
			String solicitant, org.open.erp.services.stocuri.Document comanda,
			String inchisa) {
		super(idDoc, dataDoc, solicitant);
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
