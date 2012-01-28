package org.open.erp.services.contabgest.teste;

import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.contabgest.ContabGestSrv;
//import org.open.erp.services.contabgest.DummyPersoana;
import static org.junit.Assert.assertNotNull;

public class TestContabGest {
	
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestContabGest.class.getName());
	static ContabGestSrv contabGestInstance;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//promanInstance= ProjectManagementDummyFactory.getProjectManagementSrv();
		System.out.println("ContabGestSrv initiated!");
		
		//nomenclatorInstance = ProjectManagementDummyFactory.getNomenclatoareSrv();
		logger.info("initTest " + contabGestInstance);		
		
	}
	
	//@Before
		public void setUp() throws Exception {
			
			System.out.println("ContabGestSrv initiated!");
			
			
			logger.info("initTest " + contabGestInstance);		
		}
		
		/*
		@Test
		public void testCrearePersoana() throws Exception {
			logger.info("Begin test: crearePersoana");
			
	
			DummyPersoana dummyPersoana = contabGestInstance.defDummyPersoana( "Abc", "Abc", "Abc");
			assertNotNull("Nu exista proiect nou!", dummyPersoana);
			
			logger.info("End test: crearePersoana");
		}
*/

}
