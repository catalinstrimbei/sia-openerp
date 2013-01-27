package org.open.erp.services.vanzari.teste;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.vanzari.Persoana;
import org.open.erp.services.vanzari.VanzariSrv;

public class TestVanzariEJB {
	
	
		// Resurse test
			private static Logger logger = Logger.getLogger(TestVanzariEJB.class.getName());
			
			// Unitatea de test sursa/gazda unitatii de test 
			public static VanzariSrv vanzariInstance;
			
			// Set up 
			@BeforeClass
			public static void setUpBeforeClass() throws Exception {
				vanzariInstance = VanzariSrvFactory.getVanzariSrv();
				logger.info("initTest " + vanzariInstance);
			}
			
			@Test
			public void testCrearePersoana() throws Exception{
				logger.info("-----***START creare persoana----- ");
				
				Persoana persoana = vanzariInstance.crearePersoana(1, "ION", "Ion", "sofer");
				
			
				logger.info("-----SFARSIT creare persoana----- " + persoana.getNume() );
				
			}
			
		
	}



