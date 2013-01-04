package org.open.erp.services.achizitii;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.open.erp.services.nommat.Material;

@Entity
public class LiniiNIR implements Serializable{
	@Id @GeneratedValue
    private Integer  NrLInie;
	
	@ManyToOne
	private NIR nir;
	
	@OneToOne
    private Material material;
	
    private Double cantitate;
    private Double pret;
    private  Double  valoareLinie;
    private Double tvaLinie;
    	
    public NIR getNir() {
    	return nir;
    }
    public void setNir(NIR nir) {
    	this.nir = nir;
    }
    public Integer getNrLInie() {
    	return NrLInie;
    }
    public void setNrLInie(Integer nrLInie) {
    	NrLInie = nrLInie;
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
    public Double getValoareLinie() {
    	return valoareLinie;
    }
    public void setValoareLinie(Double valoareLinie) {
    	this.valoareLinie = valoareLinie;
    }
    public Double getTvaLinie() {
    	return tvaLinie;
    }
    public void setTvaLinie(Double tvaLinie) {
    	this.tvaLinie = tvaLinie;
    }
    public LiniiNIR(NIR nir, Integer nrLInie, Material material,
    		Double cantitate, Double pret, Double valoareLinie, Double tvaLinie) {
    	super();
    	this.nir = nir;
    	NrLInie = nrLInie;
    	this.material = material;
    	this.cantitate = cantitate;
    	this.pret = pret;
    	this.valoareLinie = valoareLinie;
    	this.tvaLinie = tvaLinie;
    }
    public LiniiNIR() {
    	super();
    }
    
}