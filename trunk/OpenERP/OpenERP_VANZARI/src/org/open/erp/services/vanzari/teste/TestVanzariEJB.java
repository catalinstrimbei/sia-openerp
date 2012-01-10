package org.open.erp.services.vanzari.teste;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.vanzari.VanzariSrv;
import org.open.erp.services.vanzari.impl.VanzariImpl;

public class TestVanzariEJB {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(VanzariImpl.class.getName());
	private static VanzariSrv vanzariInstance;
	private static StocuriSrv stocuriInstance;
	//NomenclatoareSrv nomenclatorInstance;
	//ContabilizareSrv contabgenInstance;
	
	/* Set up */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InitialContext ctx = initJBossJNDICtx();
		vanzariInstance = (VanzariSrv)ctx.lookup("VanzariSrv/remote");
		stocuriInstance = (StocuriSrv)ctx.lookup("StocuriSrv/remote");
		//nomenclatorInstance = (StocuriSrv)ctx.lookup("StocuriSrv/remote");
		
		logger.info("initTest " + vanzariInstance);
		logger.info("initTest " + stocuriInstance);
	}
	
	/*--- Utils: InitialContext Client EJB-JDNI ----------------------------------------------------*/
	private static InitialContext initJBossJNDICtx() throws NamingException{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}
	
	@Test
	public void testinregistrareComanda(){
		//vanzariInstance
	}
}
