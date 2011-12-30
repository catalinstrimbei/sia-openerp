package org.open.erp.services.incasari;

/**
 * 
 * @author Echipa FININCASARI
 * 
 * @BusinessObject(Entity)
 * 
 */

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.open.erp.services.vanzari.FacturaEmisa;


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
	private Integer numar;
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

	public Integer getNumar() {
		return numar;
	}

	public void setNumar(Integer numar) {
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

	private List<FacturaEmisa> facturi = new ArrayList<FacturaEmisa>();

	public Incasare(Date dataEmiterii, Boolean avans,
			Date dataInregistrarii, Double suma, String sumaInLitere,
			String seria, Integer numar, String locatie) {
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

	public List<FacturaEmisa> getFacturi() {
		return facturi;
	}

	public void setFacturi(List<FacturaEmisa> facturi) {
		this.facturi = facturi;
	}

	public Double getSuma() {
		return suma;
	}

	public void setSuma(Double suma) {
		this.suma = suma;
	}

}