package org.open.erp.services.personal;

import java.io.Serializable;



public class Concedii implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  Integer  		nrInregistrare;
	
	private	 ContractMunca 	contract;
	private  Integer    	perioadaConcediu;
	private  String   		tipConcediu;
	
	
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
	
	
	public Concedii(Integer nrInregistrare, ContractMunca contract,
			Integer perioadaConcediu, String tipConcediu) {
		super();
		this.nrInregistrare = nrInregistrare;
		this.contract = contract;
		this.perioadaConcediu = perioadaConcediu;
		this.tipConcediu = tipConcediu;
		
	}
	public Concedii() {
		super();
	}
	
	

}
