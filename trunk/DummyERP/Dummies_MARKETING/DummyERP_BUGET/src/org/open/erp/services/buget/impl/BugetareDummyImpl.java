package org.open.erp.services.buget.impl;

import org.open.erp.services.buget.Buget;
import org.open.erp.services.buget.BugetareSrv;
import org.open.erp.services.buget.LinieBugetara;

/*
 * DummyImplementation
 * 
 */
public class BugetareDummyImpl implements BugetareSrv{

	@Override
	public Buget creareBuget(Double valoareBuget) {
		return new Buget();
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
