package org.open.erp.services.stocuri;

import java.util.Date;
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
		super(idDoc, dataDoc, solicitant);
		this.livrarePartiala = livrarePartiala;
	}


	public CerereAprovizionare(Integer idDoc, Date dataDoc, String solicitant) {
		super(idDoc, dataDoc, solicitant);
	}


	public String getLivrarePartiala() {
		return livrarePartiala;
	}


	public void setLivrarePartiala(String livrarePartiala) {
		this.livrarePartiala = livrarePartiala;
	}
	

}
