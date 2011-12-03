package org.open.erp.services.marketing;

//import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
/**
 * 
 * @author echipa.marketing
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Responsabil extends Angajat {
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
