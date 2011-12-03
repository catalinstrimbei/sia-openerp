package org.open.erp.services.stocuri;





/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Gestionar  {
	private Gestiune gestiune;

	public Gestionar() {
		//super();
	}

	public Gestionar(Integer idPersoana, String nume, String prenume,
			Integer idCandidat, String tipCandidat, Gestiune gestiune) {
		//super(idPersoana, nume, prenume, idCandidat, tipCandidat);
		this.gestiune = gestiune;
	}

	public Gestiune getGestiune() {
		return gestiune;
	}

	public void setGestiune(Gestiune gestiune) {
		this.gestiune = gestiune;
	}

	
	
}
