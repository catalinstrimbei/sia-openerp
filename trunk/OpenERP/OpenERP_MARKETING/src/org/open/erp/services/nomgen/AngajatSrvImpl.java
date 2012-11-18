package org.open.erp.services.nomgen;

import org.apache.log4j.Logger;

public class AngajatSrvImpl implements AngajatSrv {
	
	private static Logger logger;

	@Override
	public Angajat creareAngajat() {
		logger.debug("1.1 Initiere/Creare angajat nou");
		
		Angajat angajatNou = new Angajat();
		return angajatNou;
	}

}
