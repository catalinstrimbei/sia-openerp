package org.open.erp.services.plati.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.plati.DummyFurnizor;
import org.open.erp.services.ctbgen.Cont;
import org.open.erp.services.ctbgen.RegConturi;
import org.open.erp.services.ctbgen.RegSablonNC;
import org.open.erp.services.ctbgen.SablonNC;
import org.open.erp.services.ctbgen.Cont.StatusSintetic;
import org.open.erp.services.ctbgen.Cont.TipCont;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.nomgen.Document;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.plati.CEC;
import org.open.erp.services.plati.Chitanta;
import org.open.erp.services.plati.FacturaPrimita;
import org.open.erp.services.plati.FinPlatiSrv;
import org.open.erp.services.plati.OrdinPlata;
import org.open.erp.services.plati.exceptions.PlatiExceptions;

public class TestFinPlatiImpl {
	
FinPlatiSrv platiSrvInstance;
	
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	FacturaPrimita f1;
	FacturaPrimita f2;
	ArrayList<FacturaPrimita> facturi;

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(TestFinPlatiImpl.class.getName());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	
		platiSrvInstance = FinPlatiServiceFactory.getFinPlatiSrv();
		logger.info("initTest");
		f1 = new FacturaPrimita();
		f1.setIdFactura(1);
		((Document) f1).setDataDocument(df.parse("2012-01-01"));
		f1.setValoareTotalaFactura(33.00);
		f1.setSumaPlatita(13.00);
		f1.setPlatita(false);
		f2 = new FacturaPrimita();
		f2.setIdFactura(2);
		f2.setDataDocument(df.parse("2011-01-01"));
		f2.setValoareTotalaFactura(44.00);
		f2.setSumaPlatita(14.00);
		f2.setPlatita(false);
		
		RegSablonNC regSablonNC = RegSablonNC.instantiaza();
        RegConturi regConturi = RegConturi.instantiaza();    
        
        Cont c531 =new Cont(531,"casa","531","5",StatusSintetic.SINTETIC,TipCont.ACTIV);
        Cont c512 =new Cont(512,"banca","512","5",StatusSintetic.SINTETIC,TipCont.ACTIV);
        Cont c401 =new Cont(401,"Furnizori","401","4",StatusSintetic.SINTETIC, TipCont.PASIV);
        
        regConturi.addCont(c531); 
        regConturi.addCont(c512);
        regConturi.addCont(c401);
        
