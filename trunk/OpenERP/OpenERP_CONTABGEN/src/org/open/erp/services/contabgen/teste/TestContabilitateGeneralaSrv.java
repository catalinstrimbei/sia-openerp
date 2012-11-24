package org.open.erp.services.contabgen.teste;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.contabgen.ContabilitateGeneralaSrv;
import org.open.erp.services.conturi.Clasa;
import org.open.erp.services.conturi.Cont;
import org.open.erp.services.conturi.ContActiv;
import org.open.erp.services.conturi.ContPasiv;
import org.open.erp.services.conturi.PlanConturi;

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
}
