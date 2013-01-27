package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class CerereEveniment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private  Integer  		nrInregistrare;
	@ManyToOne
	private	 Angajat 	contract;
	
	private  Date       	dataCerere;
	
	private  Date       	dataAprobare;
	private  Date       	dataInceputEveniment;	
	private  Date       	dataSfarsitEveniment;
	private  String   		tipEveniment;
	private  String     	status;
	private int 			sumaEveniment;
	
	public Integer getNrInregistrare() {
		return nrInregistrare;
	}
	public Angajat getContract() {
		return contract;
	}
	public void setContract(Angajat contract) {
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
	
	//@param angajat Angajatul ce a depus cererea
	public CerereEveniment(Integer nrInregistrare, Angajat angajat,
			Date dataCerere, Date dataAprobare, Date dataInceputEveniment, Date dataSfarsitEveniment, String tipEveniment,
			String status, int sumaEveniment) {
		super();
		this.nrInregistrare = nrInregistrare;
		this.contract = contract;
		this.dataCerere = dataCerere;
		this.dataAprobare = dataAprobare;
		this.dataInceputEveniment =dataInceputEveniment;
		this.dataSfarsitEveniment = dataSfarsitEveniment;
		this.tipEveniment = tipEveniment;
		this.status = status;
		this.sumaEveniment= sumaEveniment;
	}
	public CerereEveniment() {
		super();
		dataCerere = new Date();
		dataAprobare = new Date();
		dataInceputEveniment = new Date();
		dataSfarsitEveniment = new Date();
		}
	
	public Date getDataInceputEveniment() {
		return dataInceputEveniment;
	}
	public void setDataInceputEveniment(Date dataInceputEveniment) {
		this.dataInceputEveniment = dataInceputEveniment;
	}
	public Date getDataSfarsitEveniment() {
		return dataSfarsitEveniment;
	}
	public void setDataSfarsitEveniment(Date dataSfarsitEveniment) {
		this.dataSfarsitEveniment = dataSfarsitEveniment;
	}
	public int getSumaEveniment() {
		return sumaEveniment;
	}
	public void setSumaEveniment(int sumaEveniment) {
		this.sumaEveniment = sumaEveniment;
	}
	
	

}
