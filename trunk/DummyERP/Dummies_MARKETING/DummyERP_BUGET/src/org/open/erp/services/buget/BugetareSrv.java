package org.open.erp.services.buget;

/**
 * 
 * @author catalin.strimbei
 * 
 * @ApplicationServiceFacade(ServiceDummyAPI)
 */
public interface BugetareSrv {
	public Buget creareBuget(Double valoareBuget);
	public LinieBugetara creeareLinieBugetaraInBuget(Buget buget, Double valoareBuget);
	public void actualizareBuget(LinieBugetara linie, Double consum);
}
