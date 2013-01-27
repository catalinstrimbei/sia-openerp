package org.open.erp.services.personal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Interviu {
	@ManyToOne
	Anunt anuntPostat = null;
	@OneToMany
	List<Angajat> evaluatori = null;
	@ManyToMany
	List<ProbaEvaluare> probeEval =null;
	Date dataInterviu = null;
	@ManyToMany
	List<Candidat> candidatiEvaluati = null;
	@Id
	Integer id;
	
	public Interviu (Integer id, Anunt titluAnunt,
			List<Angajat> numeEvaluatori, List<ProbaEvaluare> probeInterviu,
			Date dataInterviu){
		this.id = id;
		this.anuntPostat = titluAnunt;
		this.evaluatori = numeEvaluatori;
		this.probeEval = probeInterviu;
		this.dataInterviu = dataInterviu;
		candidatiEvaluati = new ArrayList<Candidat>();
		probeEval = new ArrayList<ProbaEvaluare>();
		
	}
	
	public Interviu(){
		
	}
	
	public Anunt getAnuntPostat() {
		return anuntPostat;
	}

	public void setAnuntPostat(Anunt anuntPostat) {
		this.anuntPostat = anuntPostat;
	}

	public List<Angajat> getEvaluatori() {
		return evaluatori;
	}

	public void setEvaluatori(List<Angajat> evaluatori) {
		this.evaluatori = evaluatori;
	}

	public List<ProbaEvaluare> getProbeEval() {
		return probeEval;
	}

	public void setProbeEval(List<ProbaEvaluare> probeEval) {
		this.probeEval = probeEval;
	}

	public Date getDataInterviu() {
		return dataInterviu;
	}

	public void setDataInterviu(Date dataInterviu) {
		this.dataInterviu = dataInterviu;
	}

	public List<Candidat> getCandidatiEvaluati() {
		return candidatiEvaluati;
	}

	public void setCandidatiEvaluati(List<Candidat> candidatiEvaluati) {
		this.candidatiEvaluati = candidatiEvaluati;
	}

	/**
	 * Atribuirea unui candidat la un interviu
	 * 
	 * @param candidatInterviu Candidatul ales pentru interviu
	 * 
	 */
	public void adaugareCandidat (Candidat candidatInterviu){
		candidatiEvaluati.add(candidatInterviu);
		for (ProbaEvaluare p : probeEval){
			candidatInterviu.addProbaDeEvaluare(p);
		}
	}
	
	/**
	 * Se stabilesc rezultatele obtinute la probe de candidati, in cadrul unui interviu
	 * 
	 * @param candidat           Persoana care a participat la interviu
	 * @param rezultataEvaluare  Rezultatul obtinut la proba de evaluare
	 */
	public void stabilireRezultateInterviu(Candidat candidat, ProbaEvaluare testEfectuat, Integer rezultatEvaluare){
		candidat.addRezultatEvaluare(testEfectuat, rezultatEvaluare);
	}
	
}
