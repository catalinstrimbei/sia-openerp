package org.open.erp.services.productie;

/**
 * 
 * @author Echipa Productie
 * 
 * @BusinessObject(Entity)
 */

public class CriteriuCalitate {

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
