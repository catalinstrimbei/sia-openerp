package org.open.erp.services.achizitii;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.open.erp.services.nomgen.Material;

@Entity
public class LinieCerereOferta implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


private Integer nrLinie;
@ManyToOne@JoinColumn(name="co")
private CerereOferta cerereOferta;
@ManyToOne@JoinColumn(name="idMaterial")
private Material articol;
private Double cantitate;

public LinieCerereOferta() {
	super();
}
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
