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
	
	

	//Andreea
		public Candidat getCandidatById(Integer id) throws Exception{
			try{
				return entityManager.find(Candidat.class, id);
			}catch(Exception ex){
				logger.logINFO("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
		}
	public Candidat getCandidatByIdCandidat(Integer idCandidat) throws Exception{
		try{
			return (Candidat) entityManager.createQuery("SELECT c FROM Candidat c WHERE c.idCandidat = :idCandidat")
					.setParameter("idCandidat", idCandidat)
					.getSingleResult();
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public Collection<Candidat> getListaCandidatilor() throws Exception{		
		try{
			return entityManager.createQuery("SELECT c FROM Candidat c").getResultList();
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return candidat;
	}
	
	public void stergeCandidat(Candidat candidat) throws Exception{
		try{
			entityManager.remove(candidat);
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}	
	}
	
	public void refreshCandidat(Candidat candidat) throws Exception{
		try{
			entityManager.refresh(candidat);
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		
		return cv;
	}

	
	
	//CerereDemisie
	public CerereDemisie getCerereDemisieById(Integer id) throws Exception{
		try{
			return entityManager.find(CerereDemisie.class, id);
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public Collection<Candidat> getListaCererilorDeDemisie() throws Exception{
		try{
			return entityManager.createQuery("SELECT cd FROM CerereDemisie cd").getResultList();
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return cerereDemisie;
	}
	public void stergeCerereDemisie(CerereDemisie cerereDemisie) throws Exception{
		try{
			entityManager.remove(cerereDemisie);
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
	}
	//CerereDemisie.end
	
	//ContractMunca.start
	public ContractMunca getContractMuncaById(Integer id) throws Exception{
		try{
			return entityManager.find(ContractMunca.class, id);
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public Collection<Candidat> getListaContracteMunca() throws Exception{
		try{
			return entityManager.createQuery("SELECT cm FROM ContractMunca cm").getResultList();
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return contractMunca;
	}
	public void stergeContractMunca(ContractMunca contractMunca) throws Exception{
		try{
			entityManager.remove(contractMunca);
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
	}
	//ContractMunca.end
	
	//CV.start
	public CV getCVById(Integer id) throws Exception{
		try{
			return entityManager.find(CV.class, id);
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public Collection<Candidat> getListaCVuri() throws Exception{
		try{
			return entityManager.createQuery("SELECT cv FROM CV cv").getResultList();
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return cv;
	}
	public void stergeCV(CV cv) throws Exception{
		try{
			entityManager.remove(cv);
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
	}
	//CV.end
	
	//DosarAngajat.start
	public DosarAngajat getDosarAngajatById(Integer id) throws Exception{
		try{
			return entityManager.find(DosarAngajat.class, id);
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public Collection<Candidat> getListaDosareAngajat() throws Exception{
		try{
			return entityManager.createQuery("SELECT da FROM DosarAngajat da").getResultList();
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
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
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return dosarAngajat;
	}
	public void stergeDosarAngajat(DosarAngajat dosarAngajat) throws Exception{
		try{
			entityManager.remove(dosarAngajat);
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
	}
	//DosarAngajat.start

	
	//FUNCTIE
	
	public Collection<Functie> getListaFunctii() throws Exception{
		try{
			return entityManager.createQuery("SELECT f FROM Functie f").getResultList();
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public Functie getFunctieById(Integer idFunctie) throws Exception{
		try{
			return (Functie) entityManager.createQuery("SELECT f FROM Functie f WHERE f.idFunctie = :idFunctie")
							.setParameter("idFunctie",idFunctie)
							.getSingleResult();
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
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

	
}

