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
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
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
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FluxProductie;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.impl.RegistruProductie;



@ManagedBean(name="formFluxFaze")
@SessionScoped
public class FormFluxFaze implements Converter{
	/* Resurse test*/
	private static Logger logger = Logger.getLogger(FormFluxFaze.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(name="ProductieSrv", mappedName="ProductieSrv")
	private ProductieSrv productieInstance;
	private RegistruProductie regProd;
	
	@EJB(name="NomenclatoareSrv", mappedName="NomenclatoareSrv")
	private NomenclatoareSrv nomenclatoareInstance;
	/* Data Model */
	private List<FluxProductie> fluxuri = new ArrayList<FluxProductie>();
	private FluxProductie flux;
	
	public FluxProductie getFlux() {
		return flux;
	}

	public void setFlux(FluxProductie flux) {
		logger.debug("Changed flux : " + flux.getIdFlux());
		this.flux = flux;
		populareModelFaze(faze);
	}
	
	public Map<String, FluxProductie> getFluxuri(){
		logger.debug("getFluxuri : " + this.fluxuri.size());
		Map<String, FluxProductie> mapFluxuri = new HashMap<String, FluxProductie>();
		for (FluxProductie f: this.fluxuri)
			mapFluxuri.put(f.getIdFlux().toString(), f);
		return mapFluxuri;
	}
	//DataModel???
	//private DataModel<FazaProductie> faze;
	private List<FazaProductie> faze = new ArrayList<FazaProductie>();
	private FazaProductie faza;

	private List<Produs> produse = new ArrayList<Produs>();
	
	public FazaProductie getFaza() {
		
		logger.debug("get id: " + ((faza!=null)? faza.getFaza() : "null") );
		return faza;
	}

	public List<FazaProductie> getFaze() {
		logger.debug("Check model faze ... ");
		if (this.faze == null)
			populareModelFaze(faze);
		return faze;
	}
	
	private void populareModelFaze(List<FazaProductie> fz){
		this.faze=fz;
	}

	/* Logica Convertor*/
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboFluxuri")){
			Integer idFlux = new Integer(uival);
			FluxProductie p = new FluxProductie();
			p.setIdFlux(idFlux);
			Integer idx = this.fluxuri.indexOf(p);
			return this.fluxuri.get(idx);
		}
		
		if (uicomp.getId().equals("txtIdFlux")){
			FluxProductie uiFluxTemplate = new FluxProductie(Integer.valueOf(uival), flux.getProdus());
			int idx = this.fluxuri.indexOf(uiFluxTemplate);
			
			return this.fluxuri.get(idx); 
		}
		
		if (uicomp.getId().equals("cboProdus")){
			Produs uiProdusTemplate = new Produs();
			uiProdusTemplate.setIdMaterial(Integer.valueOf(uival));
			Integer idx = this.produse.indexOf(uiProdusTemplate);
			
			return this.produse.get(idx);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboFluxuri")){
			// Proiect - to - StringId
			return ((FluxProductie)uival).getIdFlux().toString();
		}
		if (uicomp.getId().equals("txtIdFlux")){
			
			FluxProductie uiFlux = (FluxProductie)uival;
			if (uiFlux.getIdFlux()!=null) //poate veni null din click Add
				return uiFlux.getIdFlux().toString();
		}		
		if (uicomp.getId().equals("cboProdus")){
			if (uival != null){
				Produs uiProdus = (Produs)uival;
				return uiProdus.getIdMaterial().toString();
			}	
		}
		return null;
	}		
	
	/* Actiuni UI Controller */
	public String nextFlux(){
		Integer idx = this.fluxuri.indexOf(this.flux) + 1;
		
		logger.debug("Next flux : " + idx + " | " + this.fluxuri.size());
		
		if (idx > 0 && idx < this.fluxuri.size()){
			this.setFlux(this.fluxuri.get(idx));
			//populareModelActivitati();
		}
		return "FormFluxFaze";
	}
	
	public void nextFlux(ActionEvent evt){
		nextFlux();
	}

	public void previousFlux(ActionEvent evt){
		previousFlux();
	}
	
	public String previousFlux(){
		Integer idx = this.fluxuri.indexOf(this.flux) - 1;
		
		logger.debug("Previous flux : " + idx + " | " + this.fluxuri.size());
		
		if (idx >= 0 && idx < this.fluxuri.size()){
			this.setFlux(this.fluxuri.get(idx));
		
		}
		
		return "FormFluxFaze";
		
	}	
	
	
	
	/* Actiuni tranzactionale*/
	public String adaugareFlux(){
		
		this.flux = new FluxProductie();
		this.fluxuri.add(this.flux);
		
		return "FormFluxFaze";
	}
	
	public boolean getDisableNext(){
		if (this.fluxuri.indexOf(this.flux) == this.fluxuri.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		System.out.println("Enable Next");
		return false;
		
	}
	
	public String salvareFlux() throws Exception{
		
		this.fluxuri.remove(this.flux);
		this.flux = regProd.salveazaFlux(this.flux);
		return "FormFluxFaze";
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
		logger.debug("PostConstruct FORM Fluxuri: ..." + this.productieInstance);

		this.fluxuri = productieInstance.getListaFluxuri();
		if (!fluxuri.isEmpty())
			this.flux = fluxuri.get(0);
		else{
			System.out.println("No flux available!");
			this.flux = new FluxProductie();
			
		}
		
	}
	
	
	/* Strategia 2: Folosind AppEJB Provider - partajare injectie EJB */
	public FormFluxFaze() throws Exception{
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
				mesaj = new FacesMessage("Numele fluxului trebuie completat!");
			}
			
			if (mesaj != null){
				throw new ValidatorException(mesaj);
			}
		}
		
	}

	/* Faces Logic - procesare erori business*/
	private void ridicaEroare(String mesaj, Boolean anulareTranzactie){
		// Concepere mesaj
		FacesMessage facesMsg = 
	            new FacesMessage(FacesMessage.SEVERITY_ERROR, "EROARE SALVARE: " + mesaj, null);			
		FacesContext fc = FacesContext.getCurrentInstance();
		
		// Afisare mesaj
		fc.addMessage(null, facesMsg);
		fc.renderResponse();
		
	}
	
}
