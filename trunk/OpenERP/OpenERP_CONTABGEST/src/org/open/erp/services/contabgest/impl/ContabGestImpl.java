package org.open.erp.services.contabgest.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.open.erp.services.contabgest.CheltuieliFixe;
import org.open.erp.services.contabgest.ContabGestSrvLocal;
import org.open.erp.services.contabgest.ContabGestSrvRemote;
import org.open.erp.services.contabgest.ProdusFinit;
import org.open.erp.services.contabgest.exceptions.ContabGestLogger;


@Stateless(name="ContabGestSrv")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContabGestImpl implements  ContabGestSrvLocal, ContabGestSrvRemote {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ContabGestImpl.class.getName());
	ContabGestLogger logger2 = new ContabGestLogger();
	
	private RegistruContabGest registruContabGest;
	
	//private static ContabGestSrv contabGest;
	
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
	
	
	
	
	
	/*
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public DummyPersoana defDummyPersoana( String nume,
			String prenume, String formaAdresare)
			throws Exception {
		
		System.out.println("!>>>>>>>>>>>> START Creare persoana");
		logger.debug(">>>>>>>>>>>> START Creare persoana");		
		DummyPersoana dummyPersoanaNou = new DummyPersoana(nume, prenume, 
											formaAdresare);
		
		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Creare persoana - TRANZACTIE ANULATA");
			//throw new RuntimeException("Creare proiect - TRANZACTIE ANULATA");
		}else{
			dummyPersoanaNou = this.registruContabGest.salveazaPersoana(dummyPersoanaNou);
			//em.persist(proiectNou);
		}	
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
	*/
	
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
		logger.debug(">>>>>>>>>>>> END Creare produs finit");
		return produFinitNou;
	}
	

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public CheltuieliFixe defCheltuieliFixe(String tipCheltuiala, String denCheltuiala,
			String delatiiCheltuiala) throws Exception{
		System.out.println("!>>>>>>>>>>>> START Creare cheltuiala ");
		logger.debug(">>>>>>>>>>>> START tipcheltuiala");
		//TipCheltuieli tipCheltuialaNou = new TipCheltuieli(tipCheltuiala);
		CheltuieliFixe cheltuieliFixeNou = new CheltuieliFixe(denCheltuiala, delatiiCheltuiala);
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
  @Override
	public ProdusFinit getProdusFinit(Integer idProdusFinit)
			throws Exception {
		logger.debug(" Start >> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		ProdusFinit result = new ProdusFinit();
		if (idProdusFinit == null){				
			sessionContext.setRollbackOnly();
			logger.debug(" Transaction Canceled in >> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		else{			
			result = this.registruContabGest.getProdusFinitIdR(idProdusFinit); 
			
			logger.debug(">>>>>>End getPersonaID");
		}
		return result;
	}

}
