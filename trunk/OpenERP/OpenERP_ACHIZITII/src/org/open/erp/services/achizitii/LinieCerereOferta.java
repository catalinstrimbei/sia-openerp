package org.open.erp.services.achizitii;

public class LinieCerereOferta {
	
public Integer nrLinie;
public CerereOferta cerereOferta;
public Articol articol;
public Double cantitate;

public Integer getNrLinie() {
	return nrLinie;
}
public void setNrLinie(Integer nrLinie) {
	this.nrLinie = nrLinie;
}
public CerereOferta getCerereOferta() {
	return cerereOferta;
}
public void setCerereOferta(CerereOferta cerereOferta) {
	this.cerereOferta = cerereOferta;
}
public Articol getArticol() {
	return articol;
}
public void setArticol(Articol articol) {
	this.articol = articol;
}

public Double getCantitate() {
	return cantitate;
}
public void setCantitate(Double cantitate) {
	this.cantitate = cantitate;
}
public LinieCerereOferta(Integer nrLinie, CerereOferta cerereOferta,
		Articol articol, Double cantitate) {
	super();
	this.nrLinie = nrLinie;
	this.cerereOferta = cerereOferta;
	this.articol = articol;
	this.cantitate = cantitate;
}


}
