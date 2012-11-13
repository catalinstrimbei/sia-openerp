package org.open.erp.services.banci.teste;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBanciSrv {
	private static Logger logger;
	
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestBanciSrv.class.getName());	
	}
	
	@Before public void initServices(){	

	}
	
	@Test
	public void testCreareProiect() throws Exception{
		
	}
}
