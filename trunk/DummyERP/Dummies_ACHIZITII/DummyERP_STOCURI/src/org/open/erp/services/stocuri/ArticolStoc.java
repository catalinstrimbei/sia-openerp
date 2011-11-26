package org.open.erp.services.stocuri;

public class ArticolStoc {
	public Double stoc;
	public String denumire;
	public String UM;
	public Double getStoc() {
		return stoc;
	}
	public void setStoc(Double stoc) {
		this.stoc = this.stoc+stoc;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public ArticolStoc(Double stoc, String denumire) {
		super();
		this.stoc = stoc;
		this.denumire = denumire;
	}



}
