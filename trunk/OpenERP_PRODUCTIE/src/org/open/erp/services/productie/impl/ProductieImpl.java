package org.open.erp.services.productie.impl;

import java.util.ArrayList;

import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.MijlocFix;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.productie.ComandaProductie;
import org.open.erp.services.productie.CriteriuCalitate;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FunctieNecesara;
import org.open.erp.services.productie.SectieProductie;
import org.open.erp.services.productie.Utilaj;

import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.Semifabricat;
import org.open.erp.services.stocuri.ArticolStoc;

/**
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */
public class ProductieImpl implements ProductieSrv {

	ArrayList<FazaProductie> fazeFlux;
	Integer cantitateProdusFinal = 0;
	Integer cantitateDeseu =0 ;
	ArrayList<Material> listaMateriale;
	ArrayList<Angajat> listaAngajati;
	ArrayList<Utilaj> listaUtilaje;
	ArrayList<Integer> cantitati;
	ArrayList<Object> resurse;


	@Override
	public void definireFluxProductie(Produs produs) {
		// setez numarul de faze pentru flux
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
		
		nrFaze=5;
		fazeFlux = new ArrayList<FazaProductie>();
		
		//setez fiecare faza din flux;
		
		for (int i=1;i<=nrFaze;i++){
		
			fz=new FazaProductie();
			
			//setez un mijloc fix;
			mf=new MijlocFix();
			mf.setId(1);
			mf.setDenumire("Cuptor");
			
			//Setez utilajul;
			u =new Utilaj();
			u.setUtilaj(mf);
			u.setStatus("ocupat");
			//setez timpul de folosire al utilajului;
			timp= 10.00;
			
			fz.setFaza("amestecare"+i);
			fz.setUtilaj(u);
			fz.setTimpFolosire(timp);
			
			
			//setez sectia in care se desfasoara faza curenta
			SectieProductie sectie= new SectieProductie();
			sectie.setId(1);
			sectie.setDenumire("Departament");
			sectie.setDenSectie("Sectie");
			
			fz.setSectie(sectie);
			
			//adaugarea functiilor necesare pentru angajati	
			FunctieNecesara f1=new FunctieNecesara();
			f1.setId(1);
			f1.setDenumire("functie1");
			f1.setNrAngajatiFunctie(2);
			FunctieNecesara f2=new FunctieNecesara();
			f2.setId(2);
			f2.setDenumire("functie2");
			f2.setNrAngajatiFunctie(3);
		
			functiiNecesare =new ArrayList<FunctieNecesara>();
			functiiNecesare.add(f1);
			functiiNecesare.add(f2);
		
			fz.setFunctiiNecesare(functiiNecesare);
			
			angajati=new ArrayList<Angajat>();
		
			for (int f=0;f<functiiNecesare.size();f++){
				int nrAngajati=functiiNecesare.get(f).getNrAngajatiFunctie();
				for(int a=1;a<=nrAngajati;a++){
					Angajat angajat =new Angajat();
					//ar trebui cautati angajatii care au functia curenta
					//si introdusi intr-o lista de angajati
					angajati.add(angajat);
				}
			}
			
			fz.setAngajati(angajati);
		
		/*adaugarea materialelor necesare
		adaugarea unor denumiri pe baza carora sa caut in baza de date
		String m1=new String();
		String m2=new String();
		m1="faina"+i;
		m2="apa"+i;
		
		ArrayList <String> materialeNecesare = new ArrayList<String>();
		materialeNecesare.add(m1);
		materialeNecesare.add(m2);
		
		/*lista cu materialele pe care sa le caut in baza de date
		for (int k=0;k<materialeNecesare.size();k++){
			* caut in baza de date materiale care au denumirea materialelor
			 * care sunt in lista materiale111 si le adaug in lista materialelor
			 * necesare:* materialeNecesare.add(materialgasit); 
		}*/
		
		//lista materialelor pe care le-am luat din baza de date
		//sau in cazul de fata, lista materialelor definite local
	
		
		//lista materialelor din reteta
			materialeReteta = new ArrayList<Material>();
			Material m3=new Material();
			Material m4=new Material();
			m3.setId(1);
			m3.setDenumire("material1");
			m4.setId(2);
			m4.setDenumire("material2");
		
			materialeReteta.add(m3);
			materialeReteta.add(m4);
		
			fz.setMaterialeReteta(materialeReteta);
		
			if(i==1){
				fz.setSemifabricatReteta(null);
			}
			else{
				
				//construirea semifabricatului din reteta
				String denSemifabricat = "semifabricat";
				materialeSemifabricat = new ArrayList<Material>();
				Material m5=new Material();
				Material m6=new Material();
				m3.setId(1);
				m3.setDenumire("material3");
				m4.setId(2);
				m4.setDenumire("material4");
				materialeSemifabricat.add(m5);
				materialeSemifabricat.add(m6);
				semifabricatContinut=fazeFlux.get(i-1).getSemifabricatDorit();
		
				semifabricatReteta = new Semifabricat();
				semifabricatReteta.setSemifabricat(denSemifabricat);
				semifabricatReteta.setListaMateriale(materialeSemifabricat);
				semifabricatReteta.setSemifabricatContinut(semifabricatContinut);
				fz.setSemifabricatReteta(semifabricatReteta);
			}
			
			if(i==nrFaze){
				pDorit=new Produs();
				pDorit.setDenumire("paine"+i);
				pDorit.setId(111);
				fz.setProdusDorit(pDorit);
			}
			else{
				sDorit=new Semifabricat();
				//String denSemifabricat = "denumire semifabricat";
				/*caut in baza de date un semifabricat care are
				 * denumirea denSemifabricat;
				 * sDorit va lua valoarea semifabricatului gasit*/
				Semifabricat sDorit2=new Semifabricat();
				sDorit=sDorit2;
				fz.setSemifabricatDorit(sDorit);
			}
			
					
		fazeFlux.add(fz);
		
		}
		
		//procesez semifabricatul sau produsul final
		int n = fazeFlux.size();
		for (int i = 0; i < n - 1; i++) {
			fazeFlux.get(i).procesareSemifabricat();
		}
		fazeFlux.get(n - 1).procesareProdus();
	}

