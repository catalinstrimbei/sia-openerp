package org.open.erp.services.vanzari;

import java.util.Date;

/**
 * @author Isabela
 *
 */
public class Factura {

	Integer IDFact;
	Date dataFact;
	Double valoareFact;
	Double sumaIncasare;
	
	
	
	public Integer getIDFact() {
		return IDFact;
	}
	public void setIDFact(Integer iDFact) {
		IDFact = iDFact;
	}
	public Date getDataFact() {
		return dataFact;
	}
	public void setDataFact(Date dataFact) {
		this.dataFact = dataFact;
	}
	@Override
	public String toString() {
		return "Factura [dataFact=" + dataFact + ", getDataFact()="
				+ getDataFact() + "]";
	}
	public Double getValoareFact() {
		return valoareFact;
	}
	public void setValoareFact(Double valoareFact) {
		this.valoareFact = valoareFact;
	}
	public Double getSumaIncasare() {
		return sumaIncasare;
	}
	public void setSumaIncasare(Double sumaIncasare) {
		this.sumaIncasare = sumaIncasare;
	}
	
	
}
