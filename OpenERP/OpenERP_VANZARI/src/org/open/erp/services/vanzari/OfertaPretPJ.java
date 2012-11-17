package org.open.erp.services.vanzari;

import java.util.Date;

import org.open.erp.services.nomgen.Clienti;
import org.open.erp.services.nommat.Produse;

public class OfertaPretPJ extends OfertePret {

	Double pretFaraTVAPJ;
	Double valoareTVA;
	
	public Double getPretFaraTVAPJ() {
		return pretFaraTVAPJ;
	}
	public OfertaPretPJ(Integer idOfertaPret, Produse produs, Clienti client,
			Date dataEmitere, Date dataValabilitate, String observatii,
			Double pretFaraTVAPJ, Double valoareTVA) {
		super(idOfertaPret, produs, client, dataEmitere, dataValabilitate,
				observatii);
		this.pretFaraTVAPJ = pretFaraTVAPJ;
		this.valoareTVA = valoareTVA;
	}
	public void setPretFaraTVAPJ(Double pretFaraTVAPJ) {
		this.pretFaraTVAPJ = pretFaraTVAPJ;
	}
	public Double getValoareTVA() {
		return valoareTVA;
	}
	public void setValoareTVA(Double valoareTVA) {
		this.valoareTVA = valoareTVA;
	}
	
	
}
