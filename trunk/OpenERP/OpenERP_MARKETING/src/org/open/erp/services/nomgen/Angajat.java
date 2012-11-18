package org.open.erp.services.nomgen;

public class Angajat extends Persoana {
	String prenume;
	String rol;

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

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Angajat(long id, String nume) {
		super(id, nume);
		// TODO Auto-generated constructor stub
	}

	public Angajat(long id, String nume, String prenume, String rol) {
		super(id, nume);
		this.prenume = prenume;
		this.rol = rol;
	}

}