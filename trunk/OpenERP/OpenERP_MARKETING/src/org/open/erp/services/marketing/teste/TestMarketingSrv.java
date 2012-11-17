package org.open.erp.services.marketing.teste;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.marketing.impl.MarketingImpl;

public class TestMarketingSrv {
	private static Logger logger;
	private MarketingImpl  marketingInstance;
	
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestMarketingSrv.class.getName());	
	}
	
	@Before public void initServices(){	
//		logger.info("Marketing Service intiated for Test!");
		System.out.println("tesst");
	}
	
	@Test
	public void testCreareProiect() throws Exception{
		
	}
}
