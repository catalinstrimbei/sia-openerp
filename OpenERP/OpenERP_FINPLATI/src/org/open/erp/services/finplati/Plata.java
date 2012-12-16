package org.open.erp.services.finplati;

import java.io.Serializable;
import java.util.Date;

import org.open.erp.services.banci.CompanieBanci;
import org.open.erp.services.banci.Cont;

public class Plata implements Serializable {

	Integer idPlata;
	TipPlata tipPlata;
	ModPlata modPlata;
	Date dataPlata;
	Double valoarePlata;
	String confirmarePlata;
	Cont contBancar;
	CompanieBanci banca;
	
	private static int nextIdPlata = 1;
	
	public Plata() {
		idPlata = nextIdPlata++;
	}
	
	public Cont getCont() {
		return this.contBancar;
	}
	
	public void setCont(Cont contBancar) {
		this.contBancar = contBancar;
	}
	
	public CompanieBanci getBanca() {
		return this.banca;
	}
	
	public void setBanca(CompanieBanci banca) {
		this.banca = banca;
	}
	
	public Double getValoarePlata() {
		return valoarePlata;
	}
	public Integer getId() {
		return idPlata;
	}
	public Date getDataPlatii() {
		return dataPlata;
	}
	public TipPlata getTipPlata() {
		return tipPlata;
	}
	public ModPlata getModPlata() {
		return modPlata;
	}
	public String getConfirmarePlata() {
		return confirmarePlata;
	}

	public void setValoarePlata(Double valoarePlata) {
		this.valoarePlata = valoarePlata;
	}
	public void setId(Integer idPlata) {
		this.idPlata = idPlata;
	}
	public void setDataPlatii(Date dataPlata) {
		this.dataPlata = dataPlata;
	}
	public void setTipPlata(TipPlata tipPlata) {
		this.tipPlata = tipPlata;
	}
	public void setModPlata(ModPlata modPlata) {
		this.modPlata = modPlata;
	}
	public void setConfirmarePlata(String confirmarePlata) {
		this.confirmarePlata = confirmarePlata;
	}
	
}
