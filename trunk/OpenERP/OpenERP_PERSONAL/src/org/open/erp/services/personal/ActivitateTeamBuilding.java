package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class ActivitateTeamBuilding extends Activitate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer 	nrInscrisi;
	private String		status;	
	@OneToMany
	@JoinTable(
			name = "ResponsabilActivitate",
			joinColumns = @JoinColumn(name = "idActivitate"),
			inverseJoinColumns = @JoinColumn(name = "marca"))
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
