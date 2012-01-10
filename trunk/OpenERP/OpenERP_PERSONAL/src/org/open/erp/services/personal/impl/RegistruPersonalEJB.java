package org.open.erp.services.personal.impl;


import java.util.Collection;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;


import javax.persistence.EntityManager;


import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.CV;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.DosarAngajat;
import org.open.erp.services.personal.InterviuCandidat;

import org.open.erp.services.personal.AnuntLocMunca;
import org.open.erp.services.personal.CV;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.Activitate;
import org.open.erp.services.personal.DosarAngajat;
import org.open.erp.services.personal.DummyDepartament;
import org.open.erp.services.personal.Functie;
import org.open.erp.services.personal.ProbaEvaluare;
import org.open.erp.services.personal.RezultatProbaEvaluare;
import org.open.erp.services.personal.logger.PersonalLogger;

public class RegistruPersonalEJB {
	PersonalLogger logger = new PersonalLogger();

	/* set up */
	private EntityManager entityManager;
	public RegistruPersonalEJB(EntityManager em) {
		entityManager = em;
	}


	public Collection<ContractMunca> getListaContracteAngajatEJB(Angajat angajat_) throws Exception {
		try
		{
			return   entityManager.createQuery("SELECT c FROM  ContractMunca c where c.angajat = :angajat_")
					.setParameter("angajat_",angajat_)
					.getResultList();
		}
		catch(Exception ex)
		{
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		
	}
	
	public Collection<CV> getListaCVuriCandidatEJB(Candidat candidat_) throws Exception {
		try
		{
			return  entityManager.createQuery("SELECT c FROM  CV c INNER JOIN  Candidat cn  WHERE c.idCandidat = :cn.idCandidat AND cn.idCandidat = :idcandidat_")
					.setParameter("idcandidat_",candidat_.getIdCandidat())
					.getResultList();
		}
		catch(Exception ex)
		{
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		
	}
	
	

	public Collection<ProbaEvaluare> getProbaEvaluarePeDepartament(DummyDepartament departament_) throws Exception{
		try{
			return entityManager.createQuery("SELECT pe FROM ProbaEvaluare pe " +
											"WHERE pe.departament = :departament AND pe.scop = 'EvaluarePeriodica'")
											.setParameter("departament", departament_)
											.getResultList();
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());		
			throw ex;
		}
	}
	
	public Collection<RezultatProbaEvaluare> getRezultateProbaEvaluare(ProbaEvaluare probaEvaluare_) throws Exception{
		try{
			return entityManager.createQuery("SELECT rpe FROM RezultatProbaEvaluare rpe " +
											"WHERE rpe.probaEvaluare = :probaEvaluare")
											.setParameter("probaEvaluare", probaEvaluare_)
											.getResultList();
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());		
			throw ex;
		}
	}


	
	public Collection<CV> getCVuriPeAnuntLocMunca(AnuntLocMunca anuntMunca_) throws Exception{
		try{
			return entityManager.createQuery("SELECT cv FROM CV cv " +
											"WHERE cv.idFunctie = :idFunctie")
											.setParameter("idFunctie", anuntMunca_.getFunctie().getIdFunctie())
											.getResultList();
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());		
			throw ex;
		}
	}
	public Collection<ContractMunca> getContracteMuncaPeFunctie(Functie functie_) throws Exception{
		try{
			return entityManager.createQuery("SELECT cm FROM ContractMunca cm " +
											"WHERE cm.idFunctie = :idFunctie")
											.setParameter("idFunctie", functie_.getIdFunctie())
											.getResultList();
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());		
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
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());		
			throw ex;
		}		
	}



}

