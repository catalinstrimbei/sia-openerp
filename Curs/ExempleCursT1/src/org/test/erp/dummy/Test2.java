package org.test.erp.dummy;

import org.erp.contgen.ServiciuContabilitateFactory;
import org.erp.contgen.impl1.ServiciuContabilitateFactoryImpl1;
import org.erp.vinzari.Factura;
import org.erp.vinzari.ServiciuVinzari;
import org.erp.vinzari.impl1.ServiciuVinzariImpl1;
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
				new ServiciuVinzariImpl1(contabilitateFactory.getServiciuContabilitateInstance());
		
		srvVinzari.factureazaVinzare(new Factura("1001", 250.0));
	}
}
