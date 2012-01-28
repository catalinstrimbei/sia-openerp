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
import org.open.erp.services.achizitii.Categorie;
import org.open.erp.services.achizitii.impl.AprovizionareImpl;

@ManagedBean(name="formCategorie")
@SessionScoped
public class FormCategorie implements Converter{

	private static Logger logger = Logger.getLogger(FormCategorie.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(name="AprovizionareSrv", mappedName="AprovizionareSrv")
	private AprovizionareImpl achizitiiInstance;
	
	/* Data Model */
	private List<Categorie> categorii = new ArrayList<Categorie>();
	private Categorie categorie;
	
	public Categorie getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Categorie categorie) {
		logger.debug("Changed categorie : " + categorie.getId_cat() + " :: " + categorie.getDenumire());
		this.categorie = categorie;
		//populareModelActivitati();
	}
	
	/* Actiuni UI Controller */
	public String nextCategorie(){
		Integer idx = this.categorii.indexOf(this.categorie) + 1;
		
		logger.debug("Next categorie : " + idx + " | " + this.categorii.size());
		
		if (idx > 0 && idx < this.categorii.size()){
			this.setCategorie(this.categorii.get(idx));
			//populareModelActivitati();
		}
		return "FormCategorie";
	}
	
	public void nextCategorie(ActionEvent evt){
		nextCategorie();
	}
	
	public void previousCategorie(ActionEvent evt){
		previousCategorie();
	}
	
	public String previousCategorie(){
		Integer idx = this.categorii.indexOf(this.categorie) - 1;
		
		logger.debug("Previous categorie : " + idx + " | " + this.categorii.size());
		
		if (idx >= 0 && idx < this.categorii.size()){
			this.setCategorie(this.categorii.get(idx));
			//populareModelActivitati();
		}
		
		return "FormCategorie";
		
	}
	
	/* Actiuni tranzactionale*/
	public String adaugareCategorie(){
		
		this.categorie = new Categorie();
		this.categorii.add(this.categorie);
		
		return "FormCategorie";
	}
	
	public boolean getDisableNext(){
		if (this.categorii.indexOf(this.categorie) == this.categorii.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		System.out.println("Enable Next");
		return false;
		
	}
	
	public String salvareCategorie() throws Exception{
		logger.debug("LOGGER Salvare categorie: " + this.categorie.getDenumire() );
		this.categorii.remove(this.categorie);
		this.categorie = achizitiiInstance.registru.salveazaCategorie(this.categorie);
		this.categorii.add(this.categorie);
		return "FormCategorie";
	}
	
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
		logger.debug("PostConstruct FORM Categorie local-achizitii: ..." + this.achizitiiInstance);

		this.categorii = (List<Categorie>) achizitiiInstance.registru.getListaCategorii();
		if (!categorii.isEmpty())
			this.categorie = categorii.get(0);
		else{
			System.out.println("No category available!");
			this.categorie = new Categorie();
			categorie.setDenumire("Def cat ...");
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
