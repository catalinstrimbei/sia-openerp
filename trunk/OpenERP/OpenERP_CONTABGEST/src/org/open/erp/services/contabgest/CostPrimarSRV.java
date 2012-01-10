package org.open.erp.services.contabgest;


import javax.ejb.Remote;

/**
 * 
 * @author andreea.andronic, marius.borsan, andreea.zaharia, anca.zavate
 * 
 * @ApplicationServiceFacade(ServiceDummyAPI)
 * 
 */
public interface CostPrimarSRV {

	public CosturiPrimare creareCosturiPrimare(Double valoareCosturiPrimare) throws Exception;

	public LinieCost creareLinieCosturiPrimareInCosturiPrimare(
			CosturiPrimare costuriPrimare, Double valoareCosturiPrimare);

	public void actualizareCosturiPrimare(LinieCost linieCost,
			Double valoareAprovizionareInterna);

}
