package org.open.erp.services.vanzari;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.open.erp.services.personal.Angajat;
import javax.persistence.Id;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;

@Entity
public class Avize {

	@Id @GeneratedValue
	Integer idAviz;
	
	@Temporal(TIMESTAMP)
	Date data;
	
	@OneToOne(targetEntity = org.open.erp.services.personal.Angajat.class)
	Angajat responsabil;
	
	@OneToOne(targetEntity = org.open.erp.services.vanzari.Comenzi.class)
	Comenzi comanda;
	
	@OneToMany(targetEntity = org.open.erp.services.vanzari.LiniiAviz.class, mappedBy = "aviz")
	List<LiniiAviz> liniiAviz=new ArrayList<LiniiAviz>();
	
	
	
	
	public Avize() {
		super();
	}



	public Avize(Integer idAviz, Date data, Angajat responsabil,
			Comenzi comanda, List<LiniiAviz> liniiAviz) {
		super();
		this.idAviz = idAviz;
		this.data = data;
		this.responsabil = responsabil;
		this.comanda = comanda;
		this.liniiAviz = liniiAviz;
	}

	

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



	public Angajat getAngajat() {
		return responsabil;
	}



	public void setAngajat(Angajat responsabil) {
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
