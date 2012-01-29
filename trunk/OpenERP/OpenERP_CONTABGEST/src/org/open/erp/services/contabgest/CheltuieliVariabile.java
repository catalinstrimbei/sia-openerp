package org.open.erp.services.contabgest;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CheltuieliVariabile extends TipCheltuieli implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4487875050557713015L;

	//private Integer idCheltVariabile;
	private String denCheltuialaV;
	private String delatiiCheltuialaV;
	private Integer CantitateCheltuialaV;
	@ManyToOne @JoinColumn(name = "idCentruCost")
	private CentruCost 	centrucost;
	
	/*
	@OneToMany(mappedBy = "cheltuielivariabile", cascade = CascadeType.ALL)
	private Collection<TipCheltuieli> 	tipCheltuieli;
	*/
	
	//@OneToMany(mappedBy = "cheltuieliVariabile", cascade = CascadeType.ALL)
	//private Collection<CentruCost> centrucost;

	public CheltuieliVariabile() {
		super();
	}

	public CheltuieliVariabile(String denCheltuialaV,
			String delatiiCheltuialaV, Integer cantitateCheltuialaV) {
		super();
		//this.idCheltVariabile = idCheltVariabile;
		this.denCheltuialaV = denCheltuialaV;
		this.delatiiCheltuialaV = delatiiCheltuialaV;
		this.CantitateCheltuialaV = cantitateCheltuialaV;
	
	}

	//public Integer getIdCheltVariabile() {
	//	return idCheltVariabile;
	//}

	//public void setIdCheltVariabile(Integer idCheltVariabile) {
	//	this.idCheltVariabile = idCheltVariabile;
	//}

	public String getDenCheltuialaV() {
		return denCheltuialaV;
	}

	public void setDenCheltuialaV(String denCheltuialaV) {
		this.denCheltuialaV = denCheltuialaV;
	}

	public String getDelatiiCheltuialaV() {
		return delatiiCheltuialaV;
	}

	public Integer getCantitateCheltuialaV() {
		return CantitateCheltuialaV;
	}

	public void setCantitateCheltuialaV(Integer cantitateCheltuialaV) {
		CantitateCheltuialaV = cantitateCheltuialaV;
	}

	

	
	
	
}
