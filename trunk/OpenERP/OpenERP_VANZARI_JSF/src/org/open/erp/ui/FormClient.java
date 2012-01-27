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
import org.open.erp.services.vanzati.VanzariSrv;
import org.open.erp.services.vanzari.Client;


@ManagedBean(name="formclient")
@SessionScoped
public class FormClient implements Converter{

	
private static Logger logger = Logger.getLogger(FormClient.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(name="VanzariSrv", mappedName="VanzariSrv")
	private VanzariSrv vanzariInstance;
	
	/* Data Model */
	private List<Client> clienti = new ArrayList<Client>();
	private Client client;
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client c) {
		logger.debug("Changed proiect : " + c.getIdClient() + " :: " + p.getAdresa());
		this.client = c;
		//populareModelActivitati();
	}
	
	
	
	public Map<String, Client> getClienti(){
		logger.debug("getClienti : " + this.clienti.size());
		Map<String, Clienti> mapClienti = new HashMap<String, Client>();
		for (Client c: this.clienti)
			mapClienti.put(c.getAdresa(), c);
		return mapClienti;
	}
	
	

	
	
	
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboClienti")){
		
			Integer idClient = new Integer(uival);
			Client c = new Client();
			c.setId(idClient);
			Integer idx = this.clienti.indexOf(c);
			return this.clienti.get(idx);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if (uicomp.getId().equals("cboClienti")){
			
			return ((Client)uival).getId().toString();
		}
		return null;
	}
	
	
	/* Actiuni UI Controller */
	public String nextClient(){
		Integer idx = this.clienti.indexOf(this.client) + 1;
		
		logger.debug("Next client : " + idx + " | " + this.clienti.size());
		
		if (idx > 0 && idx < this.clienti.size()){
			this.setClient(this.client.get(idx));
			//populareModelActivitati();
		}
		return "Formclient";
	}
	
	public void nextClient(ActionEvent evt){
		nextClient();
	}

	public void previousClient(ActionEvent evt){
		previousClient();
	}
	
	public String previousClient(){
		Integer idx = this.clienti.indexOf(this.client) - 1;
		
		logger.debug("Previous client : " + idx + " | " + this.clienti.size());
		
		if (idx >= 0 && idx < this.clienti.size()){
			this.setClient(this.clienti.get(idx));
			//populareModelActivitati();
		}
		
		return "FormClient";
		
	}	
	

	/* Actiuni tranzactionale*/
	public String adaugareClient(){
		
		this.client = new Client();
		this.clienti.add(this.client);
		
		return "Formclient";
	}
	
	public boolean getDisableNext(){
		if (this.clienti.indexOf(this.client) == this.clienti.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		System.out.println("Enable Next");
		return false;
		
	}
	
	public String salvareclient() throws Exception{
		logger.debug("LOGGER Salvare client: " + this.client.getAdresa() + "::" + this.client.getId());
		this.clienti.remove(this.client);
		this.client = vanzariInstance.addclient(client);
		this.clienti.add(this.client);
		return "Formclient";
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
		logger.debug("PostConstruct FORM PROIECTE local-proman: ..." + this.vanzariInstance);

		this.clienti = (List<Client>) vanzariInstance.getclient();
		if (!clienti.isEmpty())
			this.client = clienti.get(0);
		else{
			System.out.println("No client available!");
			this.client = new client();
			client.setAdresa("Adresa....");
		}
		
	}
	
	
	
	public void validate(FacesContext arg0, UIComponent uiComponent, Object uiValue)
			throws ValidatorException {
		if ("id".equals(uiComponent.getId())){
			System.out.println("Validare id client");
			String idClient = uiValue.toString();
			FacesMessage mesaj = null;
			if (idClient == null || id.isEmpty()){
				mesaj = new FacesMessage("Idul clientii trebuie completat!");
			}
			System.out.println("Id: " + idClient + ": " + idClient.substring(0, 1));
			
			
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
