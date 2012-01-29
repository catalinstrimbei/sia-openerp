package org.open.erp.services.achizitii.teste;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.achizitii.AprovizionareSrv;
import org.open.erp.services.achizitii.Articol;
import org.open.erp.services.achizitii.Categorie;
import org.open.erp.services.achizitii.Factura;
import org.open.erp.services.achizitii.Furnizor;
import org.open.erp.services.achizitii.LinieFacturaAchizitie;
import org.open.erp.services.achizitii.LinieNIR;
import org.open.erp.services.achizitii.NIR;
import org.open.erp.services.achizitii.PlanAprovizionare;
import org.open.erp.services.achizitii.impl.AprovizionareImpl;
import org.open.erp.services.ctbgen.Cont;
import org.open.erp.services.ctbgen.Cont.StatusSintetic;
import org.open.erp.services.ctbgen.Cont.TipCont;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.stocuri.CerereAprovizionare;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.exceptions.StocuriExceptions;
import org.open.erp.services.stocuri.impl.Procesare;

public class TestAprovizionareEJBLogic {
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestAprovizionareEJBLogic.class.getName());
	static StocuriSrv stocuriInstance;
	static AprovizionareSrv aprovizionareInstance;
	static NomenclatoareSrv nomenclatorInstance;
	static ContabilizareSrv contabgenInstance;
	static AprovizionareImpl ap;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
		InitialContext ctx = initJBossJNDICtx();		
		stocuriInstance = (StocuriSrv)ctx.lookup("StocuriSrv/remote");	
		aprovizionareInstance=(AprovizionareSrv)ctx.lookup("AprovizionareSrv/remote");
		nomenclatorInstance=(NomenclatoareSrv)ctx.lookup("NomenclatoareSrv/remote");
		contabgenInstance=(org.open.erp.services.ctbgen.ContabilizareSrv)ctx.lookup("ContabilizareSrv/remote");
	
	}

	private static InitialContext initJBossJNDICtx() throws NamingException{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}
	

	@Before
	public void setUp() throws Exception {		
		/*aprovizionareInstance= AprovizionareFactory.getAprovizionareSrv();
		nomenclatorInstance=AprovizionareFactory.getNomenclatoareSrv();
		contabgenInstance=AprovizionareFactory.getContabGenSrv();
		stocuriInstance=AprovizionareFactory.getStocuriSrv();		
		logger.info("initTest");	*/
	    
	}
	@Test
	public void testCrearePlanAprovizionare() {
		logger.info("@Begin test: Inregistrare Cerere Aprovizionare");
		try{
			Calendar calendar = Calendar.getInstance();
			CerereAprovizionare cerere = new CerereAprovizionare(121,calendar.getTime(),"test","0");
			PlanAprovizionare plan1 = aprovizionareInstance.getPlanAprovizionare();
			PlanAprovizionare plan2;
			plan2 = aprovizionareInstance.inregistrareCerereAprovizionare(plan1,cerere);	
			assertEquals("Singleton failed",plan1,plan2);	
	    logger.info("plan2: "+plan2.getStatusPlan()+" "+plan2.getAn()+" "+plan2.getSaptAn()+" "+plan2.getDataStart()+" "+plan2.getDataFinal());
	    logger.info("plan1: "+plan1.getStatusPlan()+" "+plan1.getAn()+" "+plan1.getSaptAn()+" "+plan1.getDataStart()+" "+plan1.getDataFinal());
		}
		catch(Exception e){
		logger.error("Exceptie "+ e.getMessage());
		}	
		logger.info("#End test: Plan unic de aprovizionare creat");
	}	
	

	@Test
	public void testInregistrareFactura() throws Throwable {
        logger.debug("@Begin test: Inregistrare Factura");   
                //Initializare context ContabGen
        //RegSablonNC regSablonNC = RegSablonNC.instantiaza();
       // RegConturi regConturi = RegConturi.instantiaza();	
	    //RegTipuriContabile regTipContabile = RegTipuriContabile.instantiaza();
	    Cont c401 =new Cont(401,"Furnizori","401","4",StatusSintetic.SINTETIC, TipCont.PASIV);
		Cont c411 =new Cont(411,"Clienti","411","4",StatusSintetic.SINTETIC,TipCont.PASIV);
	    Cont c301 =new Cont(301,"Materii prime","301","3",StatusSintetic.SINTETIC,TipCont.ACTIV);       
       // regConturi.addCont(c301); 
       // regConturi.addCont(c401);
       //regConturi.addCont(c411);
       /* TipContabil tipContabil = new TipContabil("Materii prime", RegConturi.getContDupaId(301), 
                RegConturi.getContDupaId(401),  RegConturi.getContDupaId(411));	
        TipContabil tipContabil2 = new TipContabil( "Materii prime", c301, 
                c401,  c411);	*/
        //regTipContabile.addTipContabil(tipContabil);
        //SablonNC sab4= new SablonNC(1004,6,c301,c401);
       // regSablonNC.addSablon(sab4);
       
          
        Furnizor furnizor = new Furnizor(1111,"CUI","Denumire","Telefon");       
		Factura fact = new Factura(600.0,200.0,"fact1",furnizor);	
		fact.setDataDocument(new Date());
		fact.setNrDoc(11);
		Categorie cat=new Categorie(1,"Categorie1");
		cat.addFurnizor(furnizor);
		logger.error("bla");
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
		logger.info("#End test: factura inregistrata");
	}

	@Test
	public void testReceptieMateriale() {
		logger.info("Begin test: Inregistrare receptie comanda");		
		List<Gestiune> gestiuni = new LinkedList<Gestiune>();
		Gestiune gst1 = new Gestiune(1, "den gest 1", new Depozit(1, "Iasi",
				"100 m2"));
		Gestiune gst2 = new Gestiune(2, "den gest 1", new Depozit(2, "Iasi",
				"100 m2"));
		gestiuni.add(gst1);
		gestiuni.add(gst2);
		Procesare procesareTest = new Procesare(gestiuni,null);	
		 Persoana persoana = new Persoana();        
	        Furnizor furnizor = new Furnizor(1111,"CUI","Denumire","Telefon");    
			Categorie cat=new Categorie(1,"Categorie1");
			cat.addFurnizor(furnizor);
			logger.error("-Creat categorie articol-");
			Articol art1 = new Articol(1,"Articol1","buc",cat);
			art1.setTipContabil("Materii prime");		
			Articol art2 = new Articol(2,"Articol2","cutie",cat);
			art2.setTipContabil("Materii prime");
			//Cream un NIR de test cu liniile aferente;
			NIR nir = new NIR();
			LinieNIR linie1= new LinieNIR(1,nir,art1,100.0,10.0,2.4,11.0);
			linie1.setDocument(nir);
			LinieNIR linie2= new LinieNIR(2,nir,art2,40.0,3.0,1.0,4.0);
			linie2.setDocument(nir);
			nir.addLinie(linie1);
			nir.addLinie(linie2);
			logger.debug("-NIR creat-");
			logger.debug("Numar linii din NIR: "+nir.getLiniiDocument().size());
			//Metoda noastra <receptieMateriale> apeleaza din 'Procesare' <intrareInStoc>
			Boolean bool = procesareTest.intrareInStoc(nir,null);
			assertEquals("Produsele din NIR au fost adaugate cu succes pe stoc", Boolean.TRUE,bool);
			
			logger.debug("Rezultat intrare pe stoc: "+bool);
		logger.info("End test: comanda receptionata si adaugata pe stoc");
		
	}

	
	//////////
	@Test
	public void testReturMateriale() throws StocuriExceptions {	
		logger.debug("@Start test: testReturMateriale");	
		List<Gestiune> gestiuni = new LinkedList<Gestiune>();
		Gestiune gst1 = new Gestiune(1, "den gest 1", new Depozit(1, "Iasi",
				"100 m2"));
		Gestiune gst2 = new Gestiune(2, "den gest 1", new Depozit(2, "Iasi",
				"100 m2"));
		gestiuni.add(gst1);
		gestiuni.add(gst2);
		Procesare procesareTest = new Procesare(gestiuni,null);	
        Persoana persoana = new Persoana();        
        Furnizor furnizor = new Furnizor(1111,"CUI","Denumire","Telefon");     
        
		Factura fact = new Factura(600.0,200.0,"fact1",furnizor);	
		fact.setDataDocument(new Date());
		fact.setNrDoc(11);
		Categorie cat=new Categorie(1,"Categorie1");
		cat.addFurnizor(furnizor);
		logger.error("bla");
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
	    logger.debug("-Factura creata-");
	    Boolean bool = procesareTest.intrareInStoc(fact,null);
	    //Metoda noastra din 'AprovizionareImpl' <returMateriale> apeleaza din 'StocuriSrv' metoda 
	    //<iesireStoc> care la randul ei apeleaza din 'Procesare' <procesareComandaIesire> care ar trebui
	    //sa diminueze stocul cu produsele de pe documentul trimis din modulul 'Achizitii'
	    procesareTest.procesareComandaIesire(fact);
		logger.debug("#End test: testReturMateriale");
	}

	

}
