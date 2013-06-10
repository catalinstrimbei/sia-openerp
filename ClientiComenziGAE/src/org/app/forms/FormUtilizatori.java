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
import org.app.entities.Utilizator;
import org.app.entities.EMF;



@ManagedBean
@SessionScoped
public class FormUtilizatori implements Serializable, Converter{
	private static final long serialVersionUID = 5607669850754251085l;
	
	private List<Utilizator> utilizatori = new ArrayList<>();
	private Utilizator utilizator = new Utilizator("", "", "", "");
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
	public FormUtilizatori() {
		//em = EMF.get().createEntityManager();
		
		//init();
	}
	public String salvareUtilizator() {
		System.out.println("Salvare");
		try{
			EMF.getEntityManager().getTransaction().begin();
			EMF.getEntityManager().merge(this.utilizator);
			EMF.getEntityManager().getTransaction().commit();
			System.out.println("Success Salvare client: " + EMF.getEntityManager().contains(this.utilizator));
			return "FormAutentificare";
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "FormUtilizatori";
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
}