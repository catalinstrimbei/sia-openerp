package org.open.erp.ui;

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
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.NomenclatoareSrvLocal;
import org.open.erp.services.nomgen.Produs;


@ManagedBean(name="formMaterial")
@SessionScoped
public class FormMaterial implements Converter{

private static Logger logger = Logger.getLogger(FormPersoana.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(name="NomenclatoareSrv/local", mappedName="NomenclatoareSrv/local")
	private NomenclatoareSrvLocal nomgenInstance;
	
	/* Data Model */
	private List<Material> materiale = new ArrayList<Material>();
	private Material material;
	
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material p) {
		logger.debug("Changed material : " + p.getDenumire() + " :: " + p.getIdMaterial());
		this.material = p;
		//populareModelActivitati();
	}
	
	
	public Map<String, Material> getMateriale(){
		logger.debug("getMateriale : " + this.materiale.size());
		Map<String, Material> mapMateriale = new HashMap<String, Material>();
		for (Material p: this.materiale)
			mapMateriale.put(p.getDenumire(), p);
		return mapMateriale;
	}
	
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboPersoane")){
			// StringId - to - produs
			String denumire = new String(uival);
			//Integer idPersoana = new Integer(uival);
			Material p = new Material();
			p.setDenumire(denumire);
			Integer idx = this.materiale.indexOf(p);
			return this.materiale.get(idx);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboMateriale")){
			// produs - to - StringId
			return ((Material)uival).getDenumire().toString();
		}
		return null;
	}
	
	
	/* Actiuni UI Controller */
	public String nextMaterial(){
		Integer idx = this.materiale.indexOf(this.material) + 1;
		
		logger.debug("Next material : " + idx + " | " + this.materiale.size());
		
		if (idx > 0 && idx < this.materiale.size()){
			this.setMaterial(this.materiale.get(idx));
			//populareModelActivitati();
		}
		return "FormMaterial";
	}
	
	public void nextMaterial(ActionEvent evt){
		nextMaterial();
	}

	public void previousMaterial(ActionEvent evt){
		previousMaterial();
	}
	
	public String previousMaterial(){
		Integer idx = this.materiale.indexOf(this.material) - 1;
		
		logger.debug("Previous material : " + idx + " | " + this.materiale.size());
		
		if (idx >= 0 && idx < this.materiale.size()){
			this.setMaterial(this.materiale.get(idx));
			//populareModelActivitati();
		}
		
		return "FormMaterial";
		
	}	
	
	/* Actiuni tranzactionale*/
	public String adaugareMaterial(){
		
		this.material = new Material();
		this.materiale.add(this.material);
		
		return "FormMaterial";
	}
	
	public boolean getDisableNext(){
		if (this.materiale.indexOf(this.material) == this.materiale.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		System.out.println("Enable Next");
		return false;
		
	}
	
	public String salvareMaterial() throws Exception{
		logger.debug("LOGGER Salvare material: " + this.material.getDenumire() + "::" + this.material.getIdMaterial());
		this.materiale.remove(this.material);
		this.material = (Material) nomgenInstance.addMaterial(material);
		this.materiale.add(this.material);
		return "FormProdus";
	}
	
	
	/*--- Utils: InitialContext Client EJB-JDNI ----------------------------------------------------*/
	private static InitialContext initJBossJNDICtx() throws Exception{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}
	
	/* Initializare formularului*/	
	
	/*Strategia 1: Injectare privata EJB - referinta EJB nepartajata */
	@PostConstruct // Referinta EJB injectata este disponibila numai abua in handlerul PostConstruct, si nu la nivelul constructorului
	private void initForm() throws Exception{
		logger.debug("PostConstruct FORM Materiale local-nomgen: ..." + this.nomgenInstance);

		this.materiale = (List<Material>) nomgenInstance.getMaterialOrdonatbyId();
		if (!materiale.isEmpty())
			this.material = materiale.get(0);
		else{
			System.out.println("No material available!");
			this.material = new Material();
			material.setDenumire("Denumire....");
		}
		
	}
	
	
	
	public void validate(FacesContext arg0, UIComponent uiComponent, Object uiValue)
			throws ValidatorException {
		if ("id".equals(uiComponent.getId())){
			System.out.println("Validare id material");
			String id = uiValue.toString();
			FacesMessage mesaj = null;
			if (id == null || id.isEmpty()){
				mesaj = new FacesMessage("Idul materialului trebuie completat!");
			}
			System.out.println("Id: " + id + ": " + id.substring(0, 1));
			
			
			if (mesaj != null){
				throw new ValidatorException(mesaj);
			}
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
	
	
	
	
	
	
}
