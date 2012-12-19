package org.open.erp.services.Productie;

//aici MODIFIC!!!!!!!!!!!!!!
import java.util.HashMap;
import java.util.Map;

import org.open.erp.services.contabgest.impl.Material; /////am importat din pachetul proiectului nostru ...nu S-A REZOLVAT DEPENDENTA DUMMY



public class Reteta {
	

	private Integer IdReteta;
	public Material material;  //materialul(produsul) retetei
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material mc1) {
		this.material = mc1;
	}
	private Map <Material,Integer> materiale=new HashMap<Material,Integer> ();  //Componentele materialului	//fiecare reteta a unui produs
																					//e compusa din mai multe materiale cu diferite cantitati
	                                                                                //pe care le stocam in map
	public Map<Material, Integer> getMateriale() {
		return materiale;
	}
	public void setMateriale(Map<Material, Integer> materiale) {
		this.materiale = materiale;
	}
	public Integer getIdReteta() {
		return IdReteta;
	}
	public void setIdReteta(Integer idReteta) {
		IdReteta = idReteta;
	}
	
	
	public Reteta(Integer idReteta, Material m) {
		super();
		IdReteta = idReteta;
		this.material=m;

	}
	public Reteta() {
		super();
		// TODO Auto-generated constructor stub
	}

}
