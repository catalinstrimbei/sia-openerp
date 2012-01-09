package org.open.erp.services.personal.impl;

import javax.persistence.EntityManager;

import org.open.erp.services.personal.logger.PersonalLogger;

public class RegistruPersonalEJB {
	private static PersonalLogger logger ;	

	/* set up */
	private EntityManager entityManager;
	public RegistruPersonalEJB(EntityManager em) {
		entityManager = em;
	}


}
