package org.open.erp.services.contabgest;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class DummyFazaProductie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8939858069089042223L;

	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idFazaProductie;
	private String denumireFazaProductie;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date incepereFazaProductie;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date sfarsitFazaProductie;
	private double costFazaProductie;

	@OneToMany(mappedBy = "dummyFazaProductie", cascade = CascadeType.ALL)
	private Collection<CentruCost> centrucost;
	
	public DummyFazaProductie() {
	
	}
	public DummyFazaProductie(Integer idFazaProductie,
			String denumireFazaProductie, Date incepereFazaProductie,
			Date sfarsitFazaProductie, double costFazaProductie) {
		super();
		this.idFazaProductie = idFazaProductie;
		this.denumireFazaProductie = denumireFazaProductie;
		this.incepereFazaProductie = incepereFazaProductie;
		this.sfarsitFazaProductie = sfarsitFazaProductie;
		this.costFazaProductie = costFazaProductie;
	}
	public Integer getIdFazaProductie() {
		return idFazaProductie;
	}
	public void setIdFazaProductie(Integer idFazaProductie) {
		this.idFazaProductie = idFazaProductie;
	}
	public String getDenumireFazaProductie() {
		return denumireFazaProductie;
	}
	public void setDenumireFazaProductie(String denumireFazaProductie) {
		this.denumireFazaProductie = denumireFazaProductie;
	}
	public Date getIncepereFazaProductie() {
		return incepereFazaProductie;
	}
	public void setIncepereFazaProductie(Date incepereFazaProductie) {
		this.incepereFazaProductie = incepereFazaProductie;
	}
	public Date getSfarsitFazaProductie() {
		return sfarsitFazaProductie;
	}
	public void setSfarsitFazaProductie(Date sfarsitFazaProductie) {
		this.sfarsitFazaProductie = sfarsitFazaProductie;
	}
	public double getCostFazaProductie() {
		return costFazaProductie;
	}
	public void setCostFazaProductie(double costFazaProductie) {
		this.costFazaProductie = costFazaProductie;
	}
	
	
	
}
