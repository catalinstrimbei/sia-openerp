package org.open.erp.ui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.NomenclatoareSrvLocal;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.ProductieSrvLocal;
import org.open.erp.services.productie.Semifabricat;

public class FormSemifabricat implements Converter{
	Semifabricat semifabricat;
	List<Semifabricat> semifabricate= new ArrayList<Semifabricat>();
	Integer idSemifabricat;
	String den_semifabricat;
	ArrayList <Material> listaMateriale;
	Semifabricat semifabricatContinut;
	

	@EJB(mappedName="ProductieSrv/local", name="ProductieSrv/local") 
	private ProductieSrvLocal productieSrv;
	
	@EJB(mappedName="NomenclatoareImpl/local", name="NomenclatoareImpl/local") 
	private NomenclatoareSrvLocal nomenclatoareSrv;

	
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ProductieSrv.class.getName());
	
	@PostConstruct
	public void initFormSemifabricat() throws Exception{
				
		semifabricate = productieSrv.getListaSemifabricate();
		if (!semifabricate.isEmpty())
			semifabricat = semifabricate.get(0);
		
		listaMateriale=(ArrayList<Material>) nomenclatoareSrv.getMaterialOrdonatbyId();
			
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


	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
