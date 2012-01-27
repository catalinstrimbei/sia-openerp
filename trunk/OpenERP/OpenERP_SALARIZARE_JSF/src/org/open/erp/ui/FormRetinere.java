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
import org.open.erp.services.salarizare.Retinere;
import org.open.erp.services.salarizare.impl.SalarizareLogger;

import com.google.common.base.Functions;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;
 
@ManagedBean(name="formRetinere")
@SessionScoped
public class FormRetinere implements Converter{
	private Retinere retinere;
	private Angajat angajat;
	private List<Retinere> retineri = new ArrayList<Retinere>();
	
	private Map<String, Integer> mapLuni = new HashMap<String, Integer>();
	
	private Map<String, Integer> mapModCalcul = new HashMap<String, Integer>();
	
	private Map<String, Integer> mapTip = new HashMap<String, Integer>();
	
	private List<Angajat> angajati = new ArrayList<Angajat>();
	private static SalarizareLogger logger;
	
	@PostConstruct
	public void initFormRetinere() throws Exception{
		logger = new SalarizareLogger();
		//angajat = salarizareSrv.getAngajatById(1);
		retineri = salarizareSrv.getRetineriGenerale();
		if (!retineri.isEmpty())
			retinere = retineri.get(0);
		
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

	public Retinere getRetinere() {
		return retinere;
	}

	public void setRetinere(Retinere retinere) {
		this.retinere = retinere;
	}

	/*
	public List<Retinere> getRetineri() {
		return retineri;
	}

	public void setRetineri(List<Retinere> retineri) {
		this.retineri = retineri;
	}

	*/
	/* Implementare navigare */
	public void previousRetinere(ActionEvent evt){
		Integer idxCurent = this.retineri.indexOf(retinere);
		if (idxCurent > 0)
			this.retinere = this.retineri.get(idxCurent - 1);
	}

	public void nextRetinere(ActionEvent evt){
		Integer idxCurent = this.retineri.indexOf(retinere);
		if ((idxCurent+1) < this.retineri.size())
			this.retinere = this.retineri.get(idxCurent + 1);
	}	
	
	/* Implementare operatii CRUD */
	public void adaugareRetinere(ActionEvent evt){
		this.retinere = new Retinere();
		this.retinere.setIdRetinere(9999);
		this.retinere.setDenumire("");
		this.retineri.add(this.retinere);
		logger.logINFO("Sunt in bean, incercam sa adaugam un retinereul" );
		//return "FormRetinere";
	} 
	  
	public void stergereRetinere(ActionEvent evt) throws Exception{
		this.retineri.remove(this.retinere);
		logger.logINFO("Sunt in bean, incercam sa stergem retinereul cu id: "+retinere.getIdRetinere());
		salarizareSrv.stergeRetinere(this.retinere);
		 
		if (!this.retineri.isEmpty())
			this.retinere = this.retineri.get(0);
		else
			this.retinere = null;
		
		//return "FormRetinere";
	} 
	 
	public void salvareRetinere(ActionEvent evt) throws Exception{
		this.retineri.remove(this.retinere);
		
		this.retinere = salarizareSrv.inregistrareRetinere(retinere.getIdRetinere(),retinere.getDenumire(), retinere.getTip(), retinere.getAn(), retinere.getLuna(), retinere.getAngajat()
				, retinere.getModCalcul(), retinere.getValoare());
		logger.logINFO("Dupa salvare am retinereID: " + retinere.getIdRetinere());
		this.retineri.add(this.retinere);
	//	return "FormRetinere";
	}
	
	/* Implementare suport pentru navigare-selectie lista combinata*/
	public Map<String, Retinere> getRetineri(){
		Map<String, Retinere> mapRetineri = new HashMap<String, Retinere>();
		for (Retinere s: retineri){
			mapRetineri.put(s.getDenumire(), s);
		}
		return mapRetineri;
	}
	
	public List<Retinere> getRetineriList(){
		return this.retineri;
	}
	/*
	public void abandonClient(ActionEvent evt){
		if (this.em.contains(this.client))
			this.em.refresh(this.client);
	}
	*/
 
	//operatie invocata la selectie din lista, dar inainte de setRetinere
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		// TODO Auto-generated method stub
		if (uiComp.getId().equals("cboRetinere")){
			Retinere uiRetinereTemplate = new Retinere(Integer.valueOf(uiValue), null, null, null, null, null, null, null);
			int idx = this.retineri.indexOf(uiRetinereTemplate);
			//logger.logINFO("Id-ul din array este:"+idx);
			return this.retineri.get(idx); 
		}
		
		if (uiComp.getId().equals("cboAngajat")){
			Angajat uiAngajatTemplate = new Angajat();
			uiAngajatTemplate.setId(Integer.valueOf(uiValue));
			Integer idx = this.angajati.indexOf(uiAngajatTemplate);
			logger.logINFO("Id-ul angajatului din array este:"+angajati.get(idx).getNume());
		//	retinere.setAngajat(uiAngajatTemplate);
			return this.angajati.get(idx);
		}
		 
		return null;
	}
   
	// operatie invocata la generare elemente pentru lista, 
	// dupa getRetineri, dar inainte de popularea listei
	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		// TODO Auto-generated method stub
		if (uiComp.getId().equals("cboRetinere")){
			//logger.logINFO("getAsString uiValue:"+uiValue.toString());
			Retinere uiRetinere = (Retinere)uiValue;
			//logger.logINFO("getAsString uiValue 2:"+uiRetinere.getIdRetinere());
			if (uiRetinere.getIdRetinere()!=null) //poate veni null din click Add
				return uiRetinere.getIdRetinere().toString();
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
		mapTip.put("personal", 2);
		return mapTip;
	}

	public void setMapTip(Map<String, Integer> mapTip) {
		this.mapTip = mapTip;
	} 
	 
	public void validate(FacesContext arg0, UIComponent uiComponent, Object uiValue)
			throws ValidatorException {
		logger.logINFO("Validam");
		if ("retinere_denumire".equals(uiComponent.getId())){
			String denumire = uiValue.toString();
			logger.logINFO("Validam denumire " + denumire);
			FacesMessage mesaj = null;
			if (denumire == null || denumire.isEmpty()){
				logger.logINFO("Denumirea este goala " + denumire);
				mesaj = new FacesMessage("Numele retinereului trebuie completat!");
				//FacesContext.getCurrentInstance().addMessage("Validare esuata",mesaj);
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

