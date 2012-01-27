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
import org.open.erp.services.salarizare.StatSalarii;
import org.open.erp.services.salarizare.impl.SalarizareLogger;

import com.google.common.base.Functions;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;

public class FormPontaj implements Converter{

	private Integer luna;
	private Integer an;
	private Pontaj pontaj;
	private Integer idPontaj;
	private List<Pontaj> pontaje = new ArrayList<Pontaj>();
	private List<Angajat> angajati = new ArrayList<Angajat>();
	
	private List<Integer> listAni = new ArrayList<Integer>();
	
	private Map<String, Integer> mapLuni = new HashMap<String, Integer>();
	private Map<String, Integer> mapAni = new HashMap<String, Integer>();
	
	public List<Pontaj> oreLucrate = new ArrayList<Pontaj>();
	
	private Integer isAddMode = 0;
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

	Integer i=0;
	Integer j=0;
	Integer k=0;
	Integer l=0;
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
			//logger.logINFO("<<<<<<Map getAngajati:" + a.getNume());
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
					logger.logINFO("<<<<<<< Am incarcat pontajele cu succes luna");
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
			
			if (this.isAddMode==1){
				Pontaj p1 = new Pontaj(null, this.an, this.luna, angajati.get(0),168.0,0.0,0.0);
				logger.logINFO("<<<<<Pontajul a fost initializat in get AsObject :");
				pontaje.add(p1);
				this.isAddMode = 0;
			}
			
			pontaje.get(l).setAngajat(this.angajati.get(idx));
			l +=1;
			if (l==pontaje.size())
					l=0;
			logger.logINFO("<<<<< faces context l:" + l);
			
