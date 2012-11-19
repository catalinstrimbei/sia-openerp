/**
 * 
 */
package org.open.erp.services.finplati;

import java.io.Serializable;

/**
 * @author paraschivgeanina
 *
 *
 * @DummyObject
 *
 */
public class Chitanta implements Serializable {

	private static int nextIdChitanta = 1;
	
	Plata plata;
	Integer idChitanta;
	
	public Chitanta(Plata plata) {
		idChitanta = nextIdChitanta++;
		this.plata = plata;
	}
}
