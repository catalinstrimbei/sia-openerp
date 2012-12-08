package org.open.erp.services.admin;

public class RolUtilizatori {

	Integer IdRol;
	String DenumireRol;
	String Observatie;
	
	
	public Integer getIdRol() {
		return IdRol;
	}
	
	public void setIdRol(Integer IdRol) {
		this.IdRol = IdRol;
	}
	
	public String getDenumireRol() {
		return DenumireRol;
	}
	
	public void setDenumireRol(String DenumireRol) {
		this.DenumireRol = DenumireRol;
	}
	
	public String getObservatie() {
		return Observatie;
	}
	
	public void setObservatie() {
		this.Observatie = Observatie;
	}
	
	public RolUtilizatori(Integer IdRol, String DenumireRol, String Observatie) {
		super();
		this.IdRol = IdRol;
		this.DenumireRol = DenumireRol;
		this.Observatie = Observatie;
	}
	
	public RolUtilizatori() {
		super();
	}
}
