package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.List;

import org.open.erp.services.nommat.Materiale;

public class NIR extends Document{
	private Integer nrNIR;
	private Date data;
	private Furnizori furnizor;
	private List<LiniiNIR> linieNir;
	private Double valoareTotala;
	private Factura factura;
	
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public Integer getNrNIR() {
		return nrNIR;
	}
	public void setNrNIR(Integer nrNIR) {
		this.nrNIR = nrNIR;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Furnizori getFunrizor() {
		return furnizor;
	}
	public void setFunrizor(Furnizori furnizor) {
		this.furnizor = furnizor;
	}
	public List<LiniiNIR> getLinieNir() {
		return linieNir;
	}
	public void setLinieNir(List<LiniiNIR> linieNir) {
		this.linieNir = linieNir;
	}
	public Double getValoareTotala() {
		return valoareTotala;
	}
	public void setValoareTotala(Double valoareTotala) {
		this.valoareTotala = valoareTotala;
	}
	public NIR(Integer nrNIR, Date data, List<LiniiNIR> linieNir,
			Double valoareTotala, Factura factura) {
		super();
		this.nrNIR = nrNIR;
		this.data = data;
		this.linieNir = linieNir;
		this.valoareTotala = valoareTotala;
		this.factura = factura;
	}
	public NIR() {
		super();
	}
	public NIR(Integer nrNIR, Date data, Factura factura, Double valoareTotala) {
		super();
		this.nrNIR = nrNIR;
		this.data = data;
		this.valoareTotala = valoareTotala;
		this.factura = factura;
	}
	
	

}
