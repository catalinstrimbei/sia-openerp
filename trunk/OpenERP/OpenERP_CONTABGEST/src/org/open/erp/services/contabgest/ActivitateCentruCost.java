package org.open.erp.services.contabgest;

/**
 * 
 * @author  andronic.andreea, borsan.marius, zaharia.andreea, zavate.anca
 * 
 * @BusinessObject(Entity)
 * 
 */

import  static  javax.persistence.TemporalType.TIMESTAMP;

import  java.io.Serializable;
import  java.util.Date;

import  javax.persistence.Entity;
import  javax.persistence.GeneratedValue;
import  javax.persistence.Id;
import javax.persistence.JoinColumn;
import  javax.persistence.ManyToOne;
import  javax.persistence.Temporal;


import  static  javax.persistence.CascadeType.PERSIST;
import  static  javax.persistence.CascadeType.MERGE;
import  static  javax.persistence.CascadeType.REFRESH;

@Entity
public class ActivitateCentruCost extends LinieCost implements Serializable, Activitate{

	//@Id @GeneratedValue
	//private Integer idActivitate;
	
	@ManyToOne 
    @JoinColumn(name="idCentruCost")
	private CentruCost centruCost;
	
	private String denumire;
	
	@Temporal(TIMESTAMP)
	private Date dataStart;
	
	@Temporal(TIMESTAMP)
	private Date dataSfarsit;
	
	private Integer status = NE_PORNITA;
	
	private Double costActivitate;
	
	@ManyToOne
	private Responsabil responsabil;
	
	@Temporal(TIMESTAMP)
	private Date dataActualizare;
	
	private Double procentRealizare = 0.0;
	
	
	/* public ActivitateCentruCost(CentruCost centruCost, String denumire,
			Date dataStart, Date dataSfarsit, Integer status,
			Double costActivitate, Angajat responsabil, Date dataActualizare,
			Double procentRealizare) {
		super();
		this.centruCost = centruCost;
		this.denumire = denumire;
		this.dataStart = dataStart;
		this.dataSfarsit = dataSfarsit;
		this.status = status;
		this.costActivitate = costActivitate;
		this.responsabil = responsabil;
		this.dataActualizare = dataActualizare;
		this.procentRealizare = procentRealizare;
	}
	 */
	
	
	public ActivitateCentruCost() {
		super();
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((idLinieCost == null) ? 0 : idLinieCost.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivitateCentruCost other = (ActivitateCentruCost) obj;
		if (idLinieCost == null) {
			if (other.idLinieCost != null)
				return false;
		} else if (!idLinieCost.equals(other.idLinieCost))
			return false;
		return true;
	}





	public ActivitateCentruCost(String denumire, Date dataStart,
			Date dataSfarsit, Double costActivitate, Responsabil responsabil) {
		super();
		this.denumire = denumire;
		this.dataStart = dataStart;
		this.dataSfarsit = dataSfarsit;
		this.costActivitate = costActivitate;
		this.responsabil = responsabil;
	}
	
	
	
	
	
	@Override 
	public Double getProcentRealizare(){
		
		return procentRealizare;
		
	}

	public CentruCost getCentruCost() {
		return centruCost;
	}

	public void setCentruCost(CentruCost centruCost) {
		this.centruCost = centruCost;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Responsabil getResponsabil() {
		return responsabil;
	}

	public void setResponsabil(Responsabil responsabil) {
		this.responsabil = responsabil;
	}

	public Date getDataActualizare() {
		return dataActualizare;
	}

	public void setDataActualizare(Date dataActualizare) {
		this.dataActualizare = dataActualizare;
	}

	public void setProcentRealizare(Double procentRealizare) {
		this.procentRealizare = procentRealizare;
	}

	@Override
	public Integer getIdActivitate() {
		//return idActivitate
		return idLinieCost;
	}

	@Override
	public void setIdActivitate(Integer idActivitate) {
		
		this.idLinieCost = idActivitate;
		
		
	}

	@Override
	public Double getCostActivitate() {
		
		return valoareAprovizionareExterna;
	}

	@Override
	public void setCostActivitate(Double costActivitate) {
		
		this.valoareAprovizionareExterna = costActivitate;
		
	}




	
	
}
