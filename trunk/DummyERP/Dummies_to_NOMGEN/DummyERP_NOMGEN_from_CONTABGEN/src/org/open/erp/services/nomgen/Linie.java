package org.open.erp.services.nomgen;

public class Linie {
	public Material material;
	public Double valoare;
	public Double cantitate;
	
	public Linie(Material material, Double valoare, Double cantitate) {
		super();
		this.material = material;
		this.valoare = valoare;
		this.cantitate = cantitate;
	}

	@Override
	public String toString() {
		return "Linie [material=" + material + ", valoare=" + valoare + ", cantitate=" + cantitate + "]";
	}
}
