package org.erp.contgen.impl3;

import java.util.Map;

public class SrvContabGenImpl {
	public void contabilizareVinzari(Map<String, Double> vinzari) {
		for (String codClient: vinzari.keySet()){
			System.out.println("Impl3: Contabilizare vinzare pentru client: " + codClient + 
				", cu suma: " + vinzari.get(codClient));
		}
	}	
}
