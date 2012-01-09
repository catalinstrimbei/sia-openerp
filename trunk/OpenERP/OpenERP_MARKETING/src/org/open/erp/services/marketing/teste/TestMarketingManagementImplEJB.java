package org.open.erp.services.marketing.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import static org.junit.Assert.assertNotNull;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.marketing.Campanie;
import org.open.erp.services.marketing.MarketingManagementSrv;
import org.open.erp.services.marketing.MarketingManagementSrvRemote;
import org.open.erp.services.marketing.PersoanaTinta;
import org.open.erp.services.marketing.impl.MarketingManagementImpl;

public class TestMarketingManagementImplEJB {
		/* Resurse test*/
		private static Logger logger = Logger.getLogger(TestMarketingManagementImplEJB.class.getName());
		
		/* Unitatea de test sursa/gazda unitatii de test */
		private static MarketingManagementSrvRemote marketingInstance;
		
		/* Set up */
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			InitialContext ctx = initJBossJNDICtx();
			marketingInstance = (MarketingManagementSrvRemote)ctx.lookup("MarketingManagementSrvRemote/remote");
			logger.info("initTest " + marketingInstance);
		}

		/* Test creare proiect: 
		 * - invocare EJB, 
		 * - procesare EJB compus, 
		 * - procesare tranzactie compusa, 
		 * - procesare persistenta cu 2JPA-PU,
		 * - definire BO local cu asociaţie către BO din alt modul.
		 * */
		@Test
		public void testdefinireCampanie() throws Exception{
			
			logger.info("Begin test: definireCampanie");
			Campanie   campanie;
			 PersoanaTinta  persoanaTinta;
			 List<PersoanaTinta>  listaPersoaneTinta = new ArrayList<PersoanaTinta>();
			 Calendar		calendar = Calendar.getInstance();
			 Date			dataStart, dataFinal;
			 calendar.set(2011,11,15);
			 dataStart = calendar.getTime();
			 calendar.set(2012, 02, 15);
			 dataFinal = calendar.getTime();
			 for (int i = 0 ; i<6;i++)
			 {
				 persoanaTinta =new PersoanaTinta(1000+i, "Nume" + i, "Prenume" + i); //(PersoanaTinta) nomenclatorInstance.creazaPersona(1000+i, "Nume" + i, "Prenume" + i);
				 listaPersoaneTinta.add(persoanaTinta);
			 }
			 campanie = marketingInstance.definireCampanie("Campania de inceput", dataStart, dataFinal, listaPersoaneTinta);
			
			logger.info("Campania cu id: " + campanie.getIdCampanie() + " a fost definita!");
			
			assertNotNull("Campania ne-validata!", campanie.getIdCampanie());
			
			campanie = marketingInstance.getCampanie(campanie.getIdCampanie());
			
			assertNotNull("Nu exista campanie noua!", campanie);
			logger.info("End test: definireCamppanie");
		}
		
		/* Test creare proiect: 
		 * - procesare persistenta cu 2JPA-PU
		 * - definire BO local extinzând (moştenind) definiţia BO local din alt modul;
		 * */	
		/*@Test
		public void testCreareActivitate() throws Exception  {
			logger.info("Begin test: creareActivitate");
			Proiect proiect = promanInstance.creareProiect("Test", null, null, null, 1000.0);
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
		*/
		/*--- Utils: InitialContext Client EJB-JDNI ----------------------------------------------------*/
		private static InitialContext initJBossJNDICtx() throws NamingException{
			Properties props = new Properties();
	        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
	        props.put("java.naming.provider.url", "jnp://localhost:1099/");
	        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
	        return new InitialContext(props);
		}		

}
