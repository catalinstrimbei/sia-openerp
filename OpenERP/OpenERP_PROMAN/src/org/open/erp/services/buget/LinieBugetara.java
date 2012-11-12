package org.open.erp.services.buget;

import java.io.Serializable;

/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */

public class LinieBugetara{
	protected Integer id;
	protected Buget buget;
	protected Double valoareBugetata;
	protected Double valoareConsumata;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	
	
}
