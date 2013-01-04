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
public class LiniiCerereOferta implements Serializable{
	@Id @GeneratedValue
	private Integer nrLinie;
	private Double cantitate;
	
	@OneToOne
	private Material material;
	
	@ManyToOne
	private CerereOferta cerereOferta;
	
	
	public Integer getNrLinie() {
		return nrLinie;
	}
	public void setNrLinie(Integer nrLinie) {
		this.nrLinie = nrLinie;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public CerereOferta getCerereOferta() {
		return cerereOferta;
	}
	public void setCerereOferta(CerereOferta cerereOferta) {
		this.cerereOferta = cerereOferta;
	}
	public LiniiCerereOferta(Integer nrLinie, Double cantitate,
			Material material, CerereOferta cerereOferta) {
		super();
		this.nrLinie = nrLinie;
		this.cantitate = cantitate;
		this.material = material;
		this.cerereOferta = cerereOferta;
	}
	public LiniiCerereOferta() {
		super();
	}

	
}
