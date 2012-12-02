package org.open.erp.services.contabgest;

import org.open.erp.services.Productie.Produs;
import org.open.erp.services.contabgest.CalculCost;

public class AnalizaRezultatelor {

	private int id;
	private Produs produs;
	private CalculCost calculCost;
	private CheltuieliProdus cp;
	
	
	public AnalizaRezultatelor(int id,Produs produs)
	{
		this.setProdus(produs);
	}
	public double calcDiferenta()
	{
		
		System.out.println("SumaFinala este "+ calculCost.costFinal());
		System.out.println("SumaEstimata este "+  cp.getBugetEstimat());
		return  calculCost.costFinal()-cp.getBugetEstimat() ;
	}
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
/*
	 	if (calculCost.costFinal() > sumaEstimata ) 
	 
		{
			System.out.println ("Eroare 1");
		}
		else
		{
			System.out.println("Eroare 2");
		
	}
		
}
*/