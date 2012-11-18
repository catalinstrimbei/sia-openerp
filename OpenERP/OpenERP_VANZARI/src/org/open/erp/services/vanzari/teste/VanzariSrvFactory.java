package org.open.erp.services.vanzari.teste;

import org.apache.log4j.Logger;

import org.open.erp.services.personal.Personal;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.vanzari.VanzariSrv;
import org.open.erp.services.vanzari.impl.VanzariImpl;

public class VanzariSrvFactory {
	
	private static Logger logger = Logger.getLogger(VanzariSrvFactory.class.getName());
	
	public static VanzariSrv getVanzariSrv(){
		VanzariSrv vanzari = new VanzariImpl();
		logger.info("Creare instanta VanzariSRV din VanzariSrvFactory!");
		PersonalSrv personalSrv=VanzariSrvFactory.getPersonalSrv();
		vanzari.setPersonalSrv(personalSrv);
		return vanzari;
		
	}
	
	public static PersonalSrv getPersonalSrv(){
		logger.info("Creaza Dummy PERSONAL SRV----");
		return new PersonalSrv()
		{

			@Override
			public Personal preluarePersoana() {
				logger.info("5.1 a) Am delegat persoana responsabila");
				return new Personal();
			}
			
			
		};
	}


}
