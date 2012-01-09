package org.open.erp.services.contabgest.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.open.erp.services.contabgest.ActivitateCentruCost;
import org.open.erp.services.contabgest.CentruCost;

public class RegistruCentruCost {
	private static Logger logger = Logger.getLogger(RegistruCentruCost.class.getName());
	
	private EntityManager entityManager;
	
	public RegistruCentruCost(EntityManager em){
		entityManager = em;
	}
	
	public CentruCost getCentruCost(Integer id){
		CentruCost centruCost = new CentruCost();
		centruCost.setIdCentruCost(id);
		return centruCost;
	}
	
	public CentruCost getCentruC(Integer id){
		return  entityManager.find(CentruCost.class, id);	
	}
	public List<CentruCost> getCentreCost(){
		return entityManager.createQuery("SELECT c FROM CentruCost c").getResultList();
	}
	
	public List<CentruCost> getCentruCostDupaResponabil(Integer idResponsabil){
		
		return entityManager.
				createQuery("Select c from CentruCost c where c.responsabil.idAngajat=:idAngajat")
				.setParameter("idAngajat", idResponsabil)
				.getResultList();
	}
	
	public CentruCost salveazaCentruCost(CentruCost centruCost) throws Exception{
		try{
			if(centruCost.getIdCentruCost()==null ||
					entityManager.find(centruCost.getClass(), centruCost.getIdCentruCost() )==null)
					entityManager.persist(centruCost);
		else
			entityManager.merge(centruCost);
		}
		
		catch (Exception ex) {
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		
		return centruCost;
		
		
	}
	
	public void stergeCentruCost(CentruCost centruCost){
		entityManager.remove(centruCost);
	}
	
	public ActivitateCentruCost salveazaActivitateCentruCost(ActivitateCentruCost activitate) throws Exception{
		logger.debug("Salvare" + activitate);
		try{
			entityManager.merge(activitate.getCentruCost());
			
			if(activitate.getIdActivitate() == null ||
					entityManager.find(activitate.getClass(), activitate.getIdActivitate())==null)
					entityManager.persist(activitate);
			else
				entityManager.merge(activitate);
		}
		catch (Exception e) {
			logger.info("Eroare");
			e.printStackTrace();
			throw e;
		}
		
		return activitate;	
		
	}
	
	public void refreshCentruCost(CentruCost centruCost){
		entityManager.refresh(centruCost);
	}

}
