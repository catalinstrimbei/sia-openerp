package org.open.erp.services.contabgest.impl;

import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.PersistenceContext;

import org.open.erp.services.contabgest.Activitate;
import org.open.erp.services.contabgest.CentruCost;
import org.open.erp.services.contabgest.CentruCostSRV;
import org.open.erp.services.contabgest.CentruCostSRVLocal;
import org.open.erp.services.contabgest.CentruCostSRVRemote;
import org.open.erp.services.contabgest.CostPrimarSRV;
import org.open.erp.services.contabgest.CosturiPrimare;
import org.open.erp.services.contabgest.LinieCost;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.productie.FazaProductie;

/**
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */
@Stateless
public class CentruCostImpl implements CentruCostSRV, CentruCostSRVLocal, CentruCostSRVRemote{
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CentruCostImpl.class.getName());
	
	
	// referinte servicii (application service) dependente
	@PersistenceContext(unitName="OpenERP_CONTABGEST")
	private CostPrimarSRV costPrimarSRV;
	@Resource
	private SessionContext sessionContext;
	
	public CentruCostImpl() {

	}
	@PostConstruct
	public void init(){
		logger.debug("Exista cost primar ");
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	
	public void setCostPrimarSRV (CostPrimarSRV costPrimarSRV){
		this.costPrimarSRV=costPrimarSRV;
		
	}
	
	// alte referinte
	private RegistruCentruCost registruCentruCost = new RegistruCentruCost();
	
	/*
	 * 
	 * @ConstrutorForDummy
	 * 
	*/
	
	
	
	//implementare actiuni serviciu CentruCostSRV
	@Override
	public CentruCost creareCentruCost(String denumireCentruCost, FazaProductie faza, Angajat responsabil,
			Date dataStart, Date dataSfarsit, Double valoareCost) {
		
		logger.debug("Creare CentruCost");
		
		CentruCost centruCostNou = new CentruCost (1, denumireCentruCost, faza, dataStart, dataSfarsit, valoareCost, null, responsabil, null, null);
		if(valoareCost<= 0)
		{
			sessionContext.setRollbackOnly();
		}
		else
		{
		CosturiPrimare costuriPrimare = costPrimarSRV.creareCosturiPrimare(valoareCost);
		centruCostNou.setCosturiPrimare(costuriPrimare);
		
		logger.debug("CosturiPrimare centruCost: " + costuriPrimare.getValoareCost());
		}
		return centruCostNou;
	}
	
	
	
	
	@Override
	public Activitate creareActivitate(CentruCost centruCost, FazaProductie faza, Angajat responsabil, String denumireActivitate, 
			Date dataStart, Date dataSfarsit, Double costActivitate) {
		Activitate activitate = new Activitate(1, faza, denumireActivitate, dataStart, dataSfarsit, 
				costActivitate, responsabil);
		
		LinieCost linieCost = costPrimarSRV.creareLinieCosturiPrimareInCosturiPrimare(centruCost.getCosturiPrimare(), 
				activitate.getCostActivitate());
		centruCost.adaugaActivitate(activitate, linieCost);
		activitate.setCentruCost(centruCost);
		
		return activitate;
	}

	@Override
	public void startCentruCost(CentruCost centruCost) {
		// Schimba status centrului de cost in started, schimba status prima activitate in started
		centruCost.setStatus(CentruCost.ALOCAT);
		Activitate primaActivitate = centruCost.getActivitati().iterator().next();
		primaActivitate.setStatus(Activitate.IN_CURS);
		
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
		costPrimarSRV.actualizareCosturiPrimare(activitate.getCentruCost().getLinieCosturiPrimare(activitate), costActivitate);
	}

	@Override
	public Double getSoldCentruCostInCurs(Integer idCentruCost, Date dataSold) {
		CentruCost centruCost = registruCentruCost.getCentruCost(idCentruCost); 
		ProcesorCentruCost procesorCentruCost = new ProcesorCentruCost();
		Double costuriPrimare = procesorCentruCost.getCostPrimarCentruCostInCurs(centruCost, dataSold);
		Double costActivitate = procesorCentruCost.getSoldCentruCostInCurs(centruCost, dataSold);
		
		return costuriPrimare - costActivitate;
	}	
}

	
	
	



