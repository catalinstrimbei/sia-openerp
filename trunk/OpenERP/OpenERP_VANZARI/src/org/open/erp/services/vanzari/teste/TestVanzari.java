package org.open.erp.services.vanzari.teste;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.Comanda;
import org.open.erp.services.vanzari.FacturaEmisa;
import org.open.erp.services.vanzari.VanzariSrv;
import org.open.erp.services.vanzari.Vanzator;


/**
 * @author Irina Bogdan
 */

public class TestVanzari {
	VanzariSrv vanzariInstance;
	StocuriSrv stocuriInstance;
	NomenclatoareSrv nomenclatorInstance;
	ContabilizareSrv contabgenInstance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		vanzariInstance = VanzariFactory.getVanzariSrv();
		nomenclatorInstance = VanzariFactory.getNomenclatoareSrv();
		contabgenInstance = VanzariFactory.getContabGenSrv();
		stocuriInstance = VanzariFactory.getStocuriSrv();
	}
	
	@Test
	public void testinregistrareComanda() {
		Produs[] p = new Produs[2];
		p[1] = new Produs(1, "lapte batut", "buc", new Date(), 10, (float)0.24, (float)3.2, "nici una", 3.4); 
		p[2] = new Produs();
		Double cant[] = {2.0, 1.0};
		Client c = null;
		Comanda comanda = vanzariInstance.inregistrareComanda(p, cant, c);
		assertNotNull("Nu exista comanda!", comanda);
	}
	
	/*@Test
	public void testfacturareProduse(){
		Client client = new Client();
		Comanda comanda = new Comanda(1, new Date(), client, Comanda.PENDING);
		Vanzator vanz = new Vanzator();
		FacturaEmisa fact = vanzariInstance.facturareProduse(comanda, client, vanz);
		assertNotNull("Nu exista factura!", fact);
	}

	@Test
	public void testinregistrareFactura(){
		Client client = new Client();
		Vanzator vanzator = new Vanzator();
		FacturaEmisa factura = new FacturaEmisa(1, client, vanzator, FacturaEmisa.NEPLATITA);
		vanzariInstance.inregistrareFactura(factura);
		
	}*/
}
