package org.open.erp.services.personal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.open.erp.services.nomgen.Adresa;
import org.open.erp.services.nomgen.PersoanaFizica;

public class Candidat extends PersoanaFizica{

	
	List<ProbaEvaluare> testeEfectuate = null;
	HashMap<ProbaEvaluare,Integer> rezultatLaTeste = null;
	
	
	public Candidat(Integer id, String nume, String sex, String mail,
			String statutInCompanie, String stareCivila, String dataNastere,
			String telefon, Adresa adresa, List<ProbaEvaluare> testeEfectuate,
			HashMap<ProbaEvaluare, Integer> rezultatLaTeste) {
		super(id, nume, sex, mail, statutInCompanie, stareCivila, dataNastere,
				telefon, adresa);
		this.testeEfectuate = testeEfectuate;
		this.rezultatLaTeste = rezultatLaTeste;
	}

	public Candidat(Integer id, String nume, String sex, String mail,
			String statutInCompanie, String stareCivila, String dataNastere,
			String telefon, Adresa adresa ) {
		super(id, nume, sex, mail, statutInCompanie, stareCivila, dataNastere,
				telefon, adresa);
		testeEfectuate = new ArrayList<ProbaEvaluare>();
		rezultatLaTeste = new HashMap<ProbaEvaluare,Integer>();
		
	}
	
		
	void addProbaDeEvaluare(ProbaEvaluare test){
		testeEfectuate.add(test);
		rezultatLaTeste.put(test, 0);
	}
	
	
	public List<ProbaEvaluare> getTesteEfectuate() {
		return testeEfectuate;
	}

	public void setTesteEfectuate(List<ProbaEvaluare> testeEfectuate) {
		this.testeEfectuate = testeEfectuate;
	}

	public HashMap<ProbaEvaluare, Integer> getRezultatLaTeste() {
		return rezultatLaTeste;
	}

	public void setRezultatLaTeste(HashMap<ProbaEvaluare, Integer> rezultatLaTeste) {
		this.rezultatLaTeste = rezultatLaTeste;
	}

	void addRezultatEvaluare(ProbaEvaluare test,Integer rezultat){
		rezultatLaTeste.put(test, rezultat);
	}
	
}
