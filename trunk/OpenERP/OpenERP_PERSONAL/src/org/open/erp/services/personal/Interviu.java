package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
//TODO uncomment this
//import org.open.erp.services.nomgen.Persoana;


/**
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class Interviu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idInterviu;
	private String tipInterviu;
	//TODO    adauga Jar si clasa DummyPersoana in persistence.xml
	@OneToMany
	@JoinTable(
			name = "InterviewatorInterviu",
			joinColumns = @JoinColumn(name = "idInterviu"),
			inverseJoinColumns = @JoinColumn(name = "id"))
	private Collection<DummyPersoana> intervievatori;
	@OneToMany
	@JoinTable(
			name = "ProbaInterviu",
			joinColumns = @JoinColumn(name = "idInterviu"),
			inverseJoinColumns = @JoinColumn(name = "idProba"))
	private Collection<ProbaEvaluare> probeEvaluare;
	
	@OneToMany(mappedBy = "interviu", cascade = CascadeType.ALL)
	private Collection<InterviuCandidat> 	interviuri;
	
	public String getTipInterviu() {
		return tipInterviu;
	}
	public void setTipInterviu(String tipInterviu) {
		this.tipInterviu = tipInterviu;
	}
	public Collection<DummyPersoana> getIntervievatori() {
		return intervievatori;
	}
	public void setIntervievatori(Collection<DummyPersoana> intervievatori) {
		this.intervievatori = intervievatori;
	}
	public Collection<ProbaEvaluare> getProbeEvaluare() {
		return probeEvaluare;
	}
	
	public Interviu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Interviu(String tipInterviu, Collection<DummyPersoana> intervievatori) {
		super();
		this.tipInterviu = tipInterviu;
		this.intervievatori = intervievatori;
	}
	public Integer getIdInterviu() {
		return idInterviu;
	}
	public void setIdInterviu(Integer idInterviu) {
		this.idInterviu = idInterviu;
	}
	public Interviu(Integer idInterviu, String tipInterviu,
			Collection<DummyPersoana> intervievatori, Collection<ProbaEvaluare> probeEvaluare) {
		super();
		this.idInterviu = idInterviu;
		this.tipInterviu = tipInterviu;
		this.intervievatori = intervievatori;
		this.probeEvaluare = probeEvaluare;
	}
	public Interviu(Integer idInterviu, String tipInterviu,
			Collection<DummyPersoana> intervievatori) {
		super();
		this.idInterviu = idInterviu;
		this.tipInterviu = tipInterviu;
		this.intervievatori = intervievatori;
	}
	public Interviu(Integer idInterviu, String tipInterviu) {
		super();
		this.idInterviu = idInterviu;
		this.tipInterviu = tipInterviu;
	}
	public Collection<InterviuCandidat> getInterviuri() {
		return interviuri;
	}
	public void setInterviuri(Collection<InterviuCandidat> interviuri) {
		this.interviuri = interviuri;
	}	
	
	
}
