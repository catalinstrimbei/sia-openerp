package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class Document implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int nrDocument;

    @Temporal(TemporalType.TIMESTAMP)
	private Date dataDocument;
    
    @OneToOne @JoinColumn(name= "idPersoana")
	private Persoana persoana;
    
	private String observatie;   
	
	//@JoinColumn(name="documentParinte")
	@OneToMany(mappedBy = "documentParinte", targetEntity = LinieDocument.class, cascade = ALL, fetch = EAGER)
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
		result = prime * result + nrDocument;
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
		if (nrDocument != other.nrDocument)
			return false;
		return true;
	}

	
}
