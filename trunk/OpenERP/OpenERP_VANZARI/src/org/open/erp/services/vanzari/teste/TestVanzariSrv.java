package org.open.erp.services.vanzari.teste;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.vanzari.VanzariSrv;

public class TestVanzariSrv {
	private static Logger logger;
	VanzariSrv vanzariInstance;
	
	
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestVanzariSrv.class.getName());	
		
	}
	
	@Before public void initServices(){	

		
	}
	
	@Test
	public void testCreareProiect() throws Exception{
		
	}
}
