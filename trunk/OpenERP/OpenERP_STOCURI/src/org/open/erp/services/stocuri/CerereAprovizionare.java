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



	public CerereAprovizionare() {
		super();
	}
	

}
