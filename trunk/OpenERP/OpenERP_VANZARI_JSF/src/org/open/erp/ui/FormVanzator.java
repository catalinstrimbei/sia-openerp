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
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.open.erp.services.vanzari.VanzariSrv;
import org.open.erp.services.vanzari.Vanzator;





@ManagedBean(name="formVanzator")
@SessionScoped
public class FormVanzator implements Converter{

	
private static Logger logger = Logger.getLogger(FormVanzator.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(name="VanzariSrv", mappedName="VanzariSrv")
	private VanzariSrv vanzariInstance;
	
	/* Data Model */
	private List<Vanzator> Vanzatori = new ArrayList<Vanzator>();
	private Vanzator Vanzator;
	
	public Vanzator getVanzator() {
		return Vanzator;
	}

	public void setVanzator(Vanzator v) {
		logger.debug("Changed proiect : " + v.getCodAcces() + " :: " + v.getNume());
		this.Vanzator = v;
		//populareModelActivitati();
	}
	
	
	
	public Map<String, Vanzator> getVanzatori(){
		logger.debug("getVanzatori : " + this.Vanzatori.size());
		Map<String, Vanzatori> mapVanzatori = new HashMap<String, Vanzator>();
		for (Vanzator v: this.Vanzatori)
			mapVanzatori.put(v.getNume(), v);
		return mapVanzatori;
	}
	
	

	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		logger.debug("getAsObject:uicomp: " + uicomp.getCodAcces());
		if (uicomp.getCodAcces().equals("cboVanzator")){
		
			Integer codAcces = new Integer(uival);
			Vanzator v = new Vanzator();
			v.setCodAcces(codAcces);
			Integer idx = this.Vanzatori.indexOf(v);
			return this.Vanzatori.get(idx);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		logger.debug("getAsString:uicomp: " + uicomp.getCodAcces());
		if (uicomp.getCodAcces().equals("cboVanzator")){
			
			return ((Vanzator)uival).getCodAcces().toString();
		}
		return null;
	}
	
	
	/* Actiuni UI Controller */
	public String nextVanzator(){
		Integer idx = this.Vanzatori.indexOf(this.Vanzator) + 1;
		
		logger.debug("Next Vanzator : " + idx + " | " + this.Vanzatori.size());
		
		if (idx > 0 && idx < this.Vanzatori.size()){
			this.setVanzator(this.Vanzator.get(idx));
			//populareModelActivitati();
		}
		return "FormVanzator";
	}
	
	public void nextVanzator(ActionEvent evt){
		nextVanzator();
	}

	public void previousVanzator(ActionEvent evt){
		previousVanzator();
	}
	
	public String previousVanzator(){
		Integer idx = this.Vanzatori.indexOf(this.Vanzator) - 1;
		
		logger.debug("Previous Vanzator : " + idx + " | " + this.Vanzatori.size());
		
		if (idx >= 0 && idx < this.Vanzatori.size()){
			this.setVanzator(this.Vanzatori.get(idx));
			//populareModelActivitati();
		}
		
		return "FormVanzator";
		
	}	
	

	/* Actiuni tranzactionale*/
	public String adaugareVanzator(){
		
		this.Vanzator = new Vanzator();
		this.Vanzatori.add(this.Vanzator);
		
		return "FormVanzator";
	}
	
	public boolean getDisableNext(){
		if (this.Vanzatori.indexOf(this.Vanzator) == this.Vanzatori.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		System.out.println("Enable Next");
		return false;
		
	}
	
	public String salvareVanzator() throws Exception{
		logger.debug("LOGGER Salvare Vanzator: " + this.Vanzator.getNume() + "::" + this.Vanzator.getcodAcces());
		this.Vanzatori.remove(this.Vanzator);
		this.Vanzator = vanzariInstance.addVanzator(Vanzator);
		this.Vanzatori.add(this.Vanzator);
		return "FormVanzator";
	}
	
	/*--- Utils: InitialContext Vanzator EJB-JDNI ----------------------------------------------------*/
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
		logger.debug("PostConstruct FORM PROIECTE local-proman: ..." + this.vanzariInstance);

		this.Vanzatori = (List<Vanzator>) vanzariInstance.getVanzator();
		if (!Vanzatori.isEmpty())
			this.Vanzator = Vanzatori.get(0);
		else{
			System.out.println("No Vanzator available!");
			this.Vanzator = new Vanzator();
			Vanzator.setNume("Nume....");
		}
		
	}
	
	
	
	public void validate(FacesContext arg0, UIComponent uiComponent, Object uiValue)
			throws ValidatorException {
		if ("codAcces".equals(uiComponent.getId())){
			System.out.println("Validare cod acces Vanzator");
			String codAcces = uiValue.toString();
			FacesMessage mesaj = null;
			if (codAcces == null || id.isEmpty()){
				mesaj = new FacesMessage("Codul de acces al Vanzatorului trebuie completat!");
			}
			System.out.println("Cod acces: " + codAcces + ": " + codAcces.substring(0, 1));
			
			
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
