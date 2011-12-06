package org.open.erp.services.plati;

import org.open.erp.services.nomgen.PersoanaJuridica;

public class CEC extends DocumentPlata {
	private Double suma;
	private PersoanaJuridica emitent;
	private PersoanaJuridica tragator; 
	private Double sumaPlataAvans;
	
	public Double getSuma() {
		return suma;
	}
	
	public void setSuma(Double suma) {
		this.suma = suma;
	}
	
	public PersoanaJuridica getEmitent() {
		return emitent;
	}
	
	public void setEmitent(PersoanaJuridica emitent){
		this.emitent = emitent;
	}
	
	public PersoanaJuridica getTragator() {
		return tragator;
	}
	
	public void setTragator(PersoanaJuridica tragator){
		this.tragator = tragator;
		
	}
	public Double PlataAvans(Double suma, Double procentAvans) {
		return sumaPlataAvans;
	}
	
}
