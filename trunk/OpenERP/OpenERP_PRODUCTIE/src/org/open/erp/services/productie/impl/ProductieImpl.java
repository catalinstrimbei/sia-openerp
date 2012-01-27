package org.open.erp.services.productie.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.NomenclatoareSrvLocal;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.PersonalSrvLocal;
//import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.productie.ComandaProductie;
import org.open.erp.services.productie.CriteriuCalitate;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FluxProductie;
import org.open.erp.services.productie.FunctieNecesara;
import org.open.erp.services.productie.ProductieSrvLocal;
import org.open.erp.services.productie.ProductieSrvRemote;
import org.open.erp.services.productie.Utilaj;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.Semifabricat;




/**
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */
@Stateful (name="ProductieSrv")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProductieImpl implements ProductieSrv, ProductieSrvLocal, ProductieSrvRemote {
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ProductieImpl.class.getName());

	//private static PersonalSrv personal;
	private static ProductieSrv productie;
	//private static StocuriSrv stocuri;
	
	@PersistenceContext(unitName="OpenERP_PRODUCTIE")
	private EntityManager em;
	
	@Resource
	private SessionContext sessionContext;
	
	@PostConstruct
	public void init(){
		logger.debug("EntityManager: " + em);		
				
		if (this.registru == null)
			registru = new RegistruProductie(em);
	}
	
	private RegistruProductie registru = new RegistruProductie();
	
	ArrayList<FazaProductie> fazeFlux;
	Integer cantitateProdusFinal = 0;
	Integer cantitateDeseu =0 ;
	ArrayList<Material> listaMateriale;
	ArrayList<Angajat> listaAngajati;
	ArrayList<Utilaj> listaUtilaje;
	ArrayList<Integer> cantitati;
	ArrayList<Object> resurse;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public FluxProductie definireFluxProductie(Integer idFlux, Produs produs) throws Exception{
		
		// creez un flux pentru produsul 'produs' (pe care il primesc ca parametru), fara a adauga faze		
		
		System.out.println("!>>>>>>>>>>>> START definire flux");
		
		logger.debug(">>>>>>>>>>>> START definire flux");		
		FluxProductie flux = new FluxProductie(idFlux, produs);
		
		/* Actiune tranzactionala ... */
		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END Definire flux - TRANZACTIE ANULATA");
			//throw new RuntimeException("Creare proiect - TRANZACTIE ANULATA");
		}else{
			flux = this.registru.salveazaFlux(flux);
			//em.persist(proiectNou);
		}
		
		logger.debug(">>>>>>>>>>>> END Definire Flux");
		return flux;
				
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void comandaMateriale(FazaProductie faza, FluxProductie flux){
		/*
		logger.debug(">>>>>>>>>>>> Start comandaMateriale");
		 CerereAprovizionare cerere = new CerereAprovizionare(1, new Date(), null, null);
			logger.debug(">>>>>>>>>>>> START cerere aprovizionare");
			LinieDocument linie;
			ArrayList<Material> listaMateriale = new ArrayList<Material>();
			listaMateriale = faza.getMaterialeReteta();
			for (int i=0; i<listaMateriale.size(); i++){
				linie = new LinieDocument();
				//linie.setMaterial(listaMateriale.get(i));
				linie.setCantitate(1.00);
				linie.setDocument(cerere);
				linie.setLinieDoc(i);
			}
			logger.debug(">>>>>>>>>>>> END cerere aprovizionare");
			stocuri.consumProductie(cerere);
			
		logger.debug(">>>>>>>>>>>> END comandaMateriale");*/
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public FazaProductie definireFazaProductie(String faza, FluxProductie flux,
			Utilaj utilaj, Double timpFolosire, ArrayList<FunctieNecesara> functiiNecesare,
			ArrayList<Material> materialeReteta,
			Semifabricat semifabricatDorit, Produs produsDorit,
			Divizie sectie, Integer nrOrdine, Boolean isFinal) throws Exception {
		
		logger.debug(">>>>>>>>>>>> START Creare faza >>>>>>>>>>>>>>> ");	
		
	    FazaProductie fazaProductie = new FazaProductie(faza, utilaj, timpFolosire, functiiNecesare, materialeReteta, semifabricatDorit, produsDorit, sectie, nrOrdine, isFinal);
	    
	    flux.adaugaFaza(fazaProductie);
	    fazaProductie.setFlux(flux);
		
	    ArrayList<Angajat> listaAngajati = new ArrayList<Angajat>();
	    for (int f=0;f<functiiNecesare.size();f++){
			int nrAngajati=functiiNecesare.get(f).getNrAngajatiFunctie();
			
			for(int a=1;a<=nrAngajati;a++){
				Angajat angajat =new Angajat();
					
				//ar trebui o metoda 'get angajat by functie'
				//angajat=personal.getAngajatById(a);
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
	    
	    
	    this.registru.salveazaFaza(fazaProductie);
		logger.debug(">>>>>>>>>>>> Faza salvata in flux >>>>>>>>>>>>>>>");
		
		logger.debug(">>>>>>>>>>>> END Creare faza >>>>>>>>>>>>>>>");
		
		return fazaProductie;
		
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public FazaProductie getFazaFlux(FluxProductie flux,Integer nrOrdine){
		
		ArrayList<FazaProductie> fzList=new ArrayList<FazaProductie>();
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
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Produs lansareComandaProductie(ComandaProductie comanda, Produs produs)  throws Exception{
		  // cautare faze pentru produsul x in baza de date;
		   //de lamurit cu comanda productie - modulul stocuri
		  //definireFluxProductie(idFlux, produs);
		   
		   return produs;
		 }

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ArrayList<Object> consumResursa(FazaProductie faza, Produs produs)  throws Exception{
		 	  
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

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ArrayList<Integer> controlCalitate(Produs produs)  throws Exception {
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
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Integer livrareProdus(Integer cantitateProdus, Produs produs)  throws Exception{
		  /*ArticolStoc stocProduse;
		  stocProduse=new ArticolStoc();
		  cantitateProdus=cantitati.get(0);
		  stocProduse.getCatitateStocPeGestiune();
		  if (stocProduse.getIdArticolStoc() == produs.getIdMaterial()){
		   return cantitateProdus;
		  }
		  
		  else{
		   
		   System.out.println("Nu exista comanda pentru produsul");}*/
		   return 0; 
		   
		  
		 }

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ArrayList<Object> inregistrareGestiuneConsum(FazaProductie faza,Produs produs)  throws Exception{
		consumResursa(faza, produs);
		return resurse;
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ArrayList<Integer> inregistrareGestiuneProductie(Produs produs) throws Exception{
		controlCalitate(produs);
		return cantitati;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public FluxProductie getFlux(Integer idFlux)  throws Exception{
		return registru.getFluxProductie(idFlux);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void fabricare(Produs produs, Integer idFlux) throws Exception{

		FluxProductie fluxPr = productie.getFlux(idFlux);
		
		ArrayList<FazaProductie> fazePr = fluxPr.getFaze();
		
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
	
	@EJB(mappedName="PersonalSrv/local") 
	private PersonalSrvLocal personalSrv;
	
	public PersonalSrv getPersonalSrv() {
		return personalSrv;
	}

	public void setPersonalSrv(PersonalSrv personalSrv) {
		this.personalSrv = (PersonalSrvLocal) personalSrv;
	}

	@EJB(mappedName="NomenclatoareSrv/local") 
	private NomenclatoareSrvLocal nomenclatoareSrv;
	
	public NomenclatoareSrv getNomenclatoareSrv() {
		return nomenclatoareSrv;
	}

	public void setNomenclatoareSrv(NomenclatoareSrv nomenclatoareSrv) {
		this.nomenclatoareSrv = (NomenclatoareSrvLocal) nomenclatoareSrv;
	}

	@Override
	public List<FluxProductie> getListaFluxuri() throws Exception {
		List<FluxProductie> fluxuri=this.registru.getListaFluxuri();
		return fluxuri;
	}
	
	public void stergeFlux(FluxProductie flux)throws Exception{
		registru.stergeFlux(flux);
	}
	
	@Override
	public List<Semifabricat> getListaSemifabricate() throws Exception {
		List<Semifabricat> semifabricate=this.registru.getListaSemifabricate();
		return semifabricate;
	}
	
	@Override
	public List<CriteriuCalitate> getCriteriiCalitate() throws Exception{
		List<CriteriuCalitate> criterii = this.registru.getListaCriterii();
		return criterii;
	}
	
	public void stergeCriteriuCalitate(CriteriuCalitate criteriu)throws Exception{
		registru.stergeCriteriuCalitate(criteriu);
	}
	
public CriteriuCalitate salveazaCriteriuCalitate(Integer idCriteriu, String criteriu) throws Exception{
		
	
			
		CriteriuCalitate criteriuCalitate = new CriteriuCalitate(idCriteriu, criteriu);		
		/* Actiune tranzactionala ... */
		if (sessionContext.getRollbackOnly() == true){
			logger.debug(">>>>>>>>>>>> END salvare criteriu - TRANZACTIE ANULATA");
			
		}else{
			criteriuCalitate = this.registru.salveazaCriteriuCalitate(criteriuCalitate);
			//em.persist(proiectNou);
		}
		
		return criteriuCalitate;
				
	}

	@Override
	public FazaProductie getFazaProductie(String faza) throws Exception {
		FazaProductie fazaP=this.registru.getFazaProductie(faza);
		return fazaP;
	}
	
	@Override
	public List<FazaProductie> getListaFaze() throws Exception{
		List<FazaProductie> faze=this.registru.getListaFaze();
		return faze;
	}

@Override
	public void stergeFaza(FazaProductie faza) throws Exception{
		registru.stergeFaza(faza);
	}
	
}
