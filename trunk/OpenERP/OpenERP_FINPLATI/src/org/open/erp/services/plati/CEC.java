package org.open.erp.services.plati;

import java.util.Date;

import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.PersoanaJuridica;

public class CEC extends DocumentPlata{
	private String seriaNr;
	private Date data;
	private Double totalPlata;
	private PersoanaJuridica emitent;
	private PersoanaJuridica beneficiar;
	private ContBancaPJ contEmitent;

	public CEC(Integer idDocumentPlata, String seriaNr, Date data, Double totalPlata, PersoanaJuridica emitent, PersoanaJuridica beneficiar, ContBancaPJ contEmitent) {
		super(idDocumentPlata);
		this.setSeriaNr(seriaNr);
		this.data = data;
		this.totalPlata = totalPlata;
		this.emitent = emitent;
		this.beneficiar = beneficiar;
		this.contEmitent = contEmitent;
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

	public String getSeriaNr() {
		return seriaNr;
	}

	public void setSeriaNr(String seriaNr) {
		this.seriaNr = seriaNr;
	}
}	
