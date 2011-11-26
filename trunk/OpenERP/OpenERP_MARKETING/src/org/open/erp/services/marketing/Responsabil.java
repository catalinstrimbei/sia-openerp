package org.open.erp.services.marketing;

import org.open.erp.services.nomgen.Persoana;
/**
 * 
 * @author echipa.marketing
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Responsabil extends Persoana {
	public Responsabil() {
		super();
	}

	/**
	 * @param idPersoana
	 * @param nume
	 * @param prenume
	 */
	public Responsabil(Integer idPersoana, String nume, String prenume) {
		super(idPersoana, nume, prenume);
		// TODO Auto-generated constructor stub
	}
	
}
