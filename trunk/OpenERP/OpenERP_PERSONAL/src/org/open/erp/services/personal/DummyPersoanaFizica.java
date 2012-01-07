package org.open.erp.services.personal;

import java.util.List;

import javax.persistence.Entity;

/*
 * @author Echipa NomGen
 * @BusinessObject(DummyEntity)
 * @BusinessObject(Entity)
 */
@Entity
public class DummyPersoanaFizica extends DummyPersoana {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  nume;
	private String  prenume;
	private String  formaAdresare;
	private char    gen;
	private String  cnp;
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

	public DummyPersoanaFizica(Integer id, String adresa,String nume, String prenume, String formaAdresare, char gen, String cnp) {
	    super(id, adresa);
		
		this.nume = nume;
		this.prenume = prenume;
		this.formaAdresare = formaAdresare;
		this.gen = gen;
		this.cnp = cnp;
	}
	
	
	public DummyPersoanaFizica() {
		super();
	}
	
}