package org.open.erp.services.productie;

import org.open.erp.services.nomgen.MijlocFix;

/**
 * 
 * @author Echipa Productie
 * 
 * @BusinessObject(Entity)
 */

public class Utilaj {

	MijlocFix utilaj;
	String status;
	
	
	public Utilaj(MijlocFix utilaj, String status) {
		super();
		this.utilaj = utilaj;
		this.status = status;
	}
	public Utilaj() {
		super();
	}
	public MijlocFix getUtilaj() {
		return utilaj;
	}
	public void setUtilaj(MijlocFix utilaj) {
		this.utilaj = utilaj;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
