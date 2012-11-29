package org.open.erp.services.achizitii;


public abstract class Document {

	Integer idDocument;
	
	public Integer getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(Integer idDocument) {
		this.idDocument = idDocument;
	}

	public abstract Double getValoareTotala();
}
