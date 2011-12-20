package org.open.erp.services.productie;


import java.util.ArrayList;

import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.MateriePrima;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.personal.*;

/**
 * 
 * @author Echipa Productie
 * 
 * @BusinessObject(Entity)
 */

public class FazaProductie {

	String faza;
	Utilaj utilaj;
	Double timpFolosire;
	ArrayList <FunctieNecesara> functiiNecesare;
	ArrayList <Angajat> angajati;
	ArrayList <MateriePrima> materialeReteta;
	Semifabricat semifabricatReteta;
	Semifabricat semifabricatDorit;
	Produs produsDorit;
	Semifabricat semifabricatObtinut;
	Produs produsObtinut;
	Divizie sectie;

	
	
		
	public FazaProductie() {
		super();
	}

	public Utilaj getUtilaj() {
		return utilaj;
	}

	public void setUtilaj(Utilaj utilaj) {
		this.utilaj = utilaj;
	}

	public ArrayList<FunctieNecesara> getFunctiiNecesare() {
		return functiiNecesare;
	}

	public void setFunctiiNecesare(ArrayList<FunctieNecesara> functiiNecesare) {
		this.functiiNecesare = functiiNecesare;
	}

	public FazaProductie(String faza, Utilaj utilaj, Double timpFolosire,
			ArrayList<FunctieNecesara> functiiNecesare, ArrayList<Angajat> angajati,
			ArrayList<MateriePrima> materialeReteta,
			Semifabricat semifabricatReteta, Semifabricat semifabricatDorit,
			Produs produsDorit, Divizie sectie) {
		super();
		this.faza = faza;
		this.utilaj = utilaj;
		this.timpFolosire = timpFolosire;
		this.functiiNecesare = functiiNecesare;
		this.angajati = angajati;
		this.materialeReteta = materialeReteta;
		this.semifabricatReteta = semifabricatReteta;
		this.semifabricatDorit = semifabricatDorit;
		this.produsDorit = produsDorit;
		this.sectie=sectie;
		
		
	}

	public String getFaza() {
		return faza;
	}

	public void setFaza(String faza) {
		this.faza = faza;
	}

	public Double getTimpFolosire() {
		return timpFolosire;
	}

	public void setTimpFolosire(Double timpFolosire) {
		this.timpFolosire = timpFolosire;
	}

	public ArrayList<Angajat> getAngajati() {
		return angajati;
	}

	public void setAngajati(ArrayList<Angajat> angajati) {
		this.angajati = angajati;
	}

	public ArrayList<MateriePrima> getMaterialeReteta() {
		return materialeReteta;
	}

	public void setMaterialeReteta(ArrayList<MateriePrima> materialeReteta) {
		this.materialeReteta = materialeReteta;
	}

	public Semifabricat getSemifabricatReteta() {
		return semifabricatReteta;
	}

	public void setSemifabricatReteta(Semifabricat semifabricatReteta) {
		this.semifabricatReteta = semifabricatReteta;
	}

	public Semifabricat getSemifabricatDorit() {
		return semifabricatDorit;
	}

	public void setSemifabricatDorit(Semifabricat semifabricatDorit) {
		this.semifabricatDorit = semifabricatDorit;
	}

	public Produs getProdusDorit() {
		return produsDorit;
	}

	public void setProdusDorit(Produs produsDorit) {
		this.produsDorit = produsDorit;
	}

	

	public Divizie getSectie() {
		return sectie;
	}

	public void setSectie(Divizie sectie) {
		this.sectie = sectie;
	}

	public Semifabricat procesareSemifabricat(){
		
		utilaj.setStatus("ocupat");
		
		if (semifabricatDorit.getListaMateriale()== materialeReteta && 
				semifabricatDorit.getSemifabricatContinut()== semifabricatReteta){
			
			semifabricatObtinut=semifabricatDorit;
			utilaj.setStatus("liber");
				}
		else{
			semifabricatObtinut=null;
			System.out.println("Lista materialelor nu corespunde");
			}
		return semifabricatObtinut;
		
	}
	
	 public Produs procesareProdus(){
	     
	     utilaj.setStatus("ocupat");
	     if(semifabricatDorit.semifabricat==produsDorit.getDenumire())
	     {produsObtinut=produsDorit;
	      utilaj.setStatus("liber");
	     }
	     else {
	      produsObtinut=null;
	      System.out.println("Nu s-a obtinut produsul dorit");
	     }
	     return produsObtinut;
	     
	    }
	
}
