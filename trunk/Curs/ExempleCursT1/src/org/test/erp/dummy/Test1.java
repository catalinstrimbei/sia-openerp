package org.test.erp.dummy;

import static org.junit.Assert.*;

import org.erp.contgen.ServiciuContabilitateGenerala;
import org.erp.contgen.impl1.ServiciuContabilitateGeneralaImpl1;
import org.erp.contgen.impl2.ServiciuContabilitateGeneralaImpl2;
import org.erp.vinzari.ServiciuVinzari;
import org.erp.vinzari.impl.ServiciuVinzariImpl;
import org.junit.Before;
import org.junit.Test;

public class Test1 {

	ServiciuContabilitateGenerala srvContab;
	
    @Before public void initialize() {
    	srvContab = new ServiciuContabilitateGeneralaImpl2();
    	
     }

	
	@Test
	public void test() {
		ServiciuVinzari srvVinzari = new ServiciuVinzariImpl(srvContab);
		srvVinzari.factureazaVinzare();
	}

}
