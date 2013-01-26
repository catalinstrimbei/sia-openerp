package org.open.erp.services.achizitii;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.New;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class NIR implements Serializable{
	//in Document de la modulul NOMGEN trebuie adaugata 
	//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)  inainte de clasa
	@Id @GeneratedValue
	private Integer nrNIR;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@ManyToOne
	private Furnizori furnizor;
	
	@OneToMany(mappedBy = "nir", 
			targetEntity = LiniiNIR.class, 
			cascade = ALL)
	private List<LiniiNIR> linieNir;
	private Double valoareTotala;
		
	public Integer getNrNIR() {
		return nrNIR;
	}
	public void setNrNIR(Integer nrNIR) {
		this.nrNIR = nrNIR;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Furnizori getFunrizor() {
		return furnizor;
	}
	public void setFunrizor(Furnizori furnizor) {
		this.furnizor = furnizor;
	}
	public List<LiniiNIR> getLinieNir() {
		return linieNir;
	}
	public void setLinieNir(List<LiniiNIR> linieNir) {
		this.linieNir = linieNir;
	}
	public Double getValoareTotala() {
		return valoareTotala;
	}
	public void setValoareTotala(Double valoareTotala) {
		this.valoareTotala = valoareTotala;
	}
	public NIR(Integer nrNIR, Date data, Furnizori furnizor,
			List<LiniiNIR> linieNir, Double valoareTotala) {
		super();
		this.nrNIR = nrNIR;
		this.data = data;
		this.furnizor = furnizor;
		this.linieNir = linieNir;
		this.valoareTotala = valoareTotala;
	}
		
	public NIR() {
		super();
	}
	public NIR(Integer nrNIR, Date data, Furnizori furnizor,
			Double valoareTotala) {
		super();
		this.nrNIR = nrNIR;
		this.data = data;
		this.furnizor = furnizor;
		this.valoareTotala = valoareTotala;
	}

}
