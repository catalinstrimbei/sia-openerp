package org.open.erp.services.contabgest.impl;

public class AnalizaRezultatelor {

	private int id;
	private Produs produs;
	
	public AnalizaRezultatelor(int id,Produs produs)
	{
		this.produs=produs;
	}
	public double calcDiferenta()
	{
		double suma=0;
		double  sumaEstimata=0;
		int marime=produs.stagiiProductie.size();
		for(int i=0;i<marime;i++)
			suma=(double) (suma+produs.stagiiProductie.get(i).calculCostActivitate()); //suma alocata pentru fabricarea produsului
		for(int i=0;i<marime;i++)
			sumaEstimata=(double) (sumaEstimata+produs.stagiiProductie.get(i).getCostEstimat());
		
		System.out.println("SumaFinala este "+ suma);
		System.out.println("SumaEstimata este "+ sumaEstimata );
		return suma-sumaEstimata;
	}
	
	
}
