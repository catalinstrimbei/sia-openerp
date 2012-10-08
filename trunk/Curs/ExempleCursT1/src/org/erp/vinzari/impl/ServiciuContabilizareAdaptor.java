package org.erp.vinzari.impl;

import org.erp.contgen.ServiciuContabilitateGenerala;
import org.erp.vinzari.Vanzare;

public class ServiciuContabilizareAdaptor implements ServiciuContabilizare{
	private ServiciuContabilitateGenerala srv;
	public void contabilizareVanzare(Vanzare v){
		srv.contabilizareVinzare(v.nr.longValue(), v.val);
	}
}
