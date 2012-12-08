package org.open.erp.services.stocuri;

public class Produse {
	Integer idProdus;
	String denumire;
	Integer codProdus;
	Double cost;
	Double cantitate;
	Double stoc;
	
	public Produse(Integer idProdus, String denumire, Integer codProdus,
			Double cost, Double cantitate) {
		super();
		this.idProdus = idProdus;
		this.denumire = denumire;
		this.codProdus = codProdus;
		this.cost = cost;
		this.cantitate = cantitate;
		
	}
	
	
	
	public Produse() {
		super();
	}



	public Integer getIdProdus() {
		return idProdus;
	}
	public void setIdProdus(Integer idProdus) {
		this.idProdus = idProdus;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public Integer getCodProdus() {
		return codProdus;
	}
	public void setCodProdus(Integer codProdus) {
		this.codProdus = codProdus;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public Double getStoc() {
		return stoc;
	}
	public void setStoc(Double stoc) {
		this.stoc = stoc;
	}
	


}
