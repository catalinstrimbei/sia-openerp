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
public class CheltuieliFixe extends TipCheltuieli implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3625117143467117943L;

	//private Integer idCheltFix;
	private String denCheltuiala;
	private String delatiiCheltuiala;
	@ManyToOne @JoinColumn(name = "idCentruCost")
	private CentruCost 	centrucost;
	
/*
	@OneToMany(mappedBy = "cheltuielifixe", cascade = CascadeType.ALL)
	private Collection<TipCheltuieli> 	tipCheltuieli;
	*/
	
	//@OneToMany(mappedBy = "cheltuieliFixe", cascade = CascadeType.ALL)
	//private Collection<CentruCost> centrucost;
	

	public CheltuieliFixe() {
		super();
	}

	public CheltuieliFixe(String denCheltuiala,
			String delatiiCheltuiala) {
		super();
		//this.idCheltFix = idCheltFix;
		this.denCheltuiala = denCheltuiala;
		this.delatiiCheltuiala = delatiiCheltuiala;
	
	}
	
	public CheltuieliFixe(String denCheltuiala, String delatiiCheltuiala,
			CentruCost centrucost) {
		super();
		this.denCheltuiala = denCheltuiala;
		this.delatiiCheltuiala = delatiiCheltuiala;
		this.centrucost = centrucost;
	}

	//public Integer getIdCheltFix() {
		//return idCheltFix;
	//}

	//public void setIdCheltFix(Integer idCheltFix) {
		//this.idCheltFix = idCheltFix;
	//}

	public String getDenCheltuiala() {
		return denCheltuiala;
	}

	public void setDenCheltuiala(String denCheltuiala) {
		this.denCheltuiala = denCheltuiala;
	}

	public String getDelatiiCheltuiala() {
		return delatiiCheltuiala;
	}

	public void setDelatiiCheltuiala(String delatiiCheltuiala) {
		this.delatiiCheltuiala = delatiiCheltuiala;
	}

	
	public CheltuieliFixe(Integer 	idTipCheltuieli, String tipCheltuieli) {
		super(idTipCheltuieli, tipCheltuieli);
	}

	public CentruCost getCentrucost() {
		return centrucost;
	}

	public void setCentrucost(CentruCost centrucost) {
		this.centrucost = centrucost;
	}
	
	


	
	

}
