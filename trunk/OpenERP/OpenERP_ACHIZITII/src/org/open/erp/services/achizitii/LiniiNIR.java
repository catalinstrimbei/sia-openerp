package org.open.erp.services.achizitii;

import org.open.erp.services.nommat.Materiale;

public class LiniiNIR {
	private NIR nir;
    private Integer  NrLInie;
    private Materiale material;
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
    public Materiale getMaterial() {
    	return material;
    }
    public void setMaterial(Materiale material) {
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
    public LiniiNIR(NIR nir, Integer nrLInie, Materiale material,
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