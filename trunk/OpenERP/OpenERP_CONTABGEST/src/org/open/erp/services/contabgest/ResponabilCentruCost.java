package org.open.erp.services.contabgest;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

import org.open.erp.services.personal.Angajat;



@Entity
public class ResponabilCentruCost extends Angajat implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7694921212251738138L;
	

	private Integer idResponsabilCentruCost;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataStartResponsabilitate;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataSfarsitResponsabilitate;
	private String detaliiResponsabilitati;
	

	@OneToMany(mappedBy = "responabilCentruCost", cascade = CascadeType.ALL)
	private Collection<CentruCost> centrucost;
	

	
	public ResponabilCentruCost() {
		super();
	}


	
	
	
	public Integer getIdResponsabilCentruCost() {
		return idResponsabilCentruCost;
	}
	
	public void setIdResponsabilCentruCost(Integer idResponsabilCentruCost) {
		this.idResponsabilCentruCost = idResponsabilCentruCost;
	}
	public Date getDataStartResponsabilitate() {
		return dataStartResponsabilitate;
	}
	public void setDataStartResponsabilitate(Date dataStartResponsabilitate) {
		this.dataStartResponsabilitate = dataStartResponsabilitate;
	}
	public Date getDataSfarsitResponsabilitate() {
		return dataSfarsitResponsabilitate;
	}
	public void setDataSfarsitResponsabilitate(Date dataSfarsitResponsabilitate) {
		this.dataSfarsitResponsabilitate = dataSfarsitResponsabilitate;
	}
	public String getDetaliiResponsabilitati() {
		return detaliiResponsabilitati;
	}
	public void setDetaliiResponsabilitati(String detaliiResponsabilitati) {
		this.detaliiResponsabilitati = detaliiResponsabilitati;
	}
	
	
}
