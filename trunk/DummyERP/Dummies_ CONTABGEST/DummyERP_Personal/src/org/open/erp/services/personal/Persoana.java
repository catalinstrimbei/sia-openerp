package org.open.erp.services.personal;

public class Persoana {
	private Integer idPersoana;
	private String nume;
	private String prenume;
	
	
	
	
	public Persoana() {
		super();
	}


	public Persoana(Integer idPersoana, String nume, String prenume) {
		super();
		this.idPersoana = idPersoana;
		this.nume = nume;
		this.prenume = prenume;
	}
	
	
	public Integer getIdPersoana() {
		return idPersoana;
	}
	public void setIdPersoana(Integer idPersoana) {
		this.idPersoana = idPersoana;
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
	
	
	

}
