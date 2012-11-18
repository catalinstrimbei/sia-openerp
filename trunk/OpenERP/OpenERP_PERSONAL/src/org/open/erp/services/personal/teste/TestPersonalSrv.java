package org.open.erp.services.personal.teste;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.personal.Anunt;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.Post;

public class TestPersonalSrv {
	private static Logger logger;
	PersonalSrv instantaPersonal;
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		//logger =  Logger.getLogger(TestPersonalSrv.class.getName());	
	}
	
	@Before public void initServices(){	
		instantaPersonal = PersonalSrvFactory.getPersonalSrv();
		//logger.info("Serviciul PersonalSrv a fost instantiat pentru testare!");
	}
	
	@Test
	public void testCreareProiect() throws Exception{
		//logger.setLevel(Level.DEBUG);
		
		//logger.info("Inceput testare TestPersonalSrv!");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE,15);
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.YEAR, 2012);
		
		Date dataEmitere = cal.getTime();
		cal.add(Calendar.DATE, 10);
		Date dataExpirare = cal.getTime();
		
		Post postLiber = instantaPersonal.crearePost("Medii", 2000);
		Anunt anuntNou = instantaPersonal.creareAnunt("Responsabil resurse umane", 122025, dataEmitere, dataExpirare, "Organizat, bune abilitati de comunicare", postLiber);
		assertNotNull("Nu exista un anunt nou!", anuntNou);
		
		
		
	}
}
