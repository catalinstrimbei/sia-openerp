package org.erp.contgen.impl3;

import java.util.HashMap;
import java.util.Map;

import org.erp.contgen.ServiciuContabilitateGenerala;

public class ServiciuContabilitateGeneralaAdaptor extends SrvContabGenImpl implements ServiciuContabilitateGenerala {

	@Override
	public void contabilizareVinzare(String codClient, Double sumaVinzare) {
		Map<String, Double> vinzari = new HashMap<String, Double>();
		vinzari.put(codClient, sumaVinzare);
		System.out.println("Contabilizare vinzare adaptata: ");
		contabilizareVinzari(vinzari);
	}
	
}
