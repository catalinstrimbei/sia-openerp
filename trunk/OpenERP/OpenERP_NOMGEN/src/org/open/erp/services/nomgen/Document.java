package org.open.erp.services.nomgen;


import java.util.*;

public class Document {  
	
	public Integer nrDocument;         
	public Date dataDocument;               
	public Persoana persoana;//responsabil        
	public String observatie;   
	
	private ArrayList<LinieDocument> liniiDocument = new ArrayList<LinieDocument>();
	
	
	public void addLinieDocument(LinieDocument linieDocument) {
		liniiDocument.add(linieDocument);
	}
	
	public int getLiniiDocumentCount() {
		return liniiDocument.size();
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

