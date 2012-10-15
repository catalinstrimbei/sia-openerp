package org.erp.vinzari.impl2;

import org.erp.contgen.ServiciuContabilitateGenerala;
import org.erp.vinzari.Factura;
import org.erp.vinzari.ServiciuVinzari;

public class ServiciuVinzariImpl2 implements ServiciuVinzari{
	ServiciuContabilitateGenerala srvContabilitate;
	
	public ServiciuVinzariImpl2(ServiciuContabilitateGenerala srvContab) {
		srvContabilitate = srvContab;
	}

	@Override
	public void factureazaVinzare(Factura factura) {
		System.out.println("Facturare vizare");
		srvContabilitate.contabilizareVinzare(factura.getCodClient(), factura.getSumaFacturata());
	}
	
}
