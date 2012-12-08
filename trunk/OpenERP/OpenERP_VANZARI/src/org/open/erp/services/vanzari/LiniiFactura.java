package org.open.erp.services.vanzari;

import java.util.Date;

import org.open.erp.services.stocuri.Produse;

public class LiniiFactura {

	Integer nrLiniiFactura;
	ArticolComanda articol;
	
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
