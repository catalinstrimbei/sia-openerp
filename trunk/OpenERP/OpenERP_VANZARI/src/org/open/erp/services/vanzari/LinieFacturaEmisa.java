package org.open.erp.services.vanzari;

import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.nomgen.LinieDocument;

/*
 * @author Irina Bogdan
 * 
 * @BusinessObject(DummyEntity)
 */

public class LinieFacturaEmisa extends LinieDocument {
	//Integer idLinieFactura;
	//Produs produs;
	//Double pretUnitar;
	Double pretLinie;
	//Double cantitateFacturata;
	//Double tvaLinie;
	
	public LinieFacturaEmisa(){
		super();
	}
	
	public LinieFacturaEmisa(Produs _produs, Double _cant){
		super();
		this.material= _produs;
		this.cantitate = _cant;
	}

	public Double getPretLinie() {
		return pretLinie;
	}

	public void setPretLinie(Double pretLinie) {
		this.pretLinie = pretLinie;
	}
	
}
