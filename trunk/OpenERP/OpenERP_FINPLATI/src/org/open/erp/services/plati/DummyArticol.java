package org.open.erp.services.plati;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.open.erp.services.nomgen.Material;
//import javax.persistence.TableGenerator;
/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class DummyArticol extends Material implements Serializable {	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4821410858811466708L;
	/**
	 * 
	 */
	
	@ManyToOne@JoinColumn(name="id_cat")
    private DummyCategorie categorieArticol;
    private Double pretAchizitie;

	
	public DummyArticol() {
		super();
	}
 
	public Double getPretAchizitie() {
		return pretAchizitie;
	}

	public void setPretAchizitie(Double pretAchizitie) {
		this.pretAchizitie = pretAchizitie;
	}

	public DummyArticol(Integer id, String denumire, String unitateMasura,			
			DummyCategorie categorieArticol) {
		super(id, denumire, unitateMasura);
		this.categorieArticol = categorieArticol;
	}
	

	public DummyArticol(Integer idMaterial, String denumire, String categorie,
			String uM, String tipContabil, DummyCategorie categorieArticol,
			Double pretAchizitie) {
		super(idMaterial, denumire, categorie, uM, tipContabil);
		this.categorieArticol = categorieArticol;
		this.pretAchizitie = pretAchizitie;
	}

	public DummyCategorie getCategorieArticol() {
		return categorieArticol;
	}

	public void setCategorieArticol(DummyCategorie categorieArticol) {
		this.categorieArticol = categorieArticol;
	}

	

}
