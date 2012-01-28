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

	private Integer idCheltFix;
	private String denCheltuiala;
	private String delatiiCheltuiala;
	
/*
	@OneToMany(mappedBy = "cheltuielifixe", cascade = CascadeType.ALL)
	private Collection<TipCheltuieli> 	tipCheltuieli;
	*/
	
	@OneToMany(mappedBy = "cheltuieliFixe", cascade = CascadeType.ALL)
	private Collection<CentruCost> centrucost;

	public CheltuieliFixe() {
		super();
	}

	public CheltuieliFixe(Integer idCheltFix, String denCheltuiala,
			String delatiiCheltuiala) {
		super();
		this.idCheltFix = idCheltFix;
		this.denCheltuiala = denCheltuiala;
		this.delatiiCheltuiala = delatiiCheltuiala;
	
	}

	public Integer getIdCheltFix() {
		return idCheltFix;
	}

	public void setIdCheltFix(Integer idCheltFix) {
		this.idCheltFix = idCheltFix;
	}

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


	
	

}
