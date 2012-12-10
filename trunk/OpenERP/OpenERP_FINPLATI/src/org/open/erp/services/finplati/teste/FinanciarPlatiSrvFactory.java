/* package org.open.erp.services.finplati.teste;

import org.apache.log4j.Logger;
import org.open.erp.services.finplati.FinanciarPlatiSrv;
import org.open.erp.services.finplati.impl.FinanciarPlatiImpl;

public class FinanciarPlatiSrvFactory {
private static Logger logger = Logger.getLogger(FinanciarPlatiSrvFactory.class.getName());
	
	public static FinanciarPlatiSrv getFinanciarPlatiSrv(){
		FinanciarPlatiSrv sitfinSrv = new FinanciarPlatiImpl();
				
		logger.info("Creare FinanciarPlatiSrv instance from FinanciarPlatiSrvFactory!");
		
		return sitfinSrv;
	}
}
/*
 * 
 */
package org.open.erp.services.finplati.teste;

import org.apache.log4j.Logger;
import org.open.erp.services.finplati.*;
import org.open.erp.services.finplati.impl.FinanciarPlatiImpl;


public class FinanciarPlatiSrvFactory {
private static Logger logger = Logger.getLogger(FinanciarPlatiSrvFactory.class.getName());
	
	public static FinanciarPlatiSrv getFinanciarPlatiSrv(){
		FinanciarPlatiSrv financiarSrv = new FinanciarPlatiImpl();
				
		logger.info("Creare FinanciarPlatiSrv instance from FinanciarPlatiSrvFactory!");
		
		return financiarSrv;
	}
}