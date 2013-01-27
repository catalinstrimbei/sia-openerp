package org.open.erp.services.contabgest;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import org.open.erp.services.personal.Angajat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Analiza implements Serializable{

	
	
	public static final Integer Neinitializata=-1;
	public static final Integer Initializata=0;
	public static final Integer Terminata=1;

    @Id @GeneratedValue
	private Integer IdAnaliza;
    
	private String numeAnaliza;
	@Temporal(TIMESTAMP)
	private Date dataInceput;
	@Temporal(TIMESTAMP)
	private Date dataSfarsit;
	@ManyToOne
	private Angajat responsabil;

	private Double procentRealizare;
	
	@OneToMany(mappedBy = "analiza", 
			targetEntity = Calculatii.class, 
			cascade = ALL)
	private List<Calculatii> calculatii = new ArrayList<Calculatii>();

	public Integer getIdAnaliza() {
		return IdAnaliza;
	}

	public void setIdAnaliza(Integer idAnaliza) {
		IdAnaliza = idAnaliza;
	}

	public String getNumeAnaliza() {
		return numeAnaliza;
	}

	public void setNumeAnaliza(String numeAnaliza) {
		this.numeAnaliza = numeAnaliza;
	}

	public Date getDataInceput() {
		return dataInceput;
	}

	public void setDataInceput(Date dataInceput) {
		this.dataInceput = dataInceput;
	}

	public Date getDataSfarsit() {
		return dataSfarsit;
	}

	public void setDataSfarsit(Date dataSfarsit) {
		this.dataSfarsit = dataSfarsit;
	}

	public Angajat getResponsabil() {
		return responsabil;
	}

	public void setResponsabil(Angajat responsabil) {
		this.responsabil = responsabil;
	}

	public Double getProcentRealizare() {
		return procentRealizare;
	}

	public void setProcentRealizare(Double procentRealizare) {
		this.procentRealizare = procentRealizare;
	}

	public List<Calculatii> getCalculatii() {
		return calculatii;
	}

	public void setCalculatii(List<Calculatii> calculatii) {
		this.calculatii = calculatii;
	}

	public static Integer getNeinitializata() {
		return Neinitializata;
	}

	public static Integer getInitializata() {
		return Initializata;
	}

	public static Integer getTerminata() {
		return Terminata;
	}
	public Analiza() {
		super();
	}

	public Analiza(Integer idAnaliza, String numeAnaliza, Date dataInceput,
			Date dataSfarsit, Angajat responsabil, Double procentRealizare,
			List<Calculatii> calculatii) {
		super();
		IdAnaliza = idAnaliza;
		this.numeAnaliza = numeAnaliza;
		this.dataInceput = dataInceput;
		this.dataSfarsit = dataSfarsit;
		this.responsabil = responsabil;
		this.procentRealizare = procentRealizare;
		this.calculatii = calculatii;
	}
	public Analiza(Integer idAnaliza, String numeAnaliza, Date dataInceput,
			Date dataSfarsit, Double procentRealizare,
			List<Calculatii> calculatii) {
		super();
		IdAnaliza = idAnaliza;
		this.numeAnaliza = numeAnaliza;
		this.dataInceput = dataInceput;
		this.dataSfarsit = dataSfarsit;
		//this.responsabil = responsabil;
		this.procentRealizare = procentRealizare;
		this.calculatii = calculatii;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((IdAnaliza == null) ? 0 : IdAnaliza.hashCode());
		result = prime * result
				+ ((calculatii == null) ? 0 : calculatii.hashCode());
		result = prime * result
				+ ((dataInceput == null) ? 0 : dataInceput.hashCode());
		result = prime * result
				+ ((dataSfarsit == null) ? 0 : dataSfarsit.hashCode());
		result = prime * result
				+ ((numeAnaliza == null) ? 0 : numeAnaliza.hashCode());
		result = prime
				* result
				+ ((procentRealizare == null) ? 0 : procentRealizare.hashCode());
		result = prime * result
				+ ((responsabil == null) ? 0 : responsabil.hashCode());
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
		Analiza other = (Analiza) obj;
		if (IdAnaliza == null) {
			if (other.IdAnaliza != null)
				return false;
		} else if (!IdAnaliza.equals(other.IdAnaliza))
			return false;
		if (calculatii == null) {
			if (other.calculatii != null)
				return false;
		} else if (!calculatii.equals(other.calculatii))
			return false;
		if (dataInceput == null) {
			if (other.dataInceput != null)
				return false;
		} else if (!dataInceput.equals(other.dataInceput))
			return false;
		if (dataSfarsit == null) {
			if (other.dataSfarsit != null)
				return false;
		} else if (!dataSfarsit.equals(other.dataSfarsit))
			return false;
		if (numeAnaliza == null) {
			if (other.numeAnaliza != null)
				return false;
		} else if (!numeAnaliza.equals(other.numeAnaliza))
			return false;
		if (procentRealizare == null) {
			if (other.procentRealizare != null)
				return false;
		} else if (!procentRealizare.equals(other.procentRealizare))
			return false;
		if (responsabil == null) {
			if (other.responsabil != null)
				return false;
		} else if (!responsabil.equals(other.responsabil))
			return false;
		return true;
	}


	
}
