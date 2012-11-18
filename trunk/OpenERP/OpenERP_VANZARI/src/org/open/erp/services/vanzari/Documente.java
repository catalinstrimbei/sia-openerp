package org.open.erp.services.vanzari;

import java.util.Date;

import org.open.erp.services.nommat.Produse;

public class Documente {
	Integer idDocument;
	Responsabil responsabil;
	Date data;
	Produse produs;
	String um;
	Double cantitate;
	Double pretUnitar;
	Double valoareTVA;
	Double valoare;
	
	public Integer getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(Integer idDocument) {
		this.idDocument = idDocument;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getUm() {
		return um;
	}
	public void setUm(String um) {
		this.um = um;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public Double getPretUnitar() {
		return pretUnitar;
	}
	public void setPretUnitar(Double pretUnitar) {
		this.pretUnitar = pretUnitar;
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
	public Responsabil getResponsabil() {
		return responsabil;
	}
	public void setResponsabil(Responsabil responsabil) {
		this.responsabil = responsabil;
	}
	public Produse getProdus() {
		return produs;
	}
	public void setProdus(Produse produs) {
		this.produs = produs;
	}
	public Documente(Integer idDocument, Responsabil responsabil, Date data,
			Produse produs, String um, Double cantitate, Double pretUnitar,
			Double valoareTVA, Double valoare) {
		super();
		this.idDocument = idDocument;
		this.responsabil = responsabil;
		this.data = data;
		this.produs = produs;
		this.um = um;
		this.cantitate = cantitate;
		this.pretUnitar = pretUnitar;
		this.valoareTVA = valoareTVA;
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
