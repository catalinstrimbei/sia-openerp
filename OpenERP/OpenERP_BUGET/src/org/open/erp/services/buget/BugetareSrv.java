package org.open.erp.services.buget;

import javax.ejb.Remote;

/**
 * 
 * @author catalin.strimbei
 * 
 * @ApplicationServiceFacade(ServiceDummyAPI)
 */
public interface BugetareSrv {
	public Buget creareBuget(Double valoareBuget) throws Exception;
	public LinieBugetara creeareLinieBugetaraInBuget(Buget buget, Double valoareBuget);
	public void actualizareBuget(LinieBugetara linie, Double consum);
}
