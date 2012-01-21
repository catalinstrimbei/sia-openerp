package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Document implements Serializable{  
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name="id")
	protected int nrDocument;         
	protected Date dataDocument; 
	@OneToOne @JoinColumn(name= "idPersoana")
	protected Persoana persoana;//responsabil    
     
     
	protected String observatie;   
	
	@OneToMany(mappedBy="documentParinte",targetEntity=LinieDocument.class, cascade = ALL)
	protected List<LinieDocument> liniiDocument  =new ArrayList<LinieDocument>();
	
	public Document(Integer nrDocument, Date dataDocument, Persoana persoana,
			String observatie) {
		super();
		this.nrDocument = nrDocument;
		this.dataDocument = dataDocument;
		this.persoana = persoana;
		this.observatie = observatie;
	}
	 
	public Document(){
		
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
	
	
    
	public long getNrDoc() {               
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
	
	public Persoana getPersoana() {               
		return persoana;          
		}    
	
	public void setPersoana(Persoana persoana) {        
		this.persoana = persoana;       
		}  
	
	}    

