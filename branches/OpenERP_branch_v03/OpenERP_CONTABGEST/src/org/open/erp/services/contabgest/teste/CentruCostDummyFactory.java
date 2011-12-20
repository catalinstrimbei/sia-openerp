package org.open.erp.services.contabgest.teste;

import org.open.erp.services.contabgest.CentruCostSRV;
import org.open.erp.services.contabgest.CostPrimarSRV;
import org.open.erp.services.contabgest.impl.CentruCostImpl;
import org.open.erp.services.contabgest.impl.CostPrimarImpl;

import org.open.erp.services.personal.PersonalSrv;

import org.open.erp.services.personal.impl.PersonalImpl;


public class CentruCostDummyFactory {

	
	public static CentruCostSRV getCentruCostSrv(){
		CentruCostImpl centruCostSrv = new CentruCostImpl();
		 centruCostSrv.setCostPrimarSRV(getCostPrimarSrv());
		return centruCostSrv;
	}
	
	public static CostPrimarSRV getCostPrimarSrv(){
		return new CostPrimarImpl();
	}
	

	
	public static PersonalSrv getPersonalSrv(){
		return new PersonalImpl();
	}
}
