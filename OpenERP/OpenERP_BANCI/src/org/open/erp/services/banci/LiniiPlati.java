package org.open.erp.services.banci;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class LiniiPlati implements Serializable {
	@Id @GeneratedValue
	private Integer idlinieplata;
	
	@Temporal(TemporalType.TIMESTAMP)
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
	public Integer getIdlinieplata() {
		return idlinieplata;
	}
	public void setIdlinieplata(Integer idlinieplata) {
		this.idlinieplata = idlinieplata;
	}
}
