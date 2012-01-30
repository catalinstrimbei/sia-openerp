package org.open.erp.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.open.erp.services.achizitii.AprovizionareSrvLocal;
import org.open.erp.services.achizitii.Categorie;
import org.open.erp.services.achizitii.PlanAprovizionare;

@ManagedBean(name="formCategorie")
@SessionScoped
public class FormPlanAprovizionare implements Converter{

	private static Logger logger = Logger.getLogger(FormPlanAprovizionare.class.getPackage().getName());
	
	 //Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss 
	@EJB(name="AprovizionareSrv", mappedName="AprovizionareSrv/local")
	private AprovizionareSrvLocal achizitiiInstance;
	///
	 //Data Model 
	private List<PlanAprovizionare> planuri = new ArrayList<PlanAprovizionare>();
	private PlanAprovizionare plan;
	
	public PlanAprovizionare getPlanAprovizionare() {
		return plan;
	}
	
	public void setPlanAprovizionare(PlanAprovizionare plan) {
		logger.debug("Changed categorie : " + plan.getIdPlanAprovizionare() + " :: " + plan.getStatusPlan());
		this.plan = plan;
		//populareModelActivitati();
	}
	
	 //Actiuni UI Controller 
	public String nextPlan(){
		Integer idx = this.planuri.indexOf(this.plan) + 1;
		
		logger.debug("Next plan : " + idx + " | " + this.planuri.size());
		
		if (idx > 0 && idx < this.planuri.size()){
			this.setPlanAprovizionare(this.planuri.get(idx));
			//populareModelActivitati();
		}
		return "FormPlanAprovizionare";
	}
	
	public void nextPlan(ActionEvent evt){
		nextPlan();
	}
	
	public void previousPlan(ActionEvent evt){
		previousPlan();
	}
	
	public String previousPlan(){
		Integer idx = this.planuri.indexOf(this.plan) - 1;
		
		logger.debug("Previous categorie : " + idx + " | " + this.planuri.size());
		
		if (idx >= 0 && idx < this.planuri.size()){
			this.setPlanAprovizionare(this.planuri.get(idx));
			//populareModelActivitati();
		}
		
		return "FormPlanAprovizionare";
		
	}
	
	// Actiuni tranzactionale
	public String adaugarePlan(){
		
		this.plan = new PlanAprovizionare();
		this.planuri.add(this.plan);
		
		return "FormPlanAprovizionare";
	}
	
	public boolean getDisableNext(){
		if (this.planuri.indexOf(this.plan) == this.planuri.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		System.out.println("Enable Next");
		return false;
		
	}
	
	public String salvarePlan() throws Exception{
		logger.debug("LOGGER Salvare Plan: " + this.plan.getIdPlanAprovizionare() );
		this.planuri.remove(this.plan);
		this.plan = achizitiiInstance.salveazaPlanAprovizionare(this.plan);
		this.planuri.add(this.plan);
		return "FormPlanAprovizionare";
	}
	
	private static InitialContext initJBossJNDICtx() throws Exception{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}
	
 //Initializare formularului	
	
	//Strategia 1: Injectare privata EJB - referinta EJB nepartajata 
	@PostConstruct // Referinta EJB injectata este disponibila numai abua in handlerul PostConstruct, si nu la nivelul constructorului
	private void initForm() throws Exception{
		logger.debug("PostConstruct FORM Categorie local-achizitii: ..." + this.achizitiiInstance);

		this.planuri = (List<PlanAprovizionare>) achizitiiInstance.getListaPlanAprovizionare();
		if (!planuri.isEmpty())
			this.plan = planuri.get(0);
		else{
			System.out.println("No category available!");
			this.plan = new PlanAprovizionare();
			plan.setIdPlanAprovizionare(0);
		}
		
	}
	
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
