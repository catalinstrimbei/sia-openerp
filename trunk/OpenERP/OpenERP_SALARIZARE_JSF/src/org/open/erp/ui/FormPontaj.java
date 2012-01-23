package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.PersonalSrvLocal;
import org.open.erp.services.salarizare.Pontaj;
import org.open.erp.services.salarizare.SalarizareSrvLocal;
import org.open.erp.services.salarizare.impl.SalarizareLogger;

import com.google.common.base.Functions;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;

public class FormPontaj implements Converter{

	private Integer luna;
	private Integer an;
	private Pontaj pontaj;
	private List<Pontaj> pontaje = new ArrayList<Pontaj>();
	private List<Angajat> angajati = new ArrayList<Angajat>();
	
	private List<Integer> listAni = new ArrayList<Integer>();
	
	private Map<String, Integer> mapLuni = new HashMap<String, Integer>();
	private Map<String, Integer> mapAni = new HashMap<String, Integer>();
	
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
		pontaje = salarizareSrv.getPontajAnLuna(2009, 1);
		angajati = (List<Angajat>) personalSrv.getListaAngajati();
		if (!pontaje.isEmpty())
			pontaj = pontaje.get(0);
		
		listAni.add(2009);
		listAni.add(2010);
		listAni.add(2011);
		listAni.add(2012);
		listAni.add(2013);
		//luna = mapLuni.get(0);
	}

	public Pontaj getPontaj() {
		return pontaj;
	}

	public void setPontaj(Pontaj pontaj) {
		this.pontaj = pontaj;
	}
	
	public List<Pontaj> getPontaje() {
		return pontaje;
	}

	public void setPontaje(List<Pontaj> pontaje) {
		this.pontaje = pontaje;
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
					pontaje = salarizareSrv.getPontajAnLuna(this.an, this.luna);
			//		logger.logINFO("<<<<<<< Am incarcat pontajele cu succes luna");
				//}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.logINFO("<<<<<<< FAIL incarcare pontaje luna");
				e.printStackTrace();
			}
			return luna;
		}
		if (uiComp.getId().equals("cboAn")){
			//logger.logINFO("<<<<<<< Anul din array este:"+uiValue);
			an = Integer.valueOf(uiValue);
			try {
				//if (pontaje.isEmpty()){
					pontaje = salarizareSrv.getPontajAnLuna(this.an, this.luna);
				//	logger.logINFO("<<<<<<< Am incarcat pontajele cu succes an");
				//}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.logINFO("<<<<<<< FAIL incarcare pontaje an");
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
	
	public void adaugaLiniePontaj(ActionEvent evt){
		logger.logINFO("<<<<<Sunt in adaugare:");
		Pontaj p = new Pontaj(9999, this.an, this.luna, angajati.get(0),168.0,0.0,0.0);
		logger.logINFO("<<<<<Pontajul a fost initializat:");
		pontaje.add(p);
		
	}
 	
	public void salvareLiniiPontaj(ActionEvent evt) throws Exception{
		logger.logINFO("<<<<<Sunt in salvare:");
		for(Pontaj p:pontaje){
			logger.logINFO("<<<<<am intrat in for la salvare si am ajuns la pontaj id:" + p.getIdPontaj());
			salarizareSrv.inregistrarePontaj(p.getIdPontaj(), p.getAngajat(), p.getAn()
					, p.getLuna(), p.getOreLucrate(), p.getOreSuplimentare(), p.getOreConcediu());
			logger.logINFO("<<<<<am salvat pontaj id:" + p.getIdPontaj());
		}
		logger.logINFO("<<<<<Pontajele au fost salvate:");
		//pontaje.add(p);
		 
	}
	
	public void generarePontaj(ActionEvent evt) throws Exception{
		logger.logINFO("<<<<<Sunt in generare:");
		
		salarizareSrv.inregistrarePontajLuna(this.an, this.luna);
		pontaje = salarizareSrv.getPontajAnLuna(this.an, this.luna);					
		logger.logINFO("<<<<<am generat pontajele:") ;
		
	}
}
