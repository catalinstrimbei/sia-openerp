package org.open.erp.services.marketing.teste;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.marketing.impl.MarketingSrvImpl;

public class TestMarketingSrv {
	private static Logger logger;
	private MarketingSrvImpl  marketingInstance;
	
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestMarketingSrv.class.getName());	
	}
	
	@Before public void initServices(){	
		logger.info("Marketing Service intiated for Test!");
	}
	
	@Test
	public void testCreareProiect() throws Exception{
		
	}
}
