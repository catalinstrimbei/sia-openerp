package org.open.erp.services.achizitii;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.open.erp.services.nomgen.Persoana;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class CerereOferta  implements Serializable/*extends Document*/ {
public static final Integer TRIMISA = 0;
public static final Integer PRIMITA = 1;
public static final Integer ANULATA =-1;


public long getId_CerereOferta() {
	return id_CerereOferta;
}

public void setId_CerereOferta(long id_CerereOferta) {
	this.id_CerereOferta = id_CerereOferta;
}

public OfertaAchizitie getOfertaAchizitie() {
	return ofertaAchizitie;
}

public void setOfertaAchizitie(OfertaAchizitie ofertaAchizitie) {
	this.ofertaAchizitie = ofertaAchizitie;
}

public List<LinieCerereOferta> getLiniiCerereOferta() {
	return liniiCerereOferta;
}

public void setLiniiCerereOferta(List<LinieCerereOferta> liniiCerereOferta) {
	this.liniiCerereOferta = liniiCerereOferta;
}

public List<Furnizor> getTrimisaLaFurnizori() {
	return trimisaLaFurnizori;
}

public void setTrimisaLaFurnizori(List<Furnizor> trimisaLaFurnizori) {
	this.trimisaLaFurnizori = trimisaLaFurnizori;
}

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id_CerereOferta;
@Temporal(TemporalType.DATE)
private Date dataCerere;
private Integer statusCerereOferta;
@OneToOne@JoinColumn(name="id_OfertaAchizitie")
private OfertaAchizitie ofertaAchizitie;

@OneToMany(mappedBy = "cerereOferta", cascade = CascadeType.ALL)
private List<LinieCerereOferta> liniiCerereOferta= new LinkedList<LinieCerereOferta>();

private Persoana persona;

@ManyToMany
@JoinTable(name="CereriOfertaFurnizori",
		joinColumns=@JoinColumn(name="cerereOferta_fk"), 
		inverseJoinColumns=@JoinColumn(name="furnizor_fk"))
private List<Furnizor> trimisaLaFurnizori = new ArrayList<Furnizor>();

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
	return liniiCerereOferta;
}
public void setLinii(List<LinieCerereOferta> linii) {
	this.liniiCerereOferta = linii;
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
