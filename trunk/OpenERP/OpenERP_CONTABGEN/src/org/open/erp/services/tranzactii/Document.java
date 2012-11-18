package org.open.erp.services.tranzactii;

import java.util.Date;

public class Document {

	Integer idDocument;
	Integer numarDocument;
	Date dataDocument;
	String descriereDocument;
	
	public Integer getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(Integer idDocument) {
		this.idDocument = idDocument;
	}
	public Integer getNumarDocument() {
		return numarDocument;
	}
	public void setNumarDocument(Integer numarDocument) {
		this.numarDocument = numarDocument;
	}
	public Date getDataDocument() {
		return dataDocument;
	}
	public void setDataDocument(Date dataDocument) {
		this.dataDocument = dataDocument;
	}
	public String getDescriereDocument() {
		return descriereDocument;
	}
	public void setDescriereDocument(String descriereDocument) {
		this.descriereDocument = descriereDocument;
	}
}
