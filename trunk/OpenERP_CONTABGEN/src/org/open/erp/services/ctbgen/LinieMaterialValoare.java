package org.open.erp.services.ctbgen;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Entity)
 * 
 */

public class LinieMaterialValoare {
	public TipContabil tipMaterial;
	public Double valoare;
	public Double cantitate;

	public LinieMaterialValoare(TipContabil tipMaterial, Double valoare, Double cantitate) {
		super();
		this.tipMaterial = tipMaterial;
		this.valoare = valoare;
		this.cantitate = cantitate;
	}
	
}
