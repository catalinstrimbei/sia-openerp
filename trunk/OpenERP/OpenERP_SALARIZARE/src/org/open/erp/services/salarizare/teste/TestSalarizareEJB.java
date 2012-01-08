package org.open.erp.services.salarizare.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.salarizare.Pontaj;
import org.open.erp.services.salarizare.SalarizareSrv;
import org.open.erp.services.salarizare.impl.SalarizareImpl;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestSalarizareEJB {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SalarizareImpl.class.getName());
	private static SalarizareSrv salarizareSrvInstance;
	private static PersonalSrv personalSrvInstance;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InitialContext ctx = initJBossJNDICtx();
		salarizareSrvInstance = (SalarizareSrv)ctx.lookup("SalarizareSrv/remote");
		personalSrvInstance = (PersonalSrv)ctx.lookup("PersonalSrv/remote");
		
		logger.info("initTest " + salarizareSrvInstance);
		logger.info("initTest " + personalSrvInstance);
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

	//Test pentru inregistrarea pontajului pt un anumit angajat
	//load angajat din componenta EJB Personal
	@Test
	public void testInregistrarePontaj() throws Exception {
		logger.info("Begin test: inregistrarePontaj");
		Angajat angajat = personalSrvInstance.getAngajatById(1);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		Pontaj pontaj = salarizareSrvInstance.inregistrarePontaj(angajat, 2011, 11, 160.0, 0.0, 0.0);
		logger.info("A fost creat pontajul cu id-ul: "+pontaj.getIdPontaj());
		
		assertNotNull("Metoda de creere a pontajului nu a functionat!", pontaj.getIdPontaj());
		
		logger.info("End test: inregistrarePontaj");
	}
	
	//test metoda generare automata pontaj pe toata luna pt toti angajatii
	//propagare tranzactie intre inregistrare pontaj si inregistrarePontajLuna
	@Test
	public void testInregistrarePontajLuna() throws Exception {
		logger.info("Begin test: inregistrarePontaj");
		
		salarizareSrvInstance.inregistrarePontajLuna(2011, 11);
		
		logger.info("End test: inregistrarePontaj");
	}
	
	@Test
	public void calculSporuriAngajati() {
		logger.info("Begin test: calculSporuriAngajat");
		Double sporuri;
		Angajat angajat = personalSrvInstance.getAngajatById(1);
		
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		sporuri = salarizareSrvInstance.calculSporuriAngajat(2011, 11, angajat);
		logger.info("Sporurile insumate sunt: "+sporuri);
		
		assertNotNull("Metoda de creere a pontajului nu a functionat!", sporuri);
		
		logger.info("End test: calculSporuriAngajat");
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
