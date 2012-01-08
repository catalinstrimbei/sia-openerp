package org.open.erp.services.nomgen;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */
@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class LinieDocument { 
	 
	//@GeneratedValue
	private Integer linieDoc; 
	//@ManyToOne
	public Document document; 
	public Material material; 
	public Double cantitate = 0.0;  
	public Double pret = 0.0;  
	public Double TVA = 0.0 ; 
	
	public LinieDocument(Integer linieDoc, Document document, Material material,                  Double cantitate, Double pret, Double tVA) {    
		super();          
		this.linieDoc = linieDoc;      
		this.document = document;      
		this.material = material;      
		this.cantitate = cantitate;    
		this.pret = pret;        
		TVA = tVA;  } 
	public LinieDocument() {  
		
	}  
	@Id
	public Integer getLinieDoc() {    
		return linieDoc;  
		}  
	public void setLinieDoc(Integer linieDoc) {      
		this.linieDoc = linieDoc;
		}
	public Document getDocument() { 
		return document;  
		} 
	public void setDocument(Document document) { 
		this.document = document; 
		} 
	public Material getMaterial() {    
		return material;  
		} 
	public void setMaterial(Material material) {   
		this.material = material; 
		} 
	public Double getCantitate() {  
		return cantitate;  
		} 
	public void setCantitate(Double cantitate) { 
		this.cantitate = cantitate;
		} 
	public Double getPret() { 
		
		return pret;  
		}  
	public void setPret(Double pret) {  
		this.pret = pret; 
		}  
	public Double getTVA() {  
		return TVA;  
		}  
	public void setTVA(Double tVA) { 
		TVA = tVA; 
		}
	
	}  
