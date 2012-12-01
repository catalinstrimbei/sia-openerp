package org.open.erp.services.nommat;

public class Materiale {
	private Integer idMaterial;
	private String numeMaterial;
	private String um;
	public Integer getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}
	public String getNumeMaterial() {
		return numeMaterial;
	}
	public void setNumeMaterial(String numeMaterial) {
		this.numeMaterial = numeMaterial;
	}
	public String getUm() {
		return um;
	}
	public void setUm(String um) {
		this.um = um;
	}
	public Materiale(Integer idMaterial, String numeMaterial, String um) {
		super();
		this.idMaterial = idMaterial;
		this.numeMaterial = numeMaterial;
		this.um = um;
	}
	public Materiale() {
		super();
	}
	
	

	public void add(Materiale material) {
		// TODO Auto-generated method stub
		
	}

}
