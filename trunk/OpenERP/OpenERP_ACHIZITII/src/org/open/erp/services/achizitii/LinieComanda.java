package org.open.erp.services.achizitii;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Entity;
import org.open.erp.services.nomgen.Material;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */


@Entity
public class LinieComanda implements Serializable  {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private Integer linieComanda;
	@ManyToOne@JoinColumn(name="comanda_id")
	private Comanda comanda;
	@ManyToOne@JoinColumn(name="idMaterial")
	private Material articol;	
	private Double cantitate;
	private Double pret;
	public Integer getLinieComanda() {
		return linieComanda;
	}
	public void setLinieComanda(Integer linieComanda) {
		this.linieComanda = linieComanda;
	}
	public Comanda getComanda() {
		return comanda;
	}
	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}	
	
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public Double getPret() {
		return pret;
	}
	public void setPret(Double pret) {
		this.pret = pret;
	}
	public LinieComanda(Integer linieComanda, Comanda comanda, Material articol,
			Double cantitate, Double pret) {
		super();
		this.linieComanda = linieComanda;
		this.comanda = comanda;
		this.articol = articol;
		this.cantitate = cantitate;
		this.pret = pret;
	}
	public Material getArticol() {
		return articol;
	}
	public void setArticol(Material articol) {
		this.articol = articol;
	}
		

}
