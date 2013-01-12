package org.open.erp.services.vanzari;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class LiniiAviz {
	@Id
	Integer nrLiniiAviz;
	
	@OneToOne(targetEntity = org.open.erp.services.vanzari.ArticolComanda.class)
	ArticolComanda articol;
	
	@ManyToOne(targetEntity = org.open.erp.services.vanzari.Avize.class)
	private Avize aviz;
	
	
	
	public LiniiAviz() {
		super();
	}
	public Integer getNrLiniiAviz() {
		return nrLiniiAviz;
	}
	public void setNrLiniiAviz(Integer nrLiniiAviz) {
		this.nrLiniiAviz = nrLiniiAviz;
	}
	public ArticolComanda getArticol() {
		return articol;
	}
	public void setArticol(ArticolComanda articol) {
		this.articol = articol;
	}
	public LiniiAviz(Integer nrLiniiAviz, ArticolComanda articol) {
		super();
		this.nrLiniiAviz = nrLiniiAviz;
		this.articol = articol;
	}
	
public Double valoareLinieAviz(){		
		
		return articol.oferta.getPretOferta(articol.cantitateAcceptata) ;
	}
	
}
