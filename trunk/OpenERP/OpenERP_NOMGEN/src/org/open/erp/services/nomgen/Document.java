package org.open.erp.services.nomgen;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
/*
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */
import java.io.Serializable;
import java.util.*;
@Entity

public class Document implements Serializable{  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer nrDocument;         
	private Date dataDocument; 
	@OneToOne @JoinColumn(name= "id")
	private Persoana persoana;//responsabil    
    
    
	private String observatie;   
	
	@OneToMany(mappedBy="document", cascade = CascadeType.ALL)
	private Collection<LinieDocument> liniiDocument;
	
	

	
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
	
	public int getLiniiDocumentCount() {
		return liniiDocument.size();
	}
	

	
	public Collection<LinieDocument> getLiniiDocument(){
		return liniiDocument;
	}
	
	
	public void setLiniiDocument(Collection<LinieDocument> liniiDocument) {
		this.liniiDocument = liniiDocument;
	}


	
	public void removeLinieDocument(LinieDocument linieDocument) {
		liniiDocument.remove(linieDocument);
	}
	
	public void removeLinieDocumentAt(int index) {
		liniiDocument.remove(index);
	}
	
	
   
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

