package org.erp.contgen.impl2;

import org.erp.contgen.ServiciuContabilitateGenerala;

public class ServiciuContabilitateGeneralaImpl2 implements ServiciuContabilitateGenerala{

	@Override
	public void contabilizareVinzare(String codClient, Double sumaVinzare) {
		System.out.println("Impl2: Contabilizare vinzare pentru client: " + codClient + 
				", cu suma: " + sumaVinzare);
	}


}
