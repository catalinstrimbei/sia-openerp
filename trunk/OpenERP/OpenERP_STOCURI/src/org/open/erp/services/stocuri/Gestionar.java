package org.open.erp.services.stocuri;

import javax.persistence.Entity;

import org.open.erp.services.personal.Angajat;

/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class Gestionar extends Angajat {
	private Gestiune gestiune;

	public Gestionar() {

	}

	public Gestionar(Integer id, String adresa, String nume, String prenume,
			String formaAdresare, char gen, String cnp, Integer idCandidat,
			String tipCandidat, Gestiune gestiune) {
		super(id, adresa, nume, prenume, formaAdresare, gen, cnp, idCandidat,
				tipCandidat);
		this.gestiune = gestiune;
	}

	public Gestionar(Integer idPersoana, String nume, String prenume,
			Integer idCandidat, String tipCandidat, Gestiune gestiune) {
		// super(idPersoana, nume, prenume, idCandidat, tipCandidat);
		this.gestiune = gestiune;
	}

	public Gestiune getGestiune() {
		return gestiune;
	}

	public void setGestiune(Gestiune gestiune) {
		this.gestiune = gestiune;
	}

}
