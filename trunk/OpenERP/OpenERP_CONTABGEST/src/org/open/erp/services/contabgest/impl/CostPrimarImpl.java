package org.open.erp.services.contabgest.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.open.erp.services.contabgest.CostPrimarSRV;
import org.open.erp.services.contabgest.CostPrimarSRVLocal;
import org.open.erp.services.contabgest.CostPrimarSRVRemote;
import org.open.erp.services.contabgest.CosturiPrimare;
import org.open.erp.services.contabgest.LinieCost;

@Stateless

public class CostPrimarImpl implements CostPrimarSRV, CostPrimarSRVRemote, CostPrimarSRVLocal {
	
	
	private static Logger logger = Logger.getLogger(CostPrimarImpl.class.getName());
	
	
	
	@PersistenceContext (unitName="OpenERP_CONTABGEST")
	
	private EntityManager em;	
	
	@Resource
	
	private SessionContext sessionContext;		
	
	public CostPrimarImpl() { }
	
	@PostConstruct
	
	public void init(){ 
		logger.debug(">> Exista em ? " + em);		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	
	@Override
	public CosturiPrimare creareCosturiPrimare (Double valoareCosturiPrimare) throws Exception {
		
			logger.debug(">>START Creare cost primar");
		
		CosturiPrimare costuriPrimareNou = new CosturiPrimare();
		
		if (valoareCosturiPrimare <= 0){
			//throw new BugetInvalidException("Valoare cost primar incorecta!");
			sessionContext.setRollbackOnly();
			
		}
		else
		{
			costuriPrimareNou.setValoareCost(valoareCosturiPrimare);
			em.persist(costuriPrimareNou);
	
			logger.debug(">> END Creare cost primar");
		}
		return costuriPrimareNou;
		
	}

	@Override
	public LinieCost creareLinieCosturiPrimareInCosturiPrimare (CosturiPrimare costuriPrimare, Double valoareCosturiPrimare) {
		return new LinieCost();
	}		

	@Override
	public void actualizareCosturiPrimare (LinieCost linieCost, Double valoareAprovizionareInterna) {
		
	}
	
}
	
	
	
	
	
	




