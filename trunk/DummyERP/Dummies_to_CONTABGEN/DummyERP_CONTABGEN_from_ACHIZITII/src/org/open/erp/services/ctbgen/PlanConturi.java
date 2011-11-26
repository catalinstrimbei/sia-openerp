package org.open.erp.services.ctbgen;

import java.util.List;

public class PlanConturi {

	List<Cont> planConturi;
	

	public List<Cont> getPlanConturi() {
		return planConturi;
	}


	public void setPlanConturi(List<Cont> planConturi) {
		this.planConturi = planConturi;
	}


	public PlanConturi(List<Cont> planConturi) {
		super();
		this.planConturi = planConturi;
	}
	
	
}
