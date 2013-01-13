// package org.open.erp.services.finplati.teste;


package org.open.erp.services.finplati.teste;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.open.erp.services.finplati.FinanciarPlatiSrv;




public class FinanciarPlatiSrvFactory {
private static Logger logger = Logger.getLogger(FinanciarPlatiSrvFactory.class.getName());
	
	public static FinanciarPlatiSrv getFinanciarPlatiSrv() throws Exception{
		return (FinanciarPlatiSrv) lookupEJBService();
	}
	  private static <T> T lookupEJBService() throws NamingException {
	        final Hashtable jndiProperties = new Hashtable();
	        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	        logger.info(Context.URL_PKG_PREFIXES);
	        final Context context = new InitialContext(jndiProperties);
	        logger.info("LOOKUP FOR OpenERP_FINPLATI/FinanciarPlatiImpl!org.open.erp.services.finplati.FinanciarPlatiSrv");
	        return (T) context.lookup("ejb:/OpenERP_FINPLATI/FinanciarPlatiImpl!org.open.erp.services.finplati.FinanciarPlatiSrv");
	    }	
	
		
		
		
		
}