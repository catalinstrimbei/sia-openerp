package org.open.erp.services.buget;

import java.io.Serializable;

/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */

public class LinieBugetara implements Serializable{

	protected Integer id;

	protected Buget buget;
	protected Double valoareBugetata;
	protected Double valoareConsumata;
	
	public Integer getIdLinieBugetara() {
		return id;
	}
	public void setIdLinieBugetara(Integer idLinieBugetara) {
		this.id = idLinieBugetara;
	}
	public Buget getBuget() {
		return buget;
	}
	public void setBuget(Buget buget) {
		this.buget = buget;
	}
	public Double getValoareBugetata() {
		return valoareBugetata;
	}
	public void setValoareBugetata(Double valoareBugetata) {
		this.valoareBugetata = valoareBugetata;
	}
	public Double getValoareConsumata() {
		return valoareConsumata;
	}
	public void setValoareConsumata(Double valoareConsumata) {
		this.valoareConsumata = valoareConsumata;
	}
	public LinieBugetara(Integer idLinieBugetara, Buget buget,
			Double valoareBugetata) {
		super();
		this.id = idLinieBugetara;
		this.buget = buget;
		this.valoareBugetata = valoareBugetata;
	}
	public LinieBugetara() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
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
		LinieBugetara other = (LinieBugetara) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
