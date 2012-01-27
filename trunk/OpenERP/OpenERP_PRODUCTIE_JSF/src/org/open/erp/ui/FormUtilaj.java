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
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.open.erp.services.nomgen.MijlocFix;
import org.open.erp.services.nomgen.NomenclatoareSrvLocal;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.ProductieSrvLocal;
import org.open.erp.services.productie.Utilaj;



@ManagedBean(name="formUtilaj")
@SessionScoped
public class FormUtilaj implements Converter{

	
	Integer idUtilaj;
	
	MijlocFix utilaj;
	
	Utilaj utilajC;
	List<Utilaj> utilaje = new ArrayList<Utilaj>();
	
	String status;
	
	Logger logger;
	
	@EJB(mappedName="ProductieSrv/local", name="ProductieSrv/local") 
	private ProductieSrvLocal productieSrv;
	
	@EJB(mappedName="NomenclatoareImpl/local", name="NomenclatoareImpl/local") 
	private NomenclatoareSrvLocal nomenclatoareSrv;
	
	@PostConstruct
	public void initFormUtilaj() throws Exception{
		org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ProductieSrv.class.getName());
		
		utilaje = productieSrv.getUtilaje();
		if (!utilaje.isEmpty())
			utilajC = utilaje.get(0);
			}

	
	public Integer getIdUtilaj() {
		return idUtilaj;
	}
	public void setIdUtilaj(Integer idUtilaj) {
		this.idUtilaj = idUtilaj;
	}
	
	public MijlocFix getUtilaj() {
		return utilaj;
	}
	public void setUtilaj(MijlocFix utilaj) {
		this.utilaj = utilaj;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}



	
	public void previousUtilaj(ActionEvent evt){
		Integer idxCurent = this.utilaje.indexOf(utilajC);
		if (idxCurent > 0)
			this.utilajC = this.utilaje.get(idxCurent - 1);
	}

	public void nextUtilaj(ActionEvent evt){
		Integer idxCurent = this.utilaje.indexOf(utilajC);
		if ((idxCurent+1) < this.utilaje.size())
			this.utilajC = this.utilaje.get(idxCurent + 1);
	}	

	
	
	public void adaugareUtilaj(ActionEvent evt){
		this.utilajC = new Utilaj();
		this.utilajC.setIdUtilaj(1);
		this.utilajC.setStatus("ocupat");
		this.utilajC.setUtilaj(utilaj);
		
		
		
		this.utilaje.add(this.utilajC);
		logger.info("Sunt in bean, incercam sa adaugam o faza" );
	
		
	} 
	
	public void stergereUtilaj(ActionEvent evt) throws Exception{
		this.utilaje.remove(this.utilajC);
		logger.info("Sunt in bean, incercam sa stergem faza cu id: "+utilajC.getIdUtilaj());
		productieSrv.stergeUtilaj(this.utilajC);
		 
		if (!this.utilaje.isEmpty())
			this.utilajC = this.utilaje.get(0);
		else
			this.utilajC = null;
		
		//return "FormDefinireFaza";
	}

	
	public void salvareUtilaj(ActionEvent evt) throws Exception{
		this.utilaje.remove(this.utilajC);
		
		this.utilajC = new Utilaj(utilajC.getIdUtilaj(), utilajC.getUtilaj(), utilajC.getStatus());
				
		logger.info("Dupa salvare am id-ul Fazei: " + utilajC.getIdUtilaj());
		this.utilaje.add(this.utilajC);
	//	return "FormDefinireFaza";
	}
	
	
	public Map<String, Utilaj> getUtilajC(){
		Map<String, Utilaj> mapUtilaje = new HashMap<String, Utilaj>();
		for (Utilaj ut: utilaje){
			mapUtilaje.put(ut.getIdUtilaj().toString(), ut);
		}
		return mapUtilaje;
	}
	
	public List<Utilaj> getUtilajeList(){
		return this.utilaje;
	}
	


	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		
		
		if (uiComp.getId().equals("cboUtilaj")){
			Utilaj uiUtilajTemplate = new Utilaj();
			uiUtilajTemplate.setIdUtilaj(Integer.valueOf(uiValue));
			Integer idx = this.utilaje.indexOf(uiUtilajTemplate);
			logger.info("Id-ul utilajului din este:"+utilaje.get(idx).getIdUtilaj());
			return this.utilaje.get(idx);
		}

	return null;
}

	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		
		
		if (uiComp.getId().equals("cboUtilaj")){
			if (uiValue != null){
				Utilaj uiUtilaj = (Utilaj)uiValue;
				logger.info("<<<<<<<<<< getAsString uiValue utilaj:"+uiUtilaj.getStatus());
				return uiUtilaj.getIdUtilaj().toString();
			}	

		}
		return null;
	}

}
