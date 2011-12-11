package org.open.erp.services.nomgen;

import java.util.List;

public class Material { 
	public Integer idMaterial; 
	public String denumire; 
	public String categorie;  
	public String UM; 
	public Integer stocCurent;  
	private String tipContabil;

	
	public Material (Integer idMaterial, String denumire, 
			    String categorie, String uM, Integer stocCurent, String tipContabil) {   
		super();      
		this.idMaterial = idMaterial;       
		this.denumire = denumire;        
		this.categorie = categorie;      
		UM = uM;       
		this.stocCurent = stocCurent; 
		this.tipContabil = tipContabil;
		}  
	
	
	public void setTipContabil(String tipContabil) {
        this.tipContabil = tipContabil;
    }
        
    public String getTipContabil() {
        return tipContabil;
    }

	
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
	public Integer getStocCurent() {   
		return stocCurent; 
		}  
	public void setStocCurent(Integer stocCurent) {    
		this.stocCurent = stocCurent;  
		}          
	}  