package org.open.erp.services.vanzari.impl;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;

/**
 * 
 * @author Irina Bogdan
 * 
 * @BusinessObject(Repository)
 * 
 */

public class RegistruVanzari {
	private static Logger logger = Logger.getLogger(RegistruVanzari.class.getName());	
	
	private EntityManager em;
	
	public RegistruVanzari(EntityManager _em){
		this.em = _em;
	}	
}
