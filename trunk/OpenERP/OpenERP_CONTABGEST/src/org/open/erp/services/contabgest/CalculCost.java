package org.open.erp.services.contabgest;
import org.open.erp.services.Productie.Manopera;
import org.open.erp.services.Productie.Produs;


public  class CalculCost {

	
	private int id;
	private Produs produs;
	private Manopera manopera;
	private int pretUtilitati=103;
	public Manopera getManopera() {
		return manopera;
	}

	public void setManopera(Manopera manopera) {
		this.manopera = manopera;
	}


	
	public  double costFinal() //returneaza costul final al produsului
	{
		
		double cost= (this.produs.getReteta().getCantitateM()* this.produs.getReteta().getMateriePrima().getPretStandard()
				+  this.produs.getReteta().getCantitateS() * this.produs.getReteta().getSemifabricat().getPretSemifabricat()+
				this.manopera.calculManopera())*this.pretUtilitati/100;
		
			return cost;
		
		
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
