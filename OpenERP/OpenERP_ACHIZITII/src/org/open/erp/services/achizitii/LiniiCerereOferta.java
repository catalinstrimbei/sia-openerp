package org.open.erp.services.achizitii;

import org.open.erp.services.nommat.Material;

public class LiniiCerereOferta {
	private Integer nrLinie;
	private Double cantitate;
	private Material material;
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
