package org.open.erp.services.plati;

/**
 * 
 * @author Echipa FINPLATI
 * 
 * @BusinessObject(Entity)
 * 
 */

import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Produs;

public class LinieFacturaPrimita extends LinieDocument {
	//Integer idLinieFactura;
	//Produs produs;
	//Double pretUnitar;
	Double pretLinie;
	//Double cantitateFacturata;
	//Double tvaLinie;
	
	public LinieFacturaPrimita(){
		super();
	}
	
	public LinieFacturaPrimita(Produs _produs, Double _cant){
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