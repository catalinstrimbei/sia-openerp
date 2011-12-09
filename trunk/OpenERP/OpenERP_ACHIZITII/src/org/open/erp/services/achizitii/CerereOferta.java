package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.Persoana;

public class CerereOferta /*extends Document*/ {
public static final Integer TRIMISA = 0;
public static final Integer PRIMITA = 1;
public static final Integer ANULATA =-1;
private Integer idCerereOferta;
private Date dataCerere;
private Integer statusCerereOferta;
private List<LinieCerereOferta> linii= new LinkedList<LinieCerereOferta>();
private List<Furnizor> listaFurnizori = new LinkedList<Furnizor>();
private Persoana persona;

public void addLinieCerere(LinieCerereOferta li) {
    this.getLinii().add(li);
    li.setCerereOferta(this);
}

public void removeLinieCerere(LinieCerereOferta li) {
    this.getLinii().remove(li);
    li.setCerereOferta(null);
}

public Integer getIdCerereOferta() {
	return idCerereOferta;
}
public void setIdCerereOferta(Integer idCerereOferta) {
	this.idCerereOferta = idCerereOferta;
}
public Date getDataCerere() {
	return dataCerere;
}
public void setDataCerere(Date dataCerere) {
	this.dataCerere = dataCerere;
}
public Integer getStatusCerereOferta() {
	return statusCerereOferta;
}
public void setStatusCerereOferta(Integer statusCerereOferta) {
	this.statusCerereOferta = statusCerereOferta;
}
public List<LinieCerereOferta> getLinii() {
	return linii;
}
public void setLinii(List<LinieCerereOferta> linii) {
	this.linii = linii;
}
public List<Furnizor> getListaFurnizori() {
	return listaFurnizori;
}
public void setListaFurnizori(List<Furnizor> listaFurnizori) {
	this.listaFurnizori = listaFurnizori;
}
public Persoana getPersona() {
	return persona;
}
public void setPersona(Persoana persona) {
	this.persona = persona;
}

public CerereOferta(Date dataCerere, List<Furnizor> listaFurnizori,
		Persoana persona) {
	super();
	this.dataCerere = dataCerere;
	this.listaFurnizori = listaFurnizori;
	this.persona = persona;
}

  

}
