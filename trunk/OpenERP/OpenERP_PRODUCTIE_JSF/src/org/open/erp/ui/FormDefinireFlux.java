package org.open.erp.ui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


import org.open.erp.services.nomgen.NomenclatoareSrvLocal;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.PersonalSrvLocal;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FluxProductie;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.ProductieSrvLocal;




public class FormDefinireFlux implements Converter {
	
    Integer idFlux;
	Produs produs;
	ArrayList <FazaProductie> faze;
	FluxProductie flux;
	List<FluxProductie> fluxuri = new ArrayList<FluxProductie>();
	
	
	@EJB(mappedName="ProductieSrv/local", name="ProductieSrv/local") 
	private ProductieSrvLocal productieSrv;
	
	@EJB(mappedName="NomenclatoareImpl/local", name="NomenclatoareImpl/local") 
	private NomenclatoareSrvLocal nomenclatoareSrv;
	
	@EJB(mappedName="PersonalSrv/local", name="PersonalSrv/local") 
	private PersonalSrvLocal personalSrv;
	
	@PostConstruct
	public void initFormPontaj() throws Exception{
		org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ProductieSrv.class.getName());
		
		fluxuri = productieSrv.getListaFluxuri();
		if (!fluxuri.isEmpty())
			flux = fluxuri.get(0);
			}

	public FluxProductie getFluxProductie() {
		return flux;
	}
	
	public void setFluxProductie(FluxProductie flux) {
		this.flux = flux;
	}
	
	
	public List<FluxProductie> getListaFluxuri() {
		return fluxuri;
	}
	
	
	public void setFluxuriProductie(List<FluxProductie> fluxuri) {
		this.fluxuri = fluxuri;
	}
	
	public Produs getProdus(){
		return this.produs;
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
