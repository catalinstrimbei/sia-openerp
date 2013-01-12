// package org.open.erp.services.finplati.teste;


package org.open.erp.services.finplati.teste;

import org.apache.log4j.Logger;
import org.open.erp.services.achizitii.AchizitiiSrv;
import org.open.erp.services.achizitii.impl.AchizitiiImpl;
import org.open.erp.services.banci.BanciSrv;
import org.open.erp.services.banci.impl.BanciImpl;
import org.open.erp.services.finplati.*;
import org.open.erp.services.finplati.impl.FinanciarPlatiImpl;
import org.open.erp.services.finplati.FacturaStatus;
import org.open.erp.services.finplati.FurnizorContract;



public class FinanciarPlatiSrvFactory {
private static Logger logger = Logger.getLogger(FinanciarPlatiSrvFactory.class.getName());
	
	public static FinanciarPlatiSrv getFinanciarPlatiSrv(){
		
		FinanciarPlatiSrv financiarSrv = new FinanciarPlatiImpl();
		
		AchizitiiSrv achizitiiSrv = FinanciarPlatiSrvFactory.getFactAchizitiiSrv();
		//BanciSrv banciSrv =  FinanciarPlatiSrvFactory.getContBanciSrv();
		
		BanciSrv banciSrv = new BanciImpl();
		financiarSrv.setAchizitii(achizitiiSrv);
		financiarSrv.setBanci(banciSrv);
		
				
		logger.info("Creare FinanciarPlatiSrv instance from FinanciarPlatiSrvFactory!");
		
		return financiarSrv;
	}
		
	public static AchizitiiSrv getFactAchizitiiSrv(){
		logger.info("Creaza Dummy Achizitii SRV----");
		return new AchizitiiImpl();
	}
	public static BanciSrv getContBanciSrv(){
		logger.info("Creaza Dummy Banci SRV----");
		return new BanciImpl();
	}
}