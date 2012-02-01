package org.open.erp.services.contabgest.impl;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.open.erp.services.contabgest.CentruCost;
import org.open.erp.services.contabgest.CheltuieliFixe;
import org.open.erp.services.contabgest.CheltuieliVariabile;
import org.open.erp.services.contabgest.ContabGestSrv;
import org.open.erp.services.contabgest.ContabGestSrvLocal;
import org.open.erp.services.contabgest.ContabGestSrvRemote;
import org.open.erp.services.contabgest.DummyFazaProductie;
import org.open.erp.services.contabgest.DummyPersoana;
import org.open.erp.services.contabgest.ProceseTehnicoEconomice;
import org.open.erp.services.contabgest.ProdusFinit;
import org.open.erp.services.contabgest.ResponabilCentruCost;
import org.open.erp.services.contabgest.TipCheltuieli;
import org.open.erp.services.contabgest.exceptions.ContabGestLogger;



@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContabGestImpl implements ContabGestSrv, ContabGestSrvLocal, ContabGestSrvRemote {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ContabGestImpl.class.getName());
	ContabGestLogger logger2 = new ContabGestLogger();
	
	private RegistruContabGest registruContabGest;
	
	private static ContabGestSrv contabGest;
	
	@PersistenceContext(unitName="OpenERP_CONTABGEST")
	private EntityManager em;
	
	@Resource
	private SessionContext sessionContext;
	

	/* Initializare */
	public ContabGestImpl() { }	
	
	@PostConstruct
	public void init(){
		logger.debug(">>>>>>>>>>>> Exista em? " + em);			
		
		if (this.registruContabGest == null)
			registruContabGest = new RegistruContabGest(em);
		
	}	
	
	
	
	
	
	/* implementare actiuni serviciu ProjectManagementSrv */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public DummyPersoana defDummyPersoana( String nume,
			String prenume, String formaAdresare)
			throws Exception {
		
		System.out.println("!>>>>>>>>>>>> START Creare persoana");
		logger.debug(">>>>>>>>>>>> START Creare persoana");		
		DummyPersoana dummyPersoanaNou = new DummyPersoana(nume, prenume, 
											formaAdresare);
		/* Actiune tranzactionala ... */
		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Creare persoana - TRANZACTIE ANULATA");
			//throw new RuntimeException("Creare proiect - TRANZACTIE ANULATA");
		}else{
			dummyPersoanaNou = this.registruContabGest.salveazaPersoana(dummyPersoanaNou);
			//em.persist(proiectNou);
		}	
		System.out.println("!>>>>>>>>>>>> END Creare persoana");
		logger.debug(">>>>>>>>>>>> END Creare persoana");
		return dummyPersoanaNou;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public DummyPersoana getPersoanaId(Integer idPersoana) throws Exception{
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		DummyPersoana result = new DummyPersoana();
		if (idPersoana == null){				
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		else{			
			result = this.registruContabGest.getPersoanaIdR(idPersoana); 
			
			logger.debug(">>>>>>End getPersonaID");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ProdusFinit defProdusFinit(String den, Double procProfit) throws Exception{
		System.out.println("!>>>>>>>>>>>> START Creare produs finit");
		logger.debug(">>>>>>>>>>>> START produs finit");		
		ProdusFinit produFinitNou = new ProdusFinit(den, procProfit);
		/* Actiune tranzactionala ... */
		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Creare produs finit - TRANZACTIE ANULATA");
			//throw new RuntimeException("Creare proiect - TRANZACTIE ANULATA");
		}else{
			produFinitNou = this.registruContabGest.salveazaProdusFinit(produFinitNou);
			//em.persist(proiectNou);
		}	
		System.out.println("!>>>>>>>>>>>> END Creare produs finit");
		logger.debug(">>>>>>>>>>>> END Creare produs finit");
		return produFinitNou;
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public CheltuieliFixe defCheltuieliFixe(String tipCheltuiala, String denCheltuiala,
			String delatiiCheltuiala, CentruCost centruCost) throws Exception{
		System.out.println("!>>>>>>>>>>>> START Creare cheltuiala ");
		logger.debug(">>>>>>>>>>>> START tipcheltuiala");
		//TipCheltuieli tipCheltuialaNou = new TipCheltuieli(tipCheltuiala);
		CheltuieliFixe cheltuieliFixeNou = new CheltuieliFixe(denCheltuiala, delatiiCheltuiala, centruCost);
		/* Actiune tranzactionala ... */
		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Creare cheltuiala fixa - TRANZACTIE ANULATA");
			//throw new RuntimeException("Creare proiect - TRANZACTIE ANULATA");
		}else{
			//tipCheltuialaNou= this.registruContabGest.salveazaTipCheltuiala(tipCheltuialaNou);
			cheltuieliFixeNou = this.registruContabGest.salveazaCheltuieliFixe(cheltuieliFixeNou);
			//em.persist(proiectNou);
		}	
		logger.debug(">>>>>>>>>>>> END Creare cheltuiala fixa");
		System.out.println("!>>>>>>>>>>>> END Creare cheltuiala ");
		return cheltuieliFixeNou;
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public CheltuieliVariabile defCheltuieliVariabile(String tipCheltuiala, String denCheltuialaV,
			String delatiiCheltuialaV, Integer cantitateCheltuialaV, CentruCost centruCost) throws Exception{
		System.out.println("!>>>>>>>>>>>> START Creare cheltuiala ");
		logger.debug(">>>>>>>>>>>> START tipcheltuiala");
		//TipCheltuieli tipCheltuialaNou = new TipCheltuieli(tipCheltuiala);
		CheltuieliVariabile cheltuieliVariabileNou = new CheltuieliVariabile(denCheltuialaV, delatiiCheltuialaV, cantitateCheltuialaV, centruCost);
		/* Actiune tranzactionala ... */
		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Creare cheltuiala fixa - TRANZACTIE ANULATA");
			//throw new RuntimeException("Creare proiect - TRANZACTIE ANULATA");
		}else{
			//tipCheltuialaNou= this.registruContabGest.salveazaTipCheltuiala(tipCheltuialaNou);
			cheltuieliVariabileNou = this.registruContabGest.salveazaCheltuieliVariabile(cheltuieliVariabileNou);
			//em.persist(proiectNou);
		}	
		logger.debug(">>>>>>>>>>>> END Creare cheltuiala fixa");
		System.out.println("!>>>>>>>>>>>> END Creare cheltuiala ");
		return cheltuieliVariabileNou;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ProceseTehnicoEconomice defProceseTehnicoEconomice(String	denumireProces,
			String detaliiProces) throws Exception{
		System.out.println("!>>>>>>>>>>>> START Creare tip proces tehnico-economic ");
		logger.debug(">>>>>>>>>>>> START proces tehnico-economic");
		
		ProceseTehnicoEconomice proceseTehnicoEconomiceNou = new ProceseTehnicoEconomice(denumireProces, detaliiProces);
		/* Actiune tranzactionala ... */
		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Creare proces tehnico-economic - TRANZACTIE ANULATA");
		}else{
			//tipCheltuialaNou= this.registruContabGest.salveazaTipCheltuiala(tipCheltuialaNou);
			proceseTehnicoEconomiceNou = this.registruContabGest.salveazaTipProceseTehnicoEconomice(proceseTehnicoEconomiceNou);
			//em.persist(proiectNou);
		}	
		logger.debug(">>>>>>>>>>>> END Creare proces tehnico-economic");
		System.out.println("!>>>>>>>>>>>> END Creare proces tehnico-economic ");
		return proceseTehnicoEconomiceNou;
		
	}
	

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ResponabilCentruCost defResponabilCentruCost(String  nume, String  prenume, String  formaAdresare,
			Integer idResponsabilCentruCost, Date dataStartResponsabilitate, 
			Date dataSfarsitResponsabilitate, String detaliiResponsabilitati) throws Exception {
		
		System.out.println("!>>>>>>>>>>>> START Creare Responsabil centru cost ");
		logger.debug(">>>>>>>>>>>> START Responsabil centru cost");
		
		ResponabilCentruCost responabilCentruCostNou = new ResponabilCentruCost(nume, prenume, formaAdresare,
				idResponsabilCentruCost, dataStartResponsabilitate, dataSfarsitResponsabilitate, detaliiResponsabilitati);

		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Creare Responsabil centru cost - TRANZACTIE ANULATA");
		}else{
			
			responabilCentruCostNou = this.registruContabGest.salveazaResponabilCentruCost(responabilCentruCostNou);
			
		}	
		
		logger.debug(">>>>>>>>>>>> END Creare Responsabil centru cost");
		System.out.println("!>>>>>>>>>>>> END Creare Responsabil centru cost");
		return responabilCentruCostNou;
		
		
	}
	
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public DummyFazaProductie defDummyFazaProductie(String denumireFazaProductie,
			Date incepereFazaProductie, Date sfarsitFazaProductie, Double costFazaProductie) throws Exception{
		System.out.println("!>>>>>>>>>>>> START Creare DummyFazaProductie");
		logger.debug(">>>>>>>>>>>> START DummyFazaProductie");		
		DummyFazaProductie dummyFazaProductieNoua = new DummyFazaProductie(denumireFazaProductie, incepereFazaProductie,
				sfarsitFazaProductie, costFazaProductie);
		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Creare DummyFazaProductie - TRANZACTIE ANULATA");
			
		}else{
			dummyFazaProductieNoua = this.registruContabGest.salveazaDummyFazaProductie(dummyFazaProductieNoua);
		}	
		System.out.println("!>>>>>>>>>>>> END Creare dummyFazaProductie");
		logger.debug(">>>>>>>>>>>> END Creare dummyFazaProductie");
		return dummyFazaProductieNoua;
	}


	
	
		
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public CentruCost defCentruCost(String denCentruCost, Date startCentruCost, Date sfarsitCentruCost, 
			ResponabilCentruCost responabilCentruCost, DummyFazaProductie dummyFazaProductie,
			ProceseTehnicoEconomice proceseTehnicoEconomice, ProdusFinit produsfinit) throws Exception{
		System.out.println("!>>>>>>>>>>>> START Creare centru cost ");
		logger.debug(">>>>>>>>>>>> START centru cost");
		
		CentruCost centruCostNou = new CentruCost(denCentruCost, startCentruCost, sfarsitCentruCost, 
				responabilCentruCost, dummyFazaProductie, proceseTehnicoEconomice,  produsfinit);

		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Creare centru cost - TRANZACTIE ANULATA");
		}else{
			
			centruCostNou = this.registruContabGest.salveazaCentruCost(centruCostNou);
			
		}	
		logger.debug(">>>>>>>>>>>> END Creare centru cost");
		System.out.println("!>>>>>>>>>>>> END Creare centru cost ");
		return centruCostNou;
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ProdusFinit getProdusFinitById(Integer idProdusFinit_) throws Exception{
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		ProdusFinit result = new ProdusFinit();
		if (idProdusFinit_ == null){					
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		else{			
			result = this.registruContabGest.getProdusFinitById(idProdusFinit_);
			
			logger.debug(">>>>>>End getProdusFinitById");
		}
		return result;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public DummyFazaProductie getDummyFazaProductieById(Integer idFazaProductie_) throws Exception{
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		DummyFazaProductie result = new DummyFazaProductie();
		if (idFazaProductie_ == null){					
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		else{			
			result = this.registruContabGest.getDummyFazaProductieById(idFazaProductie_);
			
			logger.debug(">>>>>>End getDummyFazaProductieById");
		}
		return result;
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ResponabilCentruCost getResponabilCentruCostById(Integer idResponsabilCentruCost_) throws Exception{
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		ResponabilCentruCost result = new ResponabilCentruCost();
		if (idResponsabilCentruCost_ == null){					
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		else{			
			result = this.registruContabGest.getResponabilCentruCostById(idResponsabilCentruCost_);
			
			logger.debug(">>>>>>End getResponabilCentruCostById");
		}
		return result;
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ProceseTehnicoEconomice getProceseTehnicoEconomiceById(Integer idProceseTehnicoEconomice_) throws Exception{
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		ProceseTehnicoEconomice result = new ProceseTehnicoEconomice();
		if (idProceseTehnicoEconomice_ == null){					
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		else{			
			result = this.registruContabGest.getProceseTehnicoEconomiceById(idProceseTehnicoEconomice_);
			
			logger.debug(">>>>>>End getProceseTehnicoEconomiceById");
		}
		return result;
	}


		@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ArrayList<ProdusFinit> getProduseFinite() {
		ArrayList<ProdusFinit> produseFinite = registruContabGest.getProduseFInitte();
		return produseFinite;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ProdusFinit salvareProdus(ProdusFinit produsFinit) throws Exception {
		/* Actiune tranzactionala ... */
		//if (sessionContext.getRollbackOnly() == true){
		//	logger.debug(">>>>>>>>>>>> END Creare/salvare produs - TRANZACTIE ANULATA");
			//throw new RuntimeException("Creare produs - TRANZACTIE ANULATA");
	//	}else{
			produsFinit = this.registruContabGest.salveazaProdus(produsFinit);
			//em.persist(produsFinit);
	//	}
		
		logger.debug(">>>>>>>>>>>> END salvare produs");
		return produsFinit;
	
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public CentruCost getCentruCostById(Integer idCentruCost_) throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		CentruCost result = new CentruCost();
		if (idCentruCost_ == null){					
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		else{			
			result = this.registruContabGest.getCentruCostById(idCentruCost_);
			
			logger.debug(">>>>>>End getProdusFinitById");
		}
		return result;
	}
	
	/*
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ResponabilCentruCost getIdResponsabilCentruCostdupaId(int idResponsabilCentruCost){
		
		System.out.println("!>>>>>>>>>>>> START Gasire Responsabil ");
		logger.debug(">>>>>>>>>>>> START START Gasire Responsabil");
		
		//CentruCost centruCostNou = new CentruCost(denCentruCost, startCentruCost, sfarsitCentruCost, 
		//		responabilCentruCost, dummyFazaProductie, proceseTehnicoEconomice,  produsfinit);

		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Creare centru cost - TRANZACTIE ANULATA");
		}else{
			
		//	centruCostNou = this.registruContabGest.salveazaCentruCost(centruCostNou);
			
		}	
		logger.debug(">>>>>>>>>>>> END Creare centru cost");
		System.out.println("!>>>>>>>>>>>> END Creare centru cost ");
		return null;
	}
	*/
	
	
	
	

}
