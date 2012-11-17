package org.open.erp.services.vanzari;

import java.util.Date;

import org.open.erp.services.nommat.Produse;

public class Documente {
	Integer idDocument;
	Responsabil responsabil;
	Date data;
	Produse produs;
	Comenzi comanda;
	Double valoare;
	public Integer getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(Integer idDocument) {
		this.idDocument = idDocument;
	}
	public Responsabil getResponsabil() {
		return responsabil;
	}
	public void setResponsabil(Responsabil responsabil) {
		this.responsabil = responsabil;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
	public Documente(Integer idDocument, Responsabil responsabil, Date data,
			Produse produs, Comenzi comanda, Double valoare) {
		super();
		this.idDocument = idDocument;
		this.responsabil = responsabil;
		this.data = data;
		this.produs = produs;
		this.comanda = comanda;
		this.valoare = valoare;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idDocument == null) ? 0 : idDocument.hashCode());
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
		Documente other = (Documente) obj;
		if (idDocument == null) {
			if (other.idDocument != null)
				return false;
		} else if (!idDocument.equals(other.idDocument))
			return false;
		return true;
	}
	
	
}
