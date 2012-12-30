package org.open.erp.services.buget.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.open.erp.services.buget.Buget;
import org.open.erp.services.buget.BugetareSrv;
import org.open.erp.services.buget.BugetareSrvLocal;
import org.open.erp.services.buget.BugetareSrvRemote;
import org.open.erp.services.buget.LinieBugetara;
import org.open.erp.services.buget.exceptions.BugetInvalidException;

/*
 * ERP Implementation
 * 
 */
@Stateless
public class BugetareImpl implements BugetareSrv, BugetareSrvRemote, BugetareSrvLocal{
	/* Dependente resurse proprii*/
	private static Logger logger = Logger.getLogger(BugetareImpl.class.getName());
	
	/* Dependente resurse injectate*/
	@PersistenceContext(unitName="OpenERP_BUGET")
	private EntityManager em;	
	
	@Resource
	private SessionContext sessionContext;		
	
	/* Initializare */
	public BugetareImpl() { }
	@PostConstruct
	public void init(){ 
		logger.debug(">>>>>>>>>>>> Exista em ? " + em);		
	}
	
	
	/* Implementare actiuni serviciu BugetareSrv */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Buget creareBuget(Double valoareBuget) throws Exception {
		logger.debug(">>>>>>>>>>>> START Creare buget");		
		Buget bugetNou = new Buget();
		
		if (valoareBuget <= 0){
			//throw new BugetInvalidException("Valoare bugetata incorecta!");
			sessionContext.setRollbackOnly();
			
		}else{
			bugetNou.setValoareBuget(valoareBuget);
			em.persist(bugetNou);
			// cum aflu idul noului obiect ?? em.refresh(bugetNou);
			logger.debug(">>>>>>>>>>>> END Creare buget");
		}
		return bugetNou;
		
	}

	@Override
	public LinieBugetara creeareLinieBugetaraInBuget(Buget buget,
			Double valoareBuget) {
		return new LinieBugetara();
	}		

	@Override
	public void actualizareBuget(LinieBugetara linie, Double consum) {
		
	}
}
