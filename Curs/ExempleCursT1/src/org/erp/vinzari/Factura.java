package org.erp.vinzari;

public class Factura{
	String codClient;
	Double sumaFacturata;
	public String getCodClient() {
		return codClient;
	}
	public void setCodClient(String codClient) {
		this.codClient = codClient;
	}
	public Double getSumaFacturata() {
		return sumaFacturata;
	}
	public void setSumaFacturata(Double sumaFacturata) {
		this.sumaFacturata = sumaFacturata;
	}
	public Factura(String codClient, Double sumaFacturata) {
		this.codClient = codClient;
		this.sumaFacturata = sumaFacturata;
	}
	public Factura() {
	}
	
	
	
}