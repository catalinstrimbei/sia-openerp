package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.open.erp.services.contabgest.ContabGestSrvLocal;
import org.open.erp.services.contabgest.ProceseTehnicoEconomice;
import org.open.erp.services.contabgest.ProdusFinit;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.ejb.EJB;

@ManagedBean(name="procesTeh")
public class ProcesTeh implements Converter{
	
	
	@EJB(mappedName="ContabGestImpl/local", name="ContabGestImpl/local") 
	private ContabGestSrvLocal contabGestSrv;
	
	private List<ProceseTehnicoEconomice> produsFinite = new ArrayList<ProceseTehnicoEconomice>();
	private ProceseTehnicoEconomice produsFinit;
	
	private String mesaj;
	private String denProd;
	private Double proc;
	
	private static Logger logger = Logger.getLogger(FormProdus.class.getPackage().getName());
	
	
	@PostConstruct
	public void initFormAfisareIncasari() throws Exception{
	
		produsFinite =  contabGestSrv.getProcese();
		if (!produsFinite.isEmpty())
		{
			//mesaj = produsFinite.get(0).getIdProdusFinit().toString();
			produsFinit = produsFinite.get(0);
		}
    else{
            System.out.println("Nu exista angajati!!!");
            this.produsFinit = new ProceseTehnicoEconomice();
            produsFinit.setDenumireProces("Def produs ...");
    }
		//mesaj = produsFinite.get(0).getIdProdusFinit().toString();

	}
	

	
	/* Actiuni UI Controller */
	public void nextProdus1(ActionEvent evt){
		//nextProdus();
		  Integer idxCurent = this.produsFinite.indexOf(produsFinit);
          if ((idxCurent+1) < this.produsFinite.size())
                  this.produsFinit = this.produsFinite.get(idxCurent + 1);
	}
	
	public String nextProdus(){
		Integer idx = this.produsFinite.indexOf(this.produsFinit) + 1;
		
		//logger.debug("Next proiect : " + idx + " | " + this.proiecte.size());
		
		if (idx > 0 && idx < this.produsFinite.size()){
			this.setProdusFinit(this.produsFinite.get(idx));
			//populareModelActivitati();
		}
		return "Form2";
	}
	

	
	public void previousProdus1(ActionEvent evt){
		//previousProdus();
		
		  Integer idxCurent = this.produsFinite.indexOf(produsFinit);
          if (idxCurent > 0)
                  this.produsFinit = this.produsFinite.get(idxCurent - 1);
	}
	
	public String previousProdus(){
		Integer idx = this.produsFinite.indexOf(this.produsFinit) - 1;
		
		//logger.debug("Previous proiect : " + idx + " | " + this.proiecte.size());
		
		if (idx >= 0 && idx < this.produsFinite.size()){
			this.setProdusFinit(this.produsFinite.get(idx));
			//populareModelActivitati();
		}
		
		return "Form2";
		
	}	
	/*
	public String salvareProdus() throws Exception{
		//logger.debug("LOGGER Salvare proiect: " + this.produsFinit.getDenProdusFinit() + "::" + this.produsFinit.getProcentProfit());
		//this.produsFinite.remove(this.produsFinit);
		this.produsFinit = contabGestSrv.salvareProdus(produsFinit);
		this.produsFinite.add(this.produsFinit);
		
		return "Form1";
	}*/
	public String adaugareProdus(){
		
		this.produsFinit = new ProceseTehnicoEconomice();
		//this.produsFinite.add(this.produsFinit);
		
		return "Form2";
	}
	/*
	
	   public void salvareProdus(ActionEvent evt) throws Exception{
           //this.angajati.remove(this.angajat);
           
           this.produsFinit = contabGestSrv.salvareProdus(this.produsFinit);
           logger.debug("Dupa salvare am angajatID: " + produsFinit.getIdProdusFinit());
           this.produsFinite.add(this.produsFinit);
   }
	*/
	public List<ProceseTehnicoEconomice> getProdusFiniteList() {
		return produsFinite;
	}
	
    public Map<String, ProceseTehnicoEconomice> getProdusFinite(){
       // logger.logINFO("getAngajati : " + this.produsFinite.size());
        Map<String, ProceseTehnicoEconomice> mapProduse = new HashMap<String, ProceseTehnicoEconomice>();
        for (ProceseTehnicoEconomice a: produsFinite){
               // logger.logINFO("<<<<<<Map getAngajati:" + a.getNume());
        	mapProduse.put(a.getDenumireProces()+ " " + a.getDetaliiProces() + " | " + a.getIdProces(), a);
        }
        return mapProduse;
} 

	public void setProdusFinite(List<ProceseTehnicoEconomice> produsFinite) {
		this.produsFinite = produsFinite;
	}

	public String getMesaj() {
		return mesaj;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}

	public String getDenProd() {
		return denProd;
	}

	public void setDenProd(String denProd) {
		this.denProd = denProd;
	}

	public Double getProc() {
		return proc;
	}

	public void setProc(Double proc) {
		this.proc = proc;
	}

	public ProceseTehnicoEconomice getProdusFinit() {
		return produsFinit;
	}

	public void setProdusFinit(ProceseTehnicoEconomice produsFinit) {
		this.produsFinit = produsFinit;
	}



	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		 if (uiComp.getId().equals("idSelect")){
			 ProdusFinit uiProdusTemplate = new ProdusFinit();
			 uiProdusTemplate.setIdProdusFinit(Integer.valueOf(uiValue));
             //in personal nu am metoda equals
             Integer idx = this.produsFinite.indexOf(uiProdusTemplate);
             //logger.logINFO("<<<<<<<getAsObject: Id-ul produsului din array este:"+idx);
             return this.produsFinite.get(idx);
     } 
   
     return null;
	}



	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		 if (uiComp.getId().equals("idSelect")){
			 ProdusFinit uiProdus = (ProdusFinit)uiValue;
             if (uiProdus.getIdProdusFinit()!=null)
                     return uiProdus.getIdProdusFinit().toString();
     }
     // }
     return null;
	}
	
	


}
