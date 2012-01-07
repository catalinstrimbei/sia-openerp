package org.open.erp.services.productie;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author Echipa Productie
 * 
 * @BusinessObject(Entity)
 */
@Entity
public class CriteriuCalitate implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	Integer idCriteriu;
	String criteriu;
	
	
	public CriteriuCalitate(Integer idCriteriu, String criteriu) {
		super();
		this.idCriteriu = idCriteriu;
		this.criteriu = criteriu;
	}
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
	public CriteriuCalitate() {
		super();
	}
	
	
	
	
	
	
}
