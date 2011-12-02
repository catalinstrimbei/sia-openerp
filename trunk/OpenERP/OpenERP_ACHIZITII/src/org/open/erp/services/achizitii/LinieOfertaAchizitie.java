package org.open.erp.services.achizitii;

public class LinieOfertaAchizitie {
	public OfertaAchizitie oferta;
	public Articol articol;
	public Double cantitate;
	public Integer linie;
	
	public OfertaAchizitie getOferta() {
		return oferta;
	}
	public void setOferta(OfertaAchizitie oferta) {
		this.oferta = oferta;
	}
	public LinieOfertaAchizitie(OfertaAchizitie oferta, Articol articol,
			Double cantitate, Integer linie) {
		super();
		this.oferta = oferta;
		this.articol = articol;
		this.cantitate = cantitate;
		this.linie = linie;
	}
	public Articol getArticol() {
		return articol;
	}
	public void setArticol(Articol articol) {
		this.articol = articol;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public Integer getLinie() {
		return linie;
	}
	public void setLinie(Integer linie) {
		this.linie = linie;
	}	
	

}
