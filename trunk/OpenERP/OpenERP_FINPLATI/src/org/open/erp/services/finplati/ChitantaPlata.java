/**
 * 
 */
package org.open.erp.services.finplati;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author paraschivgeanina
 *
 *
 * @DummyObject
 *
 */
//@Entity
public class ChitantaPlata implements Serializable {
	@Id @GeneratedValue
Integer idChitanta;

//@OneToMany
Plata plata;

	private static int nextIdChitanta = 1;
	
	
	public ChitantaPlata(Plata plata) {
		idChitanta = nextIdChitanta++;
		this.plata = plata;
	}
}
