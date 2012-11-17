package org.open.erp.services.vanzari;

import java.util.Date;

public class Documente {
	Integer idDocument;
	Integer idDelegat;
	Date data;
	Integer idProdus;
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
	public Integer getIdDelegat() {
		return idDelegat;
	}
	public void setIdDelegat(Integer idDelegat) {
		this.idDelegat = idDelegat;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Integer getIdProdus() {
		return idProdus;
	}
	public void setIdProdus(Integer idProdus) {
		this.idProdus = idProdus;
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
	
	
}
