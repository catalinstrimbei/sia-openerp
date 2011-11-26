package org.open.erp.services.achizitii;

import org.open.erp.services.nomenclatoare.MaterialPrim;
/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class LinieCerereAprovizionare {
	private Integer idLinie;
	private CerereAprovizionare cerere;
	private MaterialPrim material;
	private  Integer cantitate;
	public LinieCerereAprovizionare() {
		super();
	}
	public LinieCerereAprovizionare(Integer idLinie,
			CerereAprovizionare cerere, MaterialPrim material, Integer cantitate) {
		super();
		this.idLinie = idLinie;
		this.cerere = cerere;
		this.material = material;
		this.cantitate = cantitate;
	}
	public Integer getIdLinie() {
		return idLinie;
	}
	public void setIdLinie(Integer idLinie) {
		this.idLinie = idLinie;
	}
	public CerereAprovizionare getCerere() {
		return cerere;
	}
	public void setCerere(CerereAprovizionare cerere) {
		this.cerere = cerere;
	}
	public MaterialPrim getMaterial() {
		return material;
	}
	public void setMaterial(MaterialPrim material) {
		this.material = material;
	}
	public Integer getCantitate() {
		return cantitate;
	}
	public void setCantitate(Integer cantitate) {
		this.cantitate = cantitate;
	}
	
	
	

}
