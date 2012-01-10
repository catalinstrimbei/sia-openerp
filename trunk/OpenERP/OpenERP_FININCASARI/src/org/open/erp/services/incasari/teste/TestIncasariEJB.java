package org.open.erp.services.incasari.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.ctbgen.Cont;
import org.open.erp.services.ctbgen.Cont.StatusSintetic;
import org.open.erp.services.ctbgen.Cont.TipCont;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.RegConturi;
import org.open.erp.services.ctbgen.RegSablonNC;
import org.open.erp.services.ctbgen.SablonNC;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.incasari.BiletLaOrdin;
import org.open.erp.services.incasari.Cec;
import org.open.erp.services.incasari.Chitanta;
import org.open.erp.services.incasari.IncasariSrv;
import org.open.erp.services.incasari.exception.IncasariException;
import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.FacturaEmisa;

public class TestIncasariEJB {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(TestIncasariEJB.class.getName());

	private static IncasariSrv incasariSrvInstance;
	private static ContabilizareSrv ctbSrvInstance;

	DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
	FacturaEmisa fact1;
	FacturaEmisa fact2;
	ArrayList<FacturaEmisa> facturi;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		InitialContext ctx = initJBossJNDICtx();

		incasariSrvInstance = (IncasariSrv) ctx.lookup("IncasariImpl/remote");
		ctbSrvInstance = (ContabilizareSrv) ctx
				.lookup("ContabilizareImpl/remote");

		logger.info("initTest " + incasariSrvInstance);
		logger.info("initTest " + ctbSrvInstance);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		fact1 = new FacturaEmisa();
		fact1.setIdFactura(1);
		((Document) fact1).setDataDoc(dfm.parse("2010-01-01"));
		fact1.setValoareTotalaFactura(40.00);
		fact1.setSumaIncasata(10.00);
		fact1.setPlatita(false);
		fact2 = new FacturaEmisa();
		fact2.setIdFactura(2);
		fact2.setDataDoc(dfm.parse("2007-01-01"));
		fact2.setValoareTotalaFactura(40.00);
		fact2.setSumaIncasata(30.00);
		fact2.setPlatita(false);

		RegSablonNC regSablonNC = RegSablonNC.instantiaza();
		RegConturi regConturi = RegConturi.instantiaza();

		Cont c531 = new Cont(531, "casa", "531", "5", StatusSintetic.SINTETIC,
				TipCont.ACTIV);
		Cont c512 = new Cont(512, "banca", "512", "5", StatusSintetic.SINTETIC,
				TipCont.ACTIV);
		Cont c401 = new Cont(401, "Furnizori", "401", "4",
				StatusSintetic.SINTETIC, TipCont.PASIV);

		regConturi.addCont(c531);
		regConturi.addCont(c512);
		regConturi.addCont(c401);

