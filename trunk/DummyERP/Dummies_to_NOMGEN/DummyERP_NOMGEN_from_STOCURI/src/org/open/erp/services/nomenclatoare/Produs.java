package org.open.erp.services.nomenclatoare;
/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class Produs extends Material{

	private Double tva;
	public Produs() {
		super();
	}
	
	

	public Produs(Integer codMijlocCirculant, String denumire, String uM,
			Double tva) {
		super(codMijlocCirculant, denumire, uM);
		this.tva = tva;
	}



	public Double getTva() {
		return tva;
	}
	public void setTva(Double tva) {
		this.tva = tva;
	}
	
	

}
