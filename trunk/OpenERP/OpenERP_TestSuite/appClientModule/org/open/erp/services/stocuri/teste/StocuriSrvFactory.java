package org.open.erp.services.stocuri.teste;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.open.erp.services.proman.ProjectManagementSrv;
import org.open.erp.services.proman.teste.ProjectManagementSrvFactory;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.impl.StocuriImpl;

public class StocuriSrvFactory {
	private static Logger logger = Logger.getLogger(StocuriSrvFactory.class.getName());
	
	public static StocuriSrv getStocuriSrv() throws Exception{
		return (StocuriSrv) lookupEJBService();
	}

	private static <T> T lookupEJBService() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        logger.info(Context.URL_PKG_PREFIXES);
        final Context context = new InitialContext(jndiProperties);
        logger.info("LOOKUP FOR OpenERP_STOCURI/StocuriImpl!org.open.erp.services.stocuri.StocuriSrv");
        return (T) context.lookup("ejb:/OpenERP_STOCURI/StocuriImpl!org.open.erp.services.stocuri.StocuriSrv");
	}	
}
/*
remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED=false
remote.connections=default
remote.connection.default.host=localhost
remote.connection.default.port = 4447
remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS=false
*/