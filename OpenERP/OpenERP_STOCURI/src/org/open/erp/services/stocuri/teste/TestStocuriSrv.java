package org.open.erp.services.stocuri.teste;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.achizitii.Produs;
import org.open.erp.services.stocuri.Articol;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.Loturi;
import org.open.erp.services.stocuri.StocuriSrv;

public class TestStocuriSrv {
	private static Logger logger;

	StocuriSrv stocuriInstance;

	@BeforeClass
	public static void initLocalJavaLogger() {
		logger = Logger.getLogger(TestStocuriSrv.class.getName());
	}

	@Before
	public void initServices() {
		stocuriInstance = StocuriSrvFactory.getStocuriSrv();
		logger.debug("StocuriSrv Service intiated for Test!");

	}

	@Test
	public void testIntrareStoc() throws Exception {

		logger.info("-----START creare date de test Intrare in stoc------ ");
		Produs produs1 = new Produs(1, "Produs 1", "produs finit", 2.2, 10.00);
		Produs produs2 = new Produs(2, "Produs 2", "produs finit", 2.5, 10.00);
		Produs produs3 = new Produs(3, "Produs 3", "produs finit", 2.7, 10.00);
		Produs produs4 = new Produs(4, "Produs 4", "produs finit", 3.2, 10.00);

		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));
		Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));
		logger.info("-----FINAL creare date de test Intrare in stoc------ ");

		logger.info("-----START caz de utilizare Intrare in stoc----- ");

		logger.info(">>>>>>>>>>>>1. Intrare in stoc a unui produs nou <<<<<<<<<<<<");
		stocuriInstance.intrareStoc(produs3, gest2);
		logger.info(">>>>>>>>>>>>2. Intrare in stoc a unui produs existent <<<<<<<<<<<<");
		stocuriInstance.intrareStoc(produs3, gest2);
		logger.info("-----FINAL caz de utilizare istrare in stoc----- ");
	}

	@Test
	public void testVerificareStocCurent() throws Exception {
		logger.info("-----START creare date de test Verificare Stoc Curent------ ");
		Produs produs1 = new Produs(1, "Produs 1", "produs finit", 2.2, 10.00);
		Produs produs2 = new Produs(2, "Produs 2", "produs finit", 2.5, 10.00);
		Produs produs3 = new Produs(3, "Produs 3", "produs finit", 2.7, 10.00);
		Produs produs4 = new Produs(4, "Produs 4", "produs finit", 3.2, 10.00);
		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));
		Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));
		Articol art1 = new Articol(1, 0.00, gest1, produs1,
				new ArrayList<Loturi>());
		Articol art2 = new Articol(2, 0.00, gest1, produs2,
				new ArrayList<Loturi>());

		Loturi lot1 = new Loturi(1, produs1.getCantitate(),
				produs1.getPretIntrare(), new Date());
		Loturi lot2 = new Loturi(2, produs1.getCantitate(),
				produs1.getPretIntrare(), new Date());
		Loturi lot3 = new Loturi(3, produs2.getCantitate(),
				produs2.getPretIntrare(), new Date());
		Loturi lot4 = new Loturi(4, produs2.getCantitate(),
				produs2.getPretIntrare(), new Date());
		art1.addLot(lot1);
		art1.addLot(lot2);
		art2.addLot(lot3);
		art2.addLot(lot4);
		gest1.addArticole(art1);
		gest1.addArticole(art2);
		logger.info("-----FINAL creare date de test Verificare Stoc Curent------ ");

		logger.info("-----START caz de utilizare Verificare stoc curent----- ");

		logger.info("4.1. Introducere date specifice produsului cautat: id-ul produsul: "
				+ produs1.getIdProd());
		logger.info("4.2. Verificare disponibilitate produs in gestiune.");
		Double val = stocuriInstance.verificareStoc(produs1, gest1);
		if (val != null) {
			logger.info("4.3.Returnare valoare cantitate produs in gestiunea dorita. Stocul produsul: "
					+ produs1.getIdProd() + " este: " + val);
		} else {
			logger.info("4.3.Returnare valoare cantitate produs in gestiunea dorita. Produsul: "
					+ produs1.getIdProd() + " este: " + val);
		}
		logger.info("-----FINAL caz de utilizare Verificare stoc curent----- ");
	}

	@Test
	public void testIesireStoc() throws Exception {
		logger.info("-----START creare date de test Iesire din stoc------ ");
		Produs produs1 = new Produs(1, "Produs 1", "produs finit", 2.2, 10.00);
		Produs produs2 = new Produs(2, "Produs 2", "produs finit", 2.5, 10.00);
		Produs produs3 = new Produs(3, "Produs 3", "produs finit", 2.7, 10.00);
		Produs produs4 = new Produs(4, "Produs 4", "produs finit", 3.2, 10.00);

		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));
		Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));
		logger.info("-----FINAL creare date de test Iesire din stoc------ ");
		
		logger.info(">>>>>>>>>>>>1. Intrare in stoc a unui produs nou <<<<<<<<<<<<");
		stocuriInstance.intrareStoc(produs3, gest2);
		logger.info(">>>>>>>>>>>>2. Intrare in stoc a unui produs existent <<<<<<<<<<<<");
		stocuriInstance.intrareStoc(produs3, gest2);

		logger.info("-----START caz de utilizare Iesire din stoc----- ");
		stocuriInstance.iesireStoc(produs3, gest2, 12.00);
		logger.info("-----FINAL caz de utilizare Iesire din stoc----- ");
	}

	@Test
	public void testTransfer() throws Exception {
		logger.info("-----START creare date de test Iesire din stoc------ ");
		Produs produs1 = new Produs(1, "Produs 1", "produs finit", 2.2, 10.00);
		Produs produs2 = new Produs(2, "Produs 2", "produs finit", 2.5, 10.00);
		Produs produs3 = new Produs(3, "Produs 3", "produs finit", 2.7, 10.00);
		Produs produs4 = new Produs(4, "Produs 4", "produs finit", 3.2, 10.00);

		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));
		Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));
		logger.info("-----FINAL creare date de test Iesire din stoc------ ");
		
		logger.info(">>>>>>>>>>>>1. Intrare in stoc a unui produs nou <<<<<<<<<<<<");
		stocuriInstance.intrareStoc(produs3, gest2);
		logger.info(">>>>>>>>>>>>2. Intrare in stoc a unui produs existent <<<<<<<<<<<<");
		stocuriInstance.intrareStoc(produs3, gest2);
		
		produs3.setCantitate(5.00);
		logger.info("-----START caz de utilizare Transfer intre gestiuni----- ");
		stocuriInstance.transfer(produs3, gest2, gest1);
		logger.info("-----FINAL caz de utilizare Transfer intre gestiuni----- ");
	}

	@Test
	public void testAlertaStoc() throws Exception {
		logger.info("-----START creare date de test Alerta stoc------ ");
		Produs produs1 = new Produs(1, "Produs 1", "produs finit", 2.2, 10.00);
		Produs produs2 = new Produs(2, "Produs 2", "produs finit", 2.5, 10.00);
		Produs produs3 = new Produs(3, "Produs 3", "produs finit", 2.7, 10.00);
		Produs produs4 = new Produs(4, "Produs 4", "produs finit", 3.2, 10.00);

		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));
		Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));

		logger.info("-----FINAL creare date de test Alerta stoc------ ");

		logger.info(">>>>>>>>>>>>1. Intrare in stoc a unui produs nou <<<<<<<<<<<<");
		stocuriInstance.intrareStoc(produs3, gest2);
		logger.info(">>>>>>>>>>>>2. Intrare in stoc a unui produs existent <<<<<<<<<<<<");
		stocuriInstance.intrareStoc(produs3, gest2);
		
		logger.info("-----START caz de utilizare Alerta stoc----- ");
		stocuriInstance.iesireStoc(produs3, gest2, 18.00);
		logger.info("-----FINAL caz de utilizare Alerta stoc----- ");
	}

}
