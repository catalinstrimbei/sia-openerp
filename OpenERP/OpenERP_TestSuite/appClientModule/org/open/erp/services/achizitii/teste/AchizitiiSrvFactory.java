package org.open.erp.services.achizitii.teste;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.open.erp.services.achizitii.AchizitiiSrv;

public class AchizitiiSrvFactory {
	private static Logger logger = Logger.getLogger(AchizitiiSrvFactory.class.getName());
	
	public static AchizitiiSrv getAchizitiiSrv() throws Exception{
		
//		AchizitiiImpl achizitiiSrv = new AchizitiiImpl();
//		NomenclatorMaterialeSrv nomGenSrv = AchizitiiSrvFactory.getAchizitiiMatSrv();
//		StocuriSrv stoc = new StocuriImpl();
//		
//		achizitiiSrv.setStocuriSrv(stoc);
//		
//		achizitiiSrv.setMaterialSrv(nomGenSrv);	
//		
//		logger.info("Crerare AchizitiiSrv instance from AchizitiiSrvFactory!");
		
		return (AchizitiiSrv) lookupEJBService();
	}

	private static <T> T lookupEJBService() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        logger.info(Context.URL_PKG_PREFIXES);
        final Context context = new InitialContext(jndiProperties);
        logger.info("LOOKUP FOR OpenERP_ACHIZITII/AchizitiiImpl!org.open.erp.services.achizitii.AchizitiiSrv");
        return (T) context.lookup("ejb:/OpenERP_ACHIZITII/AchizitiiImpl!org.open.erp.services.achizitii.AchizitiiSrv");
    }
}
