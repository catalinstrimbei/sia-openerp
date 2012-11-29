package org.open.erp.services.contabgen.teste;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.achizitii.Factura;
import org.open.erp.services.contabgen.ContabilitateGeneralaSrv;
import org.open.erp.services.conturi.Clasa;
import org.open.erp.services.conturi.Cont;
import org.open.erp.services.conturi.ContActiv;
import org.open.erp.services.conturi.ContPasiv;
import org.open.erp.services.conturi.PlanConturi;
import org.open.erp.services.rapoarte.BilantContabil;
import org.open.erp.services.sabloane.Sablon;
import org.open.erp.services.tranzactii.InregistrareOperatiune;
import org.open.erp.services.tranzactii.InregistrareOperatiuneContabila;
import org.open.erp.services.tranzactii.OperatiuneContabila;

/**
 * testul corespunzator tranzactiei se gaseste in clasa TestInregistrareOperatiuneContabila
 *
 */
public class TestContabilitateGeneralaSrv {
	private static Logger logger;

	ContabilitateGeneralaSrv contabInstance;

	@BeforeClass
	public static void initLocalJavaLogger() {
		logger = Logger.getLogger(TestContabilitateGeneralaSrv.class.getName());
	}

	@Before
	public void initServices() {
		contabInstance = ContabilitateGeneralaSrvFactory
				.getContabilitateGeneralaSrv();
		logger.debug("ContabilitateGeneralaSrv Service intiated for Test!");

	}

	@Test
	public void testCrearePlanConturi() throws Exception {
		logger.info("----- START creare plan de conturi pentru test ------ ");

		PlanConturi plan = new PlanConturi();

		logger.info("----- creare conturi ------ ");
		Cont contFurnizori = new ContPasiv(401, "Furnizori", "", 0.0, true);
		Cont contFurnizoriImobilizari = new ContPasiv(404,
				"Furnizori imobilizari", "", 0.0, true);
		Cont contClienti = new ContActiv(4111, "Clienti", "", 0.0, true);

		logger.info("----- creare clase de conturi ------ ");
		Clasa clasaTerti = new Clasa("Conturi de terti");
		clasaTerti.setCodClasa(4);
		clasaTerti.addCont(contFurnizori);
		clasaTerti.addCont(contFurnizoriImobilizari);
		clasaTerti.addCont(contClienti);

		logger.info("----- adaugare clase in planul de conturi ------ ");
		plan.addClasa(clasaTerti);

		logger.info("----- START TEST: adaugare cont ------ ");
		Cont contTest = new ContPasiv(1011, "Capital smecher", "", 0.0, true);
		contabInstance.adaugaCont(contTest, 1);

		logger.info("-----FINAL caz de utilizare creare plan de conturi ----- ");
	}
	
	@Test
	public void testCreateSablon() throws Exception {
		logger.info("----- START creare sablon ------");
		
		String denumire = "Sablon ABC";
		logger.info("-- denumire sablon: " + denumire);
		
		logger.info("-- creare inregistrare contabila 1 -- ");
		InregistrareOperatiune contDebitMarfuri = new InregistrareOperatiune(null, null,
				InregistrareOperatiune.Tip.DEBIT, 0.0);
		InregistrareOperatiune contCreditFurnizori = new InregistrareOperatiune(null, null,
				InregistrareOperatiune.Tip.CREDIT, 0.0);
			
		Cont contMarfuri = new ContActiv(371, "Marfuri", "", 0, true);
		Cont contFurnizori = new ContPasiv(401, "Furnizori", "", 0, true);
		
		contDebitMarfuri.setTransferCont(contMarfuri);
		contCreditFurnizori.setTransferCont(contFurnizori);
		
		InregistrareOperatiuneContabila inregOpCtb_1 = new InregistrareOperatiuneContabila(new Date(),
				new Factura(), "Descriere", 0.0, contDebitMarfuri, contCreditFurnizori);
		
		logger.info("-- creare inregistrare contabila 2 -- ");
		InregistrareOperatiune contDebitTVA = new InregistrareOperatiune(null, null,
				InregistrareOperatiune.Tip.DEBIT, 0.0);
			
		Cont contTVA = new ContActiv(4426, "TVA deductibil", "", 0, true);
		
		contDebitTVA.setTransferCont(contTVA);
		
		InregistrareOperatiuneContabila inregOpCtb_2 = new InregistrareOperatiuneContabila(new Date(),
				new Factura(), "Descriere", 0.0, contDebitTVA, contCreditFurnizori);
		
		
		logger.info("-- creare operatiune contabila -- ");
		OperatiuneContabila opCont = new OperatiuneContabila(new Date(), "Cumparare marfuri", "desc");
		
		opCont.addInregistrare(inregOpCtb_1);
		opCont.addInregistrare(inregOpCtb_2);
		
		logger.info("-- creare sablon -- ");
		Sablon sablon_vanzare = contabInstance.creareSablon("Sablon 1", opCont);
		
		logger.info("-- Sablonul: <<" + sablon_vanzare.getDenumireSablon() + ">> a fost creat" );
	}
	
	@Test
	public void testCreareBilant() throws Exception {
		logger.info("----- START creare bilant ------");
	
	ArrayList<Cont> conturi=new ArrayList<Cont>();
	
	Cont contFurnizori = new ContPasiv(401, "Furnizori", "", 12.0, true);
	Cont contFurnizoriImobilizari = new ContPasiv(404,
			"Furnizori imobilizari", "", 12.0, true);
	Cont contClienti = new ContActiv(4111, "Clienti", "", 24.0, true);
	
	conturi.add(contFurnizori);
	conturi.add(contFurnizoriImobilizari);
	conturi.add(contClienti);
	
	BilantContabil bilant = ContabilitateGeneralaSrvFactory.
			getContabilitateGeneralaSrv().creareBilantContabil(conturi);
	
	logger.info("----- total activ : ------"+bilant.getTotalActiv());
	logger.info("----- total pasiv : ------"+bilant.getTotalPasiv());
	
	assertEquals(bilant.getTotalActiv(), bilant.getTotalPasiv());
	

	}
}
