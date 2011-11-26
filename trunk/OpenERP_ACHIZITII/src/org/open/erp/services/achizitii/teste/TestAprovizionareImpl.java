package org.open.erp.services.achizitii.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.achizitii.AprovizionareSrv;
import org.open.erp.services.achizitii.Comanda;
import org.open.erp.services.achizitii.Factura;
import org.open.erp.services.achizitii.Furnizor;
import org.open.erp.services.achizitii.LinieComanda;
import org.open.erp.services.achizitii.PlanAprovizionare;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.finplati.FinplatiSrv;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.stocuri.ArticolStoc;
import org.open.erp.services.stocuri.CerereAprovizionare;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.StocuriSrv;


public class TestAprovizionareImpl {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestAprovizionareImpl.class.getName());
	StocuriSrv stocuriInstance;
	AprovizionareSrv aprovizionareInstance;
	NomenclatoareSrv nomenclatorInstance;
	ContabilizareSrv contabgenInstance;
	FinplatiSrv finplatiInstance;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {		
		aprovizionareInstance= AprovizionareDummyFactory.getAprovizionareSrv();
		nomenclatorInstance=AprovizionareDummyFactory.getNomenclatoareSrv();
		contabgenInstance=AprovizionareDummyFactory.getContabGenSrv();
		stocuriInstance=AprovizionareDummyFactory.getStocuriSrv();
		finplatiInstance=AprovizionareDummyFactory.getFinPlatiSrv();
		logger.info("initTest");	
	}

	@Test
	public void testInregistrareCerereAprovizionare() {
		logger.info("Begin test: Inregistrare Cerere Aprovizionare");
		Calendar calendar = Calendar.getInstance();
		CerereAprovizionare cerere = new CerereAprovizionare(121,calendar.getTime(),"test",0);
		PlanAprovizionare plan1 = PlanAprovizionare.getPlanAprovizionare();
		PlanAprovizionare plan2;
		plan2 = aprovizionareInstance.inregistrareCerereAprovizionare(cerere);	
		assertEquals("Singleton failed",plan1,plan2);		
		logger.info("End test: Plan unic de aprovizionare creat");
	}
	
	@Test
	public void testcreareFactura() {
		logger.info("Begin test: Creare Factura");
		
		Double valfact= 0.0;
		Double TVATotal= 0.0;
		Persoana persoana= nomenclatorInstance.creazaPersona(101, "Popescu", "Adela");		
		Furnizor furnizor =aprovizionareInstance.creareFurnizor(persoana, 111);			
		Factura factura=aprovizionareInstance.creareFactura(furnizor,"111", valfact, TVATotal);
		assertNotNull("Nu exista factura!", factura);	
		logger.info("End test: creareFactura");
	}


	@Test
	public void testInregistrareFactura() {
    logger.info("Begin test: Inregistrare Factura");       
        Persoana persoana = new Persoana();        
        Furnizor furnizor = new Furnizor("cui","denumire","adresa","telefon",persoana,121);       
		Factura fact = aprovizionareInstance.creareFactura(furnizor,"123gfa",(double)121,(double)212);		
		int inreg =aprovizionareInstance.inregistrareFactura(fact);		
		assertEquals("UUPPSSS: nu s-a inregistrat cu succes in contabilitate",inreg,0);	
		logger.info("End test: factura inregistrata");
	}

	@Test
	public void testInregistrareReceptie() {
		logger.info("Begin test: Inregistrare receptie comanda");
		ArticolStoc articol = new ArticolStoc((double)0,"ArticolTest");
		Persoana persoana = new Persoana();  
		Furnizor furnizor = new Furnizor("cui","denumire","adresa","telefon",persoana,121);
	    Comanda comanda = new Comanda(11,furnizor,new Date(),Comanda.IN_CURS);
		LinieComanda linieComanda = new LinieComanda((Integer)1,comanda,articol,(double)2,(double)12);
		comanda.addLinii(linieComanda);
		Depozit depozit = new Depozit();
		Gestiune gestiune = new Gestiune();
		List<LinieComanda> linii=comanda.getLiniiComanda();
		for (int i = 0; i < linii.size(); i++) { 
		   stocuriInstance.intrareInStoc(linii.get(i).articol, linii.get(i).cantitate, gestiune, depozit);		   
		   assertEquals("Nu s-a adaugat pe stoc: ",articol.getStoc(),linii.get(i).cantitate);
		}
		logger.info("End test: comanda receptionata si adaugata pe stoc");
		
	}

	@Test
	public void testReturMateriale() {
		
		
	}
	
	@Test
	public void testAcceptPlataFacturaAchizitie() {
		logger.info("Begin test: verificare plata factura");
		 Persoana persoana = new Persoana();        
	        Furnizor furnizor = new Furnizor("cui","denumire","adresa","telefon",persoana,121);       
			Factura fact = aprovizionareInstance.creareFactura(furnizor,"123gfa",(double)121,(double)212);
			int i = finplatiInstance.acceptaPlataFurnizor(furnizor, fact.getValFact(), new Date());
			assertEquals("Nu putem plati la acest furnizor ",i,1);
			logger.info("End test: plata factura acceptata");
	}

}
