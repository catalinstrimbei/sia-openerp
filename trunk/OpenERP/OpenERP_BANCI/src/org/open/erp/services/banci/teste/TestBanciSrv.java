package org.open.erp.services.banci.teste;

import static org.junit.Assert.*;

import java.util.Date;

//import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.banci.*;
import org.open.erp.services.banci.impl.*;
import org.open.erp.services.nomgen.*;

public class TestBanciSrv {
	private static Logger logger;
	BanciSrv banciInstance;
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestBanciSrv.class.getName());	
	}
	
	@Before public void initServices(){	
		banciInstance = BanciSrvFactory.getBanciSrv();
		logger.info("ProjectManagementSrv Service intiated for Test!");
	}
	
	@Test
	public void testComapanieBanci() throws Exception{
		
		logger.info("Begin test TestProjectManagementSrv!");
		
		logger.info("----- START companii pentru test ------ ");
		
		Companie firma = banciInstance.CreareFirma(1, "Firma 1");
		Companie banca = banciInstance.CreareBanca(2, "Banca 1");
		
		logger.info("----- creare conturi ------ ");
		
		Cont contlei = banciInstance.CreareContLei(1, "Cont Lei");
		Cont contvaluta = banciInstance.CreareContValuta(2, "Cont Euro");

		logger.info("----- creare relatie companie banci ------ ");
		
		//testare CompanieBanci
		CompanieBanci compbanci = banciInstance.crearerelatieCompanieBanci(firma);
		compbanci.setNumeBanca(banca.getNume());
		compbanci.setCont(contlei);
		compbanci.setCont(contvaluta);
		
		//testare carduribnc
		logger.info("----- creare card banci ------ ");
		CarduriBNC card = banciInstance.creareCarduriBNC(firma, contlei, banca, new Date(), new Date(), (double)0);
		logger.info("----- creare plati ------ ");
		LiniiPlati plata1 = banciInstance.CreareLinieplati(new Date(), (double) 110, "depunere1"); 
		LiniiPlati plata2 = banciInstance.CreareLinieplati(new Date(), (double) 10, "retrager1"); 
		card.setliniealimentare(plata1);
		card.setlinieretragere(plata2);
		
		logger.info("----- creare raport retrageri card  sold final: " + banciInstance.soldcontcard(card)+ "------ ");
		
		//testare carduribnc
		logger.info("----- creare card banci ------ ");
		
		
		CrediteBNC credit = banciInstance.creareCrediteBNC(firma, contlei, banca, (double) 323, 365, new Date(), new Date(), new Date(), 
				(double) 30, (double) 10, plata1);
		LiniiPlati rata1 = banciInstance.CreareLinieplati(new Date(), (double) 10, "rata1");
		banciInstance.actualizareCredit(credit);
		logger.info("----- creare raport suma de plata ramasa la credit: " + credit.getsumaramasadeplata() + " ------ ");
		
		credit.setplatiintermediare(rata1);
		logger.info("End Test TestBanciSrv!");
		
	}
	
}