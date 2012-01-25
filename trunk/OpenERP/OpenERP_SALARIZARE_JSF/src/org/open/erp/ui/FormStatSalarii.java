package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.PersonalSrvLocal;
import org.open.erp.services.salarizare.Pontaj;
import org.open.erp.services.salarizare.SalarizareSrvLocal;
import org.open.erp.services.salarizare.StatSalarii;
import org.open.erp.services.salarizare.impl.SalarizareLogger;

import com.google.common.base.Functions;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;

public class FormStatSalarii implements Converter{

	private Integer luna;
	private Integer an;
	private Pontaj pontaj;
	private StatSalarii statSalarii;
	private List<StatSalarii> stateSalarii = new ArrayList<StatSalarii>();
	private List<Angajat> angajati = new ArrayList<Angajat>();
	
	private List<Integer> listAni = new ArrayList<Integer>();
	
	private Map<String, Integer> mapLuni = new HashMap<String, Integer>();
	private Map<String, Integer> mapAni = new HashMap<String, Integer>();
	
	private List<Pontaj> pontaje = new ArrayList<Pontaj>();
	
	private static SalarizareLogger logger;
	
	@EJB(mappedName="SalarizareImpl/local", name="SalarizareImpl/local") 
	private SalarizareSrvLocal salarizareSrv;
	
	@EJB(mappedName="PersonalSrv/local", name="PersonalSrv/local") 
	private PersonalSrvLocal personalSrv;
	
	@PostConstruct
	public void initFormPontaj() throws Exception{
		logger = new SalarizareLogger();
		//angajat = salarizareSrv.getAngajatById(1);
		logger.logINFO("<<<<<" + this.an);
		logger.logINFO("<<<<<" + this.luna);
		stateSalarii = salarizareSrv.getStatAnLuna(2009, 1);
		angajati = (List<Angajat>) personalSrv.getListaAngajati();
		if (!stateSalarii.isEmpty())
			statSalarii = stateSalarii.get(0);
		
		listAni.add(2009);
		listAni.add(2010);
		listAni.add(2011);
		listAni.add(2012);
		listAni.add(2013);
		//luna = mapLuni.get(0);
	}

	public StatSalarii getStatSalarii() {
		return statSalarii;
	}

	public void setStatSalarii(StatSalarii statSalarii) {
		this.statSalarii = statSalarii;
	}
	
	public List<StatSalarii> getStateSalarii() {
		return stateSalarii;
	}

	public void setStateSalarii(List<StatSalarii> stateSalarii) {
		this.stateSalarii = stateSalarii;
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
		
		return ImmutableSortedMap.copyOf(mapLuni, Ordering.natural().onResultOf(Functions.forMap(mapLuni)));
	}

	public void setMapLuni(Map<String, Integer> mapLuni) {
		this.mapLuni = mapLuni;
	}
	
	public List<Integer> getListAni() {
		return listAni;
	}

	public void setListAni(List<Integer> listAni) {
		this.listAni = listAni;
	}

	public Map<String, Angajat> getAngajati(){
		Map<String, Angajat> mapAngajati = new HashMap<String, Angajat>();
		for (Angajat a: angajati){
			logger.logINFO("<<<<<<Map getAngajati:" + a.getNume());
			mapAngajati.put(a.getNume() + " " + a.getPrenume() + " | " + a.getMarca(), a);
		}
		return mapAngajati;
	}
	
	public List<Angajat> getAngajatiList(){
		return this.angajati;
	}

