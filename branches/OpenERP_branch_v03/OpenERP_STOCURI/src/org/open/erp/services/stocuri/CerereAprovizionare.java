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
public class CerereAprovizionare extends Document  {
	private String livrarePartiala;


	public CerereAprovizionare(Integer idDoc, Date dataDoc, String solicitant,
			String livrarePartiala) {
		super(idDoc, dataDoc);
		this.livrarePartiala = livrarePartiala;
	}

	

	public String getLivrarePartiala() {
		return livrarePartiala;
	}


	public void setLivrarePartiala(String livrarePartiala) {
		this.livrarePartiala = livrarePartiala;
	}
	

}