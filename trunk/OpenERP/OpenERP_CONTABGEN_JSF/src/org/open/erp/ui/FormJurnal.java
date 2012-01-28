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
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.InregistrareRJ;
import org.open.erp.services.ctbgen.ArticolCtb;;

@ManagedBean(name="formJurnal")
@SessionScoped
public class FormJurnal implements Converter{
	/* Resurse test*/
	private static Logger logger = Logger.getLogger(FormJurnal.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(name = "ContabilizareSrv", mappedName="ContabilizareSrv")
	private ContabilizareSrv contabInstance;
	
	/* Data Model */
	private List<InregistrareRJ> inregistrari = new ArrayList<InregistrareRJ>();
	private InregistrareRJ inreg;
	
	public InregistrareRJ getInregistrare() {
		return inreg;
	}

	public void setInregistrare(InregistrareRJ inreg) {
		logger.debug("Changed proiect : " + inreg.getIdInregRJ());
		this.inreg = inreg;
		populareModelArticole();
	}
	
	public Map<Integer, InregistrareRJ> getProiecte(){
		logger.debug("getInregistrari : " + this.inregistrari.size());
		Map<Integer, InregistrareRJ> mapInregistrareRJ = new HashMap<Integer, InregistrareRJ>();
		for (InregistrareRJ p: this.inregistrari)
			mapInregistrareRJ.put(p.getIdInregRJ(), p);
		return mapInregistrareRJ;
	}
	
	
	private List <ArticolCtb> articole;
	private ArticolCtb articol;

	

	
	
	public ArticolCtb getArticol() {
		
		logger.debug("get id: " + ((articol!=null)? articol.getIdArt() : "null") );
		return articol;
	}

	
	
	public DataModel getArticole() {
		logger.debug("Check model articole ... ");
		if (this.articole == null)
			populareModelArticole();
		return  (DataModel) articole;
	}
	
	private void populareModelArticole(){
		if (inreg != null){
			this.articole = (List<ArticolCtb>) new ListDataModel();
			 ((DataModel) this.articole).setWrappedData(inreg.getArticoleRJ());
			logger.debug("Populare model activitati ... DEBUG ");
		}else
			this.articole = null;
	}

	/* Logica Convertor*/
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboInreg")){
			// StringId - to - Proiect
			Integer idInreg = new Integer(uival);
			InregistrareRJ p = new InregistrareRJ();
			p.setIdInregRJ(idInreg);
			Integer idx = this.inregistrari.indexOf(p);
			return this.inregistrari.get(idx);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboInreg")){
			// Proiect - to - StringId
			return ((InregistrareRJ)uival).getIdInregRJ().toString();
		}
		return null;
	}		
	
	/* Actiuni UI Controller */
	public String nextProiect(){
		Integer idx = this.inregistrari.indexOf(this.inreg) + 1;
		
		logger.debug("Next proiect : " + idx + " | " + this.inregistrari.size());
		
		if (idx > 0 && idx < this.inregistrari.size()){
			this.setInregistrare(this.inregistrari.get(idx));
			//populareModelActivitati();
		}
		return "FormProiecte";
	}
	
	public void nextProiect(ActionEvent evt){
		nextProiect();
	}

	public void previousProiect(ActionEvent evt){
		previousProiect();
	}
	
	public String previousProiect(){
		Integer idx = this.inregistrari.indexOf(this.inreg) - 1;
		
		logger.debug("Previous proiect : " + idx + " | " + this.inregistrari.size());
		
		if (idx >= 0 && idx < this.inregistrari.size()){
			this.setInregistrare(this.inregistrari.get(idx));
			//populareModelActivitati();
		}
		
		return "FormProiecte";
		
	}	
	
	public void setActivitateCurenta(ValueChangeEvent evt){
		if ( ((DataModel) this.articole).getRowData() != null)
			logger.debug("setActivitateCurenta:: " + ((DataModel) this.articole).getRowData().toString());
		this.articol =  (ArticolCtb) ( (DataModel) this.articole).getRowData();
	}
	
	/* Actiuni tranzactionale*/
	public String adaugareInreg(){
		
		this.inreg = new InregistrareRJ();
		this.inregistrari.add(this.inreg);
		
		return "FormProiecte";
	}
	
	public boolean getDisableNext(){
		if (this.inregistrari.indexOf(this.inreg) == this.inregistrari.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		System.out.println("Enable Next");
		return false;
		
	}
	
	public String salvareInreg() throws Exception{
		logger.debug("LOGGER Salvare proiect: " + this.inreg.getIdInregRJ());
		this.inregistrari.remove(this.inreg);
		this.inreg = contabInstance.salvareInreg(this.inreg);
		this.inregistrari.add(this.inreg);
		return "FormJurnal";
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
		logger.debug("PostConstruct FORM PROIECTE local-proman: ..." + this.contabInstance);

		this.inregistrari = (List<InregistrareRJ>) contabInstance.getRegInregistrari();
		if (!inregistrari.isEmpty())
			this.inreg = inregistrari.get(0);
		else{
			System.out.println("No project available!");
			this.inreg = new InregistrareRJ();
			//inreg.setNume("Def pro ...");
		}
		
	}
	
	
	/* Strategia 2: Folosind AppEJB Provider - partajare injectie EJB */
	public FormJurnal() throws Exception{
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
				logger.debug("Validate - document legatura: " +  this.inreg.getIdInregRJ());
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
