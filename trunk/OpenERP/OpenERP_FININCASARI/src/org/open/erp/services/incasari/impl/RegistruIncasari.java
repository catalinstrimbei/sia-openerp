package org.open.erp.services.incasari.impl;

import javax.persistence.EntityManager;

import org.open.erp.services.incasari.Incasare;

public class RegistruIncasari {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(RegistruIncasari.class.getName());

	private EntityManager entityManager;

	public RegistruIncasari(EntityManager em) {
		entityManager = em;
	}

	public RegistruIncasari() {
	}

	public Incasare salveazaIncasare(Incasare incasare) throws Exception {
		try {
			if (incasare.getIdIncasare() == null
					|| entityManager.find(incasare.getClass(),
							incasare.getIdIncasare()) == null) {
				entityManager.persist(incasare);
			} else {
				entityManager.merge(incasare);
			}

		} catch (Exception e) {
			logger.info("Incasarea nu a putut fi salvata!");
			e.printStackTrace();
			throw e;
		}
		return incasare;
	}

	public void stergeIncasare(Incasare incasare) {
		entityManager.remove(incasare);
	}
	
	
}
