package org.erp.contgen.impl2;

import org.erp.contgen.ServiciuContabilitateGenerala;

public class ServiciuContabilitateGeneralaImpl2 implements ServiciuContabilitateGenerala{

	@Override
	public void contabilizareVinzare(Long nrFactura, Double valoare) {
		System.out.println("Vinzare contabilizata ... [2]");
	}

}
