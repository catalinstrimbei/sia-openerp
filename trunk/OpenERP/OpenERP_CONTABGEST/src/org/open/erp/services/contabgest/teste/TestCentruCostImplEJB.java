package org.open.erp.services.contabgest.teste;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.contabgest.Activitate;
import org.open.erp.services.contabgest.CentruCost;
import org.open.erp.services.contabgest.CentruCostSRV;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.PersonalSrv;



public class TestCentruCostImplEJB {

	
	 private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestCentruCostImpl.class.getName());
	 CentruCostSRV contabgestInstance;
	 PersonalSrv personalInstance;
	 
	 @BeforeClass
	 public static void setUpBeforeClass() throws Exception {
	 }
	 
	 @Before
	 public void setUp() throws Exception {
		 contabgestInstance= CentruCostFactory.getCentruCostSrv();
		 personalInstance = CentruCostFactory.getPersonalSrv();
	 logger.info("initTest"); 
	 }
	 
	 @Test
	 public void testCreareCentruCost() {
	 logger.info("Begin test: creareCentruCost");

	 Double sumaCentruCost = 0.0;
	 CentruCost centruCost = contabgestInstance.creareCentruCost("Test", null, null, null, null, sumaCentruCost);
	 assertNotNull("Nu exista Centru Cost nou!", centruCost);
	
	 //assertNotNull("Centrul Cost nu are o activitate alocata!", centruCost.getCentruCost());
	
	logger.info("End test: creareCentruCost");
	}
	
	 @Test
	 public void testCreareActivitateEJB() {
	 logger.info("Begin test: creareActivitate");
	 CentruCost centruCost = contabgestInstance.creareCentruCost("Test", null, null, null, null, 1000.0);
	 Angajat responsabil = personalInstance.getAngajatById(1);

	 Calendar calendarStart = Calendar.getInstance();
	 Calendar calendarEnd = Calendar.getInstance();
	 calendarStart.setTime(new Date());
	 calendarEnd.setTime(new Date()); calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);
	 Activitate activitate1 = contabgestInstance.creareActivitate(centruCost,  null, responsabil, "Prima activitate test", 
	 calendarStart.getTime(), calendarEnd.getTime(), 500.0);


	 logger.info("End test: creareActivitate");
	 }
	 

	 
public class TestCentruCostEJB {

	/* Resurse test */
	private static   Logger logger = Logger.getLogger(TestCentruCostEJB.class
			.getName());

	/* Unitatea de test sursa/gazda unitatii de test */
	private static CentruCostSRV centruCostInstance;
	// private CentruCostSRV contabgestInstance;
	private static PersonalSrv personalInstance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InitialContext ctx = initJBossJNDICtx();
		centruCostInstance = (CentruCostSRV) ctx.lookup("CentruCostSRV/remote");
		personalInstance = (PersonalSrv) ctx.lookup("personalInstance/remote");
		logger.info("initTest " + centruCostInstance);
	}

	 @Test
	 public void testStartCentruCost() throws Exception {
	 logger.info("Begin test: startCentruCost");

	 CentruCost centruCost = centruCostInstance.creareCentruCost("Test", null, null, null, null, 1000.0);
	 Angajat responsabil = personalInstance.getAngajatById(1);
	 

	 Calendar calendarStart = Calendar.getInstance();
	 Calendar calendarEnd = Calendar.getInstance();
	 calendarStart.setTime(new Date());
	 calendarEnd.setTime(new Date()); calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);
	 Activitate activitate1 = centruCostInstance.creareActivitate(centruCost, null, responsabil, "Prima activitate test", 
	 calendarStart.getTime(), calendarEnd.getTime(), 500.0);

	 calendarStart.add(Calendar.MONTH, 2);
	 calendarEnd.add(Calendar.WEEK_OF_MONTH, 6);
	 Activitate activitate2 = centruCostInstance.creareActivitate(centruCost, null, responsabil, "Prima activitate test", 
	 calendarStart.getTime(), calendarEnd.getTime(), 500.0);

	 centruCostInstance.startCentruCost(centruCost);

	 logger.info("End test: startCentruCost");

	 }
	
	@Test
	public void testProgresActivitate() throws Exception {
		logger.info("Begin test: progresActivitate");

		CentruCost centruCost = centruCostInstance.creareCentruCost("Test",
				null, null, null, null, 1000.0);
		Angajat responsabil = personalInstance.getAngajatById(1);

		Calendar calendarStart = Calendar.getInstance();
		Calendar calendarEnd = Calendar.getInstance();
		calendarStart.setTime(new Date());
		calendarEnd.setTime(new Date());
		calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);
		Activitate activitate1 = centruCostInstance.creareActivitate(
				centruCost, null, responsabil, "Prima activitate test",
				calendarStart.getTime(), calendarEnd.getTime(), 500.0);

		calendarStart.add(Calendar.MONTH, 2);
		calendarEnd.add(Calendar.WEEK_OF_MONTH, 6);
		Activitate activitate2 = centruCostInstance.creareActivitate(
				centruCost, null, responsabil, "Prima activitate test",
				calendarStart.getTime(), calendarEnd.getTime(), 500.0);

		centruCostInstance.startCentruCost(centruCost);
		centruCostInstance.progresActivitate(activitate1, 20.0, 350.0,
				new Date());

		logger.info("End test: progresActivitate");
	}

	private static InitialContext initJBossJNDICtx() throws NamingException {
		Properties props = new Properties();
		props.put("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		props.put("java.naming.provider.url", "jnp://localhost:1099/");
		props.put("java.naming.factory.url.pkgs",
				"org.jboss.naming:org.jnp.interfaces");
		return new InitialContext(props);
	}
	 
}
}


