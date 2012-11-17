package org.open.erp.services.vanzari;

import java.util.Date;

import org.open.erp.services.nomgen.Clienti;
import org.open.erp.services.nommat.Produse;

public class OfertePretPF extends OfertePret{
	
	Double pretPF;
	
	public Double getPretPF() {
		return pretPF;
	}
	public void setPretPF(Double pretPF) {
		this.pretPF = pretPF;
	}
	public OfertePretPF(Integer idOfertaPret, Produse produs, Clienti client,
			Date dataEmitere, Date dataValabilitate, String observatii,
			Double pretPF) {
		super(idOfertaPret, produs, client, dataEmitere, dataValabilitate,
				observatii);
		this.pretPF = pretPF;
	}

}
