package org.open.erp.services.contabgen.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.exceptii.CodEroare;
import org.open.erp.exceptii.ExceptieContNetranzactionabil;
import org.open.erp.services.contabgen.conturi.Cont;
import org.open.erp.services.contabgen.conturi.ContActiv;
import org.open.erp.services.contabgen.conturi.ContPasiv;
import org.open.erp.services.contabgen.conturi.Factura_ContabGen;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiune;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiuneContabila;

public class TestInregOpCtb_replaced_in_TestSuite_PRJ {

	private static Logger logger;

	private InregistrareOperatiuneContabila inregOpCtb;

	public TestInregOpCtb_replaced_in_TestSuite_PRJ() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
		logger = Logger.getLogger(TestInregOpCtb_replaced_in_TestSuite_PRJ.class
				.getName());
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() throws ExceptieContNetranzactionabil {

		logger.info("Se inregistreaza scoaterea din evidenta a cheltuielilor de constituire amortizate integral");

		InregistrareOperatiune de = new InregistrareOperatiune(null, null,
				InregistrareOperatiune.Tip.DEBIT, 0.0);
		InregistrareOperatiune ce = new InregistrareOperatiune(null, null,
				InregistrareOperatiune.Tip.CREDIT, 0.0);
		inregOpCtb = new InregistrareOperatiuneContabilaMock(new Date(),
				new Factura_ContabGen(), "Descriere", 0.0, de, ce);
		ce.setInregistrare(inregOpCtb);
		de.setInregistrare(inregOpCtb);
		Cont creditCont = new ContActiv(201, "Cheltuieli de constituire", "",
				1500, true);
		Cont debitCont = new ContPasiv(2801,
				"Amortizarea cheltuielilor de constituire", "", 1500, true);
		inregOpCtb.getDebit().setTransferCont(creditCont);
		inregOpCtb.getCredit().setTransferCont(debitCont);
		creditCont.adaugaIntrare(inregOpCtb.getCredit());
		debitCont.adaugaIntrare(inregOpCtb.getDebit());
	}

	@After
	public void tearDown() {
	}

	@Test
	public void test_cu_exceptii() {

		logger.info("rulez testul cu exceptii");
		
		Date data = new Date();
		Factura_ContabGen document = new Factura_ContabGen();
		String descriere = "Descriere";
		double suma = -1500;
		Cont creditCont = new ContActiv(201, "Cheltuieli de constituire", "",
				1500, true);
		Cont debitCont = new ContPasiv(2801,
				"Amortizarea cheltuielilor de constituire", "", 1500, false);
		
		Map rezultat = inregOpCtb.modificaInregOpCtb(data, document, descriere,
				suma, debitCont, creditCont);

		assertTrue(rezultat.containsKey("suma"));
		assertTrue(rezultat.containsValue(CodEroare.SUMA_TRANZATIE_NEGATIVA));
		assertEquals(1, rezultat.size());
		assertFalse(debitCont.equals(inregOpCtb.getDebitCont()));
	}

	@Test
	public void test_fara_exceptii() throws ExceptieContNetranzactionabil {

		logger.info("rulez testul fara exceptii");
		
		Date data = new Date();
		Factura_ContabGen document = new Factura_ContabGen();
		String descriere = "Descriere";
		double suma = 1600;
		Cont creditCont = new ContActiv(201, "Cheltuieli de constituire", "Inregistrarea 1 din cadrul operatiunii 2",
				1600, true);
		Cont debitCont = new ContPasiv(2801,
				"Amortizarea cheltuielilor de constituire", "Inregistrarea 1 din cadrul operatiunii 2", 1600, true);
		
		Map rezultat = inregOpCtb.modificaInregOpCtb(data, document, descriere,
				suma, debitCont, creditCont);

		assertTrue(rezultat.isEmpty());
		assertEquals(inregOpCtb.getDebitCont(), debitCont);
		assertEquals(inregOpCtb.getContCredit(), creditCont);
		assertEquals(inregOpCtb.getDataOperatiune(), data);
		assertEquals(inregOpCtb.getDocument(), document);
		assertEquals(inregOpCtb.getDescriereOperatiune(), descriere);
		assertEquals(inregOpCtb.getSuma(), suma, 0.0);
	}

	private class InregistrareOperatiuneContabilaMock extends
			InregistrareOperatiuneContabila {

		public InregistrareOperatiuneContabilaMock(Date data,
				Factura_ContabGen document, String descriere, double suma,
				InregistrareOperatiune intrareDebit,
				InregistrareOperatiune intrareCredit) {
			super(data, document, descriere, suma, intrareDebit, intrareCredit);
		}

		@Override
		protected void stergeIntrarileAferenteConturilor()
				throws ExceptieContNetranzactionabil {
		}

		@Override
		protected void ataseazaIntrariConturilor()
				throws ExceptieContNetranzactionabil {
		}

	}

}
