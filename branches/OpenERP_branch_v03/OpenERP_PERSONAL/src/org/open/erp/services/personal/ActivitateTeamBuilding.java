package org.open.erp.services.personal;

import java.util.List;


/**
 * 
 * @BusinessObject(Entity)
 * 
 */

public class ActivitateTeamBuilding extends Activitate{
	private Integer 	nrInscrisi;
	private String		status;	
	private List<Angajat> responsabili;
	
	
	public Integer getNrInscrisi() {
		return nrInscrisi;
	}
	public void setNrInscrisi(Integer nrInscrisi) {
		this.nrInscrisi = nrInscrisi;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Angajat> getResponsabili() {
		return responsabili;
	}
	public void setResponsabili(List<Angajat> responsabili) {
		this.responsabili = responsabili;
	}
	public ActivitateTeamBuilding(Integer nrInscrisi, String status,
			List<Angajat> responsabili) {
		super();
		this.nrInscrisi = nrInscrisi;
		this.status = status;
		this.responsabili = responsabili;
	}
	/**
	 * 
	 */
	public ActivitateTeamBuilding() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
