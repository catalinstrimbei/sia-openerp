package org.open.erp.services.vanzari;

import java.util.Date;

public class Comenzi {
 Integer idComanda;
 Integer idProdus;
 Integer idOfertePret;
 Date data;
 String UM;
 Double cantitateComandata;
 Double cantitateAcceptata;
 Double valoare;
public Integer getIdComanda() {
	return idComanda;
}
public void setIdComanda(Integer idComanda) {
	this.idComanda = idComanda;
}
public Integer getIdProdus() {
	return idProdus;
}
public void setIdProdus(Integer idProdus) {
	this.idProdus = idProdus;
}
public Integer getIdOfertePret() {
	return idOfertePret;
}
public void setIdOfertePret(Integer idOfertePret) {
	this.idOfertePret = idOfertePret;
}
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
}
public String getUM() {
	return UM;
}
public void setUM(String uM) {
	UM = uM;
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
public Double getValoare() {
	return valoare;
}
public void setValoare(Double valoare) {
	this.valoare = valoare;
}
 
 
	
}
