package org.open.erp.services.contabgest;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class TipCheltuieli implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4754127791272970660L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer 	idTipCheltuieli;
	protected String tipCheltuieli;
	
	/*
	@ManyToOne @JoinColumn(name = "idCheltFix")
	private CheltuieliFixe 	cheltuielifixe;
	
	@ManyToOne @JoinColumn(name = "idCheltFix")
	private CheltuieliVariabile 	cheltuielivariabile;
	
	*/
	
	

	public TipCheltuieli() {
		
	}
	public TipCheltuieli(String tipCheltuieli) {
		super();
		this.tipCheltuieli = tipCheltuieli;
	}
	public TipCheltuieli(Integer idTipCheltuieli, String tipCheltuieli) {
		super();
		this.idTipCheltuieli = idTipCheltuieli;
		this.tipCheltuieli = tipCheltuieli;
	}
	public Integer getIdTipCheltuieli() {
		return idTipCheltuieli;
	}
	public void setIdTipCheltuieli(Integer idTipCheltuieli) {
		this.idTipCheltuieli = idTipCheltuieli;
	}
	public String getTipCheltuieli() {
		return tipCheltuieli;
	}
	public void setTipCheltuieli(String tipCheltuieli) {
		this.tipCheltuieli = tipCheltuieli;
	}
	
	

}
