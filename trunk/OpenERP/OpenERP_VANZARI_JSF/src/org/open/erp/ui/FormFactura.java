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

@ManagedBean(name="FormFactura")
public class FormFactura implements Converter {

	private static Logger logger = Logger.getLogger(FormFactura.class.getPackage().getName());
	
	/* Inject EJB Service: trebuie mentionate ambele atribute name si mappedName epntru JBoss */
	@EJB(name="VanzariSrv/local", mappedName="VanzariSrv/local")
	private VanzariSrv vnzInstance;
	
	/* Data Model */
	private List<Factura> facturi = new ArrayList<Factura>();
	private Factura factura;
	
	public Factura getFactura(){
		return factura;
	}
	
	public void setFactura(Factura factura){
		logger.debug("Alta factura: " + factura.getIdFactura() );
		this.factura = factura;
	}
	
	public Map<Integer,Factura> getFacturi(){
		logger.debug("Facturi:" + this.facturi.size());
		Map<Integer,Factura> mapFacturi = new HashMap<Integer,Factura>();
		for(Factura f : this.facturi){
			mapFacturi.put(f.getIdFactura(), f);
		}
		return mapFacturi;
	}
	
	public List<LinieFacturaEmisa> liniiFacturaEmisa = new ArrayList<LinieFacturaEmisa>();
	//public DataModel<LinieComanda> liniiComanda;
	private LinieFacturaEmisa linieFacturaEmisa;
	
	public linieFacturaEmisa getLinieFacturaEmisa(){
		logger.debug("Get id: " + ((linieFacturaEmisa!=null)? linieFacturaEmisa.getPretLinie() : "null") );
		return liniiFacturaEmisa;
	}
	
	public List<LinieFacturaEmisa> getLiniiFacturaEmisa(){
		return liniiFacturaEmisa;
	}	
	
	public void setLiniiFacturaEmisa(List<LinieFacturaEmisa> lF){
		this.liniiFacturaEmisa = lF;
	}
	
	/* Convertor */
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		logger.debug("getAsObject:uicomp: " + uicomp.getId());
		if(uicomp.getId().equals("cbofACTURA")){
			Integer idFactura = new Integer(uival);
			Factura f = new Factura();
			f.setidFactura(idFactura);
			Integer idx = this.facturi.indexOf(f);
			return this.facturi.get(idx);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		logger.debug("getAsString:uicomp: " + uicomp.getId());
		if(uicomp.getId().equals("cboFactura")){
			return ((Factura)uival).getIdFactura().toString();
		}
		return null;
	}
	
	/* Implementare butoane navigare */
	public void previousFactura(ActionEvent evt){
		Integer idx = this.facturi.indexOf(this.facturi) - 1;
		
		logger.debug("Previous factura : " + idx + " | " + this.facturi.size());
		
		if (idx > 0 && idx < this.facturi.size()){
			this.setFactura(this.facturi.get(idx));
			//populareModelActivitati();
		}
		//return "FormFactura";
	}

	public boolean getDisablePrev(){
		if (this.facturi.indexOf(this.facturi) == 1){
			logger.debug("Disable Previous");
			return true;
		}
		return false;
	}
	
	public void nextFactura(ActionEvent evt){
		Integer idx = this.facturi.indexOf(this.facturi) + 1;
		
		logger.debug("Next factura : " + idx + " | " + this.facturi.size());
		
		if (idx > 0 && idx < this.facturi.size()){
			this.setFactura(this.facturi.get(idx));
			//populareModelActivitati();
		}
		//return "FormFactura";
	}
	
	public boolean getDisableNext(){
		if (this.facturi.indexOf(this.facturi) == this.facturi.size() - 1){
			logger.debug("Disable Next");
			return true;
		}
		return false;
	}
	
	/* Implementare CRUD */
	

}
