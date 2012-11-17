package org.open.erp.services.achizitii;

/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */

public class Produs {
	
	private Integer idProd;
	private String numeProdus;
	private String tipProdus;
	private Double pretIntrare;
	private Double cantitate;
	
	
	public Integer getIdProd() {
		return idProd;
	}


	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}


	public String getNumeProdus() {
		return numeProdus;
	}


	public void setNumeProdus(String numeProdus) {
		this.numeProdus = numeProdus;
	}


	public String getTipProdus() {
		return tipProdus;
	}


	public void setTipProdus(String tipProdus) {
		this.tipProdus = tipProdus;
	}


	public Double getPretIntrare() {
		return pretIntrare;
	}


	public void setPretIntrare(Double pretIntrare) {
		this.pretIntrare = pretIntrare;
	}


	public Double getCantitate() {
		return cantitate;
	}


	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}


	public Produs(Integer idProd, String numeProdus, String tipProdus,
			Double pretIntrare, Double cantitate) {
		super();
		this.idProd = idProd;
		this.numeProdus = numeProdus;
		this.tipProdus = tipProdus;
		this.pretIntrare = pretIntrare;
		this.cantitate = cantitate;
	}


	public Produs() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}




