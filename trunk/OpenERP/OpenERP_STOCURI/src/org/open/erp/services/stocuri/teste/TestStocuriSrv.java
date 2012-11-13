package org.open.erp.services.stocuri.teste;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestStocuriSrv {
	private static Logger logger;
	
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestStocuriSrv.class.getName());	
	}
	
	@Before public void initServices(){	

	}
	
	@Test
	public void testCreareProiect() throws Exception{
		
	}
}
