package org.open.erp.services.nommat.teste;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.open.erp.services.nommat.teste.NomenclatorMaterialeSrvFactory;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.nommat.impl.NomenclatorMaterialeImpl;


public class NomenclatorMaterialeSrvFactory {

	private static Logger logger = Logger.getLogger(NomenclatorMaterialeSrvFactory.class.getName());
	
	public static NomenclatorMaterialeSrv getNomenclatorMaterialeSrv() throws Exception{
		return (NomenclatorMaterialeSrv) lookupEJBService();
	}
	
	public static NomenclatorMaterialeSrv getNomenSrv(){
		NomenclatorMaterialeSrv nomSrv = new NomenclatorMaterialeImpl();
				
		logger.info("Creare NomenclatoarSrv instance from NomenclatoarMaterialeSrvFactory!");
		
		return nomSrv;
	}
    private static <T> T lookupEJBService() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        logger.info(Context.URL_PKG_PREFIXES);
        final Context context = new InitialContext(jndiProperties);
        logger.info("LOOKUP FOR OpenERP_NOMMAT/NomenclatorMaterialeImpl!org.open.erp.services.nommat.NomenclatorMaterialeSrv");
        return (T) context.lookup("ejb:/OpenERP_NOMMAT/NomenclatorMaterialeImpl!org.open.erp.services.nommat.NomenclatorMaterialeSrv");
    }	
}
