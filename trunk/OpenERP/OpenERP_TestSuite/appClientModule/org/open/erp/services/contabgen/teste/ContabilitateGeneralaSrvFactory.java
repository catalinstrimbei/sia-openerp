package org.open.erp.services.contabgen.teste;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.open.erp.services.contabgen.ContabilitateGeneralaSrv;
import org.open.erp.services.contabgen.conturi.Cont;
import org.open.erp.services.contabgen.rapoarte.BilantContabil;

public class ContabilitateGeneralaSrvFactory {

	private static Logger logger = Logger.getLogger(ContabilitateGeneralaSrvFactory.class.getName());
	
	public static ContabilitateGeneralaSrv getContabilitateGeneralaSrv() throws Exception{
		return (ContabilitateGeneralaSrv) lookupEJBService();
	}
	
    private static <T> T lookupEJBService() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        logger.info(Context.URL_PKG_PREFIXES);
        final Context context = new InitialContext(jndiProperties);
        logger.info("###Lookup### org.open.erp.services.contabgen.ContabilitateGeneralaSrv");
        return (T) context.lookup("ejb:/OpenERP_CONTABGEN/ContabilitateGeneralaImpl!org.open.erp.services.contabgen.ContabilitateGeneralaSrv");
    }

	public BilantContabil creareBilantContabil(ArrayList<Cont> conturi) {
		// TODO Auto-generated method stub
		return null;
	}	
}
