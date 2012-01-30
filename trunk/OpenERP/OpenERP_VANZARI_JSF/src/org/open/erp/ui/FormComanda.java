package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.apache.log4j.Logger;
import org.open.erp.services.vanzari.Comanda;
import org.open.erp.services.vanzari.LinieComanda;
import org.open.erp.services.vanzari.VanzariSrv;

@ManagedBean(name="formComanda")
public class FormComanda implements Converter {

	private static Logger logger = Logger.getLogger(FormComanda.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(name="VanzariSrv/local", mappedName="VanzariSrv/local")
	private VanzariSrv vnzInstance;
	
	/* Data Model */
	private List<Comanda> comenzi = new ArrayList<Comanda>();
	private Comanda comanda;
	
	public Comanda getComanda(){
		return comanda;
	}
	
	public void setComanda(Comanda comanda){
		logger.debug("Alta comanda: " + comanda.getNrComanda() );
		this.comanda = comanda;
	}
	
	public Map<Integer,Comanda> getComenzi(){
		logger.debug("Comenzi:" + this.comenzi.size());
		Map<Integer,Comanda> mapComenzi = new HashMap<Integer,Comanda>();
		for(Comanda c : this.comenzi){
			mapComenzi.put(c.getNrComanda(), c);
		}
		return mapComenzi;
	}
	
	public List<LinieComanda> liniiComanda = new ArrayList<LinieComanda>();
	//public DataModel<LinieComanda> liniiComanda;
	private LinieComanda linieComanda;
	
	public LinieComanda getLinieComanda(){
		logger.debug("Get id: " + ((linieComanda!=null)? linieComanda.getNrLinie() : "null") );
		return linieComanda;
	}
	
	public List<LinieComanda> getLiniiComanda(){
		return liniiComanda;
	}	
	
	public void setLiniiComanda(List<LinieComanda> lc){
		this.liniiComanda = lc;
	}
	
	/* Convertor */
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if(uicomp.getId().equals("cboComenzi")){
			Integer nrComanda = new Integer(uival);
			Comanda c = new Comanda();
			c.setNrComanda(nrComanda);
			Integer idx = this.comenzi.indexOf(c);
			return this.comenzi.get(idx);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if(uicomp.getId().equals("cboComenzi")){
			return ((Comanda)uival).getNrComanda().toString();
		}
		return null;
	}
	
	/* Implementare butoane navigare */
	public void previousComanda(ActionEvent evt){
		Integer idx = this.comenzi.indexOf(this.comenzi) - 1;
		
		logger.debug("Next comanda : " + idx + " | " + this.comenzi.size());
		
		if (idx > 0 && idx < this.comenzi.size()){
			this.setComanda(this.comenzi.get(idx));
			//populareModelActivitati();
		}
		//return "formComanda";
	}

	public boolean getDisablePrev(){
		if (this.comenzi.indexOf(this.comenzi) == 1){
			logger.debug("Disable Previous");
			return true;
		}
		return false;
	}
	
	public void nextComanda(ActionEvent evt){
		Integer idx = this.comenzi.indexOf(this.comenzi) + 1;
		
		logger.debug("Next comanda : " + idx + " | " + this.comenzi.size());
		
		if (idx > 0 && idx < this.comenzi.size()){
			this.setComanda(this.comenzi.get(idx));
			//populareModelActivitati();
		}
		//return "formComanda";
	}
	
	public boolean getDisableNext(){
		if (this.comenzi.indexOf(this.comenzi) == this.comenzi.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		return false;
	}
	
	/* Implementare CRUD */
	

}
