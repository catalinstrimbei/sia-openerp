package org.open.erp.services.finplati.teste;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFinanciarPlatiSrv {
	private static Logger logger;
	
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestFinanciarPlatiSrv.class.getName());	
	}
	
	@Before public void initServices(){	

	}
	
	@Test
	public void testCreareProiect() throws Exception{
		
	}
}
