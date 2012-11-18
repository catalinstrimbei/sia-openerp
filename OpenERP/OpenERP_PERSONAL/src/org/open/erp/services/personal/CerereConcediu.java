package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Date;



public class CerereConcediu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  Integer  		nrInregistrare;
	
	private	 ContractMunca 	contract;
	
	private  Date       	dataCerere;
	
	private  Date       	dataAprobare;
	private  Integer    	perioadaConcediu;
	private  String   		tipConcediu;
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
	public Integer getPerioadaConcediu() {
		return perioadaConcediu;
	}
	public void setPerioadaConcediu(Integer perioadaConcediu) {
		this.perioadaConcediu = perioadaConcediu;
	}
	
	public String gettipConcediu() {
		return tipConcediu;
	}
	public void settipConcediu(String tipConcediu) {
		this.tipConcediu = tipConcediu;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CerereConcediu(Integer nrInregistrare, ContractMunca contract,
			Date dataCerere, Date dataAprobare, Integer perioadaConcediu, String tipConcediu,
			String status) {
		super();
		this.nrInregistrare = nrInregistrare;
		this.contract = contract;
		this.dataCerere = dataCerere;
		this.dataAprobare = dataAprobare;
		this.perioadaConcediu = perioadaConcediu;
		this.tipConcediu = tipConcediu;
		this.status = status;
	}
	public CerereConcediu() {
		super();
	}
	
	

}
