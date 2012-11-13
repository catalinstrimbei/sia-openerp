package org.open.erp.services.productie.teste;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestProductieSrv {
	private static Logger logger;
	
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestProductieSrv.class.getName());	
	}
	
	@Before public void initServices(){	

	}
	
	@Test
	public void testCreareProiect() throws Exception{
		
	}
}
