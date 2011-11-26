package org.open.erp.services.contabgest.impl;

import org.open.erp.services.contabgest.CentruCost;

public class RegistruCentruCost {
	
	
	public CentruCost getCentruCost(Integer id){
		CentruCost centruCost = new CentruCost();
		centruCost.setIdCentruCost(id);
		return centruCost;
	}

}
