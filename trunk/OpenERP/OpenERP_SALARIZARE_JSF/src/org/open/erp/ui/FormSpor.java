package org.open.erp.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.PersonalSrvLocal;
import org.open.erp.services.salarizare.SalarizareSrvLocal;
import org.open.erp.services.salarizare.Spor;
import org.open.erp.services.salarizare.impl.SalarizareLogger;

import com.google.common.base.Functions;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;
 
@ManagedBean(name="formSpor")
@SessionScoped
public class FormSpor implements Converter{
	private Spor spor;
	private Angajat angajat;
	private List<Spor> sporuri = new ArrayList<Spor>();
	
	private Map<String, Integer> mapLuni = new HashMap<String, Integer>();
	
	private Map<String, Integer> mapModCalcul = new HashMap<String, Integer>();
	
	private Map<String, Integer> mapTip = new HashMap<String, Integer>();
	
	private List<Angajat> angajati = new ArrayList<Angajat>();
	private static SalarizareLogger logger;
	
	@PostConstruct
	public void initFormSpor() throws Exception{
		logger = new SalarizareLogger();
		//angajat = salarizareSrv.getAngajatById(1);
		sporuri = salarizareSrv.getSporuriGenerale();
		if (!sporuri.isEmpty())
			spor = sporuri.get(0);
		
		angajati = (List<Angajat>) personalSrv.getListaAngajati();
		//if (!angajati.isEmpty())
			//angajat = angajati.get(0);
	}
	
	@EJB(mappedName="SalarizareImpl/local", name="SalarizareImpl/local") 
	private SalarizareSrvLocal salarizareSrv;

	@EJB(mappedName="PersonalSrv/local", name="PersonalSrv/local") 
	private PersonalSrvLocal personalSrv;
	
	public Map<String, Angajat> getAngajati(){
		Map<String, Angajat> mapAngajati = new HashMap<String, Angajat>();
		for (Angajat a: angajati){
			//logger.logINFO("<<<<<<Map getAngajati:" + a.getNume());
			mapAngajati.put(a.getNume() + " " + a.getPrenume() + " | " + a.getMarca(), a);
		}
		return mapAngajati;
	}
	
	public List<Angajat> getAngajatiList(){
		return this.angajati;
	}

	public Spor getSpor() {
		return spor;
	}

	public void setSpor(Spor spor) {
		this.spor = spor;
	}

	/*
	public List<Spor> getSporuri() {
		return sporuri;
	}

	public void setSporuri(List<Spor> sporuri) {
		this.sporuri = sporuri;
	}

	*/
	/* Implementare navigare */
	public void previousSpor(ActionEvent evt){
		Integer idxCurent = this.sporuri.indexOf(spor);
		if (idxCurent > 0)
			this.spor = this.sporuri.get(idxCurent - 1);
	}

	public void nextSpor(ActionEvent evt){
		Integer idxCurent = this.sporuri.indexOf(spor);
		if ((idxCurent+1) < this.sporuri.size())
			this.spor = this.sporuri.get(idxCurent + 1);
	}	
	
	/* Implementare operatii CRUD */
	public void adaugareSpor(ActionEvent evt){
		this.spor = new Spor();
		this.spor.setIdSpor(9999);
		this.spor.setDenumire("");
		this.sporuri.add(this.spor);
		logger.logINFO("Sunt in bean, incercam sa adaugam un sporul" );
		//return "FormSpor";
	} 
	  
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
	 
	public void salvareSpor(ActionEvent evt) throws Exception{
		this.sporuri.remove(this.spor);
		
		this.spor = salarizareSrv.inregistrareSpor(spor.getIdSpor(),spor.getDenumire(), spor.getTip(), spor.getAn(), spor.getLuna(), spor.getAngajat()
				, spor.getModCalcul(), spor.getValoare());
		logger.logINFO("Dupa salvare am sporID: " + spor.getIdSpor());
		this.sporuri.add(this.spor);
	//	return "FormSpor";
	}
	
	/* Implementare suport pentru navigare-selectie lista combinata*/
	public Map<String, Spor> getSporuri(){
		Map<String, Spor> mapSporuri = new HashMap<String, Spor>();
		for (Spor s: sporuri){
			mapSporuri.put(s.getDenumire(), s);
		}
		return mapSporuri;
	}
	
