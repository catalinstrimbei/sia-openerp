package org.open.erp.services.salarizare.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.personal.*;
import org.open.erp.services.salarizare.*;
import org.open.erp.services.salarizare.impl.RegistruSalarizare;

public class TestSalarizareImpl {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestSalarizareImpl.class.getName());
	SalarizareSrv salarizareSrvInstance;
	PersonalSrv personalSrvInstance;
	RegistruSalarizare registruSalarizare;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		logger.info("initTest");
		salarizareSrvInstance= SalarizareDummyFactory.getSalarizareSrv();
		personalSrvInstance = SalarizareDummyFactory.getPersonalSrv();
		registruSalarizare = SalarizareDummyFactory.getRegistruSalarizare();
		logger.info("initTest");		
	}

	@Test
	public void testInregistrarePontaj() {
		logger.info("Begin test: inregistrarePontaj");
		Angajat angajat = personalSrvInstance.getAngajatById(1);
		Pontaj pontaj = salarizareSrvInstance.inregistrarePontaj(angajat, 2011, 11, 160.0, 0.0, 0.0);
		assertNotNull("Metoda de creere a pontajului nu a functionat!", pontaj);
		
		logger.info("End test: inregistrarePontaj");
	}
	
	@Test
	public void testInregistrarePontajLuna() {
		logger.info("Begin test: inregistrarePontaj");
		salarizareSrvInstance.inregistrarePontajLuna(2011, 11);
		logger.info("End test: inregistrarePontaj");
	}
	
	@Test
	public void testinregistrarStatSalariiLuna() {
		logger.info("Begin test: inregistrareStatSalariiLuna");
		salarizareSrvInstance.inregistrarStatSalariiLuna(2011, 11);
		logger.info("End test: inregistrareStatSalariiLuna");
	}
}
