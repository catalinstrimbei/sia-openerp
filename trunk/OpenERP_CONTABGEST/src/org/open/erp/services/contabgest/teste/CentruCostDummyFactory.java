package org.open.erp.services.contabgest.teste;

import org.open.erp.services.contabgest.CentruCostSRV;
import org.open.erp.services.contabgest.CostPrimarSRV;
import org.open.erp.services.contabgest.impl.CentruCostImpl;
import org.open.erp.services.contabgest.impl.CostPrimarImpl;
import org.open.erp.services.personal.PersonalSRV;
import org.open.erp.services.personal.impl.PersonalDummyImpl;


public class CentruCostDummyFactory {

	
	public static CentruCostSRV getCentruCostSrv(){
		CentruCostImpl centruCostSrv = new CentruCostImpl();
		 centruCostSrv.setCostPrimarSRV(getCostPrimarSrv());
		return centruCostSrv;
	}
	
	public static CostPrimarSRV getCostPrimarSrv(){
		return new CostPrimarImpl();
	}
	
	// ASA?!?!
	
	public static PersonalSRV getPersonalSrv(){
		return new PersonalDummyImpl();
	}
}
