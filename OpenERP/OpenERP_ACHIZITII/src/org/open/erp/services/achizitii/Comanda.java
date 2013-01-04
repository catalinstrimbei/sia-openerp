package org.open.erp.services.achizitii;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comanda implements Serializable{
	@Id @GeneratedValue
	private Integer nrComanda;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataComanda;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataReceptionare; //cand vrem noi sa primim bunurile
	
	@ManyToOne
	private Furnizori funrizor;
	
	@OneToMany
	private List<LiniiComanda> linieComanda;
	private Double valoareTotala;
	
	
	public Integer getNrComanda() {
		return nrComanda;
	}
	public void setNrComanda(Integer nrComanda) {
		this.nrComanda = nrComanda;
	}
	public Date getDataComanda() {
		return dataComanda;
	}
	public void setDataComanda(Date dataComanda) {
		this.dataComanda = dataComanda;
	}
	public Date getDataReceptionare() {
		return dataReceptionare;
	}
	public void setDataReceptionare(Date dataReceptionare) {
		this.dataReceptionare = dataReceptionare;
	}
	public Furnizori getFunrizor() {
		return funrizor;
	}
	public void setFunrizor(Furnizori funrizor) {
		this.funrizor = funrizor;
	}
	public List<LiniiComanda> getLinieComanda() {
		return linieComanda;
	}
	public void setLinieComanda(List<LiniiComanda> linieComanda) {
		this.linieComanda = linieComanda;
	}
	public Double getValoareTotala() {
		return valoareTotala;
	}
	public void setValoareTotala(Double valoareTotala) {
		this.valoareTotala = valoareTotala;
	}
	
	public Comanda(Integer nrComanda, Date dataComanda, Date dataReceptionare,
			Furnizori funrizor, List<LiniiComanda> linieComanda,
			Double valoareTotala) {
		super();
		this.nrComanda = nrComanda;
		this.dataComanda = dataComanda;
		this.dataReceptionare = dataReceptionare;
		this.funrizor = funrizor;
		this.linieComanda = linieComanda;
		this.valoareTotala = valoareTotala;
	}
	
	public Comanda() {
		super();
	}

	public Comanda(Integer nrComanda, Date dataComanda, Furnizori funrizor,
			Double valoareTotalaComanda) {
		super();
		this.nrComanda = nrComanda;
		this.dataComanda = dataComanda;
		this.funrizor = funrizor;
		this.valoareTotala = valoareTotala;
	}
	
	public void adaugaLinieComanda(LiniiComanda linie){
		this.linieComanda.add(linie);
	}
	
}
