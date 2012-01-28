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
import org.open.erp.services.marketing.MarketingManagementSrv;
import org.open.erp.services.marketing.Promotie;
import org.open.erp.services.marketing.impl.MarketingManagementImpl;



@SessionScoped
public class ListaPromotiiImpl implements Converter{

	private Promotie promotie;
	private List<Promotie> promotii = new ArrayList<Promotie>();
	
	private Logger logger;
		
	@EJB(mappedName="MarketingManagementSrvRemote/remote", name="MarketingManagementSrvRemote/remote") 
	private MarketingManagementSrv marketingSrv;
	
	@PostConstruct
	public void initListaPromotii() throws Exception{
		logger = org.apache.log4j.Logger.getLogger(ListaPromotiiImpl.class.getName());
		
		promotii = (List<Promotie>) marketingSrv.getListaPromotii();
		if (!promotii.isEmpty())
			promotie = promotii.get(0);
		else{
			System.out.println("Nu exista nicio promotie!!!");
			this.promotie = new Promotie();
			promotie.setDenumirePromotie("Promotie noua");
		}
	}

	public Promotie getPromotie() {
		return promotie;
	}

	public void setPromotie(Promotie promotie) {
		this.promotie = promotie;
	}
	
	public List<Promotie> getListPromotii(){
		return this.promotii;
	}
	
	public Map<String, Promotie> getPromotii(){
		logger.info("getPromotii : " + this.promotii.size());
		Map<String, Promotie> mapPromotii = new HashMap<String, Promotie>();
		for (Promotie p: promotii){
			logger.info("<<<<<<Map getPromotii:" + p.getDenumirePromotie());
			mapPromotii.put(p.getDenumirePromotie() + " " + p.getMesajPromotional() + " | " + p.getIdPromotie(), p);
		}
		return mapPromotii;
	} 

	public void setPromotii(List<Promotie> _promotii) {
		this.promotii = _promotii;
	}

	/* Implementare navigare */
	public void PromotieAnterioara(ActionEvent evt){
		Integer idxCurent = this.promotii.indexOf(promotie);
		if (idxCurent > 0)
			this.promotie = this.promotii.get(idxCurent - 1);
	}

	public void PromotieUrmatoare(ActionEvent evt){
		Integer idxCurent = this.promotii.indexOf(promotie);
		if ((idxCurent+1) < this.promotii.size())
			this.promotie = this.promotii.get(idxCurent + 1);
	}	

	//operatie invocata la selectie din lista, dar inainte de setLuna, An, Angajat
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		logger.info("<<<<<<<uiValue este:"+uiValue);
		//if (uiValue!=null){
		if (uiComp.getId().equals("cboPromotie")){
			Promotie uipromotieTemplate= new Promotie();
			uipromotieTemplate.setIdPromotie(Integer.valueOf(uiValue));
			//in personal nu am metoda equals
			Integer idx = this.promotii.indexOf(uipromotieTemplate);
			logger.info("<<<<<<<getAsObject: Id-ul angajatului din array este:"+idx);
			return this.promotii.get(idx);
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
			Promotie uiPromotie = (Promotie)uiValue;
			logger.info("<<<<<<<<<< getAsString uiValue promotie:"+uiPromotie.getDenumirePromotie() + " id: " + uiPromotie.getIdPromotie());
			//logger.logINFO("getAsString uiValue 2:"+uiSpor.getIdSpor());
			if (uiPromotie.getIdPromotie()!=null)
				return uiPromotie.getIdPromotie().toString();
		}
		// }
		return null;
	}
	/* Implementare operatii CRUD */
	public void adaugarePromotie(ActionEvent evt){
		this.promotie = new Promotie();
		//angajat.setId(999);
		//angajat.setNume("");
		this.promotii.add(this.promotie);
		  
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
		
		this.promotie = marketingSrv.salveazaPromotie(this.promotie);
		this.promotii.add(this.promotie);
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
