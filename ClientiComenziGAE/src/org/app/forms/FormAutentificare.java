package org.app.forms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.app.entities.Client;
import org.app.entities.Utilizator;
import org.app.entities.EMF;
@ManagedBean
@SessionScoped
public class FormAutentificare implements Serializable, Converter {
	private static final long serialVersionUID = 5607669850754251085l;

	private List<Utilizator> utilizatori = new ArrayList<>();
	private Utilizator utilizator = new Utilizator("", "", "", null);

	public List<Utilizator> getUtilizatori() {
		return utilizatori;
	}

	public void setUtilizatori(List<Utilizator> utilizatori) {
		this.utilizatori = utilizatori;
	}

	public Utilizator getUtilizator() {
		return utilizator;
	}

	public void setUtilizator(Utilizator utilizator) {
		this.utilizator = utilizator;
	}

	public FormAutentificare() {
		initUtilizatori();
	}

	public String autentificareUtilizator() throws Exception {
		System.out.println("Procedura autentificare " + utilizator.getNumeUtilizator());
		String nextForm = "MainForm";
		// verifica daca userAutentificat.parola equals cu
		// this.utilizator.parola
		String message = null;
		for (Utilizator u : utilizatori) {
			System.out.println("Check: " + u.getNumeUtilizator());
			if (u.getNumeUtilizator().equals(utilizator.getNumeUtilizator())){
				if (u.getParola().equals(utilizator.getParola())) 
					return nextForm;
				else{
					System.out.println(u.getParola() + " --- " + utilizator.getParola());
					message = "Parola gresita";
					this.utilizator.setParola(null);
					nextForm = "FormAutentificare";					
				}
			}
		}
		if (message == null){
			message = "Utilizator inexistent";
			nextForm = "FormUtilizatori";
		}
		FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
		return nextForm;
	}
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
			throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

	private void initUtilizatori() {
		// interogheaza em dupa nume utilizator => userAutentificat
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("transactions-optional");
		EntityManager em = emf.createEntityManager();

		List<Utilizator> utilizatoriExistenti = em.createQuery(
				"Select u From Utilizator u").getResultList();
		System.out.println("Lista utilizatori autentificati");
		utilizatori.add(new Utilizator("admin", "Default administrator", null, "123"));
		utilizatori.addAll(utilizatoriExistenti);
	}

}
