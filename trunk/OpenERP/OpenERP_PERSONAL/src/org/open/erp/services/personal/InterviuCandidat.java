package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;


/**
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class InterviuCandidat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer     idInterviuCandidat;
	@ManyToOne
	private Candidat	candidat;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date 		dataInterviu;
	private String		rezultatEvaluare;	
	@ManyToOne
	private Interviu	interviu;
	
	public Candidat getCandidat() {
		return candidat;
	}
	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}
	public Date getDataInterviu() {
		return dataInterviu;
	}
	public void setDataInterviu(Date dataInterviu) {
		this.dataInterviu = dataInterviu;
	}
	public String getRezultatEvaluare() {
		return rezultatEvaluare;
	}
	public void setRezultatEvaluare(String rezultatEvaluare) {
		this.rezultatEvaluare = rezultatEvaluare;
	}
	public Interviu getInterviu() {
		return interviu;
	}
	public void setInterviu(Interviu interviu) {
		this.interviu = interviu;
	}
	

	
	public InterviuCandidat(Integer idInterviuCandidat, Candidat candidat,
			Date dataInterviu, String rezultatEvaluare, Interviu interviu) {
		super();
		this.idInterviuCandidat = idInterviuCandidat;
		this.candidat = candidat;
		this.dataInterviu = dataInterviu;
		this.rezultatEvaluare = rezultatEvaluare;
		this.interviu = interviu;
	}
	public Integer getIdInterviuCandidat() {
		return idInterviuCandidat;
	}
	public void setIdInterviuCandidat(Integer idInterviuCandidat) {
		this.idInterviuCandidat = idInterviuCandidat;
	}
	public InterviuCandidat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
