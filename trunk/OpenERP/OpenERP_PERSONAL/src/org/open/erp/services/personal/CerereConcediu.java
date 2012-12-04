package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Date;



public class CerereConcediu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  Integer  		nrInregistrare;
	
	private	 Angajat 	idAngajat;
	
	private  Date       	dataCerere;	
	private  Date       	dataAprobare;
	private  Date       	dataInceputConcediu;	
	private  Date       	dataSfarsitConcediu;
	private  String   		tipConcediu;
	private  String     	status = "In asteptare";
	
		 
	public Integer getNrInregistrare() {
		return nrInregistrare;
	}
	public Angajat getAngajat() {
		return idAngajat;
	}
	public void setIdAngajat(Angajat idAngajat) {
		this.idAngajat = idAngajat;
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
		if(this.status.equals("Aprobat") ){
			//merg la salarii
		}
	}
	public CerereConcediu(Integer nrInregistrare, Angajat idAngajat,
			Date dataCerere, Date dataAprobare, Date dataInc, Date dataSf, String tipConcediu,
			String status) {
		super();
		this.nrInregistrare = nrInregistrare;
		this.idAngajat = idAngajat;
		this.dataCerere = dataCerere;
		this.dataAprobare = dataAprobare;
		this.tipConcediu = tipConcediu;
		this.dataInceputConcediu = dataInc;
		this.dataSfarsitConcediu = dataSf;
		this.status = status;
	}
	public CerereConcediu() {
		super();
		dataCerere = new Date();
		dataAprobare = new Date();
		dataInceputConcediu = new Date();
		dataSfarsitConcediu = new Date();
		tipConcediu = new String();
		idAngajat = new Angajat();
		
	}
	public Date getDataInceputConcediu() {
		return dataInceputConcediu;
	}
	public void setDataInceputConcediu(Date dataInceputConcediu) {
		this.dataInceputConcediu = dataInceputConcediu;
	}
	public Date getDataSfarsitConcediu() {
		return dataSfarsitConcediu;
	}
	public void setDataSfarsitConcediu(Date dataSfarsitConcediu) {
		this.dataSfarsitConcediu = dataSfarsitConcediu;
	}
	
	

}
