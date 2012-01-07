/**
 * 
 */
package org.open.erp.services.personal.teste;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.personal.logger.*;
import org.open.erp.services.personal.*;

/**
 * @author Tolic
 *
 */
public class TestPersonalEJB {

	/**
	 * @throws java.lang.Exception
	 */
	/* Resurse test*/
	private static PersonalLogger logger;
	
	/* Unitatea de test sursa/gazda unitatii de test */
	private static PersonalSrv personalInstance;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InitialContext ctx = initJBossJNDICtx();
		personalInstance = (PersonalSrv)ctx.lookup("PersonalSrv/remote");
		logger.logINFO("initTest " + personalInstance);
	
	}

	private static InitialContext initJBossJNDICtx() throws NamingException{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}	

	@Test
	public void testFunctieById() throws Exception {
		Functie functie = personalInstance.getFunctie(101);
		System.out.println("Nume functie: " + functie.getNumeFunctie().toString());
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSalveazaFunctie() throws Exception {
		logger.logINFO("Begin test: adaugaFunctie");
				
		Functie functie = personalInstance.adaugaFunctie(101, "primaFunctie");
		
		logger.logINFO("Functia cu id: " + functie.getIdFunctie() + " a fost creata!");
		
		assertNotNull("Functie ne-validata!", functie.getIdFunctie());
		/*
		proiect = promanInstance.getProiect(proiect.getIdProiect());
		
		assertNotNull("Nu exista proiect nou!", proiect);
		*/
		logger.logINFO("End test: creareProiect");
		//TestPersonalImpl test = new TestPersonalImpl();		
		//fail("Not yet implemented");
	}
	
	
	
}
