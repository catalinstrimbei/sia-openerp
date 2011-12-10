package org.open.erp.services.nomgen;

public class Material { 
	public Integer idMaterial; 
	public String denumire; 
	public String categorie;  
	public String UM; 
	public Integer stocCurent;  
	public Material (Integer idMaterial, String denumire, String categorie, String uM, Integer stocCurent) {   
		super();      
		this.idMaterial = idMaterial;       
		this.denumire = denumire;        
		this.categorie = categorie;      
		UM = uM;       
		this.stocCurent = stocCurent; 
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