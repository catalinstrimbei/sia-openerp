package org.open.erp.services.achizitii;

import org.open.erp.services.nommat.Materiale;

public class LiniiComanda {
	private Integer nrLinie;
	private Double pret;
	private Materiale material;
	private Double cantitate;
	private Comanda comanda;
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
	public Comanda getComanda() {
		return comanda;
	}
	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}
	public LiniiComanda(Integer nrLinie, Double pret, Materiale material,
			Double cantitate, Comanda comanda) {
		super();
		this.nrLinie = nrLinie;
		this.pret = pret;
		this.material = material;
		this.cantitate = cantitate;
		this.comanda = comanda;
	}
	public LiniiComanda() {
		super();
	}

	

}
