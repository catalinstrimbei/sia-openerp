package org.open.erp.services.nomgen;

public abstract class Document {

	Integer idDocument;
	public abstract Double getValoareTotala();
	
	public Integer getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(Integer idDocument) {
		this.idDocument = idDocument;
	}

	
}