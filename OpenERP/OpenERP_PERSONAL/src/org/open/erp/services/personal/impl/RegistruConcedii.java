package org.open.erp.services.personal.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.open.erp.services.personal.Concedii;


/**
 * 
 * @BusinessObject(Repository)
 * 
 */
public class RegistruConcedii  {
	private static Logger logger = Logger.getLogger(RegistruConcedii.class.getName());	
	
	/* set up */
	private EntityManager entityManager;
	public RegistruConcedii(EntityManager em) {
		entityManager = em;
	}

	/* interogari */
	public Concedii getConcedii(Integer nrInregistrare){
		return entityManager.find(Concedii.class, nrInregistrare);
	}
	
	public List<Concedii> getToateConcediile(){
		return entityManager.createQuery("SELECT c FROM Concedii c").getResultList();
	}
	
	public List<Concedii> getConcediiDupaAngajat(Integer idAngajat){
		return entityManager
				.createQuery("SELECT c FROM Concedii c WHERE c.Angajat.idAngajat=:id")
				.setParameter("id", idAngajat)
				.getResultList();
	}
	
	/* persistenta */
	public Concedii salveazaConcediu (Concedii concedii) throws Exception{
		try{
			
			//if (!entityManager.contains(concedii)) /* o posibilitate de verificare */
			if (concedii.getNrInregistrare() == null ||
				entityManager.find(concedii.getClass(), concedii.getNrInregistrare()) == null)
				entityManager.persist(concedii);
			else
				entityManager.merge(concedii);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return concedii;
	}
	
	public void stergeProiect(Concedii concedii){
		entityManager.remove(concedii);
	}


	public void refreshConcedii(Concedii concedii){
		entityManager.refresh(concedii);
	}
}


