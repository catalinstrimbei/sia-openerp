package org.open.erp.services.personal;

public class Tuple<I,DI,DS>{
	public I denInstitutie;
	public DI dataInceput;
	public DS dataSfarsit;
	
	public I getDenInstitutie() {
		return denInstitutie;
	}
	
	public DI getDataInceput() {
		return dataInceput;
	}
	
	public DS getDataSfarsit() {
		return dataSfarsit;
	}
	
	
}
