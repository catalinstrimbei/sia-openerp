package org.open.erp.services.personal.impl;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.open.erp.services.personal.ActivitateTeamBuilding;
import org.open.erp.services.personal.ActivitateTraining;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.AnuntLocMunca;
import org.open.erp.services.personal.CV;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.Functie;
import org.open.erp.services.personal.logger.PersonalLogger;

public class RegistruPersonal {

private static PersonalLogger logger ;	
	
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
	}
	
	Angajat							salveazaAngajat(Angajat angajat_) throws Exception
	{
		try
		{		
			if (angajat_.getMarca() == null ||
				entityManager.find(angajat_.getClass(), angajat_.getMarca()) == null)
				entityManager.persist(angajat_);
			else
				entityManager.merge(angajat_);
		}
		catch(Exception ex)
		{
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
	}
	
	
	public Candidat getCandidat(Integer id){
		return entityManager.find(Candidat.class, id);
	}
	
	public Collection<Candidat> getListaCandidatilor(){
		return entityManager.createQuery("SELECT c FROM Candidat c").getResultList();
	}
	
	public Collection<Candidat> getCandidatiPeFunctie(Integer idFunctie){
		return entityManager.createQuery("SELECT C FROM Candidat c, CV cv WHERE " +
										" cv.functieVizata.idFunctie = :idFunctie AND cv.candidat.idCandidat = c.idCandidat")
										.setParameter("idFunctie", idFunctie)
										.getResultList();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return candidat;
	}
	
	public Functie salveazaFunctie(Functie functie) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (functie.getIdFunctie() == null || 
				entityManager.find(functie.getClass(), functie.getIdFunctie()) == null)
				entityManager.persist(functie);
			else
				entityManager.merge(functie);
			
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return functie;
	}
	public void stergeCandidat(Candidat candidat){
		entityManager.remove(candidat);
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		
		return cv;
	}

	
	public void refreshCandidat(Candidat candidat){
		entityManager.refresh(candidat);
	}
	
	
	
	//FUNCTIE
	
	public Collection<Functie> getListaFunctii(){
		return entityManager.createQuery("SELECT f FROM Functie f").getResultList();
	}
	
	public Functie getFunctieById(Integer idFunctie){
		return (Functie) entityManager.createQuery("SELECT f FROM Functie f WHERE f.idFunctie = :idFunctie")
							.setParameter("idFunctie",idFunctie)
							.getSingleResult();
	}
}
