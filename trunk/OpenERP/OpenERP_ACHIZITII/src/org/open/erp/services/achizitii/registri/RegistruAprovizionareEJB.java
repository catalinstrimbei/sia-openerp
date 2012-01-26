package org.open.erp.services.achizitii.registri;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.open.erp.services.achizitii.Furnizor;
import org.open.erp.services.achizitii.OfertaAchizitie;

public class RegistruAprovizionareEJB {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RegistruAprovizionareEJB.class.getName());	

	/* set up */
	private EntityManager entityManager;
	public RegistruAprovizionareEJB(EntityManager em) {
		entityManager = em;
	}
	@SuppressWarnings("unchecked")
	public Collection<OfertaAchizitie> getOferteAchizitiePerFurnizor(Furnizor furnizor_) throws Exception{
		try{
			return entityManager.createQuery("SELECT oa FROM OfertaAchizitie oa " +
											"WHERE oa.furnizor = :furnizor_")
											.setParameter("furnizor_", furnizor_)
											.getResultList();
		}catch(Exception ex){
			logger.error("ERROR: "+ex.getMessage());
			throw ex;
		}
	}
}

