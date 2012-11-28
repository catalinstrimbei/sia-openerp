package org.open.erp.services.finincasari.teste;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
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
import org.open.erp.services.vanzari.Factura;




/**
 * @author Isabela
 *
 */
public class TestFinanciarIncasariSrv {
	
	private static Logger logger;
	FinanciarIncasariSrv incasareInstance;
	
	 Factura factura1;
	 Factura factura2;
	 ArrayList<Factura> factura = new ArrayList<Factura>();
	
	
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestFinanciarIncasariSrv.class.getName());	
	}
	
	@Before 
	public void initServices(){	
		incasareInstance= FinanciarIncasariSrvFactory.getIncasariSrv();
		logger.debug("FinanciarIncasariSrv Service intiated for Test!");
		
	}
		
	@SuppressWarnings("unused")
	@Test
	public void testCreareFinanciarIncasari() throws Exception {
		 
		logger.setLevel(Level.DEBUG);
		logger.info("Begin test TestFinanciarIncasariSrv!");
		
		 SimpleDateFormat dataFormat = new SimpleDateFormat("dd-mm-yyyy");
	    	
    	 Date dataFact = new Date(System.currentTimeMillis());
    	 
    
    	 Factura factura1;
    	 factura1 = new Factura();
    	 factura1.setIDFact(11);
    	 factura1.setSumaIncasare(23.00);
    	 factura1.setValoareFact(123.00);
    	 factura1.setDataFact(dataFormat.parse("12-05-2012"));

    	 Factura factura2;
    	 factura2 = new Factura();
    	 factura2.setIDFact(12);
    	 factura2.setSumaIncasare(50.00);
    	 factura2.setValoareFact(200.00);
    	 factura2.setDataFact(dataFormat.parse("10-09-2012"));
    	
    	
    	
		
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
    	 angajat.setIDangajat(1);
    	 angajat.setNumeAngajat("Ion");
    	 
    	 Persoana persoana = new Persoana();
    	 persoana.setNumePers("Marian");
    	 
    	 factura = new ArrayList<Factura>();
    	 factura.add(factura1);
		 factura.add(factura2);
    	 
       	BiletOrdine BO =  incasareInstance.incasareBO("bc", dataEmiterii,
    			Double.valueOf(23.00), "RON", "douazeci si trei", "RO125468SC785",factura,angajat,persoana);
      
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
    	 angajat.setIDangajat(1);
    	 angajat.setNumeAngajat("Ion");
    	 
    	 Persoana persoana = new Persoana();
    	 persoana.setNumePers("Marian");
    	 
    	 factura = new ArrayList<Factura>();
    	 factura.add(factura1);
    	 factura.add(factura2);
    	 
    	 
    	 CEC Cec = incasareInstance.incasareCec("is", dataEmiterii,23.00 , "RON", "douazeci si trei", "RO125468SC78545",null);
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
   	 angajat.setIDangajat(1);
   	 angajat.setNumeAngajat("Ion");
   	 
   	 Persoana persoana = new Persoana();
   	 persoana.setNumePers("Marian");
   	 
   	 factura = new ArrayList<Factura>();
   	 factura.add(factura1);
   	 factura.add(factura2);
   	 
   	 
   	 OrdinDePlata OP = incasareInstance.incasareOP("bucuresti", dataEmiterii, 50.00, "RON", 
   			 "cincizeci", "RO12548BUC89", 1205, "xc108", factura);
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
	   	 angajat.setIDangajat(1);
	   	 angajat.setNumeAngajat("Ion");
	   	 
	   	 Persoana persoana = new Persoana();
	   	 persoana.setNumePers("Marian");
	   	 
	   	 factura = new ArrayList<Factura>();
	   	 factura.add(factura1);
	   	 factura.add(factura2);
	   	 
	   	 Chitanta CT = incasareInstance.inregistrareCt("bacau", dataEmiterii, 50.00, "RON", "cincizeci", "RO458721bc568", factura, angajat);
	   	 
	 	 logger.info("6.Emiterea chitantei pentru suma incasata");
	  
	}
	
	@Test
	@SuppressWarnings("unused")
	public void testIncasareExtrasCont() throws Exception{
   	 
   	 SimpleDateFormat dataFormat = new SimpleDateFormat("dd-mm-yyyy");
    	
   	 Date dataEmiterii = new Date(System.currentTimeMillis());
   
   	 dataEmiterii = dataFormat.parse("05-04-2012");
   	
   	 Angajat angajat = new Angajat();
   	 angajat.setIDangajat(1);
   	 angajat.setNumeAngajat("Ion");
   	 
   	 Persoana persoana = new Persoana();
   	 persoana.setNumePers("Marian");
   	 
   	 factura = new ArrayList<Factura>();
   	 factura.add(factura1);
   	 factura.add(factura2);
   	 
   	 
   	ExtrasDeCont ec = incasareInstance.incasareEC("cluj", dataEmiterii, 23.00, "RON", "douazeci si trei", "Ro5879453cl45", factura);
   	 logger.info("5. Extras de cont");
   	 
   	 logger.info("End Test TestFinanciarIncasariSrv!");
    }
	 	
		
	}
	



	
