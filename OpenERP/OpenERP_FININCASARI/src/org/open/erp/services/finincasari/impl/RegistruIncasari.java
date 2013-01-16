package org.open.erp.services.finincasari.impl;

import java.util.ArrayList;
import java.util.Date;
import javax.management.Query;
import javax.persistence.EntityManager;

import org.open.erp.services.finincasari.FinanciarIncasari;

public class RegistruIncasari {


	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RegistruIncasari.class.getName());
	
	// set up
	private EntityManager entityManager;
	public RegistruIncasari(EntityManager em) {
		entityManager = em;
	}

	public RegistruIncasari() {
	}

	public FinanciarIncasari salvareIncasare(FinanciarIncasari incasari) throws Exception {
		try {
			if(incasari.getIdIncasare() == null
					|| entityManager.find(incasari.getClass(),
							incasari.getIdIncasare()) == null) {
				entityManager.persist(incasari);
			} else {
			entityManager.merge(incasari);
			}

		} catch (Exception e) {
			logger.info("Incasarea nu a fost salvata!");
			e.printStackTrace();
			throw e;
		}
		return incasari;
}
	
	public void stergeIncasare(FinanciarIncasari incasari) {
		entityManager.remove(incasari);
	}

	public ArrayList<FinanciarIncasari> getIncasari(Date dataInreg) {
		Query q = (Query) entityManager.createQuery(
				"SELECT i FROM FinanciarIncasari i "
						+ "WHERE i.dataInregistrarii =:dataInreg").setParameter("dataInreg", dataInreg);
		@SuppressWarnings("unchecked")
		ArrayList<FinanciarIncasari> incasari = (ArrayList<FinanciarIncasari>) ((javax.persistence.Query) q).getResultList();

		return incasari;
	}
	}

