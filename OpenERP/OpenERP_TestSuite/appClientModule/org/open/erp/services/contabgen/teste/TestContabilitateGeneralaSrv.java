package org.open.erp.services.contabgen.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.exceptii.CodEroare;
import org.open.erp.exceptii.ExceptieContNetranzactionabil;
import org.open.erp.services.contabgen.ContabilitateGeneralaSrv;
import org.open.erp.services.contabgen.conturi.Cont;
import org.open.erp.services.contabgen.conturi.Cont.Tip;
import org.open.erp.services.contabgen.conturi.ContActiv;
import org.open.erp.services.contabgen.conturi.ContPasiv;
import org.open.erp.services.contabgen.conturi.Factura_ContabGen;
import org.open.erp.services.contabgen.conturi.PlanConturi;
import org.open.erp.services.contabgen.rapoarte.BilantContabil;
import org.open.erp.services.contabgen.sabloane.Sablon;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiune;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiuneContabila;
import org.open.erp.services.contabgen.tranzactii.OperatiuneContabila;

public class TestContabilitateGeneralaSrv {
	private static Logger logger;

	ContabilitateGeneralaSrv contabInstance;
	private InregistrareOperatiuneContabila inregOpCtb;

	@BeforeClass
	public static void initLocalJavaLogger() {
		logger = Logger.getLogger(TestContabilitateGeneralaSrv.class.getName());
	}

	@Before
	public void initServices() throws Exception {
		contabInstance = ContabilitateGeneralaSrvFactory
				.getContabilitateGeneralaSrv();
		logger.debug("ContabilitateGeneralaSrv Service intiated for Test!");
		
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

	@Test
	public void testCrearePlanConturi() throws Exception {
		logger.info("----- START creare plan de conturi pentru test ------ ");
		PlanConturi plan = contabInstance.creazaPlanConturi();

		logger.info("----- creare conturi ------ ");
		Cont contFurnizori = contabInstance.creazaCont(Tip.PASIV, 401,
				"Furnizori", "", 0.0, true);
		Cont contFurnizoriImobilizari = contabInstance.creazaCont(Tip.PASIV,
				404, "Furnizori imobilizari", "", 0.0, true);
		Cont contClienti = contabInstance.creazaCont(Tip.ACTIV, 4111,
				"Clienti", "", 0.0, true);

		logger.info("----- creare clase de conturi ------ ");

		contabInstance.adaugaCont(contFurnizori, 4);
		contabInstance.adaugaCont(contFurnizoriImobilizari, 4);
		contabInstance.adaugaCont(contClienti, 4);

		logger.info("----- adaugare clase in planul de conturi ------ ");
		plan.addClasa(contFurnizori.getClasa());

		contabInstance.salveazaPlanConturi(plan);
		logger.info("-----FINAL caz de utilizare creare plan de conturi ----- ");
	}

	@Test
	public void testCreateSablon() throws Exception {
		logger.info("----- START creare sablon ------");

		String denumire = "Sablon ABC";
		logger.info("-- denumire sablon: " + denumire);

		logger.info("-- creare inregistrare contabila 1 -- ");
		InregistrareOperatiune contDebitMarfuri = new InregistrareOperatiune(
				null, null, InregistrareOperatiune.Tip.DEBIT, 0.0);
		InregistrareOperatiune contCreditFurnizori = new InregistrareOperatiune(
				null, null, InregistrareOperatiune.Tip.CREDIT, 0.0);

		Cont contMarfuri = contabInstance.creazaCont(Tip.ACTIV, 371, "Marfuri",
				"", 0, true);
		Cont contFurnizori = contabInstance.creazaCont(Tip.PASIV, 401,
				"Furnizori", "", 0, true);

		contabInstance.adaugaCont(contFurnizori, 4);
		contabInstance.adaugaCont(contMarfuri, 3);

		contDebitMarfuri.setTransferCont(contMarfuri);
		contCreditFurnizori.setTransferCont(contFurnizori);

		InregistrareOperatiuneContabila inregOpCtb_1 = new InregistrareOperatiuneContabila(
				new Date(), new Factura_ContabGen(), "Descriere", 0.0, contDebitMarfuri,
				contCreditFurnizori);

		logger.info("-- creare inregistrare contabila 2 -- ");
		InregistrareOperatiune contDebitTVA = new InregistrareOperatiune(null,
				null, InregistrareOperatiune.Tip.DEBIT, 0.0);

		Cont contTVA = contabInstance.creazaCont(Tip.ACTIV, 4426,
				"TVA deductibil", "", 0, true);
		contDebitTVA.setTransferCont(contTVA);

		InregistrareOperatiuneContabila inregOpCtb_2 = new InregistrareOperatiuneContabila(
				new Date(), new Factura_ContabGen(), "Descriere", 0.0, contDebitTVA,
				contCreditFurnizori);

		logger.info("-- creare operatiune contabila -- ");
		OperatiuneContabila opCont = new OperatiuneContabila(new Date(),
				"Cumparare marfuri", "desc");

		opCont.addInregistrare(inregOpCtb_1);
		opCont.addInregistrare(inregOpCtb_2);

		logger.info("-- creare sablon -- ");
		Sablon sablon_vanzare = contabInstance.creareSablon("Sablon 1", opCont);

		assertEquals(sablon_vanzare.getDenumireSablon(), "Sablon 1");
	}

	@Test
	public void testCreareBilant() throws Exception {
		logger.info("----- START creare bilant ------");

		logger.info("----- creare conturi ------ ");

		Cont contFurnizori = contabInstance.creazaCont(Tip.PASIV, 401,
				"Furnizori", "", 12.0, true);
		Cont contFurnizoriImobilizari = contabInstance.creazaCont(Tip.PASIV,
				404, "Furnizori imobilizari", "", 12.0, true);
		Cont contClienti = contabInstance.creazaCont(Tip.ACTIV, 4111,
				"Clienti", "", 24.0, true);

		contabInstance.adaugaCont(contFurnizori, 4);
		contabInstance.adaugaCont(contFurnizoriImobilizari, 4);
		contabInstance.adaugaCont(contClienti, 4);

		BilantContabil bilant = new BilantContabil(contabInstance.getRegistru()
				.getConturiDinClaseleDeConturi());
		logger.info("----- total activ : ------" + bilant.getTotalActiv());
		logger.info("----- total pasiv : ------" + bilant.getTotalPasiv());

		assertEquals(bilant.getTotalActiv(), bilant.getTotalPasiv());

	}

	
	@Test
	public void testTranzactii_cu_exceptii() {

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
	public void testTranzactii_fara_exceptii() throws ExceptieContNetranzactionabil {

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

		public InregistrareOperatiuneContabilaMock(Date data, Factura_ContabGen document,
				String descriere, double suma,
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
