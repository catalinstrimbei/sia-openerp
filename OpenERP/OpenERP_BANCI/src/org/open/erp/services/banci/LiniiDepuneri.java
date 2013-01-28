package org.open.erp.services.banci;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class LiniiDepuneri implements Serializable {
	@Id @GeneratedValue
	private Integer idliniedepunere;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_curenta;
	
	private Double suma_depusa;
	private String denumire_depunere;
	private Double sold_final;
	
	//setter
	public void setdatacurenta(Date data){
		this.data_curenta = data;
	}
	public void setsumadepusa(Double suma){
		this.suma_depusa = suma;
	}
	public void setdenumiredepunere(String nume){
		this.denumire_depunere = nume;
	}
	public void setsoldfinal(Double suma){
		this.sold_final = suma;
	}
	 
	//getter
	public Date getdatacurenta(){
		return data_curenta;
	}
	public Double getsumaplatita(){
		return suma_depusa;
	}
	public String getdenumireplata(){
		return denumire_depunere;
	}
	public Double getsoldfinal(){
		return sold_final;
	}
	
	public LiniiDepuneri(Date datacurenta, Double sumadepusa, String denumireplata, Double soldfinal){
		this.data_curenta = datacurenta;
		this.denumire_depunere = denumireplata;
		this.suma_depusa = sumadepusa;
		this.sold_final = soldfinal;
	}
	public LiniiDepuneri(){
		super();
	}
	public Integer getIdliniedepunere() {
		return idliniedepunere;
	}
	public void setIdliniedepunere(Integer idliniedepunere) {
		this.idliniedepunere = idliniedepunere;
	}
}
