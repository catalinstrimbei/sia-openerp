package org.open.erp.services.proman;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.open.erp.services.buget.Buget;
import org.open.erp.services.buget.LinieBugetara;
import org.open.erp.services.nomgen.Persoana;
/**
 * 
 * @author catalin.strimbei
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Proiect {
	public static final Integer IN_INITIALIZARE = -1;
	public static final Integer INITIALIZAT = 0;
	public static final Integer IN_CURS = 1;
	public static final Integer TERMINAT = 2;
	
	//
	Integer idProiect;
	String nume;
	Date dataStart = new Date();
	Date dataSfarsit;
	Double valoareBugetata;
	Integer status = Proiect.IN_INITIALIZARE;
	Persoana responsabil;
	Buget buget;
	Map<Activitate, LinieBugetara> activitati = new HashMap<Activitate, LinieBugetara>();
	
	//
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
	public Persoana getResponsabil() {
		return responsabil;
	}
	public void setResponsabil(Persoana responsabil) {
		this.responsabil = responsabil;
	}
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Set<Activitate> getActivitati() {
		return activitati.keySet();
	}
	public void adaugaActivitate(Activitate activitate, LinieBugetara linieBugetara){
		this.activitati.put(activitate, linieBugetara);
	}
	public LinieBugetara getLinieBugetara(Activitate activitate){
		return this.activitati.get(activitate);
	}
	//
	public Proiect(Integer idProiect, String nume, Date dataStart,
			Date dataSfarsit, Double valoareBugetata, Persoana responsabil) {
		this.idProiect = idProiect;
		this.nume = nume;
		this.dataStart = dataStart;
		this.dataSfarsit = dataSfarsit;
		this.valoareBugetata = valoareBugetata;
		this.responsabil = responsabil;
	}
	public Proiect() {
	}
	
	//
	
	
}