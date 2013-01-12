package org.open.erp.services.vanzari;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;


@Entity
public class LiniiFactura {

	@Id @GeneratedValue
	Integer nrLiniiFactura;
	
	@OneToOne(targetEntity = org.open.erp.services.vanzari.ArticolComanda.class)
	ArticolComanda articol;
	
	@ManyToOne(targetEntity = org.open.erp.services.vanzari.Facturi.class)
	private Facturi factura;
	
	
	public LiniiFactura() {
		super();
	}
	public Integer getNrLiniiFactura() {
		return nrLiniiFactura;
	}
	public void setNrLiniiFactura(Integer nrLiniiFactura) {
		this.nrLiniiFactura = nrLiniiFactura;
	}
	public ArticolComanda getArticol() {
		return articol;
	}
	public void setArticol(ArticolComanda articol) {
		this.articol = articol;
	}
	
	public LiniiFactura(Integer nrLiniiFactura, ArticolComanda articol) {
		super();
		this.nrLiniiFactura = nrLiniiFactura;
		this.articol = articol;
	}
	
	
	public Double valoareFaraTVA(){		
		
		return articol.oferta.getPretOferta(articol.cantitateAcceptata) ;
	}
	
	public Double valoareTVA(Double valoareFaraTVA){
		Double procTVA=0.24;

		return valoareFaraTVA*procTVA;
	}
	
	public Double valoareLinieFactura(){
		return valoareFaraTVA()+valoareTVA(valoareFaraTVA());
	}
}
