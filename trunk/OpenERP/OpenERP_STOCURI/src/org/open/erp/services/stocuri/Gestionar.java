package org.open.erp.services.stocuri;

import org.open.erp.services.personal.Angajat;



/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Gestionar extends Angajat {
	private Gestiune gestiune;

	public Gestionar() {
		super();
	}

	public Gestionar(Integer idPersoana, String nume, String prenume,
			Integer idCandidat, String tipCandidat, Gestiune gestiune) {
		super(idPersoana, nume, prenume, idCandidat, tipCandidat);
		this.gestiune = gestiune;
	}

	public Gestiune getGestiune() {
		return gestiune;
	}

	public void setGestiune(Gestiune gestiune) {
		this.gestiune = gestiune;
	}

	
	
}
