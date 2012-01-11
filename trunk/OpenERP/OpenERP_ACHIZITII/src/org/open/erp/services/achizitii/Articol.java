package org.open.erp.services.achizitii;


import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Entity;
import org.open.erp.services.nomgen.Material;
/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
@DiscriminatorValue("Articol")
public class Articol extends Material implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@ManyToOne@JoinColumn(name="cat")
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
		
	

}
