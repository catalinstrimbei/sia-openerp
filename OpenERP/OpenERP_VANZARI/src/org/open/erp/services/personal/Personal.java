package org.open.erp.services.personal;

public class Personal {

	Integer marca;
	String nume;
	String prenume;
	String serieBI;
	String nrBI;
	String ocupatie;
	public Integer getMarca() {
		return marca;
	}
	public void setMarca(Integer marca) {
		this.marca = marca;
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
	public String getSerieBI() {
		return serieBI;
	}
	public void setSerieBI(String serieBI) {
		this.serieBI = serieBI;
	}
	public String getNrBI() {
		return nrBI;
	}
	public void setNrBI(String nrBI) {
		this.nrBI = nrBI;
	}
	public String getOcupatie() {
		return ocupatie;
	}
	public void setOcupatie(String ocupatie) {
		this.ocupatie = ocupatie;
	}
	public Personal(Integer marca, String nume, String prenume, String serieBI,
			String nrBI, String ocupatie) {
		super();
		this.marca = marca;
		this.nume = nume;
		this.prenume = prenume;
		this.serieBI = serieBI;
		this.nrBI = nrBI;
		this.ocupatie = ocupatie;
	}
	public Personal() {
		super();
	}
	
	
}
