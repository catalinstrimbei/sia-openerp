package org.open.erp.services.contabgest.teste;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;


import org.open.erp.services.contabgest.CheltuieliFixe;
import org.open.erp.services.contabgest.ContabGestSrv;
//import org.open.erp.services.contabgest.DummyPersoana;
import org.open.erp.services.contabgest.ProdusFinit;

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
	
	
/*
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
	*/
	/*
		@Test
		public void testCrearePersoana() throws Exception{
			
			logger.info("Begin test: crearePersoana");
			
			//Double valoareBugetata = 2555.0;
			DummyPersoana dummyPersoana = contabGestInstance.defDummyPersoana( "Abc", "Abc", "Abc");
			logger.info("Persoana cu id: " + dummyPersoana.getId() + " a fost creat!");
			
			assertNotNull("Persoana ne-validat!", dummyPersoana.getId());
			
			//dummyPersoana = contabGestInstance.defDummyPersoana(id, nume, prenume, formaAdresare, gen, cnp)(proiect.getIdProiect());
			
			assertNotNull("Nu exista proiect nou!", dummyPersoana);
			logger.info("End test: crearePersoana");
		}
		*/
	
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
		public void testCreareCheltuieliFixe() throws Exception{
			
			logger.info("Begin test: creareCheltuieliFixe");
			
			//Double valoareBugetata = 2555.0;
			CheltuieliFixe cheltuieliFixe = contabGestInstance.defCheltuieliFixe("FIXA", "Cheltuiala fixa 1", "Detalii 1");
			logger.info("Cheltuiala fixa cu id: " + cheltuieliFixe.getIdTipCheltuieli() + " a fost creata!");
			
			assertNotNull("Cheltuiala fixa ne-validat!", cheltuieliFixe.getIdTipCheltuieli());
			
			//dummyPersoana = contabGestInstance.defDummyPersoana(id, nume, prenume, formaAdresare, gen, cnp)(proiect.getIdProiect());
			
			assertNotNull("Nu exista Cheltuiala fixa noua!", cheltuieliFixe);
			logger.info("End test: crearecheltuieliFixe");
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
