package org.open.erp.services.vanzari;

import java.util.Date;

import org.open.erp.services.nommat.Produse;

public class LiniiAviz {
	Integer nrLiniiAviz;
	Produse produs;
	Comenzi comanda;
	Double valoare;
	
	public Integer getNrLiniiAviz() {
		return nrLiniiAviz;
	}
	public void setNrLiniiAviz(Integer nrLiniiAviz) {
		this.nrLiniiAviz = nrLiniiAviz;
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
	public Double getValoare() {
		return valoare;
	}
	public void setValoare(Double valoare) {
		this.valoare = valoare;
	}
	public LiniiAviz(Integer nrLiniiAviz, Produse produs, Comenzi comanda,
			Double valoare) {
		super();
		this.nrLiniiAviz = nrLiniiAviz;
		this.produs = produs;
		this.comanda = comanda;
		this.valoare = valoare;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nrLiniiAviz == null) ? 0 : nrLiniiAviz.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LiniiAviz other = (LiniiAviz) obj;
		if (nrLiniiAviz == null) {
			if (other.nrLiniiAviz != null)
				return false;
		} else if (!nrLiniiAviz.equals(other.nrLiniiAviz))
			return false;
		return true;
	}
	
	
	
}
