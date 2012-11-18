package org.open.erp.services.achizitii;

import org.open.erp.services.nommat.Materiale;

public class LiniiOferta {
	private Integer nrLinie;
	private Double pret;
	private Materiale material;
	private Double cantitate;
	private Oferta oferta;
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
	public Oferta getOferta() {
		return oferta;
	}
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	public LiniiOferta(Integer nrLinie, Double pret, Materiale material,
			Double cantitate, Oferta oferta) {
		super();
		this.nrLinie = nrLinie;
		this.pret = pret;
		this.material = material;
		this.cantitate = cantitate;
		this.oferta = oferta;
	}
	public LiniiOferta() {
		super();
	}
	
	

}
