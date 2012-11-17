package org.open.erp.services.stocuri.teste;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.achizitii.Produs;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.StocuriSrv;

public class TestStocuriSrv {
	private static Logger logger;
	
	StocuriSrv stocuriInstance;
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestStocuriSrv.class.getName());	
	}
	
	@Before public void initServices(){	
		stocuriInstance = StocuriSrvFactory.getStocuriSrv();
		logger.debug("StocuriSrv Service intiated for Test!");

	}
	
	@Test
	public void testIntrareStoc() throws Exception{
		
		
		//2.1. Preluare date produs
		
		logger.info("START creare date de test------ ");
		
		logger.info("START creare produse----- ");
		Produs produs1 = new Produs(1, "Produs 1", "produs finit", 2.2, 10.00 );
		Produs produs2 = new Produs(2, "Produs 2", "produs finit", 2.5, 10.00 );
		Produs produs3 = new Produs(3, "Produs 3", "produs finit", 2.7, 10.00 );
		Produs produs4 = new Produs(4, "Produs 4", "produs finit", 3.2, 10.00 );
		logger.info("FINAL creare produse----- ");
		
		logger.info("START creare gestiuni----- ");
		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));
		Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));
		logger.info("FINAL creare gestiuni----- ");
	
		logger.info("Start caz de utilizare instrare in stoc----- ");
		
		stocuriInstance.intrareStoc(produs3, gest2);
		stocuriInstance.intrareStoc(produs3, gest2);
		
		
		//2.2. Verificare date identificare lot
		
		//2.3. Modificare/crestere stoc curent
		
		//2.4 Confirmare stoc curent
		
	}
	
	
	
	
}
