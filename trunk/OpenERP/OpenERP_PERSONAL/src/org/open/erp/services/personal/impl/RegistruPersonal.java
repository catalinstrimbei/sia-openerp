package org.open.erp.services.personal.impl;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.open.erp.services.personal.ActivitateTeamBuilding;
import org.open.erp.services.personal.ActivitateTraining;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.AnuntLocMunca;
import org.open.erp.services.personal.CV;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.CerereDemisie;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.DosarAngajat;
import org.open.erp.services.personal.DummyDepartament;
import org.open.erp.services.personal.Eveniment;
import org.open.erp.services.personal.Functie;
import org.open.erp.services.personal.Instructor;
import org.open.erp.services.personal.Interviu;
import org.open.erp.services.personal.InterviuCandidat;
import org.open.erp.services.personal.ProbaEvaluare;
import org.open.erp.services.personal.RezultatProbaEvaluare;
import org.open.erp.services.personal.logger.PersonalLogger;

public class RegistruPersonal {

	PersonalLogger logger = new PersonalLogger();
	
	/* set up */
	private EntityManager entityManager;
	public RegistruPersonal(EntityManager em) {
		entityManager = em;
	}

	/* interogari */

	
	
	ActivitateTeamBuilding				getActivitateTeamBuildingById(Integer idActivitate_) throws Exception 
	{
		try
		{
			return entityManager.find(ActivitateTeamBuilding.class, idActivitate_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	Collection<ActivitateTeamBuilding>	getListaActivitatiTeamBuilding() throws Exception 
	{
		try
		{
			return entityManager.createQuery("SELECT x FROM ActivitateTeamBuilding x").getResultList();
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	ActivitateTeamBuilding				salveazaActivitateTeamBuilding(ActivitateTeamBuilding activitate_) throws Exception 
	{
		try
		{		
			if (activitate_.getIdActivitate() == null ||
				entityManager.find(activitate_.getClass(), activitate_.getIdActivitate()) == null)
				entityManager.persist(activitate_);
			else
				entityManager.merge(activitate_);	
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return activitate_;
	}

	void								stergeActivitateTeamBuilding(ActivitateTeamBuilding activitate_) throws Exception
	{
		try
		{
			entityManager.remove(activitate_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	
	ActivitateTraining				getActivitateTrainingById(Integer idActivitate_) throws Exception
	{
		try
		{
			return entityManager.find(ActivitateTraining.class, idActivitate_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	Collection<ActivitateTraining>	getListaActivitatiTraining() throws Exception
	{
		try
		{
			return entityManager.createQuery("SELECT x FROM ActivitateTraining x").getResultList();
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	ActivitateTraining				salveazaActivitateTraining(ActivitateTraining activitate_) throws Exception
	{
		try
		{		
			if (activitate_.getIdActivitate() == null ||
				entityManager.find(activitate_.getClass(), activitate_.getIdActivitate()) == null)
				entityManager.persist(activitate_);
			else
				entityManager.merge(activitate_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return activitate_;
	}
	
	void							stergeActivitateTraining(ActivitateTraining activitate_) throws Exception
	{
		try
		{
			entityManager.remove(activitate_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	
	Angajat							getAngajatById(Integer idAngajat_) throws Exception
	{
		try
		{
			return entityManager.find(Angajat.class, idAngajat_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	Angajat							getAngajatByMarca(Integer marca_) throws Exception
	{
		try
		{
			return (Angajat) entityManager.createQuery("SELECT x FROM Angajat x WHERE x.marca == :marcaAng AND rownum <= 1").setParameter("marcaAng", marca_).getSingleResult();
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	Collection<Angajat>				getListaAngajati() throws Exception
	{
		try
		{
			return entityManager.createQuery("SELECT x FROM Angajat x").getResultList();
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	Angajat							salveazaAngajat(Angajat angajat_) throws Exception
	{
		logger.logINFO("Am intrat pe  salveazaAngajat in RegistruPersonal" );
		try
		{		
			logger.logINFO("Am intrat pe  try in salveazaAngajat in RegistruPersonal" );
			if (angajat_.getMarca() == null ||
				entityManager.find(angajat_.getClass(), angajat_.getMarca()) == null)
				entityManager.persist(angajat_);
			else
				entityManager.merge(angajat_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return angajat_;
	}

	void							stergeAngajat(Angajat angajat_) throws Exception
	{
		try
		{
			entityManager.remove(angajat_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
							
	AnuntLocMunca				getAnuntLocMuncaById(Integer idAnunt_) throws Exception
	{
		try
		{
			return entityManager.find(AnuntLocMunca.class, idAnunt_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}

	Collection<AnuntLocMunca>	getListaAnunturiLocMunca() throws Exception
	{
		try
		{
			return entityManager.createQuery("SELECT x FROM AnuntLocMunca x").getResultList();
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}

	AnuntLocMunca				salveazaAnuntLocMunca(AnuntLocMunca anunt_) throws Exception
	{
		try
		{		
			if (anunt_.getIdAnunt() == null ||
				entityManager.find(anunt_.getClass(), anunt_.getIdAnunt()) == null)
				entityManager.persist(anunt_);
			else
				entityManager.merge(anunt_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return anunt_;
	}

	void							stergeAnuntLocMunca(AnuntLocMunca anunt_) throws Exception
	{
		try
		{
			entityManager.remove(anunt_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	

	//Andreea
		public Candidat getCandidatById(Integer id) throws Exception{
			try{
				return entityManager.find(Candidat.class, id);
			}catch(Exception ex){
				logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
				logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
				ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
				throw ex;
			}
		}
	public Candidat getCandidatByIdCandidat(Integer idCandidat) throws Exception{
		try{
			return (Candidat) entityManager.createQuery("SELECT c FROM Candidat c WHERE c.idCandidat = :idCandidat")
					.setParameter("idCandidat", idCandidat)
					.getSingleResult();
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	public Collection<Candidat> getListaCandidatilor() throws Exception{		
		try{
			return entityManager.createQuery("SELECT c FROM Candidat c").getResultList();
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	public Collection<Candidat> getCandidatiPeFunctie(Integer idFunctie) throws Exception{
		try{
			return entityManager.createQuery("SELECT C FROM Candidat c, CV cv WHERE " +
										" cv.functieVizata.idFunctie = :idFunctie AND cv.candidat.idCandidat = c.idCandidat")
										.setParameter("idFunctie", idFunctie)
										.getResultList();
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	/* persistenta */
	public Candidat salveazaCandidat(Candidat candidat) throws Exception{
		try{

			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (candidat.getIdCandidat() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(candidat.getClass(), candidat.getIdCandidat()) == null)
				entityManager.persist(candidat);
			else
				entityManager.merge(candidat);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return candidat;
	}
	
    //Narcisa 
	public Eveniment getEvenimentById(Integer idEveniment_) throws Exception
	{
		try{
			return entityManager.find(Eveniment.class, idEveniment_);
		
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		
	}
	
	public Collection<Eveniment> getListaEvenimente() throws Exception
	{
		try{
			return entityManager.createQuery("SELECT e from Eveniment e").getResultList();
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;	
		}
	}	
	
	public Eveniment salveazaEveniment(Eveniment eveniment_) throws Exception 
	{
		try{
			if (eveniment_.getIdEveniment() == null || 
				entityManager.find(eveniment_.getClass(), eveniment_.getIdEveniment()) == null)
				entityManager.persist(eveniment_);
			else
				entityManager.merge(eveniment_);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return eveniment_;		
	}
	
	public void stergeEveniment(Eveniment eveniment_) throws Exception
	{
		try
		{
			entityManager.remove(eveniment_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}


	public Functie getFunctieById(Integer idFunctie_) throws Exception
	{
		try{
			return entityManager.find(Functie.class, idFunctie_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}		
	
	public Collection<Functie> getListaFunctii() throws Exception{
		try{
			return entityManager.createQuery("SELECT f FROM Functie f").getResultList();
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}		
	
	public Functie salveazaFunctie(Functie functie_) throws Exception{
		logger.logINFO("Am intrat pe  salveazaFunctie in RegistruPersonal" );
		try{			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (functie_.getIdFunctie() == null || 
				entityManager.find(functie_.getClass(), functie_.getIdFunctie()) == null)
				entityManager.persist(functie_);
			else
				entityManager.merge(functie_);
			
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());			
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return functie_;
	}

	public void stergeFunctie(Functie functie_) throws Exception
	{
		try
		{
			entityManager.remove(functie_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	//Instructor
	public Instructor getInstructorById(Integer idInstructor_) throws Exception
	{
		try
		{
			return entityManager.find(Instructor.class, idInstructor_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}		

	public Collection<Instructor> getListaInstructori() throws Exception
	{
		try{
			return entityManager.createQuery("SELECT i from Instructor i").getResultList();	
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}		
	}
		
	public Instructor salveazaInstructor(Instructor instructor_) throws Exception 
	{
		try{
			if (instructor_.getId() == null || 
				entityManager.find(instructor_.getClass(), instructor_.getId()) == null)
				entityManager.persist(instructor_);
			else
				entityManager.merge(instructor_);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return instructor_;		
	}	
	
	public void stergeInstructor(Instructor instructor) throws Exception
	{
		try{
			entityManager.remove(instructor);		
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
		
	
	public Interviu getInterviuById(Integer idInterviu_) throws Exception
	{
		try{
			return entityManager.find(Interviu.class, idInterviu_);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	public Collection<Interviu> getListaInterviuri() throws Exception
	{
		try{
			return entityManager.createQuery("SELECT i from Interviu i").getResultList();
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}	
	}
	
	public Interviu salveazaInterviu(Interviu interviu_) throws Exception 
	{
		try{
			if (interviu_.getIdInterviu() == null || 
				entityManager.find(interviu_.getClass(), interviu_.getIdInterviu()) == null)
				entityManager.persist(interviu_);
			else
				entityManager.merge(interviu_);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return interviu_;		
	}	
	
	public void stergeInterviu(Interviu interviu)
	{
		entityManager.remove(interviu);
	}

	//begin 
	
	//InterviuCandidat
	
	public InterviuCandidat getInterviuCandidatById(Integer idInterviuCandidat_) throws Exception{
		try
		{
			return (InterviuCandidat) entityManager.createQuery("SELECT ic FROM InterviuCandidat ic WHERE ic.idInterviuCandidat = :idInterviuCandidat")
					.setParameter("idInterviuCandidat",idInterviuCandidat_)
					.getSingleResult();
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		
	}
	
	public Collection<InterviuCandidat> getListaInterviuCandidat() throws Exception{
		try
		{
			return entityManager.createQuery("SELECT ic InterviuCandidat ic").getResultList();
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	
	public InterviuCandidat salveazaInterviuCandidat(InterviuCandidat interviuCandidat_) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (interviuCandidat_.getIdInterviuCandidat() == null || 
				entityManager.find(interviuCandidat_.getClass(), interviuCandidat_.getIdInterviuCandidat()) == null)
				entityManager.persist(interviuCandidat_);
			else
				entityManager.merge(interviuCandidat_);
			
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return interviuCandidat_;
	}
	
	public void stergeInterviuCandidat(InterviuCandidat interviuCandidat_) throws Exception{
		try
		{
			entityManager.remove(interviuCandidat_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	//ProbaEvaluare
	
	public ProbaEvaluare getProbaEvaluareById(Integer idProbaEvaluare_) throws Exception{
		try
		{
			return (ProbaEvaluare) entityManager.createQuery("SELECT pe FROM ProbaEvaluare pe WHERE pe.idProba = :idProbaEvaluare_")
					.setParameter("idProbaEvaluare",idProbaEvaluare_)
					.getSingleResult();		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
		
	
	
	public Collection<ProbaEvaluare> getListaProbaEvaluare() throws Exception {
		try
		{
			return entityManager.createQuery("SELECT pe FROM ProbaEvaluare pe").getResultList();
	}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	
	public ProbaEvaluare salveazaProbaEvaluare(ProbaEvaluare probaEvaluare_) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (probaEvaluare_.getIdProba() == null || 
				entityManager.find(probaEvaluare_.getClass(), probaEvaluare_.getIdProba()) == null)
				entityManager.persist(probaEvaluare_);
			else
				entityManager.merge(probaEvaluare_);
			
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return probaEvaluare_;
	}
	
	public void stergeProbaEvaluare(ProbaEvaluare probaEvaluare_) throws Exception{
		try
		{
			entityManager.remove(probaEvaluare_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	
	// RezultatProbaEvaluare
	
	public RezultatProbaEvaluare getRezultatProbaEvaluareById(Integer id_) throws Exception{
		try
		{
			return (RezultatProbaEvaluare) entityManager.createQuery("SELECT rb FROM RezultatProbaEvaluare rb WHERE rb.id = :id_")
					.setParameter("id",id_)
					.getSingleResult();}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		
	}
	
	public Collection<RezultatProbaEvaluare> getListaRezultatProbaEvaluare() throws Exception{
		try
		{
			return entityManager.createQuery("SELECT rb FROM RezultatProbaEvaluare rb").getResultList();
}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	
	public RezultatProbaEvaluare salveazaRezultatProbaEvaluare(RezultatProbaEvaluare rezultatProbaEvaluare_) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (rezultatProbaEvaluare_.getId() == null || 
				entityManager.find(rezultatProbaEvaluare_.getClass(), rezultatProbaEvaluare_.getId()) == null)
				entityManager.persist(rezultatProbaEvaluare_);
			else
				entityManager.merge(rezultatProbaEvaluare_);
			
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return rezultatProbaEvaluare_;
	}
	
	public void stergeRezultatProbaEvaluare (RezultatProbaEvaluare rezultatProbaEvaluare_) throws Exception{
		try
		{
			entityManager.remove(rezultatProbaEvaluare_);
		}
		catch(Exception ex)
		{
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
		

	public void stergeCandidat(Candidat candidat) throws Exception{

		try{
			entityManager.remove(candidat);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}	
	}
	
	public void refreshCandidat(Candidat candidat) throws Exception{
		try{
			entityManager.refresh(candidat);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	
	//nu stiu daca este bine aici - ramane de discutat
	public CV salveazaCVCandidat(
			CV cv) throws Exception{
		logger.logDEBUG("--De salvat CV cu ID: " + cv.getNrCV());
		try{
			
			//if (!entityManager.contains(activitate.getProiect()))
			entityManager.merge(cv.getCandidat());
			
			//if (!entityManager.contains(proiect))
			if (cv.getNrCV() == null || 
				entityManager.find(cv.getClass(), cv.getNrCV()) == null)
				entityManager.persist(cv);
			else
				entityManager.merge(cv);
			
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		
		return cv;
	}

	
	
	//CerereDemisie
	public CerereDemisie getCerereDemisieById(Integer id) throws Exception{
		try{
			return entityManager.find(CerereDemisie.class, id);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	public Collection<CerereDemisie> getListaCererilorDeDemisie() throws Exception{
		try{
			return entityManager.createQuery("SELECT cd FROM CerereDemisie cd").getResultList();
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	/* persistenta */
	public CerereDemisie salveazaCerereDemisie(CerereDemisie cerereDemisie) throws Exception{
		try{

			if (cerereDemisie.getNrInregistrare() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(cerereDemisie.getClass(), cerereDemisie.getNrInregistrare()) == null)
				entityManager.persist(cerereDemisie);
			else
				entityManager.merge(cerereDemisie);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return cerereDemisie;
	}
	public void stergeCerereDemisie(CerereDemisie cerereDemisie) throws Exception{
		try{
			entityManager.remove(cerereDemisie);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	//CerereDemisie.end
	
	//ContractMunca.start
	public ContractMunca getContractMuncaById(Integer id) throws Exception{
		try{
			return entityManager.find(ContractMunca.class, id);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	public Collection<ContractMunca> getListaContracteMunca() throws Exception{
		try{
			return entityManager.createQuery("SELECT cm FROM ContractMunca cm").getResultList();
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	/* persistenta */
	public ContractMunca salveazaContractMunca(ContractMunca contractMunca) throws Exception{
		try{

			if (contractMunca.getNrContract() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(contractMunca.getClass(), contractMunca.getNrContract()) == null)
				entityManager.persist(contractMunca);
			else
				entityManager.merge(contractMunca);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return contractMunca;
	}
	public void stergeContractMunca(ContractMunca contractMunca) throws Exception{
		try{
			entityManager.remove(contractMunca);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	//ContractMunca.end
	
	//CV.start
	public CV getCVById(Integer id) throws Exception{
		try{
			return entityManager.find(CV.class, id);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	public Collection<CV> getListaCVuri() throws Exception{
		try{
			return entityManager.createQuery("SELECT cv FROM CV cv").getResultList();
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	/* persistenta */
	public CV salveazaCV(CV cv) throws Exception{
		try{

			if (cv.getNrCV() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(cv.getClass(), cv.getNrCV()) == null)
				entityManager.persist(cv);
			else
				entityManager.merge(cv);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return cv;
	}
	public void stergeCV(CV cv) throws Exception{
		try{
			entityManager.remove(cv);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	//CV.end
	
	//DosarAngajat.start
	public DosarAngajat getDosarAngajatById(Integer id) throws Exception{
		try{
			return entityManager.find(DosarAngajat.class, id);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	public Collection<DosarAngajat> getListaDosareAngajat() throws Exception{
		try{
			return entityManager.createQuery("SELECT da FROM DosarAngajat da").getResultList();
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
	/* persistenta */
	public DosarAngajat salveazaDosarAngajat(DosarAngajat dosarAngajat) throws Exception{
		try{

			if (dosarAngajat.getIdDosar() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(dosarAngajat.getClass(), dosarAngajat.getIdDosar()) == null)
				entityManager.persist(dosarAngajat);
			else
				entityManager.merge(dosarAngajat);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
		return dosarAngajat;
	}
	public void stergeDosarAngajat(DosarAngajat dosarAngajat) throws Exception{
		try{
			entityManager.remove(dosarAngajat);
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());			
			throw ex;
		}
	}

	//TODO - to be deleted
	public Collection<DummyDepartament> getListaDepartamente() throws Exception{
		try{
			return entityManager.createQuery("SELECT d FROM DummyDepartament d").getResultList();
		}catch(Exception ex){
			logger.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[2].getMethodName());
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   PersonalLogger.trace(logger, ex.getStackTrace());
			throw ex;
		}
	}
	
}

