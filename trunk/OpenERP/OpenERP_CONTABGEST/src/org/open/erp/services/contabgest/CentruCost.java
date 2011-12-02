package org.open.erp.services.contabgest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.productie.FazaProductie;

/**
 * 
 * @author andreea.andronic, marius.borsan, andreea.zaharia, anca.zavate
 * 
 * @BusinessObject(Entity)
 * 
 */

public class CentruCost {
	
	public static final Integer IN_ALOCARE = -1;
	public static final Integer ALOCAT = 0;
	public static final Integer IN_CURS = 1;
	public static final Integer FINALIZAT = 2;
	
	//
	Integer idCentruCost;
	String denumireCentruCost;
	private FazaProductie faza;
	Date dataStart = new Date();
	Date dataSfarsit;
	Double sumaCentruCost;
	Integer status = CentruCost.IN_ALOCARE;
	Angajat responsabil;
	//Costuri primare
	CosturiPrimare costuriPrimare;
	Map<Activitate, LinieCost> activitati = new HashMap<Activitate, LinieCost>();
	
	
	
	
	public CentruCost() {
		super();
	}
	public CentruCost(Integer idCentruCost, String denumireCentruCost, FazaProductie faza,
			Date dataStart, Date dataSfarsit, Double sumaCentruCost,
			Integer status, Angajat responsabil,
			CosturiPrimare costuriPrimare, Map<Activitate, LinieCost> activitati) {
		super();
		this.idCentruCost = idCentruCost;
		this.denumireCentruCost = denumireCentruCost;
		this.faza = faza;
		this.dataStart = dataStart;
		this.dataSfarsit = dataSfarsit;
		this.sumaCentruCost = sumaCentruCost;
		this.status = status;
		this.responsabil = responsabil;
		this.costuriPrimare = costuriPrimare;
		this.activitati = activitati;
	}
	public Integer getIdCentruCost() {
		return idCentruCost;
	}
	public void setIdCentruCost(Integer idCentruCost) {
		this.idCentruCost = idCentruCost;
	}
	public String getDenumireCentruCost() {
		return denumireCentruCost;
	}
	public void setDenumireCentruCost(String denumireCentruCost) {
		this.denumireCentruCost = denumireCentruCost;
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
	public Double getSumaCentruCost() {
		return sumaCentruCost;
	}
	public void setSumaCentruCost(Double sumaCentruCost) {
		this.sumaCentruCost = sumaCentruCost;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Angajat getResponsabil() {
		return responsabil;
	}
	public void setResponsabil(Angajat responsabil) {
		this.responsabil = responsabil;
	}
	public CosturiPrimare getCosturiPrimare() {
		return costuriPrimare;
	}
	public void setCosturiPrimare(CosturiPrimare costuriPrimare) {
		this.costuriPrimare = costuriPrimare;
	}
	public Set<Activitate> getActivitati() {
		return activitati.keySet();
	}
	

	public FazaProductie getFaza() {
		return faza;
	}
	public void setFaza(FazaProductie faza) {
		this.faza = faza;
	}
	public void setActivitati(Map<Activitate, LinieCost> activitati) {
		this.activitati = activitati;
	}
	public void adaugaActivitate(Activitate activitate, LinieCost linieCost) {
		// TODO Auto-generated method stub
		
	}
	public LinieCost getLinieCosturiPrimare(Activitate activitate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
