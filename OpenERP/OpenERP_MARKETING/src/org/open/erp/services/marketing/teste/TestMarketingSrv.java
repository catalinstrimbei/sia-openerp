package org.open.erp.services.marketing.teste;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
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
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;

public class TestMarketingSrv {

	private static Logger logger;
	MarketingSrv marketingInstance;

	NomenclatorMaterialeSrv nommatSrv;
//	PersonalSrv personalSrv;
	NomenclatoareSrv nomgenSrv;

	@BeforeClass
	public static void initLocalJavaLogger() {
		logger = Logger.getLogger(TestMarketingSrv.class.getName());
	}

	@Before
	public void initServices() {
		marketingInstance = MarketingSrvFactory.getMarketingSrv();
		nommatSrv = MarketingSrvFactory.getProjectNommatSrv();
//		personalSrv = MarketingSrvFactory.getProjectPersonalSrv();
		nomgenSrv = MarketingSrvFactory.getProjectNomgenSrv();

		logger.info("Marketing Service intiated for Test!");
	}

	@Test
	public void testCrearePromotie() throws Exception {
		logger.setLevel(Level.DEBUG);
		logger.info("Begin test TestMarketingSrv!");
		////////////////////////

		Promotie promotieNoua = new Promotie();
		marketingInstance.crearePromotie(promotieNoua);
		assertNotNull("Nu exista promotie!", promotieNoua);

		// //////////////////////
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
		
		RaspunsIntrebare raspunsIntrebareNou = new RaspunsIntrebare();
		marketingInstance.creareRaspunsIntrebare(raspunsIntrebareNou);
		// //////////////////////
		Intrebare intrebareNoua = new Intrebare();
		marketingInstance.creareIntrebare(intrebareNoua);
		// //////////////////////
		Persoana persoanaChestionata = nomgenSrv.crearePF(null, null, null, null, null, null, null, null, null);
		
		Chestionar chestionarNou = new Chestionar();
		marketingInstance.creareChestionar(chestionarNou);
		
		logger.info("End test testChestionar");
	}

}
