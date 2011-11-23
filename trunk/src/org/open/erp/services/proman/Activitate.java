package org.open.erp.services.proman;

import java.util.Date;

import org.open.erp.services.nomgen.Persoana;
/**
 * 
 * @author catalin.strimbei
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Activitate {
	public static final Integer NE_PORNITA = -1; 
	public static final Integer IN_CURS = 1;
	public static final Integer TERMINAT = 2;
	
	private Integer idActivitate;
	private String titulatura;
	private Date dataStart;
	private Date dataSfarsit;
	private Double valoareBugetata;
	private Integer status = NE_PORNITA;
	private Persoana responsabil;
	private Proiect proiect;
	private Date dataActualizare;
	private Double procentRealizare = 0.0;
	
	public Double getProcentRealizare() {
		return procentRealizare;
	}
	public void setProcentRealizare(Double procentRealizare) {
		this.procentRealizare = procentRealizare;
	}
	public Date getDataActualizare() {
		return dataActualizare;
	}
	public void setDataActualizare(Date dataActualizare) {
		this.dataActualizare = dataActualizare;
	}
	public Proiect getProiect() {
		return proiect;
	}
	public void setProiect(Proiect proiect) {
		this.proiect = proiect;
	}
	public Integer getIdActivitate() {
		return idActivitate;
	}
	public void setIdActivitate(Integer idActivitate) {
		this.idActivitate = idActivitate;
	}
	public String getTitulatura() {
		return titulatura;
	}
	public void setTitulatura(String titulatura) {
		this.titulatura = titulatura;
	}
	public Date getDataStart() {
		return dataStart;
	}
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}
	public Date getDataSfarsit() {
		return dataSfarsit;
	}
	public void setDataSfarsit(Date dataSfarsit) {
		this.dataSfarsit = dataSfarsit;
	}
	public Double getValoareBugetata() {
		return valoareBugetata;
	}
	public void setValoareBugetata(Double valoareBugetata) {
		this.valoareBugetata = valoareBugetata;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Persoana getResponsabil() {
		return responsabil;
	}
	public void setResponsabil(Persoana responsabil) {
		this.responsabil = responsabil;
	}
	public Activitate(Integer idActivitate, String titulatura, Date dataStart,
			Date dataSfarsit, Double valoareBugetata, 
			Persoana responsabil) {
		super();
		this.idActivitate = idActivitate;
		this.titulatura = titulatura;
		this.dataStart = dataStart;
		this.dataSfarsit = dataSfarsit;
		this.valoareBugetata = valoareBugetata;
		this.responsabil = responsabil;
	}
	public Activitate() {
		super();
	}	
	
	
	
}
