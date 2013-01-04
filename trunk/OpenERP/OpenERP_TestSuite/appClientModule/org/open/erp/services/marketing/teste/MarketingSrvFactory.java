package org.open.erp.services.marketing.teste;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.open.erp.services.marketing.MarketingSrv;
import org.open.erp.services.proman.teste.ProjectManagementSrvFactory;

public class MarketingSrvFactory {
	
private static Logger logger = Logger.getLogger(ProjectManagementSrvFactory.class.getName());
	
	public static MarketingSrv getMarketingSrv() throws Exception{
		return (MarketingSrv) lookupEJBService();
	}
	
    private static <T> T lookupEJBService() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        logger.info(Context.URL_PKG_PREFIXES);
        final Context context = new InitialContext(jndiProperties);
        logger.info("LOOKUP FOR OpenERP_MARKETING/MarketingSrvImpl!org.open.erp.services.marketing.MarketingSrv");
        return (T) context.lookup("ejb:/OpenERP_MARKETING/MarketingSrvImpl!org.open.erp.services.marketing.MarketingSrv");
    }	

}
