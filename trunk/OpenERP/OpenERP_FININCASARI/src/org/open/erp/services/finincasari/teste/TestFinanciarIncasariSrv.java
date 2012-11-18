package org.open.erp.services.finincasari.teste;


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
import org.open.erp.services.contagen.exception.ContaException;
import org.open.erp.services.finincasari.BiletLaOrdine;
import org.open.erp.services.finincasari.CEC;
import org.open.erp.services.finincasari.Chitanta;
import org.open.erp.services.finincasari.FinanciarIncasariSrv;
import org.open.erp.services.finincasari.exception.FinanciarIncasariException;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.FacturaEmisa;



public class TestFinanciarIncasariSrv {
	
	
	FinanciarIncasariSrv FinanciarIncasariSrvInstance;
	
	DateFormat dfm = new SimpleDateFormat ("yyyy-MM-DD");
	FacturaEmisa fact1;
	FacturaEmisa fact2;
	
	ArrayList<FacturaEmisa>facturi;

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(TestFinanciarIncasariSrv.class.getName());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before 
	public void setUp () throws Exception {	
		
		FinanciarIncasariSrvInstance= FinanciarIncasariSrvFactory.getFinanciarIncasariSrv();
		logger.info("FinanciarIncasariSrv Service intiated for Test!");
		
		fact1 = new FacturaEmisa ();
		fact1.setIdFactura (1);
		fact1.setDataDoc(dfm.parse("2010-01-01"));
		fact1.setValoareTotalaFactura (40.00);
		fact1.setSumaIncasata(10.00);
		fact1.setPlatita(false);
		fact2 = new FacturaEmisa();
		fact2.setIdFactura (2); 
		fact2.setDataDoc (dfm.parse("2007-01-01"));
		fact2.setValoareTotalaFactura(40.00);
		fact2.setSumaIncasata(30.00);
		fact2.setPlatita(false);
		
		

		
      
	}
	
	

