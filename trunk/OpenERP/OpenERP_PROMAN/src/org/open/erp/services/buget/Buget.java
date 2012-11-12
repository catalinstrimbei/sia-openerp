package org.open.erp.services.buget;

import java.io.Serializable;

/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class Buget implements Serializable{
	
	Integer idBuget;
	Double valoareBuget;
	public Integer getIdBuget() {
		return idBuget;
	}
	public void setIdBuget(Integer idBuget) {
		this.idBuget = idBuget;
	}
	public Double getValoareBuget() {
		return valoareBuget;
	}
	public void setValoareBuget(Double valoareBuget) {
		this.valoareBuget = valoareBuget;
	}

}
