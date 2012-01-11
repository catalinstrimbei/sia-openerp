package org.open.erp.services.plati;

/**
 * 
 * @author Echipa FINPLATI
 * 
 * @BusinessObject(Entity)
 * 
 */

import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

@Entity(name = "Plata")
public abstract class Plata implements Serializable{
	@Id
	private Integer idPlata;
	
	private String moneda;
	@Temporal(DATE)
	private Date dataEmiterii;
	private Boolean avans;
	@Temporal(DATE)
	private Date dataInregistrarii;
	private Double suma;
	private String seria;
	private Integer numar;
	private String locatie;
	@ManyToMany
	private List<FacturaPrimita> facturi = new ArrayList<FacturaPrimita>();
	
	public Plata(Integer idPlata, Date dataEmiterii, Boolean avans,
			Date dataInregistrarii, Double suma,
			String seria, Integer numar, String locatie) {
		super();
		this.idPlata = idPlata;
		
		this.dataEmiterii = dataEmiterii;
		this.avans = avans;
		this.dataInregistrarii = dataInregistrarii;
		this.suma = suma;
		this.seria = seria;
		this.numar = numar;
		this.locatie = locatie;
	}
	
	public Plata() {
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

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

	public List<FacturaPrimita> getFacturi() {
		return facturi;
	}

	public void setFacturi(List<FacturaPrimita> facturi) {
		this.facturi = facturi;
	}

	public Integer getIdPlata() {
		return idPlata;
	}

	public void setIdPlata(Integer idPlata) {
		this.idPlata = idPlata;
	}

	public Double getSuma() {
		return suma;
	}

	public void setSuma(Double suma) {
		this.suma = suma;
	}

}
