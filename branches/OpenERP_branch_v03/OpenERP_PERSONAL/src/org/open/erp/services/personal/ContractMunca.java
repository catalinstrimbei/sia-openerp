package org.open.erp.services.personal;

import java.util.Date;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
public class ContractMunca {

	public static final Integer durataNelimitata = 0;
	
	private String  nrContract;
	private Double	salarBaza;
	private Double 	tarifOrar;
	private Angajat angajat;

	private Functie	functie;
	private Date    dataSemnare;
	private Date    dataInceput;
	private Date	dataTerminare;
	private Integer	durataContract = durataNelimitata;
	private String	motivIncheiere;
	
	
	public String getMotivIncheiere() {
		return motivIncheiere;
	}
	public void setMotivIncheiere(String motivIncheiere) {
		this.motivIncheiere = motivIncheiere;
	}
	public String getNrContract() {
		return nrContract;
	}
	public void setNrContract(String nrContract) {
		this.nrContract = nrContract;
	}
	public Angajat getAngajat() {
		return angajat;
	}
	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}
	public Functie getFunctie() {
		return functie;
	}
	public void setFunctie(Functie functie) {
		this.functie = functie;
	}
	public Date getDataSemnare() {
		return dataSemnare;
	}
	public void setDataSemnare(Date dataSemnare) {
		this.dataSemnare = dataSemnare;
	}
	public Date getDataInceput() {
		return dataInceput;
	}
	public void setDataInceput(Date dataInceput) {
		this.dataInceput = dataInceput;
	}
	public Date getDataTerminare() {
		return dataTerminare;
	}
	public void setDataTerminare(Date dataTerminare) {
		this.dataTerminare = dataTerminare;
	}
	public Integer getDurataContract() {
		return durataContract;
	}
	public void setDurataContract(Integer durataContract) {
		this.durataContract = durataContract;
	}
	public static Integer getDuratanelimitata() {
		return durataNelimitata;
	}
	public Double getSalarBaza() {
		return salarBaza;
	}
	public void setSalarBaza(Double salarBaza) {
		this.salarBaza = salarBaza;
	}
	public Double getTarifOrar() {
		return tarifOrar;
	}
	public void setTarifOrar(Double tarifOrar) {
		this.tarifOrar = tarifOrar;
	}
	public ContractMunca(String nrContract, Double salarBaza, Double tarifOrar,
			Angajat angajat, Functie functie, Date dataSemnare,
			Date dataInceput, Date dataTerminare, Integer durataContract,
			String motivIncheiere) {
		super();
		this.nrContract = nrContract;
		this.salarBaza = salarBaza;
		this.tarifOrar = tarifOrar;
		this.angajat = angajat;
		this.functie = functie;
		this.dataSemnare = dataSemnare;
		this.dataInceput = dataInceput;
		this.dataTerminare = dataTerminare;
		this.durataContract = durataContract;
		this.motivIncheiere = motivIncheiere;
	}
	
	
	public ContractMunca() {
		super();
	}	
	
	
}