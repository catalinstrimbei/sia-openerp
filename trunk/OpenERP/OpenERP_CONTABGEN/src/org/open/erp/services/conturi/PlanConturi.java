package org.open.erp.services.conturi;

import java.util.ArrayList;
import java.util.List;

import org.open.erp.services.contabgen.impl.ContabilitateGeneralaImpl;

public class PlanConturi {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PlanConturi.class.getName());
	
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
	
	public Clasa getClasaByCod(Integer cod){
		for(Clasa c : this.planConturi)
		{
			if(c.getCodClasa() == cod)
				return c;
		}
		
		return null;
	}

	public PlanConturi() {
		super();
		
		Clasa clasaTest1 = new Clasa("Conturi 1");
		clasaTest1.setCodClasa(1);
		
		Clasa clasaTest2 = new Clasa("Conturi 2");
		clasaTest2.setCodClasa(2);
		
		this.addClasa(clasaTest1);
		this.addClasa(clasaTest2);
		
	}
}
