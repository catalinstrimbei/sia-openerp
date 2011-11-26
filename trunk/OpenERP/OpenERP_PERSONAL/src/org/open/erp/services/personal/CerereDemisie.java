package org.open.erp.services.personal;

import java.util.Date;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
public class CerereDemisie {
	private  String  		nrInregistrare;
	private	 ContractMunca 	contract;
	private  Date       	dataCerere;
	private  Date       	dataDemisie;
	private  Integer    	perioadaPreaviz;
	private  String     	status;
	
	public String getNrInregistrare() {
		return nrInregistrare;
	}
	public ContractMunca getContract() {
		return contract;
	}
	public void setContract(ContractMunca contract) {
		this.contract = contract;
	}
	public void setNrInregistrare(String nrInregistrare) {
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
	public CerereDemisie(String nrInregistrare, ContractMunca contract,
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
		// TODO Auto-generated constructor stub
	}
	
	

}
