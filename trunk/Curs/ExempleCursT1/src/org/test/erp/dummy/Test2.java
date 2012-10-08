package org.test.erp.dummy;

import org.erp.contgen.ServiciuContabilitateFactory;
import org.erp.contgen.impl1.ServiciuContabilitateFactoryImpl1;
import org.erp.vinzari.ServiciuVinzari;
import org.erp.vinzari.impl.ServiciuVinzariImpl;
import org.junit.Before;
import org.junit.Test;

public class Test2 {
	ServiciuContabilitateFactory contabilitateFactory;
	
    @Before public void initialize() {
    	contabilitateFactory = new ServiciuContabilitateFactoryImpl1();
     }

	
	@Test
	public void test() {
		ServiciuVinzari srvVinzari = 
				new ServiciuVinzariImpl(contabilitateFactory.getServiciuContabilitateInstance());
		
		srvVinzari.factureazaVinzare();
	}
}
