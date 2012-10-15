package org.erp.vinzari.impl1;

import org.erp.contgen.ServiciuContabilitateGenerala;
import org.erp.vinzari.Factura;
import org.erp.vinzari.ServiciuVinzari;

public class ServiciuVinzariImpl1 implements ServiciuVinzari{
	ServiciuContabilitateGenerala srvContabilitate;
	
	public ServiciuVinzariImpl1(ServiciuContabilitateGenerala srvContab) {
		srvContabilitate = srvContab;
	}

	@Override
	public void factureazaVinzare(Factura factura) {
		System.out.println("Facturare vizare");
		srvContabilitate.contabilizareVinzare(factura.getCodClient(), factura.getSumaFacturata());
	}
	
}

