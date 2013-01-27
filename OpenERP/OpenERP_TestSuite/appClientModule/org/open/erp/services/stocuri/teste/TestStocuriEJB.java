package org.open.erp.services.stocuri.teste;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.stocuri.BonTransfer;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.StocuriSrv;

public class TestStocuriEJB {
	// Resurse test
	private static Logger logger = Logger.getLogger(TestStocuriEJB.class.getName());
	
	// Unitatea de test sursa/gazda unitatii de test 
	public static StocuriSrv stocuriInstance;
	
	// Set up 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stocuriInstance = StocuriSrvFactory.getStocuriSrv();
		logger.info("initTest " + stocuriInstance);
	}
	/* Test creare proiect: 
	 * - invocare EJB, 
	 * - procesare EJB compus, 
	 * - procesare tranzactie compusa, 
	 * - procesare persistenta cu 2JPA-PU,
	 * - definire BO local cu asociaţie către BO din alt modul.
	 * */
	
	
	@Test
	public void testCreareDepozit() throws Exception{
		logger.info("-----START creare depozit----- ");
		
		Depozit depozit = stocuriInstance.creareDepozit("Bucuresti");
		Gestiune gestiune = stocuriInstance.creareGestiune("Gestiune 3", depozit);
		
		logger.info("-----SFARSIT creare depzoit----- " + depozit.getLocatie() + gestiune.getDenumireGest());
		
	}
	
	@Test public void testCreareMaterial() throws Exception{
		logger.info("-----START creare material----- ");
		Material mat = new Material("1", "fier", "20", "5"," 1.2", null, null, null);
		stocuriInstance.creareMaterial(mat);
		logger.info("-----SFARSIT creare material----- ");
	}
	
	@Test
	public void testStergereDepozit() throws Exception{
		Depozit depozit = stocuriInstance.getDepozit(1);
		logger.info("-----SFARSIT creare depzoit----- " + depozit.getLocatie());
		stocuriInstance.stergereDepozit(depozit);
	}
	
	@Test
	public void testIntrareStoc() throws Exception {
	
		logger.info("-----START caz de utilizare Intrare in stoc----- ");
		Material material = stocuriInstance.getMaterial("1");
		Gestiune gestiune = stocuriInstance.getGestiune(151);
		
		stocuriInstance.intrareStoc(material, 25.00, 10.00, gestiune);
		
		logger.info("-----SFARSIT caz de utilizare Intrare in stoc----- ");

	}
	
	@Test
	public void testVerificareStocCurent() throws Exception {
		logger.info("-----START creare date de test Verificare Stoc Curent------ ");

		Material material = stocuriInstance.getMaterial("1");
		Gestiune gestiune = stocuriInstance.getGestiune(151);
		
		logger.info("4.1. Introducere date specifice produsului cautat: id-ul produsul: "+ material.getCodMaterial());
		logger.info("4.2. Verificare disponibilitate produs in gestiune.");
		Double val = stocuriInstance.verificareStoc(material, gestiune);
		if (val != null) {
			logger.info("4.3.Returnare valoare cantitate produs in gestiunea dorita. Stocul produsul: " + material.getCodMaterial() + " este: " + val);
		} 
		else 
		{
			logger.info("4.3.Returnare valoare cantitate produs in gestiunea dorita. Produsul: "+ material.getCodMaterial() + " nu exista in stoc: " + val + " pentru gestiunea: " + gestiune.getIdGest());
		}
		logger.info("-----FINAL caz de utilizare Verificare stoc curent----- ");
	}


	@Test
	public void testIesireStoc() throws Exception {
		logger.info("-----START creare date de test Iesire din stoc------ ");

		Material material = stocuriInstance.getMaterial("1");
		Gestiune gestiune = stocuriInstance.getGestiune(151);
		
		stocuriInstance.iesireStoc(material, 25.00, gestiune);
		logger.info("-----FINAL caz de utilizare Iesire din stoc----- ");
	}

	
	@Test
	public void testTransfer() throws Exception {
		logger.info(">>>>>>>>>>>>1. Intrare in stoc a unui produs nou pt transfer <<<<<<<<<<<<");
		Material material = stocuriInstance.getMaterial("1");
		Gestiune gestiuneOut = stocuriInstance.getGestiune(151);
		Gestiune gestiuneIn = stocuriInstance.getGestiune(161);
		
		//Depozit depozit = stocuriInstance.creareDepozit("Bacau");
		//Gestiune gestiuneIn = stocuriInstance.creareGestiune("Gestiune 2", depozit);
		
		logger.info("-----START caz de utilizare Transfer intre gestiuni----- ");
		BonTransfer bonTransfer = stocuriInstance.creareBonTransfer(material, 2.00, gestiuneIn, gestiuneOut);
		stocuriInstance.transfer(bonTransfer);
		logger.info("-----FINAL caz de utilizare Transfer intre gestiuni----- ");
	}

	@Test
	public void testAlertaStoc() throws Exception {
		logger.info("-----START creare date de test Alerta stoc------ ");
		Material material = stocuriInstance.getMaterial("1");
		Gestiune gestiune = stocuriInstance.getGestiune(149);
		stocuriInstance.iesireStoc(material, 10.00, gestiune);
		logger.info("-----FINAL caz de utilizare Alerta stoc----- ");
	}
}
