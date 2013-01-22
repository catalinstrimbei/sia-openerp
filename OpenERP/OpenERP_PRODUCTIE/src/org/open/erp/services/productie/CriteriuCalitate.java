package org.open.erp.services.productie;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CriteriuCalitate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	Integer idCriteriu;
	
	String criteriu;
	
	public Integer getIdCriteriu() {
		return idCriteriu;
	}
	public void setIdCriteriu(Integer idCriteriu) {
		this.idCriteriu = idCriteriu;
	}
	public String getCriteriu() {
		return criteriu;
	}
	public void setCriteriu(String criteriu) {
		this.criteriu = criteriu;
	}
	public CriteriuCalitate(Integer idCriteriu, String criteriu) {
		super();
		this.idCriteriu = idCriteriu;
		this.criteriu = criteriu;
	}
	
	public CriteriuCalitate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((criteriu == null) ? 0 : criteriu.hashCode());
		result = prime * result
				+ ((idCriteriu == null) ? 0 : idCriteriu.hashCode());
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
		CriteriuCalitate other = (CriteriuCalitate) obj;
		if (criteriu == null) {
			if (other.criteriu != null)
				return false;
		} else if (!criteriu.equals(other.criteriu))
			return false;
		if (idCriteriu == null) {
			if (other.idCriteriu != null)
				return false;
		} else if (!idCriteriu.equals(other.idCriteriu))
			return false;
		return true;
	}
	
	
}
