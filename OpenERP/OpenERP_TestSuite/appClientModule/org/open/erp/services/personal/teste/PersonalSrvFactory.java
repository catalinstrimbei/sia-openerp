package org.open.erp.services.personal.teste;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.impl.NomenclatoareImpl;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.impl.PersonalImpl;


public class PersonalSrvFactory {
	private static Logger logger = Logger.getLogger(PersonalSrvFactory.class.getName());
	
	public static PersonalSrv getPersonalSrv() throws Exception{
		// PersonalSrv personal = new PersonalImpl();
				return (PersonalSrv) lookupEJBService();
	}

	private static <T> T lookupEJBService() throws NamingException {
	        final Hashtable jndiProperties = new Hashtable();
	        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	        logger.info(Context.URL_PKG_PREFIXES);
	        final Context context = new InitialContext(jndiProperties);
	        logger.info("LOOKUP FOR OpenERP_PERSONAL/PersonalImpl!org.open.erp.services.personal.PersonalSrv");
	        return (T) context.lookup("ejb:/OpenERP_PERSONAL/PersonalImpl!org.open.erp.services.personal.PersonalSrv");
	    }	
	
	
	public static NomenclatoareSrv getNomenclatoareSrv(){
		
		return new NomenclatoareImpl();
		
	}	
}
