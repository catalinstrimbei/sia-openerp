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
import org.open.erp.services.achizitii.Comanda;
import org.open.erp.services.achizitii.LinieComanda;

@ManagedBean(name="formComandaLiniiComanda")
@SessionScoped
public class FormComandaLiniiComanda implements Converter{

	private static Logger logger = Logger.getLogger(FormComandaLiniiComanda.class.getPackage().getName());
	
	 //Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss 
	@EJB(name="AprovizionareSrv/local", mappedName="AprovizionareSrv/local")
	private AprovizionareSrvLocal achizitiiInstance;
	
	 //Data Model 
	private List<Comanda> comenzi = new ArrayList<Comanda>();
	private Comanda comanda;
	
	

	
	public Comanda getComanda() {
		return comanda;
	}
	
	public void setComanda(Comanda Comandc) {
		logger.debug("Changed Comanda : " + comanda.getIdComanda());
		this.comanda = comanda;
	}
	
	// Actiuni UI Controller 
	public String nextComanda(){
		Integer idx = this.comenzi.indexOf(this.comanda) + 1;
		
		logger.debug("Next comanda : " + idx + " | " + this.comenzi.size());
		
		if (idx > 0 && idx < this.comenzi.size()){
			this.setComanda(this.comenzi.get(idx));
			//populareModelActivitati();
		}
		return "FormCategorie";
	}
	
	public void nextComanda(ActionEvent evt){
		nextComanda();
	}
	
	public void previousComanda(ActionEvent evt){
		previousComanda();
	}
	
	public String previousComanda(){
		Integer idx = this.comenzi.indexOf(this.comanda) - 1;
		
		logger.debug("Previous comanda : " + idx + " | " + this.comenzi.size());
		
		if (idx >= 0 && idx < this.comenzi.size()){
			this.setComanda(this.comenzi.get(idx));
		}
		
		return "FormComandaLiniiComanda";
		
	}
	
	 //Actiuni tranzactionale
	public String adaugareComanda(){
		
		this.comanda = new Comanda();
		this.comenzi.add(this.comanda);
		
		return "FormComandaLiniiComanda";
	}
	
	public boolean getDisableNext(){
		if (this.comenzi.indexOf(this.comanda) == this.comenzi.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		System.out.println("Enable Next");
		return false;
		
	}
	
	public String salvareComanda() throws Exception{
		logger.debug("LOGGER Salvare comanda: " + this.comanda.getIdComanda() );
		this.comenzi.remove(this.comanda);
		this.comanda = achizitiiInstance.salveazaComanda(this.comanda);
		this.comenzi.add(this.comanda);
		return "FormCategorie";
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
		logger.debug("PostConstruct FORM comenzi local-achizitii: ..." + this.achizitiiInstance);

		this.comenzi = (List<Comanda>) achizitiiInstance.getListaComenzi();
		if (!comenzi.isEmpty())
			this.comanda = comenzi.get(0);
		else{
			System.out.println("No category available!");
			this.comanda = new Comanda();
			comanda.setIdComanda(0);
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
