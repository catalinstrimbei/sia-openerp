package org.open.erp.services.personal.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import org.open.erp.services.buget.Buget;
//import org.open.erp.services.buget.BugetareSrv;
//import org.open.erp.services.buget.LinieBugetara;
//TODO uncomment this
//import org.open.erp.services.nomgen.Departament;
//import org.open.erp.services.nomgen.NomenclatoareSrvLocal;
//import org.open.erp.services.personal.Activitate;
//import org.open.erp.services.personal.Proiect;
import org.open.erp.services.personal.Activitate;
import org.open.erp.services.personal.ActivitateTeamBuilding;
import org.open.erp.services.personal.ActivitateTraining;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.Instructor;
import org.open.erp.services.personal.Interviu;
import org.open.erp.services.personal.RezultatProbaEvaluare;
import org.open.erp.services.personal.AnuntLocMunca;
import org.open.erp.services.personal.CV;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.CerereDemisie;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.DosarAngajat;
import org.open.erp.services.personal.Eveniment;
import org.open.erp.services.personal.Functie;
import org.open.erp.services.personal.InterviuCandidat;
import org.open.erp.services.personal.PersonalSrvLocal;
import org.open.erp.services.personal.PersonalSrvRemote;
import org.open.erp.services.personal.ProbaEvaluare;
import org.open.erp.services.personal.DummyDepartament;
import org.open.erp.services.personal.logger.PersonalExceptions;
import org.open.erp.services.personal.logger.PersonalLogger;
import org.open.erp.services.personal.teste.TestPersonalImpl;

