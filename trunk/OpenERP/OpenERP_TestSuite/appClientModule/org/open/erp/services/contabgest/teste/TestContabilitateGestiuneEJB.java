package org.open.erp.services.contabgest.teste;

import static org.junit.Assert.assertNotNull;

import org.open.erp.services.contabgest.Analiza;
import org.open.erp.services.contabgest.ContabilitateGestiuneSRV;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestContabilitateGestiuneEJB {
	/* Resurse test*/
	private static Logger logger = Logger.getLogger(TestContabilitateGestiuneEJB.class.getName());
	
	
	/* Unitatea de test sursa/gazda unitatii de test */
	private static ContabilitateGestiuneSRV contabgestInstance;
	
	
	/* Set up */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		contabgestInstance = ContabilitateGestiuneSrvFactory.getContabilitateGestiuneSRV();
		logger.info("initTest " + contabgestInstance);
	}

	/* Test creare proiect: 
	 * - invocare EJB, 
	 * - procesare EJB compus, 
	 * - procesare tranzactie compusa, 
	 * - procesare persistenta cu 2JPA-PU,
	 * - definire BO local cu asociatie catre BO din alt modul.
	 * */
	//@Test
	public void testCreareAnaliza() throws Exception{
		
		logger.info("Begin test: creareAnaliza");
		
		Double procentRealizare = 10.00;
		Analiza analiza = contabgestInstance.creareAnaliza("Analiza1", null,  null, procentRealizare);
		
		logger.info("Analiza cu id: " + analiza.getIdAnaliza() + " a fost creata!");
		
		assertNotNull("Analiza ne-validata!", analiza.getIdAnaliza());
		
		analiza = contabgestInstance.getAnaliza(analiza.getIdAnaliza());
		
		assertNotNull("Nu exista analiza noua!", analiza);
		logger.info("End test: creareAnaliza");
	}
	
	/* Test creare proiect: 
	 * - procesare persistenta cu 2JPA-PU
	 * - definire BO local extinzand (mostenind) definitia BO local din alt modul;
	 * */	
	@Test
	public void testCreareCalculatii() throws Exception  {
		logger.info("Begin test: creareCalculatii");
		Analiza analiza = contabgestInstance.creareAnaliza("Analiza2", null, null, null, 100.00);
		logger.info("Analiza cu id: " + analiza.getIdAnaliza() + " a fost creata!");
		assertNotNull("Analiza ne-validata!", analiza.getIdAnaliza());
	
		
		Calculatii calculatie1 = contabgestInstance.creareCalculatii(analiza, null, 100.00 );
		
		Calculatii calculatie2 = contabgestInstance.creareCalculatii(analiza, null, 300.00);
		
		
		
		logger.info("End test: creareCalculatie");
	}	
}
