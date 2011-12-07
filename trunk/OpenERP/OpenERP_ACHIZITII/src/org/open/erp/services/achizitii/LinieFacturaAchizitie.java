package org.open.erp.services.achizitii;

import org.open.erp.services.nomgen.LinieDocument;

public class LinieFacturaAchizitie extends LinieDocument {
	public Double valoareLinie;
	public Double getValoareLinie() {
		return valoareLinie;
	}
	public void setValoareLinie(Double valoareLinie) {
		this.valoareLinie = valoareLinie;
	}
	public void setPret(Double pret) {
		this.pret = pret;
	}	
	public void setTVA(Double tVA) {
		TVA = tVA;
	}
}
