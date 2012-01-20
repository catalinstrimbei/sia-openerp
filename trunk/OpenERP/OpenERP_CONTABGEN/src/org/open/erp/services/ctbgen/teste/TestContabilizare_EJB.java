package org.open.erp.services.ctbgen.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.ctbgen.Cont;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.LunaLucru;
import org.open.erp.services.ctbgen.SablonNC;
import org.open.erp.services.ctbgen.StareDocument;
import org.open.erp.services.ctbgen.TipContabil;
import org.open.erp.services.ctbgen.TipIncasare;
import org.open.erp.services.ctbgen.TipPlata;
import org.open.erp.services.ctbgen.Cont.StatusSintetic;
import org.open.erp.services.ctbgen.Cont.TipCont;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Material;


public class TestContabilizare_EJB {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestContabilizare_EJB.class.getName());
	
    private static ContabilizareSrv instantaCtbGen;
    //private static NomenclatoareSrv nomenclatorInstance;
	
//	RegSablonNC regSablonNC;
//	RegConturi regConturi;
//	RegLuniLucru regLuniConturi;
//	RegTipuriContabile regTipContabile;
	
	/*--- InitialContext Client EJB-JDNI ----------------------------------------------------*/
	private static InitialContext initJBossJNDICtx() throws NamingException{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InitialContext ctx = initJBossJNDICtx();
		instantaCtbGen = (ContabilizareSrv)ctx.lookup("ContabilizareSrv/remote");
				
		logger.info("initTest " + instantaCtbGen);
		
	
		//instantaCtbGen=  ContabilizareDummyFactory.getContabilizareSrv();
		//nomenclatorInstance = ContabilizareDummyFactory.getNomenclatoareSrv();
//		regSablonNC = RegSablonNC.instantiaza();
//		regConturi = RegConturi.instantiaza();
//		regLuniConturi = RegLuniLucru.instantiaza();
//		regTipContabile = RegTipuriContabile.instantiaza();
//		
		//Cont c301=instantaCtbGen.crearePlanCont("Materii prime","301","3",StatusSintetic.SINTETIC,null, TipCont.ACTIV);
		
		Cont c301 =instantaCtbGen.crearePlanCont("Materii prime","301","3",StatusSintetic.SINTETIC,null, TipCont.ACTIV);
		Cont c303 =instantaCtbGen.crearePlanCont("Materiale ob inv","303","3",StatusSintetic.SINTETIC,null, TipCont.ACTIV);
		Cont c307 =instantaCtbGen.crearePlanCont("Marfuri","307","3",StatusSintetic.SINTETIC,null,TipCont.ACTIV);
		Cont c601 =instantaCtbGen.crearePlanCont("Chelt materii prime","601","6",StatusSintetic.SINTETIC,null, TipCont.ACTIV);
		Cont c603 =instantaCtbGen.crearePlanCont("Chelt mat ob inv","603","6",StatusSintetic.SINTETIC,null, TipCont.ACTIV);
		Cont c607 =instantaCtbGen.crearePlanCont("Chelt marfuri","607","6",StatusSintetic.SINTETIC,null, TipCont.ACTIV);
		Cont c707 =instantaCtbGen.crearePlanCont("Vanzari marfuri","707","7",StatusSintetic.SINTETIC,null, TipCont.PASIV);
		Cont c401 =instantaCtbGen.crearePlanCont("Furnizori","401","4",StatusSintetic.SINTETIC,null, TipCont.PASIV);
		Cont c411 =instantaCtbGen.crearePlanCont("Clienti","411","4",StatusSintetic.SINTETIC,null,TipCont.PASIV);
		Cont c628 =instantaCtbGen.crearePlanCont("servicii prestate de terti","628","6",StatusSintetic.SINTETIC,null, TipCont.ACTIV);
		Cont c531 =instantaCtbGen.crearePlanCont("casa","531","5",StatusSintetic.SINTETIC,null,TipCont.ACTIV);
		Cont c512 =instantaCtbGen.crearePlanCont("banca","512","5",StatusSintetic.SINTETIC,null,TipCont.ACTIV);
		Cont c345 =instantaCtbGen.crearePlanCont("produse finite","345","3",StatusSintetic.SINTETIC,null,TipCont.ACTIV);
		Cont c711 =instantaCtbGen.crearePlanCont("Variatia stocurilor","711","7",StatusSintetic.SINTETIC,null,TipCont.PASIV);
		Cont c641 =instantaCtbGen.crearePlanCont("Ch salarii","641","6",StatusSintetic.SINTETIC,null,TipCont.ACTIV);
		Cont c645 =instantaCtbGen.crearePlanCont("Ch contributii","645","3",StatusSintetic.SINTETIC,null,TipCont.ACTIV);
		Cont c421 =instantaCtbGen.crearePlanCont("Salarii personal","421","4",StatusSintetic.SINTETIC,null, TipCont.PASIV);
		Cont c4311 =instantaCtbGen.crearePlanCont("CAS firma","4311","4",StatusSintetic.ANALITIC,null, TipCont.PASIV);
		Cont c4312 =instantaCtbGen.crearePlanCont("CAS angajat","4312","4",StatusSintetic.ANALITIC,null, TipCont.PASIV);
		Cont c4313 =instantaCtbGen.crearePlanCont("Sanatate firma","4313","4",StatusSintetic.ANALITIC,null,TipCont.PASIV);
		Cont c4314 =instantaCtbGen.crearePlanCont("Sanatate angajat","4314","4",StatusSintetic.ANALITIC,null,TipCont.PASIV);
		Cont c4315=instantaCtbGen.crearePlanCont("Fond Risc","4315","4",StatusSintetic.ANALITIC,null,TipCont.PASIV);
		Cont c4316 =instantaCtbGen.crearePlanCont("Concedii medicale","4316","4",StatusSintetic.ANALITIC,null,TipCont.PASIV);
		Cont c4371 =instantaCtbGen.crearePlanCont("Somaj firma","4371","4",StatusSintetic.ANALITIC,null,TipCont.PASIV);
		Cont c4372 =instantaCtbGen.crearePlanCont("Somaj Angajat","4372","4",StatusSintetic.ANALITIC,null,TipCont.PASIV);
		Cont c4373 =instantaCtbGen.crearePlanCont("Fond garantare","4373","4",StatusSintetic.ANALITIC,null,TipCont.PASIV);
		Cont c444 =instantaCtbGen.crearePlanCont("Impozit salarii","444","4",StatusSintetic.SINTETIC,null,TipCont.PASIV);
		
//		regConturi.addCont(c301);
//		regConturi.addCont(c307);
//		regConturi.addCont(c607);
//		regConturi.addCont(c707);
//		regConturi.addCont(c401);
//		regConturi.addCont(c411);
//		regConturi.addCont(c628);
//		regConturi.addCont(c531);
//		regConturi.addCont(c512);
//		regConturi.addCont(c345);
//		regConturi.addCont(c711);
//		
//		regConturi.addCont(c641);
//		regConturi.addCont(c645);
//		regConturi.addCont(c421);
//		regConturi.addCont(c4311);
//		regConturi.addCont(c4312);
//		regConturi.addCont(c4313);
//		regConturi.addCont(c4314);
//		regConturi.addCont(c4315);
//		regConturi.addCont(c4316);
//		regConturi.addCont(c4371);
//		regConturi.addCont(c4372);
//		regConturi.addCont(c4373);
//		regConturi.addCont(c444);
		//----------------------
		SablonNC sab0= instantaCtbGen.creareSablonNC(3,instantaCtbGen.getContDupaSimbol("345"),instantaCtbGen.getContDupaSimbol("711"));
		SablonNC sabl= instantaCtbGen.creareSablonNC(5,c607,c301);
		SablonNC sab2= instantaCtbGen.creareSablonNC(4,c411,c707);
		SablonNC sab3= instantaCtbGen.creareSablonNC(6,c628,c401);
		SablonNC sab4= instantaCtbGen.creareSablonNC(6,c301,c401);
		SablonNC sab7= instantaCtbGen.creareSablonNC(9,null,c531);
		SablonNC sab8= instantaCtbGen.creareSablonNC(10,null,c512);
		SablonNC sab9= instantaCtbGen.creareSablonNC(7,c531,null);
		SablonNC sab10= instantaCtbGen.creareSablonNC(8,c512,null);
		
		
		SablonNC sab11= instantaCtbGen.creareSablonNC(11,c641,c421);
		SablonNC sab12= instantaCtbGen.creareSablonNC(12,c421,c4314);
		SablonNC sab13= instantaCtbGen.creareSablonNC(13,c421,c4372);
		SablonNC sab14= instantaCtbGen.creareSablonNC(14,c421,c4312);
		SablonNC sab15= instantaCtbGen.creareSablonNC(15,c421,c444);
		SablonNC sab16= instantaCtbGen.creareSablonNC(16,c645,c4313);
		SablonNC sab17= instantaCtbGen.creareSablonNC(17,c645,c4371);
		SablonNC sab18= instantaCtbGen.creareSablonNC(18,c645,c4311);
		SablonNC sab19= instantaCtbGen.creareSablonNC(19,c645,c4315);
		SablonNC sab20= instantaCtbGen.creareSablonNC(20,c645,c4316);
		
//		regSablonNC.addSablon(sab0);
//		regSablonNC.addSablon(sabl);
//		regSablonNC.addSablon(sab2);
//		regSablonNC.addSablon(sab3);
//		regSablonNC.addSablon(sab4);
//		regSablonNC.addSablon(sab7);
//		regSablonNC.addSablon(sab8);
//		regSablonNC.addSablon(sab9);
//		regSablonNC.addSablon(sab10);
//		
//		regSablonNC.addSablon(sab11);
//		regSablonNC.addSablon(sab12);
//		regSablonNC.addSablon(sab13);
//		regSablonNC.addSablon(sab14);
//		regSablonNC.addSablon(sab15);
//		regSablonNC.addSablon(sab16);
//		regSablonNC.addSablon(sab17);
//		regSablonNC.addSablon(sab18);
//		regSablonNC.addSablon(sab19);
//		regSablonNC.addSablon(sab20);
		//----------------------am scos id de la tip/// NU EXISTA 303 603 601
		
		TipContabil tipContabil = instantaCtbGen.creareTipMaterial(null, "Materii prime",instantaCtbGen.getContDupaSimbol("301"), 
				instantaCtbGen.getContDupaSimbol("401"), instantaCtbGen.getContDupaSimbol("601"));	
		
		TipContabil tipContabil2 = instantaCtbGen.creareTipMaterial(null, "Materiale", c303, 
               c401,  c603);
		TipContabil tipContabil3 = instantaCtbGen.creareTipMaterial(null,"Cheltuieli cu terti", c628, 
				         c401,  c628);
		TipContabil tipContabi4 = instantaCtbGen.creareTipMaterial(null,"Marfuri", c307, 
               c401,  c607);	
		
		TipContabil tipContabil5 = instantaCtbGen.creareTipMaterial(null,"Produse finite", c345, 
                c711,  c711);	
		
//		regTipContabile.addTipContabil(tipContabil);
//		regTipContabile.addTipContabil(tipContabil2);
//		regTipContabile.addTipContabil(tipContabil3);
//		regTipContabile.addTipContabil(tipContabi4);
//		regTipContabile.addTipContabil(tipContabil5);
		
		//-----------------------------
		
		
		LunaLucru luna=instantaCtbGen.getOrCreateLuna(Calendar.getInstance().getTime());
		//RegBalanta regBalante= instantaCtbGen.
		//regBalante.addBalanta(new Balanta(luna,instantaCtbGen.getContDupaSimbol("301"),100.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,false));
	}

	@Before
	public void setUp() throws Exception {	
		logger.info("Intiere Test");		
	}
 
   
