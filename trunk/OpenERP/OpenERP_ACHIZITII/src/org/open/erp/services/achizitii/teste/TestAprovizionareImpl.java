package org.open.erp.services.achizitii.teste;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.achizitii.AprovizionareSrv;
import org.open.erp.services.achizitii.Articol;
import org.open.erp.services.achizitii.Categorie;
import org.open.erp.services.achizitii.Factura;
import org.open.erp.services.achizitii.Furnizor;
import org.open.erp.services.achizitii.LinieFacturaAchizitie;
import org.open.erp.services.achizitii.PlanAprovizionare;
import org.open.erp.services.ctbgen.Cont;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.RegConturi;
import org.open.erp.services.ctbgen.RegLuniLucru;
import org.open.erp.services.ctbgen.RegSablonNC;
import org.open.erp.services.ctbgen.RegTipuriContabile;
import org.open.erp.services.ctbgen.SablonNC;
import org.open.erp.services.ctbgen.TipContabil;
import org.open.erp.services.ctbgen.Cont.StatusSintetic;
import org.open.erp.services.ctbgen.Cont.TipCont;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.ctbgen.teste.TestContabilizareSrvImpl;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.stocuri.CerereAprovizionare;
import org.open.erp.services.stocuri.StocuriSrv;

public class TestAprovizionareImpl {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestAprovizionareImpl.class.getName());
	StocuriSrv stocuriInstance;
	AprovizionareSrv aprovizionareInstance;
	NomenclatoareSrv nomenclatorInstance;
	ContabilizareSrv contabgenInstance;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	

	@Before
	public void setUp() throws Exception {		
		aprovizionareInstance= AprovizionareFactory.getAprovizionareSrv();
		nomenclatorInstance=AprovizionareFactory.getNomenclatoareSrv();
		contabgenInstance=AprovizionareFactory.getContabGenSrv();
		stocuriInstance=AprovizionareFactory.getStocuriSrv();		
		logger.info("initTest");	
	}

	@Test
	public void testCrearePlanAprovizionare() {
		logger.info("Begin test: Inregistrare Cerere Aprovizionare");
		try{
			Calendar calendar = Calendar.getInstance();
			CerereAprovizionare cerere = new CerereAprovizionare(121,calendar.getTime(),"test","0");
			PlanAprovizionare plan1 = PlanAprovizionare.getPlanAprovizionare();
			PlanAprovizionare plan2;
			plan2 = aprovizionareInstance.inregistrareCerereAprovizionare(cerere);	
			assertEquals("Singleton failed",plan1,plan2);	
	    logger.info(plan2.getStatusPlan()+" "+plan2.getAn()+" "+plan2.getSaptAn()+" "+plan2.getDataStart()+" "+plan2.getDataFinal());
		}
		catch(Exception e){
		logger.error("Exceptie "+ e.getMessage());
		}	
		logger.info("End test: Plan unic de aprovizionare creat");
	}	
	

	@Test
	public void testInregistrareFactura() throws Throwable {
    logger.info("Begin test: Inregistrare Factura");   
        //Initializare context ContabGen
        RegSablonNC regSablonNC = RegSablonNC.instantiaza();
        RegConturi regConturi = RegConturi.instantiaza();	
	    RegTipuriContabile regTipContabile = RegTipuriContabile.instantiaza();
	    Cont c401 =new Cont(401,"Furnizori","401","4",StatusSintetic.SINTETIC, TipCont.PASIV);
		Cont c411 =new Cont(411,"Clienti","411","4",StatusSintetic.SINTETIC,TipCont.PASIV);
	    Cont c301 =new Cont(301,"Materii prime","301","3",StatusSintetic.SINTETIC,TipCont.ACTIV);       
        regConturi.addCont(c301); 
        regConturi.addCont(c401);
        regConturi.addCont(c411);
        TipContabil tipContabil = new TipContabil(1, "Materii prime", regConturi.getContDupaId(301), 
                regConturi.getContDupaId(401),  regConturi.getContDupaId(411));	
        regTipContabile.addTipContabil(tipContabil);
        SablonNC sab4= new SablonNC(1004,6,c301,c401);
        regSablonNC.addSablon(sab4);
       
        Persoana persoana = new Persoana();        
        Furnizor furnizor = new Furnizor(1111,persoana.getId(),10,121,"CUI","Denumire","Adresa","Telefon");       
		Factura fact = new Factura(600.0,200.0,"fact1",furnizor);	
		fact.setDataDoc(new Date());
		fact.setNrDoc(11);
		Categorie cat=new Categorie(1,"Categorie1");
		cat.addFurnizor(furnizor);
		
		Articol art1 = new Articol(1,"Articol1","buc",cat);
		art1.setTipContabil("Materii prime");		
		Articol art2 = new Articol(2,"Articol2","cutie",cat);
		art2.setTipContabil("Materii prime");
		
	    LinieFacturaAchizitie linieFact1 = new LinieFacturaAchizitie();
	    linieFact1.setCantitate(1.0);
	    linieFact1.setLinieDoc(1);
	    linieFact1.setMaterial(art1);
	    linieFact1.setPret(300.0);
	    linieFact1.setTVA(100.0);
	    linieFact1.setDocument(fact);
	    
	    LinieFacturaAchizitie linieFact2 = new LinieFacturaAchizitie();
	    linieFact2.setCantitate(1.0);
	    linieFact2.setLinieDoc(2);
	    linieFact2.setMaterial(art2);
	    linieFact2.setPret(300.0);
	    linieFact2.setTVA(100.0);
	    linieFact2.setDocument(fact);
	    fact.addLinie(linieFact1);
	    fact.addLinie(linieFact2);
	    
		Integer inreg =aprovizionareInstance.inregistrareFactura(fact);		
		assertEquals("UUPPSSS: nu s-a inregistrat cu succes in contabilitate",inreg.getClass().getSimpleName(),"Integer");	
		logger.info("End test: factura inregistrata");
	}

	/*@Test
	public void testReceptieMateriale() {
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
		
	}*/

	@Test
	public void testReturMateriale() {
		
		
	}
	
	@Test
	public void testInregistrareCerereAprovizionare() {
		
	}
	@Test
	public void testCreareCerereOferta() {
		
	}
	@Test
	public void testCreareOfertaAchizitie() {
		
	}
	@Test
	public void testCreareComandaAnalizaOferte() {
		
	}
	@Test
	public void testCreareComandaDinPlanAprovizionare() {
		
	}
	@Test
	public void testCreareNir() {
		
	}

}
