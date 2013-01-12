package org.open.erp.services.vanzari;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class ArticolComanda {
	@Id @GeneratedValue
	Integer nrLinieComanda;
	
	@OneToOne(targetEntity = org.open.erp.services.vanzari.OfertePret.class)
	OfertePret oferta;
	
	Double cantitateComandata;
	Double cantitateAcceptata;
	
	@ManyToOne(targetEntity = org.open.erp.services.vanzari.Comenzi.class)
	private Comenzi comanda;
	
	
	public Integer getNrLinieComanda() {
		return nrLinieComanda;
	}


	public void setNrLinieComanda(Integer nrLinieComanda) {
		this.nrLinieComanda = nrLinieComanda;
	}


	public OfertePret getOferta() {
		return oferta;
	}


	public void setOferta(OfertePret oferta) {
		this.oferta = oferta;
	}


	public Double getCantitateComandata() {
		return cantitateComandata;
	}


	public void setCantitateComandata(Double cantitateComandata) {
		this.cantitateComandata = cantitateComandata;
	}


	public Double getCantitateAcceptata() {
		return cantitateAcceptata;
	}


	public void setCantitateAcceptata(Double cantitateAcceptata) {
		this.cantitateAcceptata = cantitateAcceptata;
	}

	



	public ArticolComanda(Integer nrLinieComanda, OfertePret oferta,
			Double cantitateComandata, Double cantitateAcceptata) {
		super();
		this.nrLinieComanda = nrLinieComanda;
		this.oferta = oferta;
		this.cantitateComandata = cantitateComandata;
		this.cantitateAcceptata = cantitateAcceptata;

	}


	public Double getValoareArticol(OfertePret oferta){
		if (cantitateAcceptata == null)
			return null;
		
		return oferta.getPretOferta(cantitateAcceptata) ;
	}

	public Double calcValoare(){
		return getValoareArticol(oferta);
	}


	public ArticolComanda() {
		super();
	}
	
}
