package org.open.erp.services.contabgest.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RepartizareCheltuieli {
	
	private int id;
	public Map<Activitate,Double> activitati = new HashMap<Activitate, Double>();
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Map<Activitate, Double> getActivitati() {
		return activitati;
	}


	public void setActivitati(Map<Activitate, Double> activitati) {
		this.activitati = activitati;
	}


	public void alocaBuget(Activitate a,double suma)
	{
		if(a.getBugetActual()==0)
		{
			a.setBugetActual(suma);
			a.setStatus("InCurs");
			activitati.put(a, activitati.get(a)+suma);
		}
		
		/*if(a.getBugetActual()!=0 )
		{
			
			activitati.put(a, activitati.get(a)-a.getBugetActual());
		}
			System.out.println("Bugetul este neconsumat");
		*/
			
			a.setCostActivitate(activitati.get(a));
			a.setBugetActual(0);
	}
	

}
