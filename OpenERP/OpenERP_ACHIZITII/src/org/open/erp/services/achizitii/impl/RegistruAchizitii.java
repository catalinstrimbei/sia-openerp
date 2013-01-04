package org.open.erp.services.achizitii.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.apache.log4j.Logger;
import org.open.erp.services.achizitii.LiniiPlanAprov;
import org.open.erp.services.achizitii.PlanAprov;


/**
 * 
 * @BusinessObject(Repository)
 * 
 */
public class RegistruAchizitii {
	public static Logger logger = Logger.getLogger(RegistruAchizitii.class.getName());
	
	/* set up */
	private EntityManager entityManager;
	public RegistruAchizitii(EntityManager em){
		entityManager = em;
	}

	/* interogari */
	public PlanAprov getPlanAprov(Integer id){
		return entityManager.find(PlanAprov.class, id);
	}
	
	public List<PlanAprov> getToatePlanurileAprov(){
		return entityManager.createQuery("SELECT p FROM PlanAprov p").getResultList();
	}
	
	public List<PlanAprov> getPlanAprovDupaAn(Integer an){
		return entityManager
				.createQuery("SELECT p FROM PlanAprov p WHERE p.an=:an")
				.setParameter("an", an)
				.getResultList();
		//:an corespunde cu parametrul metodei
		//p.an  si   "an"  corespund cu cele din BD
	}
	
	
	/* persistenta */
	public PlanAprov salveazaPlanAprov(PlanAprov planAprov) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (planAprov.getNrPlanAprov() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(planAprov.getClass(), planAprov.getNrPlanAprov()) == null)
				entityManager.persist(planAprov);
			else
				entityManager.merge(planAprov);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return planAprov;
	}
	
	public void stergePlanAprov(PlanAprov planAprov){
		entityManager.remove(planAprov);
	}

	public LiniiPlanAprov salveazaLiniiPlanAprov(LiniiPlanAprov liniePlanAprov) throws Exception{
		logger.debug("--De salvat linia cu ID: " + liniePlanAprov.getNrLiniePlanAprov());
		try{
			/* Proiectul plimbandu-se de la client-la server-inapoi la client-iarasi la server
			 * nu este adus inca in/atasat de cache
			 * */
			//if (!entityManager.contains(activitate.getProiect()))
			entityManager.merge(liniePlanAprov.getPlanAProv());
			
			//if (!entityManager.contains(proiect))
			if (liniePlanAprov.getNrLiniePlanAprov() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(liniePlanAprov.getClass(), liniePlanAprov.getNrLiniePlanAprov()) == null)
				entityManager.persist(liniePlanAprov);
			else
				entityManager.merge(liniePlanAprov);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return liniePlanAprov;
	}	
	
	public void refreshPlanAprov(PlanAprov planAprov){
		entityManager.refresh(planAprov);
	}
}
