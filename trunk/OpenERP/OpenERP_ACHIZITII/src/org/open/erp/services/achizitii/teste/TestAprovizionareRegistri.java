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
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestAprovizionareEJBLogic.class.getName());
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
			/*this.aprovizionareInstance.stergeCategorie(cat3);*/
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
		Furnizor furn1=new Furnizor(1001,"cui1","Furn1","telef1");
		Furnizor furn2=new Furnizor(1002,"cui2","Furn2","telef2");
		Furnizor furn3=new Furnizor(1003,"cui3","Furn3","telef3");
		try{
			this.aprovizionareInstance.salveazaFurnizor(furn1);
			this.aprovizionareInstance.salveazaFurnizor(furn2);
			this.aprovizionareInstance.salveazaFurnizor(furn3);
		}
		catch(Exception ex){
			logger.debug("ERROR Furnizor: "+ex.getMessage());
		}
		//////////////
		Articol art1 = new Articol(1001,"art1","cat1","um1","marfa",cat1,100.0);
		Articol art2 = new Articol(1001,"art1","cat1","um1","marfa",cat2,100.0);
		Articol art3 = new Articol(1001,"art1","cat1","um1","marfa",cat1,100.0);
		try{
			this.aprovizionareInstance.salveazaArticol(art1);
			this.aprovizionareInstance.salveazaArticol(art2);
			this.aprovizionareInstance.salveazaArticol(art3);
		}
		catch(Exception ex){
			logger.error("ERROARE Articol: "+ex.getMessage());
		}
		/////////////
		CerereOferta cerereOf=new CerereOferta(1,new Date());
		cerereOf.setStatusCerereOferta(CerereOferta.PRIMITA);
		Collection<Furnizor> listaFurn=new ArrayList<Furnizor>();
		Furnizor furn4=new Furnizor(1004,"cui4","Furn4","telef4");
		Furnizor furn5=new Furnizor(1005,"cui5","Furn5","telef5");
		Furnizor furn6=new Furnizor(1006,"cui6","Furn6","telef6");
		listaFurn.add(furn4);
		listaFurn.add(furn5);
		listaFurn.add(furn6);
		cerereOf.setTrimisaLaFurnizori((List<Furnizor>) listaFurn);
		Collection<LinieCerereOferta> listaLiniiCerereOferta=new ArrayList<LinieCerereOferta>();
		LinieCerereOferta linieCerereOferta1=new LinieCerereOferta(1,cerereOf,art1,100.0);
		LinieCerereOferta linieCerereOferta2=new LinieCerereOferta(2,cerereOf,art2,101.0);
		LinieCerereOferta linieCerereOferta3=new LinieCerereOferta(3,cerereOf,art3,102.0);
		listaLiniiCerereOferta.add(linieCerereOferta1);
		listaLiniiCerereOferta.add(linieCerereOferta2);
		listaLiniiCerereOferta.add(linieCerereOferta3);
		cerereOf.setLinii((List<LinieCerereOferta>) listaLiniiCerereOferta);
		try{
			this.aprovizionareInstance.salveazaCerereOferta(cerereOf);
		}catch(Exception ex){
			logger.error("ERROR CerereOferta: "+ex.getMessage());
		}
        ///////////////
		OfertaAchizitie ofertaAchizitie = new OfertaAchizitie(1,new Date(),OfertaAchizitie.IN_CURS);
		Collection<LinieOfertaAchizitie> listaLiniiOfertaAchizitie=new ArrayList<LinieOfertaAchizitie>();
		LinieOfertaAchizitie linieOfertaAchizitie1 = new LinieOfertaAchizitie(ofertaAchizitie,art1,100.0,1);
		LinieOfertaAchizitie linieOfertaAchizitie2 = new LinieOfertaAchizitie(ofertaAchizitie,art2,102.0,2);
		listaLiniiOfertaAchizitie.add(linieOfertaAchizitie1);
		listaLiniiOfertaAchizitie.add(linieOfertaAchizitie2);
		ofertaAchizitie.setLiniiOferta(listaLiniiOfertaAchizitie);
		ofertaAchizitie.setFurnizor(furn1);
		ofertaAchizitie.setNrZile(10);
		ofertaAchizitie.setValTotal(1000.0);
		//-a 2 a OfertaAchizitie
		OfertaAchizitie ofertaAchizitie2 = new OfertaAchizitie(2,new Date(),OfertaAchizitie.IN_CURS);
		Collection<LinieOfertaAchizitie> listaLiniiOfertaAchizitie2=new ArrayList<LinieOfertaAchizitie>();
		LinieOfertaAchizitie linieOfertaAchizitie21 = new LinieOfertaAchizitie(ofertaAchizitie,art2,50.0,1);
		LinieOfertaAchizitie linieOfertaAchizitie22 = new LinieOfertaAchizitie(ofertaAchizitie,art1,200.0,2);
		listaLiniiOfertaAchizitie.add(linieOfertaAchizitie21);
		listaLiniiOfertaAchizitie.add(linieOfertaAchizitie22);
		ofertaAchizitie2.setLiniiOferta(listaLiniiOfertaAchizitie2);
		ofertaAchizitie2.setFurnizor(furn2);
		ofertaAchizitie2.setNrZile(9);
		ofertaAchizitie2.setValTotal(900.0);
		try{
			this.aprovizionareInstance.salveazaOfertaAchizitie(ofertaAchizitie);
			this.aprovizionareInstance.salveazaOfertaAchizitie(ofertaAchizitie2);
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
		}catch(Exception ex){
			logger.error("ERROR Comanda: "+ex.getMessage());
		}
		//////
		Factura fact = new Factura(furn1,"1001",1000.0,422.2,null,comanda,Factura.FACTURA_ACHIZITIE);
		Collection<LinieDocument> listaLiniiFacturaAchizitie = new ArrayList<LinieDocument>();
		LinieDocument linieFact1=new LinieFacturaAchizitie(1,fact,art1,100.0,100.0,234.0,100.0);
		LinieDocument linieFact2=new LinieFacturaAchizitie(2,fact,art2,300.0,200.0,33.0,400.0);
		listaLiniiFacturaAchizitie.add(linieFact1);
		listaLiniiFacturaAchizitie.add(linieFact2);
		fact.setLiniiDocument((List<LinieDocument>) listaLiniiFacturaAchizitie);
		try{
			this.aprovizionareInstance.salveazaFactura(fact);
		}catch(Exception ex){
			logger.error("ERROR Factura: "+ex.getMessage());
		}
		///////
		NIR nir = new NIR();
		nir.setFactura(fact);
		Collection<LinieDocument> listaLiniiNIR=new ArrayList<LinieDocument>();
		LinieDocument linieNIR1=new LinieNIR(1,nir,art1,2.0,2.0,2.0,2.0);
		LinieDocument linieNIR2=new LinieNIR(2,nir,art2,2.0,2.0,2.0,2.0);
		listaLiniiNIR.add(linieNIR1);
		listaLiniiNIR.add(linieNIR2);
		nir.setLiniiDocument((List<LinieDocument>) listaLiniiNIR);	
		try{
			this.aprovizionareInstance.salveazaNIR(nir);
		}catch(Exception ex){
			logger.error("ERROR NIR: "+ex.getMessage());
		}
		///////
		PlanAprovizionare plan = new PlanAprovizionare(1,1,2004,new Date(),null,PlanAprovizionare.IN_CURS);
		Collection<LiniePlanAprovizionare> liniiPlan=new ArrayList<LiniePlanAprovizionare>();
		LiniePlanAprovizionare liniePlan1 = new LiniePlanAprovizionare(art1,1.0,1);
		liniePlan1.setStatus(LiniePlanAprovizionare.IN_ASTEPTARE);
		LiniePlanAprovizionare liniePlan2 = new LiniePlanAprovizionare(art2,1.0,2);
		liniePlan1.setStatus(LiniePlanAprovizionare.EXISTA_CERERE_OFERTA);
		liniiPlan.add(liniePlan1);
		liniiPlan.add(liniePlan2);
		plan.setLiniiPlan((List<LiniePlanAprovizionare>) liniiPlan);
			logger.debug("End test: Insert-uri");
		}
		
		catch(Exception ex)
		{
			logger.debug("ERROR: "+ex.getMessage());
		}
		
	}			

}
