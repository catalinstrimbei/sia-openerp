package org.open.erp.services.vanzari;

import java.util.Date;

public class OfertePret {
	Integer idOfertaPret;
	Integer idProdus;
	Integer idClient;
	Date dataEmitere;
	Date dataValabilitate;
	String observatii;
	public Integer getIdOfertaPret() {
		return idOfertaPret;
	}
	public void setIdOfertaPret(Integer idOfertaPret) {
		this.idOfertaPret = idOfertaPret;
	}
	public Integer getIdProdus() {
		return idProdus;
	}
	public void setIdProdus(Integer idProdus) {
		this.idProdus = idProdus;
	}
	public Date getDataEmitere() {
		return dataEmitere;
	}
	public void setDataEmitere(Date dataEmitere) {
		this.dataEmitere = dataEmitere;
	}
	public Date getDataValabilitate() {
		return dataValabilitate;
	}
	public void setDataValabilitate(Date dataValabilitate) {
		this.dataValabilitate = dataValabilitate;
	}
	public String getObservatii() {
		return observatii;
	}
	public void setObservatii(String observatii) {
		this.observatii = observatii;
	}
	public Integer getIdClient() {
		return idClient;
	}
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}
	
	
	
}
