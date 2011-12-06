package org.open.erp.services.plati;

import org.open.erp.services.nomgen.PersoanaJuridica;

public class OrdinPlata extends DocumentPlata{
	private Double suma;
	private Integer CIF;
	private String reprezentand; 
	private Double sumaPlataAvans;
	private PersoanaJuridica emitent;
	private PersoanaJuridica beneficiar;
	
	public Double getSuma() {
		return suma;
	}
	public void setSuma(Double suma) {
		this.suma = suma;
	}
	public Integer getCIF() {
		return CIF;
	}
	public void setCIF(Integer cIF) {
		CIF = cIF;
	}
	public String getReprezentand() {
		return reprezentand;
	}
	public void setReprezentand(String reprezentand) {
		this.reprezentand = reprezentand;
	}
	public PersoanaJuridica getEmitent() {
		return emitent;
	}
	
	public void setEmitent(PersoanaJuridica emitent){
		this.emitent = emitent;
	}
	
	public PersoanaJuridica getBeneficiar() {
		return beneficiar;
	}
	
	public void setBeneficiar(PersoanaJuridica beneficiar){
		this.beneficiar = beneficiar;
	}
		
	public Double PlataAvans(Double suma, Double procentAvans) {
		return sumaPlataAvans;
	}
}
