package org.open.erp.services.contabgest.teste;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.contabgest.Activitate;
import org.open.erp.services.contabgest.CentruCost;
import org.open.erp.services.contabgest.CentruCostSRV;
import org.open.erp.services.personal.Persoana;
import org.open.erp.services.personal.PersonalSRV;

public class TestCentruCostImpl {

	
	 private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestCentruCostImpl.class.getName());
	 CentruCostSRV contabgestInstance;
	 PersonalSRV personalInstance;
	 
	 @BeforeClass
	 public static void setUpBeforeClass() throws Exception {
	 }
	 
	 @Before
	 public void setUp() throws Exception {
		 contabgestInstance= CentruCostDummyFactory.getCentruCostSrv();
		 personalInstance = CentruCostDummyFactory.getPersonalSrv();
	 logger.info("initTest"); 
	 }
	 
	 @Test
	 public void testCreareCentruCost() {
	 logger.info("Begin test: creareCentruCost");

	 Double sumaCentruCost = 0.0;
	 CentruCost centruCost = contabgestInstance.creareCentruCost("Test", null, null, null, sumaCentruCost);
	 assertNotNull("Nu exista proiect nou!", centruCost);
	
	 //assertNotNull("Proiectul nu are buget alocat!", proiect.getBuget());
	//assertEquals("Valoarea bugetata nu concorda cu bugetul alocat!", valoareBugetata, proiect.getBuget().getValoareBuget());

	logger.info("End test: creareCentruCost");
	}
	
	 @Test
	 public void testCreareActivitate() {
	 logger.info("Begin test: creareActivitate");
	 CentruCost centruCost = contabgestInstance.creareCentruCost("Test", null, null, null, 1000.0);
	 Persoana responsabil = personalInstance.getPersoanaCuId(1);

	 Calendar calendarStart = Calendar.getInstance();
	 Calendar calendarEnd = Calendar.getInstance();
	 calendarStart.setTime(new Date());
	 calendarEnd.setTime(new Date()); calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);
	 Activitate activitate1 = contabgestInstance.creareActivitate(centruCost, responsabil, "Prima activitate test", 
	 calendarStart.getTime(), calendarEnd.getTime(), 500.0);


	 logger.info("End test: creareActivitate");
	 }
	 
	 
	 @Test
	 public void testStartCentruCost() {
	 logger.info("Begin test: startCentruCost");

	 CentruCost centruCost = contabgestInstance.creareCentruCost("Test", null, null, null, 1000.0);
	 Persoana responsabil = personalInstance.getPersoanaCuId(1);

	 Calendar calendarStart = Calendar.getInstance();
	 Calendar calendarEnd = Calendar.getInstance();
	 calendarStart.setTime(new Date());
	 calendarEnd.setTime(new Date()); calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);
	 Activitate activitate1 = contabgestInstance.creareActivitate(centruCost, responsabil, "Prima activitate test", 
	 calendarStart.getTime(), calendarEnd.getTime(), 500.0);

	 calendarStart.add(Calendar.MONTH, 2);
	 calendarEnd.add(Calendar.WEEK_OF_MONTH, 6);
	 Activitate activitate2 = contabgestInstance.creareActivitate(centruCost, responsabil, "Prima activitate test", 
	 calendarStart.getTime(), calendarEnd.getTime(), 500.0);

	 contabgestInstance.startCentruCost(centruCost);

	 logger.info("End test: startCentruCost");

	 }
	 
	 
	 @Test
	 public void testProgresActivitate() {
	 logger.info("Begin test: progresActivitate");

	 CentruCost centruCost = contabgestInstance.creareCentruCost("Test", null, null, null, 1000.0);
	 Persoana responsabil = personalInstance.getPersoanaCuId(1);

	 Calendar calendarStart = Calendar.getInstance();
	 Calendar calendarEnd = Calendar.getInstance();
	 calendarStart.setTime(new Date());
	 calendarEnd.setTime(new Date()); calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);
	 Activitate activitate1 = contabgestInstance.creareActivitate(centruCost, responsabil, "Prima activitate test", 
	 calendarStart.getTime(), calendarEnd.getTime(), 500.0);

	 calendarStart.add(Calendar.MONTH, 2);
	 calendarEnd.add(Calendar.WEEK_OF_MONTH, 6);
	 Activitate activitate2 = contabgestInstance.creareActivitate(centruCost, responsabil, "Prima activitate test", 
	 calendarStart.getTime(), calendarEnd.getTime(), 500.0);

	
	 contabgestInstance.startCentruCost(centruCost);

	 contabgestInstance.progresActivitate(activitate1, 20.0, 350.0, new Date());

	 logger.info("End test: progresActivitate");
	 }
	 
	 
}

