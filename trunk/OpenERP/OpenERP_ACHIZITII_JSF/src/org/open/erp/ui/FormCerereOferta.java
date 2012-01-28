package org.open.erp.ui;

import java.awt.event.ActionEvent;
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
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.open.erp.services.achizitii.AprovizionareSrv;
import org.open.erp.services.achizitii.CerereOferta;



@ManagedBean(name="FormCerereOferta")
@SessionScoped
public class FormCerereOferta implements Converter{

/*	private static Logger logger = Logger.getLogger(FormCerereOferta.class.getPackage().getName());
*/	private static Logger logger = Logger.getLogger(FormCerereOferta.class.getPackage().getName());

	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(name="AprovizionareSrv", mappedName="AprovizionareSrv")
	private AprovizionareSrv achizitiiInstance;
	
	/* Data Model */
	private List<CerereOferta> cereri = new ArrayList<CerereOferta>();
	private CerereOferta cerereoferta;
	
	public CerereOferta getCerereOferta() {
		return cerereoferta;
	}
	
	public void setCerereOferta(CerereOferta cerereOferta) {
		logger.debug("Changed CerereOferta : " + cerereoferta.getId_CerereOferta());
		this.cerereoferta = cerereoferta;
	}
	
	/* Actiuni UI Controller */
	public String nextCerereOferta(){
		Integer idx = this.cereri.indexOf(this.cerereoferta) + 1;
		
		logger.debug("Next cerereoferta : " + idx + " | " + this.cereri.size());
		
		if (idx > 0 && idx < this.cereri.size()){
			this.setCerereOferta(this.cereri.get(idx));
		}
		return "FormCerereOferta";
	}
	
	public void nextCerereOferta(ActionEvent evt){
		nextCerereOferta();
	}
	
	public void previousCerereOferta(ActionEvent evt){
		previousCerereOferta();
	}
	
	public String previousCerereOferta(){
		Integer idx = this.cereri.indexOf(this.cereri) - 1;
		
		logger.debug("Previous categorie : " + idx + " | " + this.cereri.size());
		
		if (idx >= 0 && idx < this.cereri.size()){
			this.setCerereOferta(this.cereri.get(idx));
			//populareModelActivitati();
		}
		
		return "FormCerereOferta";
		
	}
	
	/* Actiuni tranzactionale*/
	public String setId_CerereOferta(){
		
		this.cerereoferta = new CerereOferta();
		this.cereri.add(this.cerereoferta);
		
		return "FormCerereOferta";
	}
	
	public boolean getDisableNext(){
		if (this.cereri.indexOf(this.cerereoferta) == this.cereri.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		System.out.println("Enable Next");
		return false;
		
	}
	
	public String salvareCerereOferta() throws Exception{
		logger.debug("LOGGER Salvare cerere oferta: " + this.cerereoferta.getId_CerereOferta() );
		this.cereri.remove(this.cerereoferta);
		this.cerereoferta = achizitiiInstance.salveazaCerereOferta(this.cerereoferta);
		this.cereri.add(this.cerereoferta);
		return "FormCerereOferta";
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
		logger.debug("PostConstruct FORM CerereOferta local-achizitii: ..." + this.achizitiiInstance);

		this.cereri = (List<CerereOferta>) achizitiiInstance.getListaCereriOferta();
		if (!cereri.isEmpty())
			this.cerereoferta = cereri.get(0);
		else{
			System.out.println("No category available!");
			this.cerereoferta = new CerereOferta();
			cerereoferta.setId_CerereOferta(0);
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




	