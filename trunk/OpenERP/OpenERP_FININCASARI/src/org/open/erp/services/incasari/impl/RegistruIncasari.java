package org.open.erp.services.incasari.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

	public List<Incasare> getIncasari(Date dataInreg) {
		Query q = entityManager.createQuery(
				"SELECT i FROM Incasare i "
						+ "WHERE i.dataInregistrarii =:dataInreg")
				.setParameter("dataInreg", dataInreg);
		@SuppressWarnings("unchecked")
		ArrayList<Incasare> incasari = (ArrayList<Incasare>) q.getResultList();

		return incasari;
	}

}
