package org.open.erp.services.personal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Interviu {
	Anunt anuntPostat = null;
	List<Angajat> evaluatori = null;
	List<ProbaEvaluare> probeEval =null;
	Date dataInterviu = null;
	List<Candidat> candidatiEvaluati = null;
	
	
	public Interviu (Anunt titluAnunt,
			List<Angajat> numeEvaluatori, List<ProbaEvaluare> probeInterviu,
			Date dataInterviu){
		this.anuntPostat = titluAnunt;
		this.evaluatori = numeEvaluatori;
		this.probeEval = probeInterviu;
		this.dataInterviu = dataInterviu;
		candidatiEvaluati = new ArrayList<Candidat>();
		probeEval = new ArrayList<ProbaEvaluare>();
		
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
	void adaugareCandidat (Candidat candidatInterviu){
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
	void stabilireRezultateInterviu(Candidat candidat, ProbaEvaluare testEfectuat, Integer rezultatEvaluare){
		candidat.addRezultatEvaluare(testEfectuat, rezultatEvaluare);
	}
	
}
