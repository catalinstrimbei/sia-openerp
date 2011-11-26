package org.open.erp.services.achizitii;

public class LinieFacturaRetur extends LinieFacturaAchizitie {
	public String motiv;

	public LinieFacturaRetur(String motiv) {
		super();
		this.motiv = motiv;
	}

	public String getMotiv() {
		return motiv;
	}

	public void setMotiv(String motiv) {
		this.motiv = motiv;
	}
	
}
