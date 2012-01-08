/**
 * 
 */
package org.open.erp.services.productie.teste;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.open.erp.services.nomgen.Divizie;
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
import org.open.erp.services.stocuri.StocuriSrv;

/**
 * @author Echipa Productie
 *
 */
	
public class TestProductie {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestProductie.class.getName());
	ProductieSrv productie;
	NomenclatoareSrv nomenclatoare;
	StocuriSrv stocuri;
	@BeforeClass
	 public static void setUpBeforeClass() throws Exception {
	 }

	 @Before
	 public void setUp() throws Exception {
	 }
	 
	 @Test
	 public void testDefinireFluxProductie () {
		 FluxProductie flux = new FluxProductie();
			
		 ArrayList<FazaProductie> fazeFlux;
		Integer nrFaze;
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
		
		 logger.info("INCEPERE TESTE: DEFINIRE FLUX PRODUCTIE");
		 Produs produsNou = new Produs();
		 produsNou.setId(1);
		 produsNou.setDenumire("Produs nou");
		 produsNou.setUnitateMasura(null);
		 produsNou.setDataFabricatiei(null);
		 produsNou.setTermenValabilitate(null);
		 logger.info("Produsul a fost creat " + produsNou.getDenumire());
		 flux.setProdus(produsNou);
		 nrFaze=5;
		 fazeFlux = new ArrayList<FazaProductie>();
		//setez fiecare faza din flux;
		 logger.info("nr faze" + nrFaze);
			for (int i=1;i<=nrFaze;i++){
				
				fz=new FazaProductie();
				
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
				fz.setFaza("Faza"+i);
				logger.info("faza nume:" + fz.getFaza());
				fz.setUtilaj(u);
				fz.setTimpFolosire(timp);
				
				
				//selectez sectia in care se desfasoara faza curenta
				Divizie sectie= new Divizie();
					
				sectie.setId(1);				
				sectie.setDenumire("Sectie Productie");
				sectie.setIdDepartament(null);
				sectie.setAtributii(null);
				logger.info("Sectia a fost creata " + sectie.getDenumire());
				
				fz.setSectie(sectie);
				logger.info("faza sectie:" + fz.getSectie());
				
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
				fz.setFunctiiNecesare(functiiNecesare);
				logger.info("faza lista functii:" + fz.getFunctiiNecesare().size());
				angajati=new ArrayList<Angajat>();
				
				ArrayList<ContractMunca> contracte = new ArrayList<ContractMunca>();
				
				ContractMunca contract1=new ContractMunca();
				Angajat a1 = new Angajat();
				   a1.setId(1);
				   a1.setAdresa("Adresa");
				   a1.setIdCandidat(1);
				   a1.setMarca(1);
				   a1.setTipCandidat("tip candidat 1");
				   a1.setActiv(true);
				   logger.info("a1:" + a1.getId());
				contract1.setAngajat(a1);
				contract1.setFunctie(f1);
				contract1.setDataSemnare(null);
				contract1.setDataInceput(null);
				contract1.setDataTerminare(null);
				contract1.setDurataContract(null);
				contract1.setMotivIncheiere(null);
				contract1.setNrContract(null);
				logger.info("Contractul a fost creat " + contract1);
				ContractMunca contract2=new ContractMunca();
				Angajat a2 = new Angajat();
				   a2.setId(2);
				   a2.setAdresa("Adresa");
				   a2.setIdCandidat(2);
				   a2.setMarca(2);
				   a2.setTipCandidat("tip candidat 2");
				   a2.setActiv(true);
				   
				contract2.setAngajat(a2);
				contract2.setFunctie(f2);
				contract2.setDataSemnare(null);
				contract2.setDataInceput(null);
				contract2.setDataTerminare(null);
				contract2.setDurataContract(null);
				contract2.setMotivIncheiere(null);
				contract2.setNrContract(null);
				logger.info("Contractul a fost creat " + contract2);
				
				ContractMunca contract3=new ContractMunca();
				Angajat a3 = new Angajat();
				   a3.setId(3);
				   a3.setAdresa("Adresa");
				   a3.setIdCandidat(3);
				   a3.setMarca(3);
				   a3.setTipCandidat("tip candidat 3");
				   a3.setActiv(true);
				   
				contract3.setAngajat(a3);
				contract3.setFunctie(f2);
				contract3.setDataSemnare(null);
				contract3.setDataInceput(null);
				contract3.setDataTerminare(null);
				contract3.setDurataContract(null);
				contract3.setMotivIncheiere(null);
				contract3.setNrContract(null);
				logger.info("Contractul a fost creat " + contract3);
				contracte.add(contract1);
				contracte.add(contract2);
				contracte.add(contract3);
				
				logger.info("Lista de contracte a fost creata " + contracte);
				//ar trebui cautati angajatii care au functia curenta setata in contractul de munca
				//si introdusi intr-o lista de angajati
			
				for (int f=0;f<functiiNecesare.size()-1;f++){
					logger.info("functii necesare size: " + functiiNecesare.size());
					int nrAngajati=functiiNecesare.get(f).getNrAngajatiFunctie();
					logger.info("nrAngajati:" + nrAngajati);
					for(int a=0;a<=nrAngajati-1;a++){
						Angajat angajat =new Angajat();
						for (int b=0; b<=contracte.size()-1;b++)
						{
							logger.info("nr contracte: " + contracte.size());
							logger.info("functie contract" + contracte.get(b).getFunctie().getNumeFunctie());
							logger.info("functie necesara" +functiiNecesare.get(f).getNumeFunctie());
							if (contracte.get(b).getFunctie().getNumeFunctie()==functiiNecesare.get(f).getNumeFunctie())
							{
								angajat = contracte.get(b).getAngajat();
								
								angajati.add(angajat);
								logger.info("Angajatul "+ angajat.getId()+" a fost adaugat in lista angajatilor");
							}
							logger.info("b: " + b);
						}
						logger.info("a: " + a);
					}
					logger.info("f: " + f);
				}
				logger.info("Lista angajatilor a fost creata " + angajati);
				fz.setAngajati(angajati);
				logger.info("faza lista angajati:" + fz.getAngajati().size());
				
			
				
			//lista materialelor pe care le-am luat din baza de date
			//sau in cazul de fata, lista materialelor definite local
			//lista materialelor din reteta
				materialeReteta = new ArrayList<Material>();
				Material m3=new Material();
				Material m4=new Material();
				

				m3.setId(1);
				m3.setDenumire("material1");
				m3.setDataFabricatiei(null);
				m3.setUnitateMasura(null);
				m3.setTermenValabilitate(null);
				logger.info("Materialul a fost creat " + m3);
				m4.setId(2);
				m4.setDenumire("material2");
				m4.setDataFabricatiei(null);
				m4.setUnitateMasura(null);
				m4.setTermenValabilitate(null);
				logger.info("Materialul a fost creat " + m4);
				materialeReteta.add(m3);
				materialeReteta.add(m4);
				logger.info("Lista cu materialele retetei a fost creata " + materialeReteta);
				fz.setMaterialeReteta(materialeReteta);
				logger.info("faza materiale reteta:" + fz.getMaterialeReteta().size());
				logger.info("i="+i);
				if(i==1){
					fz.setSemifabricatReteta(null);
					logger.info("Nu exista semifabricat reteta pentru prima faza!");
					
					
					sDorit=new Semifabricat();
					String denSemifabricatDorit = "semifabricat";
					ArrayList<Material> materialeSemifabricatDorit = new ArrayList<Material>();
					Material m7=new Material();
					Material m8=new Material();
					m7.setId(3);
					m7.setDenumire("material3");
					m7.setDataFabricatiei(null);
					m7.setUnitateMasura(null);
					m7.setTermenValabilitate(null);
					
					m8.setId(4);
					m8.setDenumire("material4");
					m8.setDataFabricatiei(null);
					m8.setUnitateMasura(null);
					m8.setTermenValabilitate(null);
				
					materialeSemifabricatDorit.add(m7);
					materialeSemifabricatDorit.add(m8);
					
					semifabricatContinut=null;
					sDorit.setDenumire(denSemifabricatDorit);
					sDorit.setListaMateriale(materialeSemifabricatDorit);
					sDorit.setSemifabricatContinut(semifabricatContinut);
					
					logger.info("Semifabricatul dorit este: " + sDorit);
					
					fz.setSemifabricatDorit(sDorit);
				}
				else if (i>1 && i<nrFaze){
					
					//preluarea semifabricatului obtinut in faza anterioara
					semifabricatReteta = fazeFlux.get(i-2).getSemifabricatDorit();
					logger.info("Semifabricatul reteta este "+ semifabricatReteta);
					
					fz.setSemifabricatReteta(semifabricatReteta);
					
					sDorit=new Semifabricat();
					String denSemifabricatDorit = "semifabricat";
					ArrayList<Material> materialeSemifabricatDorit = new ArrayList<Material>();
					Material m7=new Material();
					Material m8=new Material();
					m7.setId(3);
					m7.setDenumire("material3");
					m7.setDataFabricatiei(null);
					m7.setUnitateMasura(null);
					m7.setTermenValabilitate(null);
					
					m8.setId(4);
					m8.setDenumire("material4");
					m8.setDataFabricatiei(null);
					m8.setUnitateMasura(null);
					m8.setTermenValabilitate(null);
				
					materialeSemifabricatDorit.add(m7);
					materialeSemifabricatDorit.add(m8);
										
					semifabricatContinut=fazeFlux.get(i-2).getSemifabricatDorit();
					sDorit.setDenumire(denSemifabricatDorit);
					sDorit.setListaMateriale(materialeSemifabricatDorit);
					sDorit.setSemifabricatContinut(semifabricatContinut);
					
					logger.info("Semifabricatul dorit este: " + sDorit);
					
					fz.setSemifabricatDorit(sDorit);
					
				}
				
				else{
					pDorit=new Produs();
					pDorit.setId(1);
					pDorit.setDenumire("Produs nou");
					pDorit.setDataFabricatiei(null);
					pDorit.setTermenValabilitate(null);
					pDorit.setUnitateMasura(null);
					logger.info("Produsul dorit este: " + pDorit);
					fz.setProdusDorit(pDorit);
				}
				
						
			fazeFlux.add(fz);
			logger.info("faze flux:" + fazeFlux.size());
			logger.info("---Faza " + i +" a fost creata " + fz + "---");
			logger.info("i:" + i);
			}
			
			logger.info("Fluxul pentru " +produsNou+" a fost creat  si contine urmatoarele faze" + fazeFlux);
			flux.setFaze(fazeFlux);
			//procesez semifabricatul sau produsul final
			int n = fazeFlux.size();
			int i;
			for (i = 0; i < n - 1; i++) {
				fazeFlux.get(i).procesareSemifabricat();
				logger.info("Procesare semifabricat: " + fazeFlux.get(i).procesareSemifabricat() );
			}
			if(i==n){
				fazeFlux.get(n - 1).procesareProdus();
				logger.info("Procesare produs: " +fazeFlux.get(n - 1).procesareProdus());
			}
			
			logger.info("SFRASIT TEST DEFINIRE FLUX PRODUCTIE");
		}

	@Test	
	 public void testConsumResursa(){
			logger.info("INCEPERE TEST CONSUM RESURSE");
			ArrayList<Material>listaMateriale = new ArrayList<Material>();
			ArrayList<Utilaj> listaUtilaje = new ArrayList<Utilaj>();
			ArrayList<Angajat> listaAngajati = new ArrayList<Angajat>();
			ArrayList<Object> resurse = new ArrayList<Object>();
			
			FazaProductie faza = new FazaProductie();
			
			faza.setFaza("faza test");
			
			MijlocFix mijloc=new MijlocFix(1, "Mijloc fix Test", "Adresa test", 10000, null);
			logger.info("Mijlocul fix a fost vreat: " + mijloc.getDenumire());
			Utilaj utilaj=new Utilaj(mijloc, "ocupat");
			logger.info("Utilajul a fost creat " + utilaj.getUtilaj().getDenumire() +" cu statusul " + utilaj.getStatus());
			
			faza.setUtilaj(utilaj);
			faza.setTimpFolosire(5.00);
			
			FunctieNecesara fn1=new FunctieNecesara(1, "functie1", 1);
			FunctieNecesara fn2 = new FunctieNecesara(2, "functie2", 2);
			ArrayList<FunctieNecesara> functiiNecesare=new ArrayList<FunctieNecesara>();
			functiiNecesare.add(fn1);
			functiiNecesare.add(fn2);
			logger.info("Lista functiilor necesare a fost creata: " + functiiNecesare.get(0).getNumeFunctie() + ", " + functiiNecesare.get(1).getNumeFunctie());
			
			faza.setFunctiiNecesare(functiiNecesare);
			
			Angajat a1=new Angajat();
			a1.setActiv(true);
			a1.setAdresa(null);
			a1.setId(1);
			a1.setIdCandidat(1);
			a1.setMarca(null);
			a1.setTipCandidat(null);
			logger.info("a1: " + a1.getId());
			
			Angajat a2=new Angajat();
			a2.setActiv(true);
			a2.setAdresa(null);
			a2.setId(2);
			a2.setIdCandidat(2);
			a2.setMarca(null);
			a2.setTipCandidat(null);
			logger.info("a2: " + a2.getId());
			
			Angajat a3=new Angajat();
			a3.setActiv(true);
			a3.setAdresa(null);
			a3.setId(3);
			a3.setIdCandidat(3);
			a3.setMarca(null);
			a3.setTipCandidat(null);
			logger.info("a3: " + a3.getId());
			
			ArrayList <Angajat> angajati =new ArrayList<Angajat>();
			angajati.add(a1);
			angajati.add(a2);
			angajati.add(a3);
			logger.info("Lista angajatilor a fost creata: " + angajati.get(0).getId() + ", " + angajati.get(1).getId() + ", " + angajati.get(2).getId());
			
			faza.setAngajati(angajati);
			
			Material m1 = new Material(1, "materie prima 1", null, null, null);
			Material m2 = new Material(2, "materie prima 2", null, null, null);
			Material m3 = new Material(3, "materie prima 3", null, null, null);
			Material m4 = new Material(4, "materie prima 4", null, null, null);
			ArrayList <Material> materialeReteta = new ArrayList<Material>();
			materialeReteta.add(m1);
			materialeReteta.add(m2);
			materialeReteta.add(m3);
			materialeReteta.add(m4);
			
			logger.info("Lista materialelor a fost creata: " + materialeReteta.get(0).getDenumire() + ", "+ materialeReteta.get(1).getDenumire() +
					", "+ materialeReteta.get(2).getDenumire() + ", " + materialeReteta.get(3).getDenumire());
			
			faza.setMaterialeReteta(materialeReteta);
			
			Semifabricat sem = new Semifabricat();
			String denSem = "semifabricat";
			ArrayList<Material> materialeSem = new ArrayList<Material>();
			Material m5 = new Material(5, "materie prima 5", null, null, null);
			Material m6 = new Material(6, "materie prima 6", null, null, null);
			materialeSem.add(m5);
			materialeSem.add(m6);
			sem.setDenumire(denSem);
			sem.setListaMateriale(materialeSem);
			sem.setSemifabricatContinut(null);
			logger.info("Semifabricatul din reteta a fost creat: " + sem.getDenumire());
			
			faza.setSemifabricatReteta(sem);
			faza.setSemifabricatDorit(null);
			faza.setProdusDorit(null);
			faza.setSectie(null);

			for(int i=0;i<faza.getMaterialeReteta().size(); i++){
				listaMateriale.add(faza.getMaterialeReteta().get(i));
				logger.info("Se adauga materialul: " + faza.getMaterialeReteta().get(i).getDenumire());
			}
			
			for (int j=0; j<faza.getAngajati().size(); j++){
				listaAngajati.add(faza.getAngajati().get(j));
				logger.info("Se adauga angajatul: "+ faza.getAngajati().get(j).getId());
			}
			
			listaUtilaje.add(faza.getUtilaj());
		    logger.info("Se adauga utilajul: " + faza.getUtilaj().getUtilaj().getDenumire());
			
		    resurse.add(listaUtilaje);
		    logger.info("Lista de utilaje a fost adaugata in lista de resurse");
			resurse.add(listaMateriale);
			logger.info("Lista de materiale a fost adaugata in lista de resurse");
			resurse.add(listaAngajati);
			logger.info("Lista de angajati a fost adaugata in lista de resurse");
			
			logger.info("SFARSIT TEST CONSUM RESURSE");
		 }
	
	@Test
	public void testControlCalitate()
	{
		logger.info("INCEPERE TEST CONTROL CALITATE");
		Boolean trecut;
		Produs produs = new Produs();
		produs.setId(1);
		produs.setDenumire("produs 1");
		produs.setDataFabricatiei(null);
		produs.setCategorie(null);
		produs.setIdMaterial(null);
		produs.setTipContabil(null);
		produs.setUM(null);
		produs.setTermenValabilitate(null);
		produs.setUnitateMasura("buc");
		
		logger.info("Produsul este:" + produs.getDenumire());
		ComandaProductie comanda = new ComandaProductie();
		comanda.setIdComanda(1);
		comanda.setProdus(produs);
		comanda.setDataComanda(null);
		comanda.setCantitate(10);
		logger.info("Comanda este:" + comanda.getIdComanda());
		
	
	  
	  Integer cantitate;
	  Integer cantitateProdusFinal=0;
	  Integer cantitateDeseu=0;
	  CriteriuCalitate criteriuCalitate;
	  ArrayList<Integer> cantitati = new ArrayList<Integer>();
	  criteriuCalitate = new CriteriuCalitate(1, "criteriu 1");
	  criteriuCalitate.getCriteriu();
	  
	  comanda=new ComandaProductie(1, produs, 10, null);  
	  cantitate=comanda.getCantitate();  
	  
	  for (int i=0; i<cantitate; i++){
		  trecut=true;//preluarea parametrului "trecut" se va face dintr-un checkbox din interfata
		  if (trecut==true){
		    cantitateProdusFinal=cantitateProdusFinal+1;
		    logger.info("Cantitatea a fost incrementata:" + cantitateProdusFinal);
		   }
		   else{
		    cantitateDeseu=cantitateDeseu+1;
		    logger.info("Cantitatea a fost incrementata:" + cantitateDeseu);
		   } 
		   
		  }
	  for (int i=0; i<cantitate; i++){
		  trecut=false;//preluarea parametrului "trecut" se va face dintr-un checkbox din interfata
		  if (trecut==true){
		    cantitateProdusFinal=cantitateProdusFinal+1;
		    logger.info("Cantitatea a fost incrementata:" + cantitateProdusFinal);
		   }
		   else{
		    cantitateDeseu=cantitateDeseu+1;
		    logger.info("Cantitatea a fost incrementata:" + cantitateDeseu);
		   } 
		   
		  }
	  cantitati.add(cantitateProdusFinal);
	  cantitati.add(cantitateDeseu);
	  logger.info("Cantitati:"+ cantitati.get(0) + " | " + cantitati.get(1));
	  logger.info("SFARSIT TEST CONTROL CALITATE");  
	}
	
