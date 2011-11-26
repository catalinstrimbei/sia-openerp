package org.open.erp.services.stocuri;

import java.util.Date;

import org.open.erp.services.personal.Angajat;
/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
public class NotaReceptie extends Document  {
	private Gestiune gestiuneDestinatie;
	private Angajat responsabilReceptie;
	public NotaReceptie(Integer idDoc, Date dataDoc, String solicitant) {
		super(idDoc, dataDoc, solicitant);
	}
	public NotaReceptie(Integer idDoc, Date dataDoc, String solicitant,
			Gestiune gestiuneDestinatie, Angajat responsabilReceptie) {
		super(idDoc, dataDoc, solicitant);
		this.gestiuneDestinatie = gestiuneDestinatie;
		this.responsabilReceptie = responsabilReceptie;
	}
	public Gestiune getGestiuneDestinatie() {
		return gestiuneDestinatie;
	}
	public void setGestiuneDestinatie(Gestiune gestiuneDestinatie) {
		this.gestiuneDestinatie = gestiuneDestinatie;
	}
	public Angajat getResponsabilReceptie() {
		return responsabilReceptie;
	}
	public void setResponsabilReceptie(Angajat responsabilReceptie) {
		this.responsabilReceptie = responsabilReceptie;
	}
	
	
	

}
