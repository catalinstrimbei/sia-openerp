package org.open.erp.services.vanzari;

import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.nomgen.LinieDocument;

/*
 * @author Irina Bogdan
 * 
 * @BusinessObject(DummyEntity)
 */

public class LinieFacturaEmisa extends LinieDocument {
	// Integer idFactura;
	Integer idLinieFactura;
	Produs produs;
	//Double pretUnitar;
	Double pretLinie;
	Double cantitateFacturata;
	Double tvaLinie;
	//Double cotaTva;
	
	public LinieFacturaEmisa(){}
	
	public LinieFacturaEmisa(Produs _produs, Double _cant){
		this.produs= _produs;
		this.cantitateFacturata = _cant;
	}
	
	public Integer getIdLinieFactura() {
		return idLinieFactura;
	}
	public void setIdLinieFactura(Integer idLinieFactura) {
		this.idLinieFactura = idLinieFactura;
	}

	public Double getPretLinie() {
		return pretLinie;
	}

	public void setPretLinie(Double pretLinie) {
		this.pretLinie = pretLinie;
	}

	public Double getCantitateFacturata() {
		return cantitateFacturata;
	}
	public void setCantitateFacturata(Double cantitateFacturata) {
		this.cantitateFacturata = cantitateFacturata;
	}
	public Double getTvaLinie() {
		return tvaLinie;
	}
	public void setTvaLinie(Double tvaLinie) {
		this.tvaLinie = tvaLinie;
	}

	public Produs getProdus() {
		return produs;
	}

	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	
	
}
