package org.open.erp.services.personal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Candidat {

	String nume = null, prenume = null ,adresa = null, telefon = null, email = null;
	char sexCandidat = 'N';
	Date dataNasterii = null;
	List<ProbaEvaluare> testeEfectuate = null;
	HashMap<ProbaEvaluare,Integer> rezultatLaTeste = null;
	
	public Candidat(String nume, String prenume, String adr, String tel, String email, Date dataDeNastere, char sex){
		this.nume = nume;
		this.prenume = prenume;
		this.adresa = adr;
		this.telefon = tel;
		this.email = email;
		this.dataNasterii = dataDeNastere;
		this.sexCandidat = sex;
		testeEfectuate = new ArrayList<ProbaEvaluare>();
		rezultatLaTeste = new HashMap<ProbaEvaluare,Integer>();
	}
	
	void addProbaDeEvaluare(ProbaEvaluare test){
		testeEfectuate.add(test);
		rezultatLaTeste.put(test, 0);
	}
	
	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getSexCandidat() {
		return sexCandidat;
	}

	public void setSexCandidat(char sexCandidat) {
		this.sexCandidat = sexCandidat;
	}

	public Date getDataNasterii() {
		return dataNasterii;
	}

	public void setDataNasterii(Date dataNasterii) {
		this.dataNasterii = dataNasterii;
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
