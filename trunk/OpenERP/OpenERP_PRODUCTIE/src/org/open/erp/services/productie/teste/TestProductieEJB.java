/**
 * 
 */
package org.open.erp.services.productie.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Properties;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.MijlocFix;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.productie.ComandaProductie;
import org.open.erp.services.productie.CriteriuCalitate;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FluxProductie;
import org.open.erp.services.productie.FunctieNecesara;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.Semifabricat;
import org.open.erp.services.productie.Utilaj;
import org.open.erp.services.stocuri.ArticolStoc;
import org.open.erp.services.stocuri.CerereAprovizionare;
import org.open.erp.services.stocuri.StocuriSrv;

/**
 * @author Echipa Productie
 *
 */
	
public class TestProductieEJB {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestProductie.class.getName());
	private static ProductieSrv productie;
	private static NomenclatoareSrv nomenclatoare;
	private static StocuriSrv stocuri;
	
	@BeforeClass
	 public static void setUpBeforeClass() throws Exception {
		InitialContext ctx = initJBossJNDICtx();
		productie = (ProductieSrv)ctx.lookup("ProductieSrv/remote");
		logger.info("initTest " + productie);
		
	 }

	 private static InitialContext initJBossJNDICtx() throws NamingException {
		 Properties props = new Properties();
	        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
	props.put("java.naming.provider.url", "jnp://localhost:1099/");
	props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
	        return new InitialContext(props);
	}

	 @Test
	 public void testDefinireFluxProductie () throws Exception{

			logger.info("Begin test: definireFlux");
		 
		 Produs produs = new Produs();
		 produs=nomenclatoare.cautareProdusDupaDenumire("produs");
		 
		 FluxProductie flux = productie.definireFluxProductie(1, produs);
		 
		 logger.info("Fluxul cu id: " + flux.getIdFlux() + " a fost creat!");
			
			assertNotNull("Flux ne-validat!", flux.getIdFlux());
			
			flux = productie.getFlux(flux.getIdFlux());
				
			assertNotNull("Nu exista flux nou!", flux);
			logger.info("End test: definireFlux");
		 
		 
		 
		}
	 
	 @Test
	 public void testDefinireFazaProductie () throws Exception{
		 
		 logger.info("Begin test: definireFaza");
		 
		 Produs produs = new Produs();
		 produs=nomenclatoare.cautareProdusDupaDenumire("produs");
		 
		 FluxProductie flux = productie.definireFluxProductie(1, produs);
		 
		 logger.info("Fluxul cu id: " + flux.getIdFlux() + " a fost creat!");
			
			assertNotNull("Flux ne-validat!", flux.getIdFlux());
			
			flux = productie.getFlux(flux.getIdFlux());
				
			assertNotNull("Nu exista flux nou!", flux);
			logger.info("End test: definireFlux");
						
			MijlocFix mf;
			FazaProductie fz;
			Utilaj u;
			Double timp;
			ArrayList<FunctieNecesara> functiiNecesare;
			ArrayList<Angajat> angajati;
			ArrayList <Material> materialeReteta;
			ArrayList <Material> materialeSemifabricat;
			Semifabricat semifabricatContinut;
			Semifabricat semifabricatReteta;
			Produs pDorit;
			Semifabricat sDorit;
					
					//setez un mijloc fix;
					mf=new MijlocFix();
					mf.setId(1);
					mf.setDenumire("Utilaj");
					mf.setAdresa(null);
					mf.setTermenExploatare(null);
					mf.setValoare(null);
					logger.info("Mijlocul fix a fost creat " + mf.getDenumire());
					//Setez utilajul;
					u =new Utilaj();
					u.setUtilaj(mf);
					u.setStatus("ocupat");
					//setez timpul de folosire al utilajului;
					logger.info("Utilajul a fost creat " + u);
					timp= 10.00;
				
					//selectez sectia in care se desfasoara faza curenta
					Divizie sectie= new Divizie();
					sectie.setId(1);				
					sectie.setDenumire("Sectie Productie");
					sectie.setIdDepartament(null);
					sectie.setAtributii(null);
					logger.info("Sectia a fost creata " + sectie.getDenumire());
					
					
					//adaugarea functiilor necesare pentru angajati	
					FunctieNecesara f1=new FunctieNecesara();
									
					f1.setIdFunctie(1);
					f1.setNumeFunctie("Functie 1");
					f1.setAptitudini(null);
					f1.setCunostinte(null);
					f1.setDeprinderi(null);
					f1.setResponsabilitati(null);
					f1.setObiective(null);
					f1.setPozitiaInCOR(null);
					f1.setNrAngajatiFunctie(1);
					
					FunctieNecesara f2=new FunctieNecesara();
					f2.setIdFunctie(1);
					f2.setNumeFunctie("Functie 2");
					f2.setAptitudini(null);
					f2.setCunostinte(null);
					f2.setDeprinderi(null);
					f2.setResponsabilitati(null);
					f2.setObiective(null);
					f2.setPozitiaInCOR(null);
					f2.setNrAngajatiFunctie(1);
					
					functiiNecesare =new ArrayList<FunctieNecesara>();
					functiiNecesare.add(f1);
					functiiNecesare.add(f2);
					logger.info("Lista de functii a fost creata " + functiiNecesare);
				
					
				//lista materialelor pe care le-am luat din baza de date
				//sau in cazul de fata, lista materialelor definite local
				//lista materialelor din reteta
					materialeReteta = new ArrayList<Material>();
					Material m3=new Material();
					Material m4=new Material();
					
					m3.setIdMaterial(1);
					m3.setDenumire("material1");
					m3.setCategorie(null);
					m3.setUM(null);
					m3.setTipContabil(null);
					logger.info("Materialul a fost creat " + m3);
					m4.setIdMaterial(2);
					m4.setDenumire("material2");
					m4.setCategorie(null);
					m4.setUM(null);
					m4.setTipContabil(null);
					logger.info("Materialul a fost creat " + m4);
					materialeReteta.add(m3);
					materialeReteta.add(m4);
					logger.info("Lista cu materialele retetei a fost creata " + materialeReteta);
					
					
						sDorit=new Semifabricat();
						String denSemifabricatDorit = "semifabricat";
						ArrayList<Material> materialeSemifabricatDorit = new ArrayList<Material>();
						Material m7=new Material();
						Material m8=new Material();
						m7.setIdMaterial(3);
						m7.setDenumire("material3");
						m7.setCategorie(null);
						m7.setUM(null);
						m7.setTipContabil(null);
						
						m8.setIdMaterial(4);
						m8.setDenumire("material4");
						m8.setCategorie(null);
						m8.setUM(null);
						m8.setTipContabil(null);
				
						materialeSemifabricatDorit.add(m7);
						materialeSemifabricatDorit.add(m8);
						
						semifabricatContinut=null;
						sDorit.setDenumire(denSemifabricatDorit);
						sDorit.setListaMateriale(materialeSemifabricatDorit);
						sDorit.setSemifabricatContinut(semifabricatContinut);
						
						logger.info("Semifabricatul dorit este: " + sDorit);
						
					
						pDorit=new Produs();
						pDorit.setId(1);
						pDorit.setDenumire("Produs nou");
						pDorit.setDataFabricatiei(null);
						pDorit.setTermenValabilitate(null);
						pDorit.setUnitateMasura(null);
						logger.info("Produsul dorit este: " + pDorit);
						
						
		FazaProductie faza=productie.definireFazaProductie("faza test", flux, u, timp, functiiNecesare, materialeReteta, sDorit, pDorit, sectie, 1, false);
		
		logger.info("End test: definireFaza");
	
	 }
			
	 public void testComandaMateriale() throws Exception{
		logger.info("----START test: comandaMateriale ---");
		 Produs produs = new Produs();
		 produs=nomenclatoare.cautareProdusDupaDenumire("produs");
		 
		 FluxProductie flux = productie.definireFluxProductie(1, produs);
		 
		 logger.info("Fluxul cu id: " + flux.getIdFlux() + " a fost creat!");
			
			assertNotNull("Flux ne-validat!", flux.getIdFlux());
			
			flux = productie.getFlux(flux.getIdFlux());
				
			assertNotNull("Nu exista flux nou!", flux);
			logger.info("End test: definireFlux");
						
			MijlocFix mf;
			FazaProductie fz;
			Utilaj u;
			Double timp;
			ArrayList<FunctieNecesara> functiiNecesare;
			ArrayList<Angajat> angajati;
			ArrayList <Material> materialeReteta;
			ArrayList <Material> materialeSemifabricat;
			Semifabricat semifabricatContinut;
			Semifabricat semifabricatReteta;
			Produs pDorit;
			Semifabricat sDorit;
					
					//setez un mijloc fix;
					mf=new MijlocFix();
					mf.setId(1);
					mf.setDenumire("Utilaj");
					mf.setAdresa(null);
					mf.setTermenExploatare(null);
					mf.setValoare(null);
					logger.info("Mijlocul fix a fost creat " + mf.getDenumire());
					//Setez utilajul;
					u =new Utilaj();
					u.setUtilaj(mf);
					u.setStatus("ocupat");
					//setez timpul de folosire al utilajului;
					logger.info("Utilajul a fost creat " + u);
					timp= 10.00;
				
					//selectez sectia in care se desfasoara faza curenta
					Divizie sectie= new Divizie();
					sectie.setId(1);				
					sectie.setDenumire("Sectie Productie");
					sectie.setIdDepartament(null);
					sectie.setAtributii(null);
					logger.info("Sectia a fost creata " + sectie.getDenumire());
					
					
					//adaugarea functiilor necesare pentru angajati	
					FunctieNecesara f1=new FunctieNecesara();
									
					f1.setIdFunctie(1);
					f1.setNumeFunctie("Functie 1");
					f1.setAptitudini(null);
					f1.setCunostinte(null);
					f1.setDeprinderi(null);
					f1.setResponsabilitati(null);
					f1.setObiective(null);
					f1.setPozitiaInCOR(null);
					f1.setNrAngajatiFunctie(1);
					
					FunctieNecesara f2=new FunctieNecesara();
					f2.setIdFunctie(1);
					f2.setNumeFunctie("Functie 2");
					f2.setAptitudini(null);
					f2.setCunostinte(null);
					f2.setDeprinderi(null);
					f2.setResponsabilitati(null);
					f2.setObiective(null);
					f2.setPozitiaInCOR(null);
					f2.setNrAngajatiFunctie(1);
					
					functiiNecesare =new ArrayList<FunctieNecesara>();
					functiiNecesare.add(f1);
					functiiNecesare.add(f2);
					logger.info("Lista de functii a fost creata " + functiiNecesare);
				
					
				//lista materialelor pe care le-am luat din baza de date
				//sau in cazul de fata, lista materialelor definite local
				//lista materialelor din reteta
					materialeReteta = new ArrayList<Material>();
					Material m3=new Material();
					Material m4=new Material();
					
					m3.setIdMaterial(1);
					m3.setDenumire("material1");
					m3.setCategorie(null);
					m3.setUM(null);
					m3.setTipContabil(null);
					logger.info("Materialul a fost creat " + m3);
					m4.setIdMaterial(2);
					m4.setDenumire("material2");
					m4.setCategorie(null);
					m4.setUM(null);
					m4.setTipContabil(null);
					logger.info("Materialul a fost creat " + m4);
					materialeReteta.add(m3);
					materialeReteta.add(m4);
					logger.info("Lista cu materialele retetei a fost creata " + materialeReteta);
					
					
						sDorit=new Semifabricat();
						String denSemifabricatDorit = "semifabricat";
						ArrayList<Material> materialeSemifabricatDorit = new ArrayList<Material>();
						Material m7=new Material();
						Material m8=new Material();
						m7.setIdMaterial(3);
						m7.setDenumire("material3");
						m7.setCategorie(null);
						m7.setUM(null);
						m7.setTipContabil(null);
						
						m8.setIdMaterial(4);
						m8.setDenumire("material4");
						m8.setCategorie(null);
						m8.setUM(null);
						m8.setTipContabil(null);
				
						materialeSemifabricatDorit.add(m7);
						materialeSemifabricatDorit.add(m8);
						
						semifabricatContinut=null;
						sDorit.setDenumire(denSemifabricatDorit);
						sDorit.setListaMateriale(materialeSemifabricatDorit);
						sDorit.setSemifabricatContinut(semifabricatContinut);
						
						logger.info("Semifabricatul dorit este: " + sDorit);
						
					
						pDorit=new Produs();
						pDorit.setId(1);
						pDorit.setDenumire("Produs nou");
						pDorit.setDataFabricatiei(null);
						pDorit.setTermenValabilitate(null);
						pDorit.setUnitateMasura(null);
						logger.info("Produsul dorit este: " + pDorit);
						
						
		FazaProductie faza=productie.definireFazaProductie("faza test", flux, u, timp, functiiNecesare, materialeReteta, sDorit, pDorit, sectie, 1, false);
		
		logger.info("End test: definireFaza");
		
		
		productie.comandaMateriale(faza, flux);
		
		logger.info("----END test: comandaMateriale ---");
			
	}		
	 
	 
	public void testFabricareProdus() throws Exception {
		logger.info("----START test: fabricareProdus ---");
		 Produs produs = new Produs();
		 produs=nomenclatoare.cautareProdusDupaDenumire("produs");
		 
		 FluxProductie flux = productie.definireFluxProductie(1, produs);
		 
		 logger.info("Fluxul cu id: " + flux.getIdFlux() + " a fost creat!");
			
			assertNotNull("Flux ne-validat!", flux.getIdFlux());
			
			flux = productie.getFlux(flux.getIdFlux());
				
			assertNotNull("Nu exista flux nou!", flux);
			
			productie.fabricare(produs, 1);
	}
	 
	 
	 

	@Test	
	 public void testConsumResursa() throws Exception{
		
		
			logger.info("----INCEPERE TEST CONSUM RESURSE----");
			 Produs produs = new Produs();
			 produs=nomenclatoare.cautareProdusDupaDenumire("produs");
			 
			 FluxProductie flux = productie.definireFluxProductie(1, produs);
			 
			 logger.info("Fluxul cu id: " + flux.getIdFlux() + " a fost creat!");
				
				assertNotNull("Flux ne-validat!", flux.getIdFlux());
				
				flux = productie.getFlux(flux.getIdFlux());
					
				assertNotNull("Nu exista flux nou!", flux);
				
			 
			 MijlocFix mf;
				FazaProductie fz;
				Utilaj u;
				Double timp;
				ArrayList<FunctieNecesara> functiiNecesare;
				ArrayList<Angajat> angajati;
				ArrayList <Material> materialeReteta;
				ArrayList <Material> materialeSemifabricat;
				Semifabricat semifabricatContinut;
				Semifabricat semifabricatReteta;
				Produs pDorit;
				Semifabricat sDorit;
						
						//setez un mijloc fix;
						mf=new MijlocFix();
						mf.setId(1);
						mf.setDenumire("Utilaj");
						mf.setAdresa(null);
						mf.setTermenExploatare(null);
						mf.setValoare(null);
						logger.info("Mijlocul fix a fost creat " + mf.getDenumire());
						//Setez utilajul;
						u =new Utilaj();
						u.setUtilaj(mf);
						u.setStatus("ocupat");
						//setez timpul de folosire al utilajului;
						logger.info("Utilajul a fost creat " + u);
						timp= 10.00;
					
						//selectez sectia in care se desfasoara faza curenta
						Divizie sectie= new Divizie();
						sectie.setId(1);				
						sectie.setDenumire("Sectie Productie");
						sectie.setIdDepartament(null);
						sectie.setAtributii(null);
						logger.info("Sectia a fost creata " + sectie.getDenumire());
						
						
						//adaugarea functiilor necesare pentru angajati	
						FunctieNecesara f1=new FunctieNecesara();
										
						f1.setIdFunctie(1);
						f1.setNumeFunctie("Functie 1");
						f1.setAptitudini(null);
						f1.setCunostinte(null);
						f1.setDeprinderi(null);
						f1.setResponsabilitati(null);
						f1.setObiective(null);
						f1.setPozitiaInCOR(null);
						f1.setNrAngajatiFunctie(1);
						
						FunctieNecesara f2=new FunctieNecesara();
						f2.setIdFunctie(1);
						f2.setNumeFunctie("Functie 2");
						f2.setAptitudini(null);
						f2.setCunostinte(null);
						f2.setDeprinderi(null);
						f2.setResponsabilitati(null);
						f2.setObiective(null);
						f2.setPozitiaInCOR(null);
						f2.setNrAngajatiFunctie(1);
						
						functiiNecesare =new ArrayList<FunctieNecesara>();
						functiiNecesare.add(f1);
						functiiNecesare.add(f2);
						logger.info("Lista de functii a fost creata " + functiiNecesare);
					
						
					//lista materialelor pe care le-am luat din baza de date
					//sau in cazul de fata, lista materialelor definite local
					//lista materialelor din reteta
						materialeReteta = new ArrayList<Material>();
						Material m3=new Material();
						Material m4=new Material();
						
						m3.setIdMaterial(1);
						m3.setDenumire("material1");
						m3.setCategorie(null);
						m3.setUM(null);
						m3.setTipContabil(null);
						logger.info("Materialul a fost creat " + m3);
						m4.setIdMaterial(2);
						m4.setDenumire("material2");
						m4.setCategorie(null);
						m4.setUM(null);
						m4.setTipContabil(null);
						logger.info("Materialul a fost creat " + m4);
						materialeReteta.add(m3);
						materialeReteta.add(m4);
						logger.info("Lista cu materialele retetei a fost creata " + materialeReteta);
						
						
							sDorit=new Semifabricat();
							String denSemifabricatDorit = "semifabricat";
							ArrayList<Material> materialeSemifabricatDorit = new ArrayList<Material>();
							Material m7=new Material();
							Material m8=new Material();
							m7.setIdMaterial(3);
							m7.setDenumire("material3");
							m7.setCategorie(null);
							m7.setUM(null);
							m7.setTipContabil(null);
							
							m8.setIdMaterial(4);
							m8.setDenumire("material4");
							m8.setCategorie(null);
							m8.setUM(null);
							m8.setTipContabil(null);
					
							materialeSemifabricatDorit.add(m7);
							materialeSemifabricatDorit.add(m8);
							
							semifabricatContinut=null;
							sDorit.setDenumire(denSemifabricatDorit);
							sDorit.setListaMateriale(materialeSemifabricatDorit);
							sDorit.setSemifabricatContinut(semifabricatContinut);
							
							logger.info("Semifabricatul dorit este: " + sDorit);
							
						
							pDorit=new Produs();
							pDorit.setId(1);
							pDorit.setDenumire("Produs nou");
							pDorit.setDataFabricatiei(null);
							pDorit.setTermenValabilitate(null);
							pDorit.setUnitateMasura(null);
							logger.info("Produsul dorit este: " + pDorit);
			 
							FazaProductie faza=productie.definireFazaProductie("faza test", flux, u, timp, functiiNecesare, materialeReteta, sDorit, pDorit, sectie, 1, false);
							
			productie.consumResursa(faza, produs);
			
			logger.info("---END testConsumResurse");
		 }
	
	@Test
	public void testControlCalitate() throws Exception
	{
		logger.info("INCEPERE TEST CONTROL CALITATE");
		
		Produs produs = new Produs();
		produs=nomenclatoare.cautareProdusDupaDenumire("produs");
		
		productie.controlCalitate(produs);
	
		logger.info("---END TEST CONTROL CALITATE");
		
}
	
@Test	
public void testLivrareProdus() throws Exception{
	logger.info("INCEPERE TEST LIVRARE PRODUS");
	
	Produs produs = new Produs();
	produs=nomenclatoare.cautareProdusDupaDenumire("produs");
	ComandaProductie comanda = new ComandaProductie();
	Integer cantitateProdus = comanda.getCantitate();
	
	productie.livrareProdus(cantitateProdus, produs);
	
	logger.info("----END TEST LIVRARE PRODUS");
	
	 }

@Test
public void testInregistrareGestiuneConsum() throws Exception{
	logger.info("INCEPERE TEST INREGISTRARE GESTIUNE CONSUM");
	testConsumResursa();
	logger.info("Consum resurse a fost inregistrat");
	
	logger.info("SFARSIT TEST INREGISTRARE GESTIUNE CONSUM");
}


@Test
public void testInregistrareGestiuneProductie() throws Exception{
	logger.info("INCEPERE TEST INREGISTRARE GESTIUNE PRODUCTIE");
	testControlCalitate();
	logger.info("Produsele au fost inregistrate");
	logger.info("SFARSIT TEST INREGISTRARE GESTIUNE PRODUCTIE");
	}
}

