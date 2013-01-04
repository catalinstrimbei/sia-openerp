package org.open.erp.services.achizitii;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.open.erp.services.nommat.Material;

@Entity
public class LiniiCerereAprov implements Serializable{
	
	@Id @GeneratedValue
	private Integer nrLinieCerereAprov;
	
	@ManyToOne
	private CerereAprov cerereAprov;
	
	@OneToOne
	private Material material;
	private Double cantitate;
	
	public CerereAprov getCerereAprov() {
		return cerereAprov;
	}
	public void setCerereAprov(CerereAprov cerereAprov) {
		this.cerereAprov = cerereAprov;
		this.setMaterial(cerereAprov.getMaterial());
	}
	public Integer getNrLinieCerereAprov() {
		return nrLinieCerereAprov;
	}
	public void setNrLinieCerereAprov(Integer nrLinieCerereAprov) {
		this.nrLinieCerereAprov = nrLinieCerereAprov;
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
	public LiniiCerereAprov(CerereAprov cerereAprov,
			Integer nrLinieCerereAprov, Material material, Double cantitate) {
		super();
		this.cerereAprov = cerereAprov;
		this.nrLinieCerereAprov = nrLinieCerereAprov;
		this.material = material;
		this.cantitate = cantitate;
	}
	
	public LiniiCerereAprov(Integer nrLinieCerereAprov, Material material,
			Double cantitate) {
		super();
		this.nrLinieCerereAprov = nrLinieCerereAprov;
		this.material = material;
		this.cantitate = cantitate;
	}
	public LiniiCerereAprov() {
		super();
	}
	
	
}
