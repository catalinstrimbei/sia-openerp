package org.open.erp.services.contabgest.impl;

import org.open.erp.services.contabgest.CostPrimarSRV;
import org.open.erp.services.contabgest.CosturiPrimare;
import org.open.erp.services.contabgest.LinieCost;

public class CostPrimarImpl implements CostPrimarSRV {
	
	
	public CosturiPrimare creareCosturiPrimare(Double valoareCosturiPrimare) {
		return new CosturiPrimare();
	}

	public LinieCost creareLinieCosturiPrimareInCosturiPrimare(CosturiPrimare costuriPrimare,
			Double valoareCosturiPrimare) {
		return new LinieCost();
	}	
	

	public void actualizareCosturiPrimare(LinieCost linie, Double valoareAprovizionareInterna) {
		
	}



}


