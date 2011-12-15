package org.open.erp.services.plati;

import java.util.Date;

import org.open.erp.services.nomgen.PersoanaJuridica;

public class CEC extends DocumentPlata{
	private Integer seriaNr;
	private Date data;
	private Double totalPlata;
	private PersoanaJuridica emitent;
	private PersoanaJuridica beneficiar;
	private ContBancaPJ contEmitent;
	private String stare;

	public CEC(Integer idDocumentPlata, Integer seriaNr, Date data, Double totalPlata, PersoanaJuridica emitent, PersoanaJuridica beneficiar, ContBancaPJ contEmitent,String stare) {
		super(idDocumentPlata);
		this.setSeriaNr(seriaNr);
		this.data = data;
		this.totalPlata = totalPlata;
		this.emitent = emitent;
		this.beneficiar = beneficiar;
		this.contEmitent = contEmitent;
		this.stare = stare;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public PersoanaJuridica getEmitent() {
		return emitent;
	}
	public void setEmitent(PersoanaJuridica emitent) {
		this.emitent = emitent;
	}
	public PersoanaJuridica getBeneficiar() {
		return beneficiar;
	}
	public void setBeneficiar(PersoanaJuridica beneficiar) {
		this.beneficiar = beneficiar;
	}
	public Double getTotalPlata() {
		return totalPlata;
	}
	public void setTotalPlata(Double totalPlata) {
		this.totalPlata = totalPlata;
	}

	public ContBancaPJ getContEmitent() {
		return contEmitent;
	}

	public void setContEmitent(ContBancaPJ contEmitent) {
		this.contEmitent = contEmitent;
	}

	public Integer getSeriaNr() {
		return seriaNr;
	}

	public void setSeriaNr(Integer seriaNr) {
		this.seriaNr = seriaNr;
		}
	public boolean efectPlata(Double totplata){
		System.out.println("Plata prin CEC in valoare de: " +
				totplata + " RON "+ getTotalPlata());
		return true;
	}

	public String getStare() {
		return stare;
	}

	public void setStare(String stare) {
		this.stare = stare;
	}
}