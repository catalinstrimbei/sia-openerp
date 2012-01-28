package org.open.erp.services.achizitii.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
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
import org.open.erp.services.achizitii.exceptions.AchizitiiExceptions;
import org.open.erp.services.achizitii.impl.AprovizionareImpl;
import org.open.erp.services.ctbgen.Cont;
import org.open.erp.services.ctbgen.Cont.StatusSintetic;
import org.open.erp.services.ctbgen.Cont.TipCont;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.RegConturi;
import org.open.erp.services.ctbgen.RegSablonNC;
import org.open.erp.services.ctbgen.RegTipuriContabile;
import org.open.erp.services.ctbgen.SablonNC;
import org.open.erp.services.ctbgen.TipContabil;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.stocuri.CerereAprovizionare;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.exceptions.StocuriExceptions;
import org.open.erp.services.stocuri.impl.Procesare;

public class TestAprovizionare {
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestAprovizionare.class.getName());
	private StocuriSrv stocuriInstance;
	private AprovizionareSrv aprovizionareInstance;
	private NomenclatoareSrv nomenclatorInstance;
	private ContabilizareSrv contabgenInstance;
	


	@Before
	public void setUp() throws Exception {		
		aprovizionareInstance= AprovizionareFactory.getAprovizionareSrv();
		nomenclatorInstance=AprovizionareFactory.getNomenclatoareSrv();
		contabgenInstance=AprovizionareFactory.getContabGenSrv();
		stocuriInstance=AprovizionareFactory.getStocuriSrv();		
		logger.info("initTest");
		
	}

	
	
	@Test
	public void testInregistrareCerereAprovizionare() {
		//Testare actualizare plan aprovizionare in mod automat
	logger.debug("@Start test: inregistrare cerere aprovizionare");
	Procesare procesareTestare = new Procesare();	
	
	CerereAprovizionare cerere = new CerereAprovizionare(1,new Date(),"solicitant","livrae");
	
	List<LinieDocument> lista = new LinkedList<LinieDocument>();
	Material mat1 = new Material(1,"Mat1","buc");
	Material mat2 = new Material(2,"Mat2","pachet");
	LinieDocument linie1 = new LinieDocument(1,cerere,mat1,100.0,100.0,100.0);
	LinieDocument linie2 = new LinieDocument(2,cerere,mat2,100.0,100.0,100.0);
	lista.add(linie1);
	lista.add(linie2);
	AprovizionareImpl aprovImpl = new AprovizionareImpl();
	PlanAprovizionare plan = new PlanAprovizionare(1,1,2008,new Date(),null,PlanAprovizionare.IN_CURS);	
	aprovImpl.planAprovizionare=plan;
	aprovImpl.ascultaFurnizoriCerereriAprovizionare(procesareTestare);
	//Apelare 'addLiniiCerereAprovizionare' din Clasa <Procesare> apartinand Stocurilor
	procesareTestare.addLiniiCerereAprovizionare(cerere, lista);
	
	
	logger.debug("Plan: "+plan.getIdPlanAprovizionare()+" dataStart: "+plan.getDataStart()+" dataFinal: "+plan.getDataFinal());
	for (LiniePlanAprovizionare linie: plan.getLiniiPlan()){
		logger.debug("Linie nr: "+linie.getLinie()+" Material: "+linie.getArticol().getDenumire()+" cantitate: "+linie.getCantitate());
	}
	logger.debug(plan.getLiniiPlan().size());
	
	assertTrue(plan.getLiniiPlan().size()>=1);
	logger.debug("#End test: inregistrare cerere aprovizionare");
	}
	
	
	@Test
	public void testCreareCerereOferta() {
		logger.debug("@Start test: testCreareCerereOferta");
		Procesare procesareTestare = new Procesare();	
		
		CerereAprovizionare cerere = new CerereAprovizionare(1,new Date(),"solicitant","livrae");
		
		List<LinieDocument> lista = new LinkedList<LinieDocument>();
		Material mat1 = new Material(1,"Mat1","buc");
		Material mat2 = new Material(2,"Mat2","pachet");
		LinieDocument linie1 = new LinieDocument(1,cerere,mat1,100.0,100.0,100.0);
		LinieDocument linie2 = new LinieDocument(2,cerere,mat2,100.0,100.0,100.0);
		lista.add(linie1);
		lista.add(linie2);
		AprovizionareImpl aprovImpl = new AprovizionareImpl();
		PlanAprovizionare plan = new PlanAprovizionare(1,1,2008,new Date(),null,PlanAprovizionare.IN_CURS);	
		aprovImpl.planAprovizionare=plan;
		aprovImpl.ascultaFurnizoriCerereriAprovizionare(procesareTestare);
		//Apelare 'addLiniiCerereAprovizionare' din Clasa <Procesare> apartinand Stocurilor
		procesareTestare.addLiniiCerereAprovizionare(cerere, lista);	
		
		//Planul de aprovizionare contine acum cateva linii de test din care va fi generata a o cerere de oferta
		
		CerereOferta cerereOferta = new CerereOferta(1,new Date());
		cerereOferta.setId_CerereOferta(101);
		logger.debug("NrLiniiPlan: "+plan.getLiniiPlan().size());
		aprovizionareInstance.adaugareLiniiCerereOferta(cerereOferta, plan.getLiniiPlan());
		logger.debug("Cererea de oferta creata: "+cerereOferta.getId_CerereOferta()+" are "+cerereOferta.getLinii().size()+" linii create;");
		for(LinieCerereOferta linieCerereOferta:cerereOferta.getLinii()){
			logger.debug("Linie Cerere Oferta: "+linieCerereOferta.getNrLinie()+" "+linieCerereOferta.getArticol().getDenumire()+" "+linieCerereOferta.getCantitate());
		}
		//Testam daca s-a modificat statusulu liniilor din Plan
		logger.debug("Plan: "+plan.getIdPlanAprovizionare()+" dataStart: "+plan.getDataStart()+" dataFinal: "+plan.getDataFinal());
		for (LiniePlanAprovizionare linie: plan.getLiniiPlan()){
			logger.debug("Linie nr: "+linie.getLinie()+" "+linie.getStatus());
		}
		logger.debug("#End test: testCreareCerereOferta");
	}
	
	@Test
	public void testCreareOfertaAchizitie() throws AchizitiiExceptions {
		logger.debug("@Start test: testCreareOfertaAchizitie");
		LinkedList<LinieOfertaAchizitie> lista = new LinkedList<LinieOfertaAchizitie>();		
		Articol art1 = new Articol(1,"art1","um",new Categorie());
		Articol art2 = new Articol(2,"art2","buc",new Categorie());
		LinieOfertaAchizitie linie1 = new LinieOfertaAchizitie(null, art1,100.0,1,100.0);
		LinieOfertaAchizitie linie2= new LinieOfertaAchizitie(null, art2,120.0,2,100.0);
		lista.add(linie1);
		lista.add(linie2);
		CerereOferta cerereOf=new CerereOferta();
		cerereOf.setId_CerereOferta(10);
		OfertaAchizitie ofAchizitie = aprovizionareInstance.creareOfertaAchizitie(cerereOf, new Date(), null, lista);
		logger.debug("Nr Linii Oferta Achizitie: "+ofAchizitie.getLiniiOferta().size());
		logger.debug("Cerere Oferta-ofAchizitie: "+ofAchizitie.getCerereOferta().getId_CerereOferta());
		logger.debug("Status Cerere Oferta: "+cerereOf.getStatusCerereOferta());
		logger.debug("#End test: testCreareOfertaAchizitie");
	}
	@Test
	public void testCreareComandaAnalizaOferte() {
		logger.debug("@Start test: Analiza oferte si creare comanda");
		List<OfertaAchizitie> listaOferte = new LinkedList<OfertaAchizitie>();
		OfertaAchizitie oferta1 = new OfertaAchizitie(1,new Date(),OfertaAchizitie.IN_CURS);
		OfertaAchizitie oferta2 = new OfertaAchizitie(2,new Date(),OfertaAchizitie.IN_CURS);
		OfertaAchizitie oferta3 = new OfertaAchizitie(3,new Date(),OfertaAchizitie.IN_CURS);
		logger.debug("OfertaAchizitie");
		oferta1.setNrZile(2);
		oferta2.setNrZile(3);
		oferta3.setNrZile(1);
		logger.debug("Oferte");
		Articol mat1 = new Articol(1,"Mat1","buc",null);		
		Articol mat2 = new Articol(2,"Mat2","pachet",null);
		Articol mat3 = new Articol(3,"Mat3","pachet",null);
		
		logger.debug(oferta1.getNrZile());
		//Inseram linii in <oferta1>
		LinieOfertaAchizitie linie11 = new LinieOfertaAchizitie(oferta1,mat1,100.0,1,50.0);
		LinieOfertaAchizitie linie12 = new LinieOfertaAchizitie(oferta1,mat2,100.0,2,60.0);
		LinieOfertaAchizitie linie13 = new LinieOfertaAchizitie(oferta1,mat3,100.0,3,55.9);
		oferta1.addLinieOfertaAchizitie(linie11);		
		oferta1.addLinieOfertaAchizitie(linie12);
		oferta1.addLinieOfertaAchizitie(linie13);
		//Inseram linii in <oferta2>
		LinieOfertaAchizitie linie21 = new LinieOfertaAchizitie(oferta2,mat1,100.0,1,77.0);
		LinieOfertaAchizitie linie22 = new LinieOfertaAchizitie(oferta2,mat2,100.0,2,48.0);
		LinieOfertaAchizitie linie23 = new LinieOfertaAchizitie(oferta2,mat3,100.0,3,50.0);
		oferta2.addLinieOfertaAchizitie(linie21);
		oferta2.addLinieOfertaAchizitie(linie22);
		oferta2.addLinieOfertaAchizitie(linie23);
		//Inseram linii in <oferta3>
		LinieOfertaAchizitie linie31 = new LinieOfertaAchizitie(oferta3,mat1,100.0,1,80.0);
		LinieOfertaAchizitie linie32 = new LinieOfertaAchizitie(oferta3,mat2,100.0,2,39.0);
		LinieOfertaAchizitie linie33 = new LinieOfertaAchizitie(oferta3,mat3,100.0,3,49.0);
		oferta3.addLinieOfertaAchizitie(linie31);
		oferta3.addLinieOfertaAchizitie(linie32);
		oferta3.addLinieOfertaAchizitie(linie33);
		//Populam lista cu ofertele de achizitie
	    listaOferte.add(oferta1);
	    listaOferte.add(oferta2);
	    listaOferte.add(oferta3);	    
		Comanda comanda;
		comanda=aprovizionareInstance.analizaOferteAchizitie(listaOferte);
		logger.debug("Comanda creata: "+comanda.getIdComanda()+ " "+comanda.getDataComanda());
		for (LinieComanda linieC:comanda.getLiniiComanda()){
			logger.debug("Linie: "+linieC.getLinieComanda()+" "+linieC.getArticol().getDenumire()+" "+linieC.getPret()+" "+linieC.getCantitate());
		}
		logger.debug("#End test: Analiza oferte si creare comanda");
		
	}
	@Test
	public void testCreareComandaDinPlanAprovizionare() {
		logger.debug("@Start test: Creare comanda din linii plan aprovizionare");
		Comanda comanda = new Comanda(1,new Date(),Comanda.IN_CURS);
		Articol mat1 = new Articol(1,"Mat1","buc",null);
		Articol mat2 = new Articol(2,"Mat2","pachet",null);
		Articol mat3 = new Articol(3,"Mat3","pachet",null);
		List<LiniePlanAprovizionare> liniiPlan = new LinkedList<LiniePlanAprovizionare>();
		LiniePlanAprovizionare linie1 = new LiniePlanAprovizionare(mat1,100.0,1);
		LiniePlanAprovizionare linie2 = new LiniePlanAprovizionare(mat2,100.0,2);
		LiniePlanAprovizionare linie3 = new LiniePlanAprovizionare(mat3,100.0,3);
		liniiPlan.add(linie1);
		liniiPlan.add(linie2);
		liniiPlan.add(linie3);
		aprovizionareInstance.adaugaLiniiComanda(comanda, liniiPlan);	
		logger.debug("LiniePlan1: "+linie1.getStatus());
		logger.debug("LiniePlan2: "+linie2.getStatus());
		logger.debug("LiniePlan3: "+linie3.getStatus());
		logger.debug("----------------------------------");
		for (LinieComanda linieComanda: comanda.getLiniiComanda()){
			logger.error("LinieComanda: "+linieComanda.getLinieComanda()+ " "+linieComanda.getArticol().getDenumire()+" "+linieComanda.getCantitate()+" "+linieComanda.getPret());			
		}
		logger.debug("#End test: Creare comanda din linii plan aprovizionare; Legenda: 2=CREAT_COMANDA");
	}	
	@Test
	public void testCreareNir() throws CtbException {
		logger.debug("@Start test: testCreareNir");
		List<LinieDocument> lista = new LinkedList<LinieDocument>();
		NIR nir = new NIR();
		Material mat1 = new Material(1,"Mat1","buc");
		Material mat2 = new Material(2,"Mat2","pachet");
		LinieDocument linie1 = new LinieDocument(1,null,mat1,100.0,100.0,100.0);
		LinieDocument linie2 = new LinieDocument(2,null,mat2,100.0,100.0,100.0);
		lista.add(linie1);
		lista.add(linie2);
		nir=aprovizionareInstance.adaugareLiniiNir(nir, lista);
		
		logger.debug("#End test: testCreareNir");
	}

}
