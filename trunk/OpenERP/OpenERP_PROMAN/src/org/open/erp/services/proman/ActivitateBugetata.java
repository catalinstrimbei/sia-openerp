package org.open.erp.services.proman;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

import org.open.erp.services.buget.LinieBugetara;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REFRESH;
/**
 * 
 * @author catalin.strimbei
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class ActivitateBugetata  extends LinieBugetara implements Serializable, Activitate{
	//@Id @GeneratedValue
	//private Integer idActivitate;
	
	@ManyToOne
	private Proiect proiect;
	
	private String titulatura;
	
	@Temporal(TIMESTAMP)
	private Date dataStart;
	
	@Temporal(TIMESTAMP)
	private Date dataSfarsit;
	
	//private Double valoareBugetata;
	
	private Integer status = NE_PORNITA;  //NOT_STARTED, IN_PROGRESS, COMPLET, AMANAT, SUSPENDAT/IN_ASTEPTARE 
	
	@ManyToOne
	private Responsabil responsabil; // persoanaAsignata
	
	
	@Temporal(TIMESTAMP)
	private Date dataActualizare;
	private Double procentRealizare = 0.0;
	
	//:: prioritate, cost, costTimp, descriere
	
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#getProcentRealizare()
	 */
	@Override
	public Double getProcentRealizare() {
		return procentRealizare;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#setProcentRealizare(java.lang.Double)
	 */
	@Override
	public void setProcentRealizare(Double procentRealizare) {
		this.procentRealizare = procentRealizare;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#getDataActualizare()
	 */
	@Override
	public Date getDataActualizare() {
		return dataActualizare;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#setDataActualizare(java.util.Date)
	 */
	@Override
	public void setDataActualizare(Date dataActualizare) {
		this.dataActualizare = dataActualizare;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#getProiect()
	 */
	@Override
	public Proiect getProiect() {
		return proiect;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#setProiect(org.open.erp.services.proman.Proiect)
	 */
	@Override
	public void setProiect(Proiect proiect) {
		this.proiect = proiect;
		this.setBuget(proiect.getBuget());
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#getIdActivitate()
	 */
	@Override
	public Integer getIdActivitate() {
		//return idActivitate;
		return id;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#setIdActivitate(java.lang.Integer)
	 */
	@Override
	public void setIdActivitate(Integer idActivitate) {
		//this.idActivitate = idActivitate;
		this.id = idActivitate;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#getTitulatura()
	 */
	@Override
	public String getTitulatura() {
		return titulatura;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#setTitulatura(java.lang.String)
	 */
	@Override
	public void setTitulatura(String titulatura) {
		this.titulatura = titulatura;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#getDataStart()
	 */
	@Override
	public Date getDataStart() {
		return dataStart;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#setDataStart(java.util.Date)
	 */
	@Override
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#getDataSfarsit()
	 */
	@Override
	public Date getDataSfarsit() {
		return dataSfarsit;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#setDataSfarsit(java.util.Date)
	 */
	@Override
	public void setDataSfarsit(Date dataSfarsit) {
		this.dataSfarsit = dataSfarsit;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#getValoareBugetata()
	 */
	@Override
	public Double getValoareBugetata() {
		return valoareBugetata;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#setValoareBugetata(java.lang.Double)
	 */
	@Override
	public void setValoareBugetata(Double valoareBugetata) {
		this.valoareBugetata = valoareBugetata;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#getStatus()
	 */
	@Override
	public Integer getStatus() {
		return status;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#setStatus(java.lang.Integer)
	 */
	@Override
	public void setStatus(Integer status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#getResponsabil()
	 */
	@Override
	public Responsabil getResponsabil() {
		return responsabil;
	}
	/* (non-Javadoc)
	 * @see org.open.erp.services.proman.Activitate#setResponsabil(org.open.erp.services.proman.Responsabil)
	 */
	@Override
	public void setResponsabil(Responsabil responsabil) {
		this.responsabil = responsabil;
	}
	
//	public ActivitateBugetata(Integer idActivitate, String titulatura, Date dataStart,
//			Date dataSfarsit, Double valoareBugetata, 
//			Responsabil responsabil) {
//		super();
//		this.id = idActivitate;
//		this.titulatura = titulatura;
//		this.dataStart = dataStart;
//		this.dataSfarsit = dataSfarsit;
//		this.valoareBugetata = valoareBugetata;
//		this.responsabil = responsabil;
//	}
	
	public ActivitateBugetata(String titulatura, Date dataStart,
			Date dataSfarsit, Double valoareBugetata, 
			Responsabil responsabil) {
		super();
		this.titulatura = titulatura;
		this.dataStart = dataStart;
		this.dataSfarsit = dataSfarsit;
		this.valoareBugetata = valoareBugetata;
		this.responsabil = responsabil;
	}	
	
	public ActivitateBugetata() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
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
		ActivitateBugetata other = (ActivitateBugetata) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
	
	
}
