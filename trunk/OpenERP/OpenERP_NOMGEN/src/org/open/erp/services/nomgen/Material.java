package org.open.erp.services.nomgen;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.Id;


/*
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */
@Entity

public class Material implements Serializable{ 
	//@Id @GeneratedValue
	private Integer idMaterial; 
	private String denumire; 
	private String categorie;  
	private String UM; 
	
	//public Integer stocCurent;  
	private String tipContabil;

	
	public Material (Integer idMaterial, String denumire, 
			    String categorie, String uM, String tipContabil) {   
		super();      
		this.idMaterial = idMaterial;       
		this.denumire = denumire;        
		this.categorie = categorie;      
		UM = uM;       
		//this.stocCurent = stocCurent; 
		this.tipContabil = tipContabil;
		}  
	
	
	public Material() {
		super();
	}

	
	
	public Material(Integer idMaterial, String denumire, String uM) {
		super();
		this.idMaterial = idMaterial;
		this.denumire = denumire;
		UM = uM;
	}
	public void setTipContabil(String tipContabil) {
        this.tipContabil = tipContabil;
    }
        
    public String getTipContabil() {
        return tipContabil;
    }

	@Id
	public Integer getIdMaterial() {     
		return idMaterial; 
		}  
	public void setIdMaterial(Integer idMaterial) {   
		this.idMaterial = idMaterial;  
		}  
	public String getDenumire() {      
		return denumire;
		} 
	public void setDenumire(String denumire) {    
		this.denumire = denumire;  
		} 
	public String getCategorie() {   
		return categorie; 
		}  
	public void setCategorie(String categorie) {    
		this.categorie = categorie; 
		} 
	public String getUM() {  
			return UM; 
			}  
	public void setUM(String uM) { 
		UM = uM;  
		} 
	
	}  