package org.open.erp.ui.productie;

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

import org.apache.log4j.Logger;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.NomenclatoareSrvLocal;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.PersonalSrvLocal;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.ProductieSrvLocal;
import org.open.erp.services.productie.Semifabricat;


@ManagedBean(name="formSemifabricat")
@SessionScoped
public class FormSemifabricat implements Converter{
	Semifabricat semifabricat;
	List<Semifabricat> semifabricate= new ArrayList<Semifabricat>();
	Integer idSemifabricat;
	String den_semifabricat;
	ArrayList <Material> listaMateriale;
	Semifabricat semifabricatContinut;
	

	@EJB(lookup = "java:global/OpenERP_PRODUCTIE/ProductieImpl!org.open.erp.services.productie.ProductieSrv")
	private ProductieSrv productieSrv;
	
	@EJB(lookup = "java:global/OpenERP_NOMGEN/NomenclatoareImpl!org.open.erp.services.nomgen.NomenclatoareSrv")
	private NomenclatoareSrv nomenclatoareSrv;
	
	@EJB(lookup="java:global/OpenERP_NOMMAT/NomenclatorMaterialeImpl!org.open.erp.services.nommat.NomenclatorMaterialeSrv")
	private NomenclatorMaterialeSrv nommatSrv;
	
	@EJB(lookup="java:global/OpenERP_PERSONAL/PersonalImpl!org.open.erp.services.personal.PersonalSrv")
	private PersonalSrv personalSrv;
	
	private static Logger logger = Logger.getLogger(FormSemifabricat.class.getPackage().getName());
	
	@PostConstruct
	public void initFormSemifabricat() throws Exception{
				
		semifabricate = productieSrv.getListaSemifabricate();
		if (!semifabricate.isEmpty())
			semifabricat = semifabricate.get(0);
		
		listaMateriale=(ArrayList<Material>) this.getListaMateriale();
			
			}

	
	public Semifabricat getSemifabricat() {
		return semifabricat;
	}


	public void setSemifabricat(Semifabricat semifabricat) {
		this.semifabricat = semifabricat;
	}


	public List<Semifabricat> getSemifabricate() {
		return semifabricate;
	}


	public void setSemifabricate(List<Semifabricat> semifabricate) {
		this.semifabricate = semifabricate;
	}


	public Integer getIdSemifabricat() {
		return idSemifabricat;
	}


	public void setIdSemifabricat(Integer idSemifabricat) {
		this.idSemifabricat = idSemifabricat;
	}


	public String getDen_semifabricat() {
		return den_semifabricat;
	}


	public void setDen_semifabricat(String den_semifabricat) {
		this.den_semifabricat = den_semifabricat;
	}


	public ArrayList<Material> getListaMateriale() {
		return listaMateriale;
	}


	public void setListaMateriale(ArrayList<Material> listaMateriale) {
		this.listaMateriale = listaMateriale;
	}


	public Semifabricat getSemifabricatContinut() {
		return semifabricatContinut;
	}


	public void setSemifabricatContinut(Semifabricat semifabricatContinut) {
		this.semifabricatContinut = semifabricatContinut;
	}

	/*--navigare--*/
	public void previousSemifabricat(ActionEvent evt){
		Integer idxCurent = this.semifabricate.indexOf(semifabricat);
		if (idxCurent > 0)
			this.semifabricat = this.semifabricate.get(idxCurent - 1);
	}

	public void nextSemifabricat(ActionEvent evt){
		Integer idxCurent = this.semifabricate.indexOf(semifabricat);
		if ((idxCurent+1) < this.semifabricate.size())
			this.semifabricat = this.semifabricate.get(idxCurent + 1);
	}	
	
	
	/* ---operatii CRUD--- */
	public void adaugareSemifabricat(ActionEvent evt){
		this.semifabricat.setIdSemifabricat(idSemifabricat);
		this.semifabricat.setSemifabricat(den_semifabricat);
		this.semifabricat.setListaMateriale(listaMateriale);
		this.semifabricat.setSemifabricatContinut(semifabricatContinut);
		
		logger.info("---adaugare semifabricat----" );
		
	} 
	  
	public void stergereSemifabricat(ActionEvent evt) throws Exception{
		this.semifabricate.remove(this.semifabricat);
		logger.info("---stergere semifabricat----id: "+semifabricat.getIdSemifabricat());
		productieSrv.stergeSemifabricat(this.semifabricat);
		 
		if (!this.semifabricate.isEmpty())
			this.semifabricat = this.semifabricate.get(0);
		else
			this.semifabricat = null;
	} 
	 
	public void salvareSemifabricat(ActionEvent evt) throws Exception{
		this.semifabricate.remove(this.semifabricat);
		
		this.semifabricat = productieSrv.salveazaSemifabricat(semifabricat.getIdSemifabricat(), semifabricat.getDenumire(), semifabricat.getListaMateriale(), semifabricat.getSemifabricatContinut());
		logger.info("--salvare flux---id " + semifabricat.getIdSemifabricat());
		this.semifabricate.add(this.semifabricat);
	
	}
	
	

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		if (uiComp.getId().equals("txtIdSemifabricat")){
			Semifabricat uiSemifabricatTemplate = new Semifabricat(Integer.valueOf(uiValue), null, null, null);
			int idx = this.semifabricate.indexOf(uiSemifabricatTemplate);
			
			return this.semifabricate.get(idx); 
		}
		 
		if (uiComp.getId().equals("listMateriale")){
			List<Material> uiMaterialeTemplate = new ArrayList<Material>();
			uiMaterialeTemplate.listIterator().toString();
			Integer idx = this.listaMateriale.indexOf(uiMaterialeTemplate);
			
			return this.listaMateriale.listIterator().toString();
		}
		 
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		if (uiComp.getId().equals("txtIdSemifabricat")){
		
			Semifabricat uiSemifabricat = (Semifabricat)uiValue;
			if (uiSemifabricat.getIdSemifabricat()!=null) //poate veni null din click Add
				return uiSemifabricat.getIdSemifabricat().toString();
		}
		 
		
		if (uiComp.getId().equals("listMateriale")){
			if (uiValue != null){
				List<Material> uiMateriale = (List<Material>)uiValue;
				return uiMateriale.listIterator().toString();
			}
			
		}
		return null;
		
	}

}
