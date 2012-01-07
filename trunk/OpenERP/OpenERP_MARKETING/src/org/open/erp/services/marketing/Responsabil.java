package org.open.erp.services.marketing;
//test commit
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.open.erp.services.nomgen.Persoana;
//import org.open.erp.services.personal.Angajat;
/**
 * 
 * @author echipa.marketing
 * 
 * @BusinessObject(Entity)
 * 
 */
@MappedSuperclass
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
		super();
		this.setId(idPersoana);
		// TODO Auto-generated constructor stub
	}
	
}