			if (idx>=0)
				return this.angajati.get(idx);
		}
		
		if (uiComp.getId().equals("txtOreLucrate")){
				logger.logINFO("<<<<< Get AsObject txtOrelucrate uiValue " + Double.valueOf(uiValue));
				if (uiValue!=null){
					//cautam pontajul si modificam orele lucrate
					Pontaj p = new Pontaj();
					p.setIdPontaj(this.idPontaj);
					Integer idx = pontaje.indexOf(p);
					logger.logINFO("<<<<< Get AsObject txtOrelucrate uiValue " + Double.valueOf(uiValue) );
					
					if (this.isAddMode==1){
						Pontaj p1 = new Pontaj(null, this.an, this.luna, angajati.get(0),168.0,0.0,0.0);
						logger.logINFO("<<<<<Pontajul a fost initializat in get AsObject :");
						pontaje.add(p1);
						this.isAddMode = 0;
					}
					//iteram prin map si actualizam in array pontaje modificarile facute de user
					//for(Pontaj p1:pontaje){
						//p1.setOreLucrate(Double.valueOf(uiValue));
					//} 
					
					pontaje.get(i).setOreLucrate(Double.valueOf(uiValue));
					i +=1;
					if (i==pontaje.size())
							i=0;
					logger.logINFO("<<<<< faces context i:" + i);
					//this.pontaje.get(idx).setOreLucrate(Double.valueOf(uiValue));				
					//pontaje.get(idx).setOreLucrate(oreLucrate)
					//return pontaje.get(idx).getOreLucrate().toString();
					return null;
				}
			}
		 
		if (uiComp.getId().equals("txtOreConcediu")){
			logger.logINFO("<<<<< Get AsObject txtOreConcediu uiValue " + Double.valueOf(uiValue));
			if (uiValue!=null){
				//cautam pontajul si modificam orele lucrate
				Pontaj p = new Pontaj();
				p.setIdPontaj(this.idPontaj);
				Integer idx = pontaje.indexOf(p);
				logger.logINFO("<<<<< Get AsObject txtOreConcediu uiValue " + Double.valueOf(uiValue) );
				
				if (this.isAddMode==1){
					Pontaj p1 = new Pontaj(null, this.an, this.luna, angajati.get(0),168.0,0.0,0.0);
					logger.logINFO("<<<<<Pontajul a fost initializat in get AsObject oreconcediu:");
					pontaje.add(p1);
					this.isAddMode = 0;
				}
				//iteram prin map si actualizam in array pontaje modificarile facute de user
				//for(Pontaj p1:pontaje){
					//p1.setOreLucrate(Double.valueOf(uiValue));
				//} 
				
				pontaje.get(j).setOreConcediu(Double.valueOf(uiValue));
				j +=1;
				if (j==pontaje.size())
						j=0;
				logger.logINFO("<<<<< faces context j:" + j);
				//this.pontaje.get(idx).setOreLucrate(Double.valueOf(uiValue));				
				//pontaje.get(idx).setOreLucrate(oreLucrate)
				//return pontaje.get(idx).getOreLucrate().toString();
				return null;
			}
		}
		
		if (uiComp.getId().equals("txtOreSuplimentare")){
			logger.logINFO("<<<<< Get AsObject txtOreSuplimentare uiValue " + Double.valueOf(uiValue));
			if (uiValue!=null){
				//cautam pontajul si modificam orele lucrate
				Pontaj p = new Pontaj();
				p.setIdPontaj(this.idPontaj);
				Integer idx = pontaje.indexOf(p);
				logger.logINFO("<<<<< Get AsObject txtOreSuplimentare uiValue " + Double.valueOf(uiValue) );
				
				if (this.isAddMode==1){
					Pontaj p1 = new Pontaj(null, this.an, this.luna, angajati.get(0),168.0,0.0,0.0);
					logger.logINFO("<<<<<Pontajul a fost initializat in get AsObject txtOreSuplimentare:");
					pontaje.add(p1);
					this.isAddMode = 0;
				}
				//iteram prin map si actualizam in array pontaje modificarile facute de user
				//for(Pontaj p1:pontaje){
					//p1.setOreLucrate(Double.valueOf(uiValue));
				//} 
				
				pontaje.get(k).setOreSuplimentare(Double.valueOf(uiValue));
				k +=1;
				if (k==pontaje.size())
						k=0;
				logger.logINFO("<<<<< faces context k:" + k);
				//this.pontaje.get(idx).setOreLucrate(Double.valueOf(uiValue));				
				//pontaje.get(idx).setOreLucrate(oreLucrate)
				//return pontaje.get(idx).getOreLucrate().toString();
				return null;
			}
		}

		return null;
	}

	// operatie invocata la generare elemente pentru lista, 
	// dupa getAngajati, dar inainte de popularea listei
	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		if (uiComp.getId().equals("cboAngajat")){
			//logger.logINFO("<<<<<<<<<< getAsString uiValue angajat:"+uiValue);
			if (uiValue != null){
				Angajat uiAngajat = (Angajat)uiValue;
				//logger.logINFO("<<<<<<<<<< getAsString uiValue angajat:"+uiAngajat.getNume());
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
		
		if (uiComp.getId().equals("txtOreLucrate")){
			//	logger.logINFO("<<<<<<<< getAsString uiValue An:"+uiValue);
				if (uiValue!=null){
					//cautam pontajul si facem display la orele lucrate
					Pontaj p = new Pontaj();
					p.setIdPontaj((Integer)uiValue);
					
					logger.logINFO("<<<<< txtOrelucrate uiValue " + (Integer)uiValue);
					Integer idx = this.pontaje.indexOf(p);
					p.setOreLucrate(pontaje.get(idx).getOreLucrate());
					//de asemene ne punem intr-un map toate valorile (folosite in getAsObject pt a modifica 
					//array-ul de pontaje
					//oreLucrate.add(p);
					this.idPontaj = (Integer)uiValue;
					return pontaje.get(idx).getOreLucrate().toString();
				}
			}
		if (uiComp.getId().equals("txtOreConcediu")){
			//	logger.logINFO("<<<<<<<< getAsString uiValue An:"+uiValue);
				if (uiValue!=null){
					//cautam pontajul si facem display la orele lucrate
					Pontaj p = new Pontaj();
					p.setIdPontaj((Integer)uiValue);
					
					logger.logINFO("<<<<< txtOreConcediu uiValue " + (Integer)uiValue);
					Integer idx = this.pontaje.indexOf(p);
					p.setOreConcediu(pontaje.get(idx).getOreConcediu());
					//de asemene ne punem intr-un map toate valorile (folosite in getAsObject pt a modifica 
					//array-ul de pontaje
					//oreLucrate.add(p);
					this.idPontaj = (Integer)uiValue;
					return pontaje.get(idx).getOreConcediu().toString();
				}
			}
		
		if (uiComp.getId().equals("txtOreSuplimentare")){
			//	logger.logINFO("<<<<<<<< getAsString uiValue An:"+uiValue);
				if (uiValue!=null){
					//cautam pontajul si facem display la orele lucrate
					Pontaj p = new Pontaj();
					p.setIdPontaj((Integer)uiValue);
					
					logger.logINFO("<<<<< txtOreSuplimentare uiValue " + (Integer)uiValue);
					Integer idx = this.pontaje.indexOf(p);
					p.setOreSuplimentare(pontaje.get(idx).getOreSuplimentare());
					//de asemene ne punem intr-un map toate valorile (folosite in getAsObject pt a modifica 
					//array-ul de pontaje
					//oreLucrate.add(p);
					this.idPontaj = (Integer)uiValue;
					return pontaje.get(idx).getOreSuplimentare().toString();
				}
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
		Pontaj p = new Pontaj(null, this.an, this.luna, angajati.get(0),168.0,0.0,0.0);
		logger.logINFO("<<<<<Pontajul a fost initializat:");
		pontaje.add(p);
		//i +=1;
		this.isAddMode = 1;
		
	}
 	
	public void salvareLiniiPontaj(ActionEvent evt) throws Exception{
		logger.logINFO("<<<<<Sunt in salvare:");
		
		for(Pontaj p:pontaje){
			logger.logINFO("<<<<<am intrat in for la salvare si am ajuns la pontaj id:" + p.getIdPontaj() + "ore lucrate:"+p.getOreLucrate());
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

	public void regenerarePontaj(ActionEvent evt) throws Exception{
		logger.logINFO("<<<<<Sunt in regenerare:");
		
		for(Pontaj p: pontaje){
			salarizareSrv.stergePontaj(p);
		}
		
		salarizareSrv.inregistrarePontajLuna(this.an, this.luna);
		pontaje = salarizareSrv.getPontajAnLuna(this.an, this.luna);					
		logger.logINFO("<<<<<am generat pontajele:") ;
		
	}
	public Integer getIdPontaj() {
		return idPontaj;
	}

	public void setIdPontaj(Integer idPontaj) {
		this.idPontaj = idPontaj;
	}
 
	public void stergeLiniePontaj(ActionEvent evt){
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestMap = context.getExternalContext().getRequestParameterMap();
		String value = (String)requestMap.get("id1");


		Integer selectedId = Integer.valueOf(evt.getComponent().getAttributes().get("selectedId").toString());
		logger.logINFO("<<<<<selectedId:" + selectedId + "    " + evt.getComponent().getAttributes().get("ccc")) ;
		Pontaj p = new Pontaj();
		p.setIdPontaj(selectedId);
		pontaje.remove(p);
		try {
			salarizareSrv.stergePontaj(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
