package org.open.erp.services.personal;

import java.util.Date;
import java.util.List;


/**
 * 
 * @BusinessObject(Entity)
 * 
 */
public class InterviuCandidat {
	private Integer     idInterviuCandidat;
	private Candidat	candidat;
	private Date 		dataInterviu;
	private String		rezultatEvaluare;	
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
