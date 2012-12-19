package org.open.erp.services.contabgest;
//AM MODIFICAT SI AICI DOAR UN PIC
import org.open.erp.services.nommat.Material;
import org.open.erp.services.contabgest.CalculCost;

public class AnalizaRezultatelor {

	private int id;
	private Material material;
	private CalculCost calculCost;
	private CheltuieliProdus cp;
	
	
	public AnalizaRezultatelor(int id,CheltuieliProdus c)
	{
		this.id=id;
		this.cp=c;
		this.calculCost=c.getCalculCost();
		this.material=c.getMaterial();
	}
	public double calcDiferenta()
	{
		
		System.out.println("SumaFinala este "+ calculCost.costFinal());
		System.out.println("SumaEstimata este "+  cp.getBugetEstimat());
		return  calculCost.costFinal()-cp.getBugetEstimat() ;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
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