        SablonNC sab9= new SablonNC(1007,7,c531,null);
        SablonNC sab10= new SablonNC(1008,8,c512,null);
        regSablonNC.addSablon(sab9);       
        regSablonNC.addSablon(sab10);
	}

	@Test
	public void testInregistrareChitanta() throws Exception {

		Date dataEmiterii = null;
		try {
			dataEmiterii = df.parse("2011-01-13");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Angajat casier = new Angajat();
		DummyFurnizor furnizor = new DummyFurnizor(null, null, null, null);
		furnizor.setCUI("1");
		facturi = new ArrayList<FacturaPrimita>();

		facturi.add(f1);

		facturi.add(f2);

		Chitanta chitanta = platiSrvInstance.inregistrareChitanta(casier,
				Double.valueOf(44.00), false, facturi,
				dataEmiterii, "mx", 1, "sediu", "RON", furnizor, null);

		logger.info("Chitanta are asociate " + chitanta.getFacturi().size()
				+ " facturi");
		 assertNotNull("Chitanta nu are asociata o factura",
		 chitanta.getFacturi());
		 
		assertEquals("Chitanta nu are asociata nici o factura", 2, chitanta
				.getFacturi().size());
		logger.info(f1.getSumaPlatita());
		assertEquals(
				"Facturile nu au fost asociate chitantei in ordine cronologica",
				Double.doubleToLongBits(40.00),
				Double.doubleToLongBits(f2.getSumaPlatita()));
		logger.info(chitanta.getDataInregistrarii());
		assertNotNull(
				"Nu s-a preluat corect data inregistrarii pentru chitanta",
				chitanta.getDataInregistrarii());

	}

	@Test(expected = PlatiExceptions.class)
	public void testInregistrareChitantaSumaExcedenta()
			throws PlatiExceptions, CtbException {

		Date dataEmiterii = null;
		try {
			dataEmiterii = df.parse("2011-01-13");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Angajat casier = new Angajat();
		DummyFurnizor furnizor = new DummyFurnizor(null, null, null, null);
		furnizor.setCUI("1");
		facturi = new ArrayList<FacturaPrimita>();

		facturi.add(f1);

		facturi.add(f2);

		@SuppressWarnings("unused")
		Chitanta chitanta = platiSrvInstance.inregistrareChitanta(casier,
				Double.valueOf(88.00), false, facturi,
				dataEmiterii, "mx", 1, "sediu", "RON", furnizor, null);

	}
	
	@Test(expected = PlatiExceptions.class)
	public void testInregistrareChitantaSumaNula()
			throws PlatiExceptions, CtbException {

		Date dataEmiterii = null;
		try {
			dataEmiterii = df.parse("2011-01-13");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Angajat casier = new Angajat();
		DummyFurnizor furnizor = new DummyFurnizor(null, null, null, null);
		furnizor.setCUI("1");
		facturi = new ArrayList<FacturaPrimita>();

		facturi.add(f1);

		facturi.add(f2);

		@SuppressWarnings("unused")
		Chitanta chitanta = platiSrvInstance.inregistrareChitanta(casier,
				null, false, facturi,
				dataEmiterii, "mx", 1, "sediu", "RON", furnizor, null);

	}

	@Test
	public void testGetSumaRON() {

		Double suma = platiSrvInstance.getSumaRON("EURO", 10.00, 4.40);

		logger.info(suma);
		assertEquals("Soldul nu a fost convertita corect in RON",
				Double.doubleToLongBits(44.00), Double.doubleToLongBits(suma));
	}
	
	
	@Test(expected = PlatiExceptions.class)
	public void testInregistrareCecSumaExcedenta()
			throws PlatiExceptions, CtbException {

		Date dataEmiterii = null;
		try {
			dataEmiterii = df.parse("2012-01-03");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		DummyFurnizor furnizor = new DummyFurnizor(null, null, null, null);
		furnizor.setCUI("2");
		facturi = new ArrayList<FacturaPrimita>();

		facturi.add(f1);

		facturi.add(f2);

		@SuppressWarnings("unused")
		CEC cec = platiSrvInstance.inregistrareCEC(1112, dataEmiterii, false,
				furnizor,"mx", 2, "sediu", "depus", Double.valueOf(88.00), 
				facturi, "RON", null);

	}






        @Test(expected = PlatiExceptions.class)
	public void testInregistrareCecSumaNula() 
			throws PlatiExceptions, CtbException {

		Date dataEmiterii = null;
		try {
			dataEmiterii = df.parse("2012-01-05");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		DummyFurnizor furnizor = new DummyFurnizor(null, null, null, null);
		furnizor.setCUI("4");
		facturi = new ArrayList<FacturaPrimita>();

		facturi.add(f1);

		facturi.add(f2);

		@SuppressWarnings("unused")
		CEC cec = platiSrvInstance.inregistrareCEC(1112, dataEmiterii, false,
				furnizor,"mx", 2, "sediu", "depus", null, 
				facturi, "RON", null);

	}
	


	@Test(expected = PlatiExceptions.class)
	public void testInregistrareOrdinPlataSumaExcedenta()
			throws PlatiExceptions, CtbException {

		Date dataEmiterii = null;
		try {
			dataEmiterii = df.parse("2011-01-02");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		DummyFurnizor furnizor = new DummyFurnizor(null, null, null, null);
		furnizor.setCUI("1");
		facturi = new ArrayList<FacturaPrimita>();

		facturi.add(f1);

		facturi.add(f2);

		@SuppressWarnings("unused")
		OrdinPlata ordinPlata = platiSrvInstance.inregistrareOrdinPlata( 
				1111, dataEmiterii, false, furnizor,"mx",
				2, "sediu", "depus", Double.valueOf(88.00), facturi, "RON", null);

	}

        @Test(expected = PlatiExceptions.class)
	public void testInregistrareOrdinPlataSumaNula()
			throws PlatiExceptions, CtbException {

		Date dataEmiterii = null;
		try {
			dataEmiterii = df.parse("2012-01-08");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		DummyFurnizor furnizor = new DummyFurnizor(null, null, null, null);
		furnizor.setCUI("4");
		facturi = new ArrayList<FacturaPrimita>();

		facturi.add(f1);

		facturi.add(f1);

		@SuppressWarnings("unused")
		OrdinPlata ordinPlata= platiSrvInstance.inregistrareOrdinPlata( 
				1111, dataEmiterii, false, furnizor,"mx",
				2, "sediu", "depus", null, facturi, "RON", null);

	}

}

