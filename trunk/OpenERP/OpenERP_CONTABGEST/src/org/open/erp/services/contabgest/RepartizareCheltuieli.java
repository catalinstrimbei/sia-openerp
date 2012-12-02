package org.open.erp.services.contabgest;

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



	public void alocaBuget(CheltuieliProdus cp)
	{
		if(bugetActual!=0)
		if(cp.getBugetAlocat()<cp.getCalculCost().costFinal())
		{
			double suma=cp.getCalculCost().costFinal()-cp.getBugetAlocat();
			cp.setBugetAlocat(suma);
			bugetActual=bugetActual-suma;
			
		}
		else System.out.println("Bugetul este consumat");
			
	}


	

}
