package org.open.erp.services.achizitii;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.open.erp.services.nommat.Material;

@Entity
public class LiniiOferta implements Serializable{
	@Id @GeneratedValue
	private Integer nrLinie;
	
	private Double pret;
	
	@OneToOne
	private Material material;
	private Double cantitate;
	
	@ManyToOne
	private Oferta oferta;
	
	
	public Integer getNrLinie() {
		return nrLinie;
	}
	public void setNrLinie(Integer nrLinie) {
		this.nrLinie = nrLinie;
	}
	public Double getPret() {
		return pret;
	}
	public void setPret(Double pret) {
		this.pret = pret;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public Oferta getOferta() {
		return oferta;
	}
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	public LiniiOferta(Integer nrLinie, Double pret, Material material,
			Double cantitate, Oferta oferta) {
		super();
		this.nrLinie = nrLinie;
		this.pret = pret;
		this.material = material;
		this.cantitate = cantitate;
		this.oferta = oferta;
	}
	public LiniiOferta() {
		super();
	}
	
	

}
