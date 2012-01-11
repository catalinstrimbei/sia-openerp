package org.open.erp.services.achizitii;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class LinieOfertaAchizitie implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@ManyToOne@JoinColumn(name="id")
	private OfertaAchizitie oferta;
	@ManyToOne@JoinColumn(name="id")
	private Articol articol;
	private Double cantitate;
	private Integer linie;
	private Double pret;
	
	public LinieOfertaAchizitie() {
		super();
	}
	public Double getPret() {
		return pret;
	}
	public void setPret(Double pret) {
		this.pret = pret;
	}
	public OfertaAchizitie getOferta() {
		return oferta;
	}
	public void setOferta(OfertaAchizitie oferta) {
		this.oferta = oferta;
	}
	public LinieOfertaAchizitie(OfertaAchizitie oferta, Articol articol,
			Double cantitate, Integer linie) {
		super();
		this.oferta = oferta;
		this.articol = articol;
		this.cantitate = cantitate;
		this.linie = linie;
	}
	public Articol getArticol() {
		return articol;
	}
	public void setArticol(Articol articol) {
		this.articol = articol;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public Integer getLinie() {
		return linie;
	}
	public void setLinie(Integer linie) {
		this.linie = linie;
	}
	public LinieOfertaAchizitie(OfertaAchizitie oferta, Articol articol,
			Double cantitate, Integer linie, Double pret) {
		super();
		this.oferta = oferta;
		this.articol = articol;
		this.cantitate = cantitate;
		this.linie = linie;
		this.pret = pret;
	}	
	

}
