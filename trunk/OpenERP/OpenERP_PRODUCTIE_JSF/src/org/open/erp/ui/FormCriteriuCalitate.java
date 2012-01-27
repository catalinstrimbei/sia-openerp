package org.open.erp.ui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;

import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.productie.CriteriuCalitate;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FluxProductie;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.ProductieSrvLocal;


@ManagedBean(name="formCriteriuCalitate")
@SessionScoped
public class FormCriteriuCalitate implements Converter{
	CriteriuCalitate criteriuCalitate;
	Integer idCriteriu;
	String criteriu;
	List<CriteriuCalitate> criterii = new ArrayList<CriteriuCalitate>();
	
	
	@EJB(mappedName="ProductieSrv/local", name="ProductieSrv/local") 
	private ProductieSrvLocal productieSrv;
	
	
org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ProductieSrv.class.getName());
	
	@PostConstruct
	public void initFormSemifabricat() throws Exception{
				
		criterii = productieSrv.getCriteriiCalitate();
		if (!criterii.isEmpty())
			criteriuCalitate = criterii.get(0);	
			}

	
	public CriteriuCalitate getCriteriuCalitate() {
		return criteriuCalitate;
	}


	public void setCriteriuCalitate(CriteriuCalitate criteriuCalitate) {
		this.criteriuCalitate = criteriuCalitate;
	}


	public Integer getIdCriteriu() {
		return idCriteriu;
	}


	public void setIdCriteriu(Integer idCriteriu) {
		this.idCriteriu = idCriteriu;
	}


	public String getCriteriu() {
		return criteriu;
	}


	public void setCriteriu(String criteriu) {
		this.criteriu = criteriu;
	}


	public List<CriteriuCalitate> getCriterii() {
		return criterii;
	}


	public void setCriterii(List<CriteriuCalitate> criterii) {
		this.criterii = criterii;
	}

	/* --navigare-- */
	public void previousCriteriu(ActionEvent evt){
		Integer idxCurent = this.criterii.indexOf(criteriuCalitate);
		if (idxCurent > 0)
			this.criteriuCalitate = this.criterii.get(idxCurent - 1);
	}

	public void nextCriteriu(ActionEvent evt){
		Integer idxCurent = this.criterii.indexOf(criteriuCalitate);
		if ((idxCurent+1) < this.criterii.size())
			this.criteriuCalitate = this.criterii.get(idxCurent + 1);
	}	
	
	/* ---operatii CRUD--- */
	public void adaugareCriteriuCalitate(ActionEvent evt){
		this.criteriuCalitate = new CriteriuCalitate();
		this.criteriuCalitate.setIdCriteriu(1);
		this.criteriuCalitate.setCriteriu("criteriu 1");
		logger.info("---adaugare criteriu----" );
		
	} 
	  
	public void stergereCriteriuCalitate(ActionEvent evt) throws Exception{
		this.criterii.remove(this.criteriuCalitate);
		logger.info("---stergere criteriu----id: "+criteriuCalitate.getIdCriteriu());
		productieSrv.stergeCriteriuCalitate(this.criteriuCalitate);
		 
		if (!this.criterii.isEmpty())
			this.criteriuCalitate = this.criterii.get(0);
		else
			this.criteriuCalitate = null;
	
	} 
	 
	public void salvareCriteriuCalitate(ActionEvent evt) throws Exception{
		this.criterii.remove(this.criteriuCalitate);
		
		this.criteriuCalitate = productieSrv.salveazaCriteriuCalitate(criteriuCalitate.getIdCriteriu(), criteriuCalitate.getCriteriu());
		logger.info("--salvare criteriu---id " + criteriuCalitate.getIdCriteriu());
		this.criterii.add(this.criteriuCalitate);
	//	return "FormSpor";
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		if (uiComp.getId().equals("txtIdCriteriu")){
			CriteriuCalitate uiCriteriuTemplate = new CriteriuCalitate(Integer.valueOf(uiValue), criteriuCalitate.getCriteriu());
			int idx = this.criterii.indexOf(uiCriteriuTemplate);
			
			return this.criterii.get(idx); 
		}
		
		if (uiComp.getId().equals("txtCriteriu")){
			CriteriuCalitate uiCriteriuTemplate = new CriteriuCalitate();
			uiCriteriuTemplate.setCriteriu(uiValue);
			Integer idx = this.criterii.indexOf(uiCriteriuTemplate);
			
			return this.criterii.get(idx);
		}
		return null;
	}
	@Override
		public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
			if (uiComp.getId().equals("txtIdCriteriu")){
			
				CriteriuCalitate uiCriteriu = (CriteriuCalitate)uiValue;
				if (uiCriteriu.getIdCriteriu()!=null) //poate veni null din click Add
					return uiCriteriu.getIdCriteriu().toString();
			}
			 
			if (uiComp.getId().equals("txtCriteriu")){
				if (uiValue != null){
					CriteriuCalitate uiCriteriu = (CriteriuCalitate)uiValue;
					return uiCriteriu.getCriteriu();
				}	
			}
		return null;
		}
	
	}

