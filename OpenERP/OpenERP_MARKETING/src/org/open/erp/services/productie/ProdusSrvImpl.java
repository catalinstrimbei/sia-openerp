package org.open.erp.services.productie;

public class ProdusSrvImpl implements ProdusSrv {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ProdusSrvImpl.class.getName());

	public ProdusSrvImpl() {

	}

	@Override
	public Produs creareProdus() {
		logger.debug("1.1 Initiere/Creare produs nou");

		Produs produsNou = new Produs(1, "produs1");
		return produsNou;
	}

}
