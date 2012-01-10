package org.open.erp.services.salarizare;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import javax.persistence.Transient;

@Entity
public class CentralizatorStatSalarii implements Serializable{
	@Id
	@GeneratedValue
	private Integer idCentralizator;
	private Integer An;
	private Integer Luna;
	
	@Transient
	private List<StatSalarii> centralizator = new ArrayList<StatSalarii>();
	private Double totalCas;
	private Double totalCass;
	private Double totalSomaj;
	private Double totalAlteRetineri;
	private Double totalAlteSporuri;
	private Double totalSalarBrut;
	private Double totalImpozit;
	private Double totalSalarNet;
	@Temporal(DATE)
	private Date dataCentralizator;
	
	public CentralizatorStatSalarii(Integer idCentralizator, Integer an,
			Integer luna, List<StatSalarii> centralizator, Double totalCas,
			Double totalCass, Double totalSomaj, Double totalAlteRetineri,
			Double totalAlteSporuri, Double totalSalarBrut,
			Double totalImpozit, Double totalSalarNet, Date dataCentralizator) {
		super();
		this.idCentralizator = idCentralizator;
		An = an;
		Luna = luna;
		this.centralizator = centralizator;
		this.totalCas = totalCas;
		this.totalCass = totalCass;
		this.totalSomaj = totalSomaj;
		this.totalAlteRetineri = totalAlteRetineri;
		this.totalAlteSporuri = totalAlteSporuri;
		this.totalSalarBrut = totalSalarBrut;
		this.totalImpozit = totalImpozit;
		this.totalSalarNet = totalSalarNet;
		this.dataCentralizator = dataCentralizator;
	}
	public Date getDataCentralizator() {
		return dataCentralizator;
	}
	public void setDataCentralizator(Date dataCentralizator) {
		this.dataCentralizator = dataCentralizator;
	}
	public Integer getIdCentralizator() {
		return idCentralizator;
	}
	public void setIdCentralizator(Integer idCentralizator) {
		this.idCentralizator = idCentralizator;
	}
	public Integer getAn() {
		return An;
	}
	public void setAn(Integer an) {
		An = an;
	}
	public Integer getLuna() {
		return Luna;
	}
	public void setLuna(Integer luna) {
		Luna = luna;
	}
	public List<StatSalarii> getCentralizator() {
		return centralizator;
	}
	public void setCentralizator(List<StatSalarii> centralizator) {
		this.centralizator = centralizator;
	}
	
	public Double getTotalCas() {
		return totalCas;
	}
	public void setTotalCas(Double totalCas) {
		this.totalCas = totalCas;
	}
	public Double getTotalCass() {
		return totalCass;
	}
	public void setTotalCass(Double totalCass) {
		this.totalCass = totalCass;
	}
	public Double getTotalSomaj() {
		return totalSomaj;
	}
	public void setTotalSomaj(Double totalSomaj) {
		this.totalSomaj = totalSomaj;
	}
	public Double getTotalAlteRetineri() {
		return totalAlteRetineri;
	}
	public void setTotalAlteRetineri(Double totalAlteRetineri) {
		this.totalAlteRetineri = totalAlteRetineri;
	}
	public Double getTotalAlteSporuri() {
		return totalAlteSporuri;
	}
	public void setTotalAlteSporuri(Double totalAlteSporuri) {
		this.totalAlteSporuri = totalAlteSporuri;
	}
	public Double getTotalSalarBrut() {
		return totalSalarBrut;
	}
	public void setTotalSalarBrut(Double totalSalarBrut) {
		this.totalSalarBrut = totalSalarBrut;
	}
	public Double getTotalImpozit() {
		return totalImpozit;
	}
	public void setTotalImpozit(Double totalImpozit) {
		this.totalImpozit = totalImpozit;
	}
	public Double getTotalSalarNet() {
		return totalSalarNet;
	}
	public void setTotalSalarNet(Double totalSalarNet) {
		this.totalSalarNet = totalSalarNet;
	}
	public void addStatSalarii(StatSalarii s){
		this.centralizator.add(s);
	}
	public CentralizatorStatSalarii(Integer idCentralizator, Integer an,
			Integer luna, List<StatSalarii> centralizator) {
		super();
		this.idCentralizator = idCentralizator;
		An = an;
		Luna = luna;
		this.centralizator = centralizator;
	}
	public CentralizatorStatSalarii() {
		super();
	}
	public CentralizatorStatSalarii(Integer idCentralizator, Integer an,
			Integer luna, List<StatSalarii> centralizator, Double totalCas,
			Double totalCass, Double totalSomaj, Double totalAlteRetineri,
			Double totalAlteSporuri, Double totalSalarBrut,
			Double totalImpozit, Double totalSalarNet) {
		super();
		this.idCentralizator = idCentralizator;
		An = an;
		Luna = luna;
		this.centralizator = centralizator;
		this.totalCas = totalCas;
		this.totalCass = totalCass;
		this.totalSomaj = totalSomaj;
		this.totalAlteRetineri = totalAlteRetineri;
		this.totalAlteSporuri = totalAlteSporuri;
		this.totalSalarBrut = totalSalarBrut;
		this.totalImpozit = totalImpozit;
		this.totalSalarNet = totalSalarNet;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCentralizator == null) ? 0 : idCentralizator.hashCode());
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
		CentralizatorStatSalarii other = (CentralizatorStatSalarii) obj;
		if (idCentralizator == null) {
			if (other.idCentralizator != null)
				return false;
		} else if (!idCentralizator.equals(other.idCentralizator))
			return false;
		return true;
	}
	
}
