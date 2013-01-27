package org.open.erp.services.contabgest.teste;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.open.erp.services.contabgest.ContabilitateGestiuneSRV;


public class ContabilitateGestiuneSrvFactory {
private static Logger logger = Logger.getLogger(ContabilitateGestiuneSrvFactory.class.getName());
	
	public static ContabilitateGestiuneSRV getContabilitateGestiuneSRV() throws Exception{
		return (ContabilitateGestiuneSRV) lookupEJBService();
	}
	
    private static <T> T lookupEJBService() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        logger.info(Context.URL_PKG_PREFIXES);
        final Context context = new InitialContext(jndiProperties);
        logger.info("LOOKUP FOR OpenERP_CONTABGEST/ContabilitateGestiuneImpl!org.open.erp.services.contabgest.ContabilitateGestiuneSRV");
        return (T) context.lookup("ejb:/OpenERP_CONTABGEST/ContabilitateGestiuneImpl!org.open.erp.services.contabgest.ContabilitateGestiuneSRV");
    }	
}
