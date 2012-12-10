package org.open.erp.services.achizitii;

import org.open.erp.services.nommat.Material;




public class LiniiCerereAprov {
	private CerereAprov cerereAprov;
	private Integer nrLinieCerereAprov;
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
