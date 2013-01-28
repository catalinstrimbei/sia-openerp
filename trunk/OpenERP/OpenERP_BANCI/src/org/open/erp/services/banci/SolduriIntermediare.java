package org.open.erp.services.banci;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SolduriIntermediare implements Serializable{
	@Id @GeneratedValue
	private Integer idsoldintermediar;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_operatie;
	
	private Integer tip_operatie; //+1 depunere, -1 retragere
	private Double suma_operatie;
	
	//setter 
	public void setdata_operatie(Date data){
		this.data_operatie = data;
	}
	private void settip_operatie(Integer tip){
		this.tip_operatie = tip;
	}
	private void setsuma_operatie(Double suma){
		this.suma_operatie = suma;
	}
	
	//getter 
	public Date getdata_operatie(){
		return data_operatie;
	}
	private Integer gettip_operatie(){
		return tip_operatie;
	}
	private Double getsuma_operatie(){
		return suma_operatie;
	}
	
	public SolduriIntermediare(){
		super();
	}
	public SolduriIntermediare(Date data_operatie, Integer tip_operatie, Double suma_operatie){
		this.data_operatie = data_operatie;
		this.suma_operatie = suma_operatie;
		this.tip_operatie = tip_operatie;
	}
	public Integer getIdsoldintermediar() {
		return idsoldintermediar;
	}
	public void setIdsoldintermediar(Integer idsoldintermediar) {
		this.idsoldintermediar = idsoldintermediar;
	}
}
