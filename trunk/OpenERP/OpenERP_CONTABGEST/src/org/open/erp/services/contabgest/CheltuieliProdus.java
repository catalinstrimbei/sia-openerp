package org.open.erp.services.contabgest;

import org.open.erp.services.Productie.Produs;

public class CheltuieliProdus {

	private Produs produs;
	private double bugetEstimat;
	private double bugetAlocat=0;
	private CalculCost calculCost;
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public double getBugetEstimat() {
		return bugetEstimat;
	}
	public void setBugetEstimat(double bugetEstimat) {
		this.bugetEstimat = bugetEstimat;
	}
	public double getBugetAlocat() {
		return bugetAlocat;
	}
	public void setBugetAlocat(double bugetAlocat) {
		this.bugetAlocat = bugetAlocat;
	}
	public CalculCost getCalculCost() {
		return calculCost;
	}
	public void setCalculCost(CalculCost calculCost) {
		this.calculCost = calculCost;
	}
}
