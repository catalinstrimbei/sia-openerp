package org.erp.contgen.impl1;

import org.erp.contgen.ServiciuContabilitateGenerala;

public class ServiciuContabilitateGeneralaImpl1 implements ServiciuContabilitateGenerala{

	@Override
	public void contabilizareVinzare(String codClient, Double sumaVinzare) {
		System.out.println("Impl1: Contabilizare vinzare pentru client: " + codClient + 
				", cu suma: " + sumaVinzare);
	}

}
