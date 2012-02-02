package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;

import org.open.erp.services.contabgest.CentruCost;
import org.open.erp.services.contabgest.ContabGestSrvLocal;
import org.open.erp.services.contabgest.ProdusFinit;

@SessionScoped
public class FormProduseCentruCost implements Converter{
	private ProdusFinit produsFinit;
	private List<ProdusFinit> produsFinite = new ArrayList<ProdusFinit>(); 	
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

	
	
	
	public List<ProdusFinit> getProdusFiniteList() {
		return produsFinite;
	}

	public void setProdusFinite(List<ProdusFinit> produsFinite) {
		this.produsFinite = produsFinite;
	}

	
	
	@EJB(mappedName="ContabGestImpl/local", name="ContabGestImpl/local") 
	private ContabGestSrvLocal contabGestSrv;
	
	
	@PostConstruct
	public void initFormProduseCentreCost() throws Exception{
		//logger = new PersonalLogger();
		
		produsFinite = (List<ProdusFinit>) contabGestSrv.getProduseFinite();
		//proceseTehnicoEconomice =  contabGestSrv.getProceTeh();
		if (!produsFinite.isEmpty())
		{
			produsFinit = produsFinite.get(0);
			centreCost = (List<CentruCost>) contabGestSrv.getListaCentreCostProduseEJB(produsFinit); 
		}
		else{
			System.out.println("Nu exista proces!!!");
			this.produsFinit = new ProdusFinit();
			produsFinit.setDenProdusFinit("Def produs ...");
		}
	}
	public ProdusFinit getProdusFinit() {
		return produsFinit;
	}

	public void setProdusFinit(ProdusFinit produsFinit) {
		this.produsFinit = produsFinit;
		
		try {
			//Integer idx = this.angajati.indexOf(this.angajat);
			centreCost = (List<CentruCost>) contabGestSrv.getListaCentreCostProduseEJB(this.produsFinit);
		} catch (Exception e) {				
			e.printStackTrace();
		} 
	}

	 public Map<String, ProdusFinit> getProdusFinite(){
	       // logger.logINFO("getAngajati : " + this.produsFinite.size());
	        Map<String, ProdusFinit> mapProduse = new HashMap<String, ProdusFinit>();
	        for (ProdusFinit a: produsFinite){
	               // logger.logINFO("<<<<<<Map getAngajati:" + a.getNume());
	        	mapProduse.put(a.getDenProdusFinit() + " | " + a.getIdProdusFinit(), a);
	        }
	        return mapProduse;
	} 
	 
	 /* Implementare navigare */
		public void previousProces(ActionEvent evt){
			Integer idxCurent = this.produsFinite.indexOf(produsFinit);
			if (idxCurent > 0)
			{
				this.produsFinit = this.produsFinite.get(idxCurent - 1);
				try {
					centreCost = (List<CentruCost>) contabGestSrv.getListaCentreCostProduseEJB(this.produsFinit);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		
		public void nextProdus1(ActionEvent evt){
			//nextProdus();
			  Integer idxCurent = this.produsFinite.indexOf(produsFinit);
	          if ((idxCurent+1) < this.produsFinite.size())
	                  this.produsFinit = this.produsFinite.get(idxCurent + 1);
		}

	
	
	
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		if (uiComp.getId().equals("cboProdus")){
			ProdusFinit uiProcesTemplate = new ProdusFinit();
			uiProcesTemplate.setIdProdusFinit(Integer.valueOf(uiValue));
			Integer idx = this.produsFinite.indexOf(uiProcesTemplate);
			return this.produsFinite.get(idx);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		if (uiComp.getId().equals("cboProdus")){
			ProdusFinit uiProces = (ProdusFinit)uiValue;
			if (uiProces.getIdProdusFinit()!=null)
				return uiProces.getIdProdusFinit().toString();
		}
		return null;
	}

}
