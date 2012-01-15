package org.open.erp.services.achizitii;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.open.erp.services.nomgen.Material;
/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class Articol extends Material implements Serializable {	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne@JoinColumn(name="id_cat")
    private Categorie categorieArticol;
    private Double pretAchizitie;

	
	public Articol() {
		super();
	}

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