// asta era o metoda care centraliza testele, iar testele erau simple metode
//	@Test
//	public void declanseaza(){
//		TestJurnalizareVanzare();
//		TestJurnalizareAchizitie();
//		TestJurnalizareIncasare();
//		TestJurnalizarePlata();
//		TestJurnalizareConsum();
//		TestJurnalizareProductie();
//		TestJurnalizareSalarii();
//		TestInchideLuna();
//	}		
	
	//-------------------------------------------------
	
	@Test
	public void TestJurnalizareVanzare(){
		logger.info("Begin test: TestjurnalizareVanzare");

		//creare matrice listMatVal
		
		//transmite sa faca o metoda publica in NomSrv, nu este,
		
		Material mat1= new Material();
		mat1.setTipContabil("Materii prime");
		LinieDocument lmv1=new LinieDocument(1,null,mat1,10.0,5.0,0.0);
		List<LinieDocument> listaMat = new ArrayList <LinieDocument>();
		listaMat.add(lmv1);
		
		//-------------------------------------	
		
		Calendar cal = Calendar.getInstance();
		Date data= cal.getTime();
		try {
			instantaCtbGen.jurnalizareVanzare(data, 1200.0,0.0, 501, 1001, listaMat, StareDocument.NOU, null);
		} catch (CtbException e) {
			logger.error("Jurnalizare vanzari nu s-a efectuat "+ e.getMessage());
			
			System.out.println(e.getMessage());
		}
		
		logger.info("End test: TestjurnalizareVanzare");
	}
	//--------------------------------------------------------------------
	@Test
	public void TestJurnalizareAchizitie(){
		logger.info("Begin test: TestJurnalizareAchizitie");
		
	
		//creare matrice listMatVal
		Material mat1= new Material();
		mat1.setTipContabil("Materii prime");
		LinieDocument lmv1=new LinieDocument(1,null,mat1,10.0,5.0,0.0);
		Material mat2= new Material();
		mat2.setTipContabil("Cheltuieli cu terti");
		LinieDocument lmv2=new LinieDocument(1,null,mat2,20.0,10.0,0.0);
		List<LinieDocument> listaMat = new ArrayList <LinieDocument>();
		listaMat.add(lmv1);
		listaMat.add(lmv2);
	
		//-------------------------------------	
		
		Calendar cal = Calendar.getInstance();
		Date data= cal.getTime();
		try {
			instantaCtbGen.jurnalizareAchizitie(data, 370.0,0.0, 501, 1001, listaMat, StareDocument.NOU, null);
		} catch (CtbException e) {
			logger.error("Jurnalizare achizitie nu s-a efectuat "+ e.getMessage());
		}
		
		logger.info("End test: TestjurnalizareAchizitie");
	}
	
	//-------------------------------------------------------------
	@Test
	public void TestJurnalizareIncasare() {
		logger.info("Begin test: TestJurnalizareIncasare");
		
					
		Calendar cal = Calendar.getInstance();
		 Date data= cal.getTime();
		try {
			instantaCtbGen.jurnalizareIncasare(data,1200.0, 501, TipIncasare.EXTRAS, 50, "401", StareDocument.NOU, null);
		} catch (CtbException e) {
			logger.error("Jurnalizare incasare nu s-a efectuat "+ e.getMessage());
		}
		
		logger.info("End test: TestJurnalizareIncasare");
	}
	
	
	@Test
	public void TestJurnalizarePlata() {
		logger.info("Begin test: TestJurnalizarePlata");
		
	//-------------------------------------------------			
		Calendar cal = Calendar.getInstance();
		 Date data= cal.getTime();
		try {
			instantaCtbGen.jurnalizarePlata(data,1200.0, 501, TipPlata.BANCA, 50, "628", StareDocument.NOU, null);
		} catch (CtbException e) {
			logger.error("Jurnalizare plata nu s-a efectuat "+ e.getMessage());
		}
		
		logger.info("End test: TestJurnalizarePlata");
	}

	//--------------------------------------------------
	
	@Test	
	public void TestJurnalizareConsum(){
		logger.info("Begin test: TestJurnalizareConsum");
	
		//creare matrice listMatVal
		Material mat1= new Material();
		 mat1.setTipContabil("Materii prime");
		LinieDocument lmv1=new LinieDocument(1,null,mat1,10.0,5.0,0.0);
		List<LinieDocument> listaMat = new ArrayList <LinieDocument>();
		listaMat.add(lmv1);
		
		//-------------------------------------	
		
		Calendar cal = Calendar.getInstance();
		Date data= cal.getTime();
		try {
			instantaCtbGen.jurnalizareConsum(data,  501,  listaMat, StareDocument.NOU, null);
		} catch (CtbException e) {
			logger.error("Jurnalizare consum nu s-a efectuat "+ e.getMessage());
		}
		
		logger.info("End test: TestJurnalizareConsum");
	}
	
	//---------------------------------------------------------
	
	@Test
	public void TestJurnalizareProductie(){
		logger.info("Begin test: TestJurnalizareProductie");
	
		//creare matrice listMatVal
		Material mat1= new Material();
		 mat1.setTipContabil("Produse finite");
		LinieDocument lmv1=new LinieDocument(1,null,mat1,10.0,5.0,0.0);
		List<LinieDocument> listaMat = new ArrayList <LinieDocument>();
		listaMat.add(lmv1);
			
		
		Calendar cal = Calendar.getInstance();
		Date data= cal.getTime();
		try {
			instantaCtbGen.jurnalizareProductie(data,  475,  listaMat, StareDocument.NOU, null);
		} catch (CtbException e) {
			logger.error("Jurnalizare productie nu s-a efectuat "+ e.getMessage());
		}
		
		logger.info("End test: TestJurnalizareProductie");
	}
	//---------------------------------------------------------
	
	@Test
	public void TestJurnalizareSalarii(){
		logger.info("Begin test: TestJurnalizareSalarii");
	
		
		Calendar cal = Calendar.getInstance();
		Date data= cal.getTime();
		try {
			instantaCtbGen.jurnalizareSalarii(data,  8, 1500.0,150.0,10.0,240.0,200.0,145.0,10.0,500.0,30.0,80.0, StareDocument.NOU, null);
		} catch (CtbException e) {
			logger.error("Jurnalizare salarii nu s-a efectuat "+ e.getMessage());
		}
		
		logger.info("End test: TestJurnalizareSalarii");
	}
	
	//-------------------------------------------------------
	
	@Test
	public void TestInchideLuna(){
		logger.info("Begin test: TestInchideLuna");
		
		LunaLucru luna=instantaCtbGen.getOrCreateLuna(Calendar .getInstance().getTime());
		//System.out.print(luna.toString());
		try {
			instantaCtbGen.inchideLuna(luna);
		} catch (CtbException e) {
			logger.error("Inchidere luna nu s-a efectuat "+ e.getMessage());
			System.out.println(e.getMessage());
		}
		//RegBalanta.instantiaza().printAll();		
		logger.info("End test: TestInchideLuna");
		
	}
	
	//--------------------------------------------------------------
	@Test
	public void TestverificaLunaInchisa(){
		logger.info("Begin test: TestverificaLunaInchisa");
		String s;
	    s=instantaCtbGen.verificaLunaInchisa(Calendar .getInstance().getTime());
	    logger.debug("Luna pentru " +Calendar .getInstance().getTime().toString()+" este "+s);
				
		logger.info("End test: TestInchideLuna");
		
	}
	
	@Test
	public void TestAnuleazaInchidere(){
		logger.info("Begin test: TestAnuleazaInchidere");
		
		LunaLucru luna=instantaCtbGen.getOrCreateLuna(Calendar .getInstance().getTime());
		luna.anuleazaInchidere();
	    instantaCtbGen.anuleazaInchidere(luna);
	    
	    logger.debug("Luna pentru " +Calendar .getInstance().getTime().toString()+" este: "+luna.getStatus().toString());
				
		logger.info("End test: TestAnuleazaInchidere");
		
	}
	
	@Test
	public void TestListaTipuriCtb(){
		logger.info("Begin test: TestListaTipuriCtb");
		
		List<String> ltp= new ArrayList<String>();
		ltp=instantaCtbGen.getTipuriContabile();
		//este deja completata de la celelalte teste
		for (String l : ltp){
			logger.debug("un tip: "+l.toString());
		}
	        	
		logger.info("End test: TestListaTipuriCtb");
		
	}

}
