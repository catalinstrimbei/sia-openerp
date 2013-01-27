package org.open.erp.services.productie.teste;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.MijlocFix;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.productie.ComandaProductie;
import org.open.erp.services.productie.CriteriuCalitate;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FluxProductie;
import org.open.erp.services.productie.FunctieNecesara;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.Produs;
import org.open.erp.services.productie.Semifabricat;
import org.open.erp.services.productie.Utilaj;


public class TestProductieEJB {
	
	/* Resurse test*/
	private static Logger logger = Logger.getLogger(TestProductieEJB.class.getName());
	
	/* Unitatea de test sursa/gazda unitatii de test */
	private static ProductieSrv productie;
	
	//NomenclatoareSrv nomgeneral;
	//NomenclatorMaterialeSrv nommat;
	
	/* Set up */
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestProductieEJB.class.getName());	
	}
	
	@Before public void initServices() throws Exception{	
		productie = ProductieSrvFactory.getProductieSrv();
		logger.info("ProductieSrv Service intiated for Test!");
	}
	
	@Test
	 public void testDefinireFluxProductie () throws Exception {
	 logger.info(">>>>>>>>>>>> START definire flux");	
	 	//Produs produsNou = productie.creareProdus(1, "Produs_1");
	 	Produs produsNou = new Produs();	 
	 	produsNou.setIdProdus(1);
		produsNou.setDenumire("Produs nou");
		produsNou.setUnitateMasura(null);
		produsNou.setDataFabricatiei(null);
		produsNou.setTermenValabilitate(null);
		 logger.info("*****A fost creat un nou produs: " + produsNou.getDenumire());
		 FluxProductie flux = productie.definireFluxProductie(1,produsNou);
		 logger.info("Fluxul cu id: " + flux.getIdFlux() + " a fost creat!");
			
			assertNotNull("Flux ne-validat!", flux.getIdFlux());
			
			flux = productie.getFlux(flux.getIdFlux());
				
			assertNotNull("Nu exista flux nou!", flux);
			logger.info("End test: definireFlux");	
		 }
	
	
	@Test
	public void testDefinireFazaProductie() throws Exception{
		logger.info(">>>>>>>>>>>> START definire faza");
		
		Produs produsNou = new Produs();
		 produsNou.setIdProdus(1);
		 produsNou.setDenumire("Produs nou");
		 produsNou.setUnitateMasura(null);
		 produsNou.setDataFabricatiei(null);
		 produsNou.setTermenValabilitate(null);
		 
		 ArrayList<FazaProductie> faze = new ArrayList<FazaProductie>();

		 logger.info("*****A fost creat un nou flux pentru produsul: " + produsNou.getDenumire());
		 
		 FluxProductie flux = productie.definireFluxProductie(1,produsNou);
		 
		 logger.info("*****Fluxul cu id: " + flux.getIdFlux() + " a fost creat!");
		 
		 assertNotNull("Flux ne-validat!", flux.getIdFlux());
			
			flux = productie.getFlux(flux.getIdFlux());
				
			assertNotNull("Nu exista flux nou!", flux);
			logger.info("End test: definireFlux");
		 
		Utilaj utilaj;
		FazaProductie fz;
		Double timpFolosire;
		ArrayList<FunctieNecesara> functiiNecesare;
		ArrayList<Angajat> angajati;
		ArrayList<Material> materialeReteta;
		ArrayList <Material> materialeSemifabricat;
		Semifabricat semifabricatContinut;
		Semifabricat semifabricatReteta;
		Semifabricat semifabricatDorit;
		Produs produsDorit;
		Integer nrOrdine;
		Boolean isFinal;
		
		
		 //faza
		
		//utilaj
		MijlocFix mf=new MijlocFix();
		mf.setId(1);
		mf.setDenumire("Utilaj");
		mf.setTermenExploatare(null);
		mf.setValoare(null);
		logger.info("*****Mijlocul fix a fost creat " + mf.getDenumire());
		//Setez utilajul;
		utilaj =new Utilaj();
		utilaj.setUtilaj(mf);
		utilaj.setStatus("ocupat");
		
		//timp folosire
		timpFolosire=  10.00;
		
		//sectie
		Divizie sectie= new Divizie();
		sectie.setId("1");				
		sectie.setDenumire("Departament Productie");
		sectie.setDescriere(null);
		sectie.setParinte(null);
		logger.info("*****Sectia a fost creata " + sectie.getDenumire());
		
		//functii necesare
		FunctieNecesara f1=new FunctieNecesara();						
		f1.setIdFunctie(1);
		f1.setNumeFunctie("Functie 1");
		f1.setNrAngajatiFunctie(1);
				
		FunctieNecesara f2=new FunctieNecesara();
		f2.setIdFunctie(1);
		f2.setNumeFunctie("Functie 2");
		f2.setNrAngajatiFunctie(1);
				
		functiiNecesare = new ArrayList<FunctieNecesara>();
		functiiNecesare.add(f1);
		functiiNecesare.add(f2);
		logger.info("*****Lista de functii a fost creata " + functiiNecesare);
		
		// materiale reteta
		materialeReteta = new ArrayList<Material>();
		Material m3=new Material();
		Material m4=new Material();
		
		m3.setCodMaterial("1");
		m3.setDenumireMaterial("material1");
		m3.setCategorieMaterial(null);
		m3.setCantitateStandard(null);
		logger.info("*****Materialul a fost creat " + m3);
				
		m4.setCodMaterial("2");
		m4.setDenumireMaterial("material2");
		m4.setCategorieMaterial(null);
		m4.setCantitateStandard(null);
		logger.info("*****Materialul a fost creat " + m4);

		materialeReteta.add(m3);
		materialeReteta.add(m4);
		logger.info("*****Lista cu materialele retetei a fost creata " + materialeReteta);
		
		//semifabricat dorit
		semifabricatDorit=new Semifabricat();
		String denSemifabricatDorit = "semifabricat";
		ArrayList<Material> materialeSemifabricatDorit = new ArrayList<Material>();
		Material m7=new Material();
		Material m8=new Material();
		m7.setCodMaterial("3");
		m7.setDenumireMaterial("material3");
		m7.setCategorieMaterial(null);
		m7.setCantitateStandard(null);
		
		m8.setCodMaterial("4");
		m8.setDenumireMaterial("material4");
		m8.setCategorieMaterial(null);
		m8.setCantitateStandard(null);
				
		materialeSemifabricatDorit.add(m7);
		materialeSemifabricatDorit.add(m8);
		semifabricatContinut=null;
		semifabricatDorit.setDenumire(denSemifabricatDorit);
		semifabricatDorit.setListaMateriale(materialeSemifabricatDorit);
		semifabricatDorit.setSemifabricatContinut(semifabricatContinut);
		
		logger.info("Semifabricatul dorit este: " + semifabricatDorit);
		
		//produs dorit
		produsDorit=new Produs();
		produsDorit.setIdProdus(1);
		produsDorit.setDenumire("Produs nou");
		produsDorit.setUnitateMasura(null);
		produsDorit.setDataFabricatiei(null);
		produsDorit.setTermenValabilitate(null);
		logger.info("*****Produsul dorit este: " + produsDorit);
		
		
		
		nrOrdine =1;
		isFinal= false;
		
		FazaProductie faza=productie.definireFazaProductie("faza test", flux, utilaj, timpFolosire, functiiNecesare, materialeReteta, semifabricatDorit, produsDorit, sectie, 1, false);
				
		logger.info(">>>>>>>>> END test creare faza");
		}
	
	public void testComandaMateriale() throws Exception{
		logger.info("----START test: comandaMateriale ---");
		Produs produsNou = new Produs();
		 produsNou.setIdProdus(1);
		 produsNou.setDenumire("Produs nou");
		 produsNou.setUnitateMasura(null);
		 produsNou.setDataFabricatiei(null);
		 produsNou.setTermenValabilitate(null);
		 
		 ArrayList<FazaProductie> faze = new ArrayList<FazaProductie>();

		 logger.info("*****A fost creat un nou flux pentru produsul: " + produsNou.getDenumire());
		 
		 FluxProductie flux = productie.definireFluxProductie(1,produsNou);
		 
		 logger.info("*****Fluxul cu id: " + flux.getIdFlux() + " a fost creat!");
		 
		 assertNotNull("Flux ne-validat!", flux.getIdFlux());
			
			flux = productie.getFlux(flux.getIdFlux());
				
			assertNotNull("Nu exista flux nou!", flux);
			logger.info("End test: definireFlux");
		 
		Utilaj utilaj;
		FazaProductie fz;
		Double timpFolosire;
		ArrayList<FunctieNecesara> functiiNecesare;
		ArrayList<Angajat> angajati;
		ArrayList<Material> materialeReteta;
		ArrayList <Material> materialeSemifabricat;
		Semifabricat semifabricatContinut;
		Semifabricat semifabricatReteta;
		Semifabricat semifabricatDorit;
		Produs produsDorit;
		Integer nrOrdine;
		Boolean isFinal;
		
		
		 //faza
		
		//utilaj
		MijlocFix mf=new MijlocFix();
		mf.setId(1);
		mf.setDenumire("Utilaj");
		mf.setTermenExploatare(null);
		mf.setValoare(null);
		logger.info("*****Mijlocul fix a fost creat " + mf.getDenumire());
		//Setez utilajul;
		utilaj =new Utilaj();
		utilaj.setUtilaj(mf);
		utilaj.setStatus("ocupat");
		
		//timp folosire
		timpFolosire=  10.00;
		
		//sectie
		Divizie sectie= new Divizie();
		sectie.setId("1");				
		sectie.setDenumire("Departament Productie");
		sectie.setDescriere(null);
		sectie.setParinte(null);
		logger.info("*****Sectia a fost creata " + sectie.getDenumire());
		
		//functii necesare
		FunctieNecesara f1=new FunctieNecesara();						
		f1.setIdFunctie(1);
		f1.setNumeFunctie("Functie 1");
		f1.setNrAngajatiFunctie(1);
				
		FunctieNecesara f2=new FunctieNecesara();
		f2.setIdFunctie(1);
		f2.setNumeFunctie("Functie 2");
		f2.setNrAngajatiFunctie(1);
				
		functiiNecesare = new ArrayList<FunctieNecesara>();
		functiiNecesare.add(f1);
		functiiNecesare.add(f2);
		logger.info("*****Lista de functii a fost creata " + functiiNecesare);
		
		// materiale reteta
		materialeReteta = new ArrayList<Material>();
		Material m3=new Material();
		Material m4=new Material();
		
		m3.setCodMaterial("1");
		m3.setDenumireMaterial("material1");
		m3.setCategorieMaterial(null);
		m3.setCantitateStandard(null);
		logger.info("*****Materialul a fost creat " + m3);
				
		m4.setCodMaterial("2");
		m4.setDenumireMaterial("material2");
		m4.setCategorieMaterial(null);
		m4.setCantitateStandard(null);
		logger.info("*****Materialul a fost creat " + m4);

		materialeReteta.add(m3);
		materialeReteta.add(m4);
		logger.info("*****Lista cu materialele retetei a fost creata " + materialeReteta);
		
		//semifabricat dorit
		semifabricatDorit=new Semifabricat();
		String denSemifabricatDorit = "semifabricat";
		ArrayList<Material> materialeSemifabricatDorit = new ArrayList<Material>();
		Material m7=new Material();
		Material m8=new Material();
		m7.setCodMaterial("3");
		m7.setDenumireMaterial("material3");
		m7.setCategorieMaterial(null);
		m7.setCantitateStandard(null);
		
		m8.setCodMaterial("4");
		m8.setDenumireMaterial("material4");
		m8.setCategorieMaterial(null);
		m8.setCantitateStandard(null);
				
		materialeSemifabricatDorit.add(m7);
		materialeSemifabricatDorit.add(m8);
		
		semifabricatContinut=null;
		semifabricatDorit.setDenumire(denSemifabricatDorit);
		semifabricatDorit.setListaMateriale(materialeSemifabricatDorit);
		semifabricatDorit.setSemifabricatContinut(semifabricatContinut);
		
		
		//produs dorit
		produsDorit=new Produs();
		produsDorit.setIdProdus(1);
		produsDorit.setDenumire("Produs nou");
		produsDorit.setUnitateMasura(null);
		produsDorit.setDataFabricatiei(null);
		produsDorit.setTermenValabilitate(null);
		logger.info("*****Produsul dorit este: " + produsDorit);
		
		
		FazaProductie faza=productie.definireFazaProductie("faza test", flux, utilaj, timpFolosire, functiiNecesare, materialeReteta, semifabricatDorit, produsDorit, sectie, 1, false);
				
		logger.info(">>>>>>>>> End test: definireFaza");
		
		
		productie.comandaMateriale(faza, flux);
		
		logger.info("----END test: comandaMateriale ---");
			
	}		
	
	public void testFabricareProdus() throws Exception {
		logger.info("----START test: fabricareProdus ---");
		Produs produsNou = new Produs();
		 produsNou.setIdProdus(1);
		 produsNou.setDenumire("Produs nou");
		 produsNou.setUnitateMasura(null);
		 produsNou.setDataFabricatiei(null);
		 produsNou.setTermenValabilitate(null);
		 
		 ArrayList<FazaProductie> faze = new ArrayList<FazaProductie>();

		 FluxProductie flux = productie.definireFluxProductie(1, produsNou);
		 
		 logger.info("Fluxul cu id: " + flux.getIdFlux() + " a fost creat!");
			
			assertNotNull("Flux ne-validat!", flux.getIdFlux());
			
			flux = productie.getFlux(flux.getIdFlux());
				
			assertNotNull("Nu exista flux nou!", flux);
			
			productie.fabricare(produsNou, 1);
	}
	 
	
	@Test	
	 public void testConsumResursa() throws Exception{
		logger.info(">>>>>>>> INCEPERE TEST CONSUM RESURSE");
			
		Produs produsNou = new Produs();
		 produsNou.setIdProdus(1);
		 produsNou.setDenumire("Produs nou");
		 produsNou.setUnitateMasura(null);
		 produsNou.setDataFabricatiei(null);
		 produsNou.setTermenValabilitate(null);
		 
		 ArrayList<FazaProductie> faze = new ArrayList<FazaProductie>();

		 logger.info("*****A fost creat un nou flux pentru produsul: " + produsNou.getDenumire());
		 
		 FluxProductie flux = productie.definireFluxProductie(1,produsNou);
		 
		 logger.info("*****Fluxul cu id: " + flux.getIdFlux() + " a fost creat!");
		 
		 assertNotNull("Flux ne-validat!", flux.getIdFlux());
			
			flux = productie.getFlux(flux.getIdFlux());
				
			assertNotNull("Nu exista flux nou!", flux);
			logger.info("End test: definireFlux");
		 
		Utilaj utilaj;
		FazaProductie fz;
		Double timpFolosire;
		ArrayList<FunctieNecesara> functiiNecesare;
		ArrayList<Angajat> angajati;
		ArrayList<Material> materialeReteta;
		ArrayList <Material> materialeSemifabricat;
		Semifabricat semifabricatContinut;
		Semifabricat semifabricatReteta;
		Semifabricat semifabricatDorit;
		Produs produsDorit;
		Integer nrOrdine;
		Boolean isFinal;
		
		
		 //faza
		
		//utilaj
		MijlocFix mf=new MijlocFix();
		mf.setId(1);
		mf.setDenumire("Utilaj");
		mf.setTermenExploatare(null);
		mf.setValoare(null);
		logger.info("*****Mijlocul fix a fost creat " + mf.getDenumire());
		//Setez utilajul;
		utilaj =new Utilaj();
		utilaj.setUtilaj(mf);
		utilaj.setStatus("ocupat");
		
		//timp folosire
		timpFolosire=  10.00;
		
		//sectie
		Divizie sectie= new Divizie();
		sectie.setId("1");				
		sectie.setDenumire("Departament Productie");
		sectie.setDescriere(null);
		sectie.setParinte(null);
		logger.info("*****Sectia a fost creata " + sectie.getDenumire());
		
		//functii necesare
		FunctieNecesara f1=new FunctieNecesara();						
		f1.setIdFunctie(1);
		f1.setNumeFunctie("Functie 1");
		f1.setNrAngajatiFunctie(1);
				
		FunctieNecesara f2=new FunctieNecesara();
		f2.setIdFunctie(1);
		f2.setNumeFunctie("Functie 2");
		f2.setNrAngajatiFunctie(1);
				
		functiiNecesare = new ArrayList<FunctieNecesara>();
		functiiNecesare.add(f1);
		functiiNecesare.add(f2);
		logger.info("*****Lista de functii a fost creata " + functiiNecesare);
		
		// materiale reteta
		materialeReteta = new ArrayList<Material>();
		Material m3=new Material();
		Material m4=new Material();
		
		m3.setCodMaterial("1");
		m3.setDenumireMaterial("material1");
		m3.setCategorieMaterial(null);
		m3.setCantitateStandard(null);
		logger.info("*****Materialul a fost creat " + m3);
				
		m4.setCodMaterial("2");
		m4.setDenumireMaterial("material2");
		m4.setCategorieMaterial(null);
		m4.setCantitateStandard(null);
		logger.info("*****Materialul a fost creat " + m4);

		materialeReteta.add(m3);
		materialeReteta.add(m4);
		logger.info("*****Lista cu materialele retetei a fost creata " + materialeReteta);
		
		//semifabricat dorit
		semifabricatDorit=new Semifabricat();
		String denSemifabricatDorit = "semifabricat";
		ArrayList<Material> materialeSemifabricatDorit = new ArrayList<Material>();
		Material m7=new Material();
		Material m8=new Material();
		m7.setCodMaterial("3");
		m7.setDenumireMaterial("material3");
		m7.setCategorieMaterial(null);
		m7.setCantitateStandard(null);
		
		m8.setCodMaterial("4");
		m8.setDenumireMaterial("material4");
		m8.setCategorieMaterial(null);
		m8.setCantitateStandard(null);
				
		materialeSemifabricatDorit.add(m7);
		materialeSemifabricatDorit.add(m8);
		
		semifabricatContinut=null;
		semifabricatDorit.setDenumire(denSemifabricatDorit);
		semifabricatDorit.setListaMateriale(materialeSemifabricatDorit);
		semifabricatDorit.setSemifabricatContinut(semifabricatContinut);
		
		
		//produs dorit
		produsDorit=new Produs();
		produsDorit.setIdProdus(1);
		produsDorit.setDenumire("Produs nou");
		produsDorit.setUnitateMasura(null);
		produsDorit.setDataFabricatiei(null);
		produsDorit.setTermenValabilitate(null);
		logger.info("*****Produsul dorit este: " + produsDorit);
		
		
		FazaProductie faza=productie.definireFazaProductie("faza test", flux, utilaj, timpFolosire, functiiNecesare, materialeReteta, semifabricatDorit, produsDorit, sectie, 1, false);
				
		productie.consumResursa(faza, produsNou);
			logger.info(">>>>>>>>>>> SFARSIT TEST CONSUM RESURSE: " );
		 }
	
	
	@Test
	public void testControlCalitate()throws Exception
	{
		logger.info("INCEPERE TEST CONTROL CALITATE");
		Produs produsNou = new Produs();
		 produsNou.setIdProdus(1);
		 produsNou.setDenumire("Produs nou");
		 produsNou.setUnitateMasura(null);
		 produsNou.setDataFabricatiei(null);
		 produsNou.setTermenValabilitate(null);
	
		productie.controlCalitate(produsNou);
	
		logger.info("---END TEST CONTROL CALITATE");	
	}
	
	
	@Test	
	public void testLivrareProdus()throws Exception{
		logger.info(">>>>>>>>>>> INCEPERE TEST LIVRARE PRODUS");
		
		Produs produsNou = new Produs();
		 produsNou.setIdProdus(1);
		 produsNou.setDenumire("Produs nou");
		 produsNou.setUnitateMasura(null);
		 produsNou.setDataFabricatiei(null);
		 produsNou.setTermenValabilitate(null);
	
		ComandaProductie comanda = new ComandaProductie();
		//comanda.setProdus(produsNou);
		//comanda.setDataComanda(null);
		//comanda.setCantitate(10);
		Integer cantitate = comanda.getCantitate();
		//logger.info("*****Comanda este:" + comanda.getIdComanda());
		productie.livrareProdus(cantitate, produsNou);
		
		   logger.info(">>>>>>>>>>>>SFARSIT TEST LIVRARE PRODUS");
		 }

	@Test
	public void testInregistrareGestiuneConsum()throws Exception{
		logger.info(">>>>>>>>>>>>INCEPERE TEST INREGISTRARE GESTIUNE CONSUM");
		testConsumResursa();
		logger.info("*****Consum resurse a fost inregistrat");
		
		logger.info(">>>>>>>>>>>>SFARSIT TEST INREGISTRARE GESTIUNE CONSUM");
	}


	@Test
	public void testInregistrareGestiuneProductie()throws Exception{
		logger.info(">>>>>>>>>INCEPERE TEST INREGISTRARE GESTIUNE PRODUCTIE");
		testControlCalitate();
		logger.info("*****Produsele au fost inregistrate");
		logger.info(">>>>>>>>>SFARSIT TEST INREGISTRARE GESTIUNE PRODUCTIE");
		
	}
	
}
