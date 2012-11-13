package org.open.erp.services.proman;

import java.util.Date;

import org.open.erp.services.buget.LinieBugetara;

/**
 * 
 * @author catalin.strimbei
 * 
 * @BusinessObject(Entity)
 * 
 */
public class ActivitateBugetata  extends LinieBugetara implements Activitate{
	private Proiect proiect;
	
	private String titulatura;

	private Date dataStart;

	private Date dataSfarsit;
	
	private Integer status = NE_PORNITA;  //NOT_STARTED, IN_PROGRESS, COMPLET, AMANAT, SUSPENDAT/IN_ASTEPTARE 

	private Responsabil responsabil; // persoanaAsignata

	private Date dataActualizare;
	private Double procentRealizare = 0.0;
	
	//:: prioritate, cost, costTimp, descriere

	@Override
	public Double getProcentRealizare() {
		return procentRealizare;
	}
	
	public void setProcentRealizare(Double procentRealizare) {
		this.procentRealizare = procentRealizare;
	}

	@Override
	public Date getDataActualizare() {
		return dataActualizare;
	}

	@Override
	public void setDataActualizare(Date dataActualizare) {
		this.dataActualizare = dataActualizare;
	}

	@Override
	public Proiect getProiect() {
		return proiect;
	}

	@Override
	public void setProiect(Proiect proiect) {
		this.proiect = proiect;
		this.setBuget(proiect.getBuget());
	}

	@Override
	public Integer getIdActivitate() {
		return id;
	}

	@Override
	public void setIdActivitate(Integer idActivitate) {
		this.id = idActivitate;
	}

	@Override
	public String getTitulatura() {
		return titulatura;
	}

	@Override
	public void setTitulatura(String titulatura) {
		this.titulatura = titulatura;
	}

	@Override
	public Date getDataStart() {
		return dataStart;
	}

	@Override
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}

	@Override
	public Date getDataSfarsit() {
		return dataSfarsit;
	}

	@Override
	public void setDataSfarsit(Date dataSfarsit) {
		this.dataSfarsit = dataSfarsit;
	}

	@Override
	public Double getValoareBugetata() {
		return valoareBugetata;
	}

	@Override
	public void setValoareBugetata(Double valoareBugetata) {
		this.valoareBugetata = valoareBugetata;
	}

	@Override
	public Integer getStatus() {
		return status;
	}

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
