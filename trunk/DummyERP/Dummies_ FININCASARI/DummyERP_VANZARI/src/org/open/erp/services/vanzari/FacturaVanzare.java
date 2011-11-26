package org.open.erp.services.vanzari;

import java.util.Date;

/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class FacturaVanzare implements Comparable<Object> {
	private String nrfactura;
	private String seriaFactura;
	private Date data;
	private Double suma = 0.00;
	private Double sumaIncasata = 0.00;

	// private List<Incasare> incasari;
	//
	//
	// public List<Incasare> getIncasari() {
	// return incasari;
	// }
	// public void setIncasari(List<Incasare> incasari) {
	// this.incasari = incasari;
	// }
	public Double getSumaIncasata() {
		return sumaIncasata;
	}

	public void setSumaIncasata(Double sumaIncasata) {
		this.sumaIncasata = sumaIncasata;
	}

	public FacturaVanzare() {
		super();
	}

	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getNrfactura() {
		return nrfactura;
	}

	public void setNrfactura(String nrfactura) {
		this.nrfactura = nrfactura;
	}

	public String getSeriaFactura() {
		return seriaFactura;
	}

	public void setSeriaFactura(String seriaFactura) {
		this.seriaFactura = seriaFactura;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getSuma() {
		return suma;
	}

	public void setSuma(Double suma) {
		this.suma = suma;
	}

	public FacturaVanzare(String nrfactura, Date data, double suma,
			double sumaIncasata) {
		super();
		this.nrfactura = nrfactura;
		this.data = data;
		this.suma = suma;
		this.sumaIncasata = sumaIncasata;
	}

	@Override
	public int compareTo(Object o) {
		return this.data.compareTo(((FacturaVanzare) o).data);
	}

}
