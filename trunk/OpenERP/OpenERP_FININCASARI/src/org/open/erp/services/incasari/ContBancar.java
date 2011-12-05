package org.open.erp.services.incasari;


/**
 * 
 * @author Echipa FININCASARI
 * 
 * @BusinessObject(Entity)
 * 
 */

import org.open.erp.services.nomgen.PersoanaJuridica;

public class ContBancar {

	private PersoanaJuridica banca;

	private String numarCont;

	private String moneda;

	private Double soldCurent;

	public PersoanaJuridica getBanca() {
		return banca;
	}

	public void setBanca(PersoanaJuridica banca) {
		this.banca = banca;
	}

	public String getNumarCont() {
		return numarCont;
	}

	public void setNumarCont(String numarCont) {
		this.numarCont = numarCont;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public Double getSoldCurent() {
		return soldCurent;
	}

	public void setSoldCurent(Double soldCurent) {
		this.soldCurent = soldCurent;
	}

}
