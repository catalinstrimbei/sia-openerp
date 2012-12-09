package org.open.erp.services.stocuri;

import org.open.erp.services.nommat.Material;

/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
public class BonTransfer {
	Material material;
	Double cantitate;
	Gestiune gestiuneIntrare;
	Gestiune gestiuneIesire;
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
	public Gestiune getGestiuneIntrare() {
		return gestiuneIntrare;
	}
	public void setGestiuneIntrare(Gestiune gestiuneIntrare) {
		this.gestiuneIntrare = gestiuneIntrare;
	}
	public Gestiune getGestiuneIesire() {
		return gestiuneIesire;
	}
	public void setGestiuneIesire(Gestiune gestiuneIesire) {
		this.gestiuneIesire = gestiuneIesire;
	}
	public BonTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BonTransfer(Material material, Double cantitate,
			Gestiune gestiuneIntrare, Gestiune gestiuneIesire) {
		super();
		this.material = material;
		this.cantitate = cantitate;
		this.gestiuneIntrare = gestiuneIntrare;
		this.gestiuneIesire = gestiuneIesire;
	}
	
	

}
