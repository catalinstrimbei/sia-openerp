package org.open.erp.services.vanzari;

import java.io.Serializable;

import javax.persistence.Entity;

import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.nomgen.LinieDocument;

/**
 * @author Irina Bogdan
 * 
 * @BusinessObject(Entity)
 */

@Entity
public class LinieFacturaEmisa extends LinieDocument implements Serializable {
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
		this.setMaterial(_produs);
		this.setCantitate(_cant);
	}

	public Double getPretLinie() {
		return pretLinie;
	}

	public void setPretLinie(Double pretLinie) {
		this.pretLinie = pretLinie;
	}
	
}
