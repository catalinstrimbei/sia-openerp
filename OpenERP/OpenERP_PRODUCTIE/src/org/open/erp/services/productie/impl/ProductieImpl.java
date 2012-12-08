package org.open.erp.services.productie.impl;

import java.util.ArrayList;
import java.util.List;

import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.Produs;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.productie.ComandaProductie;
import org.open.erp.services.productie.CriteriuCalitate;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FluxProductie;
import org.open.erp.services.productie.FunctieNecesara;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.Semifabricat;
import org.open.erp.services.productie.Utilaj;

public class ProductieImpl implements ProductieSrv {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ProductieImpl.class.getName());
	
	private static ProductieSrv productie;
	
	public void setProductieSrv(ProductieSrv productie) {
		this.productie = productie;
	}
	
	ArrayList<FazaProductie> fazeFlux;
	Integer cantitateProdusFinal = 0;
	Integer cantitateDeseu =0 ;
	ArrayList<Material> listaMateriale;
	ArrayList<Angajat> listaAngajati;
	ArrayList<Utilaj> listaUtilaje;
	ArrayList<Integer> cantitati;
	ArrayList<Object> resurse;
	
	
	@Override
	public FluxProductie definireFluxProductie(Integer idFlux, Produs produs)
			throws Exception {
		System.out.println("!>>>>>>>>>>>> START definire flux");
		
		logger.debug(">>>>>>>>>>>> START definire flux");		
		FluxProductie flux = new FluxProductie(idFlux, produs);
		
		logger.debug(">>>>>>>>>>>> END Definire Flux");
		return flux;
		
	}

	@Override
	public FazaProductie definireFazaProductie(String faza, FluxProductie flux,
			Utilaj utilaj, Double timpFolosire,
			ArrayList<FunctieNecesara> functiiNecesare,
			ArrayList<Material> materialeReteta,
			Semifabricat semifabricatDorit, Produs produsDorit, Divizie sectie,
			Integer nrOrdine, Boolean isFinal) throws Exception {
		
		logger.debug(">>>>>>>>>>>> START Creare faza >>>>>>>>>>>>>>> ");	
		
	    FazaProductie fazaProductie = new FazaProductie(faza, utilaj, timpFolosire, functiiNecesare, materialeReteta, semifabricatDorit, produsDorit, sectie, nrOrdine, isFinal);
	    
	    flux.adaugaFaza(fazaProductie);
	    fazaProductie.setFlux(flux);
		
	    ArrayList<Angajat> listaAngajati = new ArrayList<Angajat>();
	    for (int f=0;f<functiiNecesare.size();f++){
			int nrAngajati=functiiNecesare.get(f).getNrAngajatiFunctie();
			
			for(int a=1;a<=nrAngajati;a++){
				Angajat angajat =new Angajat();
					
				angajat.setId(1);
			
				listaAngajati.add(angajat);
			}
		}
	    
	    fazaProductie.setAngajati(listaAngajati);
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
		
		logger.debug(">>>>>>>>>>>> END Creare faza >>>>>>>>>>>>>>>");
		
		return fazaProductie;
		
	}

	@Override
	public FazaProductie getFazaFlux(FluxProductie flux, Integer nrOrdine) {
		List<FazaProductie> fzList=new ArrayList<FazaProductie>();
		FazaProductie fazaObtinuta = new FazaProductie();
		fzList=flux.getFaze();
		for(int i=0; i<fzList.size();i++){
			if (fzList.get(i).getNrOrdine()==nrOrdine){
				fazaObtinuta=fzList.get(i);
			}
			else{
				fazaObtinuta=null;
			}
		}
		return fazaObtinuta;
	}
	
	@Override
	public Produs lansareComandaProductie(ComandaProductie comanda,
			Produs produs) throws Exception {
		return produs;
	}

	@Override
	public ArrayList<Object> consumResursa(FazaProductie faza, Produs produs)
			throws Exception {
		  listaMateriale = new ArrayList<Material>();
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
	public ArrayList<Integer> controlCalitate(Produs produs) throws Exception {
		  Boolean trecut;
		  ComandaProductie comanda;
		  
		  Integer cantitate;  
		  CriteriuCalitate criteriuCalitate;
		  ArrayList<Integer> cantitati = new ArrayList<Integer>();
		  criteriuCalitate = new CriteriuCalitate(1, "criteriu 1");
		  criteriuCalitate.getCriteriu();
		  
		  comanda=new ComandaProductie(produs, 10, null);  
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
	public Integer livrareProdus(Integer cantitateProdus, Produs produs)
			throws Exception {
		   return 0;
	}

	@Override
	public ArrayList<Object> inregistrareGestiuneConsum(FazaProductie faza,
			Produs produs) throws Exception {
		consumResursa(faza, produs);
		return resurse;
	}

	@Override
	public ArrayList<Integer> inregistrareGestiuneProductie(Produs produs)
			throws Exception {
		controlCalitate(produs);
		return cantitati;
	}

	@Override
	public FluxProductie getFlux(Integer idFlux) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fabricare(Produs produs, Integer idFlux) throws Exception {
FluxProductie fluxPr = productie.getFlux(idFlux);
		
		List<FazaProductie> fazePr = fluxPr.getFaze();
		
		int n = fazePr.size();
		int i;
		for (i = 0; i < n - 1; i++) {
			fazePr.get(i).procesareSemifabricat();
			logger.info("Procesare semifabricat: " + fazeFlux.get(i).procesareSemifabricat() );
		}
		if(i==n){
			fazePr.get(n - 1).procesareProdus();
			logger.info("Procesare produs: " +fazeFlux.get(n - 1).procesareProdus());
		}
		
	}

	

	@Override
	public void comandaMateriale(FazaProductie faza, FluxProductie flux)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FluxProductie> getListaFluxuri() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stergeFlux(FluxProductie flux) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Semifabricat> getListaSemifabricate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stergeSemifabricat(Semifabricat semifabricat) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Semifabricat salveazaSemifabricat(Integer idSemifabricat,
			String semifabricat, ArrayList<Material> listaMateriale,
			Semifabricat semifabricatContinut) throws Exception {
		Semifabricat semif = new Semifabricat(idSemifabricat, semifabricat, listaMateriale, semifabricatContinut);		
		
		return semif;
	}

	@Override
	public List<CriteriuCalitate> getCriteriiCalitate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stergeCriteriuCalitate(CriteriuCalitate criteriu)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CriteriuCalitate salveazaCriteriuCalitate(Integer idCriteriu,
			String criteriu) throws Exception {
		CriteriuCalitate criteriuCalitate = new CriteriuCalitate(idCriteriu, criteriu);		
		
		return criteriuCalitate;
	}

	@Override
	public FazaProductie getFazaProductie(String faza) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FazaProductie> getListaFaze() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stergeFaza(FazaProductie faza) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utilaj> getUtilaje() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stergeUtilaj(Utilaj utilaj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNomenclatoareSrv(NomenclatoareSrv nomenclatoareSrv) {
		// TODO Auto-generated method stub
		
	}

	
	
}
