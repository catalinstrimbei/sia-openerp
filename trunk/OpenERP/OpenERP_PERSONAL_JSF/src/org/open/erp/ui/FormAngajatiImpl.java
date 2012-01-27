package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.PersonalSrvLocal;
import org.open.erp.services.personal.logger.PersonalLogger;

import com.google.common.base.Functions;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;

@SessionScoped
public class FormAngajatiImpl implements Converter{

	private Angajat angajat;
	private List<Angajat> angajati = new ArrayList<Angajat>();
	
	private PersonalLogger logger;
		
	@EJB(mappedName="PersonalSrv/local", name="PersonalSrv/local") 
	private PersonalSrvLocal personalSrv;
	
	@PostConstruct
	public void initFormAngajati() throws Exception{
		logger = new PersonalLogger();
		
		angajati = (List<Angajat>) personalSrv.getListaAngajati();
		if (!angajati.isEmpty())
			angajat = angajati.get(0);
		else{
			System.out.println("Nu exista angajati!!!");
			this.angajat = new Angajat();
			angajat.setNume("Def angajat ...");
		}
	}

	public Angajat getAngajat() {
		return angajat;
	}

	public void setAngajat(Angajat angajat) {
		logger.logINFO("<<<<<<setAngajat: " + angajat.getNume() + angajat.getId());
		this.angajat = angajat;
	}
	
	public List<Angajat> getAngajatiList(){
		return this.angajati;
	}
	
	public Map<String, Angajat> getAngajati(){
		logger.logINFO("getAngajati : " + this.angajati.size());
		Map<String, Angajat> mapAngajati = new HashMap<String, Angajat>();
		for (Angajat a: angajati){
			logger.logINFO("<<<<<<Map getAngajati:" + a.getNume());
			mapAngajati.put(a.getNume() + " " + a.getPrenume() + " | " + a.getId(), a);
		}
		return mapAngajati;
	} 

	public void setAngajati(List<Angajat> angajati) {
		this.angajati = angajati;
	}

	/* Implementare navigare */
	public void previousAngajat(ActionEvent evt){
		Integer idxCurent = this.angajati.indexOf(angajat);
		if (idxCurent > 0)
			this.angajat = this.angajati.get(idxCurent - 1);
	}

	public void nextAngajat(ActionEvent evt){
		Integer idxCurent = this.angajati.indexOf(angajat);
		if ((idxCurent+1) < this.angajati.size())
			this.angajat = this.angajati.get(idxCurent + 1);
	}	

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

	// operatie invocata la generare elemente pentru lista, 
	// dupa getAngajati, dar inainte de popularea listei
	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		//if (uiValue!=null){
			
		
		if (uiComp.getId().equals("cboAngajat")){
			//logger.logINFO("<<<<<<<<<< getAsString uiValue angajat:"+uiValue);
			Angajat uiAngajat = (Angajat)uiValue;
			logger.logINFO("<<<<<<<<<< getAsString uiValue angajat:"+uiAngajat.getNume() + " id: " + uiAngajat.getId());
			//logger.logINFO("getAsString uiValue 2:"+uiSpor.getIdSpor());
			if (uiAngajat.getId()!=null)
				return uiAngajat.getId().toString();
		}
		// }
		return null;
	}
	/* Implementare operatii CRUD */
	public void adaugareAngajat(ActionEvent evt){
		this.angajat = new Angajat();
		//angajat.setId(999);
		//angajat.setNume("");
		this.angajati.add(this.angajat);
		  
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
	public void salvareAngajat(ActionEvent evt) throws Exception{
		//this.angajati.remove(this.angajat);
		
		this.angajat = personalSrv.salveazaAngajat(this.angajat);
		logger.logINFO("Dupa salvare am angajatID: " + angajat.getId());
		this.angajati.add(this.angajat);
	}
	
	/*
	public DataModel<Pontaj> getPontaje() {
		logger.logINFO("Check model pontaje ... ");
		if (this.pontaje == null)
			populareModelPontaje();
		return pontaje;
	}
	
	private void populareModelPontaje(){
		if (luna != null){
			this.activitati = new ListDataModel<Activitate>();
			this.activitati.setWrappedData(proiect.getActivitati());
			logger.debug("Populare model activitati ... DEBUG ");
		}else
			this.activitati = null;
	}
*/
		
}
