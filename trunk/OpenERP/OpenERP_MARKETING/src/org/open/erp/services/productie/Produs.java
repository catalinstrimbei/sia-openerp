package org.open.erp.services.productie;

public class Produs {
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

	public Produs() {

	}

	public Produs(long id, String nume) {
		super();
		this.id = id;
		this.nume = nume;
	}

}
