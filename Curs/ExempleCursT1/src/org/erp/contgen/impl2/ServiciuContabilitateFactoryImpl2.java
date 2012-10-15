package org.erp.contgen.impl2;

import org.erp.contgen.ServiciuContabilitateFactory;
import org.erp.contgen.ServiciuContabilitateGenerala;

public class ServiciuContabilitateFactoryImpl2 implements ServiciuContabilitateFactory{
	static ServiciuContabilitateGenerala INSTANCE;
	
	@Override
	public ServiciuContabilitateGenerala getServiciuContabilitateInstance() {
		if (INSTANCE == null)
			INSTANCE = new ServiciuContabilitateGeneralaImpl2();
		return INSTANCE;
	}
	
}
