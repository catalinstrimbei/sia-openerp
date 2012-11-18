package org.open.erp.services.finincasari.impl;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.open.erp.services.finincasari.FinIncasari;



public class RegistruIncasari {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(RegistruIncasari.class.getName());

	private EntityManager entityManager;

	public RegistruIncasari(EntityManager emanager) {
		entityManager = emanager;
	}

	public RegistruIncasari() {
	}

	public FinIncasari salveazaIncasare(FinIncasari incasare) throws Exception {
		try {
			if (incasare.getIdFinIncasari() == null
					|| entityManager.find(incasare.getClass(),
							incasare.getIdFinIncasari()) == null) {
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

	public void stergeIncasare(FinIncasari incasare) {
		entityManager.remove(incasare);
	}

	 public ArrayList<FinIncasari> getFinIncasari(Date dataInreg) {
		Query q =  entityManager.createQuery(
				"SELECT i FROM FinIncasare i "
						+ "WHERE i.dataInregistrarii =:dataInreg").setParameter("dataInreg", dataInreg);
		
		
		@SuppressWarnings("unchecked")
		ArrayList<FinIncasari> incasari = (ArrayList<FinIncasari>)  q.getResultList();

		return incasari;
	} 
 
	
}



