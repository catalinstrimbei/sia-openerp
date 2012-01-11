package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class CerereDemisie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer  		nrInregistrare;
	@OneToOne @JoinColumn(name = "nrContract")
	private	 ContractMunca 	contract;
	@Temporal(javax.persistence.TemporalType.DATE)
	private  Date       	dataCerere;
	@Temporal(javax.persistence.TemporalType.DATE)
	private  Date       	dataDemisie;
	private  Integer    	perioadaPreaviz;
	private  String     	status;
	
	public Integer getNrInregistrare() {
		return nrInregistrare;
	}
	public ContractMunca getContract() {
		return contract;
	}
	public void setContract(ContractMunca contract) {
		this.contract = contract;
	}
	public void setNrInregistrare(Integer nrInregistrare) {
		this.nrInregistrare = nrInregistrare;
	}
	
	public Date getDataCerere() {
		return dataCerere;
	}
	public void setDataCerere(Date dataCerere) {
		this.dataCerere = dataCerere;
	}
	public Date getDataDemisie() {
		return dataDemisie;
	}
	public void setDataDemisie(Date dataDemisie) {
		this.dataDemisie = dataDemisie;
	}
	public Integer getPerioadaPreaviz() {
		return perioadaPreaviz;
	}
	public void setPerioadaPreaviz(Integer perioadaPreaviz) {
		this.perioadaPreaviz = perioadaPreaviz;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CerereDemisie(Integer nrInregistrare, ContractMunca contract,
			Date dataCerere, Date dataDemisie, Integer perioadaPreaviz,
			String status) {
		super();
		this.nrInregistrare = nrInregistrare;
		this.contract = contract;
		this.dataCerere = dataCerere;
		this.dataDemisie = dataDemisie;
		this.perioadaPreaviz = perioadaPreaviz;
		this.status = status;
	}
	public CerereDemisie() {
		super();
	}
	
	

}
