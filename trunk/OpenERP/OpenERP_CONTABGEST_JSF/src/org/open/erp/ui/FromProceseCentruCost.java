package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;

import org.open.erp.services.contabgest.CentruCost;
import org.open.erp.services.contabgest.ContabGestSrvLocal;
import org.open.erp.services.contabgest.ProceseTehnicoEconomice;

//@ManagedBean(name="fromProceseCentruCost")


@SessionScoped
public class FromProceseCentruCost implements Converter{
	private ProceseTehnicoEconomice proceseTehnicoEconomic;
	private List<ProceseTehnicoEconomice> proceseTehnicoEconomice = new ArrayList<ProceseTehnicoEconomice>();
	private List<CentruCost> centreCost = new ArrayList<CentruCost>();
	private CentruCost centruCost;
	HtmlDataTable centreTable;	

	public HtmlDataTable getCentreTable() {
		return centreTable;
	}

	public void setCentreTable(HtmlDataTable centreTable) {
		this.centreTable = centreTable;
	}

	
	
	
	public List<CentruCost> getCentreCost() {
		return centreCost;
	}

	public void setCentreCost(List<CentruCost> centreCost) {
		this.centreCost = centreCost;
	}

	public List<ProceseTehnicoEconomice> getProceseTehnicoEconomiceList() {
		return proceseTehnicoEconomice;
	}

	public void setProceseTehnicoEconomice(
			List<ProceseTehnicoEconomice> proceseTehnicoEconomice) {
		this.proceseTehnicoEconomice = proceseTehnicoEconomice;
	}
	@EJB(mappedName="ContabGestImpl/local", name="ContabGestImpl/local") 
	private ContabGestSrvLocal contabGestSrv;
	
	@PostConstruct
	public void initFormProceseCentreCost() throws Exception{
		//logger = new PersonalLogger();
		
		proceseTehnicoEconomice = (List<ProceseTehnicoEconomice>) contabGestSrv.getListaProcese();
		//proceseTehnicoEconomice =  contabGestSrv.getProceTeh();
		if (!proceseTehnicoEconomice.isEmpty())
		{
			proceseTehnicoEconomic = proceseTehnicoEconomice.get(0);
			centreCost = (List<CentruCost>) contabGestSrv.getListaCentreCostProcesEJB(proceseTehnicoEconomic); 
		}
		else{
			System.out.println("Nu exista proces!!!");
			this.proceseTehnicoEconomic = new ProceseTehnicoEconomice();
			proceseTehnicoEconomic.setDenumireProces("Def proces ...");
		}
	}
	
	
	

	public ProceseTehnicoEconomice getProceseTehnicoEconomic() {
		return proceseTehnicoEconomic;
	}

	public void setProceseTehnicoEconomic(ProceseTehnicoEconomice proceseTehnicoEconomic) {
		this.proceseTehnicoEconomic = proceseTehnicoEconomic;
		
		try {
			//Integer idx = this.angajati.indexOf(this.angajat);
			centreCost = (List<CentruCost>) contabGestSrv.getListaCentreCostProcesEJB(this.proceseTehnicoEconomic);
		} catch (Exception e) {				
			e.printStackTrace();
		} 
	}
	
	 public Map<String, ProceseTehnicoEconomice> getProceseTehnicoEconomice(){
	       // logger.logINFO("getAngajati : " + this.produsFinite.size());
	        Map<String, ProceseTehnicoEconomice> mapProduse = new HashMap<String, ProceseTehnicoEconomice>();
	        for (ProceseTehnicoEconomice a: proceseTehnicoEconomice){
	               // logger.logINFO("<<<<<<Map getAngajati:" + a.getNume());
	        	mapProduse.put(a.getDenumireProces()+ " " + a.getDetaliiProces() + " | " + a.getIdProces(), a);
	        }
	        return mapProduse;
	} 
	
	
	
	/* Implementare navigare */
	public void previousProces(ActionEvent evt){
		Integer idxCurent = this.proceseTehnicoEconomice.indexOf(proceseTehnicoEconomic);
		if (idxCurent > 0)
		{
			this.proceseTehnicoEconomic = this.proceseTehnicoEconomice.get(idxCurent - 1);
			try {
				centreCost = (List<CentruCost>) contabGestSrv.getListaCentreCostProcesEJB(this.proceseTehnicoEconomic);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
/*
	public void nextProces(ActionEvent evt){
		Integer idxCurent = this.proceseTehnicoEconomice.indexOf(proceseTehnicoEconomic);
		if ((idxCurent+1) < this.proceseTehnicoEconomice.size())
		{
			this.proceseTehnicoEconomic = this.proceseTehnicoEconomice.get(idxCurent + 1);
			try {
				centreCost = (List<CentruCost>) contabGestSrv.getListaCentreCostProcesEJB(this.proceseTehnicoEconomic);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}	

*/
	
	public String nextProiect(){
		Integer idx = this.proceseTehnicoEconomice.indexOf(this.proceseTehnicoEconomic) + 1;

		//logger.debug("Next proiect : " + idx + " | " + this.proiecte.size());

		if (idx > 0 && idx < this.proceseTehnicoEconomice.size()){
		this.setProceseTehnicoEconomic(this.proceseTehnicoEconomice.get(idx));
		//populareModelActivitati();
		}
		return "Form3";
		}
	
	 public void nextProiect(ActionEvent evt){
		 nextProiect();
		 }
	 
		public void nextProdus1(ActionEvent evt){
			//nextProdus();
			  Integer idxCurent = this.proceseTehnicoEconomice.indexOf(proceseTehnicoEconomic);
	          if ((idxCurent+1) < this.proceseTehnicoEconomice.size())
	                  this.proceseTehnicoEconomic = this.proceseTehnicoEconomice.get(idxCurent + 1);
		}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		//logger.logINFO(" uiValue = :"+uiValue);
		if (uiComp.getId().equals("cboAngajat")){
			ProceseTehnicoEconomice uiProcesTemplate = new ProceseTehnicoEconomice();
			uiProcesTemplate.setIdProces(Integer.valueOf(uiValue));
			Integer idx = this.proceseTehnicoEconomice.indexOf(uiProcesTemplate);
		//	logger.logINFO("Id-ul angajatului curent:"+idx);
//			try {
//				contracte = (List<ContractMunca>) personalSrv.getListaContracteAngajatEJB(this.angajati.get(idx));
//			} catch (Exception e) {				
//				e.printStackTrace();
//			} 
			return this.proceseTehnicoEconomice.get(idx);
		} 
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		if (uiComp.getId().equals("cboAngajat")){
			ProceseTehnicoEconomice uiProces = (ProceseTehnicoEconomice)uiValue;
			//logger.logINFO("<<<<<<<<<< getAsString uiValue angajat:"+uiAngajat.getNume() + " id: " + uiAngajat.getId());			
			if (uiProces.getIdProces()!=null)
				return uiProces.getIdProces().toString();
		}
		return null;
	}
	
	
}
