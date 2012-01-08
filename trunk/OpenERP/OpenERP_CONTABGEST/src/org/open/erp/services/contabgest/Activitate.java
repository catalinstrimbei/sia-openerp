package org.open.erp.services.contabgest;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.productie.FazaProductie;

/**
 * 
 * @author andreea.andronic, marius.borsan, andreea.zaharia, anca.zavate
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class Activitate implements Serializable {

	public static final Integer NE_PORNITA = -1;
	public static final Integer IN_CURS = 1;
	public static final Integer TERMINATA = 2;

	@Id
	@GeneratedValue
	private Integer idActivitate;
	private String denumireActivitate;
	private Date dataStart;
	private Date dataStop;
	private FazaProductie faza;
	private Double costActivitate;
	private Integer status = NE_PORNITA;
	private Angajat responsabil;
	private CentruCost centruCost;
	private Date dataActualizare;
	private Double procentRealizare = 0.0;

	public Activitate(Integer idActivitate, FazaProductie faza,
			String denumireActivitate, Date dataStart, Date dataStop,
			Double costActivitate, Angajat responsabil) {
		super();
		this.idActivitate = idActivitate;
		this.denumireActivitate = denumireActivitate;
		this.dataStart = dataStart;
		this.dataStop = dataStop;
		this.costActivitate = costActivitate;
		this.responsabil = responsabil;
	}

	public Activitate(Integer idActivitate, String denumireActivitate,
			Date dataStart, Date dataStop, Double costActivitate,
			Integer status, Angajat responsabil, CentruCost centruCost,
			Date dataActualizare, Double procentRealizare) {
		super();
		this.idActivitate = idActivitate;
		this.denumireActivitate = denumireActivitate;
		this.dataStart = dataStart;
		this.dataStop = dataStop;
		this.costActivitate = costActivitate;
		this.status = status;
		this.responsabil = responsabil;
		this.centruCost = centruCost;
		this.dataActualizare = dataActualizare;
		this.procentRealizare = procentRealizare;
	}

	public Integer getIdActivitate() {
		return idActivitate;
	}

	public String getDenumireActivitate() {
		return denumireActivitate;
	}

	public Date getDataStart() {
		return dataStart;
	}

	public Date getDataStop() {
		return dataStop;
	}

	public Double getCostActivitate() {
		return costActivitate;
	}

	public Integer getStatus() {
		return status;
	}

	public Angajat getResponsabil() {
		return responsabil;
	}

	public CentruCost getCentruCost() {
		return centruCost;
	}

	public Date getDataActualizare() {
		return dataActualizare;
	}

	public Double getProcentRealizare() {
		return procentRealizare;
	}

	public static Integer getNePornita() {
		return NE_PORNITA;
	}

	public static Integer getInCurs() {
		return IN_CURS;
	}

	public void setIdActivitate(Integer idActivitate) {
		this.idActivitate = idActivitate;
	}

	public void setDenumireActivitate(String denumireActivitate) {
		this.denumireActivitate = denumireActivitate;
	}

	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}

	public void setDataStop(Date dataStop) {
		this.dataStop = dataStop;
	}

	public void setCostActivitate(Double costActivitate) {
		this.costActivitate = costActivitate;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setResponsabil(Angajat responsabil) {
		this.responsabil = responsabil;
	}

	public void setCentruCost(CentruCost centruCost) {
		this.centruCost = centruCost;
	}

	public void setDataActualizare(Date dataActualizare) {
		this.dataActualizare = dataActualizare;
	}

	public void setProcentRealizare(Double procentRealizare) {
		this.procentRealizare = procentRealizare;
	}

	public static Integer getTerminata() {
		return TERMINATA;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idActivitate == null) ? 0 : idActivitate.hashCode());
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
		Activitate other = (Activitate) obj;
		if (idActivitate == null) {
			if (other.idActivitate != null)
				return false;
		} else if (!idActivitate.equals(other.idActivitate))
			return false;
		return true;
	}

}
