package org.open.erp.services.contabgest;
import java.util.Map;
//AM MODIFICAT AICI!!! clasa CalculCost


import org.open.erp.services.nommat.Material;
//import org.open.erp.services.Productie.Manopera;



public  class CalculCost {

	
	private int id;
	private Material material;
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
		
//		double cost= (this.material.getReteta().getCantitateM()* this.material.getReteta().getMateriePrima().getPretStandard()
//				+  this.material.getReteta().getCantitateS() * this.material.getReteta().getSemifabricat().getPretSemifabricat()+
//				this.manopera.calculManopera())*this.pretUtilitati/100;
//				return cost;
		
		
			double costCuMaterialele=0;
			double costCuManopera=0;
			System.out.println("sasasasasa");
			System.out.println(this.material.getReteta().getMateriale().size());
			System.out.println("wtf....");
			for(Map.Entry<Material, Integer> entry : material.getReteta().getMateriale().entrySet())
			{
				costCuMaterialele=costCuMaterialele+entry.getValue()* Integer.parseInt(entry.getKey().getPretStandard());
			}
			//costCuManopera=costCuManopera+this.manopera.calculManopera()*this.pretUtilitati/100; //cand modifica ceilalti manopera punem si noi linia asta ...pt ca ei inca mai au produs in clasa respectiva;
			costCuManopera=100*this.pretUtilitati/100;
			return (costCuMaterialele+costCuManopera);
			
			//eventual aici putem seta si PretulStandard al Materialul in caz ca nu este de tip MateriePrima in clasa Material 
			//intrucat cred ca noi suntem responsabili cu calcularea pretuluiStandard.
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
