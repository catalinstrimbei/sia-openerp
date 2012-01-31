package org.open.erp.services.vanzari.teste;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;
//import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Produs;
//import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.Comanda;
import org.open.erp.services.vanzari.FacturaEmisa;
import org.open.erp.services.vanzari.LinieComanda;
import org.open.erp.services.vanzari.LinieFacturaEmisa;
import org.open.erp.services.vanzari.VanzariSrv;
import org.open.erp.services.vanzari.Vanzator;
import org.open.erp.services.vanzari.impl.VanzariImpl;

public class TestVanzariEJB {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(VanzariImpl.class.getName());
	private static VanzariSrv vanzariInstance;
//	private static StocuriSrv stocuriInstance;
	//NomenclatoareSrv nomenclatorInstance;
	//ContabilizareSrv contabgenInstance;
	
	/* Set up */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("before ctx");
		InitialContext ctx = initJBossJNDICtx();
		vanzariInstance = (VanzariSrv)ctx.lookup("VanzariImpl/remote");
		//stocuriInstance = (StocuriSrv)ctx.lookup("StocuriSrv/remote");
		//nomenclatorInstance = (StocuriSrv)ctx.lookup("StocuriSrv/remote");
		
		logger.info("initTest " + vanzariInstance);
		//logger.info("initTest " + stocuriInstance);
	}
	
	/*--- Utils: InitialContext Client EJB-JDNI ----------------------------------------------------*/
	private static InitialContext initJBossJNDICtx() throws NamingException{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}
	
	@Test
	public void testinregistrareComanda() {
		Produs[] p = new Produs[2];
		p[0] = new Produs(1, "lapte batut", "buc", new Date(), 10, (float)0.24, 3.2); 
		p[1] = new Produs();
		Double cant[] = {2.0, 1.0};
		Client client = new Client(1, "Gigel", "gigel@yahoo.com", "0987654321", "CT123456", 0.0);
		Comanda comanda = vanzariInstance.inregistrareComanda(p, cant, client);
		assertNotNull("Nu exista comanda!", comanda);
	}
	
	@Test
	public void testfacturareProduse(){
		Client client = new Client(1, "Gigel", "gigel@yahoo.com", "0987654321", "CT123456", 0.0);
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
		Client client = new Client(1, "Gigel", "gigel@yahoo.com", "0987654321", "CT123456", 0.0);
		assertNotNull("Nu exista facturi", vanzariInstance.getFacturiClient(client));
	}
	
	@Test
	public void testReturProduse(){
		Client client = new Client(1, "Gigel", "gigel@yahoo.com", "0987654321", "CT123456", 0.0);
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
