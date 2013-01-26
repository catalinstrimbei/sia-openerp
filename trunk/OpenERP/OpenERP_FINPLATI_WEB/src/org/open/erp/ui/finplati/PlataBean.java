package org.open.erp.ui.finplati;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.open.erp.services.finplati.ModPlata;
import org.open.erp.services.finplati.Plata;
import org.open.erp.services.finplati.FinanciarPlatiSrv;
import org.open.erp.services.finplati.TipPlata;

@ManagedBean(name = "plataBean")
@javax.faces.bean.RequestScoped
public class PlataBean implements Serializable{

	@EJB(lookup="java:global/OpenERP_FINPLATI/FinanciarPlatiSrvImpl!org.open.erp.services.finplati.FinanciarPlatiSrv")
	private FinanciarPlatiSrv financiarPlatiSrv;
	
	//private int buget; ??
	private Double valoarePlata;
	private Date dataPlata;
	private ModPlata modPlata;
	private TipPlata tipPlata;
	//private Date dataFinal;
	
	public PlataBean(){
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
	
}
