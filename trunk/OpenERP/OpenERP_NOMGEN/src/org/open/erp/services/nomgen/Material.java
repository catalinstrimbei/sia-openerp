package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import static javax.persistence.CascadeType.ALL;


/*
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Material implements Serializable{ 
	@Id @GeneratedValue
	protected Integer idMaterial; 
	protected String denumire; 
	protected String categorie;  
	protected String UM; 
	
	//public Integer stocCurent;  
	protected String tipContabil;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="mat", cascade = CascadeType.ALL)
	private List <Produs> prod=new ArrayList<Produs>();
	
	@OneToMany(mappedBy="material",targetEntity=LinieDocument.class, cascade = ALL)
	private List<LinieDocument> liniiDocumente=new ArrayList<LinieDocument>();
	
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
	
	public Material(Integer idMaterial, String denumire, String categorie,
			String uM, String tipContabil, List<Produs> prod) {
		super();
		this.idMaterial = idMaterial;
		this.denumire = denumire;
		this.categorie = categorie;
		UM = uM;
		this.tipContabil = tipContabil;
		this.prod = prod;
	}


	public Collection<Produs> getProd() {
		return prod;
	}


	public void setProd(List<Produs> prod) {
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


	public List<LinieDocument> getLiniiDocumente() {
		return liniiDocumente;
	}


	public void setLiniiDocumente(ArrayList<LinieDocument> liniiDocumente) {
		this.liniiDocumente = liniiDocumente;
	} 
	
	}  