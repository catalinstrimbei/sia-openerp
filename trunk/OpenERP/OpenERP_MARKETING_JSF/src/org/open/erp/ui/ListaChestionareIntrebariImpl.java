package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;

import org.open.erp.services.marketing.Chestionar;
import org.open.erp.services.marketing.Intrebare;
import org.open.erp.services.marketing.MarketingManagementSrv;
import org.open.erp.services.marketing.MarketingManagementSrvLocal;
import org.open.erp.services.personal.logger.PersonalLogger;

@SessionScoped

public class ListaChestionareIntrebariImpl implements Converter{

	private Chestionar chestionar;
	private List<Chestionar> chestionare = new ArrayList<Chestionar>();
	private List<Intrebare> intrebari = new ArrayList<Intrebare>();
	private Intrebare intrebare;
	private Logger logger;
	HtmlDataTable intrebariTable;
	public HtmlDataTable getIntrebariTable() {
		return intrebariTable;
	}

	public void setIntrebariTable(HtmlDataTable intrebariTable) {
		this.intrebariTable = intrebariTable;
	}

	public List<Intrebare> getIntrebari() {
		return intrebari;
	}

	public void setIntrebari(List<Intrebare> intrebari) {
		this.intrebari = intrebari;
	}

		
	@EJB(mappedName="MarketingManagementSrvRemote/local", name="MarketingManagementSrvRemote/local") 
	private MarketingManagementSrvLocal marketingSrv;
	
	@PostConstruct
	public void initListaChestionareIntrebari() throws Exception{
		logger = org.apache.log4j.Logger.getLogger(ListaChestionareIntrebariImpl.class.getName());

		
		chestionare = (List<Chestionar>) marketingSrv.getListaChestionare();
		if (!chestionare.isEmpty())
		{
			chestionar = chestionare.get(0);
			intrebari = (List<Intrebare>) marketingSrv.getListaIntrebariChestionar(chestionar); 
		}
		else{
			System.out.println("Nu exista chestionare!!!");
			this.chestionar = new Chestionar();
			chestionar.setDenumireChestionar("Chestionar nou");
		}
	}

	public Chestionar getChestionar() {
		return chestionar;
	}

	public void setChestionar(Chestionar chestionar) {
		this.chestionar = chestionar;
	}
	
	public List<Chestionar> getListaChestionare(){
		return this.chestionare;
	}
	
	public Map<String, Chestionar> getChestionare(){
		logger.info("getChestionare : " + this.chestionare.size());
		Map<String, Chestionar> mapChestionare = new HashMap<String, Chestionar>();
		for (Chestionar ch: chestionare){
			logger.info("<<<<<<Map getChestionare:" + ch.getDenumireChestionar());
			mapChestionare.put(ch.getDenumireChestionar() + " " + ch.getScopChestionar() + " | " + ch.getIdChestionar(), ch);
		}
		return mapChestionare;
	} 

	public void setChestionare(List<Chestionar> chestionare) {
		this.chestionare = chestionare;
	}

	/* Implementare navigare */
	public void previousChestionar(ActionEvent evt){
		Integer idxCurent = this.chestionare.indexOf(chestionar);
		if (idxCurent > 0)
		{
			this.chestionar = this.chestionare.get(idxCurent - 1);
			try {
				intrebari = (List<Intrebare>) marketingSrv.getListaIntrebariChestionar(this.chestionar);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

	public void nextChestionar(ActionEvent evt){
		Integer idxCurent = this.chestionare.indexOf(chestionar);
		if ((idxCurent+1) < this.chestionare.size())
		{
			this.chestionar = this.chestionare.get(idxCurent + 1);
			try {
				intrebari = (List<Intrebare>) marketingSrv.getListaIntrebariChestionar(this.chestionar);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}	

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		logger.info("<<<<<<<uiValue este:"+uiValue);
		if (uiComp.getId().equals("cboChestionar")){
			Chestionar uiChestionarTemplate = new Chestionar();
			uiChestionarTemplate.setIdChestionar(Integer.valueOf(uiValue));
			Integer idx = this.chestionare.indexOf(uiChestionarTemplate);
			logger.info("Id-ul chestionarului curent:"+idx);
			try {
				intrebari = (List<Intrebare>) marketingSrv.getListaIntrebariChestionar(this.chestionare.get(idx));
			} catch (Exception e) {				
				e.printStackTrace();
			} 
			return this.chestionare.get(idx);
		} 
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {		
		if (uiComp.getId().equals("cboChestionar")){
			Chestionar uiChestionar = (Chestionar)uiValue;
			logger.info("<<<<<<<<<< getAsString uiValue chestionar:"+uiChestionar.getDenumireChestionar() + " id: " + uiChestionar.getIdChestionar());			
			if (uiChestionar.getIdChestionar()!=null)
				return uiChestionar.getIdChestionar().toString();
		}
		return null;
	}
	
	public void adaugareIntrebari(ActionEvent evt){
		this.intrebare = new Intrebare();
		this.intrebare.setEditable(true);
		this.intrebari.add(this.intrebare);	  
	} 
	
	public String editAction(){
		logger.info("Am intrat pe editAction ");
		Intrebare intrebare_ = null;
		intrebare_ = intrebari.get(intrebariTable.getRowIndex());
		logger.info("Suntem pe editAction la intrebarea: " + intrebare_.getIdIntrebare());
		intrebare_.setEditable(true);
		return null;
	}
	
	public String deleteAction(){
		logger.info("Suntem pe deleteAction");
		Intrebare intrebare_ = null;
		intrebare_ = intrebari.get(intrebariTable.getRowIndex());
		try {
			intrebare_ = marketingSrv.getIntrebareById(intrebare_.getIdIntrebare());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		logger.info("Suntem pe deleteAction la intrebarea: " + intrebare_.getIdIntrebare());
		try {
			if (intrebare_ != null)
			{
				logger.info("Suntem pe deleteAction si vom sterge intrebarea: " + intrebare_.getIdIntrebare());
				marketingSrv.stergeIntrebare(intrebare_);
			}
			else
				logger.info("Suntem pe deleteAction si  intrebarea de sters este NULL");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String saveAction(){
		logger.info("Suntem pe saveAction ");
		Intrebare intrebare_ = null;
		intrebare_ = intrebari.get(intrebariTable.getRowIndex());
		logger.info("Suntem pe saveAction la intrebarea: " + intrebare_.getIdIntrebare());
		try {
			intrebare_.setEditable(false);
			marketingSrv.salveazaIntrebare(intrebare_);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}
	
	public String modificaIntrebare(Intrebare intrebare_){
		logger.info("Modificam intrebarea:  ");
		intrebare_.setEditable(true);
		return null;
	}

	public void modificaIntrebare(ActionEvent evt) throws Exception{		
		for(Intrebare ctrCurent : intrebari)
		{
			ctrCurent.setEditable(true);
		}		
	}
	public void salvareIntrebare(ActionEvent evt) throws Exception{	
		for(Intrebare ctrCurent : intrebari)
		{
			logger.info("Salvam intrebarea:  " + ctrCurent.getIdIntrebare());
			ctrCurent.setEditable(false);
			this.intrebare = marketingSrv.salveazaIntrebare(ctrCurent);
		}
		return;
		
	}
			
	
}
