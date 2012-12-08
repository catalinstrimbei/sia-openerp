package org.open.erp.services.vanzari;

import org.open.erp.services.stocuri.Produse;

public class LiniiDispozitieLivrare {
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

	public LiniiDispozitieLivrare(Integer nrLiniiAviz, ArticolComanda articol) {
		super();
		this.nrLiniiAviz = nrLiniiAviz;
		this.articol = articol;
	}
	
public Double valoareLinieDispozitie(){		
		
		return articol.oferta.getPretOferta(articol.cantitateAcceptata) ;
	}
	

}
