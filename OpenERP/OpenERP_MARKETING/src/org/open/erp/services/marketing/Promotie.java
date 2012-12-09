package org.open.erp.services.marketing;

import java.util.Date;

import org.open.erp.services.nommat.Material;

public class Promotie {
	long id;
	Material produsPromotie;
	int pretPromotional;
	Date dataStart;
	Date dataFinal;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Material getProdusPromotie() {
		return produsPromotie;
	}

	public void setProdusPromotie(Material produsPromotie) {
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

	public Promotie() {

	}

	public Promotie(long id, Material produsPromotie, int pretPromotional, Date dataStart, Date dataFinal) {
		super();
		this.id = id;
		this.produsPromotie = produsPromotie;
		this.pretPromotional = pretPromotional;
		this.dataStart = dataStart;
		this.dataFinal = dataFinal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Promotie other = (Promotie) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
