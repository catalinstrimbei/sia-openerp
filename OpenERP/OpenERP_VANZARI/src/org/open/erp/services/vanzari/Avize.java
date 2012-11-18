package org.open.erp.services.vanzari;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Avize {

	Integer idAviz;
	Date data;
	Responsabil responsabil;
	Comenzi comanda;
	List<LiniiAviz> liniiAviz=new ArrayList<LiniiAviz>();
	public Integer getIdAviz() {
		return idAviz;
	}
	public void setIdAviz(Integer idAviz) {
		this.idAviz = idAviz;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Responsabil getResponsabil() {
		return responsabil;
	}
	public void setResponsabil(Responsabil responsabil) {
		this.responsabil = responsabil;
	}
	public Comenzi getComanda() {
		return comanda;
	}
	public void setComanda(Comenzi comanda) {
		this.comanda = comanda;
	}
	public List<LiniiAviz> getLiniiAviz() {
		return liniiAviz;
	}
	public void setLiniiAviz(List<LiniiAviz> liniiAviz) {
		this.liniiAviz = liniiAviz;
	}
	public Avize(Integer idAviz, Date data, Responsabil responsabil,
			Comenzi comanda, List<LiniiAviz> liniiAviz) {
		super();
		this.idAviz = idAviz;
		this.data = data;
		this.responsabil = responsabil;
		this.comanda = comanda;
		this.liniiAviz = liniiAviz;
	}
	
	public Double getValoareAviz(){
		
		Double valoare = 0.0;
		for (LiniiAviz linie: liniiAviz){
			valoare = valoare + linie.valoareLinieAviz();
		}
		
		return valoare;
	}


public void adaugaLinieAviz( LiniiAviz linieAviz){
	
	this.liniiAviz.add(linieAviz);
}

	
}
