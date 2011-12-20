package org.open.erp.services.achizitii;


import org.open.erp.services.nomgen.Material;
/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Articol extends Material {	
    private Categorie categorieArticol;
    private Double pretAchizitie;

	
	public Double getPretAchizitie() {
		return pretAchizitie;
	}

	public void setPretAchizitie(Double pretAchizitie) {
		this.pretAchizitie = pretAchizitie;
	}

	public Articol(Integer id, String denumire, String unitateMasura,			
			Categorie categorieArticol) {
		super(id, denumire, unitateMasura);
		this.categorieArticol = categorieArticol;
	}

	public Categorie getCategorieArticol() {
		return categorieArticol;
	}

	public void setCategorieArticol(Categorie categorieArticol) {
		this.categorieArticol = categorieArticol;
	}
		
	

}
