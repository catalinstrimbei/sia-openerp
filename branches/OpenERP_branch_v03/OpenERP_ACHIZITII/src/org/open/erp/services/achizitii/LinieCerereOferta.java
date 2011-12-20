package org.open.erp.services.achizitii;

import org.open.erp.services.nomgen.Material;

public class LinieCerereOferta {

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */

public Integer nrLinie;
public CerereOferta cerereOferta;
public Material articol;
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
public Material getArticol() {
	return articol;
}
public void setArticol(Material articol) {
	this.articol = articol;
}
public Double getCantitate() {
	return cantitate;
}
public void setCantitate(Double cantitate) {
	this.cantitate = cantitate;
}
public LinieCerereOferta(Integer nrLinie, CerereOferta cerereOferta,
		Material articol, Double cantitate) {
	super();
	this.nrLinie = nrLinie;
	this.cerereOferta = cerereOferta;
	this.articol = articol;
	this.cantitate = cantitate;
}


}
