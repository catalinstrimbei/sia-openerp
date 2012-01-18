package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import javax.persistence.Id;

import org.hibernate.annotations.CollectionOfElements;


/*
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */
@Entity

public class Material implements Serializable{ 
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idMaterial; 
	
	private String denumireMaterial; 
	private String categorie;  
	private String UM; 
	
	//public Integer stocCurent;  
	private String tipContabil;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="mat", cascade = CascadeType.ALL)
	@CollectionOfElements
	private Collection<Produs> prod;
	
	public Material (Integer idMaterial, String denumire, 
			    String categorie, String uM, String tipContabil) {   
		super();      
		this.idMaterial = idMaterial;       
		this.denumireMaterial = denumire;        
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
		this.denumireMaterial = denumire;
		UM = uM;
	}
	
	public Material(Integer idMaterial, String denumire, String categorie,
			String uM, String tipContabil, Collection<Produs> prod) {
		super();
		this.idMaterial = idMaterial;
		this.denumireMaterial = denumire;
		this.categorie = categorie;
		UM = uM;
		this.tipContabil = tipContabil;
		this.prod = prod;
	}

	//@CollectionOfElements 
	public Collection<Produs> getProd() {
		return prod;
	}


	public void setProd(Collection<Produs> prod) {
		this.prod = prod;
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
		return denumireMaterial;
		} 
	public void setDenumire(String denumireM) {    
		this.denumireMaterial = denumireM;  
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