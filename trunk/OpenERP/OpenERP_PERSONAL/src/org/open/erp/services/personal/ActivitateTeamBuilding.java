package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	@ManyToMany
	@JoinTable(
			name = "ResponsabilActivitate",
			joinColumns = @JoinColumn(name = "idActivitate"),
			inverseJoinColumns = @JoinColumn(name = "marca"))
	private Collection<Angajat> responsabili;
	
	
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
	public Collection<Angajat> getResponsabili() {
		return responsabili;
	}
	public void setResponsabili(Collection<Angajat> responsabili) {
		this.responsabili = responsabili;
	}
	public ActivitateTeamBuilding(Integer nrInscrisi, String status,
			Collection<Angajat> responsabili) {
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