	@Test
	public void testInregistrareChitanta() throws Exception {

			Date dataEmitere = null;
			try {
				dataEmitere = dfm.parse("2007-02-26");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Angajat casier = new Angajat ();
			Client client = new Client ();
			client.setIdClient(1);
			facturi = new ArrayList<FacturaEmisa>();
			
			facturi.add (fact1);
			facturi.add (fact2);
			
			Chitanta chitanta = new Chitanta();
				chitanta.equals(FinanciarIncasariSrvInstance.inregistrareChitanta(casier,
					Double.valueOf(40.00), "douazeci", false, facturi,
					dataEmitere, "mx", 1, "sediu", "RON", client, null));
			
			
			logger.info("Chitanta are asociata " +chitanta.getFacturi().size() + " facturi");
			assertNotNull("Chitanta nu are asociata nicio factura",chitanta.getFacturi());
			 
			assertEquals("Chitanta nu are asociata nici o factura", 0, chitanta.getFacturi().size());
			
			logger.info(fact1.getSumaIncasata());
			
			assertEquals(
					"Facturile nu au fost asociate chitantei in ordine cronologica",
					Double.doubleToLongBits(40.00),
					Double.doubleToLongBits(fact2.getSumaIncasata()));
					logger.info(chitanta.getDataInregistrarii());
					
			assertNotNull("Nu s-a preluat corect data inregistrarii pentru chitanta",chitanta.getDataInregistrarii());
		}
		
	
	@Test(expected = FinanciarIncasariException.class)
		 
		public void testInregistrareChitantaSumaExcedenta() throws FinanciarIncasariException,ContaException  {
			Date dataEmitere = null;
			try {
				dataEmitere = dfm.parse("2007-02-27");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Angajat casier = new Angajat();
			Client client = new Client();
			client.setIdClient(1);
			facturi = new ArrayList<FacturaEmisa>();

			facturi.add(fact1);

			facturi.add(fact2);

			@SuppressWarnings("unused")
			Chitanta chitanta = FinanciarIncasariSrvInstance.inregistrareChitanta(casier,Double.valueOf(60.00),
					"douazeci", false, facturi,dataEmitere, "mx", 1, "sediu", "RON", client, null);

		}
		

	@Test(expected = FinanciarIncasariException.class)
		
		public void testInregistrareChitantaSumaNula() throws FinanciarIncasariException, ContaException {

			Date dataEmitere = null;
				try {
					dataEmitere = dfm.parse("200-02-27");
					} 
				catch (ParseException e) {
					e.printStackTrace();
					}
				
		Angajat casier = new Angajat();
		Client client = new Client();
		client.setIdClient(1);
		facturi = new ArrayList<FacturaEmisa>();
	
		facturi.add(fact1);
	
		facturi.add(fact2);
	
		@SuppressWarnings("unused")
		Chitanta chitanta = FinanciarIncasariSrvInstance.inregistrareChitanta(casier,
				null, "douazeci", false, facturi,
				dataEmitere, "mx", 1, "sediu", "RON", client, null);

}

	@Test
	public void testGetSumaRON() {
	
		Double suma = FinanciarIncasariSrvInstance.getSumaRON("EURO", 15.00, 4.00);
	    
		logger.info("Suma RON!");
		logger.info(suma);
		assertEquals("Soldul nu a fost convertita corect in RON",Double.doubleToLongBits(60.00), Double.doubleToLongBits(suma));
		
	}
	

	public void testInregistrareCECSumaExcedenta()
			throws FinanciarIncasariException, ContaException {

		Date dataEmitere = null;
		try {
			dataEmitere = dfm.parse("2011-12-22");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Client client = new Client();
		client.setIdClient(2);
		facturi = new ArrayList<FacturaEmisa>();

		facturi.add(fact1);

		facturi.add(fact2);

		@SuppressWarnings("unused")
		CEC cec = FinanciarIncasariSrvInstance.inregistrareCEC( dataEmitere, false,
				client,"ab", 2, "sediu", "depus", Double.valueOf(80.00), 
				"optzeci", facturi, "RON", null);

	}

        @Test(expected = FinanciarIncasariException.class)
	public void testInregistrareCECSumaNula() 
			throws FinanciarIncasariException, ContaException {

		Date dataEmitere = null;
		try {
			dataEmitere = dfm.parse("2011-05-23");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Client client = new Client();
		client.setIdClient(4);
		facturi = new ArrayList<FacturaEmisa>();

		facturi.add(fact1);

		facturi.add(fact2);

		@SuppressWarnings("unused")
		CEC cec = FinanciarIncasariSrvInstance.inregistrareCEC( dataEmitere, false, 
				client,"xy", 4, "sediu", "depus", null , "zero", facturi, 
				"RON", null);

	}
	


	@Test(expected = FinanciarIncasariException.class)
	public void testInregistrareBiletLaOrdineSumaExcedenta()
			throws FinanciarIncasariException, ContaException {

		Date dataEmitere = null;
		try {
			dataEmitere = dfm.parse("2010-06-22");
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
		garant.setIdpersoana(3);
		Client client = new Client();
		client.setIdClient(1);
		facturi = new ArrayList<FacturaEmisa>();

		facturi.add(fact1);

		facturi.add(fact2);

		@SuppressWarnings("unused")
		BiletLaOrdine biletlaordine = FinanciarIncasariSrvInstance.inregistrareBiletLaOrdine( 
				dataEmitere, false, client,"gw",
				2, "sediu", "depus", facturi, garant, dataScadenta, 
				Double.valueOf(70.00), "saptezeci", "RON", null);

	}


        @SuppressWarnings("unused")
		@Test(expected = FinanciarIncasariException.class)
	public void testInregistrareBiletLaOrdineSumaNula()
			throws FinanciarIncasariException, ContaException {

		Date dataEmitere = null;
		try {
			dataEmitere = dfm.parse("2011-05-23");
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
		garant.setIdpersoana(3);
		Client client = new Client();
		client.setIdClient(4);
		facturi = new ArrayList<FacturaEmisa>();

		facturi.add(fact1);

		facturi.add(fact2);

	
		BiletLaOrdine biletlaordine = FinanciarIncasariSrvInstance.inregistrareBiletLaOrdine( 
				dataEmitere, false, client,"gw",2, "sediu", "depus", facturi, garant, dataScadenta, null, " zero", "RON", null);
	
	

	}

}
	
