package org.open.erp.services.achizitii;

import org.open.erp.services.nommat.Material;


public class LiniiFactura {
	private Integer nrLinie;
	private Double pret;
	private Material material;
	private Double cantitate;
	private Factura factura;
	public Integer getNrLinie() {
		return nrLinie;
	}
	public void setNrLinie(Integer nrLinie) {
		this.nrLinie = nrLinie;
	}
	public Double getPret() {
		return pret;
	}
	public void setPret(Double pret) {
		this.pret = pret;
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
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public LiniiFactura(Integer nrLinie, Double pret, Material material,
			Double cantitate, Factura factura) {
		super();
		this.nrLinie = nrLinie;
		this.pret = pret;
		this.material = material;
		this.cantitate = cantitate;
		this.factura = factura;
	}
	public LiniiFactura() {
		super();
	}
	
	

}
