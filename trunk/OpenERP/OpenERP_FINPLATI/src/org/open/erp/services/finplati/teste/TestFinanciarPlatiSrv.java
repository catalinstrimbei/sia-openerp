

/*
* @UseCase("1. Monitorizare datorii"):
 * 
 * @UseCase("2. Plati in avans"):
 * 
 * @UseCase("3. Efectuare plati pt furnizori"):
 *
 * @UseCase("4. Efectuare plati pt diverse datorii"):
 * 
 * @UseCase("5. Urmarire plati si datorii ramase"):
*/

package org.open.erp.services.finplati.teste;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.finplati.ChitantaPlata;
import org.open.erp.services.finplati.Contract;
import org.open.erp.services.finplati.Factura;
import org.open.erp.services.finplati.FinanciarPlatiSrv;
import org.open.erp.services.finplati.Furnizor;
import org.open.erp.services.finplati.ModPlata;
import org.open.erp.services.finplati.Persoana;
import org.open.erp.services.finplati.Plata;
import org.open.erp.services.finplati.Responsabil;
import org.open.erp.services.finplati.SituatieFinanciara;
import org.open.erp.services.finplati.TipPlata;

public class TestFinanciarPlatiSrv {
	private static Logger logger;
	FinanciarPlatiSrv finplatiInstance;

	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestFinanciarPlatiSrv.class.getName());	
	}
	
	@Before public void initServices(){	
		 finplatiInstance= FinanciarPlatiSrvFactory.getFinanciarPlatiSrv();
		logger.info("FinanciarPlatiSrv Service este pregatit pt test!");
		
	}
	
	
	@Test
	public void testCrearefinanciarplatiSrv() throws Exception{
	logger.setLevel(Level.DEBUG);
		
		logger.info("Incepe testul pentru FinanciarPlatiSrv!");
		
		// Adaugam dummy data pentru testarea modulului		
		SituatieFinanciara sitFit = finplatiInstance.getSituatieFinanciara();
		Persoana ionescu = new Persoana();
		ionescu.setIdPersoana(1);
		ionescu.setNume("Ionescu");
		ionescu.setPrenume("Ion");
		ionescu.setScorAptitudini(500);
		sitFit.adaugarePersonal(ionescu);
		
		Persoana popescu = new Persoana();
		popescu.setIdPersoana(2);
		popescu.setNume("Popescu");
		popescu.setPrenume("Ion");
		popescu.setScorAptitudini(50);
		sitFit.adaugarePersonal(popescu);
		
		
		Factura factura1 = new Factura();
		Date dataFact = new Date();
		dataFact.setDate(25);
		dataFact.setMonth(10);
		dataFact.setYear(2012);
		factura1.setDataFactura(dataFact);
		factura1.setValoareTotal(1000.0);
		sitFit.adaugareFactura(factura1);
		 
		Plata plata1 = new Plata();
		Date dataPlata = new Date();
		plata1.setDataPlatii(dataPlata);
		plata1.setId(5);
		plata1.setValoarePlata(120.0);
		plata1.setTipPlata(TipPlata.DATORIE);
		plata1.setModPlata(ModPlata.CEC);
		plata1.setConfirmarePlata(null);
		
		Plata plata2 = new Plata();
		plata2.setDataPlatii(new Date());
		plata2.setValoarePlata(250.0);
		plata2.setTipPlata(TipPlata.ALTTIP);
		plata2.setModPlata(ModPlata.CASH);
		 
		sitFit.adaugarePlata(plata1);
		sitFit.adaugarePlata(plata2);
		Furnizor furnizor1 = new Furnizor();
	    furnizor1.adaugarePlata(plata1);
		
		
		Double sitfit = finplatiInstance.getSumePlatite(new Date());
		assertNotNull("Nu exista sume platite noua!", sitfit);

		
		logger.info("1.2. Alocare buget pentru datorii");
		finplatiInstance.setBugetDatorii(20000.0);
		double buget = finplatiInstance.getBugetDatorii();
		assertNotNull("Bugetul setat nu exista", buget);
		assertTrue("Bugetul setat nu este corect", (buget==20000.0));
//1.3		
		Double soldfact = finplatiInstance.getSolduriFacturi();
	    assertNotNull("Nu exista sold nou!", soldfact);
	    assertTrue("Valoarea soldului nu e corecta!", soldfact == 1000.0);
//2	    
	    logger.info("2.1. Incheiere contract cu furnizoruli");
	    
	    Furnizor furnizor = new Furnizor();
		Plata avans = new Plata();
		avans.setDataPlatii(new Date());
		avans.setValoarePlata(350.0);
		
	    Contract testCtr = finplatiInstance.createContractFurnizor(furnizor, 1500.0, avans);
	    Contract testCtr2 = finplatiInstance.cautaContractFurnizor(testCtr.getIdContract());

	    assertNotNull("Nu exista contractul adaugat", testCtr);
	    assertTrue("Contractul adaugat si cel cautat nu sunt identice", (testCtr==testCtr2));
	    
	    logger.info("2.2. Inregistrare suma in avans");
	    Double avansdbl = testCtr2.getTotalPlati();
	    assertNotNull("Nu exista nici un avans inregistrat", avansdbl);
	    assertTrue("Valoarea avansului nu este corecta", avansdbl==350.0);
	    
	    logger.info("2.3. Discountul acordat");
	    testCtr.setDiscountContract(0.2);
	    Double dsc = testCtr.getDiscountContract();
	    assertNotNull("Nu exista nici un discount inregistrat", dsc);
	    assertTrue("Valoarea discountului nu este corecta", dsc==0.2);
	    
	    
	    logger.info("2.4  Afisare situatie");
	    finplatiInstance.afisareSituatie(testCtr2);
	    logger.debug(finplatiInstance.afisareSituatie(testCtr2));
	    
//3.	    
	    List<Persoana> listpers = finplatiInstance.afisareListaPersonal();
	    assertNotNull("Nu exista nici un avans inregistrat", listpers);
	    assertTrue("Prima persoana nu e Ionescu", listpers.get(0)==ionescu);
	    assertTrue("A doua persoana nu e Popescu", listpers.get(1)==popescu);
	    
	    logger.info("3.2. Stabilire responsabil plata");
	    finplatiInstance.stabilireResponsabilPlata();
	    Responsabil resp = finplatiInstance.getSituatieFinanciara().getResponsabil();
	    assertNotNull("Nu exista nici un responsabil inregistrat", resp);
	    assertTrue("Prima persoana nu e Ionescu", resp.getIdPersoana()==ionescu.getIdPersoana());
	    
	    logger.info("3.3. Clasificare plati ( furnizori / datorii )");
	   // finplatiInstance.clasificarePlati();
	 // Map<TipPlata, List<Plata>> clasif = finplatiInstance.clasificarePlati();
	// assertNotNull("Nu exista nici o clasificare", clasif);
	  // assertTrue("Prima plata nu e plata1", clasif.get(0)==plata1);
	 //  assertTrue("A doua plata nu e plata2", clasif.get(1)==plata2);
	    
	    logger.info("3.4. Procesare/onorare plata catre furnizori");
	    logger.debug("3.5. Verificare desfasurare plata");
	    Boolean verificare = finplatiInstance.verificarePlata(furnizor1, plata1);
	    assertNotNull("Nu exista nici o verificare", verificare);
	    assertTrue("Nu corespunde", verificare);
	    
	    logger.debug("4.1 Efectuare plata pt datorii");
	    logger.debug("4.2. Primire chitanta");
	    ChitantaPlata chit = finplatiInstance.primireChitanta(200.0);
	    assertNotNull("S-a facut primirea chitante", chit);
	    
	    logger.debug(finplatiInstance.afisareSituatiePlati());
	    Double sitplata = finplatiInstance.afisareSituatiePlati();
	    assertNotNull("Eroare in calculul situatia platilor", sitplata);
	    assertTrue("Situatia plata nu coincide cu evidenta", sitplata == 570.0);
	    //850
	    
	    
//5	    
	    logger.debug("5.1. Urmarire datorii ramase");
	    Double datorii = finplatiInstance.afisareDatorii();
	    assertNotNull("Eroare in calculul datoriilor", datorii);
	    assertTrue("Datoriile nu coincid cu evidenta", datorii == 1850.0);
	    
	    
	    logger.info("5.2. Urmarire situatie plati");
	    logger.debug(finplatiInstance.afisarePlatiTotale());
	    
	    Double platitotale = finplatiInstance.afisarePlatiTotale();
	    assertNotNull("Eroare in calculul platilor", platitotale);
	    assertTrue("Platile totale nu coincid cu evidenta", platitotale == 570.0);
	    
	    logger.info("5.3. Interogare sold");
	   // logger.debug(finplatiInstance.afisareSold());
	    Double soldafisare = finplatiInstance.afisareSold();
	    assertNotNull("Eroare in calculul platilor", soldafisare);
	    assertTrue("Platile totale nu coincid cu evidenta", soldafisare == 1850.0);
	    
	    	   
	    logger.info("THe END!");
	    
	}
}

	

