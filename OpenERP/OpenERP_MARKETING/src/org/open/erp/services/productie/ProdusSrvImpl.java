package org.open.erp.services.productie;

import org.apache.log4j.Logger;

public class ProdusSrvImpl implements ProdusSrv {

	private static Logger logger;
	
	public ProdusSrvImpl(){
		
	}

	@Override
	public Produs creareProdus() {
		//logger.debug("1.1 Initiere/Creare produs nou");

		Produs produsNou = new Produs(1, "produs1");
		return produsNou;
	}

}
