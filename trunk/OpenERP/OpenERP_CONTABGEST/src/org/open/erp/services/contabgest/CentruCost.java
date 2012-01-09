package org.open.erp.services.contabgest;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.CascadeType;


import org.open.erp.services.productie.FazaProductie;

/**
 * 
 * @author andreea.andronic, marius.borsan, andreea.zaharia, anca.zavate
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class CentruCost implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer idCentruCost;
	
	private String denumireCentruCost;
	private FazaProductie faza;
	
	@Temporal(TIMESTAMP)
	private Date dataStart = new Date();
	
	@Temporal(TIMESTAMP)
	private Date dataSfarsit;
	
	private Double sumaCentruCost;
	
	private Integer status = CentruCost.IN_ALOCARE;
	
	@ManyToOne
	private Responsabil responsabil;
	
	// Costuri primare
	@ManyToOne
	private CosturiPrimare costuriPrimare;
	
	@OneToMany (mappedBy = "centruCost", targetEntity = ActivitateCentruCost.class, cascade=ALL)
	List <Activitate> activitati = new ArrayList<Activitate>();

	


	
	public static final Integer IN_ALOCARE = -1;
	public static final Integer ALOCAT = 0;
	public static final Integer IN_CURS = 1;
	public static final Integer FINALIZAT = 2;

	//

	public CentruCost() {
		super();
	}

	public CentruCost(Integer idCentruCost, String denumireCentruCost,
			FazaProductie faza, Date dataStart, Date dataSfarsit,
			Double sumaCentruCost, Integer status, Responsabil responsabil,
			CosturiPrimare costuriPrimare, List<Activitate> activitati) {
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
	
	

	public CentruCost(Integer idCentruCost, String denumireCentruCost,
			Date dataStart, Date dataSfarsit, Double sumaCentruCost,
			Responsabil responsabil) {
		super();
		this.idCentruCost = idCentruCost;
		this.denumireCentruCost = denumireCentruCost;
		this.dataStart = dataStart;
		this.dataSfarsit = dataSfarsit;
		this.sumaCentruCost = sumaCentruCost;
		this.responsabil = responsabil;
	}

	
	public CentruCost(String denumireCentruCost, FazaProductie faza,
			Date dataStart, Date dataSfarsit, Double sumaCentruCost,
			Responsabil responsabil) {
		super();
		this.denumireCentruCost = denumireCentruCost;
		this.faza = faza;
		this.dataStart = dataStart;
		this.dataSfarsit = dataSfarsit;
		this.sumaCentruCost = sumaCentruCost;
		this.responsabil = responsabil;
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

	public Responsabil getResponsabil() {
		return responsabil;
	}

	public void setResponsabil(Responsabil responsabil) {
		this.responsabil = responsabil;
	}

	public CosturiPrimare getCosturiPrimare() {
		return costuriPrimare;
	}

	public void setCosturiPrimare(CosturiPrimare costuriPrimare) {
		this.costuriPrimare = costuriPrimare;
	}

	public List<Activitate> getActivitati() {
		return activitati;
	}

	public FazaProductie getFaza() {
		return faza;
	}

	public void setFaza(FazaProductie faza) {
		this.faza = faza;
	}

	//public void setActivitati(Map<Activitate, LinieCost> activitati) {
	//	this.activitati = activitati;
	//}

	public void adaugaActivitate(Activitate activitate) {
		this.activitati.add(activitate);
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCentruCost == null) ? 0 : idCentruCost.hashCode());
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
		CentruCost other = (CentruCost) obj;
		if (idCentruCost == null) {
			if (other.idCentruCost != null)
				return false;
		} else if (!idCentruCost.equals(other.idCentruCost))
			return false;
		return true;
	}

}
