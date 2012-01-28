package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.open.erp.services.personal.Functie;
import org.open.erp.services.personal.PersonalSrvLocal;
import org.open.erp.services.personal.logger.PersonalLogger;


//@ManagedBean(name="formFunctie")
@SessionScoped
public class FormFunctiiImpl implements Converter{
	private Functie functie;	
	private List<Functie> functii = new ArrayList<Functie>();
	
	
	private static PersonalLogger logger;
	@PostConstruct
	public void initFormFunctii() throws Exception{
		logger = new PersonalLogger();
		functii = (List<Functie>) personalSrv.getListaFunctii();
		if (!functii.isEmpty())
			functie = functii.get(0);
		else{
			System.out.println("Nu exista functii!!!");
			this.functie = new Functie();
			functie.setNumeFunctie("Def functie ...");
		}
	}
	/*
	@EJB(mappedName="SalarizareImpl/local", name="SalarizareImpl/local") 
	private SalarizareSrvLocal salarizareSrv;
	*/
	@EJB(mappedName="PersonalSrv/local", name="PersonalSrv/local") 
	private PersonalSrvLocal personalSrv;
	
	public Functie getFunctie() {
		return functie;
	}

	public void setFunctie(Functie functie) {
		logger.logINFO("<<<<<<setFunctie: " + functie.getNumeFunctie());
		this.functie = functie;
	}

	
	public List<Functie> getFunctiiList(){
		return this.functii;
	}
	
	public Map<String, Functie> getFunctii(){
		logger.logINFO("getFunctii : " + this.functii.size());
		Map<String, Functie> mapFunctii = new HashMap<String, Functie>();
		for (Functie f: functii){
			logger.logINFO("<<<<<<Map getFunctii:" + f.getNumeFunctie());
			mapFunctii.put(f.getNumeFunctie()  + " | " + f.getIdFunctie(), f);
		}
		return mapFunctii;
	} 

	public void setFunctii(List<Functie> functii) {
		this.functii = functii;
	}

	/* Implementare navigare */
	public void previousFunctie(ActionEvent evt){
		Integer idxCurent = this.functii.indexOf(functie);
		logger.logINFO("INDEX CURENT:" + idxCurent);
		if (idxCurent > 0)
			this.functie = this.functii.get(idxCurent - 1);
	}

	public void nextFunctie(ActionEvent evt){
		Integer idxCurent = this.functii.indexOf(functie);
		logger.logINFO("INDEX CURENT:" + idxCurent);
		if ((idxCurent+1) < this.functii.size())
			this.functie = this.functii.get(idxCurent + 1);
	}	

	//operatie invocata la selectie din lista
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		logger.logINFO("<<<<<<<uiValue este:"+uiValue);
		//if (uiValue!=null){
		if (uiComp.getId().equals("cboFunctie")){
			Functie uiFunctieTemplate = new Functie();
			//uiFunctieTemplate.setIdFunctie(Integer.valueOf(uiValue));
			try {
				uiFunctieTemplate = personalSrv.getFunctieById(Integer.valueOf(uiValue));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//in personal nu am metoda equals
			
			logger.logINFO("<<<<<<<Size Functii "+functii.size());
			
			for (Functie f: functii){
				logger.logINFO("<<<<<<Indexul functiei:" + f.getIdFunctie() + " este" + functii.indexOf(f));
				
			}
			logger.logINFO("ID-ul functiei setate este: " + uiFunctieTemplate.getIdFunctie());
			Integer idx = functii.indexOf(uiFunctieTemplate);
			logger.logINFO("<<<<<<<getAsObject: INDEX-ul functiei din array este:"+idx);
			return functii.get(idx);
		} 
		//}
		return null;
	}
	
	/*
	//operatie invocata la selectie din lista, dar inainte de setLuna, An, Angajat
		@Override
		public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
			logger.logINFO("<<<<<<<uiValue este:"+uiValue);
			//if (uiValue!=null){
			if (uiComp.getId().equals("cboAngajat")){
				Angajat uiAngajatTemplate = new Angajat();
				uiAngajatTemplate.setId(Integer.valueOf(uiValue));
				//in personal nu am metoda equals
				Integer idx = this.angajati.indexOf(uiAngajatTemplate);
				logger.logINFO("<<<<<<<getAsObject: Id-ul angajatului din array este:"+idx);
				return this.angajati.get(idx);
			} 
			//}
			return null;
		}
	*/

	// operatie invocata la generare elemente pentru lista, 
	// dupa getAngajati, dar inainte de popularea listei
	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		//if (uiValue!=null){
			
		
		if (uiComp.getId().equals("cboFunctie")){
			//logger.logINFO("<<<<<<<<<< getAsString uiValue functie:"+uiValue);
			Functie uiFunctie = (Functie)uiValue;
			logger.logINFO("<<<<<<<<<< getAsString uiValue functie:"+uiFunctie.getNumeFunctie() + " id: " + uiFunctie.getIdFunctie());
			//logger.logINFO("getAsString uiValue 2:"+uiSpor.getIdSpor());
			if (uiFunctie.getIdFunctie()!=null)
				return uiFunctie.getIdFunctie().toString();
		}
		// }
		return null;
	}
	/* Implementare operatii CRUD */
	public void adaugareFunctie(ActionEvent evt){
		this.functie = new Functie();
		//angajat.setId(999);
		//angajat.setNume("");
		this.functii.add(this.functie);
		  
		//return "FormPontajAngajat";
		//logger.logINFO("Sunt in bean, incercam sa adaugam un sporul" );
		//return "FormSpor";
	}  
	  /*
	public void stergereSpor(ActionEvent evt) throws Exception{
		this.sporuri.remove(this.spor);
		logger.logINFO("Sunt in bean, incercam sa stergem sporul cu id: "+spor.getIdSpor());
		salarizareSrv.stergeSpor(this.spor);
		 
		if (!this.sporuri.isEmpty())
			this.spor = this.sporuri.get(0);
		else
			this.spor = null;
		
		//return "FormSpor";
	} 
	 */
	public void salvareFunctie(ActionEvent evt) throws Exception{
		//this.angajati.remove(this.angajat);
		
		this.functie = personalSrv.salveazaFunctie(this.functie);
		logger.logINFO("Dupa functie : " + functie.getIdFunctie());
		this.functii.add(this.functie);
	}
	
	
		
}
