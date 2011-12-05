package org.open.erp.services.incasari.teste;

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
import org.open.erp.services.incasari.Chitanta;
import org.open.erp.services.incasari.IncasariSrv;
import org.open.erp.services.nomgen.Document;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.FacturaEmisa;
import org.open.erp.services.vanzari.VanzariSrv;

public class TestIncasariImpl {

	VanzariSrv vanzariSrvInstance;
	IncasariSrv incasariSrvInstance;

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(TestIncasariImpl.class.getName());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		vanzariSrvInstance = IncasariDummyFactory.getVanzariSrv();
		incasariSrvInstance = IncasariDummyFactory.getIncasariSrv();
		logger.info("initTest");
	}

	@Test
	public void testInregistrareChitanta() throws Exception {
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
		Date dataEmiterii = null;
		try {
			dataEmiterii = dfm.parse("2007-02-26");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Angajat casier = new Angajat();
		Client client = new Client();
		ArrayList<FacturaEmisa> facturi = new ArrayList<FacturaEmisa>();
		FacturaEmisa fact1 = new FacturaEmisa();
		fact1.setIdFactura(1);
		((Document) fact1).setDataDoc(dfm.parse("2010-01-01"));
		fact1.setValoareTotalaFactura(40.00);
		fact1.setSumaIncasata(10.00);
		facturi.add(fact1);
		FacturaEmisa fact2 = new FacturaEmisa();
		fact2.setIdFactura(2);
		fact2.setDataDoc(dfm.parse("2007-01-01"));
		fact2.setValoareTotalaFactura(40.00);
		fact2.setSumaIncasata(30.00);
	
		facturi.add(fact2);

		Chitanta chitanta = incasariSrvInstance.inregistrareChitanta(casier,
				Double.valueOf(30.00), "douazeci", false, facturi,
				dataEmiterii, "mx", "chit1", "sediu", "RON", client);

		logger.info("Chitanta are asociate " + chitanta.getFacturi().size()
				+ " facturi");
//		assertNotNull("Chitanta nu are asociata o factura",
//				chitanta.getFacturi());
		assertEquals("Chitanta nu are asociata o factura", 2, chitanta
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

	@Test
	public void testGetSumaRON() {

		Double suma = incasariSrvInstance.getSumaRON("EURO", 10.00, 4.00);

		logger.info(suma);
		assertEquals("Soldul nu a fost convertita corect in RON",
				Double.doubleToLongBits(40.00), Double.doubleToLongBits(suma));
	}


}
