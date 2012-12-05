package org.open.erp.services.buget.impl;


import org.apache.log4j.Logger;
import org.open.erp.services.buget.Buget;
import org.open.erp.services.buget.BugetareSrv;

import org.open.erp.services.buget.LinieBugetara;
import org.open.erp.services.buget.exceptions.BugetInvalidException;

/*
 * ERP Implementation
 * 
 */

public class BugetareImpl implements BugetareSrv{
	/* Dependente resurse proprii*/
	private static Logger logger = Logger.getLogger(BugetareImpl.class.getName());
	
	
	/* Initializare */
	public BugetareImpl() { }
	public void init(){ 
		logger.debug(">>>>>>>>>>>> init bugetare  " );		
	}
	
	
	/* Implementare actiuni serviciu BugetareSrv */
	@Override
	public Buget creareBuget(Double valoareBuget) throws Exception {
		logger.debug(">>>>>>>>>>>> START Creare buget");		
		Buget bugetNou = new Buget();
		
		if (valoareBuget <= 0){
			throw new BugetInvalidException("Valoare bugetata incorecta!");
			
		}else{
			bugetNou.setValoareBuget(valoareBuget);
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
