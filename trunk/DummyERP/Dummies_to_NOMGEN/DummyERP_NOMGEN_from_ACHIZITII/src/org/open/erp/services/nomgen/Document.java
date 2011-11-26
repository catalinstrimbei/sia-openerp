package org.open.erp.services.nomgen;

import java.util.Date;

public class Document {
	
	public Integer nrDocument;
	public Date dataDocument;	
	public Persoana persoana;//responsabil
	public String observatie;	
	
	public Integer getNrDocument() {
		return nrDocument;
	}
	public void setNrDocument(Integer nrDocument) {
		this.nrDocument = nrDocument;
	}
	public Date getDataDpcument() {
		return dataDocument;
	}
	public void setDataDpcument(Date dataDocument) {
		this.dataDocument = dataDocument;
	}	
	public String getObservatie() {
		return observatie;
	}
	public void setObservatie(String observatie) {
		this.observatie = observatie;
	}
	public Date getDataDocument() {
		return dataDocument;
	}
	public void setDataDocument(Date dataDocument) {
		this.dataDocument = dataDocument;
	}
	public Persoana getPersoana() {
		return persoana;
	}
	public void setPersoana(Persoana persoana) {
		this.persoana = persoana;
	}
	
	

}
