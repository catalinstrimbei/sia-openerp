package org.open.erp.services.nomgen;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;
import javax.persistence.JoinTable;
import javax.persistence.Access;
import static javax.persistence.AccessType.FIELD;
import static javax.persistence.AccessType.PROPERTY;


/*
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */
@Entity
@Access(FIELD)
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class LinieDocument implements Serializable { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue
	 protected Integer linieDoc; 
	@ManyToOne @ForeignKey(name="fk_linieDoc_mat")		 
	 @JoinColumn(name = "material_id", referencedColumnName = "IDMATERIAL")
	 protected Material material; 
	 @ManyToOne @ForeignKey(name="fk_liniedoc_DOC")		 
	 @JoinColumn(name = "documentParinte_nrDocument", referencedColumnName = "nrDocument")
	protected Document documentParinte; 
	
	 protected Double cantitate = 0.0;  
	 protected Double pret = 0.0;  
	 protected Double TVA = 0.0 ; 
	
	public LinieDocument(Integer linieDoc, Document document, Material material,                  Double cantitate, Double pret, Double tVA) {    
		super();          
		this.linieDoc = linieDoc;      
		this.documentParinte = document;      
		this.material = material;      
		this.cantitate = cantitate;    
		this.pret = pret;        
		TVA = tVA;  } 
	public LinieDocument() {  
		
	}  

	public Integer getLinieDoc() {    
		return linieDoc;  
		}  
	public void setLinieDoc(Integer linieDoc) {      
		this.linieDoc = linieDoc;
		}
	public Document getDocument() { 
		return documentParinte;  
		} 
	public void setDocument(Document document) { 
		this.documentParinte = document; 
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
