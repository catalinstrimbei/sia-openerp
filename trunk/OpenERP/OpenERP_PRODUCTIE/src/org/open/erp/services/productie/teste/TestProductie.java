/**
 * 
 */
package org.open.erp.services.productie.teste;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.Document;
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
//import org.open.erp.services.stocuri.ArticolStoc;
//import org.open.erp.services.stocuri.StocuriSrv;

/**
 * @author Echipa Productie
 *
 */
	
public class TestProductie {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestProductie.class.getName());
	ProductieSrv productie;
	NomenclatoareSrv nomenclatoare;
	//StocuriSrv stocuri;
	@BeforeClass
	 public static void setUpBeforeClass() throws Exception {
	 }

	 @Before
	 public void setUp() throws Exception {
	 }
	 
	 @Test
	 public void testDefinireFluxProductie () {
	 logger.debug(">>>>>>>>>>>> START definire flux");	
	 	Produs produsNou = new Produs();
		 produsNou.setIdMaterial(1);
		 produsNou.setDenumire("Produs nou");
		 produsNou.setUnitateMasura(null);
		 produsNou.setDataFabricatiei(null);
		 produsNou.setTermenValabilitate(null);
		 logger.debug("*****A fost creat un nou produs: " + produsNou.getDenumire());
		FluxProductie flux = new FluxProductie(1,produsNou);
		
		logger.debug(">>>>>>>>>>>> END definire flux cu id:" + flux.getIdFlux());	
		 }
	
	 @Test
	public void testDefinireFazaProductie() throws Exception{
		logger.debug(">>>>>>>>>>>> START definire faza");
		
		String faza1;
		FluxProductie flux;
		Utilaj utilaj;
		Double timpFolosire;
		ArrayList<FunctieNecesara> functiiNecesare;
		ArrayList<Material> materialeReteta;
		Semifabricat semifabricatDorit = null;
		Produs produsDorit;
		Divizie sectie;
		Integer nrOrdine;
		Boolean isFinal;
		
		//flux
		
		 Produs produsNou = new Produs();
		 produsNou.setIdMaterial(1);
		 produsNou.setDenumire("Produs nou");
		 produsNou.setUnitateMasura(null);
		 produsNou.setDataFabricatiei(null);
		 produsNou.setTermenValabilitate(null);
		 
		 ArrayList<FazaProductie> faze = new ArrayList<FazaProductie>();

		 
		 logger.debug("*****A fost creat un nou produs: " + produsNou.getDenumire());
		 flux = new FluxProductie(1,produsNou);

		 //faza
		faza1="Faza 1";
		//faza2="Faza2";
		
		//utilaj
		MijlocFix mf=new MijlocFix();
		mf.setId(1);
		mf.setDenumire("Utilaj");
		mf.setAdresa(null);
		mf.setTermenExploatare(null);
		mf.setValoare(null);
		logger.info("*****Mijlocul fix a fost creat " + mf.getDenumire());
		//Setez utilajul;
		utilaj =new Utilaj();
		utilaj.setUtilaj(mf);
		utilaj.setStatus("ocupat");
		
		//timp folosire
		timpFolosire=  10.00;
		
		
		//functii necesare
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
				
		functiiNecesare = new ArrayList<FunctieNecesara>();
		functiiNecesare.add(f1);
		functiiNecesare.add(f2);
		logger.info("*****Lista de functii a fost creata " + functiiNecesare);
		
		// materiale reteta
		materialeReteta = new ArrayList<Material>();
		Material m3=new Material();
		Material m4=new Material();
		
		m3.setIdMaterial(1);
		m3.setDenumire("material1");
		m3.setCategorie(null);
		m3.setLiniiDocumente(null);
		m3.setProd(null);
		m3.setTipContabil(null);
		m3.setUM(null);
		logger.info("*****Materialul a fost creat " + m3);
				
		m4.setIdMaterial(2);
		m4.setDenumire("material2");
		m4.setCategorie(null);
		m4.setLiniiDocumente(null);
		m4.setProd(null);
		m4.setTipContabil(null);
		m4.setUM(null);
		logger.info("*****Materialul a fost creat " + m4);

		materialeReteta.add(m3);
		materialeReteta.add(m4);
		logger.info("*****Lista cu materialele retetei a fost creata " + materialeReteta);
		
		//semifabricat dorit
		Semifabricat sDorit=new Semifabricat();
		String denSemifabricatDorit = "semifabricat";
		ArrayList<Material> materialeSemifabricatDorit = new ArrayList<Material>();
		Material m7=new Material();
		Material m8=new Material();
		m7.setIdMaterial(3);
		m7.setDenumire("material3");
		m7.setCategorie(null);
		m7.setLiniiDocumente(null);
		m7.setProd(null);
		m7.setTipContabil(null);
		m7.setUM(null);
		
		m8.setIdMaterial(4);
		m8.setDenumire("material4");
		m8.setCategorie(null);
		m8.setLiniiDocumente(null);
		m8.setProd(null);
		m8.setTipContabil(null);
		m8.setUM(null);
				
		materialeSemifabricatDorit.add(m7);
		materialeSemifabricatDorit.add(m8);
		
		//produs dorit
		produsDorit=new Produs();
		produsDorit.setIdMaterial(1);
		produsDorit.setDenumire("Produs nou");
		produsDorit.setUnitateMasura(null);
		produsDorit.setDataFabricatiei(null);
		produsDorit.setTermenValabilitate(null);
		logger.info("*****Produsul dorit este: " + produsDorit);
		
		//sectie
		sectie= new Divizie();
		sectie.setId(1);				
		sectie.setDenumire("Sectie Productie");
		sectie.setIdDepartament(null);
		sectie.setAtributii(null);
		logger.info("*****Sectia a fost creata " + sectie.getDenumire());
		
		nrOrdine =1;
		isFinal= false;
			
		FazaProductie fazaProductie = new FazaProductie(faza1, utilaj, timpFolosire, functiiNecesare, materialeReteta, semifabricatDorit, produsDorit, sectie, nrOrdine, isFinal);
		//FazaProductie fazaProductie2 = new FazaProductie(faza2, utilaj, timpFolosire, functiiNecesare, materialeReteta, semifabricatDorit, produsDorit, sectie, nrOrdine, isFinal);
		
		
		fazaProductie.setFlux(flux);
		flux.adaugaFaza(fazaProductie);

		faze.add(fazaProductie);
			
		ArrayList<Angajat> listaAngajati = new ArrayList<Angajat>();
	    for (int f=0;f<functiiNecesare.size();f++){
			int nrAngajati=functiiNecesare.get(f).getNrAngajatiFunctie();
			
			for(int a=1;a<=nrAngajati;a++){
				Angajat angajat =new Angajat();
					
				//ar trebui o metoda 'get angajat by functie'
				//angajat=personal.getAngajatById(a);
				angajat.setId(a);
			
				listaAngajati.add(angajat);
				
			}
			logger.debug("*****Angajatul a fost adaugat");
		}
	    
	    fazaProductie.setAngajati(listaAngajati);
	    logger.debug("*****Lista de angajati a fost adaugata in cadrul fazei!");
	    
	    Semifabricat semifabricatReteta = new Semifabricat();
	    if (nrOrdine==1&&isFinal==false)
	    {
	    	fazaProductie.setSemifabricatReteta(null);
	    	fazaProductie.setProdusDorit(null);	
	    }
	    else if (nrOrdine>1 && isFinal==false)
	    {
	    	
	    	FazaProductie fz = new FazaProductie();
	    	fz=productie.getFazaFlux(flux, nrOrdine);
	    	
	    	semifabricatReteta=fz.procesareSemifabricat();
	    	fazaProductie.setSemifabricatReteta(semifabricatReteta);
	    	fazaProductie.setProdusDorit(null);
	    	
	    }
	    
	    else if (nrOrdine==1&&isFinal==true){
	       	fazaProductie.setSemifabricatReteta(null);
	    	fazaProductie.setSemifabricatDorit(null);
	    }
	    else{
	    	FazaProductie fz = new FazaProductie();
	    	fz=productie.getFazaFlux(flux, nrOrdine);
	    	
	    	semifabricatReteta=fz.procesareSemifabricat();
	    	fazaProductie.setSemifabricatReteta(semifabricatReteta);
	    	fazaProductie.setSemifabricatDorit(null);
	    }
	    
		logger.debug(">>>>>>>>> END test creare faza: " + fazaProductie.getFaza());
		}
	 
	 
	 @Test
	 public void testGetFazaFlux() throws Exception{
			 
		 logger.info(">>>>>>>>>>>>START TEST getFazaFlux");
		 FluxProductie flux;
		 Produs produs = new Produs();
		 produs.setIdMaterial(1);
		 produs.setDenumire("Produs nou");
		 produs.setUnitateMasura(null);
		 produs.setDataFabricatiei(null);
		 produs.setTermenValabilitate(null);
		 flux=new FluxProductie(1, produs);
			
		 String faza1;
		 Utilaj utilaj;
		 Double timpFolosire;
		 ArrayList<FunctieNecesara> functiiNecesare;
		 ArrayList<Material> materialeReteta;
		 Semifabricat semifabricatDorit = null;
		 Produs produsDorit;
		 Divizie sectie;
		 Integer nrOrdine=1;
		 Boolean isFinal = true;
			
			//flux
			
			 Produs produsNou = new Produs();
			 produsNou.setIdMaterial(1);
			 produsNou.setDenumire("Produs nou");
			 produsNou.setUnitateMasura(null);
			 produsNou.setDataFabricatiei(null);
			 produsNou.setTermenValabilitate(null);
			 
			 ArrayList<FazaProductie> faze = new ArrayList<FazaProductie>();

			 
			 logger.debug("*****A fost creat un nou produs: " + produsNou.getDenumire());
			 flux = new FluxProductie(1,produsNou);

			 //faza
			faza1="Faza 1";
			//faza2="Faza2";
			
			//utilaj
			MijlocFix mf=new MijlocFix();
			mf.setId(1);
			mf.setDenumire("Utilaj");
			mf.setAdresa(null);
			mf.setTermenExploatare(null);
			mf.setValoare(null);
			logger.info("*****Mijlocul fix a fost creat " + mf.getDenumire());
			//Setez utilajul;
			utilaj =new Utilaj();
			utilaj.setUtilaj(mf);
			utilaj.setStatus("ocupat");
			
			//timp folosire
			timpFolosire=  10.00;
			
			
			//functii necesare
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
					
			functiiNecesare = new ArrayList<FunctieNecesara>();
			functiiNecesare.add(f1);
			functiiNecesare.add(f2);
			logger.info("*****Lista de functii a fost creata " + functiiNecesare);
			
			// materiale reteta
			materialeReteta = new ArrayList<Material>();
			Material m3=new Material();
			Material m4=new Material();
			
			m3.setIdMaterial(1);
			m3.setDenumire("material1");
			m3.setCategorie(null);
			m3.setLiniiDocumente(null);
			m3.setProd(null);
			m3.setTipContabil(null);
			m3.setUM(null);
			logger.info("*****Materialul a fost creat " + m3);
					
			m4.setIdMaterial(2);
			m4.setDenumire("material2");
			m4.setCategorie(null);
			m4.setLiniiDocumente(null);
			m4.setProd(null);
			m4.setTipContabil(null);
			m4.setUM(null);
			logger.info("*****Materialul a fost creat " + m4);

			materialeReteta.add(m3);
			materialeReteta.add(m4);
			logger.info("*****Lista cu materialele retetei a fost creata " + materialeReteta);
			
			//semifabricat dorit
			Semifabricat sDorit=new Semifabricat();
			String denSemifabricatDorit = "semifabricat";
			ArrayList<Material> materialeSemifabricatDorit = new ArrayList<Material>();
			Material m7=new Material();
			Material m8=new Material();
			m7.setIdMaterial(3);
			m7.setDenumire("material3");
			m7.setCategorie(null);
			m7.setLiniiDocumente(null);
			m7.setProd(null);
			m7.setTipContabil(null);
			m7.setUM(null);
			
			m8.setIdMaterial(4);
			m8.setDenumire("material4");
			m8.setCategorie(null);
			m8.setLiniiDocumente(null);
			m8.setProd(null);
			m8.setTipContabil(null);
			m8.setUM(null);
					
			materialeSemifabricatDorit.add(m7);
			materialeSemifabricatDorit.add(m8);
			
			//produs dorit
			produsDorit=new Produs();
			produsDorit.setIdMaterial(1);
			produsDorit.setDenumire("Produs nou");
			produsDorit.setUnitateMasura(null);
			produsDorit.setDataFabricatiei(null);
			produsDorit.setTermenValabilitate(null);
			logger.info("*****Produsul dorit este: " + produsDorit);
			
			//sectie
			sectie= new Divizie();
			sectie.setId(1);				
			sectie.setDenumire("Sectie Productie");
			sectie.setIdDepartament(null);
			sectie.setAtributii(null);
			logger.info("*****Sectia a fost creata " + sectie.getDenumire());
			
			nrOrdine =1;
			isFinal= false;
				
			FazaProductie fazaProductie = new FazaProductie(faza1, utilaj, timpFolosire, functiiNecesare, materialeReteta, semifabricatDorit, produsDorit, sectie, nrOrdine, isFinal);
			//FazaProductie fazaProductie2 = new FazaProductie(faza2, utilaj, timpFolosire, functiiNecesare, materialeReteta, semifabricatDorit, produsDorit, sectie, nrOrdine, isFinal);
			
			
			fazaProductie.setFlux(flux);
			flux.adaugaFaza(fazaProductie);

			faze.add(fazaProductie);
				
			ArrayList<Angajat> listaAngajati = new ArrayList<Angajat>();
		    for (int f=0;f<functiiNecesare.size();f++){
				int nrAngajati=functiiNecesare.get(f).getNrAngajatiFunctie();
				
				for(int a=1;a<=nrAngajati;a++){
					Angajat angajat =new Angajat();
						
					//ar trebui o metoda 'get angajat by functie'
					//angajat=personal.getAngajatById(a);
					angajat.setId(a);
				
					listaAngajati.add(angajat);
					
				}
				logger.debug("*****Angajatul a fost adaugat");
			}
		    
		    fazaProductie.setAngajati(listaAngajati);
		    logger.debug("*****Lista de angajati a fost adaugata in cadrul fazei!");
		    
		    Semifabricat semifabricatReteta = new Semifabricat();
		    if (nrOrdine==1&&isFinal==false)
		    {
		    	fazaProductie.setSemifabricatReteta(null);
		    	fazaProductie.setProdusDorit(null);	
		    
		    }
		    else if (nrOrdine>1 && isFinal==false)
		    {
		    	
		    	FazaProductie fz = new FazaProductie();
		    	fz=productie.getFazaFlux(flux, nrOrdine);
		    	
		    	semifabricatReteta=fz.procesareSemifabricat();
		    	fazaProductie.setSemifabricatReteta(semifabricatReteta);
		    	fazaProductie.setProdusDorit(null);
		    
		    }
		    
		    else if (nrOrdine==1&&isFinal==true){
		       	fazaProductie.setSemifabricatReteta(null);
		    	fazaProductie.setSemifabricatDorit(null);
		    }
		    else{
		    	FazaProductie fz = new FazaProductie();
		    	fz=productie.getFazaFlux(flux, nrOrdine);
		    	
		    	semifabricatReteta=fz.procesareSemifabricat();
		    	fazaProductie.setSemifabricatReteta(semifabricatReteta);
		    	fazaProductie.setSemifabricatDorit(null);
		    	
		    }
		
			FazaProductie fazaObtinuta=fazaProductie;
			
			for(int i=0; i<faze.size();i++){
				if (faze.get(i).getNrOrdine()==nrOrdine){
					fazaObtinuta=faze.get(i);
				}
				else{
					fazaObtinuta=null;
				}
			}
						
		    logger.info(">>>>>>>> END TEST getFazaFlux!");
		
		}
	 
	 
		@Test	
		 public void testConsumResursa(){
			logger.info(">>>>>>>> INCEPERE TEST CONSUM RESURSE");
				
			ArrayList<Material>listaMateriale = new ArrayList<Material>();
			ArrayList<Utilaj> listaUtilaje = new ArrayList<Utilaj>();
			ArrayList<Object> resurse = new ArrayList<Object>();
			
			String faza1;
			FluxProductie flux;
			Utilaj utilaj;
			Double timpFolosire;
			ArrayList<FunctieNecesara> functiiNecesare;
			ArrayList<Material> materialeReteta;
			Semifabricat semifabricatDorit = null;
			Produs produsDorit;
			Divizie sectie;
			Integer nrOrdine;
			Boolean isFinal;
			
			//flux
			
			 Produs produsNou = new Produs();
			 produsNou.setIdMaterial(1);
			 produsNou.setDenumire("Produs nou");
			 produsNou.setUnitateMasura(null);
			 produsNou.setDataFabricatiei(null);
			 produsNou.setTermenValabilitate(null);
			 
			 ArrayList<FazaProductie> faze = new ArrayList<FazaProductie>();

			 
			 logger.debug("*****A fost creat un nou produs: " + produsNou.getDenumire());
			 flux = new FluxProductie(1,produsNou);

			 //faza
			faza1="Faza 1";
			//faza2="Faza2";
			
			//utilaj
			MijlocFix mf=new MijlocFix();
			mf.setId(1);
			mf.setDenumire("Utilaj");
			mf.setAdresa(null);
			mf.setTermenExploatare(null);
			mf.setValoare(null);
			logger.info("*****Mijlocul fix a fost creat " + mf.getDenumire());
			//Setez utilajul;
			utilaj =new Utilaj();
			utilaj.setUtilaj(mf);
			utilaj.setStatus("ocupat");
			
			//timp folosire
			timpFolosire=  10.00;
			
			
			//functii necesare
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
					
			functiiNecesare = new ArrayList<FunctieNecesara>();
			functiiNecesare.add(f1);
			functiiNecesare.add(f2);
			logger.info("*****Lista de functii a fost creata " + functiiNecesare);
			
			// materiale reteta
			materialeReteta = new ArrayList<Material>();
			Material m3=new Material();
			Material m4=new Material();
			
			m3.setIdMaterial(1);
			m3.setDenumire("material1");
			m3.setCategorie(null);
			m3.setLiniiDocumente(null);
			m3.setProd(null);
			m3.setTipContabil(null);
			m3.setUM(null);
			logger.info("*****Materialul a fost creat " + m3);
					
			m4.setIdMaterial(2);
			m4.setDenumire("material2");
			m4.setCategorie(null);
			m4.setLiniiDocumente(null);
			m4.setProd(null);
			m4.setTipContabil(null);
			m4.setUM(null);
			logger.info("*****Materialul a fost creat " + m4);

			materialeReteta.add(m3);
			materialeReteta.add(m4);
			logger.info("*****Lista cu materialele retetei a fost creata " + materialeReteta);
			
			//semifabricat dorit
			Semifabricat sDorit=new Semifabricat();
			String denSemifabricatDorit = "semifabricat";
			ArrayList<Material> materialeSemifabricatDorit = new ArrayList<Material>();
			Material m7=new Material();
			Material m8=new Material();
			m7.setIdMaterial(3);
			m7.setDenumire("material3");
			m7.setCategorie(null);
			m7.setLiniiDocumente(null);
			m7.setProd(null);
			m7.setTipContabil(null);
			m7.setUM(null);
			
			m8.setIdMaterial(4);
			m8.setDenumire("material4");
			m8.setCategorie(null);
			m8.setLiniiDocumente(null);
			m8.setProd(null);
			m8.setTipContabil(null);
			m8.setUM(null);
					
			materialeSemifabricatDorit.add(m7);
			materialeSemifabricatDorit.add(m8);
			
			//produs dorit
			produsDorit=new Produs();
			produsDorit.setIdMaterial(1);
			produsDorit.setDenumire("Produs nou");
			produsDorit.setUnitateMasura(null);
			produsDorit.setDataFabricatiei(null);
			produsDorit.setTermenValabilitate(null);
			logger.info("*****Produsul dorit este: " + produsDorit);
			
			//sectie
			sectie= new Divizie();
			sectie.setId(1);				
			sectie.setDenumire("Sectie Productie");
			sectie.setIdDepartament(null);
			sectie.setAtributii(null);
			logger.info("*****Sectia a fost creata " + sectie.getDenumire());
			
			nrOrdine =1;
			isFinal= false;
				
			FazaProductie fazaProductie = new FazaProductie(faza1, utilaj, timpFolosire, functiiNecesare, materialeReteta, semifabricatDorit, produsDorit, sectie, nrOrdine, isFinal);
			logger.info("*****A fost creata o noua faza: " + fazaProductie.getFaza());
			fazaProductie.setFlux(flux);
			flux.adaugaFaza(fazaProductie);
			logger.info("*****A fost adaugata o noua faza in flux: " + fazaProductie.getFaza());
			faze.add(fazaProductie);
			
			
			ArrayList<Angajat> listaAngajati = new ArrayList<Angajat>();
		    for (int f=0;f<functiiNecesare.size();f++){
		    	
				int nrAngajati=functiiNecesare.get(f).getNrAngajatiFunctie();
				
				for(int a=1;a<=nrAngajati;a++){
					Angajat angajat =new Angajat();
						
					//ar trebui o metoda 'get angajat by functie'
					//angajat=personal.getAngajatById(a);
					angajat.setId(a);
				
					listaAngajati.add(angajat);
				}
				
			}
		    
		    logger.info("*****A fost creata lista angajatilor: " + listaAngajati.size());
		    fazaProductie.setAngajati(listaAngajati);
		    
		    int n=fazaProductie.getMaterialeReteta().size();
				for(int i=0;i<n-1; i++){
					listaMateriale.add(fazaProductie.getMaterialeReteta().get(i));
					logger.info("*****Se adauga materialul: " + fazaProductie.getMaterialeReteta().get(i).getDenumire());
				}
				int m=fazaProductie.getAngajati().size();
				for (int j=0; j<m-1; j++){
					listaAngajati.add(fazaProductie.getAngajati().get(j));
					logger.info("*****Se adauga angajatul: "+ fazaProductie.getAngajati().get(j).getId());
				}
				
				listaUtilaje.add(fazaProductie.getUtilaj());
			    logger.info("*****Se adauga utilajul: " + fazaProductie.getUtilaj().getUtilaj().getDenumire());
				
			    resurse.add(listaUtilaje);
			    logger.info("*****Lista de utilaje a fost adaugata in lista de resurse");
				resurse.add(listaMateriale);
				logger.info("*****Lista de materiale a fost adaugata in lista de resurse");
				resurse.add(listaAngajati);
				logger.info("*****Lista de angajati a fost adaugata in lista de resurse");
				
				logger.info(">>>>>>>>>>> SFARSIT TEST CONSUM RESURSE: " + resurse.size());
			 }
	@Test
	public void testControlCalitate()
	{
		logger.info(">>>>>>>>>>>> INCEPERE TEST CONTROL CALITATE");
		Boolean trecut;
		Produs produs = new Produs();
		produs.setIdMaterial(1);
		produs.setDenumire("Produs nou");
		produs.setUnitateMasura(null);
		produs.setDataFabricatiei(null);
		produs.setTermenValabilitate(null);
		logger.info("*****Produsul este:" + produs.getDenumire());
		
		Document doc = new Document();
		doc.setNrDoc(12);
		doc.setDataDoc(null);
		doc.setDataDocument(null);
		doc.setLiniiDocument(null);
		doc.setObservatie("comanda productie");
		doc.setPersoana(null);
		logger.info("*****Documentul cu numarul:" + doc.getNrDoc() + " a fost creat");
		
		ComandaProductie comanda = new ComandaProductie();
		comanda.setIdComanda(doc);
		comanda.setProdus(produs);
		comanda.setDataComanda(null);
		comanda.setCantitate(10);
		logger.info("*****Comanda este:" + comanda.getIdComanda());
		
	  Integer cantitate;
	  Integer cantitateProdusFinal=0;
	  Integer cantitateDeseu=0;
	  CriteriuCalitate criteriuCalitate;
	  ArrayList<Integer> cantitati = new ArrayList<Integer>();
	  criteriuCalitate = new CriteriuCalitate(1, "criteriu 1");
	  criteriuCalitate.getCriteriu();
	  
	  comanda=new ComandaProductie(produs, 10, null);  
	  cantitate=comanda.getCantitate();  
	  
	  for (int i=0; i<cantitate; i++){
		  trecut=true;//preluarea parametrului "trecut" se va face dintr-un checkbox din interfata
		  if (trecut==true){
		    cantitateProdusFinal=cantitateProdusFinal+1;
		    logger.info("*****Cantitatea a fost incrementata:" + cantitateProdusFinal);
		   }
		   else{
		    cantitateDeseu=cantitateDeseu+1;
		    logger.info("*****Cantitatea a fost incrementata:" + cantitateDeseu);
		   } 
		   
		  }
	  for (int i=0; i<cantitate; i++){
		  trecut=false;//preluarea parametrului "trecut" se va face dintr-un checkbox din interfata
		  if (trecut==true){
		    cantitateProdusFinal=cantitateProdusFinal+1;
		    logger.info("*****Cantitatea de produse finale a fost incrementata:" + cantitateProdusFinal);
		   }
		   else{
		    cantitateDeseu=cantitateDeseu+1;
		    logger.info("*****Cantitatea de deseuri a fost incrementata:" + cantitateDeseu);
		   } 
		   
		  }
	  cantitati.add(cantitateProdusFinal);
	  cantitati.add(cantitateDeseu);
	  logger.info("*****Cantitati:"+ cantitati.get(0) + " | " + cantitati.get(1));
	  logger.info(">>>>>>>>>>>>SFARSIT TEST CONTROL CALITATE");  
	}
	
