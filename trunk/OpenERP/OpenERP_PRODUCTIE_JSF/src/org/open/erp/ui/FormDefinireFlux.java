package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;


import org.open.erp.services.nomgen.NomenclatoareSrvLocal;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FluxProductie;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.ProductieSrvLocal;



@ManagedBean(name="formDefinireFlux")
@SessionScoped
public class FormDefinireFlux implements Converter {
	
    Integer idFlux;
	Produs produs;
	FazaProductie faza;
	FluxProductie flux;
	List<FluxProductie> fluxuri = new ArrayList<FluxProductie>();
	List<Produs> produse = new ArrayList<Produs>();
	List<FazaProductie> faze = new ArrayList<FazaProductie>();
	
	private Map<String, FluxProductie> mapFluxuri= new HashMap<String, FluxProductie>();
	
	private Map<String, Produs> mapProduse = new HashMap<String, Produs>();
	
	private Map<String, FazaProductie> mapFaze = new HashMap<String, FazaProductie>();
	
	
	@EJB(mappedName="ProductieSrv/local", name="ProductieSrv/local") 
	private ProductieSrvLocal productieSrv;
	
	@EJB(mappedName="NomenclatoareImpl/local", name="NomenclatoareImpl/local") 
	private NomenclatoareSrvLocal nomenclatoareSrv;

	
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ProductieSrv.class.getName());
	
	@PostConstruct
	public void initFormDefinireFlux() throws Exception{
		
		fluxuri = productieSrv.getListaFluxuri();
		if (!fluxuri.isEmpty())
			flux = fluxuri.get(0);
		faze = flux.getFaze();
		
		produse=nomenclatoareSrv.getProduse();
	
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
	
	public List<FazaProductie> getListaFaze() {
		return faze;
	}
	
	public void setFazeFlux(List<FazaProductie> faze){
		this.faze=faze;
	}
	
	
	/* --navigare-- */
	public void previousFlux(ActionEvent evt){
		Integer idxCurent = this.fluxuri.indexOf(flux);
		if (idxCurent > 0)
			this.flux = this.fluxuri.get(idxCurent - 1);
	}

	public void nextFlux(ActionEvent evt){
		Integer idxCurent = this.fluxuri.indexOf(flux);
		if ((idxCurent+1) < this.fluxuri.size())
			this.flux = this.fluxuri.get(idxCurent + 1);
	}	
	
	/* ---operatii CRUD--- */
	public void adaugareFlux(ActionEvent evt){
		this.flux = new FluxProductie();
		this.flux.setIdFlux(1);
		this.flux.setProdus(getProdus());
		this.flux.adaugaFaza(faza);
		logger.info("---adaugare flux----" );
		
	} 
	  
	public void stergereFlux(ActionEvent evt) throws Exception{
		this.fluxuri.remove(this.flux);
		logger.info("---stergere flux----id: "+flux.getIdFlux());
		productieSrv.stergeFlux(this.flux);
		 
		if (!this.fluxuri.isEmpty())
			this.flux = this.fluxuri.get(0);
		else
			this.flux = null;
		
		
	} 
	 
	public void salvareFlux(ActionEvent evt) throws Exception{
		this.fluxuri.remove(this.flux);
		
		this.flux = productieSrv.definireFluxProductie(flux.getIdFlux(), flux.getProdus());
		logger.info("--salvare flux---id " + flux.getIdFlux());
		this.fluxuri.add(this.flux);
	
	}
	
	/* Implementare suport pentru navigare-selectie lista combinata*/
	public Map<String, FluxProductie> getFluxuri(){
		mapFluxuri = new HashMap<String, FluxProductie>();
		for (FluxProductie f: fluxuri){
			mapFluxuri.put(f.getIdFlux().toString(), f);
		}
		return mapFluxuri;
	}
	
	public List<FluxProductie> getFluxuriList(){
		return this.fluxuri;
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp, String uiValue) {
		if (uiComp.getId().equals("txtIdFlux")){
			FluxProductie uiFluxTemplate = new FluxProductie(Integer.valueOf(uiValue), flux.getProdus());
			int idx = this.fluxuri.indexOf(uiFluxTemplate);
			
			return this.fluxuri.get(idx); 
		}
		
		if (uiComp.getId().equals("cboProdus")){
			Produs uiProdusTemplate = new Produs();
			uiProdusTemplate.setIdMaterial(Integer.valueOf(uiValue));
			Integer idx = this.produse.indexOf(uiProdusTemplate);
			
			return this.produse.get(idx);
		}
		 
		if (uiComp.getId().equals("listFaze")){
			List<FazaProductie> uiFazeTemplate = new ArrayList<FazaProductie>();
			uiFazeTemplate.listIterator().toString();
			Integer idx = this.faze.indexOf(uiFazeTemplate);
			
			return this.faze.listIterator().toString();
		}
		 
		return null;
		}

	@SuppressWarnings("unchecked")
	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp, Object uiValue) {
		if (uiComp.getId().equals("txtIdFlux")){
		
			FluxProductie uiFlux = (FluxProductie)uiValue;
			if (uiFlux.getIdFlux()!=null) //poate veni null din click Add
				return uiFlux.getIdFlux().toString();
		}
		 
		if (uiComp.getId().equals("cboProdus")){
			if (uiValue != null){
				Produs uiProdus = (Produs)uiValue;
				return uiProdus.getIdMaterial().toString();
			}	
		}
		
		if (uiComp.getId().equals("listFaze")){
			if (uiValue != null){
				List<FazaProductie> uiFaze = (List<FazaProductie>)uiValue;
				return uiFaze.listIterator().toString();
			}	
		}
		return null;
	}

	
	public Map<String, Produs> getProduse(){
		mapProduse = new HashMap<String, Produs>();
		for (Produs p: produse){
			mapProduse.put(p.getDenumire(), p);
		}
		return mapProduse;
	}
	
	public List<Produs> getProdusList(){
		return this.produse;
	}
	
	public Map<String, FazaProductie> getFazeFlux(){
		mapFaze = new HashMap<String, FazaProductie>();
		for (FazaProductie fz: faze){
			mapFaze.put(fz.getFaza(), fz);
		}
		return mapFaze;
	}
	
	public List<FazaProductie> getFazeFluxList(){
		return this.faze;
	}
	
	
}
