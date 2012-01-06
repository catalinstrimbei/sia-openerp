package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.open.erp.services.nomgen.Persoana;


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
	@Id
	private Integer idInterviu;
	private String tipInterviu;
	@ManyToMany
	private List<Persoana> intervievatori;
	@ManyToMany
	private List<ProbaEvaluare> probeEvaluare;
	
	public String getTipInterviu() {
		return tipInterviu;
	}
	public void setTipInterviu(String tipInterviu) {
		this.tipInterviu = tipInterviu;
	}
	public List<Persoana> getIntervievatori() {
		return intervievatori;
	}
	public void setIntervievatori(List<Persoana> intervievatori) {
		this.intervievatori = intervievatori;
	}
	public List<ProbaEvaluare> getProbeEvaluare() {
		return probeEvaluare;
	}
	
	public Interviu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Interviu(String tipInterviu, List<Persoana> intervievatori) {
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
			List<Persoana> intervievatori, List<ProbaEvaluare> probeEvaluare) {
		super();
		this.idInterviu = idInterviu;
		this.tipInterviu = tipInterviu;
		this.intervievatori = intervievatori;
		this.probeEvaluare = probeEvaluare;
	}
	public Interviu(Integer idInterviu, String tipInterviu,
			List<Persoana> intervievatori) {
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
	
	
}
