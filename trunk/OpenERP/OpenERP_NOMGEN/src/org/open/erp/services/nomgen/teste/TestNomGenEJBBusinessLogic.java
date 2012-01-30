package org.open.erp.services.nomgen.teste;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nomgen.logger.NomgenLogger;

@SuppressWarnings("unused")
public class TestNomGenEJBBusinessLogic {

private static NomgenLogger logger;
	
	/* Unitatea de test sursa/gazda unitatii de test */
	private static NomenclatoareSrv NGInstance;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger = new NomgenLogger();
		InitialContext ctx = initJBossJNDICtx();
		NGInstance = (NomenclatoareSrv)ctx.lookup("NomenclatoareSrv/remote");		
		logger.logINFO("initTest " + NGInstance);
	
	}

	private static InitialContext initJBossJNDICtx() throws NamingException{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}	
	
	
	
	@Test
	public void TESTcautarePersoanaFizicaDupaPrenume() {
		try
		{
			logger.logINFO("Start test: TESTcautarePersoanaFizicaDupaPrenume");
			Collection<PersoanaFizica> LPF= NGInstance.getPF();	
			while (LPF.iterator().hasNext())
			{
			PersoanaFizica pf = LPF.iterator().next();
			PersoanaFizica pfnume = NGInstance.cautarePersoanaFizicaDupaPrenume(pf.getNume().toString());
			
			}					
			logger.logINFO("End test: TESTcautarePersoanaFizicaDupaPrenume");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}
	
	
	
	
	
	
	
	
	
}
