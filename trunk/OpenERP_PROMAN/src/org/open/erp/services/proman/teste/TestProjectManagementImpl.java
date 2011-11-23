package org.open.erp.services.proman.teste;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.proman.Activitate;
import org.open.erp.services.proman.Proiect;
import org.open.erp.services.proman.ProjectManagementSrv;

public class TestProjectManagementImpl {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestProjectManagementImpl.class.getName());
	ProjectManagementSrv promanInstance;
	NomenclatoareSrv nomenclatorInstance;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		promanInstance= ProjectManagementDummyFactory.getProjectManagementSrv();
		nomenclatorInstance = ProjectManagementDummyFactory.getNomenclatoareSrv();
		logger.info("initTest");		
	}

	@Test
	public void testCreareProiect() {
		logger.info("Begin test: creareProiect");
		
		Double valoareBugetata = 0.0;
		Proiect proiect = promanInstance.creareProiect("Test", null, null, null, valoareBugetata);
		assertNotNull("Nu exista proiect nou!", proiect);
		//assertNotNull("Proiectul nu are buget alocat!", proiect.getBuget());
		//assertEquals("Valoarea bugetata nu concorda cu bugetul alocat!", valoareBugetata, proiect.getBuget().getValoareBuget());
		
		logger.info("End test: creareProiect");
	}

	@Test
	public void testCreareActivitate() {
		logger.info("Begin test: creareActivitate");
		Proiect proiect = promanInstance.creareProiect("Test", null, null, null, 1000.0);
		Persoana responsabil = nomenclatorInstance.getPersoanaCuId(1);
		
		Calendar calendarStart = Calendar.getInstance();
		Calendar calendarEnd = Calendar.getInstance();
		
		calendarStart.setTime(new Date());
		calendarEnd.setTime(new Date()); calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);
		Activitate activitate1 = promanInstance.creareActivitate(proiect, responsabil, "Prima activitate test", 
				calendarStart.getTime(), calendarEnd.getTime(), 500.0);

		
		logger.info("End test: creareActivitate");
	}

	@Test
	public void testStartProiect() {
		logger.info("Begin test: startProiect");
		
		Proiect proiect = promanInstance.creareProiect("Test", null, null, null, 1000.0);
		Persoana responsabil = nomenclatorInstance.getPersoanaCuId(1);
		
		Calendar calendarStart = Calendar.getInstance();
		Calendar calendarEnd = Calendar.getInstance();
		
		calendarStart.setTime(new Date());
		calendarEnd.setTime(new Date()); calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);
		Activitate activitate1 = promanInstance.creareActivitate(proiect, responsabil, "Prima activitate test", 
				calendarStart.getTime(), calendarEnd.getTime(), 500.0);
		
		calendarStart.add(Calendar.MONTH, 2);
		calendarEnd.add(Calendar.WEEK_OF_MONTH, 6);
		Activitate activitate2 = promanInstance.creareActivitate(proiect, responsabil, "Prima activitate test", 
				calendarStart.getTime(), calendarEnd.getTime(), 500.0);
		
		promanInstance.startProiect(proiect);
		
		logger.info("End test: startProiect");
		
	}

	@Test
	public void testProgresActivitate() {
		logger.info("Begin test: progresActivitate");
		
		Proiect proiect = promanInstance.creareProiect("Test", null, null, null, 1000.0);
		Persoana responsabil = nomenclatorInstance.getPersoanaCuId(1);
		
		Calendar calendarStart = Calendar.getInstance();
		Calendar calendarEnd = Calendar.getInstance();
		
		calendarStart.setTime(new Date());
		calendarEnd.setTime(new Date()); calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);
		Activitate activitate1 = promanInstance.creareActivitate(proiect, responsabil, "Prima activitate test", 
				calendarStart.getTime(), calendarEnd.getTime(), 500.0);
		
		calendarStart.add(Calendar.MONTH, 2);
		calendarEnd.add(Calendar.WEEK_OF_MONTH, 6);
		Activitate activitate2 = promanInstance.creareActivitate(proiect, responsabil, "Prima activitate test", 
				calendarStart.getTime(), calendarEnd.getTime(), 500.0);
		
		promanInstance.startProiect(proiect);
		
		promanInstance.progresActivitate(activitate1, 20.0, 350.0, new Date());
		
		logger.info("End test: progresActivitate");
	}

}
