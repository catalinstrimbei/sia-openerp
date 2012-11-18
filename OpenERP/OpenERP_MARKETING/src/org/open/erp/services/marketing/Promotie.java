package org.open.erp.services.marketing;

import java.util.Date;

import org.open.erp.services.productie.Produs;

public class Promotie {
	long id;
	Produs produsPromotie;
	int pretPromotional;
	Date dataStart;
	Date dataFinal;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Produs getProdusPromotie() {
		return produsPromotie;
	}
	public void setProdusPromotie(Produs produsPromotie) {
		this.produsPromotie = produsPromotie;
	}
	public int getPretPromotional() {
		return pretPromotional;	
	}
	public void setPretPromotional(int pretPromotional) {
		this.pretPromotional = pretPromotional;
	}
	public Date getDataStart() {
		return dataStart;
	}
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
}
