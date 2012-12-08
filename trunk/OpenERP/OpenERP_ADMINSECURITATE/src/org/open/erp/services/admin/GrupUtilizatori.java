package org.open.erp.services.admin;

public class GrupUtilizatori {

	Integer IdGrup;
	String DenumireGrup;
	String Observatie;
	Integer IdDrept;
	
	public Integer getIdGrup() {
		return IdGrup;
	}
	
	public void setIdGrup(Integer IdGrup) {
		this.IdGrup = IdGrup;
	}
	
	public String DenumireGrup() {
		return DenumireGrup;
	}
	
	public void setDenumireGrup(String DenumireGrup) {
		this.DenumireGrup = DenumireGrup;
	}
	
	public String getObservatie() {
		return Observatie;
	} 
	
	public void setObservatie( String Observatie) {
		this.Observatie = Observatie;
	}
	
	public Integer getIdDrept() {
		return IdDrept;
	}
	
	public void setIdDrept(Integer IdDrept) {
		this.IdDrept = IdDrept;
	}
	
	public GrupUtilizatori(Integer IdGrup, String DenumireGrup, String Observatie, Integer IdDrept) {
		super();
		this.IdGrup = IdGrup;
		this.DenumireGrup = DenumireGrup;
		this.Observatie = Observatie;
		this.IdDrept = IdDrept;
	}
	
	public GrupUtilizatori() {
		super();
	}
}
