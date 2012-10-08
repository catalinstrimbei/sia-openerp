package org.erp.vinzari.impl;

import org.erp.contgen.ServiciuContabilitateGenerala;
import org.erp.vinzari.ServiciuVinzari;

public class ServiciuVinzariImpl implements ServiciuVinzari{
	ServiciuContabilitateGenerala srvContabilitate;
	
	public ServiciuVinzariImpl(ServiciuContabilitateGenerala srvContab) {
		srvContabilitate = srvContab;
	}

	@Override
	public void factureazaVinzare() {
		System.out.println("Facturare vizare");
		srvContabilitate.contabilizareVinzare();
	}
	
}
