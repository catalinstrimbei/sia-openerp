package org.open.erp.services.proman.teste;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.proman.Activitate;
import org.open.erp.services.proman.Proiect;
import org.open.erp.services.proman.ProjectManagementSrv;
import org.open.erp.services.proman.Responsabil;

public class TestProjectManagementEJB {
	/* Resurse test*/
	private static Logger logger = Logger.getLogger(TestProjectManagementEJB.class.getName());
	
	/* Unitatea de test sursa/gazda unitatii de test */
	private static ProjectManagementSrv promanInstance;
	
	/* Set up */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		promanInstance = 
			ProjectManagementSrvFactory.getProjectManagementSrv();
		logger.info("initTest " + promanInstance);
	}

	/* Test creare proiect: 
	 * - invocare EJB, 
	 * - procesare EJB compus, 
	 * - procesare tranzactie compusa, 
	 * - procesare persistenta cu 2JPA-PU,
	 * - definire BO local cu asociaţie către BO din alt modul.
	 * */
	//@Test
	public void testCreareProiect() throws Exception{
		
		logger.info("Begin test: creareProiect");
		
		Double valoareBugetata = 2555.0;
		Proiect proiect = promanInstance.creareProiect("Test4", null, null, null, valoareBugetata);
		
		logger.info("Proiectul cu id: " + proiect.getIdProiect() + " a fost creat!");
		
		assertNotNull("Proiect ne-validat!", proiect.getIdProiect());
		
		proiect = promanInstance.getProiect(proiect.getIdProiect());
		
		assertNotNull("Nu exista proiect nou!", proiect);
		logger.info("End test: creareProiect");
	}
	
	/* Test creare proiect: 
	 * - procesare persistenta cu 2JPA-PU
	 * - definire BO local extinzând (moştenind) definiţia BO local din alt modul;
	 * */	
	@Test
	public void testCreareActivitate() throws Exception  {
		logger.info("Begin test: creareActivitate");
		Proiect proiect = promanInstance.creareProiect("Test 1", null, null, null, 1000.0);
		logger.info("Proiectul cu id: " + proiect.getIdProiect() + " a fost creat!");
		assertNotNull("Proiect ne-validat!", proiect.getIdProiect());

		Responsabil responsabil = null; // nomenclatorInstance.getPersoanaCuId(1); ????
		
		Calendar calendarStart = Calendar.getInstance();
		Calendar calendarEnd = Calendar.getInstance();
		
		calendarStart.setTime(new Date());
		calendarEnd.setTime(new Date()); 
		calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);
		
		Activitate activitate1 = promanInstance.creareActivitate(proiect, responsabil, "Prima activitate test", 
				calendarStart.getTime(), calendarEnd.getTime(), 500.0);
		
		calendarStart.add(Calendar.WEEK_OF_MONTH, 2);
		calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);
		
		Activitate activitate2 = promanInstance.creareActivitate(proiect, responsabil, "A doua activitate test", 
				calendarStart.getTime(), calendarEnd.getTime(), 500.0);
		
		logger.info("End test: creareActivitate");
	}	
}
