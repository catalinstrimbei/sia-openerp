package org.open.erp.services.ctbgen;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Repository)
 * 
 */

public class RegConturi {
	private static RegConturi singleReference;

	private RegConturi() {
		planConturi = new ArrayList<Cont>();
	}

	public static RegConturi instantiaza() {
		if (singleReference == null)
			singleReference = new RegConturi();
		return singleReference;
	}

	private List<Cont> planConturi;

	public List<Cont> getPlanConturi() {
		return planConturi; 
	}

	void setPlanConturi(List<Cont> planConturi) {
		this.planConturi = planConturi;
	}
	
	private static int contorId = 1;
	public void addCont(Cont cont) {
		if(cont.getIdCont()==-1){
			cont.setIdCont(contorId);
			contorId++;
		}
		
		if (!planConturi.contains(cont)) {
			planConturi.add(cont);
		}
	}

	void removeSablon(Cont cont) {
		planConturi.remove(cont);
	}

	public Cont getContDupaId(Integer idCont) {
		for (Cont c : planConturi) {
			if (idCont == c.getIdCont()) {
				return c;
			}
		}
		return null;
	}
	
	//TODO: remove me
	public void printAll(){
		for(int i=0;i<planConturi.size();i++){
			System.out.println(planConturi.get(i).getSimbolCont().toString());
		}
	}
}
