package org.open.erp.ui.stocuri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.stocuri.BonTransfer;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.StocuriSrv;

@ManagedBean(name="formbonuri")
@SessionScoped
public class formbonuri implements Converter {
	/* Resurse test*/
	private static Logger logger = Logger.getLogger(formbonuri.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(lookup="java:global/OpenERP_STOCURI/StocuriImpl!org.open.erp.services.stocuri.StocuriSrv")
	private StocuriSrv stocuriInstance;
	/* Model Bon Transfer*/
	BonTransfer bon;
	
	
	/* Data Model Material */
	private List<Material> materiale = new ArrayList<Material>();
	private Material material;
	
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material mat) {
		logger.debug("Changed material : " + mat.getCodMaterial());
		this.material = mat;
		//populareModelActivitati();
	}
	
	public Map<String, Material> getMateriale(){
		logger.debug("getMateriale : " + this.materiale.size());
		Map<String, Material> mapMateriale = new HashMap<String, Material>();
		for (Material p: this.materiale)
			mapMateriale.put(p.getCodMaterial(), p);
		return mapMateriale;
	}
		
	/* Data Model Gestiune Iesire */
	private List<Gestiune> gestiuniies = new ArrayList<Gestiune>();
	private Gestiune gestiuneies;
	
	public Gestiune getGestiuneIes() {
		return gestiuneies;
	}

	public void setGestiuneIes(Gestiune gest) {
		logger.debug("Changed material : " + gest.getDenumireGest());
		this.gestiuneies = gest;
		//populareModelActivitati();
	}
	
	public Map<String, Gestiune> getGestiuniIes(){
		logger.debug("getGestiuniIes : " + this.gestiuniies.size());
		Map<String, Gestiune> mapGestiniIes = new HashMap<String, Gestiune>();
		for (Gestiune g: this.gestiuniies)
			mapGestiniIes.put(g.getDenumireGest(), g);
		return mapGestiniIes;
	}
	
	/* Data Model Gestiune Intrare */
	private List<Gestiune> gestiuniintr = new ArrayList<Gestiune>();
	private Gestiune gestiuneintr;
	
	public Gestiune getGestiuneIntr() {
		return gestiuneintr;
	}

	public void setGestiuneIntr(Gestiune gest) {
		logger.debug("Changed gestiune : " + gest.getIdGest());
		this.gestiuneintr = gest;
		//populareModelActivitati();
	}
	
	public Map<String, Gestiune> getGestiuniIntr(){
		logger.debug("getGestiuni : " + this.gestiuniintr.size());
		Map<String, Gestiune> mapGestiuniIntr = new HashMap<String, Gestiune>();
		for (Gestiune g: this.gestiuniintr)
			mapGestiuniIntr.put(g.getDenumireGest(), g);
		return mapGestiuniIntr;
	}
	
	
	/*--- Utils: InitialContext Client EJB-JDNI ----------------------------------------------------*/
	@SuppressWarnings("unused")
	private static InitialContext initJBossJNDICtx() throws Exception{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}
	/* Initializare formularului*/	
	
	/*Strategia 1: Injectare privata EJB - referinta EJB nepartajata */
	@SuppressWarnings("unused")
	@PostConstruct // Referinta EJB injectata este disponibila numai abua in handlerul PostConstruct, si nu la nivelul constructorului
	private void initForm() throws Exception{
		logger.debug("PostConstruct FORM Materiale local-stoc: ..." + this.stocuriInstance);
		List<Material> materiale = stocuriInstance.getMateriale();		
		//Material mat = stocuriInstance.getMaterial("2");
		//this.materiale.add(mat);
		if (!materiale.isEmpty())
			this.material = materiale.get(0);
		else{
			System.out.println("No materials available!");
			this.material = new Material();
			material.setDenumireMaterial("Den of..");
		}
		
		logger.debug("PostConstruct FORM Gestiuni local-stoc: ..." + this.stocuriInstance);
		List<Gestiune> gestiuniies = stocuriInstance.getGestiuni();
		if (!gestiuniies.isEmpty())
			this.gestiuneies = gestiuniies.get(0);
		else{
			System.out.println("No gestiuni available!");
			this.gestiuneies = new Gestiune();
			gestiuneies.setDenumireGest("Gest ...");
		}
		
		logger.debug("PostConstruct FORM Gestiuni local-stoc: ..." + this.stocuriInstance);
		List<Gestiune> gestiuniintr = stocuriInstance.getGestiuni();
		if (!gestiuniintr.isEmpty())
			this.gestiuneintr = gestiuniintr.get(0);
		else{
			System.out.println("No gestiuni available!");
			this.gestiuneintr = new Gestiune();
			gestiuneintr.setDenumireGest("Gest ...");
		}		
		
	}
	
	/* Faces Logic - procesare erori business*/
	private void ridicaEroare(String mesaj, Boolean anulareTranzactie){
		// Cocepere mesaj
		FacesMessage facesMsg = 
	            new FacesMessage(FacesMessage.SEVERITY_ERROR, "EROARE SALVARE: " + mesaj, null);			
		FacesContext fc = FacesContext.getCurrentInstance();
		
		// Afisare mesaj
		fc.addMessage(null, facesMsg);
		fc.renderResponse();
		
	}
	
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboBonuri")){
			
			Integer codMaterial = new Integer(uival);
			Material m = new Material();
			m.setCodMaterial(codMaterial.toString());
			Integer idx = this.materiale.indexOf(m);
			return this.materiale.get(idx);
		}
		
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cbogestiesire")){
			
			Integer idGest = new Integer(uival);
			Gestiune g = new Gestiune();
			g.setIdGest(idGest);
			Integer idx = this.gestiuniies.indexOf(g);
			return this.gestiuniies.get(idx);
		}
		
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cbogestintrare")){
			
			Integer idGest = new Integer(uival);
			Gestiune g = new Gestiune();
			g.setIdGest(idGest);
			Integer idx = this.gestiuniintr.indexOf(g);
			return this.gestiuniintr.get(idx);
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboBonuri")){
			// Proiect - to - StringId
			return ((Material)uival).getCodMaterial().toString();
		}
		
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cbogestiesire")){
			// Proiect - to - StringId
			return ((Gestiune)uival).getIdGest().toString();
		}
		
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cbogestintrare")){
			// Proiect - to - StringId
			return ((Gestiune)uival).getIdGest().toString();
		}
		return null;
	}
	
	
	/* Actiuni tranzactionale*/
	/*
	public String adaugareBon(){	
		this.bon = new BonTransfer();		
		return "FormProiecte";
	}*/
	
	
	public String salvarBon() throws Exception{
		this.bon = new BonTransfer();
		this.bon.setCantitate(10.00);
		this.bon.setMaterial(this.material);
		this.bon.setGestiuneIesire(this.gestiuneies);
		this.bon.setGestiuneIntrare(this.gestiuneintr);
		stocuriInstance.salvareBonTransfer(this.bon);
		return "FormProiecte";
	}
	
}