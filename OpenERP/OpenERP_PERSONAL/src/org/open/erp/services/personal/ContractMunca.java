package org.open.erp.services.personal;

import java.util.Date;

public class ContractMunca {
 private int salar;
 private int idContract;
 private Date dataAngajare;
 private String perioadaContract;
 private int numarLuniContractuale=0;
 private int normaZilnica;
 private Post functie;
 private int tarifOreSuplimentare;
 
public int getSalar() {
	return salar;
}
public void setSalar(int salar) {
	this.salar = salar;
}
public int getIdContract() {
	return idContract;
}
public void setIdContract(int idContract) {
	this.idContract = idContract;
}
public Date getDataAngajare() {
	return dataAngajare;
}
public void setDataAngajare(Date dataAngajare) {
	this.dataAngajare = dataAngajare;
}
public String getPerioadaContract() {
	return perioadaContract;
}
public void setPerioadaContract(String perioadaContract,int numarLuni) {
	this.perioadaContract = perioadaContract;
	if(this.perioadaContract.equals("determinata")){
		numarLuniContractuale= numarLuni;
	}
}
public int getNumarLuniContractuale() {
	return numarLuniContractuale;
}
public void setNumarLuniContractuale(int numarLuniContractuale) {
	this.numarLuniContractuale = numarLuniContractuale;
}
public int getNormaZilnica() {
	return normaZilnica;
}
public void setNormaZilnica(int normaZilnica) {
	this.normaZilnica = normaZilnica;
}
public Post getFunctie() {
	return functie;
}
public void setFunctie(Post functie) {
	this.functie = functie;
}
public int getTarifOreSuplimentare() {
	return tarifOreSuplimentare;
}
public void setTarifOreSuplimentare(int tarifOreSuplimentare) {
	this.tarifOreSuplimentare = tarifOreSuplimentare;
}

public ContractMunca (int salar, int idContract, Date dataAngajare, String perioadaContract,
		int numarLuniContr, int normaZilnica, Post functie,int tarifOreSupl){
	 this.salar= salar;
	 this.idContract= idContract;
	 this.dataAngajare=dataAngajare;
	 this.perioadaContract=perioadaContract;
	 this.numarLuniContractuale= numarLuniContr;
	 this.normaZilnica= normaZilnica;
	 this.functie= functie;
	 this.tarifOreSuplimentare= tarifOreSupl;
}

public ContractMunca (){
	super();
	dataAngajare= new Date();
	functie = new Post();	
}
}
