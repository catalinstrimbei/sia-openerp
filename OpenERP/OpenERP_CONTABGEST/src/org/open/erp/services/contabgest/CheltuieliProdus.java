package org.open.erp.services.contabgest;

//import org.open.erp.services.contabgest.impl.Material;
import org.open.erp.services.nommat.Material;

public class CheltuieliProdus {

	private Material material;
	private double bugetEstimat;
	private double bugetAlocat=0;
	private CalculCost calculCost;

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
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
}
