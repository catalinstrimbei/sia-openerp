package org.open.erp.services.productie.impl;

import java.util.ArrayList;

import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.MateriePrima;
import org.open.erp.services.nomgen.MijlocFix;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.productie.ComandaProductie;
import org.open.erp.services.productie.CriteriuCalitate;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FluxProductie;
import org.open.erp.services.productie.FunctieNecesara;
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
	ArrayList<MateriePrima> listaMateriale;
	ArrayList<Angajat> listaAngajati;
	ArrayList<Utilaj> listaUtilaje;
	ArrayList<Integer> cantitati;
	ArrayList<Object> resurse;


	@Override
	public void definireFluxProductie(Produs produs) {
		// setez numarul de faze pentru flux
		FluxProductie flux = new FluxProductie();
		flux.setProdus(produs);
		Integer nrFaze;
		MijlocFix mf;
		FazaProductie fz;
		Utilaj u;
		Double timp;
		ArrayList<FunctieNecesara> functiiNecesare;
		ArrayList<Angajat> angajati;
		ArrayList <MateriePrima> materialeReteta;
		Semifabricat semifabricatReteta;
		Produs pDorit;
		Semifabricat sDorit;
		
		nrFaze=5;
		fazeFlux = new ArrayList<FazaProductie>();
		
		//setez fiecare faza din flux;
		
		for (int i=1;i<=nrFaze;i++){
		
			fz=new FazaProductie();
			
			//selectez un mijloc fix;
			mf=new MijlocFix();
			mf.getDenumire();
			
			//Setez utilajul;
			u =new Utilaj();
			u.setUtilaj(mf);
			u.setStatus("ocupat");
			//setez timpul de folosire al utilajului;
			timp= 10.00;
			
			fz.setFaza("amestecare"+i);
			fz.setUtilaj(u);
			fz.setTimpFolosire(timp);
			
			
			//selectez sectia in care se desfasoara faza curenta
			Divizie sectie= new Divizie();
			sectie.getDenumire();
			sectie.getIdDepartament();
			
			fz.setSectie(sectie);
			
			//adaugarea functiilor necesare pentru angajati	
			FunctieNecesara f1=new FunctieNecesara();
			f1.getNumeFunctie();
			f1.setNrAngajatiFunctie(2);
			
			FunctieNecesara f2=new FunctieNecesara();
			f2.getNumeFunctie();
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
					//ar trebui cautati angajatii care au functia curenta setata in contractul de munca
					//si introdusi intr-o lista de angajati
					angajati.add(angajat);
				}
			}
			
			fz.setAngajati(angajati);
		
		//lista materialelor din reteta
			materialeReteta = new ArrayList<MateriePrima>();
			MateriePrima m3=new MateriePrima();
			MateriePrima m4=new MateriePrima();
			m3.getDenumire();
			m4.getDenumire();
		
			materialeReteta.add(m3);
			materialeReteta.add(m4);
		
			fz.setMaterialeReteta(materialeReteta);
		
			if(i==1){
				//pentru prima faza nu exista un semifabricat
				fz.setSemifabricatReteta(null);
			}
			else{
				//preluarea semifabricatului obtinut in faza anterioara
				semifabricatReteta = fazeFlux.get(i-1).procesareSemifabricat();
				fz.setSemifabricatReteta(semifabricatReteta);
				
			}
			
			if(i==nrFaze){
				pDorit=new Produs();
				pDorit.getDenumire();
				fz.setProdusDorit(pDorit);
			}
			else{
				//trebuie setat semifabricatul care se doreste a fi obtinut
				
				sDorit=new Semifabricat();
							
			    String denSemifabricatDorit = "semifabricat dorit";
			    ArrayList<MateriePrima> materialeSemifabricatDorit = new ArrayList<MateriePrima>();
			    MateriePrima m5=new MateriePrima();
			    MateriePrima m6=new MateriePrima();
			    m5.getDenumire();
			    m6.getDenumire();
			    materialeSemifabricatDorit.add(m5);
			    materialeSemifabricatDorit.add(m6);
			    Semifabricat semifabricatContinut;
			    if(i==1)
			    {
			     semifabricatContinut=null;
			    }
			    else
			    {
			     semifabricatContinut=fazeFlux.get(i-1).getSemifabricatDorit();
			    }
			    sDorit.setSemifabricat(denSemifabricatDorit);
			    sDorit.setListaMateriale(materialeSemifabricatDorit);
			    sDorit.setSemifabricatContinut(semifabricatContinut);
			    
			    fz.setSemifabricatReteta(sDorit);
	
			}
			
					
		fazeFlux.add(fz);
		
		}
		
		//procesez semifabricatul sau produsul final
		int n = fazeFlux.size();
		for (int i = 0; i < n - 1; i++) {
			fazeFlux.get(i).procesareSemifabricat();
		}
		fazeFlux.get(n - 1).procesareProdus();
		
		flux.setFaze(fazeFlux);
	}

	@Override
	public Produs lansareComandaProductie(ComandaProductie comanda, Produs produs) {
		  // cautare faze pentru produsul x in baza de date;
		   definireFluxProductie(produs);
		   
		   return produs;
		 }

	@Override
	public ArrayList<Object> consumResursa(FazaProductie faza,Produs produs) {
		 	  
		  listaMateriale = new ArrayList<MateriePrima>();
		  listaUtilaje = new ArrayList<Utilaj>();
		  listaAngajati = new ArrayList<Angajat>();


		  for(int i=0;i<faza.getMaterialeReteta().size(); i++){
		   listaMateriale.add(faza.getMaterialeReteta().get(i));
		   }
		  
		  for (int j=0; j<faza.getAngajati().size(); j++){
		   listaAngajati.add(faza.getAngajati().get(j));
		   } 
		  
		  listaUtilaje.add(faza.getUtilaj());
		      
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
		  ArticolStoc stocProduse;
		  stocProduse=new ArticolStoc();
		  cantitateProdus=cantitati.get(0);
		  stocProduse.getCatitateStocPeGestiune();
		  if (stocProduse.getIdArticolStoc() == produs.getId()){
		   return cantitateProdus;
		  }
		  
		  else{
		   
		   System.out.println("Nu exista comanda pentru produsul");
		   return 0; 
		   
		  }
		 }

	@Override
	public ArrayList<Object> inregistrareGestiuneConsum(FazaProductie faza,Produs produs) {
		consumResursa(faza, produs);
		return resurse;
		
	}
	public ArrayList<Integer> inregistrareGestiuneProductie(Produs produs){
		controlCalitate(produs);
		return cantitati;
	}
}
