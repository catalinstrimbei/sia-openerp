package org.open.erp.services.contabgest.teste;

import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;


import org.open.erp.services.contabgest.CentruCost;
import org.open.erp.services.contabgest.CheltuieliFixe;
import org.open.erp.services.contabgest.CheltuieliVariabile;
import org.open.erp.services.contabgest.ContabGestSrv;
import org.open.erp.services.contabgest.DummyFazaProductie;
import org.open.erp.services.contabgest.DummyPersoana;
import org.open.erp.services.contabgest.ProceseTehnicoEconomice;
import org.open.erp.services.contabgest.ProdusFinit;
import org.open.erp.services.contabgest.ResponabilCentruCost;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import static org.junit.Assert.assertNotNull;


public class TestContabGestEJB {
	
	
	/* Resurse test*/
	private static Logger logger = Logger.getLogger(TestContabGestEJB.class.getName());
	
	/* Unitatea de test sursa/gazda unitatii de test */
	private static ContabGestSrv contabGestInstance;
	
	/* Set up */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InitialContext ctx = initJBossJNDICtx();
		
		contabGestInstance = (ContabGestSrv)ctx.lookup("ContabGestSrv/remote");
		logger.info("initTest " + contabGestInstance);
	}
	
	

	@Test
	public void testFunctieById() throws Exception
	{
		DummyPersoana dummyPersoana = contabGestInstance.getPersoanaId(2);
		if(dummyPersoana != null)
			System.out.println("Nume persoana: " + dummyPersoana.getNume().toString());
		else
		{
			System.out.println("Nu exista persoana cu acest id.");
		}
	}
	
	
		@Test
		public void testCrearePersoana() throws Exception{
			
			logger.info("Begin test: crearePersoana");
			
			//Double valoareBugetata = 2555.0;
			DummyPersoana dummyPersoana = contabGestInstance.defDummyPersoana( "Abc", "Abc", "Abc");
			logger.info("Persoana cu id: " + dummyPersoana.getId() + " a fost creat!");
			
			assertNotNull("Persoana ne-validat!", dummyPersoana.getId());
			
			assertNotNull("Nu exista proiect nou!", dummyPersoana);
			logger.info("End test: crearePersoana");
		}
		
		@Test
		public void testCreareProdusFinit() throws Exception{
			
			logger.info("Begin test: creareProdusFinit");
			
			//Double valoareBugetata = 2555.0;
			ProdusFinit produsFinit = contabGestInstance.defProdusFinit("Produs 1", 1.2);
			logger.info("Produsul cu id: " + produsFinit.getIdProdusFinit() + " a fost creat!");
			
			assertNotNull("Produsul ne-validat!", produsFinit.getIdProdusFinit());
			
			//dummyPersoana = contabGestInstance.defDummyPersoana(id, nume, prenume, formaAdresare, gen, cnp)(proiect.getIdProiect());
			
			assertNotNull("Nu exista produs finit nou nou!", produsFinit);
			logger.info("End test: creareProdusFinit");
		}
		
		
		
		
		@Test
		public void testCreareProcesTehnicoEconomic() throws Exception{
			
			logger.info("Begin test: creareProcesTehnicoEconomic");
			
			ProceseTehnicoEconomice proceseTehnicoEconomice = contabGestInstance.defProceseTehnicoEconomice("ASAMBLARE 1", "Procesul de asamblare a tuturor produselor");
			
			logger.info("Procesul Tehnico-economic cu id: " + proceseTehnicoEconomice.getIdProces() + " a fost creat!");
			
			assertNotNull("Procesul Tehnico-economic ne-validat!", proceseTehnicoEconomice.getIdProces());
			
			assertNotNull("Nu exista Procesul Tehnico-economic nou!", proceseTehnicoEconomice);
			logger.info("End test: creare	Proces Tehnico-economic");
		}
		
		
		@Test
		public void testCreareDummyFazaProductie() throws Exception{
			
			logger.info("Begin test: creareDummyFazaProductie");
			
			DummyFazaProductie dummyFazaProductie = contabGestInstance.defDummyFazaProductie("Faza Peoductie 1", new Date("10/12/2010"), new Date("10/03/2011"), 1000.00);
			
			logger.info("DummyFazaProductie cu id: " + dummyFazaProductie.getIdFazaProductie() + " a fost creat!");
			
			assertNotNull("DummyFazaProductie ne-validat!", dummyFazaProductie.getIdFazaProductie());
			
			assertNotNull("Nu exista DummyFazaProductie nou!", dummyFazaProductie);
			logger.info("End test: creare	DummyFazaProductie");
		}
		
		
		
		@Test
		public void testCreareCentruCost() throws Exception{
			
			logger.info("Begin test: creareCentruCost");
			
			ResponabilCentruCost responabilCentruCost;
			
			DummyFazaProductie dummyFazaProductie;
			
			ProdusFinit produsfinit;
			
			ProceseTehnicoEconomice proceseTehnicoEconomice;
			responabilCentruCost = contabGestInstance.defResponabilCentruCost("Georgescu", "Ionel", "Dl.", 1, new Date("10/12/2010"), 
					new Date("10/03/2011"), "Detalii 1");
			responabilCentruCost = contabGestInstance.getResponabilCentruCostById(5);
			System.out.println(responabilCentruCost);
			dummyFazaProductie = contabGestInstance.defDummyFazaProductie("Faza Peoductie 1", new Date("10/12/2010"), new Date("10/03/2011"), 1000.00);
			//dummyFazaProductie = new DummyFazaProductie("Faza Peoductie 1", new Date("10/12/2010"), new Date("10/03/2011"), 1000.00);
			dummyFazaProductie = contabGestInstance.getDummyFazaProductieById(4);
			System.out.println(dummyFazaProductie);
			
			produsfinit = contabGestInstance.getProdusFinitById(2);
			System.out.println(produsfinit);
			
			//proceseTehnicoEconomice =  contabGestInstance.defProceseTehnicoEconomice("Proces Tehnico-Economic 2", "Detalii 2");
			//proceseTehnicoEconomice =  new ProceseTehnicoEconomice("Proces Tehnico-Economic 2", "Detalii 2");
			proceseTehnicoEconomice = contabGestInstance.getProceseTehnicoEconomiceById(3);
			System.out.println(proceseTehnicoEconomice);		
			
			
			
			CentruCost centruCost = contabGestInstance.defCentruCost("Centru Cost 1", new Date("10/12/2010"), 
					new Date("10/03/2011"), responabilCentruCost, dummyFazaProductie, 
					proceseTehnicoEconomice, produsfinit);
			
			
			
			logger.info("Centrul de Cost cu id: " + centruCost.getIdCentruCost() + " a fost creat!");
			
			assertNotNull("Centrul de Cost ne-validat!", centruCost.getIdCentruCost());
			
			assertNotNull("Nu exista Centrul de Cost nou!", centruCost);
			logger.info("End test: creare	Centrul de Cost");
		}
		
		@Test
		public void testCreareCheltuieliFixe() throws Exception{
			
			logger.info("Begin test: creareCheltuieliFixe");
			
			CentruCost centruCost = contabGestInstance.getCentruCostById(12);
			
			//Double valoareBugetata = 2555.0;
			CheltuieliFixe cheltuieliFixe = contabGestInstance.defCheltuieliFixe("FIXA", "Cheltuiala fixa 1", "Detalii 1", centruCost);
			
			logger.info("Cheltuiala fixa cu id: " + cheltuieliFixe.getIdTipCheltuieli() + " a fost creata!");
			
			assertNotNull("Cheltuiala fixa ne-validat!", cheltuieliFixe.getIdTipCheltuieli());
			
			//dummyPersoana = contabGestInstance.defDummyPersoana(id, nume, prenume, formaAdresare, gen, cnp)(proiect.getIdProiect());
			
			assertNotNull("Nu exista Cheltuiala fixa noua!", cheltuieliFixe);
			logger.info("End test: crearecheltuieliFixe");
		}
		
		

		@Test
		public void testCreareCheltuieliVariabile() throws Exception{
			
			logger.info("Begin test: creareCheltuieliVariabile");
			
			CentruCost centruCost = contabGestInstance.getCentruCostById(12);
			
			CheltuieliVariabile cheltuieliVariabile = contabGestInstance.defCheltuieliVariabile(  "VARIABILA", "Cheltuiala variabila 1", "Detalii 1", 100, centruCost);
			
			logger.info("Cheltuiala variabila cu id: " + cheltuieliVariabile.getIdTipCheltuieli() + " a fost creata!");
			
			assertNotNull("Cheltuiala variabila ne-validat!", cheltuieliVariabile.getIdTipCheltuieli());
			
			assertNotNull("Nu exista Cheltuiala variabila noua!", cheltuieliVariabile);
			logger.info("End test: creare	CheltuieliVariabile");
		}
		
	private static InitialContext initJBossJNDICtx() throws NamingException
	{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}	

}
