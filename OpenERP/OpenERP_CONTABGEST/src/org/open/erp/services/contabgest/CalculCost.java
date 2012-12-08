package org.open.erp.services.contabgest;
import org.open.erp.services.Productie.Produs;
import org.open.erp.services.contabgest.Manopera;



public  class CalculCost {

	
	private int id;
	private Produs produs;
	private Manopera manopera;
	private int pretUtilitati=103;
	public Manopera getManopera() {
		return manopera;
	}

	public CalculCost(int id, Produs produs, Manopera manopera)
	{
		this.id=id;
		this.produs=produs;
		this.manopera=manopera;
	}
	public void setManopera(Manopera manopera) {
		this.manopera = manopera;
	}


	
	public  double costFinal() //returneaza costul final al produsului
	{
		
		double cost= (this.produs.getReteta().getCantitateM()* Double.parseDouble(this.produs.getReteta().getMaterial().getPretStandard())
				+  this.produs.getReteta().getCantitateS() * this.produs.getReteta().getSemifabricat().getPretSemifabricat()+
				this.manopera.calculManopera())*this.pretUtilitati/100;
			return cost;
	}
	public void InregistreazaCost()
	{
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produs getProdus() {
		return produs;
	}

	public void setProdus(Produs produs) {
		this.produs = produs;
	}

	


}
