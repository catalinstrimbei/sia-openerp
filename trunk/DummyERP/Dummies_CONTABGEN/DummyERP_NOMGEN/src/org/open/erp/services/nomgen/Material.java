package org.open.erp.services.nomgen;

/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class Material {
	public int idMaterial;
	public String numeMaterial;
	
	public Material() {
		super();
	}

	public Material(int idMaterial, String numeMaterial) {
		super();
		this.idMaterial = idMaterial;
		this.numeMaterial = numeMaterial;
	}

	public int getIdMaterial() {
		return idMaterial;
	}

	public String getNumeMaterial() {
		return numeMaterial;

	}

}
