package org.open.erp.services.achizitii;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.open.erp.services.nomgen.Material;

public class Articol extends Material {
	public List<Furnizor> furnizori =new LinkedList<Furnizor>();

	public Articol(Integer idMaterial, String denumire, String categorie,
			String uM, Integer stocCurent, List<Furnizor> furnizori) {
		super(idMaterial,denumire,"UM",new Date(),2);		
		this.furnizori = furnizori;
	}
	

}
