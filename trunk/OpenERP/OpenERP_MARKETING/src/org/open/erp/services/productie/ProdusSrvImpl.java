package org.open.erp.services.productie;

import org.apache.log4j.Logger;

public class ProdusSrvImpl implements ProdusSrv {

	private static Logger logger;

	@Override
	public Produs creareProdus() {
		logger.debug("1.1 Initiere/Creare produs nou");

		Produs produsNou = new Produs();
		return produsNou;
	}

}
