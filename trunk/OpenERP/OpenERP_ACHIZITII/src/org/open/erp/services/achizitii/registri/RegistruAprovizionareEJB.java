package org.open.erp.services.achizitii.registri;

import javax.persistence.EntityManager;

public class RegistruAprovizionareEJB {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RegistruAprovizionareEJB.class.getName());	

	/* set up */
	private EntityManager entityManager;
	public RegistruAprovizionareEJB(EntityManager em) {
		entityManager = em;
	}
}
