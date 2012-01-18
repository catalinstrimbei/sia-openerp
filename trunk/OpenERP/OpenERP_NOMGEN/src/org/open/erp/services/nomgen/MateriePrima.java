package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/*
 * @author Echipa NomGen
 * @BusinessObject(DummyEntity)
 * 
 */
@Entity
public class MateriePrima extends Material implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@Id @GeneratedValue
	private Integer id;
  
	private String  denumireMateriePrima;
    
	private String  unitateMasura;
	private Date    dataFabricatiei;
	private Integer termenValabilitate;
	@OneToOne @JoinColumn(name= "idMaterial")
	private Material m;
	
	
	
	/**
	 * @return the id
	 */

	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	
	public Material getM() {
		return m;
	}

	public void setM(Material m) {
		this.m = m;
	}

	/**
	 * @return the denumire
	 */
	public String getDenumire() {
		return denumireMateriePrima;
	}

	/**
	 * @param denumire the denumire to set
	 */
	public void setDenumire(String denumire) {
		this.denumireMateriePrima = denumire;
	}

	
	/**
	 * @return the unitateMasura
	 */
	public String getUnitateMasura() {
		return unitateMasura;
	}

	/**
	 * @param unitateMasura the unitateMasura to set
	 */
	public void setUnitateMasura(String unitateMasura) {
		this.unitateMasura = unitateMasura;
	}

	
	/**
	 * @return the dataFabricatiei
	 */
	public Date getDataFabricatiei() {
		return dataFabricatiei;
	}

	/**
	 * @param dataFabricatiei the dataFabricatiei to set
	 */
	public void setDataFabricatiei(Date dataFabricatiei) {
		this.dataFabricatiei = dataFabricatiei;
	}

	
	/**
	 * @return the termenValabilitate
	 */
	public Integer getTermenValabilitate() {
		return termenValabilitate;
	}

	/**
	 * @param termenValabilitate the termenValabilitate to set
	 */
	public void setTermenValabilitate(Integer termenValabilitate) {
		this.termenValabilitate = termenValabilitate;
	}

	
	public MateriePrima(Integer id, String denumire, String unitateMasura, Date dataFabricatiei, Integer termenValabilitate) {
		super();
		
		this.id = id;
		this.denumireMateriePrima = denumire;
		this.unitateMasura = unitateMasura;
		this.dataFabricatiei = dataFabricatiei;
		this.termenValabilitate = termenValabilitate;
	}
	
	public MateriePrima() {
		super();
	}

	public MateriePrima(Integer idMaterial, String denumire, String categorie,
			String uM, String tipContabil, Integer id, String denumire2,
			String unitateMasura, Date dataFabricatiei,
			Integer termenValabilitate, Material m) {
		super(idMaterial, denumire, categorie, uM, tipContabil);
		this.id = id;
		denumire = denumire2;
		this.unitateMasura = unitateMasura;
		this.dataFabricatiei = dataFabricatiei;
		this.termenValabilitate = termenValabilitate;
		this.m = m;
	}	
	
}