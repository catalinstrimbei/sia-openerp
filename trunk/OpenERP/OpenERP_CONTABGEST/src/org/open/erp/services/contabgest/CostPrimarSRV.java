package org.open.erp.services.contabgest;


/**
 * 
 * @author andreea.andronic, marius.borsan, andreea.zaharia, anca.zavate
 * 
 * @ApplicationServiceFacade(ServiceDummyAPI)
 * 
 */

public interface CostPrimarSRV {
	
	public CosturiPrimare creareCosturiPrimare(Double valoareCosturiPrimare);
	public  LinieCost creareLinieCosturiPrimareInCosturiPrimare(CosturiPrimare costuriPrimare, Double valoareCosturiPrimare);
	public void actualizareCosturiPrimare(LinieCost linieCost, Double  valoareAprovizionareInterna);

}
