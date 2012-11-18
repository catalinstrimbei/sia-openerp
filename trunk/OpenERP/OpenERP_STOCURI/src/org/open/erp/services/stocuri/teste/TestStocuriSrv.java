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

		// 2.1. Preluare date produs

		logger.info("START creare date de test------ ");

		logger.info("START creare produse----- ");
		Produs produs1 = new Produs(1, "Produs 1", "produs finit", 2.2, 10.00);
		Produs produs2 = new Produs(2, "Produs 2", "produs finit", 2.5, 10.00);
		Produs produs3 = new Produs(3, "Produs 3", "produs finit", 2.7, 10.00);
		Produs produs4 = new Produs(4, "Produs 4", "produs finit", 3.2, 10.00);
		logger.info("FINAL creare produse----- ");

		logger.info("START creare gestiuni----- ");
		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));
		Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));
		logger.info("FINAL creare gestiuni----- ");

		logger.info("Start caz de utilizare instrare in stoc----- ");

		stocuriInstance.intrareStoc(produs3, gest2);
		stocuriInstance.intrareStoc(produs3, gest2);

		// 2.2. Verificare date identificare lot

		// 2.3. Modificare/crestere stoc curent

		// 2.4 Confirmare stoc curent

	}

	@Test
	public void testVerificareStocCurent() throws Exception {

		// 4.1. Preluare date produs

		logger.info("START creare date de test Verificare Stoc Curent------ ");

		logger.info("START creare produse----- ");
		Produs produs1 = new Produs(1, "Produs 1", "produs finit", 2.2, 10.00);
		Produs produs2 = new Produs(2, "Produs 2", "produs finit", 2.5, 10.00);
		Produs produs3 = new Produs(3, "Produs 3", "produs finit", 2.7, 10.00);
		Produs produs4 = new Produs(4, "Produs 4", "produs finit", 3.2, 10.00);
		logger.info("FINAL creare produse----- ");

		logger.info("START creare gestiuni----- ");
		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));
		Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));
		logger.info("FINAL creare gestiuni----- ");

		logger.info("START creare articole----- ");
		Articol art1 = new Articol(1, 0.00, gest1, produs1,
				new ArrayList<Loturi>());
		Articol art2 = new Articol(2, 0.00, gest1, produs2,
				new ArrayList<Loturi>());
		logger.info("FINAL creare articole----- ");

		logger.info("START creare loturi----- ");
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
		logger.info("FINAL creare loturi----- ");

		// 4.2. Verificare disponibilitate produs
		logger.info("Start caz de utilizare verificare stoc curent----- ");
		logger.info("Verificare disponibilitate produs in gestiune----- ");
		Double val = stocuriInstance.verificareStoc(produs1, gest1);

		// 4.3. Returnare/Afisare Rezultat Cautat
		logger.info("Returnare valoare cantitate produs in gestiunea dorita----- ");
		if (val != null) {
			logger.info("Valoarea cantitatii produsului: "
					+ produs1.getNumeProdus() + " este de: " + val);
		} else {
			logger.info("Produsului: " + produs1.getNumeProdus()
					+ " nu a fost gasit.");
		}

	}

	@Test
	public void testIesireStoc() throws Exception {
		
		Produs produs1 = new Produs(1, "Produs 1", "produs finit", 2.2, 10.00);
		Produs produs2 = new Produs(2, "Produs 2", "produs finit", 2.5, 10.00);
		Produs produs3 = new Produs(3, "Produs 3", "produs finit", 2.7, 10.00);
		Produs produs4 = new Produs(4, "Produs 4", "produs finit", 3.2, 10.00);
		
		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));
		Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));
		
		stocuriInstance.intrareStoc(produs3, gest2);
		stocuriInstance.intrareStoc(produs3, gest2);
		
		stocuriInstance.iesireStoc(produs3, gest2, 12.00);
	}

}
