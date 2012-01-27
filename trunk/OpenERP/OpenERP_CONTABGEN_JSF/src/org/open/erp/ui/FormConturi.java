package org.open.erp.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;

import org.open.erp.services.ctbgen.Cont;
import org.open.erp.services.ctbgen.ContabilizareSrv;


@ManagedBean(name="formConturi")
@SessionScoped
public class FormConturi {
	/* Resurse test*/
	private static Logger logger = Logger.getLogger(FormConturi.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(name = "ContabilizareSrv", mappedName="ContabilizareSrv")
	private ContabilizareSrv contabInstance;
	
	
	
	/* Data Model */
	private List<Cont> planConturi = new ArrayList<Cont>();
	private Cont cont;
	
	public Cont getCont() {
		return cont;
	}
//
//	public void setProiect(Proiect proiect) {
//		logger.debug("Changed proiect : " + proiect.getIdProiect() + " :: " + proiect.getNume());
//		this.proiect = proiect;
//		populareModelActivitati();
//	}
//	
//	public Map<String, Proiect> getProiecte(){
//		logger.debug("getProiecte : " + this.proiecte.size());
//		Map<String, Proiect> mapProiecte = new HashMap<String, Proiect>();
//		for (Proiect p: this.proiecte)
//			mapProiecte.put(p.getNume(), p);
//		return mapProiecte;
//	}
//	
//	private DataModel<Activitate> activitati;
//	private Activitate activitate;
//	
//	public Activitate getActivitate() {
//		
//		logger.debug("get id: " + ((activitate!=null)? activitate.getIdActivitate() : "null") );
//		return activitate;
//	}
//
//	public DataModel<Activitate> getActivitati() {
//		logger.debug("Check model activitati ... ");
//		if (this.activitati == null)
//			populareModelActivitati();
//		return activitati;
//	}
//	
//	private void populareModelActivitati(){
//		if (proiect != null){
//			this.activitati = new ListDataModel<Activitate>();
//			this.activitati.setWrappedData(proiect.getActivitati());
//			logger.debug("Populare model activitati ... DEBUG ");
//		}else
//			this.activitati = null;
//	}
//
//	/* Logica Convertor*/
//	@Override
//	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
//		logger.debug("getAsObject:uicomp: " + uicomp.getId());
//		if (uicomp.getId().equals("cboProiecte")){
//			// StringId - to - Proiect
//			Integer idProiect = new Integer(uival);
//			Proiect p = new Proiect();
//			p.setIdProiect(idProiect);
//			Integer idx = this.proiecte.indexOf(p);
//			return this.proiecte.get(idx);
//		}
//		return null;
//	}
//
//	@Override
//	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
//		logger.debug("getAsString:uicomp: " + uicomp.getId());
//		if (uicomp.getId().equals("cboProiecte")){
//			// Proiect - to - StringId
//			return ((Proiect)uival).getIdProiect().toString();
//		}
//		return null;
//	}		
//	
//	/* Actiuni UI Controller */
//	public String nextProiect(){
//		Integer idx = this.proiecte.indexOf(this.proiect) + 1;
//		
//		logger.debug("Next proiect : " + idx + " | " + this.proiecte.size());
//		
//		if (idx > 0 && idx < this.proiecte.size()){
//			this.setProiect(this.proiecte.get(idx));
//			//populareModelActivitati();
//		}
//		return "FormProiecte";
//	}
//	
//	public void nextProiect(ActionEvent evt){
//		nextProiect();
//	}
//
//	public void previousProiect(ActionEvent evt){
//		previousProiect();
//	}
//	
//	public String previousProiect(){
//		Integer idx = this.proiecte.indexOf(this.proiect) - 1;
//		
//		logger.debug("Previous proiect : " + idx + " | " + this.proiecte.size());
//		
//		if (idx >= 0 && idx < this.proiecte.size()){
//			this.setProiect(this.proiecte.get(idx));
//			//populareModelActivitati();
//		}
//		
//		return "FormProiecte";
//		
//	}	
//	
//	public void setActivitateCurenta(ValueChangeEvent evt){
//		if (this.activitati.getRowData() != null)
//			logger.debug("setActivitateCurenta:: " + this.activitati.getRowData().getTitulatura());
//		this.activitate = this.activitati.getRowData();
//	}
//	
//	/* Actiuni tranzactionale*/
//	public String adaugareProiect(){
//		
//		this.proiect = new Proiect();
//		this.proiecte.add(this.proiect);
//		
//		return "FormProiecte";
//	}
//	
//	public boolean getDisableNext(){
//		if (this.proiecte.indexOf(this.proiect) == this.proiecte.size() - 1){
//			logger.debug("Disable Next");
//			return true;
//		}
//		System.out.println("Enable Next");
//		return false;
//		
//	}
//	
//	public String salvareProiect() throws Exception{
//		logger.debug("LOGGER Salvare proiect: " + this.proiect.getNume() + "::" + this.proiect.getValoareBugetata());
//		this.proiecte.remove(this.proiect);
//		this.proiect = promanInstance.salvareProiect(this.proiect);
//		this.proiecte.add(this.proiect);
//		return "FormProiecte";
//	}
//	
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
		//logger.debug("PostConstruct FORM CONTURI local-ctb: ..." + this.contabInstance);

		this.planConturi = (List<Cont>) contabInstance.getPlanConturi();
		if (!planConturi.isEmpty())
			this.cont = planConturi.get(0);
		else{
			System.out.println("No project available!");
			this.cont = new Cont();
			cont.setDenCont("Cont nou...");
		}
		
	}
//	
//	
//	/* Strategia 2: Folosind AppEJB Provider - partajare injectie EJB */
//	public FormProiecte() throws Exception{
////		//InitialContext ctx = initJBossJNDICtx(); promanInstance = (ProjectManagementSrv)ctx.lookup("ProjectManagementSrv");
////		promanInstance = AppEJBProvider.getProjectManagementSrv();
////		
////		logger.debug("initTest for JSF " + promanInstance);
////
////		proiecte = promanInstance.getProiecte();
////		if (!proiecte.isEmpty())
////			this.proiect = proiecte.get(0);
////		else{
////			System.out.println("No project available!");
////			this.proiect = new Proiect();
////			proiect.setNume("Def pro ...");
////		}
////		System.out.println("Initial FORM PROIECTE app-proman: ..." + AppEJBProvider.getProjectManagementSrv());
//	}
//	public void validate(FacesContext arg0, UIComponent uiComponent, Object uiValue)
//			throws ValidatorException {
//		if ("nume".equals(uiComponent.getId())){
//			System.out.println("Validare nume client");
//			String nume = uiValue.toString();
//			FacesMessage mesaj = null;
//			if (nume == null || nume.isEmpty()){
//				mesaj = new FacesMessage("Numele proiectului trebuie completat!");
//			}
//			System.out.println("Nume: " + nume + ": " + nume.substring(0, 1));
//			if (!nume.substring(0,1).equals(nume.substring(0, 1).toUpperCase())){
//				mesaj = new FacesMessage("Numele proiectului trebuie scris cu majuscula!");
//				logger.debug("Validate - numeproiect: " +  this.proiect.getNume());
//			}
//			
//			if (mesaj != null){
//				throw new ValidatorException(mesaj);
//			}
//		}
//		
//	}
//
//	/* Faces Logic - procesare erori business*/
//	private void ridicaEroare(String mesaj, Boolean anulareTranzactie){
//		// Cocepere mesaj
//		FacesMessage facesMsg = 
//	            new FacesMessage(FacesMessage.SEVERITY_ERROR, "EROARE SALVARE: " + mesaj, null);			
//		FacesContext fc = FacesContext.getCurrentInstance();
//		
//		// Afisare mesaj
//		fc.addMessage(null, facesMsg);
//		fc.renderResponse();
//		
//	}
}
