package org.open.erp.services.personal.impl;

import java.util.List;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;

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
	public Candidat getCandidat(Integer id){
		return entityManager.find(Candidat.class, id);
	}
	
	public List<Candidat> getListaCandidatilor(){
		return entityManager.createQuery("SELECT c FROM Candidat c").getResultList();
	}
	
	public List<Candidat> getCandidatiPeFunctie(Integer idFunctie){
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
	
}
