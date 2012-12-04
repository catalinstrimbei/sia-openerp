package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Date;



public class Concedii implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  Integer  		nrInregistrare;
	private	 Angajat 		idAngajat;
	private  Date       	dataInceputConcediu;	
	private  Date       	dataSfarsitConcediu;	
	private  String   		tipConcediu;
	
	
	public Integer getNrInregistrare() {
		return nrInregistrare;
	}
	public Angajat getAngajat() {
		return idAngajat;
	}
	public void setAngajat(Angajat idAngajat) {
		this.idAngajat = idAngajat;
	}
	public void setNrInregistrare(Integer nrInregistrare) {
		this.nrInregistrare = nrInregistrare;
	}
	
	

	public String gettipConcediu() {
		return tipConcediu;
	}
	public void settipConcediu(String tipConcediu) {
		this.tipConcediu = tipConcediu;
	}
	
	
	public Concedii(Integer nrInregistrare, Angajat idAngajat,Date dataInc, Date dataSf, String tipConcediu) {
		super();
		dataInceputConcediu = new Date();
		dataSfarsitConcediu = new Date();
		idAngajat = new Angajat();
		this.nrInregistrare = nrInregistrare;
		this.idAngajat = idAngajat;
		this.dataInceputConcediu = dataInc;
		this.dataSfarsitConcediu = dataSf;
		this.tipConcediu = tipConcediu;
		
	}
	public Concedii() {
		super();
		dataInceputConcediu = new Date();
		dataSfarsitConcediu = new Date();
		idAngajat = new Angajat();
	}
	public Angajat getIdAngajat() {
		return idAngajat;
	}
	public void setIdAngajat(Angajat idAngajat) {
		this.idAngajat = idAngajat;
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
