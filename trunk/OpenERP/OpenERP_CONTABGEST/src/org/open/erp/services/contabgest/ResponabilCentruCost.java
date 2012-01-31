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

@Entity
public class ResponabilCentruCost extends DummyPersoana implements Serializable{
	
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


	
	
	
	public ResponabilCentruCost(String nume, String prenume,
			String formaAdresare) {
		super(nume, prenume, formaAdresare);
		// TODO Auto-generated constructor stub
	}
	
	


	public ResponabilCentruCost(String nume, String prenume,
			String formaAdresare, Integer idResponsabilCentruCost, Date dataStartResponsabilitate,
			Date dataSfarsitResponsabilitate, String detaliiResponsabilitati) {
		super(nume, prenume, formaAdresare);
		this.idResponsabilCentruCost = idResponsabilCentruCost;
		this.dataStartResponsabilitate = dataStartResponsabilitate;
		this.dataSfarsitResponsabilitate = dataSfarsitResponsabilitate;
		this.detaliiResponsabilitati = detaliiResponsabilitati;
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
