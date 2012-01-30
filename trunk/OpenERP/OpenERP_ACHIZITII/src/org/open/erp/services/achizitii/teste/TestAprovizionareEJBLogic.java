package org.open.erp.services.achizitii.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.hibernate.Hibernate;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.achizitii.AprovizionareSrv;
import org.open.erp.services.achizitii.Articol;
import org.open.erp.services.achizitii.CerereOferta;
import org.open.erp.services.achizitii.Comanda;
import org.open.erp.services.achizitii.Factura;
import org.open.erp.services.achizitii.LinieComanda;
import org.open.erp.services.achizitii.LinieNIR;
import org.open.erp.services.achizitii.LinieOfertaAchizitie;
import org.open.erp.services.achizitii.LiniePlanAprovizionare;
import org.open.erp.services.achizitii.NIR;
import org.open.erp.services.achizitii.OfertaAchizitie;
import org.open.erp.services.achizitii.PlanAprovizionare;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.stocuri.CerereAprovizionare;
import org.open.erp.services.stocuri.StocuriSrv;

public class TestAprovizionareEJBLogic {
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("LOoooooooooooooooooooooooooGGGGGGGG");
	static StocuriSrv stocuriInstance;
	static AprovizionareSrv aprovizionareInstance;
	static NomenclatoareSrv nomenclatorInstance;
	static ContabilizareSrv contabgenInstance;
	
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
	

/*	@Before
	public void setUp() throws Exception {		
		aprovizionareInstance= AprovizionareFactory.getAprovizionareSrv();
		nomenclatorInstance=AprovizionareFactory.getNomenclatoareSrv();
		contabgenInstance=AprovizionareFactory.getContabGenSrv();
		stocuriInstance=AprovizionareFactory.getStocuriSrv();		
		logger.info("initTest");	*/
		
		
		///---

		@Test
		public void testInregistrareCerereAprovizionare() throws Exception {
			//Testare actualizare plan aprovizionare in mod automat
		logger.debug("@Start test: inregistrare cerere aprovizionare");
		//Procesare procesare=stocuriInstance.getProcesare();
		CerereAprovizionare cerere = new CerereAprovizionare(1,new Date(),"solicitant","livrae");		
		List<LinieDocument> lista = new LinkedList<LinieDocument>();
		Articol mat1 = new Articol(1005,"mat1","cat1","um1","tip1",null,10.0);
		Articol mat2 = new Articol(1006,"mat2","cat2","um1","tip2",null,10.0);
		aprovizionareInstance.salveazaArticol(mat1);
		aprovizionareInstance.salveazaArticol(mat2);		
		LinieDocument linie1 = new LinieDocument(1,cerere,mat1,100.0,100.0,100.0);
		LinieDocument linie2 = new LinieDocument(2,cerere,mat2,100.0,100.0,100.0);
		lista.add(linie1);
		lista.add(linie2);
		cerere.setLiniiDocument(lista);		
		PlanAprovizionare plan = aprovizionareInstance.getPlanAprovizionare();//--se extrage ultimul plan din BD
		logger.error("IdPlanExtrasDinBD: "+plan.getIdPlanAprovizionare());
		//aprovizionareInstance.ascultaFurnizoriCerereriAprovizionare(procesare);
		//Apelare 'addLiniiCerereAprovizionare' din Clasa <Procesare> apartinand Stocurilor
		//procesare.addLiniiCerereAprovizionare(cerere, lista);
		//aprovizionareInstance.salveazaPlanAprovizionare(plan);
		logger.debug("Plan: "+plan.getIdPlanAprovizionare()+" dataStart: "+plan.getDataStart()+" dataFinal: "+plan.getDataFinal());
		PlanAprovizionare plan2=aprovizionareInstance.inregistrareCerereAprovizionare(plan, cerere);
		aprovizionareInstance.salveazaPlanAprovizionare(plan2);
		for (LiniePlanAprovizionare linie: plan2.getLiniiPlan()){
			logger.debug("Linie nr: "+linie.getLinie()+" Material: "+linie.getArticol().getDenumire()+" cantitate: "+linie.getCantitate());
		}
		logger.debug(plan2.getLiniiPlan().size());
		 
		assertTrue(plan2.getLiniiPlan().size()>=2);
		logger.debug("#End test: inregistrare cerere aprovizionare");
		}
		
		
		@Test
		public void testCreareCerereOferta() throws Exception {
			logger.debug("@Start test: testCreareCerereOferta");
			PlanAprovizionare plan=aprovizionareInstance.getPlanAprovizionareById(999);
			CerereOferta cerereOf=new CerereOferta(1099,new Date());
			CerereOferta cerereOfActualizat=aprovizionareInstance.adaugareLiniiCerereOferta(cerereOf, plan.getLiniiPlan());
			logger.error("NrLiniiPlanExtras: "+plan.getLiniiPlan().size());
			logger.error("StatusLinie2Plan: "+plan.getLiniiPlan().get(1).getStatus());
			aprovizionareInstance.salveazaCerereOferta(cerereOfActualizat);
			logger.error("NrLiniiCerereOferta "+cerereOfActualizat.getLinii().size());
			logger.error("LiniiPlanModificateAtasateEJB: "+aprovizionareInstance.getLiniiPlanAprovizionareCerereOf().size());
			aprovizionareInstance.salveazaPlanAprovizionare(plan);
			/*for(LiniePlanAprovizionare liniep:aprovizionareInstance.getLiniiPlanAprovizionareCerereOf()){
				logger.error("IdLiniePlanCreat: "+liniep.getIdLiniePlanAprovizionare());
				aprovizionareInstance.salveazaLiniePlanAprovizionare(liniep);
			}*/
			//aprovizionareInstance.salveazaCerereOferta(cerereOfActualizat);
			logger.debug("#End test: testCreareCerereOferta");
		}
		
