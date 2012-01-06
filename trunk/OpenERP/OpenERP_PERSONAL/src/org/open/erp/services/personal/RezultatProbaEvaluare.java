package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class RezultatProbaEvaluare implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer 		id;
	@ManyToOne
	private Angajat			angajat;
	private	String			rezultat;
	private String			observatii;
	@OneToOne
	private ProbaEvaluare	probaEvaluare;
	
	public Angajat getAngajat() {
		return angajat;
	}
	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}
	public String getRezultat() {
		return rezultat;
	}
	public void setRezultat(String rezultat) {
		this.rezultat = rezultat;
	}
	public String getObservatii() {
		return observatii;
	}
	public void setObservatii(String observatii) {
		this.observatii = observatii;
	}
	public ProbaEvaluare getProbaEvaluare() {
		return probaEvaluare;
	}
	public void setProbaEvaluare(ProbaEvaluare probaEvaluare) {
		this.probaEvaluare = probaEvaluare;
	}
	public RezultatProbaEvaluare(Angajat angajat, String rezultat,
			String observatii, ProbaEvaluare probaEvaluare) {
		super();
		this.angajat = angajat;
		this.rezultat = rezultat;
		this.observatii = observatii;
		this.probaEvaluare = probaEvaluare;
	}
	
	public RezultatProbaEvaluare() {
		super();		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
