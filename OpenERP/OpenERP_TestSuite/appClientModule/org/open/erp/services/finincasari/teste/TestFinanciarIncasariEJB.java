package org.open.erp.services.finincasari.teste;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.finincasari.BiletOrdine;
import org.open.erp.services.finincasari.CEC;
import org.open.erp.services.finincasari.Chitanta;
import org.open.erp.services.finincasari.ExtrasDeCont;
import org.open.erp.services.finincasari.FinanciarIncasariSrv;
import org.open.erp.services.finincasari.OrdinDePlata;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Facturi;





/**
 * @author Isabela
 *
 */
public class TestFinanciarIncasariEJB {
	/* Resurse test */
	
	private static Logger logger = Logger.getLogger(TestFinanciarIncasariEJB.class.getName());
	
	/*  Unitatea de test sursa/gazda unitatii de test*/
	private static FinanciarIncasariSrv incasareInstance;
	
	 Facturi Facturi1;
	 Facturi Facturi2;
	 ArrayList<Facturi> Facturi = new ArrayList<Facturi>();
	
	
	/* Set up */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		incasareInstance = FinanciarIncasariSrvFactory.getIncasariSrv();
		logger.info("initTest" + incasareInstance);
	}
	
	/*public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestFinanciarIncasariEJB.class.getName());	
	}
	
	@Before 
	public void initServices(){	
		incasareInstance= FinanciarIncasariSrvFactory.getIncasariSrv();
		logger.debug("FinanciarIncasariSrv Service intiated for Test!");
		
	} */
	

	/* Test creare proiect: 
	 * - invocare EJB, 
	 * - procesare EJB compus, 
	 * - procesare tranzactie compusa, 
	 * - procesare persistenta cu 2JPA-PU,
	 * - definire BO local cu asociaţie către BO din alt modul.
	 * */
	@SuppressWarnings({ "unused" })
	@Test
	public void testCreareFinanciarIncasari() throws Exception {
		 
		logger.setLevel(Level.DEBUG);
		logger.info("Begin test TestFinanciarIncasariSrv!");
		
		 SimpleDateFormat dataFormat = new SimpleDateFormat("dd-mm-yyyy");
	    	
    	 Date dataFact = new Date(System.currentTimeMillis());
    	 
    
    	// Facturi Facturi1 = null;
    	Facturi1 = new Facturi();
    	//Facturi1.getIdFactura();
    	//Facturi1.setSumaIncasare(23.00);
    	// Facturi1.setValoareFact(123.00);
    	//Facturi1.setDataFact(dataFormat.parse("12-05-2012"));

    	 //Facturi Facturi2 = null;
    	Facturi2 = new Facturi();
    	//Facturi2.setIdFactura(12);
    	// Facturi2.setSumaIncasare(50.00);
    	// Facturi2.setValoareFact(200.00);
    	// Facturi2.setDataFact(dataFormat.parse("10-09-2012"));
    	
    	
    	
		
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testIncasareBiletOrdine() throws Exception{
    	 SimpleDateFormat dataFormat = new SimpleDateFormat("dd-mm-yyyy");
    	 Date dataEmiterii = new Date(System.currentTimeMillis());
     	
    	 Date dataScadenta = new Date(System.currentTimeMillis());
    	 
    	 dataEmiterii = dataFormat.parse("12-05-2012");
    	 dataScadenta = dataFormat.parse("30-08-2012");
    	 
    	 Angajat angajat = new Angajat();
    	// angajat.setIDangajat(1);
    	// angajat.setNumeAngajat("Ion");
    	 
    	 Persoana persoana = new Persoana();
    	// persoana.setNume("Marian");
    	 
    	 Facturi = new ArrayList<Facturi>();
    	 Facturi1 = new Facturi();
    	 Facturi2 = new Facturi();
    	 
    	 
       	BiletOrdine BO =  incasareInstance.incasareBO("bc", dataEmiterii,
    			Double.valueOf(23.00), "RON", "douazeci si trei",Facturi,angajat,persoana);
      
       
       	logger.info("1.Incasare prin Bilet Ordine");
    
    
	}

    
	
	@SuppressWarnings("unused")
	@Test
	public void testIncasareCEC() throws Exception{
    	 
    	 SimpleDateFormat dataFormat = new SimpleDateFormat("dd-mm-yyyy");
     	
    	 Date dataEmiterii = new Date(System.currentTimeMillis());
    	
    	 Date dataScadenta = new Date(System.currentTimeMillis());
    	 
    	 dataEmiterii = dataFormat.parse("05-04-2012");
    	 dataScadenta = dataFormat.parse("30-08-2012");

    	 Angajat angajat = new Angajat();
    	// angajat.setIDangajat(1);
    	// angajat.setNumeAngajat("Ion");
    	 
    	 Persoana persoana = new Persoana();
    	// persoana.setNume("Marian");
    	 
    	 Facturi = new ArrayList<Facturi>();
    	 Facturi1 = new Facturi();
    	 Facturi2 = new Facturi();
    	 
    	 
    	 CEC Cec = incasareInstance.incasareCec("is", dataEmiterii,23.00 , "RON", "douazeci si trei", null);
    	
    	 logger.info("2.Incasare utilizand CEC");
     }
	
	
	@SuppressWarnings("unused")
	@Test
	public void testIncasareOrdinDePlata() throws Exception{
   	 
   	 SimpleDateFormat dataFormat = new SimpleDateFormat("dd-mm-yyyy");
    	
   	 Date dataEmiterii = new Date(System.currentTimeMillis());
   	
   	 Date dataScadenta = new Date(System.currentTimeMillis());
   	 
   	 dataEmiterii = dataFormat.parse("05-04-2012");
   	 dataScadenta = dataFormat.parse("30-08-2012");

   	Angajat angajat = new Angajat();
   	// angajat.setIDangajat(1);
   	// angajat.setNumeAngajat("Ion");
   	 
   	 Persoana persoana = new Persoana();
   	// persoana.setNume("Marian");
   	 
   	 Facturi = new ArrayList<Facturi>();
   	 Facturi1 = new Facturi();
	 Facturi2 = new Facturi();
	 
   	 
   	 OrdinDePlata OP = incasareInstance.incasareOP("bucuresti", dataEmiterii, 50.00, "RON", 
   			 "cincizeci",  1205, "xc108", Facturi);
   	
   	 logger.info("3.Incasare prin Ordin de Plata");
    }
	
	
	@Test
	public void testSumaRON() throws Exception {
		Double suma = incasareInstance.getSuma("EURO", 18.00, 4.23);
		logger.info("Suma RON este:");
		logger.debug(suma);
		
	}
	
	
	
	
	@SuppressWarnings("unused")
	@Test
	public void testinregistrareChitanta() throws Exception {
		 
		SimpleDateFormat dataFormat = new SimpleDateFormat("dd-mm-yyyy");
	    	
	   	 Date dataEmiterii = new Date(System.currentTimeMillis());
	   	 dataEmiterii = dataFormat.parse("05-04-2012");
	   
	   	 Angajat angajat = new Angajat();
	   	 //angajat.setIDangajat(1);
	   	// angajat.setNumeAngajat("Ion");
	   	 
	   	 Persoana persoana = new Persoana();
	   	// persoana.setNume("Marian");
	   	 
	   	 Facturi = new ArrayList<Facturi>();
	   	 Facturi1 = new Facturi();
    	 Facturi2 = new Facturi();
    	 
	   	 
	   	 Chitanta CT = incasareInstance.inregistrareCt("bacau", dataEmiterii, 50.00, "RON", "cincizeci",  Facturi, angajat);
	   	 
	 	 logger.info("4.Emiterea chitantei pentru suma incasata");
	  
	}
	
	@Test
	@SuppressWarnings("unused")
	public void testIncasareExtrasCont() throws Exception{
   	 
   	 SimpleDateFormat dataFormat = new SimpleDateFormat("dd-mm-yyyy");
    	
   	 Date dataEmiterii = new Date(System.currentTimeMillis());
   
   	 dataEmiterii = dataFormat.parse("05-04-2012");
   	
   	 Angajat angajat = new Angajat();
   	// angajat.setIDangajat(1);
   	// angajat.setNumeAngajat("Ion");
   	 
   	 Persoana persoana = new Persoana();
   	// persoana.setNume("Marian");
   	 
   	 Facturi = new ArrayList<Facturi>();
   	 Facturi1 = new Facturi();
	 Facturi2 = new Facturi();
	 
   	 
   	ExtrasDeCont ec = incasareInstance.incasareEC("cluj", dataEmiterii, 23.00, "RON", "douazeci si trei", Facturi);
   	 logger.info("5. Extras de cont");
   	 
   	 logger.debug("End Test TestFinanciarIncasariSrv!");
    }

		
	}
	



	
