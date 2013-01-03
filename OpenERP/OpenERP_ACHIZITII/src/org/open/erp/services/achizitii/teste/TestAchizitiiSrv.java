package org.open.erp.services.achizitii.teste;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import static org.junit.Assert.assertNotNull;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.open.erp.services.achizitii.AchizitiiSrv;
import org.open.erp.services.achizitii.CerereAprov;
import org.open.erp.services.achizitii.LiniiCerereAprov;
import org.open.erp.services.nommat.Material;

import org.open.erp.services.achizitii.AchizitiiSrv;
import org.open.erp.services.achizitii.CerereAprov;
import org.open.erp.services.achizitii.CerereOferta;
import org.open.erp.services.achizitii.Comanda;
import org.open.erp.services.achizitii.Factura;
import org.open.erp.services.achizitii.Furnizori;
import org.open.erp.services.achizitii.LiniiCerereOferta;
import org.open.erp.services.achizitii.LiniiComanda;
import org.open.erp.services.achizitii.LiniiFactura;
import org.open.erp.services.achizitii.LiniiNIR;
import org.open.erp.services.achizitii.LiniiOferta;
import org.open.erp.services.achizitii.LiniiPlanAprov;
import org.open.erp.services.achizitii.NIR;
import org.open.erp.services.achizitii.Oferta;
import org.open.erp.services.achizitii.PlanAprov;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.stocuri.Gestiune;


public class TestAchizitiiSrv {
	private static Logger logger;