	@Override
	public Produs lansareComandaProductie(ComandaProductie comanda, Produs produs) {
		  // cautare faze pentru produsul x in baza de date;
		   definireFluxProductie(produs);
		   
		   return produs;
		 }

	@Override
	public ArrayList<Object> consumResursa(Produs produs) {
		/*parcurgem din baza de date din fiecare si preluam
		 * listele cu resursele consumate
		 * se va face atunci cand va exista persistenta cu baza de date*/
		listaMateriale = new ArrayList<Material>();
		listaUtilaje = new ArrayList<Utilaj>();
		listaAngajati = new ArrayList<Angajat>();
		 ArrayList<Object> resurse = new ArrayList<Object>();
		  resurse.add(listaMateriale);
		  resurse.add(listaUtilaje);
		  resurse.add(listaAngajati);
		return resurse;
	}



	@Override
	public ArrayList<Integer> controlCalitate(Produs produs) {
		  Boolean trecut;
		  ComandaProductie comanda;
		  
		  Integer cantitate;  
		  CriteriuCalitate criteriuCalitate;
		  ArrayList<Integer> cantitati = new ArrayList<Integer>();
		  criteriuCalitate = new CriteriuCalitate(1, "criteriu 1");
		  criteriuCalitate.getCriteriu();
		  
		  comanda=new ComandaProductie(1, produs, 10, null);  
		  cantitate=comanda.getCantitate();  
		 
		  for (int i=0; i<cantitate; i++){
		   trecut = true;
		   if (trecut==true){
		    cantitateProdusFinal=cantitateProdusFinal+1;
		   }
		   else{
		    cantitateDeseu=cantitateDeseu+1;
		   } 
		   
		  }
		  cantitati.add(cantitateProdusFinal);
		  cantitati.add(cantitateDeseu);
		  return cantitati;
		    
}
	
	@Override
	public Integer livrareProdus(Integer cantitateProdus, Produs produs) {
		  ArticolStoc stocProduse = null;
		    
		  cantitateProdus=cantitati.get(0);
		  stocProduse = new ArticolStoc(1, produs.getDenumire(), 5);
		  if (stocProduse.getDenumire() == produs.getDenumire()){
		   return cantitateProdus;
		  }
		  
		  else{
		   
		   System.out.println("Nu exista comanda pentru produsul");
		   return 0; 
		   
		  }
		 }

	@Override
	public ArrayList<Object> inregistrareGestiuneConsum(Produs produs) {
		consumResursa(produs);
		return resurse;
		
	}
	public ArrayList<Integer> inregistrareGestiuneProductie(Produs produs){
		
		controlCalitate(produs);
		return cantitati;
	}
}
