package org.open.erp.services.achizitii;

import org.open.erp.services.nommat.Materiale;

public class LiniiCerereAprov {
	private CerereAprov cerereAprov;
	private Integer nrLinieCerereAprov;
	private Materiale material;
	private Double cantitate;
	public CerereAprov getCerereAprov() {
		return cerereAprov;
	}
	public void setCerereAprov(CerereAprov cerereAprov) {
		this.cerereAprov = cerereAprov;
	}
	public Integer getNrLinieCerereAprov() {
		return nrLinieCerereAprov;
	}
	public void setNrLinieCerereAprov(Integer nrLinieCerereAprov) {
		this.nrLinieCerereAprov = nrLinieCerereAprov;
	}
	public Materiale getMaterial() {
		return material;
	}
	public void setMaterial(Materiale material) {
		this.material = material;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public LiniiCerereAprov(CerereAprov cerereAprov,
			Integer nrLinieCerereAprov, Materiale material, Double cantitate) {
		super();
		this.cerereAprov = cerereAprov;
		this.nrLinieCerereAprov = nrLinieCerereAprov;
		this.material = material;
		this.cantitate = cantitate;
	}
	public LiniiCerereAprov() {
		super();
	}
	
	
}
