package org.app.forms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.event.ActionEvent;

import org.app.entities.Client;
import org.app.entities.EMF;

/* GAE_JPA_JSF Restrictii:
 * 1. ManagedBean-urile trebuie sa fie serializabile [eroare de ne-seriabilitate]
 * 2. EntityManager este gestionat separat de clasa EMF
 * 3. Rezultatul interogarilor trebuie impachetat intr-un ArrayList explicit [eroare de ne-seriabilitate]
 * 
 * TestURL: http://localhost:8888/faces/FormClienti.xhtml sau http://startmyfaces.appspot.com/faces/FormClienti.xhtml
 * La testul direct de pe GAE tb inceputa OBLIGATORIU o noua sesiune, adica anulata (inchis browserul) cea anterioara.
 */


@ManagedBean
@SessionScoped
public class FormClienti implements Serializable, Converter{
	private static final long serialVersionUID = 5607669850754251085l;
	
	private List<Client> clienti = new ArrayList<>();
	private Client client = new Client("", "","", "", "", "", "", "", "", "");
	
	public List<Client> getClienti() {
		return clienti;
	}
	public void setClienti(List<Client> clienti) {
		this.clienti = clienti;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public FormClienti() {
		//em = EMF.get().createEntityManager();
		
		init();
	}
	
	/* Implementare operatii CRUD */
	public void adaugareClient(ActionEvent evt) {
		this.client = new Client("990", "Client","", "", "", "", "", "", "", "");
		this.clienti.add(this.client);
	}

	public void stergereClient(ActionEvent evt) {
		this.clienti.remove(this.client);
		if (EMF.getEntityManager().contains(this.client)) {
			EMF.getEntityManager().getTransaction().begin();
			EMF.getEntityManager().remove(this.client);
			EMF.getEntityManager().getTransaction().commit();
		}

		if (!this.clienti.isEmpty())
			this.client = this.clienti.get(0);
		else
			this.client = new Client("999", "Client", "", "", "", "", "", "", "", "");
	}

	public void salvareClient(ActionEvent evt) {
		System.out.println("Salvare");
		try{
			EMF.getEntityManager().getTransaction().begin();
			EMF.getEntityManager().merge(this.client);
			EMF.getEntityManager().getTransaction().commit();
			System.out.println("Success Salvare client: " + EMF.getEntityManager().contains(this.client));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void abandonClient(ActionEvent evt) {
		System.out.println("Abandon client !");
		init();
	}	 
	
	private void init(){
		clienti = new ArrayList(EMF.getEntityManager().createQuery("SELECT o FROM Client o").getResultList());
		if (!clienti.isEmpty()){
			client = clienti.get(0);
		}else{
			clienti.add(client);
		}
	}
	
	/*End Implementare CRUD*/
	
	/* Implementare suport pentru navigare-selectie lista combinata */
	public Map<String, Client> getClientiMap() {
		Map<String, Client> mapClienti = new HashMap<String, Client>();
		for (Client c : clienti) {
			mapClienti.put(c.getDenumireClient(), c);
		}
		
		return mapClienti;
	}	
	
	@Override
	// operatie invocata la selectie din lista, dar inainte de setClient
	public Object getAsObject(FacesContext arg0, UIComponent uic, String uiValue)
			throws ConverterException {
		if (uiValue == null)
			return null;
		
		Client uiClientTemplate = new Client(uiValue, null, null, null, null, null, null, null, null, null);
		int idx = this.clienti.indexOf(uiClientTemplate);
		return this.clienti.get(idx);
	}

	@Override
	// operatie invocata la generare elemente pentru lista,
	// dupa getClienti, dar inainte de popularea listei
	public String getAsString(FacesContext arg0, UIComponent uic, Object uiValue)
			throws ConverterException {
		Client uiClient = (Client) uiValue;
		return uiClient.getIdClient().toString();
	}	

}

