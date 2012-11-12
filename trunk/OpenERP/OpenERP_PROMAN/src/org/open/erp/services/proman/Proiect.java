package org.open.erp.services.proman;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.open.erp.services.buget.Buget;

/**
 * 
 * @author catalin.strimbei
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Proiect implements Serializable{
	public static final Integer IN_INITIALIZARE = -1;
	public static final Integer INITIALIZAT = 0;
	public static final Integer IN_CURS = 1;
	public static final Integer TERMINAT = 2;

	Integer idProiect;
	
	String nume;
	Date dataStart = new Date();
	Date dataSfarsit;
	
	Double valoareBugetata;
	
	Integer status = Proiect.IN_INITIALIZARE; /* NOT_STARTED, IN_PROGRESS, COMPLET, AMANAT, SUSPENDAT/IN_ASTEPTARE */ 
	
	Responsabil responsabil;
	
	Buget buget;

	List<Activitate> activitati = new ArrayList<Activitate>();
	
	/* :: categorie, prioritate, bugetTimp, observatii */
	public Buget getBuget() {
		return buget;
	}
	public void setBuget(Buget buget) {
		this.buget = buget;
	}
	public Integer getIdProiect() {
		return idProiect;
	}
	public void setIdProiect(Integer idProiect) {
		this.idProiect = idProiect;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
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
	public Responsabil getResponsabil() {
		return responsabil;
	}
	public void setResponsabil(Responsabil responsabil) {
		this.responsabil = responsabil;
	}
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<Activitate> getActivitati() {
		return activitati;
	}

	public void adaugaActivitate(Activitate activitate){
		this.activitati.add(activitate);
	}	
	
	public Proiect(Integer idProiect, String nume, Date dataStart,
			Date dataSfarsit, Double valoareBugetata, Responsabil responsabil) {
		this.idProiect = idProiect;
		this.nume = nume;
		this.dataStart = dataStart;
		this.dataSfarsit = dataSfarsit;
		this.valoareBugetata = valoareBugetata;
		this.responsabil = responsabil;
	}
	public Proiect() {
	}
	
	public Proiect(String nume, Date dataStart,
			Date dataSfarsit, Double valoareBugetata, Responsabil responsabil) {
		//this.idProiect = idProiect;
		this.nume = nume;
		this.dataStart = dataStart;
		this.dataSfarsit = dataSfarsit;
		this.valoareBugetata = valoareBugetata;
		this.responsabil = responsabil;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idProiect == null) ? 0 : idProiect.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proiect other = (Proiect) obj;
		if (idProiect == null) {
			if (other.idProiect != null)
				return false;
		} else if (!idProiect.equals(other.idProiect))
			return false;
		return true;
	}
}