	public List<Spor> getSporuriList(){
		return this.sporuri;
	}
	/*
	public void abandonClient(ActionEvent evt){
		if (this.em.contains(this.client))
			this.em.refresh(this.client);
	}
	*/
 
	//operatie invocata la selectie din lista, dar inainte de setSpor
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		// TODO Auto-generated method stub
		if (uiComp.getId().equals("cboSpor")){
			Spor uiSporTemplate = new Spor(Integer.valueOf(uiValue), null, null, null, null, null, null, null);
			int idx = this.sporuri.indexOf(uiSporTemplate);
			//logger.logINFO("Id-ul din array este:"+idx);
			return this.sporuri.get(idx); 
		}
		
		if (uiComp.getId().equals("cboAngajat")){
			Angajat uiAngajatTemplate = new Angajat();
			uiAngajatTemplate.setId(Integer.valueOf(uiValue));
			Integer idx = this.angajati.indexOf(uiAngajatTemplate);
			logger.logINFO("Id-ul angajatului din array este:"+angajati.get(idx).getNume());
		//	spor.setAngajat(uiAngajatTemplate);
			return this.angajati.get(idx);
		}
		 
		return null;
	}
   
	// operatie invocata la generare elemente pentru lista, 
	// dupa getSporuri, dar inainte de popularea listei
	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		// TODO Auto-generated method stub
		if (uiComp.getId().equals("cboSpor")){
			//logger.logINFO("getAsString uiValue:"+uiValue.toString());
			Spor uiSpor = (Spor)uiValue;
			//logger.logINFO("getAsString uiValue 2:"+uiSpor.getIdSpor());
			if (uiSpor.getIdSpor()!=null) //poate veni null din click Add
				return uiSpor.getIdSpor().toString();
		}
		 
		if (uiComp.getId().equals("cboAngajat")){
			if (uiValue != null){
				Angajat uiAngajat = (Angajat)uiValue;
				logger.logINFO("<<<<<<<<<< getAsString uiValue angajat:"+uiAngajat.getNume());
				return uiAngajat.getId().toString();
			}	
		}
		return null;
	}

	public Map<String, Integer> getMapLuni() {
		
		mapLuni.put("Ianuarie", 1);
		mapLuni.put("Februarie", 2);
		mapLuni.put("Martie", 3);
		mapLuni.put("Aprilie", 4);
		mapLuni.put("Mai", 5);
		mapLuni.put("Iunie", 6);
		
		mapLuni.put("Iulie", 7);
		mapLuni.put("August", 8);
		mapLuni.put("Septembrie", 9);
		mapLuni.put("Octombrie", 10);
		mapLuni.put("Noiembrie", 11);
		mapLuni.put("Decembrie", 12);
		
	//	valueComparator = Ordering.natural().onResultOf(Functions.forMap(mapLuni));
		
		return ImmutableSortedMap.copyOf(mapLuni, Ordering.natural().onResultOf(Functions.forMap(mapLuni)));

	 	 
		//return mapLuni;
	}

	public void setMapLuni(Map<String, Integer> mapLuni) {
		this.mapLuni = mapLuni;
	}

	public Map<String, Integer> getMapModCalcul() {
		mapModCalcul.put("Valoare", 1);
		mapModCalcul.put("Procent", 2);
		return mapModCalcul;
	}

	public void setMapModCalcul(Map<String, Integer> mapModCalcul) {
		this.mapModCalcul = mapModCalcul;
	}

	public Map<String, Integer> getMapTip() {
		mapTip.put("general", 1);
		mapTip.put("angajat", 2);
		return mapTip;
	}

	public void setMapTip(Map<String, Integer> mapTip) {
		this.mapTip = mapTip;
	}
	
	public void validate(FacesContext arg0, UIComponent uiComponent, Object uiValue)
			throws ValidatorException {
		logger.logINFO("Validam");
		if ("spor_denumire".equals(uiComponent.getId())){
			String denumire = uiValue.toString();
			logger.logINFO("Validam denumire " + denumire);
			FacesMessage mesaj = null;
			if (denumire == null || denumire.isEmpty()){
				mesaj = new FacesMessage("Numele sporului trebuie completat!");
			}
			
			if (mesaj != null){
				throw new ValidatorException(mesaj);
			}
		}
		
	}

	public Angajat getAngajat() {
		return angajat;
	}

	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}
	
	
}

