package org.open.erp.services.contabgest.impl;

import java.util.Date;
import java.util.logging.Logger;

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


import org.open.erp.services.contabgest.Activitate;
import org.open.erp.services.contabgest.ActivitateCentruCost;
import org.open.erp.services.contabgest.CentruCost;
import org.open.erp.services.contabgest.CentruCostSRV;
import org.open.erp.services.contabgest.CentruCostSRVLocal;
import org.open.erp.services.contabgest.CentruCostSRVRemote;
import org.open.erp.services.contabgest.CostPrimarSRV;
import org.open.erp.services.contabgest.CostPrimarSRVLocal;
import org.open.erp.services.contabgest.CosturiPrimare;
import org.open.erp.services.contabgest.LinieCost;
import org.open.erp.services.contabgest.Responsabil;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.productie.FazaProductie;

/**
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */
@Stateless(name="CentruCostSRV")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CentruCostImpl implements CentruCostSRV, CentruCostSRVLocal, CentruCostSRVRemote{
	
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CentruCostImpl.class.getName());
	private RegistruCentruCost registruCentruCost;
	
	// referinte servicii (application service) dependente
	@PersistenceContext(unitName="OpenERP_CONTABGEST")
	private EntityManager em;
	@Resource
	private SessionContext sessionContext;
	
	@EJB(mappedName="CostPrimarImpl/local")
	
	private CostPrimarSRVLocal CostPrimarSRV;
	
	
	public CentruCostImpl() {

	}
	@PostConstruct
	public void init(){
		logger.debug(">> Exista em? " + em);		
		logger.debug(">> Exista CostPrimarSrv? " + CostPrimarSRV);		
		
		if (this.registruCentruCost == null)
			registruCentruCost = new RegistruCentruCost(em);
				
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	//implementare actiuni serviciu CentruCostSRV
		@Override
		public CentruCost creareCentruCost(String denumireCentruCost, FazaProductie faza, Angajat responsabil,
				Date dataStart, Date dataSfarsit, Double valoareCost) throws Exception {
			
		
			System.out.println(">> START Creare CentruCost");

			logger.debug("Creare CentruCost");
							
			//CentruCost centruCostNou = new CentruCost(1, denumireCentruCost, dataStart, dataSfarsit, sumaCentruCost, responsabil);
			CentruCost centruCostNou = new CentruCost (denumireCentruCost,faza, responsabil, dataStart, dataSfarsit, valoareCost);
			
			logger.debug(">> Cerere costPrimar: " + CostPrimarSRV);		
			CosturiPrimare CosturiPrimare = CostPrimarSRV.creareCosturiPrimare(valoareCost);
			centruCostNou.setCosturiPrimare(CosturiPrimare);
			logger.debug("CostPrimar centruCost: " + CosturiPrimare.getValoareCost());
			
		
			if (sessionContext.getRollbackOnly() == true){
				logger.debug(">> END Creare centruCost - TRANZACTIE ANULATA");
				//throw new RuntimeException("Creare centruCost - TRANZACTIE ANULATA");
			}
			else
			{
				centruCostNou = this.registruCentruCost.salveazaCentruCost(centruCostNou);
				//em.persist(centruCostNou);
			}
			
			logger.debug(">> END Creare centruCostNou");
			return centruCostNou;
		
					
		}
	
	
	@Override
	public Activitate creareActivitate(CentruCost centruCost, FazaProductie faza,
			Angajat responsabil, String denumireCentru, Date dataStart,
			Date dataSfarsit, Double costActivitate) throws Exception 
			{
		logger.debug(">>START CREARE ACTIVITATE");
	
		ActivitateCentruCost activitate = new ActivitateCentruCost (denumireCentru, dataStart, dataSfarsit, 
				costActivitate, responsabil);
		centruCost.adaugaActivitate(activitate);
		activitate.setCentruCost(centruCost);
				
		
		this.registruCentruCost.salveazaCentruCost(centruCost);
		logger.debug(">>Activitate salvata in centru cost");
		logger.debug(">> END creare Activitate");
		return activitate;
		
			}

	@Override
	public void startCentruCost(CentruCost centruCost) {
		// Schimba status centrului de cost in started, schimba status prima activitate in started
		System.out.println("To start centru cost..");
		
		centruCost.setStatus(CentruCost.ALOCAT);
		System.out.println("To centru cost started..");
		
		Activitate primaActivitate = centruCost.getActivitati().iterator().next();
		System.out.println("activity started..");
		
		primaActivitate.setStatus(Activitate.IN_CURS);
		System.out.println("Finish starting centru cost");
		
	}
	@Override
	public void progresActivitate(Activitate activitate, Double procentRealizare,
			Double costActivitate, Date dataActualizata) {
		// Schimba status centru cost in progress, actualizeaza activitate, actualizeaza linii de costuri primare in centru cost
		if (activitate.getStatus().equals(Activitate.NE_PORNITA))
			activitate.setStatus(Activitate.IN_CURS);
		activitate.setDataActualizare(dataActualizata);
		activitate.setProcentRealizare(activitate.getProcentRealizare() + procentRealizare);
		// Actualizare costuri primare
		//costPrimarSRV.actualizareCosturiPrimare(activitate.getCentruCost().getLinieCosturiPrimare(activitate), costActivitate);
	}

	@Override
	public Double getSoldCentruCostInCurs(Integer idCentruCost, Date dataSold) {
		CentruCost centruCost = registruCentruCost.getCentruCost(idCentruCost); 
		ProcesorCentruCost procesorCentruCost = new ProcesorCentruCost();
		Double costuriPrimare = procesorCentruCost.getCostPrimarCentruCostInCurs(centruCost, dataSold);
		Double costActivitate = procesorCentruCost.getSoldCentruCostInCurs(centruCost, dataSold);
		
		return costuriPrimare - costActivitate;
	}

	
	@Override
	public CentruCost getCentruCost(Integer idCentruCost) {
		return registruCentruCost.getCentruCost(idCentruCost);
	}
	public void setCostPrimarSRV(CostPrimarSRV costPrimarSrv) {
		// TODO Auto-generated method stub
		
	}	
}

	
	
	



