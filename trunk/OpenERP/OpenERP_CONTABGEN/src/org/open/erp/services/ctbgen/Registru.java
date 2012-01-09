package org.open.erp.services.ctbgen;

import javax.persistence.EntityManager;

public abstract class Registru {
	protected static EntityManager em;
	protected String sqlDefaultText;

	public Registru() {
	}

	public Registru(EntityManager entityManager) {
		Registru.em = entityManager;
	}

	public void synchronize() {
		// sincronizare cu baza de date
		em.getTransaction().begin();
		try {
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}
