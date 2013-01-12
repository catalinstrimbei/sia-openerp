/**
 * 
 */
package org.open.erp.services.finplati;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author paraschivgeanina
 *
 *
 * @DummyObject
 *
 */
@Entity
public class ChitantaPlata implements Serializable {
	@Id @GeneratedValue
protected Integer idChitanta;

@OneToOne
Plata plata;

	
	
	public Integer getidChitanta() {
		return idChitanta;
	}
	public void setIdFurnizor(Integer idChitanta) {
		this.idChitanta = idChitanta;
	}
	
	private static int nextIdChitanta = 1;
	public ChitantaPlata(Plata plata) {
		idChitanta = nextIdChitanta++;
		this.plata = plata;
	}
}
