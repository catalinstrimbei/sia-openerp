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

import org.apache.log4j.Logger;
import org.open.erp.services.marketing.Campanie;
import org.open.erp.services.marketing.MarketingManagementSrvLocal;



//@ManagedBean(name="formCampanii")
@SessionScoped
public class ListaCampaniiImpl implements Converter{

	private Campanie campanie;
	private List<Campanie> campanii = new ArrayList<Campanie>();
	private Logger logger;
	
	@EJB(mappedName="MarketingManagementSrvRemote/local", name="MarketingManagementSrvRemote/local") 
	private MarketingManagementSrvLocal marketingSrv;
	
	@PostConstruct
	public void initListaCampanii() throws Exception{
		logger = org.apache.log4j.Logger.getLogger(ListaCampaniiImpl.class.getName());
		
		campanii = (List<Campanie>) marketingSrv.getListaCampanii();
		if (!campanii.isEmpty())
			campanie = campanii.get(0);
		else{
			System.out.println("Nu exista nicio campanie!!!");
			this.campanie = new Campanie();
			campanie.setDenumireCampanie("Campanie noua");
		}
	}

	public Campanie getCampanie() {
		return campanie;
	}

	public void setCampanie(Campanie campanie) {
		this.campanie = campanie;
	}
	
	public Map<String, Campanie> getCampanii(){
		logger.info("getCampanii : " + this.campanii.size());
		Map<String, Campanie> mapCampanii = new HashMap<String, Campanie>();
		for (Campanie c: campanii){
			logger.info("<<<<<<Map getCampanii:" + c.getDenumireCampanie());
			mapCampanii.put(c.getDenumireCampanie() + " " + c.getStatus() + " | " + c.getIdCampanie(), c);
		}
		return mapCampanii;
	}
	
	
	public void setCampanii(List<Campanie> _campanii) {
		this.campanii = _campanii;
	}

	/* Implementare navigare */
	public void CampanieAnterioara (ActionEvent evt){
		logger.info("am intrat in anterioara");
		Integer idxCurent = this.campanii.indexOf(campanii);
		if (idxCurent > 0)
			this.campanie = this.campanii.get(idxCurent - 1);
	}

	public void PromotieUrmatoare(ActionEvent evt){
		logger.info("am intrat in urmatoare");
		Integer idxCurent = this.campanii.indexOf(campanie);
		if ((idxCurent+1) < this.campanii.size())
			this.campanie = this.campanii.get(idxCurent + 1);
	}	

	//operatie invocata la selectie din lista, dar inainte de setLuna
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		logger.info("<<<<<<<uiValue este:"+uiValue);
		//if (uiValue!=null){
		if (uiComp.getId().equals("cboCampanie")){
			logger.info("Am itrat in index");
			Integer idx = 0;
			Campanie uicampanieTemplate= new Campanie();
			uicampanieTemplate.setIdCampanie(Integer.valueOf(uiValue));

			if (campanii.contains(uicampanieTemplate))
			{
				idx = this.campanii.indexOf(uicampanieTemplate);	
			}
			else
			{
				logger.info("Nu s-a gasit campania");
				idx = this.campanii.indexOf(campanie);
			}
			logger.info("Id campanie noua este : " + idx);
			return this.campanii.get(idx);
		} 
		//}
		return null;
	}

	// operatie invocata la generare elemente pentru lista, 
	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		//if (uiValue!=null){
			
		
		if (uiComp.getId().equals("cboCampanie")){
			//logger.logINFO("<<<<<<<<<< getAsString uiValue angajat:"+uiValue);
			Campanie uiCampanie = (Campanie)uiValue;
			logger.info("<<<<<<<<<< getAsString uiValue campanie:"+uiCampanie.getDenumireCampanie() + " id: " + uiCampanie.getIdCampanie());
			//logger.logINFO("getAsString uiValue 2:"+uiSpor.getIdSpor());
			if (uiCampanie.getIdCampanie()!=null)
				return uiCampanie.getIdCampanie().toString();
		}
		// }
		return null;
	}
	/* Implementare operatii CRUD */
	public void adaugareCampanie(ActionEvent evt){
		this.campanie = new Campanie();
		this.campanii.add(this.campanie);
		  
	}  
	  /*

	 */
	public void salvareCampanie(ActionEvent evt) throws Exception{
		
		this.campanie = marketingSrv.salveazaCampanie(this.campanie);
		this.campanii.add(this.campanie);
	}

	public ListaCampaniiImpl() {
		super();
	}
	
}
