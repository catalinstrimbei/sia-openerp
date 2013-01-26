package org.open.erp.ui.finplati;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.open.erp.services.finplati.FacturaStatus; /* s-ar putea sa nu fie nevoie , ce importuri dau unused le scoti-*/
import org.open.erp.services.finplati.FurnizorContract; /* s-ar putea sa nu fie nevoie , ce importuri dau unused le scoti-*/
import org.open.erp.services.finplati.Persoana;
import org.open.erp.services.finplati.ResponsabilPlata;
//import.org.open.erp.services.finplati.*; /* s-ar putea sa nu fie nevoie ..??? */
import org.open.erp.services.finplati.SituatieFinanciara;
import org.open.erp.services.finplati.FinanciarPlatiSrv;

@ManagedBean(name = "situatieFinanciaraBean")
@javax.faces.bean.RequestScoped

public class SituatieFinanciaraBean implements Serializable{
/*--------------------*/
	@EJB(lookup="java:global/OpenERP_FINPLATI/FinanciarPlatiSrvImpl!org.open.erp.services.finplati.FinanciarPlatiSrv")
	private FinanciarPlatiSrv financiarPlatiSrv;
/*-------------------*/
	
	private Double valoarePlatiRestante;
	private Double bugetDatorii;
//      private Contract contracte;
//	private Personal personal;
//	private Plata plati;
//	private Factura factura;
	private ResponsabilPlata responsabil;

	public SituatieFinanciaraBean(){
	}
	/**------*/
	public FinanciarPlatiSrv getFinanciarPlatiSrv() {
		return financiarPlatiSrv;
	}

	public void setFinanciarPlatiSrv(FinanciarPlatiSrv financiarPlatiSrv) {
		this.financiarPlatiSrv = financiarPlatiSrv;
	}
/*-*--------------------*/
    public Double getValoarePlatiRestante() {
		return valoarePlatiRestante;
	}
	public void setValoarePlatiRestante(Double valoarePlatiRestante) {
		this.valoarePlatiRestante = valoarePlatiRestante;
	}
	public void setBugetDatorii(Double bugetDatorii) {
		this.bugetDatorii = bugetDatorii;
	}
	public Double getBugetDatorii() {
		return this.bugetDatorii;
/*
	}
	public Map<Integer,Contract> getContracte() {
		return contracte;
	}
	public void setContracte(Map<Integer,Contract> contracte) {
		this.contracte = contracte;
	}

	public void setPersonal(Map<Integer,Persoana> personal) {
		this.personal = personal;
	}
	public Map<Integer,Persoana> getPersonal() {
		return this.personal;
	}

	public Map<Integer,Plata> getPlati() {
		return plati;
	}
	public void setPlati(Map<Integer,Plata> plati) {
		this.plati = plati;
	}

	public void setfactura(Map<Integer,FacturaStatus> factura) {
		this.factura = factura;
	}
	public Map<Integer,FacturaStatus> getfactura() {
		return this.factura;

*/
	}
	public ResponsabilPlata getResponsabil() {
		return responsabil;
	}
	public void setResponsabil(Persoana persoana) {
		this.responsabil = new ResponsabilPlata(persoana);
	}
/*-*--------------------------*/
	
	public String adaugaSituatieFinanciara() throws Exception{
		
	SituatieFinanciara situatieFinanciaraNoua = new SituatieFinanciara();
	situatieFinanciaraNoua.setValoarePlatiRestante(valoarePlatiRestante);
//	situatieFinanciaraNoua.setContract(contracte);
//	situatieFinanciaraNoua.setPersonal(personal); /*-----?? sau mai corect persoana? */
//	situatieFinanciaraNoua.setFactura(factura);
	//situatieFinanciaraNoua.setResponsabilPlata(responsabil);
		
	  //.adaugaSituatieFinanciara(situatieFinanciaraNoua);
		
		return "situatieFinanciaraNoua";
	}
	
}
