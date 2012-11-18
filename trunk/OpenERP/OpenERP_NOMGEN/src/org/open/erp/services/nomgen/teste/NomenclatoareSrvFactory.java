package org.open.erp.services.nomgen.teste;

import org.apache.log4j.Logger;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.impl.NomenclatoareImpl;



public class NomenclatoareSrvFactory {
	private static Logger logger = Logger.getLogger(NomenclatoareSrvFactory.class.getName());
	
	public static NomenclatoareSrv getNomenSrv(){
		NomenclatoareSrv nomSrv = new NomenclatoareImpl();
				
		logger.info("Creare NomenclatoareSrv instance from NomenclatoareSrvFactory!");
		
		return nomSrv;
	}
}
