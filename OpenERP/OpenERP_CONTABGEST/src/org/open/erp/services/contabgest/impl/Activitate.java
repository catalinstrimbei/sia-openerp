package org.open.erp.services.contabgest.impl;

import java.util.Date;

import org.open.erp.services.contabgest.Persoana;

public class Activitate {

	
	private String status;			//status NeInceputa InCurs InAsteptare 	Terminata
	private double bugetActual;
	private double costEstimat;
	private int idActivitate;
	private String denumire;
	private double costActivitate;
	private Date dataIncepere;
	private Date dataSfarsit;
	private Produs produs;
	private Persoana responsabil;

	public Activitate(int id,String denumire,double costA,Date d1,Date d2,Produs produs,String status,double BugetAlocat)
	{
		this.idActivitate=id;
		this.denumire=denumire;
		this.costActivitate=costA;
		this.dataIncepere=d1;
		this.dataSfarsit=d2;
		this.produs=produs;
		this.status=status;
		this.bugetActual=BugetAlocat;
	}
	public double getCostActivitate() {
		return costActivitate;
	}
	public void setCostActivitate(double costActivitate) {
		this.costActivitate = costActivitate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getCostEstimat() {
		return costEstimat;
	}
	public void setCostEstimat(double costEstimat) {
		this.costEstimat = costEstimat;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public int getIdActivitate() {
		return idActivitate;
	}
	public void setIdActivitate(int idActivitate) {
		this.idActivitate = idActivitate;
	}
	
	public double calculCostActivitate() //returneaza costul produsului pe activitate
	{
	
		return costActivitate;
		
	}
	public Date getDataSfarsit() {
		return dataSfarsit;
	}
	public void setDataSfarsit(Date dataSfarsit) {
		this.dataSfarsit = dataSfarsit;
	}
	public Date getDataIncepere() {
		return dataIncepere;
	}
	public void setDataIncepere(Date dataIncepere) {
		this.dataIncepere = dataIncepere;
	}
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public double getBugetActual() {
		return bugetActual;
	}
	public void setBugetActual(double bugetActual) {
		this.bugetActual = bugetActual;
	}
	public Persoana getResponsabil() {
		return responsabil;
	}
	public void setResponsabil(Persoana responsabil) {
		this.responsabil = responsabil;
	}

}
