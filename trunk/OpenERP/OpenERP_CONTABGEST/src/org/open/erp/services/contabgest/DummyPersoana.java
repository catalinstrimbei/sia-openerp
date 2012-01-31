package org.open.erp.services.contabgest;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

/*
 * @author Echipa NomGen
 * @BusinessObject(DummyEntity)
 * @BusinessObject(Entity)
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class DummyPersoana implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String  nume;
	private String  prenume;
	private String  formaAdresare;
	private char    gen;
	private String  cnp;
	private String  adresa;
	@Transient
	private Collection<String> telefoane;
	@Transient
	private Collection<String> emailuri;
	
	
	
	/**
	 * @return the id
	 */
	
	
	
	public Integer getId() {
		return id;
	}

	
	
	public DummyPersoana(String nume, String prenume, String formaAdresare) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.formaAdresare = formaAdresare;
	}



	public DummyPersoana(Integer id, String nume, String prenume,
			String formaAdresare, char gen, String cnp) {
		super();
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		this.formaAdresare = formaAdresare;
		this.gen = gen;
		this.cnp = cnp;
	}

	public DummyPersoana(Integer id, String nume, String prenume,
			String formaAdresare, char gen, String cnp, String adresa,
			Collection<String> telefoane, Collection<String> emailuri) {
		super();
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		this.formaAdresare = formaAdresare;
		this.gen = gen;
		this.cnp = cnp;
		this.adresa = adresa;
		this.telefoane = telefoane;
		this.emailuri = emailuri;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the adresa
	 */
	public String getAdresa() {
		return adresa;
	}

	/**
	 * @param adresa the adresa to set
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
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

	public String getFormaAdresare() {
		return formaAdresare;
	}

	public void setFormaAdresare(String formaAdresare) {
		this.formaAdresare = formaAdresare;
	}

	public char getGen() {
		return gen;
	}

	public void setGen(char gen) {
		this.gen = gen;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public Collection<String> getTelefoane() {
		return telefoane;
	}

	public void setTelefoane(Collection<String> telefoane) {
		this.telefoane = telefoane;
	}

	public Collection<String> getEmailuri() {
		return emailuri;
	}

	public void setEmailuri(Collection<String> emailuri) {
		this.emailuri = emailuri;
	}

	public void afiseazaInformatii(String p) {
		 
	      System.out.println("- Date despre persoana - "+p);
	      System.out.println("Id persoana: " + getId());
	      System.out.println("Adresa: " + adresa);
	   }
	
	public DummyPersoana() {
		
	}
	
}