		SablonNC sab9 = new SablonNC(1007, 7, c531, null);
		SablonNC sab10 = new SablonNC(1008, 8, c512, null);
		regSablonNC.addSablon(sab9);
		regSablonNC.addSablon(sab10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInregistrareChitanta() throws Exception {

		Date dataEmiterii = null;
		try {
			dataEmiterii = dfm.parse("2007-02-26");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Angajat casier = new Angajat();
		Client client = new Client();
		client.setId(1);
		facturi = new ArrayList<FacturaEmisa>();

		facturi.add(fact1);

		facturi.add(fact2);

		Chitanta chitanta = incasariSrvInstance.inregistrareChitanta(casier,
				Double.valueOf(40.00), "douazeci", false, facturi,
				dataEmiterii, "mx", 1, "sediu", "RON", client, null);

		logger.info("Chitanta are asociate " + chitanta.getFacturi().size()
				+ " facturi");
		assertNotNull("Chitanta nu are asociata o factura",
				chitanta.getFacturi());

		assertEquals("Chitanta nu are asociata nici o factura", 2, chitanta
				.getFacturi().size());
		logger.info(fact1.getSumaIncasata());
		assertEquals(
				"Facturile nu au fost asociate chitantei in ordine cronologica",
				Double.doubleToLongBits(40.00),
				Double.doubleToLongBits(fact2.getSumaIncasata()));
		logger.info(chitanta.getDataInregistrarii());
		assertNotNull(
				"Nu s-a preluat corect data inregistrarii pentru chitanta",
				chitanta.getDataInregistrarii());

	}

	@Test(expected = IncasariException.class)
	public void testInregistrareChitantaSumaExcedenta()
			throws IncasariException, CtbException {

		Date dataEmiterii = null;
		try {
			dataEmiterii = dfm.parse("2007-02-26");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Angajat casier = new Angajat();
		Client client = new Client();
		client.setId(1);
		facturi = new ArrayList<FacturaEmisa>();

		facturi.add(fact1);

		facturi.add(fact2);

		@SuppressWarnings("unused")
		Chitanta chitanta = incasariSrvInstance.inregistrareChitanta(casier,
				Double.valueOf(60.00), "douazeci", false, facturi,
				dataEmiterii, "mx", 1, "sediu", "RON", client, null);

	}

	@Test(expected = IncasariException.class)
	public void testInregistrareChitantaSumaNula() throws IncasariException,
			CtbException {

		Date dataEmiterii = null;
		try {
			dataEmiterii = dfm.parse("2007-02-26");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Angajat casier = new Angajat();
		Client client = new Client();
		client.setId(1);
		facturi = new ArrayList<FacturaEmisa>();

		facturi.add(fact1);

		facturi.add(fact2);

		@SuppressWarnings("unused")
		Chitanta chitanta = incasariSrvInstance.inregistrareChitanta(casier,
				null, "douazeci", false, facturi, dataEmiterii, "mx", 1,
				"sediu", "RON", client, null);

	}

	@Test
	public void testGetSumaRON() {

		Double suma = incasariSrvInstance.getSumaRON("EURO", 10.00, 4.00);

		logger.info(suma);
		assertEquals("Soldul nu a fost convertita corect in RON",
				Double.doubleToLongBits(40.00), Double.doubleToLongBits(suma));
	}
	
	
	@Test
	public void testInregistrareCec() throws Exception {

		Date dataEmiterii = null;
		try {
			dataEmiterii = dfm.parse("2007-02-26");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Client client = new Client();
		client.setId(1);
		facturi = new ArrayList<FacturaEmisa>();

		facturi.add(fact1);

		facturi.add(fact2);

		Cec cec = incasariSrvInstance.inregistrareCec( dataEmiterii, false,
				client,"bx", 2, "sediu", "depus", Double.valueOf(80.00), 
				"optzeci", facturi, "RON", null);

		logger.info("Cecul are asociate " + cec.getFacturi().size()
				+ " facturi");
		assertNotNull("Cecul nu are asociata o factura",
				cec.getFacturi());

		assertEquals("Cecul nu are asociata nici o factura", 2, cec.getFacturi().size());
		logger.info(fact1.getSumaIncasata());
		assertEquals(
				"Facturile nu au fost asociate cecului in ordine cronologica",
				Double.doubleToLongBits(80.00),
				Double.doubleToLongBits(fact2.getSumaIncasata()));
		logger.info(cec.getDataInregistrarii());
		assertNotNull(
				"Nu s-a preluat corect data inregistrarii pentru cec",
				cec.getDataInregistrarii());

	}
	
	
	@Test(expected = IncasariException.class)
	public void testInregistrareCecSumaExcedenta()
			throws IncasariException, CtbException {

		Date dataEmiterii = null;
		try {
			dataEmiterii = dfm.parse("2011-12-22");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Client client = new Client();
		client.setId(2);
		facturi = new ArrayList<FacturaEmisa>();

		facturi.add(fact1);

		facturi.add(fact2);

		@SuppressWarnings("unused")
		Cec cec = incasariSrvInstance.inregistrareCec( dataEmiterii, false,
				client,"bx", 2, "sediu", "depus", Double.valueOf(80.00), 
				"optzeci", facturi, "RON", null);

	}


        @Test(expected = IncasariException.class)
	public void testInregistrareCecSumaNula() 
			throws IncasariException, CtbException {

		Date dataEmiterii = null;
		try {
			dataEmiterii = dfm.parse("2011-05-23");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Client client = new Client();
		client.setId(4);
		facturi = new ArrayList<FacturaEmisa>();

		facturi.add(fact1);

		facturi.add(fact2);

		@SuppressWarnings("unused")
		Cec cec = incasariSrvInstance.inregistrareCec( dataEmiterii, false, 
				client,"wy", 4, "sediu", "depus", null , "zero", facturi, 
				"RON", null);

	}
	

        
        
        
        @Test
    	public void testInregistrareBiletLaOrdin() throws Exception {

    		Date dataEmiterii = null;
    		try {
    			dataEmiterii = dfm.parse("2011-07-22");
    		} catch (ParseException e) {
    			e.printStackTrace();
    		}

    		Date dataScadenta = null;
    		try {
    			dataScadenta = dfm.parse("2011-12-22");
    		} catch (ParseException e) {
    			e.printStackTrace();
    		}
    		
    		Persoana garant = new Persoana();
    		garant.setId(3);
    		Client client = new Client();
    		client.setId(1);
    		facturi = new ArrayList<FacturaEmisa>();

    		facturi.add(fact1);

    		facturi.add(fact2);

    BiletLaOrdin biletlaordin = incasariSrvInstance.inregistrareBiletLaOrdin( 
    				dataEmiterii, false, client,"gw",
    				2, "sediu", "depus", facturi, garant, dataScadenta, 
    				Double.valueOf(70.00), "saptezeci", "RON", null);

    		logger.info("Biletul la ordin are asociate " + biletlaordin.getFacturi().size()
    				+ " facturi");
    		assertNotNull("Biletul la ordin nu are asociata o factura",
    				biletlaordin.getFacturi());

    		assertEquals("Biletul la ordin nu are asociata nici o factura", 2, biletlaordin
    				.getFacturi().size());
    		logger.info(fact1.getSumaIncasata());
    		assertEquals(
    				"Facturile nu au fost asociate biletului la ordin in ordine cronologica",
    				Double.doubleToLongBits(80.00),
    				Double.doubleToLongBits(fact2.getSumaIncasata()));
    		logger.info(biletlaordin.getDataInregistrarii());
    		assertNotNull(
    				"Nu s-a preluat corect data inregistrarii pentru Biletul la ordin",
    				biletlaordin.getDataInregistrarii());

    	}
    	
        
        
        

	@Test(expected = IncasariException.class)
	public void testInregistrareBiletLaOrdinSumaExcedenta()
			throws IncasariException, CtbException {

		Date dataEmiterii = null;
		try {
			dataEmiterii = dfm.parse("2010-06-22");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Date dataScadenta = null;
		try {
			dataScadenta = dfm.parse("2010-07-22");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Persoana garant = new Persoana();
		garant.setId(3);
		Client client = new Client();
		client.setId(1);
		facturi = new ArrayList<FacturaEmisa>();

		facturi.add(fact1);

		facturi.add(fact2);

		@SuppressWarnings("unused")
		BiletLaOrdin biletlaordin = incasariSrvInstance.inregistrareBiletLaOrdin( 
				dataEmiterii, false, client,"gw",
				2, "sediu", "depus", facturi, garant, dataScadenta, 
				Double.valueOf(70.00), "saptezeci", "RON", null);

	}






        @Test(expected = IncasariException.class)
	public void testInregistrareBiletLaOrdinSumaNula()
			throws IncasariException, CtbException {

		Date dataEmiterii = null;
		try {
			dataEmiterii = dfm.parse("2011-05-23");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date dataScadenta = null;
		try {
			dataScadenta = dfm.parse("2010-07-22");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Persoana garant = new Persoana();
		garant.setId(3);
		Client client = new Client();
		client.setId(4);
		facturi = new ArrayList<FacturaEmisa>();

		facturi.add(fact1);

		facturi.add(fact2);

		@SuppressWarnings("unused")
		BiletLaOrdin biletlaordin = incasariSrvInstance.inregistrareBiletLaOrdin( 
				dataEmiterii, false, client,"gw",
				2, "sediu", "depus", facturi, garant, dataScadenta, 
				null, " zero", "RON", null);

	}
	private static InitialContext initJBossJNDICtx() throws NamingException {
		Properties props = new Properties();
		props.put("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		props.put("java.naming.provider.url", "jnp://localhost:1099/");
		props.put("java.naming.factory.url.pkgs",
				"org.jboss.naming:org.jnp.interfaces");
		return new InitialContext(props);
	}

}
