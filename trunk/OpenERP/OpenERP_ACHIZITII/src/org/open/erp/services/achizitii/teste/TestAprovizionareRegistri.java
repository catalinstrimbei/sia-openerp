package org.open.erp.services.achizitii.teste;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
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
import org.open.erp.services.achizitii.CerereOferta;
import org.open.erp.services.achizitii.Comanda;
import org.open.erp.services.achizitii.Factura;
import org.open.erp.services.achizitii.Furnizor;
import org.open.erp.services.achizitii.LinieCerereOferta;
import org.open.erp.services.achizitii.LinieComanda;
import org.open.erp.services.achizitii.LinieFacturaAchizitie;
import org.open.erp.services.achizitii.LinieNIR;
import org.open.erp.services.achizitii.LinieOfertaAchizitie;
import org.open.erp.services.achizitii.LiniePlanAprovizionare;
import org.open.erp.services.achizitii.NIR;
import org.open.erp.services.achizitii.OfertaAchizitie;
import org.open.erp.services.achizitii.PlanAprovizionare;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.stocuri.StocuriSrv;


public class TestAprovizionareRegistri {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestAprovizionareRegistri.class.getName());
	static StocuriSrv stocuriInstance;
	static AprovizionareSrv aprovizionareInstance;
	static NomenclatoareSrv nomenclatorInstance;
	static ContabilizareSrv contabgenInstance;
	/*static AprovizionareImpl ap;*/
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
	@SuppressWarnings("static-access")
	@Test	
	public void testInsert() throws Exception {
		try
		{
			logger.debug("Begin test: Insert-uri");			
		@SuppressWarnings("unused")
		Collection<Categorie> listCategorii =new ArrayList<Categorie>();	
		Categorie cat1 = new Categorie(1,"Categorie1");
		Categorie cat2 = new Categorie(2,"Categorie2");
		Categorie cat3 = new Categorie(3,"Categorie3");
		try{			
			this.aprovizionareInstance.salveazaCategorie(cat1);
			this.aprovizionareInstance.salveazaCategorie(cat2);
			this.aprovizionareInstance.salveazaCategorie(cat3);
			//this.aprovizionareInstance.stergeCategorie(cat3);
			logger.error("---------Adaugat Categorii-------------- ");
			
		}
		catch(Exception ex){
			logger.debug("ERROR Categorie: "+ex.getMessage());
		}
		/*listCategorii=aprovizionareInstance.getListaCategorii();		
			
			for(Iterator<Categorie> c = listCategorii.iterator(); c.hasNext();)
			{
				Categorie cat = c.next();
				logger.error("Categorie: "+cat.getId_cat()+" "+cat.getDenumire());
			}
		logger.error("Categorie cu ID 2: "+aprovizionareInstance.getCategorieById(2).getDenumire());*/	
		  
		////////////
		Furnizor furn1=new Furnizor(1001,1001,"cui1","furn1","tel1","adresa1",cat1);
		Furnizor furn2=new Furnizor(1002,1002,"cui2","furn2","tel2","adresa2",cat1);
		Furnizor furn3=new Furnizor(1003,1003,"cui3","furn3","tel3","adresa3",cat1);
		try{
			this.aprovizionareInstance.salveazaFurnizor(furn1);
			this.aprovizionareInstance.salveazaFurnizor(furn2);
			this.aprovizionareInstance.salveazaFurnizor(furn3);
			logger.error("---------Adaugat Furnizori-------------- ");
		}
		catch(Exception ex){
			logger.debug("ERROR Furnizor: "+ex.getMessage());
		}
		//////////////
		Articol art1 = new Articol(1001,"art1","cat1","um1","marfa",cat1,100.0);
		Articol art2 = new Articol(1002,"art2","cat2","um1","marfa",cat2,100.0);
		Articol art3 = new Articol(1003,"art3","cat1","um1","marfa",cat1,100.0);
		try{
			this.aprovizionareInstance.salveazaArticol(art1);
			this.aprovizionareInstance.salveazaArticol(art2);
			this.aprovizionareInstance.salveazaArticol(art3);
			logger.error("---------Adaugat Articole-------------- ");
		}
		catch(Exception ex){
			logger.error("ERROARE Articol: "+ex.getMessage());
		}  
		/////////////
		CerereOferta cerereOf=new CerereOferta(1,new Date());
		cerereOf.setStatusCerereOferta(CerereOferta.PRIMITA);
		Collection<Furnizor> listaFurn=new ArrayList<Furnizor>();
		Furnizor furn4=new Furnizor(1004,1004,"cui4","furn4","tel4","adresa4",cat1);
		Furnizor furn5=new Furnizor(1005,1005,"cui5","furn5","tel5","adresa5",cat2);
		Furnizor furn6=new Furnizor(1006,1006,"cui6","furn6","tel6","adresa6",cat1);
		listaFurn.add(furn4);
		listaFurn.add(furn5);
		listaFurn.add(furn6);
		cerereOf.setTrimisaLaFurnizori((List<Furnizor>) listaFurn);
		Collection<LinieCerereOferta> listaLiniiCerereOferta=new ArrayList<LinieCerereOferta>();
		LinieCerereOferta linieCerereOferta1=new LinieCerereOferta(1,1,cerereOf,art1,100.0);
		LinieCerereOferta linieCerereOferta2=new LinieCerereOferta(2,2,cerereOf,art2,101.0);
		LinieCerereOferta linieCerereOferta3=new LinieCerereOferta(3,3,cerereOf,art3,102.0);
		listaLiniiCerereOferta.add(linieCerereOferta1);
		listaLiniiCerereOferta.add(linieCerereOferta2);
		listaLiniiCerereOferta.add(linieCerereOferta3);
		cerereOf.setLinii((List<LinieCerereOferta>) listaLiniiCerereOferta);
		try{
			this.aprovizionareInstance.salveazaCerereOferta(cerereOf);
			logger.error("---------Adaugat CerereOferta-------------- ");
		}catch(Exception ex){
			logger.error("ERROR CerereOferta: "+ex.getMessage());
		}
        ///////////////
		OfertaAchizitie ofertaAchizitie = new OfertaAchizitie(1,new Date(),OfertaAchizitie.IN_CURS);
		Collection<LinieOfertaAchizitie> listaLiniiOfertaAchizitie=new ArrayList<LinieOfertaAchizitie>();
		LinieOfertaAchizitie linieOfertaAchizitie1 = new LinieOfertaAchizitie(1,ofertaAchizitie,art1,100.0,1,100.0);
		LinieOfertaAchizitie linieOfertaAchizitie2 = new LinieOfertaAchizitie(2,ofertaAchizitie,art1,100.0,2,100.0);
		
		listaLiniiOfertaAchizitie.add(linieOfertaAchizitie1);
		listaLiniiOfertaAchizitie.add(linieOfertaAchizitie2);
		ofertaAchizitie.setLiniiOferta(listaLiniiOfertaAchizitie);
		ofertaAchizitie.setFurnizor(furn1);
		ofertaAchizitie.setNrZile(10);
		ofertaAchizitie.setValTotal(1000.0);
		//-a 2 a OfertaAchizitie
		OfertaAchizitie ofertaAchizitie2 = new OfertaAchizitie(2,new Date(),OfertaAchizitie.IN_CURS);
		Collection<LinieOfertaAchizitie> listaLiniiOfertaAchizitie2=new ArrayList<LinieOfertaAchizitie>();
		LinieOfertaAchizitie linieOfertaAchizitie21 = new LinieOfertaAchizitie(3,ofertaAchizitie2,art2,100.0,1,100.0);
		LinieOfertaAchizitie linieOfertaAchizitie22 = new LinieOfertaAchizitie(4,ofertaAchizitie2,art1,100.0,2,100.0);
		listaLiniiOfertaAchizitie2.add(linieOfertaAchizitie21);
		listaLiniiOfertaAchizitie2.add(linieOfertaAchizitie22);
		ofertaAchizitie2.setLiniiOferta(listaLiniiOfertaAchizitie2);
		ofertaAchizitie2.setFurnizor(furn2);
		ofertaAchizitie2.setNrZile(9);
		ofertaAchizitie2.setValTotal(900.0);
		try{ 
			this.aprovizionareInstance.salveazaOfertaAchizitie(ofertaAchizitie);
			this.aprovizionareInstance.salveazaOfertaAchizitie(ofertaAchizitie2);
			logger.error("---------Adaugat OferteAchizitii-------------- ");
		}catch(Exception ex){
			logger.error("ERROR OfertaAchizitie: "+ex.getMessage());
		}  
		//////
		Comanda comanda = new Comanda(1,new Date(),Comanda.IN_CURS);
		Collection<LinieComanda> listaLiniiComanda = new ArrayList<LinieComanda>();
		LinieComanda linieComanda1=new LinieComanda(1,comanda,art1,100.0,2.0);
		LinieComanda linieComanda2=new LinieComanda(2,comanda,art2,70.0,5.0);
		LinieComanda linieComanda3=new LinieComanda(3,comanda,art1,60.0,10.0);
		listaLiniiComanda.add(linieComanda1);
		listaLiniiComanda.add(linieComanda2);
		listaLiniiComanda.add(linieComanda3);
		comanda.setLiniiComanda(listaLiniiComanda);
		comanda.setFurnizor(furn3);
		comanda.setOfertaAchizitie(ofertaAchizitie);		
		try{
			this.aprovizionareInstance.salveazaComanda(comanda);	
			logger.error("---------Adaugat Comanda-------------- ");
		}catch(Exception ex){
			logger.error("ERROR Comanda: "+ex.getMessage());
		}
		//////
		Factura fact1 = new Factura(1001,new Date(),null,"obs","1001",100.0,100.0,Factura.INREGISTRATA,Factura.FACTURA_ACHIZITIE);
		Factura fact2 = new Factura(1002,new Date(),null,"ob2s","1002",100.0,100.0,Factura.INREGISTRATA,Factura.FACTURA_ACHIZITIE);
		Collection<LinieDocument> listaLiniiFacturaAchizitie = new ArrayList<LinieDocument>();
		LinieDocument linieFact1=new LinieFacturaAchizitie(1,fact1,art1,100.0,20.0,2.0,1,100.0);
		LinieDocument linieFact2=new LinieFacturaAchizitie(2,fact1,art2,100.0,20.0,2.0,2,100.0);
		listaLiniiFacturaAchizitie.add(linieFact1);
		listaLiniiFacturaAchizitie.add(linieFact2);
		fact1.setLiniiDocument((List<LinieDocument>) listaLiniiFacturaAchizitie);
		
		Collection<LinieDocument> listaLiniiFacturaAchizitie2 = new ArrayList<LinieDocument>();
		LinieDocument linieFact21=new LinieFacturaAchizitie(3,fact2,art1,100.0,20.0,2.0,1,100.0);
		LinieDocument linieFact22=new LinieFacturaAchizitie(4,fact2,art2,100.0,20.0,2.0,2,100.0);
		listaLiniiFacturaAchizitie2.add(linieFact21);
		listaLiniiFacturaAchizitie2.add(linieFact22);
		fact2.setLiniiDocument((List<LinieDocument>) listaLiniiFacturaAchizitie2);
		try{ 
			this.aprovizionareInstance.salveazaFactura(fact1);
			this.aprovizionareInstance.salveazaFactura(fact2);
			logger.error("---------Adaugat Factura-------------- ");
		}catch(Exception ex){
			logger.error("ERROR Factura: "+ex.getMessage());
		}
		///////
		NIR nir = new NIR();	
		nir.setNrDocument(1006);
		nir.setDataDocument(new Date());
		nir.setFactura(fact1);		
		Collection<LinieDocument> listaLiniiNIR=new ArrayList<LinieDocument>();
		LinieDocument linieNIR1=new LinieNIR(1,nir,art1,2.0,2.0,2.0,2.0);
		LinieDocument linieNIR2=new LinieNIR(2,nir,art2,2.0,2.0,2.0,2.0);
		listaLiniiNIR.add(linieNIR1);
		listaLiniiNIR.add(linieNIR2);
		nir.setLiniiDocument((List<LinieDocument>) listaLiniiNIR);	
		NIR nir3=new NIR();
		nir3.setNrDocument(1008);
	
		///---
		NIR nir2 = new NIR();
		nir2.setNrDocument(1009);
		nir2.setDataDocument(new Date());
		nir2.setFactura(fact2);
		Collection<LinieDocument> listaLiniiNIR2=new ArrayList<LinieDocument>();
		LinieDocument linieNIR21=new LinieNIR(3,nir2,art1,2.0,2.0,2.0,2.0);
		LinieDocument linieNIR22=new LinieNIR(4,nir2,art2,2.0,2.0,2.0,2.0);
		listaLiniiNIR2.add(linieNIR21);
		listaLiniiNIR2.add(linieNIR22);
		nir2.setLiniiDocument((List<LinieDocument>) listaLiniiNIR2);	
		try{
			this.aprovizionareInstance.salveazaNIR(nir);
			this.aprovizionareInstance.salveazaNIR(nir3);
			this.aprovizionareInstance.salveazaNIR(nir2);
			logger.error("---------Adaugat NIR1-------------- "+nir.getNrDocument()+" "+nir.getLiniiDocument().size()+"  "+nir.getTest());
			//logger.error("---------Adaugat NIR2-------------- "+nir2.getNrDocument()+" "+nir2.getLiniiDocument().size());
		}catch(Exception ex){
			logger.error("ERROR NIR: "+ex.getMessage());
		}
		///////
		PlanAprovizionare plan = new PlanAprovizionare(1,1,2004,new Date(),null,PlanAprovizionare.IN_CURS);
		Collection<LiniePlanAprovizionare> liniiPlan=new ArrayList<LiniePlanAprovizionare>();
		LiniePlanAprovizionare liniePlan1 = new LiniePlanAprovizionare(1,plan,art1,10.0,1,LiniePlanAprovizionare.IN_ASTEPTARE);
		liniePlan1.setStatus(LiniePlanAprovizionare.IN_ASTEPTARE);
		LiniePlanAprovizionare liniePlan2 = new LiniePlanAprovizionare(2,plan,art2,10.0,2,LiniePlanAprovizionare.IN_ASTEPTARE);
		liniePlan1.setStatus(LiniePlanAprovizionare.EXISTA_CERERE_OFERTA);
		liniiPlan.add(liniePlan1);
		liniiPlan.add(liniePlan2);
		plan.setLiniiPlan((List<LiniePlanAprovizionare>) liniiPlan);
		try{
			this.aprovizionareInstance.salveazaPlanAprovizionare(plan);
			logger.error("---------Adaugat Plan Aprovizionare-------------- ");
		}catch(Exception ex){
			logger.error("ERROR Plan: "+ex.getMessage());
		}
		
		logger.debug("End test: Insert-uri");
		}
		
		catch(Exception ex)
		{
			logger.debug("ERROR: "+ex.getMessage());
		}
		
	}			

}
