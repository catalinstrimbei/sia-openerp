package org.open.erp.services.stocuri.teste;


import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.stocuri.BonTransfer;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.StocuriSrv;


public class TestStocuriSrv {
	private static Logger logger;

	StocuriSrv stocuriInstance;
	//public NomenclatorMaterialeSrv nomenclatorMaterialeSrv;
	//public PersonalSrv personalSrv;
	//ListaGestiuni lista;
	

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
		
		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));		
		//Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));
		
		//Post postLiber = personalSrv.crearePost("Medii", 2000, new Departament("1","Finante"));
		//Angajat responsabilGestiune = personalSrv.creareAngajat(1234,"Ionescu Daniel", "M", "danielIon@yahoo.com", "Angajat","necasatorit", "01/06/1980","0232/115874", new Adresa("1","Iasi","Iasi","Romania","x","007891"),  new ContractMunca (1500, 23, new Date(), "nedeterminata", 0, 8, postLiber, 200));
		//gest1.setResponsabilGestiune(responsabilGestiune);
		
		//NIR nir = new NIR(10, null, null, 100.00);
		
		Material mat = new Material("1", "fier", "20", "5"," 1.2", null, null, null);
		//Material mat1 = new Material("1", "fier", "20", "5"," 1.2", null, null, null);
		
		//LiniiNIR linieNIR1 = new LiniiNIR(nir, 1, mat, 10.00, 10.00, 100.00, 24.00);
		//LiniiNIR linieNIR2 = new LiniiNIR(nir, 2, mat1, 10.00, 10.00, 100.00, 24.00);
		
		//nir.getLinieNir().add(linieNIR1);
		//nir.getLinieNir().add(linieNIR2);
		
		logger.info("-----FINAL creare date de test Intrare in stoc------ ");

		logger.info("-----START caz de utilizare Intrare in stoc----- ");
		
		logger.info(">>>>>>>>>>>>1. Intrare in stoc a unui produs nou <<<<<<<<<<<<");
		stocuriInstance.intrareStoc(mat, 12.00, 10.00, gest1);

	}

	@Test
	public void testVerificareStocCurent() throws Exception {
		logger.info("-----START creare date de test Verificare Stoc Curent------ ");
		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));		
		Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));
		
		//Post postLiber = personalSrv.crearePost("Medii", 2000, new Departament("1","Finante"));
		//Angajat responsabilGestiune = personalSrv.creareAngajat(1234,"Ionescu Daniel", "M", "danielIon@yahoo.com", "Angajat","necasatorit", "01/06/1980","0232/115874", new Adresa("1","Iasi","Iasi","Romania","x","007891"),  new ContractMunca (1500, 23, new Date(), "nedeterminata", 0, 8, postLiber, 200));
		//gest1.setResponsabilGestiune(responsabilGestiune);
		
		Material mat = new Material("1", "fier", "20", "5"," 1.2", null, null, null);
		Material mat1 = new Material("1", "fier", "20", "5"," 1.2", null, null, null);
		
		logger.info("-----START creare date de test Verificare Stoc Curent------ ");
		
		logger.info("-----FINAL creare date de test Intrare in stoc------ ");

		stocuriInstance.intrareStoc(mat, 12.00, 10.00, gest1);
		
		logger.info("-----FINAL creare date de test Verificare Stoc Curent------ ");

		logger.info("-----START caz de utilizare Verificare stoc curent----- ");

		logger.info("4.1. Introducere date specifice produsului cautat: id-ul produsul: "+ mat1.getCodMaterial());
		logger.info("4.2. Verificare disponibilitate produs in gestiune.");
		Double val = stocuriInstance.verificareStoc(mat, gest1);
		if (val != null) {
			logger.info("4.3.Returnare valoare cantitate produs in gestiunea dorita. Stocul produsul: " + mat1.getCodMaterial() + " este: " + val);
		} 
		else 
		{
			logger.info("4.3.Returnare valoare cantitate produs in gestiunea dorita. Produsul: "+ mat1.getCodMaterial() + " nu exista in stoc: " + val);
		}
		
		logger.info("-----FINAL caz de utilizare Verificare stoc curent----- ");
	}


	@Test
	public void testIesireStoc() throws Exception {
		logger.info("-----START creare date de test Iesire din stoc------ ");
	
		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));		
		Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));
		
		//Post postLiber = personalSrv.crearePost("Medii", 2000, new Departament("1","Finante"));
		//Angajat responsabilGestiune = personalSrv.creareAngajat(1234,"Ionescu Daniel", "M", "danielIon@yahoo.com", "Angajat","necasatorit", "01/06/1980","0232/115874", new Adresa("1","Iasi","Iasi","Romania","x","007891"),  new ContractMunca (1500, 23, new Date(), "nedeterminata", 0, 8, postLiber, 200));
		//gest1.setResponsabilGestiune(responsabilGestiune);
		
		Material mat = new Material("1", "fier", "20", "5"," 1.2", null, null, null);
		Material mat1 = new Material("1", "fier", "20", "5"," 1.2", null, null, null);
		
		logger.info("-----FINAL creare date de test Intrare in stoc------ ");

		logger.info("-----START caz de utilizare Intrare in stoc----- ");
		
		logger.info(">>>>>>>>>>>>1. Intrare in stoc a unui produs nou <<<<<<<<<<<<");
		stocuriInstance.intrareStoc(mat, 12.00, 10.00, gest1);
		
		logger.info("-----FINAL creare date de test Iesire din stoc------ ");
		
		logger.info("-----START caz de utilizare Iesire din stoc----- ");
		stocuriInstance.iesireStoc(mat, 8.00, gest1);
		logger.info("-----FINAL caz de utilizare Iesire din stoc----- ");
	}

	
	@Test
	public void testTransfer() throws Exception {
		logger.info("-----START creare date de test Iesire din stoc------ ");
		//INCEPUT intrare in stoc
		
		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));		
		Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));
		
		//Post postLiber = personalSrv.crearePost("Medii", 2000, new Departament("1","Finante"));
		//Angajat responsabilGestiune = personalSrv.creareAngajat(1234,"Ionescu Daniel", "M", "danielIon@yahoo.com", "Angajat","necasatorit", "01/06/1980","0232/115874", new Adresa("1","Iasi","Iasi","Romania","x","007891"),  new ContractMunca (1500, 23, new Date(), "nedeterminata", 0, 8, postLiber, 200));
		//gest1.setResponsabilGestiune(responsabilGestiune);
		
		Material mat = new Material("1", "fier", "20", "5"," 1.2", null, null, null);
		Material mat1 = new Material("1", "fier", "20", "5"," 1.2", null, null, null);
		
		logger.info("-----FINAL creare date de test Intrare in stoc------ ");

		logger.info("-----START caz de utilizare Intrare in stoc----- ");
		
		logger.info(">>>>>>>>>>>>1. Intrare in stoc a unui produs nou <<<<<<<<<<<<");
		stocuriInstance.intrareStoc(mat, 12.00, 10.00, gest1);
		
		BonTransfer bonTransfer = new BonTransfer(1,mat, 2.00, gest2, gest1);
		
		logger.info("-----START caz de utilizare Transfer intre gestiuni----- ");
		stocuriInstance.transfer(bonTransfer);
		logger.info("-----FINAL caz de utilizare Transfer intre gestiuni----- ");
	}

	@Test
	public void testAlertaStoc() throws Exception {
		logger.info("-----START creare date de test Alerta stoc------ ");
		
		Gestiune gest1 = new Gestiune(1, "Gestiune 1", new Depozit(1, "Iasi"));		
		Gestiune gest2 = new Gestiune(2, "Gestiune 2", new Depozit(2, "Bacau"));
		
		//Post postLiber = personalSrv.crearePost("Medii", 2000, new Departament("1","Finante"));
		//Angajat responsabilGestiune = personalSrv.creareAngajat(1234,"Ionescu Daniel", "M", "danielIon@yahoo.com", "Angajat","necasatorit", "01/06/1980","0232/115874", new Adresa("1","Iasi","Iasi","Romania","x","007891"),  new ContractMunca (1500, 23, new Date(), "nedeterminata", 0, 8, postLiber, 200));
		//gest1.setResponsabilGestiune(responsabilGestiune);
		
		Material mat = new Material("1", "fier", "20", "5"," 1.2", null, null, null);
		Material mat1 = new Material("1", "fier", "20", "5"," 1.2", null, null, null);
		
	
		logger.info("-----FINAL creare date de test Intrare in stoc------ ");

		logger.info("-----START caz de utilizare Intrare in stoc----- ");
		
		logger.info(">>>>>>>>>>>>1. Intrare in stoc a unui produs nou <<<<<<<<<<<<");
		stocuriInstance.intrareStoc(mat, 12.00, 10.00, gest1);
	
		logger.info("-----FINAL creare date de test Alerta stoc------ ");
		
		logger.info("-----START caz de utilizare Alerta stoc----- ");
		stocuriInstance.iesireStoc(mat, 10.00, gest1);
		logger.info("-----FINAL caz de utilizare Alerta stoc----- ");
	}

}
