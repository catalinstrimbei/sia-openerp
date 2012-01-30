package org.open.erp.services.marketing;
/*
 * test2
 * test MR
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


/**
 * 
 * @author Echipa.Marketing
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public  class Campanie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Integer NE_PORNITA =1; 
	public static final Integer IN_CURS = 2;
	public static final Integer TERMINATA = 3; 
	
	@Id @GeneratedValue
	private Integer idCampanie;
	private String denumireCampanie;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataStart;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataSfarsit;
	private Integer status = NE_PORNITA;
	@ManyToOne @JoinColumn(name = "idResponsabil")
	Responsabil responsabil;
	@OneToMany(mappedBy = "campanie",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<PersoanaTinta> PersoaneTinta;

	public Campanie() {
		super();
	}
	public Campanie(Integer idCampanie, String denumireCampanie, Date dataStart, Date dataSfarsit,
		 Responsabil responsabil)
		{
			super();
			this.idCampanie = idCampanie;
			this.denumireCampanie = denumireCampanie;
			this.dataStart = dataStart;
			this.dataSfarsit = dataSfarsit;
			this.responsabil = responsabil;
		}
	public Campanie(int i, String nume, Date dataStart2, Date dataSfarsit2) {
		super();
		this.idCampanie = i;
		this.denumireCampanie = nume;
		this.dataStart = dataStart2;
		this.dataSfarsit = dataSfarsit2;
	}
	public Date getDataSfarsit() {
		return dataSfarsit;
	}
	public Date getDataStart() {
		return dataStart;
	}
	public String getDenumireCampanie() {
		return denumireCampanie;
	}
	public Integer getStatus() {
		return status;
	}
	public Integer getIdCampanie() {
		return idCampanie;
	}
	public Responsabil getResponsabil() {
		return responsabil;
	}
	public static Integer getTerminat() {
		return TERMINATA;
	}
	public static Integer getNePornita() {
		return NE_PORNITA;
	}
	public static Integer getInCurs() {
		return IN_CURS;
	}
	public void setResponsabil(Responsabil responsabil) {
		this.responsabil = responsabil;
	}
	public void setIdCampanie(Integer idCampanie) {
		this.idCampanie = idCampanie;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}
	public void setDataSfarsit(Date dataSfarsit) {
		this.dataSfarsit = dataSfarsit;
	}
	public void setDenumireCampanie(String denumireCampanie) {
		this.denumireCampanie = denumireCampanie;
	}
	/**
	 * @return the persoaneTinta
	 */
	public List<PersoanaTinta> getPersoaneTinta() {
		return PersoaneTinta;
	}
	/**
	 * @param persoaneTinta the persoaneTinta to set
	 */
	public void setPersoaneTinta(List<PersoanaTinta> persoaneTinta) {
		PersoaneTinta = persoaneTinta;
	}
	/**
	 * @param Persoana tinta care se doreste a fi adaugata
	 */
	public void adaugaPersoaneTinta(PersoanaTinta persoanaTinta){
		this.PersoaneTinta.add(persoanaTinta);
	}
	public void stergePersoaneTinta(PersoanaTinta persoanaTinta){
		this.PersoaneTinta.remove(persoanaTinta);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCampanie == null) ? 0 : idCampanie.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campanie other = (Campanie) obj;
		if (idCampanie == null) {
			if (other.idCampanie != null)
				return false;
		} else if (!idCampanie.equals(other.idCampanie))
			return false;
		return true;
	}
	
	}
