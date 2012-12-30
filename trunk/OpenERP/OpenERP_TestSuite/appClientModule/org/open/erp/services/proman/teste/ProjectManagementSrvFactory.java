package org.open.erp.services.proman.teste;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.open.erp.services.proman.ProjectManagementSrv;
import org.open.erp.services.proman.impl.ProjectManagementImpl;

public class ProjectManagementSrvFactory {
	private static Logger logger = Logger.getLogger(ProjectManagementSrvFactory.class.getName());
	
	public static ProjectManagementSrv getProjectManagementSrv() throws Exception{
		return (ProjectManagementSrv) lookupEJBService();
	}
	
    private static <T> T lookupEJBService() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        logger.info(Context.URL_PKG_PREFIXES);
        final Context context = new InitialContext(jndiProperties);
        logger.info("LOOKUP FOR OpenERP_PROMAN/ProjectManagementImpl!org.open.erp.services.proman.ProjectManagementSrv");
        return (T) context.lookup("ejb:/OpenERP_PROMAN/ProjectManagementImpl!org.open.erp.services.proman.ProjectManagementSrv");
    }	
}
/*
remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED=false
remote.connections=default
remote.connection.default.host=localhost
remote.connection.default.port = 4447
remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS=false
*/
