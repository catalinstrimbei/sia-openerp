package org.open.erp.services.finincasari.teste;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.open.erp.services.finincasari.FinanciarIncasariSrv;
import org.open.erp.services.finincasari.impl.FinanciarIncasariImpl;



/**
 * @author Isabela
 *
 */
public class FinanciarIncasariSrvFactory  {
	
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(FinanciarIncasariSrvFactory.class.getName());
	
	
	public static FinanciarIncasariSrv getIncasariSrv() throws Exception{
		return (FinanciarIncasariSrv) lookupEJBService();
	}
		
	
	private static <T> T lookupEJBService() throws NamingException {
		
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        logger.info(Context.URL_PKG_PREFIXES);
        final Context context = new InitialContext(jndiProperties);
       
        logger.info("LOOKUP FOR OpenERP_FININCASARI/FinanciarIncasariImpl!org.open.erp.services.finincasari.FinanciarIncasariSrv");
        return (T) context.lookup("ejb:/OpenERP_FININCASARI/FinanciarIncasariImpl!org.open.erp.services.finincasari.FinanciarIncasariSrv");
	}
	
}



			
	


	