@Test	
public void testLivrareProdus(){
	logger.info(">>>>>>>>>>> INCEPERE TEST LIVRARE PRODUS");
	
	Boolean trecut;
	Produs produs = new Produs();
	produs.setIdMaterial(1);
	produs.setDenumire("Produs nou");
	produs.setUnitateMasura(null);
	produs.setDataFabricatiei(null);
	produs.setTermenValabilitate(null);
	logger.info("**********Produsul este:" + produs.getDenumire());
	
	Document doc = new Document();
	doc.setNrDoc(12);
	doc.setDataDoc(null);
	doc.setDataDocument(null);
	doc.setLiniiDocument(null);
	doc.setObservatie("comanda productie");
	doc.setPersoana(null);
	logger.info("*****Documentul cu numarul:" + doc.getNrDoc() + " a fost creat");
	
	ComandaProductie comanda = new ComandaProductie();
	comanda.setIdComanda(doc);
	comanda.setProdus(produs);
	comanda.setDataComanda(null);
	comanda.setCantitate(10);
	logger.info("*****Comanda este:" + comanda.getIdComanda());
	
  
  Integer cantitate;
  Integer cantitateProdusFinal=0;
  Integer cantitateDeseu=0;
  CriteriuCalitate criteriuCalitate;
  ArrayList<Integer> cantitati = new ArrayList<Integer>();
  criteriuCalitate = new CriteriuCalitate(1, "criteriu 1");
  criteriuCalitate.getCriteriu();
  
  comanda=new ComandaProductie(produs, 10, null);  
  cantitate=comanda.getCantitate();  
  
  for (int i=0; i<cantitate; i++){
	  trecut=true;//preluarea parametrului "trecut" se va face dintr-un checkbox din interfata
	  if (trecut==true){
	    cantitateProdusFinal=cantitateProdusFinal+1;
	    logger.info("*****Cantitatea a fost incrementata:" + cantitateProdusFinal);
	   }
	   else{
	    cantitateDeseu=cantitateDeseu+1;
	    logger.info("*****Cantitatea a fost incrementata:" + cantitateDeseu);
	   } 
	   
	  }
  	cantitati.add(cantitateProdusFinal);
  	cantitati.add(cantitateDeseu);
  	
  	 /* ArticolStoc stocProduse;
	  stocProduse=new ArticolStoc();
	  Integer cantitateProdus;
	  cantitateProdus=cantitati.get(0);
	  stocProduse.getCatitateStocPeGestiune();
	  if (stocProduse.getIdArticolStoc() == produs.getId()){
	  }  
	 		else{
	   
			System.out.println("Nu exista comanda pentru produsul");
	  }*/
	   logger.info(">>>>>>>>>>>>SFARSIT TEST LIVRARE PRODUS");
	 }

@Test
public void testInregistrareGestiuneConsum(){
	logger.info(">>>>>>>>>>>>INCEPERE TEST INREGISTRARE GESTIUNE CONSUM");
	testConsumResursa();
	logger.info("*****Consum resurse a fost inregistrat");
	
	logger.info(">>>>>>>>>>>>SFARSIT TEST INREGISTRARE GESTIUNE CONSUM");
}


@Test
public void testInregistrareGestiuneProductie(){
	logger.info(">>>>>>>>>INCEPERE TEST INREGISTRARE GESTIUNE PRODUCTIE");
	testControlCalitate();
	logger.info("*****Produsele au fost inregistrate");
	logger.info(">>>>>>>>>SFARSIT TEST INREGISTRARE GESTIUNE PRODUCTIE");
	
}


		 
	 }

