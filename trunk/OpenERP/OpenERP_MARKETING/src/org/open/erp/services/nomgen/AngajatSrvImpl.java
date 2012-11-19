package org.open.erp.services.nomgen;

public class AngajatSrvImpl implements AngajatSrv {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AngajatSrvImpl.class.getName());

	public AngajatSrvImpl() {

	}

	@Override
	public Angajat creareAngajat() {
		logger.debug("1.1 Initiere/Creare angajat nou");

		Angajat angajatNou = new Angajat(1, "nume", "prenume", "rol");
		return angajatNou;
	}

}
