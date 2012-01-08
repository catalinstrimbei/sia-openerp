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
public class TestPersonalEJBregistru {

	/**
	 * @throws java.lang.Exception
	 */
	/* Resurse test*/
	private static PersonalLogger logger;
	
	/* Unitatea de test sursa/gazda unitatii de test */
	private static PersonalSrv personalInstance;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger = new PersonalLogger();
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
	public void testInserari() throws Exception {
		logger.logINFO("Begin test: Inserari");			
		TestPersonalImpl test = new TestPersonalImpl();
		test.generareAnunturi();
		test.initEvenimenteActivitati();
		Candidat candidat = personalInstance.salveazaCandidat(test.candidat1);
		Angajat	angajat = personalInstance.salveazaAngajat(test.angajat1);
		DosarAngajat	dosar = personalInstance.salveazaDosarAngajat(test.dosar1);
		ActivitateTeamBuilding	activitateTeamBld = personalInstance.salveazaActivitateTeamBuilding((ActivitateTeamBuilding)test.activitate1);
		//ActivitateTraining	activitateTraining = personalInstance.salveazaActivitateTraining((ActivitateTraining)test.activitate2);
		
		//AnuntLocMunca	anunt = personalInstance.salveazaAnuntLocMunca(test.anunt1);
		logger.logINFO("End test: Inserari");
	}
	
	
	
}
