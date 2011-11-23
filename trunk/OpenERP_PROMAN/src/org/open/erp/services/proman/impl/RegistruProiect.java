package org.open.erp.services.proman.impl;

import org.open.erp.services.proman.Proiect;

/**
 * 
 * @BusinessObject(Repository)
 * 
 */
public class RegistruProiect {
	public Proiect getProiect(Integer id){
		Proiect proiect = new Proiect();
		proiect.setIdProiect(id);
		return proiect;
	}
}
