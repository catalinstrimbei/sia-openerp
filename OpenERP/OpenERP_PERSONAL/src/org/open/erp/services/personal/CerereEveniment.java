package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Date;



public class CerereEveniment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  Integer  		nrInregistrare;
	
	private	 ContractMunca 	contract;
	
	private  Date       	dataCerere;
	
	private  Date       	dataAprobare;
	private  Integer    	perioadaEveniment;
	private  String   		tipEveniment;
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
	public Date getDataAprobare() {
		return dataAprobare;
	}
	public void setDataAprobare(Date dataAprobare) {
		this.dataAprobare = dataAprobare;
	}
	public Integer getPerioadaEveniment() {
		return perioadaEveniment;
	}
	public void setPerioadaEveniment(Integer perioadaEveniment) {
		this.perioadaEveniment = perioadaEveniment;
	}
	
	public String gettipEveniment() {
		return tipEveniment;
	}
	public void settipEveniment(String tipEveniment) {
		this.tipEveniment = tipEveniment;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CerereEveniment(Integer nrInregistrare, ContractMunca contract,
			Date dataCerere, Date dataAprobare, Integer perioadaEveniment, String tipEveniment,
			String status) {
		super();
		this.nrInregistrare = nrInregistrare;
		this.contract = contract;
		this.dataCerere = dataCerere;
		this.dataAprobare = dataAprobare;
		this.perioadaEveniment = perioadaEveniment;
		this.tipEveniment = tipEveniment;
		this.status = status;
	}
	public CerereEveniment() {
		super();
	}
	
	

}
