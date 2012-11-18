package org.open.erp.services.conturi;

import java.util.ArrayList;
import java.util.List;

public class PlanConturi {

	private List<Clasa> planConturi = new ArrayList<Clasa>();

	public List<Clasa> getPlanConturi() {
		return planConturi;
	}

	public void addClasa(Clasa clasa) {
		this.planConturi.add(clasa);
	}
	
	public void removeClasa(Clasa clasa) {
		this.planConturi.remove(clasa);
	}
	
}
