package org.erp.contgen.impl1;

import org.erp.contgen.ServiciuContabilitateFactory;
import org.erp.contgen.ServiciuContabilitateGenerala;

public class ServiciuContabilitateFactoryImpl1 implements ServiciuContabilitateFactory{
	static ServiciuContabilitateGenerala INSTANCE;
	
	@Override
	public ServiciuContabilitateGenerala getServiciuContabilitateInstance() {
		if (INSTANCE == null)
			INSTANCE = new ServiciuContabilitateGeneralaImpl1();
		return INSTANCE;
	}
	
}
