package org.open.erp.services.vanzari;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;


@Entity
public class LiniiDispozitieLivrare {
	
	@Id @GeneratedValue
	Integer nrLiniiAviz;
	
	@OneToOne(targetEntity = org.open.erp.services.vanzari.ArticolComanda.class)
	ArticolComanda articol;
	
	@ManyToOne(targetEntity = org.open.erp.services.vanzari.DispozitiiLivrare.class)
	private DispozitiiLivrare dispozitie;
	
	
	
	public LiniiDispozitieLivrare() {
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

	public LiniiDispozitieLivrare(Integer nrLiniiAviz, ArticolComanda articol) {
		super();
		this.nrLiniiAviz = nrLiniiAviz;
		this.articol = articol;
	}
	
public Double valoareLinieDispozitie(){		
		
		return articol.oferta.getPretOferta(articol.cantitateAcceptata) ;
	}
	

}
