package org.app.forms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.event.ActionEvent;

import org.app.entities.Client;
import org.app.entities.Comanda;
import org.app.entities.EMF;
import org.app.entities.Produs;

import com.sun.org.apache.xml.internal.security.Init;

@ManagedBean
@SessionScoped
public class FormComenzi implements Serializable, Converter {
	private static final long serialVersionUID = 5607669850754251085l;

	// Master entities
	private List<Client> clienti = new ArrayList<>();
	private Client client = new Client("000", "Def Client","", "", "", "", "", "", "", "");
	private List<Produs> produse = new ArrayList<Produs>();
	
	// Child entities
	private List<Comanda> comenzi = new ArrayList<>();
	private Comanda comanda = new Comanda(9999l, "", this.client);
	
	public List<Comanda> getComenziList() {
		return comenzi;
	}

	public Map<String, Comanda> getComenzi() {
		Map<String, Comanda> comenziMap = new HashMap<String, Comanda>();
		for (Comanda c : this.comenzi)
			comenziMap.put(c.getId().toString(), c);
		return comenziMap;
	}

	public Comanda getComanda() {
		if (comanda.getClient() == null)
			this.comanda.setClient(this.client);
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public List<Produs> getProduseList() {
		return produse;
	}

	public Map<String, Produs> getProduse() {
		Map<String, Produs> produseMap = new HashMap<String, Produs>();
		for (Produs c : this.produse)
			produseMap.put(c.getDenumire().toString(), c);
		return produseMap;
	}

	public FormComenzi() {
		// em = EMF.get().createEntityManager();

		init();
	}

	private void init() {
		// init master entities
		clienti = new ArrayList(EMF.getEntityManager().createQuery("SELECT o FROM Client o").getResultList());
		if (!clienti.isEmpty()){
			client = clienti.get(0);
		}else{
			clienti.add(client);
		}	
		
		// init child entities
		comenzi = new ArrayList(EMF.getEntityManager()
				.createQuery("SELECT o FROM Comanda o").getResultList());
		if (!comenzi.isEmpty()) {
			comanda = comenzi.get(0);
		} else {
			comanda.setClient(this.clienti.get(0));
			comenzi.add(comanda);
		}
		
	
	}

	private void PreviousComanda(ActionEvent evt) {
		Integer idxCurrent = this.comenzi.indexOf(this.comanda);
		if (idxCurrent - 1 >= 0)
			this.comanda = this.comenzi.get(idxCurrent - 1);
	}

	private void NextComanda(ActionEvent evt) {
		Integer idxCurrent = this.comenzi.indexOf(this.comanda);
		if (idxCurrent + 1 < this.comenzi.size())
			this.comanda = this.comenzi.get(idxCurrent + 1);
	}

	public void adaugareComanda(ActionEvent evt) {
		this.comanda = new Comanda(9999l, "", this.client);
		this.comenzi.add(this.comanda);
	}

	public void stergereComanda(ActionEvent evt) {
		this.comenzi.remove(this.comanda);
		if (EMF.getEntityManager().contains(this.comanda)) {
			EMF.getEntityManager().getTransaction().begin();
			EMF.getEntityManager().remove(this.comanda);
			EMF.getEntityManager().getTransaction().commit();
		}

		if (this.comenzi.size() > 0)
			this.comanda = this.comenzi.get(0);
		else
			this.comanda = null;
	}

	public void salvareComanda(ActionEvent evt) {
		System.out.println("Salvare");
		try {
			EMF.getEntityManager().getTransaction().begin();
			EMF.getEntityManager().merge(this.client);
			EMF.getEntityManager().merge(this.comanda);
			EMF.getEntityManager().getTransaction().commit();
			System.out.println("Success Salvare comanda: "
					+ EMF.getEntityManager().contains(this.comanda));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void abandonComanda(ActionEvent evt) {
		System.out.println("Abandon comanda !");
		init();
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComponent,
			String uiValue) throws ConverterException {

		if (uiComponent.getId().equals("cboComenzi")) {
			Comanda comandaSablon = new Comanda(Long.valueOf(uiValue), null, null);
			return this.comenzi.get(this.comenzi.indexOf(comandaSablon));
		}
		if (uiComponent.getId().equals("cboProduse")) {
			Produs produsSablon = new Produs();
			produsSablon.setCod(Integer.valueOf(uiValue));
			return this.produse.get(this.produse.indexOf(produsSablon));
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComponent,
			Object modelObject) throws ConverterException {
		if (uiComponent.getId().equals("cboComenzi")) {
			return ((Comanda) modelObject).getId().toString();
		}
		if (uiComponent.getId().equals("cboProduse")) {
			return ((Produs) modelObject).getCod().toString();
		}
		return null;
	}
}

/*

    <persistence-unit name="transactions-optional">
        <provider>org.datanucleus.api.jpa.PersistenceProviderImpl</provider>
        <properties>
            <property name="datanucleus.NontransactionalRead" value="true"/>
            <property name="datanucleus.NontransactionalWrite" value="true"/>
            <property name="datanucleus.generateSchema.mode" value="drop-and-create"/>
            <property name="datanucleus.ConnectionURL" value="appengine"/>
        </properties>
    </persistence-unit>
    
    
    <persistence-unit name="transactions-optional">
        <provider>org.datanucleus.store.appengine.jpa.DatastorePersistenceProvider</provider>
        <properties>
            <property name="datanucleus.NontransactionalRead" value="true"/>
            <property name="datanucleus.NontransactionalWrite" value="true"/>
			<property name="datanucleus.generateSchema.mode" value="drop-and-create"/>            
            <property name="datanucleus.ConnectionURL" value="appengine"/>
        </properties>
    </persistence-unit>        
    
    
<h:dataTable >
				<h:column id="colId">
					<h:inputText id="Id" value="#{LinieComanda.id}" />
					<f:facet name="header"> Numar comanda </f:facet>
				</h:column>

				<h:column id="colProduse">
					<h:selectOneMenu id="cboProduse" value="#{linieComanda.produs}"
						converter="#{formComenzi}">
						<f:selectItems value="#{formComenzi.produs}" />
					</h:selectOneMenu>
					<f:facet name="header">Produs</f:facet>
				</h:column>

				<h:column id="colCantitate">
					<h:inputText id="Id" value="#{LinieComanda.cantitate}" />
					<f:facet name="header"> Cantitate </f:facet>
				</h:column>

				<h:column id="colValoareProdus">
					<h:inputText id="Id" value="#{LinieComanda.id}" />
					<f:facet name="header"> Valoare Produs </f:facet>
				</h:column>
			</h:dataTable>    
			
			
Storage: E:\Professional\Programare_OO\Projects\GAE-wks\ClientiComenziGAE\war\WEB-INF\appengine-generated\local_db.bin

*/