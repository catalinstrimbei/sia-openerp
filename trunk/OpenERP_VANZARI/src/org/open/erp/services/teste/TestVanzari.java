package org.open.erp.services.teste;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import org.open.erp.services.impl.VanzariDummyImpl;
import org.open.erp.services.stocuri.ArticolStoc;
import org.open.erp.services.vanzari.*;

/*
 * @author Irina Bogdan
 */

public class TestVanzari {
	VanzariDummyImpl vanzariInstance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		vanzariInstance = VanzariDummyFactory.getVanzariSrv();
	}
	
	@Test
	public void testinregistrareComanda() {
		ArticolStoc p[] = {null};
		Float cant[] = {(float)0};
		Client c = null;
		Comanda comanda = vanzariInstance.inregistrareComanda(p, cant, c);
		assertNotNull("Nu exista comanda!", comanda);
	}
	
	@Test
	public void testfacturareProduse(){
		FacturaVanzare fact = vanzariInstance.facturareProduse(1, null);
		assertNotNull("Nu exista factura!", fact);
	}

}
