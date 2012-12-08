package org.open.erp.services.vanzari;

import java.util.Date;



public class LiniiAviz {
	Integer nrLiniiAviz;
	ArticolComanda articol;
	
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
