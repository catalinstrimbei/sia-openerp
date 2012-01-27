package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.NomenclatoareSrvLocal;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.PersonalSrvLocal;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FluxProductie;
import org.open.erp.services.productie.FunctieNecesara;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.ProductieSrvLocal;
import org.open.erp.services.productie.Semifabricat;
import org.open.erp.services.productie.Utilaj;



@ManagedBean(name="formDefinireFaza")
@SessionScoped
public class FormDefinireFaza implements Converter {
	
	String faza;
	
	FazaProductie fazaP;
	
	List<FazaProductie> faze = new ArrayList<FazaProductie>();
	
	FluxProductie flux;
	
	Utilaj utilaj;
	
	private List<Utilaj> utilaje = new ArrayList<Utilaj>();
	
	Double timpFolosire;
	
	/*ArrayList <FunctieNecesara> functiiNecesare;*/
		
	ArrayList<Angajat> angajati;
	
	ArrayList<Material> materialeReteta;
	
	Semifabricat semifabricatReteta;
	
	Semifabricat semifabricatDorit;
	
	Produs produsDorit;
	
	Semifabricat semifabricatObtinut;
	
	Produs produsObtinut;
	
	Divizie sectie;
	
	FunctieNecesara functieNecesara;
	
	FunctieNecesara functie;
	
	Material materialReteta;
	
	Integer nrOrdine;
	
	Boolean isFinal;
	
	Logger logger;
	
	Integer nrfunctii;
	/*----------------------------------*/
	
		
		@EJB(mappedName="ProductieSrv/local", name="ProductieSrv/local") 
		private ProductieSrvLocal productieSrv;
		
		@EJB(mappedName="NomenclatoareImpl/local", name="NomenclatoareImpl/local") 
		private NomenclatoareSrvLocal nomenclatoareSrv;
		
		@EJB(mappedName="PersonalSrv/local", name="PersonalSrv/local") 
		private PersonalSrvLocal personalSrv;
		
		public Map<String, Utilaj> getUtilaje(){
			Map<String, Utilaj> mapUtilaje = new HashMap<String, Utilaj>();
			for (Utilaj u : utilaje){
				mapUtilaje.put(u.getIdUtilaj().toString(), u); 
			}
			return mapUtilaje;
		}
	
		
		
		@PostConstruct
		public void initFormDefinireFaza() throws Exception{
			org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ProductieSrv.class.getName());
			
