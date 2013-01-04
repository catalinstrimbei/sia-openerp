package org.open.erp.services.stocuri.teste;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.StocuriSrv;

public class TestStocuriEJB {
	// Resurse test
	private static Logger logger = Logger.getLogger(TestStocuriSrv.class.getName());
	
	// Unitatea de test sursa/gazda unitatii de test 
	public static StocuriSrv stocuriInstance;
	
	// Set up 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stocuriInstance = StocuriSrvFactory.getStocuriSrv();
		logger.info("initTest " + stocuriInstance);
	}
	
	
	@Test
	public void testIntrareStoc() throws Exception {
		
		logger.info("-----START creare date de test Intrare in stoc------ ");
		
		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));		
				
		//Post postLiber = personalSrv.crearePost("Medii", 2000, new Departament("1","Finante"));
		//Angajat responsabilGestiune = personalSrv.creareAngajat(1234,"Ionescu Daniel", "M", "danielIon@yahoo.com", "Angajat","necasatorit", "01/06/1980","0232/115874", new Adresa("1","Iasi","Iasi","Romania","x","007891"),  new ContractMunca (1500, 23, new Date(), "nedeterminata", 0, 8, postLiber, 200));
		//gest1.setResponsabilGestiune(responsabilGestiune);
		
		Material mat = new Material("1", "fier", "20", "5"," 1.2", null, null, null);
		//Material mat1 = new Material("1", "fier", "20", "5"," 1.2", null, null, null);
		
		logger.info("-----FINAL creare date de test Intrare in stoc------ ");

		logger.info("-----START caz de utilizare Intrare in stoc----- ");
		
		logger.info(">>>>>>>>>>>>1. Intrare in stoc a unui produs nou <<<<<<<<<<<<");
		stocuriInstance.intrareStoc(mat, 12.00, 10.00, gest1);

	}
}
