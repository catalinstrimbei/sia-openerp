package org.open.erp.services.personal;

public class Angajat {

	Integer id;
	String nume;
	Functie functie;

	public Angajat(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public Functie getFunctie() {
		return functie;
	}

	public void setFunctie(Functie functie) {
		this.functie = functie;
	}

	public Angajat(Functie functie) {
		super();
		this.functie = functie;
	}

	public Angajat(Integer id, String nume, Functie functie) {
		super();
		this.id = id;
		this.nume = nume;
		this.functie = functie;
	}

	public Angajat() {
		super();
	}
	
}
