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
import org.open.erp.services.achizitii.Furnizor;

@ManagedBean(name="formFurnizor")
@SessionScoped
public class FormFurnizor implements Converter{

	private static Logger logger = Logger.getLogger(FormFurnizor.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(name="AprovizionareSrv/local", mappedName="AprovizionareSrv/local")
	private AprovizionareSrvLocal achizitiiInstance;
	
	/* Data Model */
	private List<Furnizor> furnizori = new ArrayList<Furnizor>();
	private Furnizor furnizor;
	
	public Furnizor getFurnizor() {
		return furnizor;
	}
	
	public void setFurnizor(Furnizor furnizor) {
		logger.debug("Changed furnizor : " + furnizor.getIdFurnizor() + " :: " + furnizor.getDenumire());
		this.furnizor = furnizor;
		
	}
	
	/* Actiuni UI Controller */
	public String nextFurnizor(){
		Integer idx = this.furnizori.indexOf(this.furnizor) + 1;
		
		logger.debug("Next furnizor : " + idx + " | " + this.furnizori.size());
		
		if (idx > 0 && idx < this.furnizori.size()){
			this.setFurnizor(this.furnizori.get(idx));
		}
		return "FormFurnizor";
	}
	
	public void nextFurnizor(ActionEvent evt){
		nextFurnizor();
	}
	
	public void previousFurnizor(ActionEvent evt){
		previousFurnizor();
	}
	
	public String previousFurnizor(){
		Integer idx = this.furnizori.indexOf(this.furnizor) - 1;
		
		logger.debug("Previous furnizor : " + idx + " | " + this.furnizori.size());
		
		if (idx >= 0 && idx < this.furnizori.size()){
			this.setFurnizor(this.furnizori.get(idx));
		}
		
		return "FormFurnizor";
		
	}
	
	/* Actiuni tranzactionale*/
	public String adaugareFurnizor(){
		
		this.furnizor = new Furnizor();
		this.furnizori.add(this.furnizor);
		
		return "FormFurnizor";
	}
	
	public boolean getDisableNext(){
		if (this.furnizori.indexOf(this.furnizor) == this.furnizori.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		System.out.println("Enable Next");
		return false;
		
	}
	
	public String salvareFurnizor() throws Exception{
		logger.debug("LOGGER Salvare furnizor: " + this.furnizor.getDenumire() );
		this.furnizori.remove(this.furnizor);
		this.furnizor = achizitiiInstance.salveazaFurnizor(this.furnizor);
		this.furnizori.add(this.furnizor);
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
		logger.debug("PostConstruct FORM Furnizor local-achizitii: ..." + this.achizitiiInstance);

		this.furnizori =  (List<Furnizor>) achizitiiInstance.getListaFurnizor();
		if (!furnizori.isEmpty())
			this.furnizor = furnizori.get(0);
		else{
			System.out.println("No category available!");
			this.furnizor = new Furnizor();
			furnizor.setDenumire("Def cat ...");
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
