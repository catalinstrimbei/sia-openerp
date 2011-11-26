package org.open.erp.services.nomgen;

/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class PersoanaFizica extends Persoana {
	private String  nume;
	private String  prenume;
	private String  formaAdresare;
	private char    gen;
	private String  cnp;
	
	
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


	public PersoanaFizica(Integer id, String adresa, Integer idContact,
			              String nume, String prenume, String formaAdresare, char gen, String cnp) {
		super(id, adresa, idContact);
		
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