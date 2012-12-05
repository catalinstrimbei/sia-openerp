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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBuget == null) ? 0 : idBuget.hashCode());
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
		Buget other = (Buget) obj;
		if (idBuget == null) {
			if (other.idBuget != null)
				return false;
		} else if (!idBuget.equals(other.idBuget))
			return false;
		return true;
	}
	
	
}
