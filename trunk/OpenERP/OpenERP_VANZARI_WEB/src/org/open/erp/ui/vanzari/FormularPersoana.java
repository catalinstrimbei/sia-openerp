package org.open.erp.ui.vanzari;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.open.erp.services.vanzari.Persoana;
import org.open.erp.services.vanzari.VanzariSrv;

@ManagedBean(name="FormularPersoana")
@SessionScoped

public class FormularPersoana implements Converter {
	
	/* Resurse test*/
	private static Logger logger = Logger.getLogger(FormularPersoana.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(lookup="java:global/OpenERP_VANZARI/VanzariImpl!org.open.erp.services.vanzari.VanzariSrv")
	private VanzariSrv vanzariInstance;
	
	/* Data Model */
	private List<Persoana> persoane = new ArrayList<Persoana>();
	private Persoana persoana;
	
	

	public Persoana getPersoana() {
		return persoana;
	}

	public void setPersoana(Persoana persoana) {
		logger.debug("Changed persoana : " + persoana.getIdPersoana() + " :: " + persoana.getNume());
		this.persoana = persoana;
	}
	
	public Map<String, Persoana> getPersoane(){
		logger.debug("getPersoane : " + this.persoane.size());
		Map<String, Persoana> mapPersoane = new HashMap<String, Persoana>();
		for (Persoana p: this.persoane)
			mapPersoane.put(p.getNume(), p);
		return mapPersoane;
	}
	
	

	/* Logica Convertor*/
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboProiecte")){
			// StringId - to - Proiect
			Integer idPersona = new Integer(uival);
			Persoana p = new Persoana();
			p.setIdPersoana(idPersona);
			Integer idx = this.persoane.indexOf(p);
			return this.persoane.get(idx);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboPersoane")){
			// Proiect - to - StringId
			return ((Persoana)uival).getIdPersoana().toString();
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
		return "FormularPersoana";
	}
	
	public void nextPersoana(ActionEvent evt){
		nextPersoana();
	}

	
	public String previousPersoana(){
		Integer idx = this.persoane.indexOf(this.persoana) - 1;
		
		logger.debug("Previous persoana : " + idx + " | " + this.persoane.size());
		
		if (idx >= 0 && idx < this.persoane.size()){
			this.setPersoana(this.persoane.get(idx));
			//populareModelActivitati();
		}
		
		return "FormularPersoana";
		
	}	

	public void previousPersoana(ActionEvent evt){
		previousPersoana();
	}
	
	/* Actiuni tranzactionale*/
	public String adaugarePersoana(){
		
		this.persoana = new Persoana();
		this.persoane.add(this.persoana);
		
		return "FormularPersoana";
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
		logger.debug("LOGGER Salvare proiect: " + this.persoana.getNume() + "::" + this.persoana.getPrenume());
		this.persoane.remove(this.persoana);
		this.persoana = vanzariInstance.salvarePersoana(this.persoana);
		this.persoane.add(this.persoana);
		return "FormularPersoana";
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
	private void initForm(){
		logger.debug("PostConstruct FORM Persoana local-vanzari: ..." + this.vanzariInstance);

		this.persoane = vanzariInstance.getPersoane();
		if (!persoane.isEmpty())
			this.persoana = persoane.get(0);
		else{
			System.out.println("No project available!");
			this.persoana = new Persoana();
			persoana.setNume("Def pro ...");
		}
		
	}
	
	
	/* Strategia 2: Folosind AppEJB Provider - partajare injectie EJB */
	//public FormularPersoana() throws Exception{
//		//InitialContext ctx = initJBossJNDICtx(); promanInstance = (ProjectManagementSrv)ctx.lookup("ProjectManagementSrv");
//		promanInstance = AppEJBProvider.getProjectManagementSrv();
//		
//		logger.debug("initTest for JSF " + promanInstance);
//
//		proiecte = promanInstance.getProiecte();
//		if (!proiecte.isEmpty())
//			this.proiect = proiecte.get(0);
//		else{
//			System.out.println("No project available!");
//			this.proiect = new Proiect();
//			proiect.setNume("Def pro ...");
//		}
//		System.out.println("Initial FORM PROIECTE app-proman: ..." + AppEJBProvider.getProjectManagementSrv());
	//}
	/*public void validate(FacesContext arg0, UIComponent uiComponent, Object uiValue)
			throws ValidatorException {
		if ("nume".equals(uiComponent.getId())){
			System.out.println("Validare nume client");
			String nume = uiValue.toString();
			FacesMessage mesaj = null;
			if (nume == null || nume.isEmpty()){
				mesaj = new FacesMessage("Numele proiectului trebuie completat!");
			}
			System.out.println("Nume: " + nume + ": " + nume.substring(0, 1));
			if (!nume.substring(0,1).equals(nume.substring(0, 1).toUpperCase())){
				mesaj = new FacesMessage("Numele proiectului trebuie scris cu majuscula!");
				logger.debug("Validate - numeproiect: " +  this.proiect.getNume());
			}
			
			if (mesaj != null){
				throw new ValidatorException(mesaj);
			}
		}
		
	}
*/
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