	//operatie invocata la selectie din lista, dar inainte de setLuna, An, Angajat
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		if (uiComp.getId().equals("cboLuna")){
			//logger.logINFO("<<<<<<< Luna din array este:"+uiValue);
			luna = Integer.valueOf(uiValue);
			try {
				//if (pontaje.isEmpty()){
					stateSalarii = salarizareSrv.getStatAnLuna(this.an, this.luna);
					for(StatSalarii s:stateSalarii)
						logger.logINFO("stat salarii:" + s.getIdStatSalarii());
			//		logger.logINFO("<<<<<<< Am incarcat pontajele cu succes luna");
				//}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.logINFO("<<<<<<< FAIL incarcare stat salarii luna");
				e.printStackTrace();
			}
			return luna;
		}
		if (uiComp.getId().equals("cboAn")){
			//logger.logINFO("<<<<<<< Anul din array este:"+uiValue);
			an = Integer.valueOf(uiValue);
			try {
				//if (pontaje.isEmpty()){
				stateSalarii = salarizareSrv.getStatAnLuna(this.an, this.luna);
				//	logger.logINFO("<<<<<<< Am incarcat pontajele cu succes an");
				//}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.logINFO("<<<<<<< FAIL incarcare stat salarii");
				e.printStackTrace();
			}
			return an;
		}
		if (uiComp.getId().equals("cboAngajat")){
			Angajat uiAngajatTemplate = new Angajat();
			uiAngajatTemplate.setId(Integer.valueOf(uiValue));
			Integer idx = this.angajati.indexOf(uiAngajatTemplate);
			logger.logINFO("Id-ul angajatului din array este:"+idx);
			if (idx>=0)
				return this.angajati.get(idx);
		}
		return null;
	}

	// operatie invocata la generare elemente pentru lista, 
	// dupa getAngajati, dar inainte de popularea listei
	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		if (uiComp.getId().equals("cboAngajat")){
			logger.logINFO("<<<<<<<<<< getAsString uiValue angajat:"+uiValue);
			if (uiValue != null){
				
				Angajat uiAngajat = (Angajat)uiValue;
				logger.logINFO("<<<<<<<<<< getAsString uiValue angajat:"+uiAngajat.getNume());
				//logger.logINFO("getAsString uiValue 2:"+uiSpor.getIdSpor());
				if (uiAngajat.getId()!=null) //poate veni null din click Add
					return uiAngajat.getId().toString();
			}	
		}
		if (uiComp.getId().equals("cboLuna")){
		//	logger.logINFO("<<<<<<<< getAsString uiValue Luna:"+uiValue);
			if (uiValue!=null)
				return uiValue.toString();
		}
		if (uiComp.getId().equals("cboAn")){
		//	logger.logINFO("<<<<<<<< getAsString uiValue An:"+uiValue);
			if (uiValue!=null)
				return uiValue.toString();
		}
		return null;
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
	public Integer getLuna() {
		return luna;
	}

	public void setLuna(Integer luna) {
		this.luna = luna;
	}

	public Integer getAn() {
		return an;
	}

	public void setAn(Integer an) {
		this.an = an;
	}
	
	public void adaugaStatSalarii(ActionEvent evt){
		logger.logINFO("<<<<<Sunt in adaugare:");
		StatSalarii s = new StatSalarii(null, this.pontaj, 0.0,0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0);
				
		logger.logINFO("<<<<<StatSalarii a fost initializat:");
		stateSalarii.add(s);
		
	}
 	/* void salvareLiniiStateSalarii(ActionEvent evt) throws Exception{
		logger.logINFO("<<<<<Sunt in salvare:");
		for(StatSalarii s:stateSalarii){
			logger.logINFO("<<<<<am intrat in for la salvare si am ajuns la Salarii id:" + s.getIdStatSalarii());
			salarizareSrv.i
			inregistrarePontaj(p.getIdPontaj(), p.getAngajat(), p.getAn()
					, p.getLuna(), p.getOreLucrate(), p.getOreSuplimentare(), p.getOreConcediu());
			logger.logINFO("<<<<<am salvat pontaj id:" + p.getIdPontaj());
		}
		logger.logINFO("<<<<<Pontajele au fost salvate:");
		//pontaje.add(p);
		 
	}
	*/
	public void generareStatSalarii(ActionEvent evt) throws Exception{
		logger.logINFO("<<<<<Sunt in generare:");
		FacesMessage mesaj = null;
		mesaj = new FacesMessage("Nu exista pontaje pentru anul selectat: " + this.an+
				" si luna selectate: " + this.luna + "!");
		FacesContext.getCurrentInstance().addMessage("Validare esuta",mesaj);
		
		try {
			pontaje = salarizareSrv.getPontajAnLuna(this.an, this.luna);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (pontaje == null || pontaje.isEmpty()){
			logger.logINFO("<<<<<pontajul este gol") ;
			FacesContext.getCurrentInstance().renderResponse();
			
		}
		salarizareSrv.inregistrarStatSalariiLuna(this.an, this.luna);
		stateSalarii = salarizareSrv.getStatAnLuna(this.an, this.luna);					
		logger.logINFO("<<<<<am generat salariile") ;
		
	}
	
	public void validate(FacesContext arg0, UIComponent uiComponent, Object uiValue)
			throws ValidatorException {
		logger.logINFO("Validam");
		if (uiComponent.getId().equals("cmdGenereaza")){
			try {
				pontaje = salarizareSrv.getPontajAnLuna(this.an, this.luna);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			logger.logINFO("Validam pontaje " );
			FacesMessage mesaj = null;
			if (pontaje == null || pontaje.isEmpty()){
				mesaj = new FacesMessage("Nu exista pontaje pentru anul: " + this.an+
						" si luna: " + this.luna + "!");
			}
			
			if (mesaj != null){
				throw new ValidatorException(mesaj);
			}
		}
		
	}	
}
