package org.open.erp.services.vanzari.teste;
import static org.junit.Assert.*;

import java.util.ArrayList;
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
import org.open.erp.services.vanzari.LinieComanda;
import org.open.erp.services.vanzari.LinieFacturaEmisa;
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
		p[0] = new Produs(1, "lapte batut", "buc", new Date(), 10, (float)0.24, 3.2); 
		p[1] = new Produs();
		Double cant[] = {2.0, 1.0};
		Client client = new Client(1, 1, 2, "Gigel", "gigel@yahoo.com", "0987654321", "CT123456", 0.0);
		Comanda comanda = vanzariInstance.inregistrareComanda(p, cant, client);
		assertNotNull("Nu exista comanda!", comanda);
	}
	
	@Test
	public void testfacturareProduse(){
		Client client = new Client(1, 1, 2, "Gigel", "gigel@yahoo.com", "0987654321", "CT123456", 0.0);
		Produs produs = new Produs(1, "lapte batut", "buc", new Date(), 10, (float)0.24, 3.2);
		Comanda comanda = new Comanda(1, new Date(), client, Comanda.PENDING);
		//LinieComanda
		ArrayList<LinieComanda> lc = new ArrayList<LinieComanda>();
		lc.add(new LinieComanda(produs, 10.0));
		comanda.setProduseComandate(lc);
		Vanzator vanz = new Vanzator();
		FacturaEmisa fact = vanzariInstance.facturareProduse(comanda, client, vanz);
		assertNotNull("Nu exista factura!", fact);
	}
	
	@Test
	public void testGetFacturiClient(){
		Client client = new Client(1, 1, 2, "Gigel", "gigel@yahoo.com", "0987654321", "CT123456", 0.0);
		assertNotNull("Nu exista facturi", vanzariInstance.getFacturiClient(client));
	}
	
	@Test
	public void testReturProduse(){
		Client client = new Client(1, 1, 2, "Gigel", "gigel@yahoo.com", "0987654321", "CT123456", 0.0);
		Vanzator vanzator = new Vanzator();
		
		FacturaEmisa fact = new FacturaEmisa(1, client, vanzator, FacturaEmisa.NEPLATITA);
		
		Produs produs = new Produs(1, "lapte batut", "buc", new Date(), 10, (float)0.24, 3.2);
		LinieFacturaEmisa lf = new LinieFacturaEmisa(produs, 10.0);
		
		//fact.addLinie(lf);
		fact.getProduseFacturate().add(lf);
		
		vanzariInstance.returProduse(fact);
		
		// how to test a method that returns void? thinking (in progress)..
		
	}
	

	/*@Test
	public void testinregistrareFactura(){
		Client client = new Client(1, 1, 2, "Gigel", "gigel@yahoo.com", "0987654321", "CT123456", 0.0);
		Vanzator vanzator = new Vanzator();
		FacturaEmisa factura = new FacturaEmisa(1, client, vanzator, FacturaEmisa.NEPLATITA);
		Integer result = vanzariInstance.inregistrareFactura(factura);
		assertEquals("Nu s-a inregistrat in contabilitate", result.getClass().getSimpleName(),"Integer");
	}*/
}
