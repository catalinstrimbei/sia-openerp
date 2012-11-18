package org.open.erp.services.achizitii.teste;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.achizitii.AchizitiiSrv;
import org.open.erp.services.achizitii.CerereAprov;
import org.open.erp.services.achizitii.CerereOferta;
import org.open.erp.services.achizitii.LiniiCerereAprov;
import org.open.erp.services.achizitii.LiniiCerereOferta;
import org.open.erp.services.achizitii.LiniiPlanAprov;
import org.open.erp.services.achizitii.PlanAprov;
import org.open.erp.services.nommat.Materiale;




public class TestAchizitiiSrv {
	private static Logger logger;

	AchizitiiSrv achizitiiInstance;
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestAchizitiiSrv.class.getName());	
	}
	
	@Before public void initServices(){	
		achizitiiInstance= AchizitiiSrvFactory.getAchizitiiSrv();
		logger.info("AchizitiiSrv Service intiated for Test!");
	}
	
	@Test
	public void testCreareCerereOferta() throws Exception{
		logger.setLevel(Level.DEBUG);
		logger.info("Begin test TestAchizitiiSrv!");
		
		Calendar calendarStart = Calendar.getInstance();
		calendarStart.setTime(new Date());
		
		CerereOferta cerereOferta = achizitiiInstance.creareCerereOferta(1, calendarStart.getTime());
		assertNotNull("Nu exista cerere noua!", cerereOferta);
		
		org.open.erp.services.nommat.Materiale mat = new org.open.erp.services.nommat.Materiale();
		CerereAprov cerere = achizitiiInstance.creareCerereAprov(1, calendarStart.getTime(), mat);
		PlanAprov planAprov=achizitiiInstance.crearePlanAprov(1, 2012, 07, 2);
		assertNotNull("Nu exista cerereAprovizionare noua!", cerere);
		
		LiniiPlanAprov liniePlan=achizitiiInstance.creareLiniePlan(1, planAprov, mat, 1.1);
		org.open.erp.services.nommat.Materiale material=achizitiiInstance.stabilireMaterial(liniePlan);
		LiniiCerereOferta linie1 = achizitiiInstance.creareLinie(1, 5.0, material, cerereOferta);
		
		
	}
	@Test
	public void testCreareProiect() throws Exception{
		logger.setLevel(Level.DEBUG);
		
		logger.info("Begin test TestAchizitiiSrv!");
		//--------
		
		//--------
				Calendar calendarStart = Calendar.getInstance();
				Calendar calendarEnd = Calendar.getInstance();		
				calendarStart.setTime(new Date());		
				calendarEnd.add(Calendar.MONTH, 2);
				//
				Materiale mat = new Materiale();
				CerereAprov cerere = achizitiiInstance.creareCerereAprov(1, calendarStart.getTime(), mat);
				assertNotNull("Nu exista cerereAprovizionare noua!", cerere);
				//
 
				LiniiCerereAprov linie1 = achizitiiInstance.creareLinieCerereAprov(cerere, 1, mat, 20.00);
				LiniiCerereAprov linie2 = achizitiiInstance.creareLinieCerereAprov(cerere, 2, mat, 30.00);

				//
	
				
				//--------
				logger.info("End Test TestAchizitiiSrv!");
		
	}
}
