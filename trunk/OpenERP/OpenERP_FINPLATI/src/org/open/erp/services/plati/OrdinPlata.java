package org.open.erp.services.plati;

import java.util.Date;

import org.open.erp.services.nomgen.PersoanaJuridica;

public class OrdinPlata extends DocumentPlata{
	private String seriaNr;
	private Date data;
	private Double totalPlata;
	private PersoanaJuridica emitent;
	private PersoanaJuridica beneficiar;
	private ContBancaPJ contEmitent;
	private ContBancaPJ contBeneficiar;
	private String reprezentand;
	
	public OrdinPlata(Integer idDocumentPlata, String seriaNr, Date data, Double totalPlata, PersoanaJuridica emitent, PersoanaJuridica beneficiar, ContBancaPJ contEmitent, ContBancaPJ contBeneficiar, String reprezentand) {
		super(idDocumentPlata);
		this.seriaNr=seriaNr;
		this.data = data;
		this.totalPlata = totalPlata;
		this.emitent = emitent;
		this.beneficiar = beneficiar;
		this.contEmitent = contEmitent;
		this.contBeneficiar = contBeneficiar;
		this.reprezentand = reprezentand;
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
	public String getReprezentand() {
		return reprezentand;
	}
	public void setReprezentand(String reprezentand) {
		this.reprezentand = reprezentand;
	}
	public ContBancaPJ getContEmitent() {
		return contEmitent;
	}
	public void setContEmitent(ContBancaPJ contEmitent) {
		this.contEmitent = contEmitent;
	}
	public ContBancaPJ getContBeneficiar() {
		return contBeneficiar;
	}
	public void setContBeneficiar(ContBancaPJ contBeneficiar) {
		this.contBeneficiar = contBeneficiar;
	}

	public String getSeriaNr() {
		return seriaNr;
	}

	public void setSeriaNr(String seriaNr) {
		this.seriaNr = seriaNr;
	}
	
	public boolean efectPlata(Double totplata){
		System.out.println("Plata prin OP in valoare de: " +
				totplata + " RON "+ getTotalPlata());
		return true;
	}
}

