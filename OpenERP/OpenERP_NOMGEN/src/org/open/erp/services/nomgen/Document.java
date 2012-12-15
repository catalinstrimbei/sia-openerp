package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public  class Document implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nrDocument;         
	private Date dataDocument; 
	private Persoana persoana;    
	private String observatie;   
	private List<LinieDocument> liniiDocument  = new ArrayList<LinieDocument>();
	
	public int getNrDocument() {
		return nrDocument;
	}
	public void setNrDocument(int nrDocument) {
		this.nrDocument = nrDocument;
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
	public String getObservatie() {
		return observatie;
	}
	public void setObservatie(String observatie) {
		this.observatie = observatie;
	}
	public List<LinieDocument> getLiniiDocument() {
		return liniiDocument;
	}
	public void setLiniiDocument(List<LinieDocument> liniiDocument) {
		this.liniiDocument = liniiDocument;
	}
	
	public Document(int nrDocument, Date dataDocument, Persoana persoana,
			String observatie, List<LinieDocument> liniiDocument) {
		super();
		this.nrDocument = nrDocument;
		this.dataDocument = dataDocument;
		this.persoana = persoana;
		this.observatie = observatie;
		this.liniiDocument = liniiDocument;
	}
	
	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataDocument == null) ? 0 : dataDocument.hashCode());
		result = prime * result
				+ ((liniiDocument == null) ? 0 : liniiDocument.hashCode());
		result = prime * result + nrDocument;
		result = prime * result
				+ ((observatie == null) ? 0 : observatie.hashCode());
		result = prime * result
				+ ((persoana == null) ? 0 : persoana.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (dataDocument == null) {
			if (other.dataDocument != null)
				return false;
		} else if (!dataDocument.equals(other.dataDocument))
			return false;
		if (liniiDocument == null) {
			if (other.liniiDocument != null)
				return false;
		} else if (!liniiDocument.equals(other.liniiDocument))
			return false;
		if (nrDocument != other.nrDocument)
			return false;
		if (observatie == null) {
			if (other.observatie != null)
				return false;
		} else if (!observatie.equals(other.observatie))
			return false;
		if (persoana == null) {
			if (other.persoana != null)
				return false;
		} else if (!persoana.equals(other.persoana))
			return false;
		return true;
	}
	
	
}
