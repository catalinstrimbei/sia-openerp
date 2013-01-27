package org.open.erp.ui.finplati;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.open.erp.services.finplati.ModPlata;
import org.open.erp.services.finplati.Plata;
import org.open.erp.services.finplati.FinanciarPlatiSrv;
import org.open.erp.services.finplati.TipPlata;


@ManagedBean(name = "plataBean")
@javax.faces.bean.RequestScoped
public class PlataBean implements Converter{

	@EJB(lookup="java:global/OpenERP_FINPLATI/FinanciarPlatiImpl!org.open.erp.services.finplati.FinanciarPlatiSrv")
	private FinanciarPlatiSrv financiarPlatiSrv;
	
	private int idPlata;
	private List<String> modPlataList = new ArrayList<String>();
	private List<String> tipPlataList = new ArrayList<String>();
	

	public int getIdPlata() {
		return idPlata;
	}

	public void setIdPlata(int idPlata) {
		this.idPlata = idPlata;
	}

	public Date getDataPlata() {
		return dataPlata;
	}

	public void setDataPlata(Date dataPlata) {
		this.dataPlata = dataPlata;
	}

	private Double valoarePlata;
	private Date dataPlata;
	private ModPlata modPlata;
	private TipPlata tipPlata;
	//private Date dataFinal;
	
	public PlataBean(){
		modPlataList.add(ModPlata.CASH.toValue());
		modPlataList.add(ModPlata.CEC.toValue());
		modPlataList.add(ModPlata.VIRAMENTBANCAR.toValue());
		
		tipPlataList.add(TipPlata.FURNIZOR.toValue());
		tipPlataList.add(TipPlata.DATORIE.toValue());
		tipPlataList.add(TipPlata.ALTTIP.toValue());
	}
	
	public List<String> getTipPlataList() {
		return tipPlataList;
	}

	public void setTipPlataList(List<String> tipPlataList) {
		this.tipPlataList = tipPlataList;
	}

	public List<String> getModPlataList() {
		return modPlataList;
	}

	public void setModPlataList(List<String> modPlataList) {
		this.modPlataList = modPlataList;
	}

	public FinanciarPlatiSrv getFinanciarPlatiSrv() {
		return financiarPlatiSrv;
	}

	public void setFinanciarPlatiSrv(FinanciarPlatiSrv financiarPlatiSrv) {
		this.financiarPlatiSrv = financiarPlatiSrv;
	}
/*---------------------*/
	public Double getValoarePlata() {
		return valoarePlata;
	}
/*	public Integer getId() {
		return idPlata;
	}*/
	public Date getDataPlatii() {
		return dataPlata;
	}
	public TipPlata getTipPlata() {
		return tipPlata;
	}
	public ModPlata getModPlata() {
		return modPlata;
	}
/*	public String getConfirmarePlata() {
		return confirmarePlata;
	}*/
	public void setValoarePlata(Double valoarePlata) {
		this.valoarePlata = valoarePlata;
	}
	/*
	public void setId(Integer idPlata) {
		this.idPlata = idPlata;
	} */
	public void setDataPlatii(Date dataPlata) {
		this.dataPlata = dataPlata;
	}
	public void setTipPlata(TipPlata tipPlata) {
		this.tipPlata = tipPlata;
	}
	public void setModPlata(ModPlata modPlata) {
		this.modPlata = modPlata;
	}
	/*
	public void setConfirmarePlata(String confirmarePlata) {
		this.confirmarePlata = confirmarePlata;
	}*/
	
/*	public int getBuget() {
		return buget;
	}

	public void setBuget(int buget) {
		this.buget = buget;
	}

	public Date getDataStart() {
		return dataStart;
	}

	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
*/
	public String  adaugaPlata() throws Exception{
		
		Plata plataNoua = new Plata();
		plataNoua.setValoarePlata(valoarePlata);
		plataNoua.setDataPlatii(dataPlata);
		plataNoua.setModPlata(modPlata);
		plataNoua.setTipPlata(tipPlata);
	
		
	    financiarPlatiSrv.adaugarePlata(plataNoua);
		
		return "plataNoua";
	}
	
	/* Logica Convertor*/
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uicomp, String uival) {
		if (uicomp.getId().equals("modPlataSel")){
			// StringId - to - modPlata
			for (ModPlata tip : ModPlata.values()) {
				if (uival.equalsIgnoreCase(tip.toString()))
					return tip;
			}
		}
		if (uicomp.getId().equals("tipPlataSel")){
			// StringId - to - modPlata
			for (TipPlata tip : TipPlata.values()) {
				if (uival.equalsIgnoreCase(tip.toString()))
					return tip;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uicomp, Object uival) {
		if (uicomp.getId().equals("modPlataSel")){
			// modPlata - to - StringId
			for (ModPlata tip : ModPlata.values()) {
				if (uival.toString().equalsIgnoreCase(tip.toString()))
					return tip.toValue();
			}
		}
		if (uicomp.getId().equals("tipPlataSel")){
			// tipPlata - to - StringId
			for (TipPlata tip : TipPlata.values()) {
				if (uival.toString().equalsIgnoreCase(tip.toString()))
					return tip.toValue();
			}
		}
		return null;
	}		

	
}
