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
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;





@ManagedBean(name="formPersoana")
@SessionScoped
public class FormPersoana implements Converter{

	
private static Logger logger = Logger.getLogger(FormPersoana.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(name="NomenclatoareSrv", mappedName="NomenclatoareSrv")
	private NomenclatoareSrv nomgenInstance;
	
	/* Data Model */
	private List<Persoana> persoane = new ArrayList<Persoana>();
	private Persoana persoana;
	
	public Persoana getPersoana() {
		return persoana;
	}

	public void setPersoana(Persoana p) {
		logger.debug("Changed proiect : " + p.getId() + " :: " + p.getAdresa());
		this.persoana = p;
		//populareModelActivitati();
	}
	
	
	
	public Map<String, Persoana> getPersoane(){
		logger.debug("getPersoane : " + this.persoane.size());
		Map<String, Persoana> mapPersoane = new HashMap<String, Persoana>();
		for (Persoana p: this.persoane)
			mapPersoane.put(p.getAdresa(), p);
		return mapPersoane;
	}
	
	

	
	
	
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboPersoane")){
			// StringId - to - persoana
			Integer idPersoana = new Integer(uival);
			Persoana p = new Persoana();
			p.setId(idPersoana);
			Integer idx = this.persoane.indexOf(p);
			return this.persoane.get(idx);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboPersoane")){
			// persoana - to - StringId
			return ((Persoana)uival).getId().toString();
		}
		return null;
	}
	
	
	/* Actiuni UI Controller */
	public String nextPersoana(){
		Integer idx = this.persoane.indexOf(this.persoana) + 1;
		
		logger.debug("Next persoana : " + idx + " | " + this.persoane.size());
		
		if (idx > 0 && idx < this.persoane.size()){
			this.setPersoana(this.persoane.get(idx));
			//populareModelActivitati();
		}
		return "FormPersoana";
	}
	
	public void nextPersoana(ActionEvent evt){
		nextPersoana();
	}

	public void previousPersoana(ActionEvent evt){
		previousPersoana();
	}
	
	public String previousPersoana(){
		Integer idx = this.persoane.indexOf(this.persoana) - 1;
		
		logger.debug("Previous persoana : " + idx + " | " + this.persoane.size());
		
		if (idx >= 0 && idx < this.persoane.size()){
			this.setPersoana(this.persoane.get(idx));
			//populareModelActivitati();
		}
		
		return "FormPersoana";
		
	}	
	

	/* Actiuni tranzactionale*/
	public String adaugarePersoana(){
		
		this.persoana = new Persoana();
		this.persoane.add(this.persoana);
		
		return "FormPersoana";
	}
	
	public boolean getDisableNext(){
		if (this.persoane.indexOf(this.persoana) == this.persoane.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		System.out.println("Enable Next");
		return false;
		
	}
	
	public String salvarePersoana() throws Exception{
		logger.debug("LOGGER Salvare persoana: " + this.persoana.getAdresa() + "::" + this.persoana.getId());
		this.persoane.remove(this.persoana);
		this.persoana = nomgenInstance.addPersoana(persoana);
		this.persoane.add(this.persoana);
		return "FormPersoana";
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
		logger.debug("PostConstruct FORM PROIECTE local-proman: ..." + this.nomgenInstance);

		this.persoane = (List<Persoana>) nomgenInstance.getPersoana();
		if (!persoane.isEmpty())
			this.persoana = persoane.get(0);
		else{
			System.out.println("No person available!");
			this.persoana = new Persoana();
			persoana.setAdresa("Adresa....");
		}
		
	}
	
	
	
	public void validate(FacesContext arg0, UIComponent uiComponent, Object uiValue)
			throws ValidatorException {
		if ("id".equals(uiComponent.getId())){
			System.out.println("Validare id persoana");
			String id = uiValue.toString();
			FacesMessage mesaj = null;
			if (id == null || id.isEmpty()){
				mesaj = new FacesMessage("Idul persoanei trebuie completat!");
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
