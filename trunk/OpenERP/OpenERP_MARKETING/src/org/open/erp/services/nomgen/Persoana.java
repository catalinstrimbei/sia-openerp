package org.open.erp.services.nomgen;

public class Persoana {
	long id;
	String nume;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public Persoana(long id, String nume) {
		super();
		this.id = id;
		this.nume = nume;
	}

}
