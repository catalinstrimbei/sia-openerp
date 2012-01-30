package org.open.erp.services.plati.test;

import static org.junit.Assert.*;

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
import org.open.erp.services.plati.DummyFurnizor;
import org.open.erp.services.ctbgen.Cont;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.RegConturi;
import org.open.erp.services.ctbgen.RegSablonNC;
import org.open.erp.services.ctbgen.SablonNC;
import org.open.erp.services.ctbgen.Cont.StatusSintetic;
import org.open.erp.services.ctbgen.Cont.TipCont;
import org.open.erp.services.nomgen.Document;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.plati.Chitanta;
import org.open.erp.services.plati.FacturaPrimita;
import org.open.erp.services.plati.FinPlatiSrv;

public class TestFinPlatiEJB {
		private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
				.getLogger(TestFinPlatiEJB.class.getName());
		
		private static FinPlatiSrv platiSrvInstance;
		private static ContabilizareSrv ctbSrvInstance;
		
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
		FacturaPrimita fact1;
		FacturaPrimita fact2;
		ArrayList<FacturaPrimita> facturi;

		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			InitialContext ctx = initJBossJNDICtx();

			platiSrvInstance = (FinPlatiSrv) ctx.lookup("FinPlatiImpl/remote");
			ctbSrvInstance = (ContabilizareSrv) ctx
					.lookup("ContabilizareImpl/remote");

			logger.info("initTest " + platiSrvInstance);
			logger.info("initTest " + ctbSrvInstance);
		}


		@AfterClass
		public static void tearDownAfterClass() throws Exception {
		}

		@Before
		public void setUp() throws Exception {
			platiSrvInstance = FinPlatiServiceFactory.getFinPlatiSrv();
			logger.info("initTest");
			fact1 = new FacturaPrimita();
			fact1.setIdFactura(1);
			((Document) fact1).setDataDocument(dfm.parse("2011-01-01"));
			fact1.setValoareTotalaFactura(40.00);
			fact1.setSumaPlatita(10.00);
			fact1.setPlatita(false);
			fact2 = new FacturaPrimita();
			fact2.setIdFactura(2);
			fact2.setDataDocument(dfm.parse("2010-01-01"));
			fact2.setValoareTotalaFactura(40.00);
			fact2.setSumaPlatita(30.00);
			fact2.setPlatita(false);
			
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

		@After
		public void tearDown() throws Exception {
		}
		
		@Test
		public void testInregistrareChitanta() throws Exception {

			Date dataEmiterii = null;
			try {
				dataEmiterii = (Date) dfm.parse("2010-01-10");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Angajat casier = new Angajat();
			
			DummyFurnizor furnizor = new DummyFurnizor(1, "301256", "Istbercom", "Iasi");
			
			facturi = new ArrayList<FacturaPrimita>();

			facturi.add(fact1);

			facturi.add(fact2);

			Chitanta chitanta = platiSrvInstance.inregistrareChitanta(casier,
					Double.valueOf(40.00), false, facturi,
					dataEmiterii, "mx", 1, "sediu", "RON", furnizor, Double.valueOf(0.00));

			logger.info("Chitanta are asociate " + chitanta.getFacturi().size()
					+ " facturi");
			 assertNotNull("Chitanta nu are asociata o factura",
			 chitanta.getFacturi());
			 
			assertEquals("Chitanta nu are asociata nici o factura", 2, chitanta
					.getFacturi().size());
			logger.info(fact1.getSumaPlatita());
			assertEquals(
					"Facturile nu au fost asociate chitantei in ordine cronologica",
					Double.doubleToLongBits(40.00),
					Double.doubleToLongBits(fact2.getSumaPlatita()));
			logger.info(chitanta.getDataInregistrarii());
			assertNotNull(
					"Nu s-a preluat corect data inregistrarii pentru chitanta",
					chitanta.getDataInregistrarii());

		}
		
		@Test
		public void testGetSumaRON() {

			Double suma = platiSrvInstance.getSumaRON("EURO", 150.00, 4.23);

			logger.info(suma);
			assertEquals("Soldul nu a fost convertita corect in RON",
					Double.doubleToLongBits(40.00), Double.doubleToLongBits(suma));
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
