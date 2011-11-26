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
import org.open.erp.services.incasari.Casa;
import org.open.erp.services.incasari.Chitanta;
import org.open.erp.services.incasari.IncasariSrv;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.FacturaVanzare;
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
		ArrayList<FacturaVanzare> facturi = new ArrayList<FacturaVanzare>();
		FacturaVanzare fact1 = new FacturaVanzare("fact1",
				dfm.parse("2010-01-01"), 40.00, 10.00);
		facturi.add(fact1);
		FacturaVanzare fact2 = new FacturaVanzare("fact2",
				dfm.parse("2007-01-01"), 40.00, 30.00);
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
	public void testActualizeazaSoldCasa() {

		Casa casa = incasariSrvInstance.actualizeazaSoldCasa(20.00);

		logger.info(casa.getSoldCurent());
		assertEquals("Soldul nu s-a actualizat corect",
				Double.doubleToLongBits(20.00),
				Double.doubleToLongBits(casa.getSoldCurent()));

		Casa casa2 = incasariSrvInstance.actualizeazaSoldCasa(30.00);

		logger.info(casa.getSoldCurent());
		assertEquals("Soldul nu s-a actualizat corect",
				Double.doubleToLongBits(50.00),
				Double.doubleToLongBits(casa2.getSoldCurent().doubleValue()));

	}

	@Test
	public void testGetSumaRON() {

		Double suma = incasariSrvInstance.getSumaRON("EURO", 10.00, 4.00);

		logger.info(suma);
		assertEquals("Soldul nu a fost convertita corect in RON",
				Double.doubleToLongBits(40.00), Double.doubleToLongBits(suma));
	}

	@Test
	public void testActualizeazaSoldClient() {

		Client client = incasariSrvInstance.actualizeazaSoldClient(30.00, "1");

		logger.info(client.getSoldCurent());
		assertEquals("Soldul nu s-a actualizat corect",
				Double.doubleToLongBits(30.00),
				Double.doubleToLongBits(client.getSoldCurent()));

	}
}
