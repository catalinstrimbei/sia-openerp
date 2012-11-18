package org.open.erp.services.contabgen.impl;

import org.open.erp.services.contabgen.ContabilitateGeneralaSrv;
import org.open.erp.services.conturi.PlanConturi;

public class ContabilitateGeneralaImpl implements ContabilitateGeneralaSrv{

	@Override
	public PlanConturi crearePlanConturi() {
		PlanConturi plan = new PlanConturi();
		
		return plan;
	}

	
}
