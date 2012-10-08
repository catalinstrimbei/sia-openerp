package org.erp.vinzari.impl;

import org.erp.vinzari.ServiciuVinzari;
import org.erp.vinzari.Vanzare;

public class ServiciuVinzariImpl implements ServiciuVinzari{
	ServiciuContabilizare srvContabilitate;
	
	public ServiciuVinzariImpl(ServiciuContabilizare srvContab) {
		srvContabilitate = srvContab;
	}

	@Override
	public void factureazaVinzare(Vanzare v) {
		System.out.println("Facturare vizare");
		srvContabilitate.contabilizareVanzare(v);
	}
	
}
