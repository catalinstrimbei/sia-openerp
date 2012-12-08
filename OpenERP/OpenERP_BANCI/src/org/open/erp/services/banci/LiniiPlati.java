package org.open.erp.services.banci;

import java.util.Date;

public class LiniiPlati {
	private Date datacurenta;
	private Double sumaplatita;
	private String denumireplata;
	
	//setter
	public void setdatacurenta(Date data){
		this.datacurenta = data;
	}
	public void setsumaplatita(Double suma){
		this.sumaplatita = suma;
	}
	public void setdenumireplata(String nume){
		this.denumireplata = nume;
	}
	 
	//getter
	public Date getdatacurenta(){
		return datacurenta;
	}
	public Double getsumaplatita(){
		return sumaplatita;
	}
	public String getdenumireplata(){
		return denumireplata;
	}
	
	public LiniiPlati(Date datacurenta, Double sumaplatita, String denumireplata){
		this.datacurenta = datacurenta;
		this.denumireplata = denumireplata;
		this.sumaplatita = sumaplatita;
	}
	public LiniiPlati(){
		super();
	}
}
