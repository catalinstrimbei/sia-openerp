package org.erp.contgen.impl1;

import org.erp.contgen.ServiciuContabilitateGenerala;

public class ServiciuContabilitateGeneralaImpl1 implements ServiciuContabilitateGenerala{

	@Override
	public void contabilizareVinzare(Long nrFactura, Double valoare) {
		System.out.println("Vinzare contabilizata ...[1]");
	}

}
