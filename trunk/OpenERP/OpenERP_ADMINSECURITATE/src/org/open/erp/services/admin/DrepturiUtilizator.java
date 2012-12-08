package org.open.erp.services.admin;

public class DrepturiUtilizator {

	Integer IdDrept;
	String DenumireDrept;
	String Observatie;
	
	public Integer getIdDrept() {
		return IdDrept;
	}
	
	public void setidDrept(Integer IdDrept) {
		this.IdDrept = IdDrept;
	}
	
	public String getDenumireDrept() {
		return DenumireDrept;
	}
	
	public void setDenumireDrept(String DenumireDrept) {
		this.DenumireDrept = DenumireDrept;
	}
	
	public String getObservatie() {
		return Observatie;
	}
	
	public void setObservatie() {
		this.Observatie = Observatie;
	}
	
	public DrepturiUtilizator(Integer IdDrept, String DenumireDrept, String Observatie) {
		super();
		this.IdDrept = IdDrept;
		this.DenumireDrept= DenumireDrept;
		this.Observatie = Observatie;
	}
	
	public DrepturiUtilizator() {
		super();
	}
}