	AchizitiiSrv achizitiiInstance;


	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestAchizitiiSrv.class.getName());	
	}
	
	@Before 
	public void initServices(){	
		achizitiiInstance= AchizitiiSrvFactory.getAchizitiiSrv();
		logger.info("AchizitiiSrv Service intiated for Test!");
	}
	@Test
	public void testCerereAprovizionare() throws Exception{
		logger.setLevel(Level.DEBUG);
		
		logger.info("Begin test TestCerereAprovizionare!");
		//--------
		
		//--------
				Calendar calendarStart = Calendar.getInstance();
				calendarStart.setTime(new Date());		
			
				//
				Material mat = new Material();
				CerereAprov cerere = achizitiiInstance.creareCerereAprov(1, calendarStart.getTime(), mat);

				assertNotNull("Nu exista cerereAprovizionare noua!", cerere);
				//
 
				LiniiCerereAprov linie1 = achizitiiInstance.creareLinieCerereAprov(cerere, 1, mat, 20.00);
				LiniiCerereAprov linie2 = achizitiiInstance.creareLinieCerereAprov(cerere, 2, mat, 30.00);

				//
	
				org.open.erp.services.nommat.Material mat3 = new org.open.erp.services.nommat.Material();
				//CerereAprov cerere = achizitiiInstance.creareCerereAprov(1, calendarStart.getTime(), mat);
				PlanAprov planAprov=achizitiiInstance.crearePlanAprov(1, 2012, 07, 2);
				//assertNotNull("Nu exista cerereAprovizionare noua!", cerere);
				LiniiPlanAprov liniePlan=achizitiiInstance.creareLiniePlan(1, planAprov, mat3, 1.1);
				//--------
				logger.info("End Test CerereAprovizionare!");
	
	}
	
		@Test
		public void testCerereOferta() throws Exception{
			logger.setLevel(Level.DEBUG);
		logger.info("Begin test Test CreareCerereOferta!");
		
		Calendar calendarStart = Calendar.getInstance();
		calendarStart.setTime(new Date());
		
		Material mat3 = new Material();
		PlanAprov planAprov =  new PlanAprov(1, 2012, 07, 2);
		LiniiPlanAprov liniePlan = new LiniiPlanAprov(1, planAprov, mat3, 10.00);//achizitiiInstance.creareLiniePlan(1, planAprov, mat3, 1.1);

		CerereOferta cerereOferta = achizitiiInstance.creareCerereOferta(1, calendarStart.getTime());
		assertNotNull("Nu exista cerere noua!", cerereOferta);
		
		
		Material mat2=achizitiiInstance.stabilireMaterial(liniePlan);
		LiniiCerereOferta linieCerereOferta1=achizitiiInstance.creareLinie(2, 3.3, mat2, cerereOferta);


		//org.open.erp.services.nommat.Materiale material=achizitiiInstance.stabilireMaterial(liniePlan);
		LiniiCerereOferta linieCerereOferta2 = achizitiiInstance.creareLinie(1, 5.0, mat2, cerereOferta);
		
		
		logger.info("End Test CreareCerereOferta!");	
	}	
		
	
		@Test
		public void testOferta() throws Exception{
			logger.setLevel(Level.DEBUG);
			logger.info("Begin test CreareOferta!");

		Calendar calendarStart = Calendar.getInstance();
		calendarStart.setTime(new Date());
			
		Furnizori furnizor1 = new Furnizori("Furnizor1", "Ion");
		CerereOferta cerereOferta = new CerereOferta(1, calendarStart.getTime());
		Oferta oferta = achizitiiInstance.creareOferta(111, calendarStart.getTime(), calendarStart.getTime(),123.00, furnizor1, cerereOferta);

		assertNotNull("Nu exista oferta noua!", oferta);

		//LiniiOferta linieOferta = achizitiiInstance.creareLinieOferta(1, 20.00, linieCerereOferta1.getMaterial(), 7.00, oferta);
		Material mat2 = new Material("111", "Material 2", "buc");
		LiniiOferta linieOferta = achizitiiInstance.creareLinieOferta(1, 20.00, mat2, 7.00, oferta);

		logger.info("S a introdus linia " + linieOferta.getNrLinie() + " pentru oferta " + oferta.getNrOferta());
		
		Oferta oferta2 = achizitiiInstance.creareOferta(112, calendarStart.getTime(), calendarStart.getTime(),127.00, furnizor1, cerereOferta);
		assertNotNull("Nu exista oferta noua!", oferta);
		  
		  
		  logger.info("Oferta finala" );
		  
		  List<Oferta> oferte= new ArrayList<Oferta>();
		  oferte.add(oferta);
		  oferte.add(oferta2);
		  Oferta ofertaAleasa = oferte.get(1);
		   for (int i=1; i< oferte.size(); i++)
		   {
		    Oferta ofertaFinala = achizitiiInstance.comparare(ofertaAleasa, oferte.get(i));
		     ofertaAleasa = ofertaFinala;
		   }
		   
		   Oferta ofertaFinala = achizitiiInstance.comparare(oferta,oferta2);
		   logger.info("Oferta finala " + ofertaFinala.getNrOferta());
	
	}
		  
		@Test
		public void testComanda() throws Exception{
			logger.setLevel(Level.DEBUG);
			logger.info("Begin Test Comanda!");

			Calendar calendarStart = Calendar.getInstance();
			calendarStart.setTime(new Date());
			
		   logger.info("Begin Test Comanda!");
		   
			Furnizori furnizor1 = new Furnizori("Furnizor1", "Ion");
			CerereOferta cerereOferta = new CerereOferta(1, calendarStart.getTime());
			Oferta oferta = achizitiiInstance.creareOferta(111, calendarStart.getTime(), calendarStart.getTime(),123.00, furnizor1, cerereOferta);
			Oferta oferta2 = achizitiiInstance.creareOferta(112, calendarStart.getTime(), calendarStart.getTime(),127.00, furnizor1, cerereOferta);
			Oferta ofertaFinala = achizitiiInstance.comparare(oferta,oferta2);
			
			Comanda comanda1 = achizitiiInstance.creareComanda(1, calendarStart.getTime(), furnizor1, ofertaFinala, ofertaFinala.getValoareTotala());
			assertNotNull("Nu exista cerereAprovizionare noua!", comanda1);
			
			Material mat2 = new Material("111", "Material 2", "buc");
			LiniiOferta linieOferta = new LiniiOferta(1, 2.00, mat2, 2.00, ofertaFinala);
			LiniiComanda linieComanda1 = achizitiiInstance.creareLinieComanda(1, 10.00, mat2, 50.00, comanda1, linieOferta);
			logger.info("S a introdus linia " + linieComanda1.getNrLinie() + " pentru comanda " + comanda1.getNrComanda());

			achizitiiInstance.salveazaComanda(comanda1);
			achizitiiInstance.trimitereComanda(comanda1, furnizor1);
			
			logger.info("End Test Comanda!");
			
		}

		@Test
		public void testFactura() throws Exception{
			logger.setLevel(Level.DEBUG);
		    logger.info("Begin Test Facura!");

			Calendar calendarStart = Calendar.getInstance();
			calendarStart.setTime(new Date());

			Furnizori furnizorA = new Furnizori("Furnizor A SRL");
			Factura factura1 = achizitiiInstance.creareFactura(1, calendarStart.getTime(), calendarStart.getTime(), 200.00, furnizorA.getDenumire());
			assertNotNull("Nu exista Factura ", factura1);
			
			Material mat2 = new Material("111", "Material 2", "buc");
			Furnizori furnizor1 = new Furnizori("Furnizor1", "Ion");
			//CerereOferta cerereOferta = new CerereOferta(1, calendarStart.getTime());
			//Oferta oferta = new Oferta(111, calendarStart.getTime(), calendarStart.getTime(),123.00, furnizor1, cerereOferta);
			//Oferta oferta2 = new Oferta(112, calendarStart.getTime(), calendarStart.getTime(),127.00, furnizor1, cerereOferta);
			//Oferta ofertaFinala = achizitiiInstance.comparare(oferta,oferta2);
			//LiniiOferta linieOferta = new LiniiOferta(1, 20.00, mat2, 7.00, oferta);
			Comanda comanda1 = new Comanda(1, calendarStart.getTime(), furnizor1, 200.00);
			LiniiComanda linieComanda1 = new LiniiComanda(1, 10.00, mat2, 50.00, comanda1);
			LiniiFactura lf1 = achizitiiInstance.creareLinieFactura(001, 1.00, linieComanda1.getMaterial(), 5.00, factura1, linieComanda1);
			LiniiFactura lf2 = achizitiiInstance.creareLinieFactura(002, 2.00, linieComanda1.getMaterial(), 5.00, factura1, linieComanda1);
			assertNotNull("Nu exista linieFactura ", lf1); 
			logger.info("End Test Factura!");

		}
		
			    
    //Test NIR
		@Test
		public void testNIR() throws Exception{
			logger.setLevel(Level.DEBUG);
		    logger.info("Begin Test NIR!!!");

			Calendar calendarStart = Calendar.getInstance();
			calendarStart.setTime(new Date());
			
			Furnizori furnizor1 = new Furnizori("Furnizor1", "Ion");
			NIR nir1= achizitiiInstance.creareNIR(1, calendarStart.getTime(), furnizor1, 120.00);
			assertNotNull("Nu exista NIR nou!", nir1);
	    
			//Adaugare linie in NIR
			Gestiune gestiune11 = new Gestiune(2, "Gestiune pentru Stocuri");
			Material mat01 = new Material("5", "mat8", "buc");
			Material mat02 = new Material("5", "mat5", "buc");
			LiniiNIR liniNir1=achizitiiInstance.creareLiniiNIR(nir1, 1, mat01, 12.00, 5.4, 64.8, 15.55, gestiune11);
			LiniiNIR liniNir2=achizitiiInstance.creareLiniiNIR(nir1, 2, mat02, 2.00, 5.4, 64.8, 15.55, gestiune11);

	      //liniNir1.add(nir1.getLinieNir());
	      //nir1.getLinieNir().add(liniNir1);
//			achizitiiInstance.trimitereMaterialLaStoc2(liniNir1, gestiune11);
//			achizitiiInstance.trimitereMaterialLaStoc2(liniNir2, gestiune11);
			achizitiiInstance.trimitereMaterialLaStoc2(mat01, 2.00, 2.00, gestiune11);
		  //nir1.getLinieNir().add(liniNir1);
		  //achizitiiInstance.creareLiniiNIR(nir1, 1, mat3, 2.00, 1.00, 3.00, 1.90, gestiune11);
		  //achizitiiInstance.intrareStoc(nir1, gestiune11);
			assertNotNull("Nu exista linieNir noua!", nir1);
	     
	    logger.info("End Test NIR!");
	    
	}	
		
	  //Test crestere cantitate in Stoc
		@Test
		public void testCrestereCantitateStoc() throws Exception{
			logger.setLevel(Level.DEBUG);
		    logger.info("Begin Test crestere cantitate Stoc.");
	    
	    
		    Calendar calendarStart = Calendar.getInstance();
			calendarStart.setTime(new Date());
			
			Furnizori furnizorA = new Furnizori("Furnizor A SRL");
			Furnizori furnizor1 = new Furnizori("Furnizor1", "Ion");
			Gestiune gestiune1 = new Gestiune(1, "Gestiunea ABC");
			NIR nir1= new NIR(1, calendarStart.getTime(), furnizor1, 120.00);
			NIR nir2 = new NIR(10, calendarStart.getTime(), furnizorA, 100.00);
			Gestiune gestiune11 = new Gestiune(111, "Gestiune pentru Stocuri");
			Material mat01 = new Material("5", "mat8", "buc");
			Material mat4 = new Material("4", "mat4", "buc");
			Material mat5 = new Material("5", "mat5", "buc");
			LiniiNIR linieNIR1 = new LiniiNIR(nir1, 1, mat01, 10.00, 10.00, 100.00, 24.00); //daca materialul nu e instantiat aici nu il recunoaste, de ex daca in loc de mat4 scriu mat2
			LiniiNIR linieNIR2 = new LiniiNIR(nir2, 2, mat5, 30.00, 10.00, 100.00, 24.00);
		 
			//nir1.getLinieNir().add(linieNIR1);
			achizitiiInstance.crestereStoc(mat01, gestiune11, nir1, linieNIR1);
			achizitiiInstance.crestereStoc(mat5, gestiune1, nir2, linieNIR2);
			logger.info("End Test crestere cantitate Stoc....");
		
	}
	

}


//Transformare proiect in proiect java Beans. de pus adnotari @EJP si dat url-ul catre modulul celalalt pe care l am importat.
//Java persistence API
//jar pentru unitatea de persistenta in xml de pus