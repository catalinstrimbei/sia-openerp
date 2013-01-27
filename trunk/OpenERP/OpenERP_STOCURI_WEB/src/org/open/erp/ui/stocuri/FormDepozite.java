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
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.StocuriSrv;



@ManagedBean(name="formDepozite")
@SessionScoped
public class FormDepozite implements Converter{
	/* Resurse test*/
	private static Logger logger = Logger.getLogger(FormDepozite.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(lookup="java:global/OpenERP_STOCURI/StocuriImpl!org.open.erp.services.stocuri.StocuriSrv")
	private StocuriSrv stocuriInstance;
	
	/* Data Model */
	public  List<Depozit> depozite = new ArrayList<Depozit>();
	public Depozit depozit;
	
	public Depozit getDepozit() {
		return depozit;
	}

	public void setDepozit(Depozit depozit) {
		logger.debug("Changed depozit : " + depozit.getIdDepozit() + " :: " + depozit.getLocatie());
		this.depozit = depozit;
// ce-i asta ?! 
		//populareModelActivitati();
	}
	
	public Map<String, Depozit> getDepozite(){
		logger.debug("getDepozite : " + this.depozite.size());
		Map<String, Depozit> mapDepozite = new HashMap<String, Depozit>();
		for (Depozit p: this.depozite)
			mapDepozite.put(p.getIdDepozit().toString(), p);
		return mapDepozite;
	}
	
//	private DataModel<Activitate> activitati;
//	private Activitate activitate;
	
/*	public Activitate getActivitate() {
		
		logger.debug("get id: " + ((activitate!=null)? activitate.getIdActivitate() : "null") );
		return activitate;
	}

	public DataModel<Activitate> getActivitati() {
		logger.debug("Check model activitati ... ");
		if (this.activitati == null)
			populareModelActivitati();
		return activitati;
	}
	
	private void populareModelActivitati(){
		if (proiect != null){
			this.activitati = new ListDataModel<Activitate>();
			this.activitati.setWrappedData(proiect.getActivitati());
			logger.debug("Populare model activitati ... DEBUG ");
		}else
			this.activitati = null;
	}
*/
	/* Logica Convertor*/
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboDepozite")){
			// StringId - to - Proiect
			Integer idDepozit = new Integer(uival);
			Depozit p = new Depozit();
			p.setIdDepozit(idDepozit);
			Integer idx = this.depozite.indexOf(p);
			return this.depozite.get(idx);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboDepozite")){
			// Proiect - to - StringId
			return ((Depozit)uival).getIdDepozit().toString();
		}
		return null;
	}		
	
	/* Actiuni UI Controller */
	public String nextDepozit(){
		Integer idx = this.depozite.indexOf(this.depozit) + 1;
		
		logger.debug("Next depozit : " + idx + " | " + this.depozite.size());
		
		if (idx > 0 && idx < this.depozite.size()){
			this.setDepozit(this.depozite.get(idx));
			//populareModelActivitati();
		}
		return "FormDepozite";
	}
	
	public void nextDepozit(ActionEvent evt){
		nextDepozit();
	}

	public void previousDepozit(ActionEvent evt){
		previousDepozit();
	}
	
	public String previousDepozit(){
		Integer idx = this.depozite.indexOf(this.depozit) - 1;
		
		logger.debug("Previous depozit : " + idx + " | " + this.depozite.size());
		
		if (idx >= 0 && idx < this.depozite.size()){
			this.setDepozit(this.depozite.get(idx));
			//populareModelActivitati();
		}
		
		return "FormDepozite";
		
	}	
/*	
	public void setActivitateCurenta(ValueChangeEvent evt){
		if (this.activitati.getRowData() != null)
			logger.debug("setActivitateCurenta:: " + this.activitati.getRowData().getTitulatura());
		this.activitate = this.activitati.getRowData();
	}
*/	
	/* Actiuni tranzactionale*/
	public String adaugareDepozit(){
		
		this.depozit = new Depozit();
		this.depozite.add(this.depozit);
		
		return "FormDepozite";
	}
	
	public boolean getDisableNext(){
		if (this.depozite.indexOf(this.depozit) == this.depozite.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		System.out.println("Enable Next");
		return false;
		
	}
	
	public String salvareDepozit() throws Exception{
		logger.debug("LOGGER Salvare depozit: " + this.depozit.getLocatie());

		this.depozite.remove(this.depozit);
		this.depozit = stocuriInstance.salvareDepozit(this.depozit);
		this.depozite.add(this.depozit);
		return "FormDepozite";
		
	}
	
	public String stergeDepozit() throws Exception{
		logger.debug("LOGGER Salvare depozit: " + this.depozit.getLocatie());

		
		stocuriInstance.stergereDepozit(this.depozit);
		this.depozite.remove(this.depozit);
		this.initForm();
		return "FormDepozite";
		
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
		logger.debug("PostConstruct FORM DEPOZITE local-stocuri: ..." + this.stocuriInstance);

		this.depozite = stocuriInstance.getDepozite();
		if (!depozite.isEmpty())
			this.depozit = depozite.get(0);
		else{
			System.out.println("No project available!");
		 	this.depozit = new Depozit();
			depozit.setLocatie("Def pro ...");
			logger.debug("ajunge aici");
	
		}
		
	}
	
	
	/* Strategia 2: Folosind AppEJB Provider - partajare injectie EJB */
	public FormDepozite() throws Exception{
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
	}
	public void validate(FacesContext arg0, UIComponent uiComponent, Object uiValue)
			throws ValidatorException {
		if ("locatie".equals(uiComponent.getId())){
			System.out.println("Validare Locatie");
			String locatie = uiValue.toString();
			FacesMessage mesaj = null;
			if (locatie == null || locatie.isEmpty()){
				mesaj = new FacesMessage("Numele Locatiei trebuie completat!");
			}
			System.out.println("Locatie: " + locatie + ": " + locatie.substring(0, 1));
			if (!locatie.substring(0,1).equals(locatie.substring(0, 1).toUpperCase())){
				mesaj = new FacesMessage("Numele locatiei trebuie scris cu majuscula!");
				logger.debug("Validate - numedepozit: " +  this.depozit.getIdDepozit());
			}
			
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