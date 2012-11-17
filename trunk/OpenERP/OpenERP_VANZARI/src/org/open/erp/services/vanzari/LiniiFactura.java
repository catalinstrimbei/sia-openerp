package org.open.erp.services.vanzari;

import java.util.Date;

import org.open.erp.services.nommat.Produse;

public class LiniiFactura {

	Integer nrLiniiFactura;
	Produse produs;
	Comenzi comanda;
	Double valoareFaraTva;
	Double valoareTVA;
	Double valoare;
	
	public Integer getNrLiniiFactura() {
		return nrLiniiFactura;
	}
	public void setNrLiniiFactura(Integer nrLiniiFactura) {
		this.nrLiniiFactura = nrLiniiFactura;
	}
	
	public Produse getProdus() {
		return produs;
	}
	public void setProdus(Produse produs) {
		this.produs = produs;
	}
	public Comenzi getComanda() {
		return comanda;
	}
	public void setComanda(Comenzi comanda) {
		this.comanda = comanda;
	}
	public Double getValoareFaraTva() {
		return valoareFaraTva;
	}
	public void setValoareFaraTva(Double valoareFaraTva) {
		this.valoareFaraTva = valoareFaraTva;
	}
	public Double getValoareTVA() {
		return valoareTVA;
	}
	public void setValoareTVA(Double valoareTVA) {
		this.valoareTVA = valoareTVA;
	}
	public Double getValoare() {
		return valoare;
	}
	public void setValoare(Double valoare) {
		this.valoare = valoare;
	}
	
	
}