@Test	
public void testLivrareProdus(){
	logger.info("INCEPERE TEST LIVRARE PRODUS");
	
	Boolean trecut;
	Produs produs = new Produs();
	produs.setId(1);
	produs.setDenumire("produs 1");
	produs.setDataFabricatiei(null);
	produs.setCategorie(null);
	produs.setIdMaterial(null);
	produs.setTipContabil(null);
	produs.setUM(null);
	produs.setTermenValabilitate(null);
	produs.setUnitateMasura("buc");
	logger.info("Produsul este:" + produs.getDenumire());
	ComandaProductie comanda = new ComandaProductie();
	comanda.setIdComanda(1);
	comanda.setProdus(produs);
	comanda.setDataComanda(null);
	comanda.setCantitate(10);
	logger.info("Comanda este:" + comanda.getIdComanda());
	

  
  Integer cantitate;
  Integer cantitateProdusFinal=0;
  Integer cantitateDeseu=0;
  CriteriuCalitate criteriuCalitate;
  ArrayList<Integer> cantitati = new ArrayList<Integer>();
  criteriuCalitate = new CriteriuCalitate(1, "criteriu 1");
  criteriuCalitate.getCriteriu();
  
  comanda=new ComandaProductie(1, produs, 10, null);  
  cantitate=comanda.getCantitate();  
  
  for (int i=0; i<cantitate; i++){
	  trecut=true;//preluarea parametrului "trecut" se va face dintr-un checkbox din interfata
	  if (trecut==true){
	    cantitateProdusFinal=cantitateProdusFinal+1;
	    logger.info("Cantitatea a fost incrementata:" + cantitateProdusFinal);
	   }
	   else{
	    cantitateDeseu=cantitateDeseu+1;
	    logger.info("Cantitatea a fost incrementata:" + cantitateDeseu);
	   } 
	   
	  }
  	cantitati.add(cantitateProdusFinal);
  	cantitati.add(cantitateDeseu);
  	
  	  ArticolStoc stocProduse;
	  stocProduse=new ArticolStoc();
	  Integer cantitateProdus;
	  cantitateProdus=cantitati.get(0);
	  stocProduse.getCatitateStocPeGestiune();
	 // if (stocProduse.getIdArticolStoc() == produs.getId()){
	   logger.info("Cantitatea de produs livrata:" + cantitateProdus);
	  //}
	  
	 // else{
	   
	  // System.out.println("Nu exista comanda pentru produsul");
	    
	   
	  //}
	   logger.info("SFARSIT TEST LIVRARE PRODUS");
	 }

@Test
public void testInregistrareGestiuneConsum(){
	logger.info("INCEPERE TEST INREGISTRARE GESTIUNE CONSUM");
	testConsumResursa();
	logger.info("Consum resurse a fost inregistrat");
	
	logger.info("SFARSIT TEST INREGISTRARE GESTIUNE CONSUM");
}


@Test
public void testInregistrareGestiuneProductie(){
	logger.info("INCEPERE TEST INREGISTRARE GESTIUNE PRODUCTIE");
	testControlCalitate();
	logger.info("Produsele au fost inregistrate");
	logger.info("SFARSIT TEST INREGISTRARE GESTIUNE PRODUCTIE");
	
}

 
		 
	 }

