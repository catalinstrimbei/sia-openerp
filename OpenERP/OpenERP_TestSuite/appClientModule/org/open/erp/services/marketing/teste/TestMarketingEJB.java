package org.open.erp.services.marketing.teste;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.marketing.CampaniePromovare;
import org.open.erp.services.marketing.CanalDistributie;
import org.open.erp.services.marketing.CercetarePiata;
import org.open.erp.services.marketing.Chestionar;
import org.open.erp.services.marketing.Intrebare;
import org.open.erp.services.marketing.MarketingSrv;
import org.open.erp.services.marketing.Promotie;
import org.open.erp.services.marketing.RaspunsIntrebare;
import org.open.erp.services.marketing.Reclamatie;
import org.open.erp.services.marketing.StatusReclamatie;
import org.open.erp.services.marketing.TipPromovare;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;

public class TestMarketingEJB {

	private static Logger logger;
	private static MarketingSrv marketingInstance;
	NomenclatoareSrv nomgenSrv;

	@BeforeClass
	public static void initLocalJavaLogger() {
		logger = Logger.getLogger(TestMarketingSrv.class.getName());
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		marketingInstance = 
			MarketingSrvFactory.getMarketingSrv();
		//logger.info("initTest " + marketingInstance);
	}

	@Test
	public void testCrearePromotie() throws Exception {
		logger.setLevel(Level.DEBUG);
		logger.info("Begin test TestMarketingSrv!");
		////////////////////////

		Date dataStart = new Date();
		Date dataFinal = new Date();
		// Promotie promotieNoua = new Promotie(1, produs1, pretPromotional,
		// dataStart, dataFinal);
		Promotie promotieNoua = new Promotie();
		marketingInstance.crearePromotie(promotieNoua);
		assertNotNull("Nu exista promotie!", promotieNoua);

		// //////////////////////
		TipPromovare tipPromovare = TipPromovare.FLYERE;
		Date data = new Date();
		CanalDistributie canalDistributie = CanalDistributie.PRESA_SCRISA;
		int buget = 11;
		CampaniePromovare campanieNoua = new CampaniePromovare();
		marketingInstance.creareCampaniePromovare(campanieNoua);
		campanieNoua.getPromotiiCampanie().add(promotieNoua);
		
		// //////////////////////
		CercetarePiata cercetarePiataNoua = new CercetarePiata();
		marketingInstance.creareCercetarePiata(cercetarePiataNoua);
		// //////////////////////
		StatusReclamatie status = StatusReclamatie.NOU;
		Reclamatie reclamatieNoua = new Reclamatie();
		marketingInstance.creareReclamatie(reclamatieNoua);
		// //////////////////////
		System.out.println("aaaaa");
		logger.info("End test TestMarketingSrv");
	}
	
	@Test
	public void testChestionar() throws Exception {
		logger.setLevel(Level.DEBUG);
		logger.info("Begin test testChestionar!");
		
		RaspunsIntrebare raspunsIntrebareNou = new RaspunsIntrebare(1, "text");
		marketingInstance.creareRaspunsIntrebare(raspunsIntrebareNou);
		// //////////////////////
		Intrebare intrebareNoua = new Intrebare();
		marketingInstance.creareIntrebare(intrebareNoua);
		/////////////////////////
		
		Chestionar chestionarNou = new Chestionar();
		marketingInstance.creareChestionar(chestionarNou);
		
		logger.info("End test testChestionar");
	}

}
