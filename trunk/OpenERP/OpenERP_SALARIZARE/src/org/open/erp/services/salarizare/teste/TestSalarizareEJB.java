package org.open.erp.services.salarizare.teste;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.salarizare.SalarizareSrv;
import org.open.erp.services.salarizare.impl.SalarizareImpl;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestSalarizareEJB {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SalarizareImpl.class.getName());
	private static SalarizareSrv salarizareInstance;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InitialContext ctx = initJBossJNDICtx();
		salarizareInstance = (SalarizareSrv)ctx.lookup("SalarizareSrv/remote");
		logger.info("initTest " + salarizareInstance);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	/*--- Utils: InitialContext Client EJB-JDNI ----------------------------------------------------*/
	private static InitialContext initJBossJNDICtx() throws NamingException{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}		
}
