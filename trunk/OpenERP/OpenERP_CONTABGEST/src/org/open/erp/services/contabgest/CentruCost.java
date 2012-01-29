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
import javax.persistence.Temporal;


@Entity
public class CentruCost implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCentruCost;
	private String denCentruCost;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date startCentruCost;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date sfarsitCentruCost;
	
	@ManyToOne @JoinColumn(name = "idResponsabilCentruCost")
	private ResponabilCentruCost responabilCentruCost;
	
	@ManyToOne @JoinColumn(name = "idFazaProductie")
	private DummyFazaProductie dummyFazaProductie;

	@ManyToOne @JoinColumn(name = "idProces")
	private ProceseTehnicoEconomice proceseTehnicoEconomice;
	
	@ManyToOne @JoinColumn(name = "idProdusFinit")
	private ProdusFinit produsfinit;
	
	@OneToMany(mappedBy = "centrucost", cascade = CascadeType.ALL)
	private Collection<CheltuieliVariabile> 	cheltuieliVariabile;
	
	@OneToMany(mappedBy = "centrucost", cascade = CascadeType.ALL)
	private Collection<CheltuieliFixe> 	cheltuieliFixe;
	
	//@ManyToOne @JoinColumn(name = "idCheltVariabile")
	//private CheltuieliVariabile cheltuieliVariabile;
	
	//@ManyToOne @JoinColumn(name = "idCheltFix")
	//private CheltuieliFixe cheltuieliFixe;
	
	

	public CentruCost() {
		super();
	}



	public CentruCost(Integer idCentruCost, String denCentruCost,
			Date startCentruCost, Date sfarsitCentruCost) {
		super();
		this.idCentruCost = idCentruCost;
		this.denCentruCost = denCentruCost;
		this.startCentruCost = startCentruCost;
		this.sfarsitCentruCost = sfarsitCentruCost;
	}



	public Integer getIdCentruCost() {
		return idCentruCost;
	}

	public void setIdCentruCost(Integer idCentruCost) {
		this.idCentruCost = idCentruCost;
	}

	public String getDenCentruCost() {
		return denCentruCost;
	}

	public void setDenCentruCost(String denCentruCost) {
		this.denCentruCost = denCentruCost;
	}

	public Date getStartCentruCost() {
		return startCentruCost;
	}

	public void setStartCentruCost(Date startCentruCost) {
		this.startCentruCost = startCentruCost;
	}

	public Date getSfarsitCentruCost() {
		return sfarsitCentruCost;
	}

	public void setSfarsitCentruCost(Date sfarsitCentruCost) {
		this.sfarsitCentruCost = sfarsitCentruCost;
	}



	


	



	



	


	
	
}
