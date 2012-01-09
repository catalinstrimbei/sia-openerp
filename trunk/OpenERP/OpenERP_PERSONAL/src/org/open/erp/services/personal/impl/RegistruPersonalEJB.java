package org.open.erp.services.personal.impl;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.open.erp.services.personal.Activitate;
import org.open.erp.services.personal.DosarAngajat;
import org.open.erp.services.personal.DummyDepartament;
import org.open.erp.services.personal.ProbaEvaluare;
import org.open.erp.services.personal.RezultatProbaEvaluare;
import org.open.erp.services.personal.logger.PersonalLogger;

public class RegistruPersonalEJB {
	private static PersonalLogger logger ;	

	/* set up */
	private EntityManager entityManager;
	public RegistruPersonalEJB(EntityManager em) {
		entityManager = em;
	}

	public Collection<ProbaEvaluare> getProbaEvaluarePeDepartament(DummyDepartament departament_) throws Exception{
		try{
			return entityManager.createQuery("SELECT pe FROM ProbeEvaluare pe " +
											"WHERE pe.departament = :departament AND pe.scop = 'EvaluarePeriodica'")
											.setParameter("departament", departament_).
											getResultList();
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public Collection<RezultatProbaEvaluare> getRezultateProbaEvaluare(ProbaEvaluare probaEvaluare_) throws Exception{
		try{
			return entityManager.createQuery("SELECT rpe FROM RezultatProbeEvaluare rpe " +
											"WHERE rpe.probaEvaluare = :probaEvaluare")
											.setParameter("probaEvaluare", probaEvaluare_).
											getResultList();
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public Collection<Activitate> getActivitatiByEvenimentEJB(Integer IdEveniment) throws Exception	{
		try
		{
			return entityManager.createQuery("SELECT a FROM Activitate a WHERE"+ 
					"a.eveniment.IdEveniment =:idEveniment")
					.setParameter("IdEveniment", IdEveniment)
					.getResultList();
		}
		catch(Exception ex)
		{
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}		
	}


}
