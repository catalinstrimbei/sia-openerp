package org.open.erp.services.contabgen.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.exceptii.ExceptieContNetranzactionabil;
import org.open.erp.exceptii.ExceptieTipContInvalid;
import org.open.erp.services.contabgen.ContabilitateGeneralaSrv;
import org.open.erp.services.contabgen.conturi.Cont;
import org.open.erp.services.contabgen.conturi.Cont.Tip;
import org.open.erp.services.contabgen.conturi.PlanConturi;
import org.open.erp.services.contabgen.rapoarte.BilantContabil;
import org.open.erp.services.contabgen.sabloane.Sablon;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiune;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiuneContabila;
import org.open.erp.services.contabgen.tranzactii.OperatiuneContabila;
import org.open.erp.services.nomgen.Document;

public class TestContabilitateGeneralaSrv {
	private static Logger logger;

	ContabilitateGeneralaSrv contabInstance;

	@BeforeClass
	public static void initLocalJavaLogger() {
		logger = Logger.getLogger(TestContabilitateGeneralaSrv.class.getName());
	}

	@Before
	public void initServices() throws Exception {
		contabInstance = ContabilitateGeneralaSrvFactory
				.getContabilitateGeneralaSrv();
	}

	//@Test
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

		plan = contabInstance.salveazaPlanConturi(plan);
		
		assertFalse("Planul de conturi a fost creat cu succes !", plan==null);
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

		contFurnizori = contabInstance.adaugaCont(contFurnizori, 4);
		contMarfuri = contabInstance.adaugaCont(contMarfuri, 3);

		contDebitMarfuri.setTransferCont(contMarfuri);
		contCreditFurnizori.setTransferCont(contFurnizori);

		InregistrareOperatiuneContabila inregOpCtb_1 = new InregistrareOperatiuneContabila(
				new Date(), new Document(), "Descriere", 0.0,
				contDebitMarfuri, contCreditFurnizori);

		logger.info("-- creare inregistrare contabila 2 -- ");
		InregistrareOperatiune contDebitTVA = new InregistrareOperatiune(null,
				null, InregistrareOperatiune.Tip.DEBIT, 0.0);

		Cont contTVA = contabInstance.creazaCont(Tip.ACTIV, 4426,
				"TVA deductibil", "", 0, true);
		contDebitTVA.setTransferCont(contTVA);

		InregistrareOperatiuneContabila inregOpCtb_2 = new InregistrareOperatiuneContabila(
				new Date(), new Document(), "Descriere", 0.0,
				contDebitTVA, contCreditFurnizori);

		logger.info("-- creare operatiune contabila -- ");
		OperatiuneContabila opCont = new OperatiuneContabila(new Date(),
				"Cumparare marfuri", "desc");

		opCont.addInregistrare(inregOpCtb_1);
		opCont.addInregistrare(inregOpCtb_2);

		logger.info("-- creare sablon -- ");
		Sablon sablon_vanzare = contabInstance.creareSablon("Sablon 1", opCont);

		assertTrue(sablon_vanzare!=null);
	}

	//@Test
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

		
		BilantContabil bilant = new BilantContabil(contabInstance.getConturiDinClaseleDeConturi());
		logger.info("----- total activ : ------" + bilant.getTotalActiv());
		logger.info("----- total pasiv : ------" + bilant.getTotalPasiv());

		assertEquals(bilant.getTotalActiv(), bilant.getTotalPasiv());

	}

	//@Test
	public void testTranzactii_cu_exceptii() throws ExceptieTipContInvalid,
			ExceptieContNetranzactionabil {

		logger.info("rulez testul cu exceptii");
		testTranzactii(false);

	}

	//@Test
	public void testTranzactii_fara_exceptii()
			throws ExceptieContNetranzactionabil, ExceptieTipContInvalid {
		logger.info("rulez testul fara exceptii");
		testTranzactii(true);
	}

	public void testTranzactii(boolean tranzactionabil)
			throws ExceptieContNetranzactionabil, ExceptieTipContInvalid {

		InregistrareOperatiuneContabila inregOpCtb = null;
		logger.info("Se inregistreaza scoaterea din evidenta a cheltuielilor de constituire amortizate integral");

		inregOpCtb = adaugaOperatiuneContabila(3000, tranzactionabil);

		assertTrue(inregOpCtb != null);

		Cont creditCont = inregOpCtb.getContCredit();
		Cont debitCont = inregOpCtb.getDebitCont();

		assertEquals(creditCont.getClasa(), debitCont.getClasa());
		assertTrue(creditCont.getIntrari().contains(inregOpCtb.getCredit()));
		assertTrue(debitCont.getIntrari().contains(inregOpCtb.getDebit()));
		assertFalse(creditCont.getSold() == debitCont.getSold());
	}

	private InregistrareOperatiuneContabila adaugaOperatiuneContabila(
			double suma, boolean tranzactionabile)
			throws ExceptieTipContInvalid, ExceptieContNetranzactionabil {

		InregistrareOperatiuneContabila inregOpCtb;

		InregistrareOperatiune de = new InregistrareOperatiune(null, null,
				InregistrareOperatiune.Tip.DEBIT, suma);
		InregistrareOperatiune ce = new InregistrareOperatiune(null, null,
				InregistrareOperatiune.Tip.CREDIT, suma);

		inregOpCtb = new InregistrareOperatiuneContabila(new Date(),
				new Document(), "Descriere", suma, de, ce);

		ce.setInregistrare(inregOpCtb);
		de.setInregistrare(inregOpCtb);

		Cont creditCont = contabInstance.creazaCont(Tip.ACTIV, 201,
				"Cheltuieli de constituire", "", 0, tranzactionabile);
		Cont debitCont = contabInstance.creazaCont(Tip.PASIV, 2801,
				"Amortizarea cheltuielilor de constituire", "", 0,
				tranzactionabile);
		creditCont.setTranzactionabil(tranzactionabile);
		debitCont.setTranzactionabil(tranzactionabile);
		
		creditCont = contabInstance.adaugaCont(creditCont, 2);
		debitCont = contabInstance.adaugaCont(debitCont, 2);

		inregOpCtb.getDebit().setTransferCont(creditCont);
		inregOpCtb.getCredit().setTransferCont(debitCont);
		creditCont.adaugaIntrare(inregOpCtb.getCredit());
		debitCont.adaugaIntrare(inregOpCtb.getDebit());

		inregOpCtb = contabInstance.salveazaOperatiuneContabila(inregOpCtb);

		return inregOpCtb;
	}

	private class InregistrareOperatiuneContabilaMock extends
			InregistrareOperatiuneContabila {

		/**
 * 
 */
		private static final long serialVersionUID = 7767467287431843133L;

		public InregistrareOperatiuneContabilaMock(Date data,
				Document document, String descriere, double suma,
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
