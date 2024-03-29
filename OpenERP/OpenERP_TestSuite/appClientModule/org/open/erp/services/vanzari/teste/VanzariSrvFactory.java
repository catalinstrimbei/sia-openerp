package org.open.erp.services.vanzari.teste;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.open.erp.services.vanzari.VanzariSrv;

public class VanzariSrvFactory {

	private static Logger logger = Logger.getLogger(VanzariSrvFactory.class.getName());
		
		public static VanzariSrv getVanzariSrv() throws Exception{
			return (VanzariSrv) lookupEJBService();
		}

		private static <T> T lookupEJBService() throws NamingException {
			final Hashtable jndiProperties = new Hashtable();
	        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	        logger.info(Context.URL_PKG_PREFIXES);
	        final Context context = new InitialContext(jndiProperties);
	        logger.info("LOOKUP FOR OpenERP_VANZARI/VanzariImpl!org.open.erp.services.vanzari.VanzariSrv");
	        return (T) context.lookup("ejb:/OpenERP_VANZARI/VanzariImpl!org.open.erp.services.vanzari.VanzariSrv");
		}	
	}