			faze = productieSrv.getListaFaze();
			if (!faze.isEmpty())
				fazaP = faze.get(0);
				}
		public Integer getNrOrdine() {
			return nrOrdine;
		}

		public void setNrOrdine(Integer nrOrdine) {
			this.nrOrdine = nrOrdine;
		}

		public Boolean getIsFinal() {
			return isFinal;
		}

		public void setIsFinal(Boolean isFinal) {
			this.isFinal = isFinal;
		}

		/*public Utilaj getUtilaj() {
			return utilaj;
		}

		public void setUtilaj(Utilaj utilaj) {
			this.utilaj = utilaj;
		}*/
		
		public void addMaterialeReteta(Material materialReteta) {
			this.materialReteta = materialReteta;
		}
		
		public Integer getNrfunctii() {
			return nrfunctii;
		}
		public void setNrfunctii(Integer nrfunctii) {
			this.nrfunctii = nrfunctii;
		}
		
		public void adaugaFunctieNecesara(FunctieNecesara functieNecesara) {
			this.functieNecesara=functieNecesara;
		}
		
		
		public Semifabricat getSemifabricatReteta() {
			return semifabricatReteta;
		}

		public void setSemifabricatReteta(Semifabricat semifabricatReteta) {
			this.semifabricatReteta = semifabricatReteta;
		}

		public Semifabricat getSemifabricatDorit() {
			return semifabricatDorit;
		}

		public void setSemifabricatDorit(Semifabricat semifabricatDorit) {
			this.semifabricatDorit = semifabricatDorit;
		}

		public Produs getProdusDorit() {
			return produsDorit;
		}

		public void setProdusDorit(Produs produsDorit) {
			this.produsDorit = produsDorit;
		}

		

		public Divizie getSectie() {
			return sectie;
		}

		public void setSectie(Divizie sectie) {
			this.sectie = sectie;
		}

		
		
		public void previousFaza(ActionEvent evt){
			Integer idxCurent = this.faze.indexOf(fazaP);
			if (idxCurent > 0)
				this.fazaP = this.faze.get(idxCurent - 1);
		}

		public void nextFaza(ActionEvent evt){
			Integer idxCurent = this.faze.indexOf(fazaP);
			if ((idxCurent+1) < this.faze.size())
				this.fazaP = this.faze.get(idxCurent + 1);
		}	
		
		
		/* Implementare operatii CRUD */
		public void adaugareFaza(ActionEvent evt){
			this.fazaP = new FazaProductie();
			this.fazaP.setFaza("");
			/*
			//setez mijlocul fix
			MijlocFix mf=new MijlocFix();
			mf.setId(1);
			mf.setDenumire("");
			mf.setAdresa(null);
			mf.setTermenExploatare(null);
			mf.setValoare(null);
			logger.info("*****Mijlocul fix a fost creat " + mf.getDenumire());
			//Setez utilajul;
			utilaj =new Utilaj();
			utilaj.setUtilaj(mf);
			utilaj.setStatus("");
			//this.fazaP.setUtilaj(utilaj);*/
			
			//setez timp folosire
			this.fazaP.setTimpFolosire(10.2);
			
			
			//setez functiile necesare
			
			this.fazaP.adaugaFunctieNecesara(functieNecesara);
			this.fazaP.addMaterialeReteta(materialReteta);
			this.fazaP.setSemifabricatDorit(semifabricatDorit);
			this.fazaP.setProdusDorit(produsDorit);
			this.fazaP.setSectie(sectie);
			this.fazaP.setNrOrdine(1);
			this.fazaP.setIsFinal(false);
			this.faze.add(this.fazaP);
			logger.info("Sunt in bean, incercam sa adaugam o faza" );
			//return "FormDefinireFaza";
			
		} 
		
		
		public void adaugareFunctie(ActionEvent evt){
			this.functie = new FunctieNecesara();
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
			
		}
		
		
		public void stergereFaza(ActionEvent evt) throws Exception{
			this.faze.remove(this.fazaP);
			logger.info("Sunt in bean, incercam sa stergem faza cu id: "+fazaP.getFaza());
			productieSrv.stergeFaza(this.fazaP);
			 
			if (!this.faze.isEmpty())
				this.fazaP = this.faze.get(0);
			else
				this.fazaP = null;
			
			//return "FormDefinireFaza";
		}
	
		
		public void salvareFaza(ActionEvent evt) throws Exception{
			this.faze.remove(this.fazaP);
			
			this.fazaP = productieSrv.definireFazaProductie(fazaP.getFaza(), fazaP.getFlux(), fazaP.getUtilaj(), fazaP.getTimpFolosire(),
					fazaP.getFunctiiNecesare(), fazaP.getMaterialeReteta(),
					fazaP.getSemifabricatDorit(), fazaP.getProdusDorit(), fazaP.getSectie(), fazaP.getNrOrdine(), fazaP.getIsFinal());
					
			logger.info("Dupa salvare am id-ul Fazei: " + fazaP.getFaza());
			this.faze.add(this.fazaP);
		//	return "FormDefinireFaza";
		}
		
		
		public Map<String, FazaProductie> getFaze(){
			Map<String, FazaProductie> mapFaze = new HashMap<String, FazaProductie>();
			for (FazaProductie fz: faze){
				mapFaze.put(fz.getFaza(), fz);
			}
			return mapFaze;
		}
		
		public List<FazaProductie> getFazeList(){
			return this.faze;
		}
		
		
		
		@Override
	
		public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
			
				if (uiComp.getId().equals("cboFaza")){
					FazaProductie uiFazaProductieTemplate = new FazaProductie(String.valueOf(uiValue), null,null, null, null, null, null, null, null, null);
					int idx = this.faze.indexOf(uiFazaProductieTemplate);
					//logger.logINFO("Id-ul din array este:"+idx);
					return this.faze.get(idx); 
				}
				
				if (uiComp.getId().equals("cboUtilaj")){
					Utilaj uiUtilajTemplate = new Utilaj();
					uiUtilajTemplate.setIdUtilaj(Integer.valueOf(uiValue));
					Integer idx = this.utilaje.indexOf(uiUtilajTemplate);
					logger.info("Id-ul utilajului din array este:"+utilaje.get(idx).getIdUtilaj());
				//	spor.setAngajat(uiAngajatTemplate);
					return this.utilaje.get(idx);
				}
		
			return null;
		}

		@Override
		public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
			// TODO Auto-generated method stub
			if (uiComp.getId().equals("cboFaza")){
				//logger.logINFO("getAsString uiValue:"+uiValue.toString());
				FazaProductie uiFaza = (FazaProductie)uiValue;
				//logger.logINFO("getAsString uiValue 2:"+uiSpor.getIdSpor());
				if (uiFaza.getFaza()!=null) //poate veni null din click Add
					return uiFaza.getFaza();
			}
			
			if (uiComp.getId().equals("cboUtilaj")){
				if (uiValue != null){
					Utilaj uiUtilaj = (Utilaj)uiValue;
					logger.info("<<<<<<<<<< getAsString uiValue utilaj:"+uiUtilaj.getStatus());
					return uiUtilaj.getIdUtilaj().toString();
				}	
	
			}
			return null;
		}
		
		}
		
		

