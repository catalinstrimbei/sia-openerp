package org.open.erp.services.achizitii.registri;

import javax.persistence.EntityManager;



public class RegistruAprovizionare {
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RegistruAprovizionare.class.getName());	

		/* set up */
		private EntityManager entityManager;
		public RegistruAprovizionare(EntityManager em) {
			entityManager = em;
		}

}
