package org.open.erp.services.proman.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.open.erp.services.buget.Buget;
import org.open.erp.services.buget.BugetareSrvLocal;
import org.open.erp.services.proman.Activitate;
import org.open.erp.services.proman.ActivitateBugetata;
import org.open.erp.services.proman.Proiect;
import org.open.erp.services.proman.ProjectManagementSrv;
import org.open.erp.services.proman.ProjectManagementSrvLocal;
import org.open.erp.services.proman.Responsabil;

/**
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProjectManagementImpl 
	implements ProjectManagementSrv, ProjectManagementSrvLocal{
	
	/* Dependente resurse proprii */
	private static Logger logger = Logger.getLogger(ProjectManagementImpl.class.getName());	
	private RegistruProiect registruProiect;

	/* Dependente resurse injectate */
	@PersistenceContext(unitName="OpenERP_PROMAN")
	private EntityManager em;
	
	@Resource
	private SessionContext sessionContext;	
	
	@EJB(lookup="java:global/OpenERP_BUGET/BugetareImpl!org.open.erp.services.buget.BugetareSrvLocal")
	private BugetareSrvLocal bugetareSrv;
	
	/* Initializare */
	public ProjectManagementImpl() { }	
	@PostConstruct
	public void init(){		
		if (this.registruProiect == null)
			registruProiect = new RegistruProiect(em);
		
	}	
	
	
	/* implementare actiuni serviciu ProjectManagementSrv */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Proiect creareProiect(String nume, Responsabil responsabil,
			Date dataStart, Date dataSfarsit, Double valoareBuget) throws Exception {
		
		logger.debug(">>>>>>>>>>>> START Creare proiect standadr");		
		//Proiect proiectNou = new Proiect(1, nume, dataStart, dataSfarsit, valoareBuget, responsabil);
		Proiect proiectNou = new Proiect(nume, dataStart, dataSfarsit, valoareBuget, responsabil);
		
		creareProiect(proiectNou);
		
		logger.debug(">>>>>>>>>>>> END Creare proiect standard");
		return proiectNou;
	}
	
	
	@Override
	public Activitate creareActivitate(Proiect proiect, Responsabil responsabil,
			String titulatura, Date dataStart, Date dataSfarsit,
			Double valoareBugetata) throws Exception {
		
		logger.debug(">>>>>>>>>>>> START Creare activitate >>>>>>>>>>>>>>> ");	
		
		ActivitateBugetata activitate = new ActivitateBugetata(titulatura, dataStart, dataSfarsit, valoareBugetata, responsabil);
		proiect.adaugaActivitate(activitate);
		activitate.setProiect(proiect);
		
		/* 1. Direct activitate */
		//activitate = this.registruProiect.salveazaActivitateBugetata(activitate);
		//logger.debug(">>>>>>>>>>>> Activitate salvata direct >>>>>>>>>>>>>>>");
		
		/* 2. Mod agregat - cascadare @OneoMany */
		this.registruProiect.salveazaProiect(proiect);
		logger.debug(">>>>>>>>>>>> Activitate salvata in agregat proiect >>>>>>>>>>>>>>>");
		
		logger.debug(">>>>>>>>>>>> END Creare activitate >>>>>>>>>>>>>>>");
		return activitate;
	}

	@Override
	public void startProiect(Proiect proiect) {
		System.out.println("To start project ....");
		// Schimba status proiect in started, schimba status prima activitate in started
		proiect.setStatus(Proiect.INITIALIZAT);
		System.out.println("To project started ....");
		Activitate primaActivitate = proiect.getActivitati().iterator().next();
		System.out.println("activity started ....");
		primaActivitate.setStatus(Activitate.IN_CURS);
		System.out.println("Finish starting project ....");
	}

	@Override
	public void progresActivitate(Activitate activitate, Double procent,
			Double cost, Date dataActualizata) {
		// Schimba status proiect in progress, actualizeaza activitate, actualizeaza linii de bugetare proiect
		if (activitate.getStatus().equals(Activitate.NE_PORNITA))
			activitate.setStatus(activitate.IN_CURS);
		activitate.setDataActualizare(dataActualizata);
		activitate.setProcentRealizare(activitate.getProcentRealizare() + procent);
		/* Actualizare buget ??? */
		//bugetareSrv.actualizareBuget(activitate.getProiect().getLinieBugetara(activitate), cost);
	}

	@Override
	public Double getSoldProiectInCurs(Integer idProiect, Date dataSold) {
		Proiect proiect = registruProiect.getProiect(idProiect); 
		ProcesorProiecte procesorProiecte = new ProcesorProiecte();
		Double buget = procesorProiecte.getBugetProiectInCurs(proiect, dataSold);
		Double cost = procesorProiecte.getCostProiectInCurs(proiect, dataSold);
		
		return buget - cost;
//		return null;
	}

	@Override
	public Proiect getProiect(Integer idProiect) {
		return registruProiect.getProiect(idProiect);
//		return null;
	}
	@Override
	public List<Proiect> getProiecte() {
		List<Proiect> proiecte = registruProiect.getToateProiectele();
		if (proiecte.isEmpty())
			logger.debug("Returner 000 proiecte!");
		else
			logger.debug("Returner " + proiecte.size() + " proiecte!");
		return proiecte;
	}
	@Override
	public Proiect creareProiect(Proiect proiectNou) throws Exception {
		logger.debug(">>>>>>>>>>>> Cerere buget: " + bugetareSrv);		
		Buget buget = bugetareSrv.creareBuget(proiectNou.getValoareBugetata());
		proiectNou.setBuget(buget);
		logger.debug("Buget proiect: " + buget.getValoareBuget());
		
		salvareProiect(proiectNou);
		
		logger.debug(">>>>>>>>>>>> END Creare proiect");
		return proiectNou;
	}
	
	@Override
	public Proiect salvareProiect(Proiect proiect) throws Exception {
		if (proiect.getBuget() == null){
			logger.debug(">>>>>>>>>>>> Cerere buget: " + bugetareSrv);		
			Buget buget = bugetareSrv.creareBuget(proiect.getValoareBugetata());
			proiect.setBuget(buget);
			logger.debug("Buget proiect: " + buget.getValoareBuget());			
		}
		
		/* Actiune tranzactionala ... */
		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Creare/salvare proiect - TRANZACTIE ANULATA");
			//throw new RuntimeException("Creare proiect - TRANZACTIE ANULATA");
		}else{
			proiect = this.registruProiect.salveazaProiect(proiect);
			//em.persist(proiectNou);
		}
		
		logger.debug(">>>>>>>>>>>> END salvare proiect");
		return proiect;
	}	
}