		@Test 
		public void testCreareOfertaAchizitie() throws Exception {
			logger.debug("@Start test: testCreareOfertaAchizitie");
			CerereOferta cerereOf=aprovizionareInstance.getCerereOfertaById(1099);
			LinkedList<LinieOfertaAchizitie> lista = new LinkedList<LinieOfertaAchizitie>();		
			Articol art1 = new Articol(10,"art1","um",aprovizionareInstance.getCategorieById(1));
			Articol art2 = new Articol(20,"art2","buc",aprovizionareInstance.getCategorieById(2));
			aprovizionareInstance.salveazaArticol(art1);
			aprovizionareInstance.salveazaArticol(art2);
			LinieOfertaAchizitie linie1 = new LinieOfertaAchizitie(1199,null, art1,100.0,1,100.0);
			LinieOfertaAchizitie linie2= new LinieOfertaAchizitie(1188,null, art2,120.0,2,100.0);
			lista.add(linie1);
			lista.add(linie2);			
			OfertaAchizitie ofAchizitie = aprovizionareInstance.creareOfertaAchizitie(cerereOf, new Date(), null, lista);
			aprovizionareInstance.salveazaOfertaAchizitie(ofAchizitie);
			aprovizionareInstance.salveazaCerereOferta(aprovizionareInstance.getCerereOf());
			logger.debug("Nr Linii Oferta Achizitie: "+ofAchizitie.getLiniiOferta().size());
			logger.debug("Cerere Oferta-ofAchizitie: "+ofAchizitie.getCerereOferta().getId_CerereOferta());
			//logger.debug("Status Cerere Oferta: "+cerereOf.getStatusCerereOferta());
			logger.debug("#End test: testCreareOfertaAchizitie");
		}
		@Test
		public void testCreareComandaAnalizaOferte() throws Exception {
			logger.debug("@Start test: Analiza oferte si creare comanda");			
			List<OfertaAchizitie> listaOf=new ArrayList<OfertaAchizitie>();
			OfertaAchizitie of1=aprovizionareInstance.getOfertaAchizitie(1);
			OfertaAchizitie of2=aprovizionareInstance.getOfertaAchizitie(2);
			listaOf.add(of1);
			listaOf.add(of2);			
			Comanda comanda=aprovizionareInstance.analizaOferteAchizitie(listaOf);
			aprovizionareInstance.salveazaComanda(comanda);
			logger.debug("Comanda creata: "+comanda.getIdComanda()+ " "+comanda.getDataComanda());
			for (LinieComanda linieC:comanda.getLiniiComanda()){
				logger.debug("Linie: "+linieC.getLinieComanda()+" "+linieC.getArticol().getDenumire()+" "+linieC.getPret()+" "+linieC.getCantitate());
			}
			logger.debug("#End test: Analiza oferte si creare comanda");
			
		}
		@Test
		public void testInregistrareFactura() throws Throwable {
	        logger.debug("@Begin test: Inregistrare Factura");   
	        Factura fact = aprovizionareInstance.getFacturaById(1002);
	        logger.error("NRDOCFacturaExtrasa: "+fact.getNrDocument());
	        logger.error("NRFACTFacturaExtrasa: "+fact.getNrFact());
	        //logger.error("NRLINIIFacturaExtrasa: "+fact.getLiniiDocumentCount());
		    fact.setStatus(Factura.STORNATA);
		    
			Integer inreg =aprovizionareInstance.inregistrareFactura(fact);	
			aprovizionareInstance.salveazaFactura(fact);
			logger.error("Integer generat de inregistrare: "+inreg);
			assertEquals("UUPPSSS: nu s-a inregistrat cu succes in contabilitate",inreg.getClass().getSimpleName(),"Integer");	
			logger.info("#End test: factura inregistrata");
		}

		 
		@Test
		public void testCreareNir() throws Exception {
			logger.debug("@Start test: testCreareNir");
			
			List<LinieDocument> liniiNir= new ArrayList<LinieDocument>();	
		
			NIR nir = new NIR();
			nir.setNrDocument(99192);
			nir.setDataDocument(new Date());
			LinieNIR linie1= new LinieNIR(9988,nir,aprovizionareInstance.getArticoleById(1001),1.0,1.0,1.0,1.0);
			LinieNIR linie2= new LinieNIR(9987,nir,aprovizionareInstance.getArticoleById(1002),1.0,1.0,1.0,1.0);
			liniiNir.add(linie1);
			liniiNir.add(linie2);
			nir=aprovizionareInstance.adaugareLiniiNir(nir, liniiNir);
			nir.setFactura(aprovizionareInstance.getFacturaById(1002));
			
			aprovizionareInstance.salveazaNIR(nir);
			logger.debug("#End test: testCreareNir");
		}

		///---
	    
	
		
		
		
		
		
		
		
	
	/*@Test
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
		
	}*/
	
	

	

}
