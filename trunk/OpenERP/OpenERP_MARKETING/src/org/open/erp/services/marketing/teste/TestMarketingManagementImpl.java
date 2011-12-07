package org.open.erp.services.marketing.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.marketing.Campanie;
import org.open.erp.services.marketing.Chestionar;
import org.open.erp.services.marketing.Discount;
import org.open.erp.services.marketing.Intrebare;
import org.open.erp.services.marketing.MarketingManagementSrv;
import org.open.erp.services.marketing.PersoanaTinta;
import org.open.erp.services.marketing.Promotie;
import org.open.erp.services.marketing.Responsabil;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nomgen.Produs;


public class TestMarketingManagementImpl {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestMarketingManagementImpl.class.getName());
	MarketingManagementSrv marketingInstance;
	NomenclatoareSrv nomenclatorInstance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		marketingInstance= MarketingManagementDummyFactory.getMarketingManagementSrv();
		nomenclatorInstance = MarketingManagementDummyFactory.getNomenclatoareSrv();
		logger.info("initTest");	
	}

	@Test
	public final void testMarketingManagementImpl() {
	} 

	@Test
	public final void testDefinireCampanie() {
			logger.info("Begin test: definireCampanie");
		 Campanie  campanieNoua;
		 Responsabil responsabil= new Responsabil(1000, "Responsabil", "Prima campanie"); //= (Responsabil)nomenclatorInstance.creazaPersona(1000, "Responsabil", "Prima campanie");
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
		 campanieNoua = marketingInstance.definireCampanie("Campania de inceput", dataStart, dataFinal, responsabil, listaPersoaneTinta);
		 logger.info("End test: definireCampanie");
	}

	@Test
	public final void testInitiereCampanie() { 
		logger.info("Begin test: definireCampanie");
		 Campanie  campanieNoua;
		 Responsabil responsabil= new Responsabil(1000, "Responsabil", "Prima campanie"); //= (Responsabil)nomenclatorInstance.creazaPersona(1000, "Responsabil", "Prima campanie");
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
		 campanieNoua = marketingInstance.definireCampanie("Campania de inceput", dataStart, dataFinal, responsabil, listaPersoaneTinta);
		 logger.info("End test: definireCampanie");
		 logger.info("Start initiere Campanie");
		 marketingInstance.initiereCampanie(campanieNoua);
		 logger.info("Mail-urile au fost trimise catre persoanele tinta");
		 logger.info("End initiere campanie");
	}

	@Test
	public final void testFinalizareCampanie() {
		logger.info("Begin test: definireCampanie");
		 Campanie  campanieNoua;
		 Responsabil responsabil= new Responsabil(1000, "Responsabil", "Prima campanie"); //= (Responsabil)nomenclatorInstance.creazaPersona(1000, "Responsabil", "Prima campanie");
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
		 campanieNoua = marketingInstance.definireCampanie("Campania de inceput", dataStart, dataFinal, responsabil, listaPersoaneTinta);
		 logger.info("End test: definireCampanie");
		 logger.info("Start initiere Campanie");
		 marketingInstance.initiereCampanie(campanieNoua);
		 logger.info("Mail-urile au fost trimise catre persoanele tinta");
		 logger.info("End initiere campanie");
		 logger.info("Start finalizareCampanie");
		 marketingInstance.finalizareCampanie(campanieNoua);
		 logger.info("Campania s-a incheiat");
		 logger.info("End finalizareCampanie");
	}

	@Test
	public final void testDerulareChestionar() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testInitiereChestionar() {
		Chestionar			chestionarNou;
		Intrebare			intrebare;
		List<Intrebare>		listaIntrebari = new ArrayList<Intrebare>();
		Responsabil			responsabil;
		
		intrebare = new Intrebare();
		intrebare.setIdIntrebare(1);
		intrebare.setTipIntrebare("Un singur raspuns posibil");
		intrebare.setTextIntrebare("V-ar interesa noul nostru produs?");
		intrebare.adaugaRaspuns(1, "Da");
		intrebare.adaugaRaspuns(2, "Nu");
		listaIntrebari.add(intrebare);
		
		intrebare = null;
		intrebare = new Intrebare();
		intrebare.setIdIntrebare(2);
		intrebare.setTextIntrebare("Cat ati fi dispus sa cheltuiti pentru produsul noul nostru produs");
		intrebare.setTipIntrebare("Un singur raspuns posibil");
		intrebare.adaugaRaspuns(1, "Sub 400 ron");
		intrebare.adaugaRaspuns(2, "Intre 400 - 500 ron");
		intrebare.adaugaRaspuns(3, "Peste 500 ron");
		listaIntrebari.add(intrebare);
		
		responsabil = new Responsabil();
		chestionarNou = marketingInstance.initiereChestionar("Primul chestionar", responsabil, listaIntrebari.size(), "Parere despre un nou produs", listaIntrebari);
		
	}

	@Test
	public final void testProceseazaRezultate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testDefinirePromotie() {
		Promotie					promotie;
		Produs						produs;
		Discount					discount;
		Map<Produs,Discount> 		listaDiscount = new HashMap<Produs,Discount>();
		Calendar					calendar = Calendar.getInstance();
		Date						dataStart, dataFinal;
		Random						generator = new Random();
		Float						pret;
		int							j= 0;
		logger.info("Start: definire Promotie");
		calendar.set(2011,11,15);
		dataStart = calendar.getTime();
		calendar.set(2012, 02, 15);
		dataFinal = calendar.getTime();
		while (j<=5)
		{
			j++;
			produs = null;
			discount = null;
			produs = new Produs();
			produs.setDenumire("Produs" + j);
			produs.setId(1000+j);
			produs.setPretVanzare(generator.nextDouble()*100);
			discount = new Discount(1000+j,"Discount" + j,1,generator.nextFloat()*20);
			listaDiscount.put(produs, discount);
		}
		promotie = marketingInstance.definirePromotie("Prima Promotie", "Cumpara acum sau niciodata", dataStart, dataFinal, Promotie.DISCOUNT, listaDiscount, null);
		logger.info("End: definire Promotie");
	}

	@Test
	public final void testGetPretFinalByPromotie() {
		Promotie					promotie;
		Produs						produs;
		Discount					discount;
		Map<Produs,Discount> 		listaDiscount = new HashMap<Produs,Discount>();
		Calendar					calendar = Calendar.getInstance();
		Date						dataStart, dataFinal;
		Random						generator = new Random();
		Float						pret;
		int							j= 0;
		Iterator<Produs>					iterator;
		logger.info("Start: definire Promotie");
		calendar.set(2011,11,15);
		dataStart = calendar.getTime();
		calendar.set(2012, 02, 15);
		dataFinal = calendar.getTime();
		while (j<=5)
		{
			j++;
			produs = null;
			discount = null;
			produs = new Produs();
			produs.setDenumire("Produs" + j);
			produs.setId(1000+j);
			produs.setPretVanzare(generator.nextDouble()*100);
			discount = new Discount(1000+j,"Discount" + j,1,generator.nextFloat()*20);
			listaDiscount.put(produs, discount);
		}
		promotie = marketingInstance.definirePromotie("Prima Promotie", "Cumpara acum sau niciodata", dataStart, dataFinal, Promotie.DISCOUNT, listaDiscount, null);
		logger.info("End: definire Promotie");
		listaDiscount = null;
		listaDiscount = promotie.getListaProduse();
		iterator = listaDiscount.keySet().iterator();
		float pretInitial = generator.nextFloat()*100;
		logger.info("Preturile produselor dupa aplicarea discount-urilor");
		logger.info("Produs         Pret Initial        PretFinal");

		while(iterator.hasNext())
		{
			produs = (Produs)iterator.next();
			discount = promotie.getListaProduse().get(produs);
			logger.info(produs.getDenumire() + "  " + pretInitial + "   " + marketingInstance.getPretFinalByPromotie(produs, promotie, pretInitial));
		}
	}

}
