package org.open.erp.services.contabgest;
//AM MODIFICAT SI AICI--IMBUNATATI


public class RepartizareCheltuieli {
	
	private int id;
	private double bugetActual;
	public double getBugetActual() {
		return bugetActual;
	}


	public void setBugetActual(double bugetActual) {
		this.bugetActual = bugetActual;
	}

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void alocaBugetInitial(CheltuieliProdus cp, int sumaAlocataInitial)
	{
		if(cp.getBugetAlocat()==0)
		{
			cp.setBugetAlocat(sumaAlocataInitial);
			this.bugetActual=this.bugetActual-sumaAlocataInitial;
		}
	}
	public void alocaBugetComplet(CheltuieliProdus cp)
	{
		if(bugetActual>0 && bugetActual>(cp.getCalculCost().costFinal()-cp.getBugetAlocat()))
		if(cp.getBugetAlocat()<cp.getCalculCost().costFinal())
		{
			double suma=cp.getCalculCost().costFinal()-cp.getBugetAlocat();
			cp.setBugetAlocat(suma);
			bugetActual=bugetActual-suma;
			
		}
		else System.out.println("Bugetul este consumat sau insuficient");
	}
	
	public void alocaBugetPartial(CheltuieliProdus cp,double sumaPartialaAlocata)
	{
		if(bugetActual>0&& bugetActual>sumaPartialaAlocata)
			if(cp.getBugetAlocat()<cp.getCalculCost().costFinal())
			{
				cp.setBugetAlocat(cp.getBugetAlocat()+sumaPartialaAlocata);
			}
			else System.out.println("Bugetul este consumat sau insuficient");
	}

	

}
