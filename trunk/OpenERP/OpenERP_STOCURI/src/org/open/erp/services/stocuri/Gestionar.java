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

	public Gestionar(Integer marcaAng, String nume, String adresa,
			String telefon, Gestiune gestiune) {
		super(marcaAng, nume, adresa, telefon);
		this.gestiune = gestiune;
	}

	public Gestiune getGestiune() {
		return gestiune;
	}

	public void setGestiune(Gestiune gestiune) {
		this.gestiune = gestiune;
	}

	
	
}
