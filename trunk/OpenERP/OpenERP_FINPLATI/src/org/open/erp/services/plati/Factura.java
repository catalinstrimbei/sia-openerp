package org.open.erp.services.plati;

import java.util.Date;

import org.open.erp.services.nomgen.PersoanaJuridica;

public class Factura {
	private String seriaNr;
	private Date data;
	public Double totalPlata;
	private PersoanaJuridica furnizor;
	private PersoanaJuridica client;
	
	public Factura(String seriaNr, Date data, Double totalPlata, PersoanaJuridica furnizor, PersoanaJuridica client){
		this.seriaNr=seriaNr;
		this.data=data;
		this.totalPlata=totalPlata;
		this.furnizor=furnizor;
		this.client=client;
	}
	
	public String getSeriaNr() {
		return seriaNr;
	}
	public void setSeriaNr(String seriaNr) {
		this.seriaNr = seriaNr;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getTotalPlata() {
		return totalPlata;
	}
	public void setTotalPlata(Double totalPlata) {
		this.totalPlata = totalPlata;
	}
	public PersoanaJuridica getFurnizor() {
		return furnizor;
	}
	public void setFurnizor(PersoanaJuridica furnizor) {
		this.furnizor = furnizor;
	}
	public PersoanaJuridica getClient() {
		return client;
	}
	public void setClient(PersoanaJuridica client) {
		this.client = client;
	}
}
