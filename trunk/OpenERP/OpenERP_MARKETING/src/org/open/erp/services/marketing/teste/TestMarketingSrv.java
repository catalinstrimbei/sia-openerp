package org.open.erp.services.marketing.teste;

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
import org.open.erp.services.nomgen.AngajatSrv;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nomgen.PersoanaSrv;
import org.open.erp.services.productie.Produs;
import org.open.erp.services.productie.ProdusSrv;

public class TestMarketingSrv {
	private static Logger logger;
	private MarketingSrv marketingInstance;
	
	private ProdusSrv produsSrv;
	private AngajatSrv angajatSrv;
	private PersoanaSrv persoanaSrv;

	@BeforeClass
	public static void initLocalJavaLogger() {
		logger = Logger.getLogger(TestMarketingSrv.class.getName());
	}

	@Before
	public void initServices() {
		marketingInstance = MarketingSrvFactory.getMarketingSrv();
		logger.info("Marketing Service intiated for Test!");
	}

	@Test
	public void testCreareProiect() throws Exception {
		logger.setLevel(Level.DEBUG);
		logger.info("Begin test TestMarketingSrv!");
////////////////////////
		Produs produsPromotie = produsSrv.creareProdus();
		int pretPromotional = 10;
		Date dataStart = new Date();
		Date dataFinal = new Date();
		Promotie promotieNoua = marketingInstance.crearePromotie(produsPromotie, pretPromotional, dataStart, dataFinal);
////////////////////////		
		TipPromovare tipPromovare = TipPromovare.FLYERE;
		Date data = new Date();	
		CanalDistributie canalDistributie = CanalDistributie.PRESA_SCRISA;
		int buget = 11;	
		CampaniePromovare campanieNoua = marketingInstance.creareCampaniePromovare(tipPromovare, data, canalDistributie, buget);
		campanieNoua.getPromotiiCampanie().add(promotieNoua);
////////////////////////
		RaspunsIntrebare raspunsIntrebareNou = marketingInstance.creareRaspunsIntrebare("raspuns corect");
////////////////////////		
		Intrebare intrebareNoua = marketingInstance.creareIntrebare("intrebare");
		intrebareNoua.getRaspunsuriIntrebare().add(raspunsIntrebareNou);
////////////////////////
		Persoana persoanaChestionata = persoanaSrv.crearePersoanaChestionata();
		Chestionar chestionarNou = marketingInstance.creareChestionar(data, "Chestionar1", persoanaChestionata);
		chestionarNou.getIntrebariChestionar().add(intrebareNoua);
////////////////////////
		CercetarePiata cercetarePiataNoua = marketingInstance.creareCercetarePiata(dataStart, dataFinal, buget);
////////////////////////
		StatusReclamatie status = StatusReclamatie.NOU;
		Reclamatie reclamatieNoua = marketingInstance.creareReclamatie(data, "reclamatie", "raspuns", status);
////////////////////////	
	}
	
}
