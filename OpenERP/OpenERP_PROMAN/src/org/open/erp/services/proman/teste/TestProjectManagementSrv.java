package org.open.erp.services.proman.teste;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.proman.Activitate;
import org.open.erp.services.proman.Proiect;
import org.open.erp.services.proman.ProjectManagementSrv;
import org.open.erp.services.proman.Responsabil;

/**
 * 
 * Foloseste numai ERP.API fara dependente relativ la implementare.
 * Instantele concrete de implementare ale serviciilor sunt furnizate de clase Factory.
 * 
 * @author catalin.strimbei
 *
 */
public class TestProjectManagementSrv {
	private static Logger logger;
	ProjectManagementSrv promanInstance;
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestProjectManagementSrv.class.getName());	
	}
	
	@Before public void initServices(){	
		logger.setLevel(Level.DEBUG);
		
		promanInstance= ProjectManagementSrvFactory.getProjectManagementSrv();
		logger.info("ProjectManagementSrv Service intiated for Test!");
	}
	
	@Test
	public void testCreareProiect() throws Exception{
		
		
		logger.info("Begin test TestProjectManagementSrv!");
		//--------
		Calendar calendarStart = Calendar.getInstance();
		Calendar calendarEnd = Calendar.getInstance();		
		calendarStart.setTime(new Date());
		calendarEnd.setTime(new Date());		
		calendarEnd.add(Calendar.MONTH, 2);
		//
		Proiect proiect = promanInstance.creareProiect("Test", calendarStart.getTime(),  calendarEnd.getTime(), 1500.0);
		assertNotNull("Nu exista proiect nou!", proiect);
		//
		Responsabil responsabil = new Responsabil();
		calendarStart.setTime(new Date());
		calendarEnd.setTime(new Date()); 
		calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);
		Activitate activitate1 = promanInstance.creareActivitate(proiect,
				"Prima activitate test", 
				calendarStart.getTime(), calendarEnd.getTime());
		//
		promanInstance.stabilireResponsabilActivitate(activitate1, responsabil);
		//
		promanInstance.stabilireLinieBugetara(activitate1, 500.0);		
		//
		calendarStart.add(Calendar.WEEK_OF_MONTH, 2);
		calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);
		Activitate activitate2 = promanInstance.creareActivitate(proiect, responsabil, 
				"A doua activitate test", 
				calendarStart.getTime(), calendarEnd.getTime(), 500.0);
		
		
		promanInstance.salvareProiect(proiect);
		
		logger.debug("1.7 Afisare stare proiect nou");
		logger.debug("Status proiect: " + proiect.getStatus());
		//--------
		logger.info("End Test TestProjectManagementSrv!");
	}
}

/*
1.1 Initiere/Creare proiect nou
1.2 Stabilire buget proiect
1.3 Adaugare activitati in proiect
1.4 Stabilire responsabil activitate
1.5 Stabilire linie bugetara
1.6 Confirmare/Salvare proiect initiat
1.7 Afisare stare proiect nou
*/
