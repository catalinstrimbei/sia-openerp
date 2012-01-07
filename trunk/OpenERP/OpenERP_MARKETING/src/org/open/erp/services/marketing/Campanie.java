package org.open.erp.services.marketing;
/*
 * test2
 * test MR
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
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
	public static final Integer NE_PORNITA = -1; 
	public static final Integer IN_CURS = 1;
	public static final Integer TERMINATA = 2; 
	
	@Id @GeneratedValue
	private Integer idCampanie;
	private String denumireCampanie;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataStart;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataSfarsit;
	private Integer status = NE_PORNITA;
	@ManyToOne @JoinColumn(name = "idPersoana")
	Responsabil responsabil;
	@OneToMany @JoinTable(
			name = "PersoanaTinta", joinColumns = @JoinColumn(name="idCampanie"), inverseJoinColumns = @JoinColumn(name="idPersoana"))
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
	}
