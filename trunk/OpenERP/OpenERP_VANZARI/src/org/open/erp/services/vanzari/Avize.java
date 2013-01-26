package org.open.erp.services.vanzari;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	
	@OneToOne(targetEntity = org.open.erp.services.vanzari.Persoana.class)
	Persoana responsabil;
	
	@OneToOne(targetEntity = org.open.erp.services.vanzari.Comenzi.class)
	Comenzi comanda;
	
	@OneToMany(targetEntity = org.open.erp.services.vanzari.LiniiAviz.class, mappedBy = "aviz")
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

	public Persoana getResponsabil() {
		return responsabil;
	}

	public void setResponsabil(Persoana responsabil) {
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

	public Avize(Integer idAviz, Date data, Persoana responsabil,
			Comenzi comanda, List<LiniiAviz> liniiAviz) {
		super();
		this.idAviz = idAviz;
		this.data = data;
		this.responsabil = responsabil;
		this.comanda = comanda;
		this.liniiAviz = liniiAviz;
	}

	public Avize() {
		super();
	}
	
	
public void adaugalinieAviz(LiniiAviz linieAviz)
{
	this.liniiAviz.add(linieAviz);
}
	

	
}
