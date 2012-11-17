package org.open.erp.services.vanzari;

import java.util.Date;

import org.open.erp.services.nommat.Produse;

public class Comenzi {
 Integer idComanda;
 Produse produs;
 OfertePret ofertaPret;
 Date data;
 Double cantitateComandata;
 Double cantitateAcceptata;
 Double valoare;
 
public Integer getIdComanda() {
	return idComanda;
}
public void setIdComanda(Integer idComanda) {
	this.idComanda = idComanda;
}

public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
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
public Produse getProdus() {
	return produs;
}
public void setProdus(Produse produs) {
	this.produs = produs;
}
public OfertePret getOfertaPret() {
	return ofertaPret;
}
public void setOfertaPret(OfertePret ofertaPret) {
	this.ofertaPret = ofertaPret;
}
public Comenzi(Integer idComanda, Produse produs, OfertePret ofertaPret,
		Date data, Double cantitateComandata,
		Double cantitateAcceptata, Double valoare) {
	super();
	this.idComanda = idComanda;
	this.produs = produs;
	this.ofertaPret = ofertaPret;
	this.data = data;
	this.cantitateComandata = cantitateComandata;
	this.cantitateAcceptata = cantitateAcceptata;
	this.valoare = valoare;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((idComanda == null) ? 0 : idComanda.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Comenzi other = (Comenzi) obj;
	if (idComanda == null) {
		if (other.idComanda != null)
			return false;
	} else if (!idComanda.equals(other.idComanda))
		return false;
	return true;
}
 
 
	
}