/**
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */
@Stateful(name="PersonalSrv")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonalImpl implements PersonalSrvLocal, PersonalSrvRemote{	

	final static long MILLIS_PER_DAY = 24 * 3600 * 1000;
	DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
	
	PersonalLogger logger = new PersonalLogger();
	private RegistruPersonal	registruPersonal;
	private RegistruPersonalEJB	registruPersonalEJB;
	/* Dependente resurse injectate */
	@PersistenceContext(unitName="OpenERP_PERSONAL")
	private EntityManager em;
	@Resource
	private SessionContext sessionContext;	
	
	//@EJB(mappedName="NomenclatoareDummyImpl/local") /* BUG JBoss 5 referinte EJB: de folosit mappedName */
	//private NomenclatoareSrvLocal nomGenSrv;
	
	/* Initializare */
	public PersonalImpl() { }	
	@PostConstruct
	public void init(){
		logger.logDEBUG(">>>>>>>>>>>> EM = " + em);		
		//logger.logDEBUG(">>>>>>>>>>>> Exista nomGenSrv? " + nomGenSrv);				
		
		if (this.registruPersonal == null)
			registruPersonal = new RegistruPersonal(em);
		
		if (this.registruPersonalEJB == null)
			registruPersonalEJB = new RegistruPersonalEJB(em);
	}
		
	//ActivitateTeamBuilding
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ActivitateTeamBuilding getActivitateTeamBuildingById(
			Integer idActivitate_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getActivitateTeamBuildingById");
		ActivitateTeamBuilding result = new ActivitateTeamBuilding();
		if (idActivitate_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.getActivitateTeamBuildingById(idActivitate_);
			
			logger.logDEBUG(">>>>>>End getActivitateTeamBuildingById");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<ActivitateTeamBuilding> getListaActivitatiTeamBuilding()
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getListaActivitatiTeamBuilding");
		Collection<ActivitateTeamBuilding> result = this.registruPersonal.getListaActivitatiTeamBuilding();
		logger.logDEBUG(">>>>>>End getListaActivitatiTeamBuilding");
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ActivitateTeamBuilding salveazaActivitateTeamBuilding(
			ActivitateTeamBuilding activitate_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start salveazaActivitateTeamBuilding");
		ActivitateTeamBuilding result = new ActivitateTeamBuilding();
		if (activitate_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.salveazaActivitateTeamBuilding(activitate_);
			logger.logDEBUG(">>>>>>End salveazaActivitateTeamBuilding");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void stergeActivitateTeamBuilding(ActivitateTeamBuilding activitate_)
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start stergeActivitateTeamBuilding");
		if (activitate_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeActivitateTeamBuilding(activitate_);
			logger.logDEBUG(">>>>>>End stergeActivitateTeamBuilding");
		}		
	}
	
	//ActivitateTraining
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ActivitateTraining getActivitateTrainingById(Integer idActivitate_)
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getActivitateTrainingById");
		ActivitateTraining result = new ActivitateTraining();
		if (idActivitate_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.getActivitateTrainingById(idActivitate_);
			
			logger.logDEBUG(">>>>>>End getActivitateTrainingById");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<ActivitateTraining> getListaActivitatiTraining()
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getListaActivitatiTraining");
		Collection<ActivitateTraining> result = this.registruPersonal.getListaActivitatiTraining();
		logger.logDEBUG(">>>>>>End getListaActivitatiTraining");
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ActivitateTraining salveazaActivitateTraining(
			ActivitateTraining activitate_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start salveazaActivitateTraining");
		ActivitateTraining result = new ActivitateTraining();
		if (activitate_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.salveazaActivitateTraining(activitate_);
			logger.logDEBUG(">>>>>>End salveazaActivitateTraining");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void stergeActivitateTraining(ActivitateTraining activitate_)
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start stergeActivitateTraining");
		if (activitate_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeActivitateTraining(activitate_);
			logger.logDEBUG(">>>>>>End stergeActivitateTraining");
		}	
	}
	
	//Angajat
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Angajat getAngajatByMarca(Integer marca_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getAngajatById");
		Angajat result = new Angajat();
		if (marca_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.getAngajatById(marca_);
			
			logger.logDEBUG(">>>>>>End getAngajatById");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Angajat getAngajatById(Integer id_) throws Exception{
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getAngajatById");
		Angajat result = new Angajat();
		if (id_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.getAngajatById(id_);
			
			logger.logDEBUG(">>>>>>End getAngajatById");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<Angajat> getListaAngajati() throws Exception{
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getListaAngajati");
		Collection<Angajat> result = this.registruPersonal.getListaAngajati();
		logger.logDEBUG(">>>>>>End getListaAngajati");
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Angajat salveazaAngajat(Angajat angajat_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start salveazaAngajat");
		Angajat result = new Angajat();
		if (angajat_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.salveazaAngajat(angajat_);
			logger.logDEBUG(">>>>>>End salveazaAngajat");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void stergeAngajat(Angajat angajat_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start stergeAngajat");
		if (angajat_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeAngajat(angajat_);
			logger.logDEBUG(">>>>>>End stergeAngajat");
		}	
	}
	
	//AnuntLocMunca
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public AnuntLocMunca getAnuntLocMuncaById(Integer idAnunt_)
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getAnuntLocMuncaById");
		AnuntLocMunca result = new AnuntLocMunca();
		if (idAnunt_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.getAnuntLocMuncaById(idAnunt_);
			
			logger.logDEBUG(">>>>>>End getAnuntLocMuncaById");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<AnuntLocMunca> getListaAnunturiLocMunca()
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getListaAnunturiLocMunca");
		Collection<AnuntLocMunca> result = this.registruPersonal.getListaAnunturiLocMunca();
		logger.logDEBUG(">>>>>>End getListaAnunturiLocMunca");
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public AnuntLocMunca salveazaAnuntLocMunca(AnuntLocMunca anunt_)
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start salveazaAnuntLocMunca");
		AnuntLocMunca result = new AnuntLocMunca();
		if (anunt_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.salveazaAnuntLocMunca(anunt_);
			logger.logDEBUG(">>>>>>End salveazaAnuntLocMunca");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void stergeAnuntLocMunca(AnuntLocMunca anunt_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start stergeAnuntLocMunca");
		if (anunt_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeAnuntLocMunca(anunt_);
			logger.logDEBUG(">>>>>>End stergeAnuntLocMunca");
		}
	}
	
	//Candidat
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Candidat getCandidatById(Integer idPersoanaCandidat_) throws Exception{
	// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getCandidatById");
		Candidat result = new Candidat();
		if (idPersoanaCandidat_ == null){					
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.getCandidatById(idPersoanaCandidat_);
			
			logger.logDEBUG(">>>>>>End getCandidatById");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Candidat getCandidatByIdCandidat(Integer idCandidat_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getCandidatByIdCandidat");
		Candidat result = new Candidat();
		if (idCandidat_ == null){					
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.getCandidatByIdCandidat(idCandidat_);
			
			logger.logDEBUG(">>>>>>End getCandidatByIdCandidat");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<Candidat> getListaCandidati() throws Exception {
		logger.logDEBUG(">>>>>>Start getListaCandidati");
		Collection<Candidat> result = this.registruPersonal.getListaCandidatilor();
		logger.logDEBUG(">>>>>>End getListaCandidati");
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Candidat salveazaCandidat(Candidat candidat_) throws Exception {
		logger.logDEBUG(">>>>>>Start salveazaCandidat");
		Candidat result = new Candidat();
		if (candidat_ == null){				
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.salveazaCandidat(candidat_);
			logger.logDEBUG(">>>>>>End salveazaCandidat");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void stergeCandidat(Candidat candidat_) throws Exception {
		logger.logDEBUG(">>>>>>Start stergeCandidat");
		if (candidat_ == null){					
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeCandidat(candidat_);
			logger.logDEBUG(">>>>>>End stergeCandidat");
		}	
		
	}
	
	//CerereDemisie
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public CerereDemisie getCerereDemisieById(Integer idCerereDemisie_)
			throws Exception {
		logger.logDEBUG(">>>>>>Start getCerereDemisieById");
		CerereDemisie result = new CerereDemisie();
		if (idCerereDemisie_ == null){					
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.getCerereDemisieById(idCerereDemisie_);
			
			logger.logDEBUG(">>>>>>End getCerereDemisieById");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<CerereDemisie> getListaCereriDemisie() throws Exception {
		logger.logDEBUG(">>>>>>Start getListaCereriDemisie");
		Collection<CerereDemisie> result = this.registruPersonal.getListaCererilorDeDemisie();
		logger.logDEBUG(">>>>>>End getListaCereriDemisie");
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public CerereDemisie salveazaCerereDemisie(CerereDemisie cerereDemisie_)
			throws Exception {
		logger.logDEBUG(">>>>>>Start salveazaCerereDemisie");
		CerereDemisie result = new CerereDemisie();
		if (cerereDemisie_ == null){				
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.salveazaCerereDemisie(cerereDemisie_);
			logger.logDEBUG(">>>>>>End salveazaCerereDemisie");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void stergeCerereDemisie(CerereDemisie cerereDemisie_)
			throws Exception {
		logger.logDEBUG(">>>>>>Start stergeCerereDemisie");
		if (cerereDemisie_ == null){					
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeCerereDemisie(cerereDemisie_);
			logger.logDEBUG(">>>>>>End stergeCerereDemisie");
		}	
		
	}
	
	//ContractMunca
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ContractMunca getContractMuncaById(Integer idContractMunca_)
			throws Exception {
		logger.logDEBUG(">>>>>>Start getContractMuncaById");
		ContractMunca result = new ContractMunca();
		if (idContractMunca_ == null){					
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.getContractMuncaById(idContractMunca_);
			
			logger.logDEBUG(">>>>>>End getCerereDemisieById");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<ContractMunca> getListaContracteMunca() throws Exception {
		logger.logDEBUG(">>>>>>Start getListaContracteMunca");
		Collection<ContractMunca> result = this.registruPersonal.getListaContracteMunca();
		logger.logDEBUG(">>>>>>End getListaContracteMunca");
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ContractMunca salveazaContractMunca(ContractMunca contractMunca_)
			throws Exception {
		logger.logDEBUG(">>>>>>Start salveazaContractMunca");
		ContractMunca result = new ContractMunca();
		if (contractMunca_ == null){				
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.salveazaContractMunca(contractMunca_);
			logger.logDEBUG(">>>>>>End salveazaContractMunca");
		}
		return result;
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void stergeContractMunca(ContractMunca contractMunca_)
			throws Exception {
		logger.logDEBUG(">>>>>>Start stergeContractMunca");
		if (contractMunca_ == null){					
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeContractMunca(contractMunca_);
			logger.logDEBUG(">>>>>>End stergeContractMunca");
		}	
		
	}
	
	//CV
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public CV getCVById(Integer idCV_) throws Exception {
		logger.logDEBUG(">>>>>>Start getCVById");
		CV result = new CV();
		if (idCV_ == null){					
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.getCVById(idCV_);
			
			logger.logDEBUG(">>>>>>End getCVById");
		}
		return result;
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<CV> getListaCVuri() throws Exception {
		logger.logDEBUG(">>>>>>Start getListaCVuri");
		Collection<CV> result = this.registruPersonal.getListaCVuri();
		logger.logDEBUG(">>>>>>End getListaCvuri");
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public CV salveazaCV(CV cv_) throws Exception {
		logger.logDEBUG(">>>>>>Start salveazaCV");
		CV result = new CV();
		if (cv_ == null){				
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.salveazaCV(cv_);
			logger.logDEBUG(">>>>>>End salveazaCV");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void stergeCV(CV cv_) throws Exception {
		logger.logDEBUG(">>>>>>Start stergeCV");
		if (cv_ == null){					
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeCV(cv_);
			logger.logDEBUG(">>>>>>End stergeCV");
		}	
		
	}
	
	//DosarAngajat
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public DosarAngajat getDosarAngajatById(Integer idDosarAngajat_)
			throws Exception {
		logger.logDEBUG(">>>>>>Start getDosarAngajatById");
		DosarAngajat result = new DosarAngajat();
		if (idDosarAngajat_ == null){					
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.getDosarAngajatById(idDosarAngajat_);
			
			logger.logDEBUG(">>>>>>End getCerereDemisieById");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<DosarAngajat> getListaDosareAngajat() throws Exception {
		logger.logDEBUG(">>>>>>Start getListaCereriDemisie");
		Collection<DosarAngajat> result = this.registruPersonal.getListaDosareAngajat();
		logger.logDEBUG(">>>>>>End getListaCereriDemisie");
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public DosarAngajat salveazaDosarAngajat(DosarAngajat dosarAngajat_)
			throws Exception {
		logger.logDEBUG(">>>>>>Start salveazaDosarAngajat");
		DosarAngajat result = new DosarAngajat();
		if (dosarAngajat_ == null){				
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.salveazaDosarAngajat(dosarAngajat_);
			logger.logDEBUG(">>>>>>End salveazaDosarAngajat");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void stergeDosarAngajat(DosarAngajat dosarAngajat_) throws Exception {
		logger.logDEBUG(">>>>>>Start stergeDosarAngajat");
		if (dosarAngajat_ == null){					
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeDosarAngajat(dosarAngajat_);
			logger.logDEBUG(">>>>>>End stergeCandidat");
		}	
		
	}

	
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	
	@Override
	public Functie adaugaFunctie(Integer idFunctie, String numeFunctie) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start creare Functie");
		Functie functie = new Functie(idFunctie, numeFunctie);
		if (idFunctie == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{
			if (this.registruPersonal == null)
				registruPersonal = new RegistruPersonal(em);
			this.registruPersonal.salveazaFunctie(functie);
			
			logger.logDEBUG(">>>>>>End creare Activitate Team Bld");
		}
		return functie;
	}
	
	
	//Eveniment
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Eveniment getEvenimentById(
			Integer idEveniment_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getEvenimentbyId");
		Eveniment result = new Eveniment();
		if (idEveniment_ == null){				
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.getEvenimentById(idEveniment_);
			
			logger.logDEBUG(">>>>>>End getEvenimentbyId");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<Eveniment> getListaEvenimente()
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getListaEvenimente");
		Collection<Eveniment> result = this.registruPersonal.getListaEvenimente();
		logger.logDEBUG(">>>>>>End getListaEvenimente");
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Eveniment salveazaEveniment(
			Eveniment eveniment_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start salveazaEveniment");
		Eveniment result = new Eveniment();
		if (eveniment_ == null){			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.salveazaEveniment(eveniment_);
			logger.logDEBUG(">>>>>>End salveazaEveniment");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void stergeEveniment(Eveniment eveniment_)
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start stergeEveniment");
		if (eveniment_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeEveniment(eveniment_);
			logger.logDEBUG(">>>>>>End stergeEveniment");
		}		
	}
	
	//Functie
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Functie getFunctieById(Integer idFunctie_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getFunctieById");
		Functie result = new Functie();
		if (idFunctie_ == null){				
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.getFunctieById(idFunctie_); 
			
			logger.logDEBUG(">>>>>>End getFunctieById");
		}
		return result;
	}	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<Functie> getListaFunctii()
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getListaFunctii");
		Collection<Functie> result = this.registruPersonal.getListaFunctii();
		logger.logDEBUG(">>>>>>End getListaFunctii");
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Functie salveazaFunctie(
			Functie functie_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start salveazaFunctie");
		logger.logDEBUG("functie_ = " + functie_.toString());
		Functie result = new Functie();
		logger.logDEBUG("Am trecut de new Functie()");
		if (functie_ == null){			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.salveazaFunctie(functie_);
			logger.logDEBUG(">>>>>>End salveazaFunctie");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void stergeFunctie(Functie functie_)
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start stergeFunctie");
		if (functie_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeFunctie(functie_);
			logger.logDEBUG(">>>>>>End stergeFunctie");
		}		
	}
	
	//Instructor
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Instructor getInstructorById(
			Integer Id_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getInstructorById");
		Instructor result = new Instructor(); 
		if (Id_ == null){				
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.getInstructorById(Id_);
			
			logger.logDEBUG(">>>>>>End getInstructorById");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<Instructor> getListaInstructori()
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getListaInstructori");
		Collection<Instructor> result = this.registruPersonal.getListaInstructori();
		logger.logDEBUG(">>>>>>End getListaInstructori");
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Instructor salveazaInstructor(
			Instructor instructor_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start salveazaEveniment");
		Instructor result = new Instructor();
		if (instructor_ == null){			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.salveazaInstructor(instructor_);
			logger.logDEBUG(">>>>>>End salveazaEveniment");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void stergeInstructor(Instructor instructor_)
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start stergeInstructor");
		if (instructor_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeInstructor(instructor_);
			logger.logDEBUG(">>>>>>End stergeInstructor");
		}		
	}
	
	//Interviu
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Interviu getInterviuById(Integer idInterviu_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getInterviuById");
		Interviu result = new Interviu();
		if (idInterviu_ == null){				
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.getInterviuById(idInterviu_);
			
			logger.logDEBUG(">>>>>>End getInterviuById");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<Interviu> getListaInterviuri()
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getListaInterviuri");
		Collection<Interviu> result = this.registruPersonal.getListaInterviuri();
		logger.logDEBUG(">>>>>>End getListaInterviuri");
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Interviu salveazaInterviu(
			Interviu interviu_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start salveazaInterviu");
		Interviu result = new Interviu();
		if (interviu_ == null){			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruPersonal.salveazaInterviu(interviu_);
			logger.logDEBUG(">>>>>>End salveazaInterviu");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void stergeInterviu(Interviu interviu_)
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start stergeInterviu");
		if (interviu_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeInterviu(interviu_);
			logger.logDEBUG(">>>>>>End stergeInterviu");
		}		
	}

	
	//InterviuCandidat
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public InterviuCandidat getInterviuCandidatById(Integer idInterviuCandidat_)
			throws Exception {
		logger.logDEBUG(">>>>>>Start afisare InterviuCandidat");
		InterviuCandidat interviuCandidat_ = new InterviuCandidat();
		if (idInterviuCandidat_ == null){	
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			interviuCandidat_ = this.registruPersonal.getInterviuCandidatById(idInterviuCandidat_);
			// cum aflu idul noului obiect ?? em.refresh(bugetNou);
			logger.logDEBUG(">>>>>>End ");
		}
		return interviuCandidat_;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<InterviuCandidat> getListaInterviuriCandidati()
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getListaAnunturiLocMunca");
		Collection<InterviuCandidat> result = this.registruPersonal.getListaInterviuCandidat();
		logger.logDEBUG(">>>>>>End getListaAnunturiLocMunca");
		return result;
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public InterviuCandidat salveazaInterviuCandidat(
			InterviuCandidat idInterviuCandidat_) throws Exception {
		// TODO Auto-generated method stub
				logger.logDEBUG(">>>>>>Start creare InterviuCandidat");
				InterviuCandidat interviuCandidat_ = new InterviuCandidat();
				if (idInterviuCandidat_ == null){
					sessionContext.setRollbackOnly();
					logger.logDEBUG(">>>>>>Tranzactie Anulata");
				}
				else{
					if (this.registruPersonal == null)
						registruPersonal = new RegistruPersonal(em);
					this.registruPersonal.salveazaInterviuCandidat(interviuCandidat_);
					logger.logDEBUG(">>>>>>End creare Activitate Team Bld");
				}
				return interviuCandidat_;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void stergeInterviuCandidat(InterviuCandidat interviuCandidat_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start stergeInterviuCandidat");
		if (interviuCandidat_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeInterviuCandidat(interviuCandidat_);
			logger.logDEBUG(">>>>>>End stergeInterviuCandidat");
		}
	}
		
	//ProbaEvaluare
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ProbaEvaluare getProbaEvaluareById(Integer idProba_)
			throws Exception {
		logger.logDEBUG(">>>>>>Start afisare ProbaEvaluare");
		ProbaEvaluare probaEvaluare_ = new ProbaEvaluare();
		if (idProba_ == null){	
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			probaEvaluare_ = this.registruPersonal.getProbaEvaluareById(idProba_);
			logger.logDEBUG(">>>>>>End ");
		}
		return probaEvaluare_;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<ProbaEvaluare> getListaProbeEvaluare()
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getListaProbeEvaluare");
		Collection<ProbaEvaluare> result = this.registruPersonal.getListaProbaEvaluare();
		logger.logDEBUG(">>>>>>End getListaProbeEvaluare");
		return result;
	}	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ProbaEvaluare salveazaProbaEvaluare(ProbaEvaluare probaEvaluare_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start creare ProbaEvaluare");		
		if (probaEvaluare_ == null){
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{
			if (this.registruPersonal == null)
				registruPersonal = new RegistruPersonal(em);
			this.registruPersonal.salveazaProbaEvaluare(probaEvaluare_);
			logger.logDEBUG(">>>>>>End creare Activitate Team Bld");
		}
		return probaEvaluare_;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void stergeProbaEvaluare(ProbaEvaluare proba_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start stergeProbaEvaluare");
		if (proba_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeProbaEvaluare(proba_);
			logger.logDEBUG(">>>>>>End stergeProbaEvaluare");
		}
	}
		
	// RezultatProbaEvaluare
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public RezultatProbaEvaluare getRezultatProbaEvaluareById(Integer id_)
			throws Exception {
		logger.logDEBUG(">>>>>>Start afisare RezultatProbaEvaluare");
		RezultatProbaEvaluare rezultatProbaEvaluare_ = new RezultatProbaEvaluare();
		if (id_ == null){	
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			rezultatProbaEvaluare_ = this.registruPersonal.getRezultatProbaEvaluareById(id_);
			logger.logDEBUG(">>>>>>End ");
		}
		return rezultatProbaEvaluare_;
	}
		
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Collection<RezultatProbaEvaluare> getListaRezultateProbeEvaluare()
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start getListaRezultateProbeEvaluare");
		Collection<RezultatProbaEvaluare> result = this.registruPersonal.getListaRezultatProbaEvaluare();
		logger.logDEBUG(">>>>>>End getListaRezultateProbeEvaluare");
		return result;
	}	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public RezultatProbaEvaluare salveazaRezultatProbaEvaluare(RezultatProbaEvaluare rezultatProbaEvaluare_)
			throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start creare RezultatProbaEvaluare");		
		if (rezultatProbaEvaluare_ == null){
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{
			if (this.registruPersonal == null)
				registruPersonal = new RegistruPersonal(em);
			this.registruPersonal.salveazaRezultatProbaEvaluare(rezultatProbaEvaluare_);
			logger.logDEBUG(">>>>>>End creare Activitate Team Bld");
		}
		return rezultatProbaEvaluare_;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void stergeRezultatProbaEvaluare(RezultatProbaEvaluare rezultat_) throws Exception {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start stergeRezultatProbaEvaluare");
		if (rezultat_ == null){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>Tranzactie Anulata");
		}
		else{			
			this.registruPersonal.stergeRezultatProbaEvaluare(rezultat_);
			logger.logDEBUG(">>>>>>End stergeRezultatProbaEvaluare");
		}
	}
	
	
	
	///BusinessLogicRelated
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ActivitateTeamBuilding creareActivitateTeamBld(Integer nrInscrisi_) throws PersonalExceptions {
		// TODO Auto-generated method stub
		logger.logDEBUG(">>>>>>Start creare Activitate Team Bld");
		ActivitateTeamBuilding	activitateTeamBld = new ActivitateTeamBuilding() ;
		if (nrInscrisi_ <= 0){
			//throw new PersonalExceptions("Numarul inscrisilor nu poate fi negativ!");			
			sessionContext.setRollbackOnly();
			logger.logDEBUG(">>>>>>TranzactieAnulata");
		}
		else{
			activitateTeamBld.setNrInscrisi(nrInscrisi_);
			em.persist(activitateTeamBld);			
			logger.logDEBUG(">>>>>>End creare Activitate Team Bld");
		}
		return activitateTeamBld;
	}
	
	@Override
	public void demisionare(CerereDemisie cerereDemisie_) {
		// TODO Auto-generated method stub				
		ContractMunca	contract = cerereDemisie_.getContract();
		Angajat 		angajat = contract.getAngajat();
		Date			data;
		try
		{
			if(cerereDemisie_.getDataCerere() == null)
			{
				data = Calendar.getInstance().getTime();
				cerereDemisie_.setDataCerere(data);
			}
			
			if(cerereDemisie_.getDataDemisie() == null)
			{
				cerereDemisie_.setDataDemisie(Calendar.getInstance().getTime());
			}
			
			long msDiff= cerereDemisie_.getDataDemisie().getTime() - cerereDemisie_.getDataCerere().getTime();
			int nrZile = Math.round(msDiff / ((int)MILLIS_PER_DAY));
			
			cerereDemisie_.setPerioadaPreaviz(nrZile);
			
			contract.setDataTerminare(cerereDemisie_.getDataDemisie());
			contract.setMotivIncheiere("Demisionare");
			
			angajat.setActiv(false);
			cerereDemisie_.setStatus("Finalizata");
			
			System.out.println("Detalii cerere: " + cerereDemisie_.getNrInregistrare().toString());
			System.out.println("Status--------- " + cerereDemisie_.getStatus().toString());
			System.out.println("DataCerere----- " + cerereDemisie_.getDataCerere().toString());
			System.out.println("DataDemisie---- " + cerereDemisie_.getDataDemisie().toString());
			System.out.println("PerioadaPreaviz " + cerereDemisie_.getPerioadaPreaviz().toString());
			
			System.out.println("------------------------------------------------------------ ");
			System.out.println("Detalii ContractMunca: " + contract.getNrContract().toString());
			System.out.println("DataSemnare----------- " + contract.getDataSemnare().toString());
			System.out.println("DataTerminare--------- " + contract.getDataTerminare().toString());
			System.out.println("MotivIncheiere-------- " + contract.getMotivIncheiere().toString());
			
			System.out.println("------------------------------------------------------------ ");
			System.out.println("Detalii Angajat: " + angajat.getMarca().toString());
			System.out.println("Activ----------- " + angajat.getActiv().toString());
			System.out.println("Nume------------ " + angajat.getNume().toString());
			System.out.println("Prenume--------- " + angajat.getPrenume().toString());	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.logERROR(e.getMessage(), e);
		}
		
	}

	@Override
	public void concediere(ContractMunca contractMunca_) {
		try
		{
		
			Angajat 		angajat = contractMunca_.getAngajat();
			
			contractMunca_.setDataTerminare(Calendar.getInstance().getTime());
			
			angajat.setActiv(false);
			contractMunca_.setMotivIncheiere("Concediere");
			
			System.out.println("------------------------------------------------------------ ");
			System.out.println("Detalii ContractMunca: " + contractMunca_.getNrContract().toString());
			System.out.println("DataSemnare----------- " + contractMunca_.getDataSemnare().toString());
			System.out.println("DataTerminare--------- " + contractMunca_.getDataTerminare().toString());
			System.out.println("MotivIncheiere-------- " + contractMunca_.getMotivIncheiere().toString());
			
			System.out.println("------------------------------------------------------------ ");
			System.out.println("Detalii Angajat: " + angajat.getMarca().toString());
			System.out.println("Activ----------- " + angajat.getActiv().toString());
			System.out.println("Nume------------ " + angajat.getNume().toString());
			System.out.println("Prenume--------- " + angajat.getPrenume().toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.logERROR(e.getMessage(), e);
		}
	}

	//private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PersonalImpl.class.getName());

	@Override
	public  Collection<AnuntLocMunca> getPosturiVacante(Date dataVizata_, Collection<AnuntLocMunca> ListaInit_) {
		try
		{
			Collection<AnuntLocMunca> rezultat = new ArrayList<AnuntLocMunca>();
			
			Iterator<AnuntLocMunca> iterator = ListaInit_.iterator();
			while (iterator.hasNext()) {
				AnuntLocMunca	anunt = iterator.next();
				//System.out.println(anunt.getCorpAnunt());
				if(dataVizata_.compareTo(anunt.getDataInceput()) >= 0 && dataVizata_.compareTo(anunt.getDataExpirare()) <= 0)
				{
					rezultat.add(anunt);	
				}
			}
			return rezultat;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.logERROR(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public Collection<Candidat> getCandidatipeFunctie(AnuntLocMunca anuntLocMunca_, Collection<CV> ListaInit_) {
		try
		{
			Collection<Candidat> rezultat = new ArrayList<Candidat>();
			
			Iterator<CV> iterator = ListaInit_.iterator();
			
			while (iterator.hasNext()) {
				CV	cv = iterator.next();
				//System.out.println(cv.getCandidat().getNume());
				if(cv.getUltimaModificare().compareTo(anuntLocMunca_.getDataInceput()) >= 0 && cv.getUltimaModificare().compareTo(anuntLocMunca_.getDataExpirare()) <= 0
					&& 	cv.getFunctieVizata() == anuntLocMunca_.getFunctie())
				{
					rezultat.add(cv.getCandidat());	
				}
			}
			return rezultat;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.logERROR(e.getMessage(), e);
			return null;
		}
	}
	
	
	@Override
	public Collection<Candidat> recrutare(Date dataAnunt_, Candidat candidat_, Collection<InterviuCandidat> ListaInit_) {
		try
		{
			Collection<Candidat> rezultat = new ArrayList<Candidat>();
			
			Iterator<InterviuCandidat> iterator = ListaInit_.iterator();
			
			while (iterator.hasNext()) {
				InterviuCandidat	interviu = iterator.next();
				if (interviu.getRezultatEvaluare() == "ADMIS" && interviu.getInterviu().getTipInterviu() == "Final" 
								&& candidat_.getIdCandidat()== interviu.getCandidat().getIdCandidat()
								&& (interviu.getDataInterviu().compareTo(dataAnunt_)) >= 0)
											
				{
					rezultat.add(interviu.getCandidat());	
				}
			}
			return rezultat;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.logERROR(e.getMessage(), e);
			return null;
		}
	}
	
	//evaluareAngajat - Andreea

	@Override
	public HashMap <DummyDepartament, Collection<ProbaEvaluare>> getProbeEvaluareDepartament(
			Collection<ProbaEvaluare> probeEvaluareInit_, Collection<DummyDepartament> departamenteInit) 
	{
		DummyDepartament 	departamentCurent;
		ProbaEvaluare	probaEvaluare;
		
		Iterator <DummyDepartament>	iteratorDepartament = departamenteInit.iterator();
		HashMap <DummyDepartament, Collection<ProbaEvaluare>> tMap = new HashMap<DummyDepartament, Collection<ProbaEvaluare>>();
		Collection<ProbaEvaluare> probeEvaluarePeDepartament = new ArrayList<ProbaEvaluare>();
		while (iteratorDepartament.hasNext()) {
			departamentCurent = iteratorDepartament.next();
			probeEvaluarePeDepartament.clear();
			Iterator <ProbaEvaluare> iteratorProbe = probeEvaluareInit_.iterator();
			while (iteratorProbe.hasNext())
			{
				probaEvaluare = iteratorProbe.next();
				if (probaEvaluare.getDepartament() == departamentCurent
						&& probaEvaluare.getScop() == "EvaluarePeriodica")
				{
					probeEvaluarePeDepartament.add(probaEvaluare);
				}
			}			
			tMap.put(departamentCurent, new ArrayList<ProbaEvaluare>(probeEvaluarePeDepartament));			
		}
		
		return tMap;
	}

	

	@Override
	public Collection<ContractMunca> getListaContracteByAngajat(Angajat angajat_) {
		TestPersonalImpl test = new TestPersonalImpl();
		test.ListaContracte();
		Iterator <ContractMunca> iteratorMunca = test.contracteMunca.iterator();
		Collection <ContractMunca> ListaContractelor = new ArrayList<ContractMunca>();
		while (iteratorMunca.hasNext()){
			ContractMunca contractCurent;
			contractCurent = iteratorMunca.next();
			if (contractCurent.getAngajat().getMarca().equals(angajat_ .getMarca())
					&&
					contractCurent.getDataInceput().compareTo(Calendar.getInstance().getTime()) <= 0 
					&&
					contractCurent.getDataTerminare().compareTo(Calendar.getInstance().getTime()) >= 0)
			{
				ListaContractelor.add(contractCurent);
			}
		}
		return ListaContractelor;
	}
	
	@Override
	public ContractMunca getContractAngajatActiv(Angajat angajat_) {
		TestPersonalImpl test = new TestPersonalImpl();
		test.ListaContracte();
		
		Iterator <ContractMunca> iteratorMunca = test.contracteMunca.iterator();

		while (iteratorMunca.hasNext()){
			ContractMunca contractCurent;
			contractCurent = iteratorMunca.next();
			if (contractCurent.getAngajat().getMarca().equals(angajat_ .getMarca())
					&&
					contractCurent.getDataInceput().compareTo(Calendar.getInstance().getTime()) <= 0 
					&&
					contractCurent.getDataTerminare().compareTo(Calendar.getInstance().getTime()) >= 0)
			{
				System.out.println( "Contractul are codul: " + contractCurent.getNrContract() + ", data inceput: " + contractCurent.getDataInceput() 
						+ ", data sfarsit: " + contractCurent.getDataTerminare());
				
				System.out.println("Contract gasit pentru angajatul cu numele: " + angajat_.getNume());


				return contractCurent;
			}
			

		}
		System.out.println("Nu a fost gasit niciun contract pentru angajatul cu numele " + angajat_.getNume());
		return null;
	}
	
	@Override
	public CV getCVByCandidat (Candidat candidat_) {
		TestPersonalImpl test = new TestPersonalImpl();
	
		test.generareAnunturi();
		Iterator <CV> iteratorCV = test.ListaCandidati.iterator();
		while (iteratorCV.hasNext()){
			CV cvCurent = iteratorCV.next();
			if (cvCurent.getCandidat().getIdCandidat().equals(candidat_.getIdCandidat() ))
			{
				return cvCurent;
			}
		}
		return null;
	}
	

	@Override
	public void angajare(Candidat candidat_) {
		Angajat angajat;
		angajat = new Angajat (candidat_.getId(), candidat_.getAdresa(), candidat_.getNume(), candidat_.getPrenume(),
				candidat_.getFormaAdresare(), candidat_.getGen(), candidat_.getCnp(), candidat_.getIdCandidat(), candidat_.getTipCandidat(),
				3// va fi modificat odata cu baza de date
				, null, 0);
		em.persist(angajat);
		CV cv = getCVByCandidat(candidat_);
		
		ContractMunca contract;
		contract = new ContractMunca(1, 1000.00, 10.00, angajat, cv.getFunctieVizata(), new Date("11/08/2011"), new Date("15/08/2011"), null,0,null);
		
		DosarAngajat dosar;
		dosar = new DosarAngajat(10, angajat, false, false, false);	
		
	}

	
	@Override
	public DosarAngajat getDosarByAngajat(Angajat angajat_) {
		TestPersonalImpl test = new TestPersonalImpl();
		test.ListaDosare();
		Iterator <DosarAngajat> iteratorDosar = test.dosareAngajati.iterator();
		while (iteratorDosar.hasNext()){
			DosarAngajat dosarCurent = iteratorDosar.next();
			if (dosarCurent.getAngajat().getMarca().equals(angajat_.getMarca()))
			{
				return dosarCurent;
			}
		}
		return null;
	}
		
	
	@Override
	public void activareAngajati(Collection<Angajat> ListaAngajati) {

		Iterator<Angajat> iterator = ListaAngajati.iterator();
		Collection<ContractMunca> contracte = new ArrayList<ContractMunca>();
		Integer nrActivari = 0; // variabila utilizata la metoda angajare
		
		while (iterator.hasNext()) {
			Angajat angajatCurent = iterator.next();
			DosarAngajat dosar;   
			dosar = getDosarByAngajat (angajatCurent);
		
			
			if(angajatCurent.getActiv() == false &&
				dosar.getAdeverintaStudii() ==true && dosar.getAdeverintaStudii() == true && dosar.getFisaMedicala() == true)
				
			{
				contracte = getListaContracteByAngajat(angajatCurent);
				
				//System.out.println("activare2" + angajatCurent.getNume());
				
				//System.out.println("activare3 " + contracte.size());

				
				if (contracte.size()>0) {
					
					angajatCurent.setActiv(true);	
					
					nrActivari = nrActivari + 1;
					
					System.out.println("-------- Angajatul activat are numele:  " + angajatCurent.getNume());
				}
				
				contracte.clear();
			}
		}
		
		System.out.println("Numarul de angajati activati este: " + nrActivari);
		
	}

	@Override
	public HashMap<ProbaEvaluare, Collection<RezultatProbaEvaluare>> getRezultateEvaluareByProba(
			Collection<RezultatProbaEvaluare> angajatProbaInit_,
			Collection<ProbaEvaluare> probeEvaluareInit_) {
		//Collection<ProbaEvaluare> ListaProbelorEvaluate = new ArrayList<ProbaEvaluare>();
		HashMap<ProbaEvaluare, Collection<RezultatProbaEvaluare>> rezultat = new HashMap<ProbaEvaluare, Collection<RezultatProbaEvaluare>>();
		Collection<RezultatProbaEvaluare> angajatiRezultate = new ArrayList<RezultatProbaEvaluare>();
		Iterator<ProbaEvaluare> iteratorProbe = probeEvaluareInit_.iterator();
		RezultatProbaEvaluare rezultatCurent;
		ProbaEvaluare probaCurenta;
		while (iteratorProbe.hasNext()) {
			probaCurenta = iteratorProbe.next();
			Iterator<RezultatProbaEvaluare> iteratorRezultate = angajatProbaInit_.iterator();
			while (iteratorRezultate.hasNext()){
				rezultatCurent = iteratorRezultate.next();
				//probaE = rezultatCurent.getProbaEvaluare();
				if (rezultatCurent.getProbaEvaluare() == probaCurenta)
				{
					angajatiRezultate.add(rezultatCurent);
				}
			}
			rezultat.put(probaCurenta, new ArrayList<RezultatProbaEvaluare>(angajatiRezultate));
			angajatiRezultate.clear();
		}
		return rezultat;
	}

	@Override
	public ContractMunca relocalizare_promovare(Integer marca_, Functie functieNoua_, ContractMunca contractVizat_, boolean promovare_, double salarBaza_, double tarifOrar_)
	 {

		Angajat angajat = new Angajat();
		try
		{
			angajat = this.getAngajatById(marca_);
		}
		catch(Exception ex)
		{
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();			
		}
		if(angajat == null)
		{
			return null;
		}
		if (contractVizat_ == null)
		{
			Iterator<ContractMunca> iteratorContracte = this.getListaContracteByAngajat(angajat).iterator();
			
			while (iteratorContracte.hasNext())
			{
				ContractMunca contractVechi = iteratorContracte.next();
				contractVechi.setDataTerminare(Calendar.getInstance().getTime());
				if(promovare_)
				{
					contractVechi.setMotivIncheiere("Promovare");
				}
				else
				{
					contractVechi.setMotivIncheiere("Relocalizare");
				}
			}	
		}
		else
		{
			contractVizat_.setDataTerminare(Calendar.getInstance().getTime());
			if(promovare_)
			{
				contractVizat_.setMotivIncheiere("Promovare");
			}
			else
			{
				contractVizat_.setMotivIncheiere("Relocalizare");
			}
		}
		ContractMunca	contractNou = new ContractMunca(1, salarBaza_, tarifOrar_, angajat, functieNoua_, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), null, 0, null);
		
		return contractNou;
		
		
	}

	@Override
	public Functie adaugareFunctie(String numeFunctie_, Integer pozitiaInCOR_,
			Collection<String> obiective_, Collection<String> responsabilitati_,
			Collection<String> cunostinte_, Collection<String> deprinderi_,
			Collection<String> aptitudini_, DummyDepartament departament) {
		Functie functieNoua = new Functie (1,//va fi modificat cu BD
				numeFunctie_, pozitiaInCOR_, obiective_, responsabilitati_, cunostinte_, deprinderi_, aptitudini_, departament);
		return functieNoua;
	}
	@Override
	public Collection<Eveniment> getEvenimenteAnuale(Integer _year) {
		Collection<Eveniment> evenimente = new ArrayList<Eveniment>();

		if(_year ==0)
		{
			return Eveniment.getEvenimente();
		}		
		return evenimente;
	}

	
	
	@Override
	public void aprobareEveniment(Eveniment _eveniment) {
		
		Iterator <Activitate> activitatiEveniment =_eveniment.getActivitati().iterator();
		Double sumaActivitati = 0.00;
		while (activitatiEveniment.hasNext())
		{
			Activitate activitateCurenta = activitatiEveniment.next();
			sumaActivitati += activitateCurenta.getSumaEstimata();				
		}
		if(sumaActivitati<= _eveniment.getSumaAlocata())
		{
			_eveniment.setStatusEveniment("Eveniment Aprobat");
		}		
		System.out.println(_eveniment.getStatusEveniment());
	}
	@Override
	public HashMap<DummyDepartament, Collection<ProbaEvaluare>> getProbeEvaluareDepartamentEJB() {
	try{
		Collection<DummyDepartament> listaDepartamente =  this.registruPersonal.getListaDepartamente() ;
	}catch(Exception ex){
		logger.logERROR(ex.getMessage());
	}
	//	Iterator <DummyDepartament>	iteratorDepartament = listaDepartamente.iterator();
		//while ()
		DummyDepartament 	departamentCurent;
		ProbaEvaluare	probaEvaluare;
		/*
		Iterator <DummyDepartament>	iteratorDepartament = departamenteInit.iterator();
		HashMap <DummyDepartament, Collection<ProbaEvaluare>> tMap = new HashMap<DummyDepartament, Collection<ProbaEvaluare>>();
		Collection<ProbaEvaluare> probeEvaluarePeDepartament = new ArrayList<ProbaEvaluare>();
		while (iteratorDepartament.hasNext()) {
			departamentCurent = iteratorDepartament.next();
			probeEvaluarePeDepartament.clear();
			Iterator <ProbaEvaluare> iteratorProbe = probeEvaluareInit_.iterator();
			while (iteratorProbe.hasNext())
			{
				probaEvaluare = iteratorProbe.next();
				if (probaEvaluare.getDepartament() == departamentCurent
						&& probaEvaluare.getScop() == "EvaluarePeriodica")
				{
					probeEvaluarePeDepartament.add(probaEvaluare);
				}
			}			
			tMap.put(departamentCurent, new ArrayList<ProbaEvaluare>(probeEvaluarePeDepartament));			
		}
		
		return tMap;
		*/
		return null;
	}
	

	
}
