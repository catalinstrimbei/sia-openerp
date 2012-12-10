package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.List;


public class Factura extends Document{
	private Integer nrFactura;
	private Date dataFactura;
	private Date dataScadenta;  //data pana la care se poate plati factura
	private Furnizori funrizor;
	private List<LiniiFactura> linieFactura;
	private Double valoareTotala;

	public Integer getNrFactura() {
		return nrFactura;
	}
	public void setNrFactura(Integer nrFactura) {
		this.nrFactura = nrFactura;
	}
	public Date getDataFactura() {
		return dataFactura;
	}
	public void setDataFactura(Date dataFactura) {
		this.dataFactura = dataFactura;
	}
	public Date getDataScadenta() {
		return dataScadenta;
	}
	public void setDataScadenta(Date dataScadenta) {
		this.dataScadenta = dataScadenta;
	}
	public Furnizori getFunrizor() {
		return funrizor;
	}
	public void setFunrizor(Furnizori funrizor) {
		this.funrizor = funrizor;
	}
	public List<LiniiFactura> getLinieFactura() {
		return linieFactura;
	}
	public void setLinieFactura(List<LiniiFactura> linieFactura) {
		this.linieFactura = linieFactura;
	}
	/**
	 * necesar pentru inregistrarea in contabilitate
	 */
	public Double getValoareTotala() {
		return valoareTotala;
	}
	public void setValoareTotala(Double valoareTotala) {
		this.valoareTotala = valoareTotala;
	}
	public Factura(Integer nrFactura, Date dataFactura, Date dataScadenta,
			Furnizori funrizor, List<LiniiFactura> linieFactura,
			Double valoareTotala) {
		super();
		this.nrFactura = nrFactura;
		this.dataFactura = dataFactura;
		this.dataScadenta = dataScadenta;
		this.funrizor = funrizor;
		this.linieFactura = linieFactura;
		this.valoareTotala = valoareTotala;
	}
	
	public Factura(Integer nrFactura, Date dataFactura, Date dataScadenta,
			Furnizori funrizor, Double valoareTotala) {
		super();
		this.nrFactura = nrFactura;
		this.dataFactura = dataFactura;
		this.dataScadenta = dataScadenta;
		this.funrizor = funrizor;
		this.valoareTotala = valoareTotala;
	}
	
	public Factura(Integer nrFactura, Date dataFactura, Date dataScadenta, Double valoareTotala) {
		super();
		this.nrFactura = nrFactura;
		this.dataFactura = dataFactura;
		this.dataScadenta = dataScadenta;
		this.valoareTotala = valoareTotala;
	}
	
	public Factura() {
		super();
	}

	
}
