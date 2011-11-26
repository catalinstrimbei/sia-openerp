package org.open.erp.services.buget;
/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class Buget {
	Integer idBuget;
	Double valoareBuget;

	public Double getValoareBuget() {
		return valoareBuget;
	}

	public void setValoareBuget(Double valoareBuget) {
		this.valoareBuget = valoareBuget;
	}

	public Buget(Integer idBuget, Double valoareBuget) {
		this.idBuget = idBuget;
		this.valoareBuget = valoareBuget;
	}

	public Buget() {
	}
	
	
}
