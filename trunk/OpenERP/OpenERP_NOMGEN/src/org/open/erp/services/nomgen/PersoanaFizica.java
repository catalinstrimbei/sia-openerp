package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/*
 * @author Echipa NomGen
 * @BusinessObject(DummyEntity)
 * @BusinessObject(Entity)
 */

@Entity
public class PersoanaFizica extends Persoana implements Serializable{
	private String  nume;
	private String  prenume;
	private String  formaAdresare;
	private char    gen;
	private String  cnp;
	@OneToOne @JoinColumn(name= "id")
	private Persoana p;
	
	private List<String> telefoane;
	
	private List<String> emailuri;
	
	
	/**
	 * @return the nume
	 */
	public String getNume() {
		return nume;
	}

	/**
	 * @param nume the nume to set
	 */
	public void setNume(String nume) {
		this.nume = nume;
	}


	/**
	 * @return the prenume
	 */
	public String getPrenume() {
		return prenume;
	}

	/**
	 * @param prenume the prenume to set
	 */
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}


	/**
	 * @return the formaAdresare
	 */
	public String getFormaAdresare() {
		return formaAdresare;
	}

	/**
	 * @param formaAdresare the formaAdresare to set
	 */
	public void setFormaAdresare(String formaAdresare) {
		this.formaAdresare = formaAdresare;
	}


	/**
	 * @return the gen
	 */
	public char getGen() {
		return gen;
	}

	/**
	 * @param gen the gen to set
	 */
	public void setGen(char gen) {
		this.gen = gen;
	}


	/**
	 * @return the cnp
	 */
	public String getCnp() {
		return cnp;
	}

	/**
	 * @param cnp the cnp to set
	 */
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}


	public List<String> getTelefoane() {
		return telefoane;
	}

	public void setTelefoane(List<String> telefoane) {
		this.telefoane = telefoane;
	}

	public List<String> getEmailuri() {
		return emailuri;
	}

	public void setEmailuri(List<String> emailuri) {
		this.emailuri = emailuri;
	}

	public Persoana getP() {
		return p;
	}

	public void setP(Persoana p) {
		this.p = p;
	}

	public PersoanaFizica(Integer id, Departament dep, String adresa,
			List<String> telefoane, List<String> emailuri, String nume,
			String prenume, String formaAdresare, char gen, String cnp,
			Persoana p, List<String> telefoane2, List<String> emailuri2) {
		super(id, dep, adresa, telefoane, emailuri);
		this.nume = nume;
		this.prenume = prenume;
		this.formaAdresare = formaAdresare;
		this.gen = gen;
		this.cnp = cnp;
		this.p = p;
		telefoane = telefoane2;
		emailuri = emailuri2;
	}

	public PersoanaFizica(Integer id, String adresa,String nume, String prenume, String formaAdresare, char gen, String cnp) {
	    super(id, adresa);
		
		this.nume = nume;
		this.prenume = prenume;
		this.formaAdresare = formaAdresare;
		this.gen = gen;
		this.cnp = cnp;
	}
	
	
	public PersoanaFizica() {
		super();
	}
	
}