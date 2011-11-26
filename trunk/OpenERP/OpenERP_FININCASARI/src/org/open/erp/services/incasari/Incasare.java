package org.open.erp.services.incasari;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.open.erp.services.vanzari.FacturaVanzare;

public abstract class Incasare {
	
	private String moneda;

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	private Date dataEmiterii;

	private Boolean avans;

	private Date dataInregistrarii;

	private Double suma;
	
	private String sumaInLitere;
	
	public String getSumaInLitere() {
		return sumaInLitere;
	}

	public void setSumaInLitere(String sumaInLitere) {
		this.sumaInLitere = sumaInLitere;
	}

	private String seria;
	private String numar;
	private String locatie;

	public Date getData() {
		return dataEmiterii;
	}

	public void setData(Date data) {
		this.dataEmiterii = data;
	}

	public String getSeria() {
		return seria;
	}

	public void setSeria(String seria) {
		this.seria = seria;
	}

	public String getNumar() {
		return numar;
	}

	public void setNumar(String numar) {
		this.numar = numar;
	}

	public Date getDataEmiterii() {
		return dataEmiterii;
	}

	public void setDataEmiterii(Date dataEmiterii) {
		this.dataEmiterii = dataEmiterii;
	}

	public Boolean getAvans() {
		return avans;
	}

	public void setAvans(Boolean avans) {
		this.avans = avans;
	}

	public Date getDataInregistrarii() {
		return dataInregistrarii;
	}

	public void setDataInregistrarii(Date dataInregistrarii) {
		this.dataInregistrarii = dataInregistrarii;
	}

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}

	private List<FacturaVanzare> facturi = new ArrayList<FacturaVanzare>();

	public Incasare(Date dataEmiterii, Boolean avans,
			Date dataInregistrarii, Double suma, String sumaInLitere,
			String seria, String numar, String locatie) {
		super();
		this.dataEmiterii = dataEmiterii;
		this.avans = avans;
		this.dataInregistrarii = dataInregistrarii;
		this.suma = suma;
		this.sumaInLitere = sumaInLitere;
		this.seria = seria;
		this.numar = numar;
		this.locatie = locatie;
		
	}

	public List<FacturaVanzare> getFacturi() {
		return facturi;
	}

	public void setFacturi(List<FacturaVanzare> facturi) {
		this.facturi = facturi;
	}

	public Double getSuma() {
		return suma;
	}

	public void setSuma(Double suma) {
		this.suma = suma;
	}

}
