package org.open.erp.services.nomgen;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


import org.hibernate.annotations.Fetch;
/*
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */
import java.io.Serializable;
import java.util.*;
@Entity

public class Document implements Serializable{  
	@Id
	private Integer nrDocument;         
	private Date dataDocument; 
    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Persoana persoana;//responsabil        
	private String observatie;   
	
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@Column(name="liniiDocument")
	private List<LinieDocument> liniiDocument = new ArrayList<LinieDocument>();
	
	

	
	public Document(Integer nrDocument, Date dataDocument, Persoana persoana,
			String observatie) {
		super();
		this.nrDocument = nrDocument;
		this.dataDocument = dataDocument;
		this.persoana = persoana;
		this.observatie = observatie;
	}
	
	public Document(){
		super();
	}
	
	public Document(Integer nrDocument,Date dataDocument){ // adaugare constructor pt Stocuri
		super();
	}
	
	public void addLinie(LinieDocument linieDocument) {
		liniiDocument.add(linieDocument);
	}
	@Transient
	public int getLiniiDocumentCount() {
		return liniiDocument.size();
	}
	

	
	public List<LinieDocument> getLiniiDocument(){
		return liniiDocument;
	}
	
	
	public void setLiniiDocument(List<LinieDocument> liniiDocument) {
		this.liniiDocument = liniiDocument;
	}

	public LinieDocument getLinieDocumentAt(int index) {
		return liniiDocument.get(index);
	}
	
	public void removeLinieDocument(LinieDocument linieDocument) {
		liniiDocument.remove(linieDocument);
	}
	
	public void removeLinieDocumentAt(int index) {
		liniiDocument.remove(index);
	}
	
	
    @Id
	public Integer getNrDoc() {               
		return nrDocument;          
		}         
	
	public void setNrDoc(Integer nrDocument) {              
		this.nrDocument = nrDocument;       
		}       
	
	public Date getDataDoc() {                 
		return dataDocument;         
		}       
	
	public void setDataDoc(Date dataDocument) {        
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
	@OneToOne
	public Persoana getPersoana() {               
		return persoana;          
		}    
	
	public void setPersoana(Persoana persoana) {        
		this.persoana = persoana;       
		}  
	
	}    

