package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * @author Echipa NomGen
 * @BusinessObject(DummyEntity)
 * @BusinessObject(Entity)
 */
@Entity
public class Produs extends Material implements Serializable{
	private Integer id;
	private String  denumire;
	private String  unitateMasura;
	private Date    dataFabricatiei;
	private Integer termenValabilitate;
	private Double pretVanzare= 0.0;
	private Float procentTVA;
	private static final long serialVersionUID = 1L;
	
	 @ManyToOne @JoinColumn(name = "idMaterial")
	 private Material mat;
	public Float getProcentTVA() {
		return procentTVA;
	}

	public void setProcentTVA(Float procentTVA) {
		this.procentTVA = procentTVA;
	}

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

	
	/**
	 * @return the denumire
	 */
	public String getDenumire() {
		return denumire;
	}

	/**
	 * @param denumire the denumire to set
	 */
	public void setDenumire(String denumire) {
		this.denumire = denumire;
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

	
	public Double getPretVanzare() {
		return pretVanzare;
	}

	public void setPretVanzare(Double pretVanzare) {
		this.pretVanzare = pretVanzare;
	}

	public Material getMat() {
		return mat;
	}

	public void setMat(Material mat) {
		this.mat = mat;
	}

	public Produs(Integer id, String denumire, String unitateMasura, Date dataFabricatiei, Integer termenValabilitate) {
		super();
		
		this.id = id;
		this.denumire = denumire;
		this.unitateMasura = unitateMasura;
		this.dataFabricatiei = dataFabricatiei;
		this.termenValabilitate = termenValabilitate;
	}
	
	public Produs() {
		super();
	}

	public Produs(Integer id, String denumire, String uM, Date dataFabricatiei, Integer termenValabilitate, Float procentTVA, Double pretVanzare){
		super();
		this.id = id;
		this.denumire = denumire;
		this.unitateMasura = uM;
		this.dataFabricatiei = dataFabricatiei;
		this.termenValabilitate = termenValabilitate;
		this.procentTVA = procentTVA;
		this.pretVanzare = pretVanzare;

		}

	public Produs(int i, String string, String string2, Date date, int j,
			float f, float g, String string3, double d) {
		super();
		this.id = id;
		this.denumire = denumire;
		//this.unitateMasura = uM;
		this.dataFabricatiei = dataFabricatiei;
		this.termenValabilitate = termenValabilitate;
		this.procentTVA = procentTVA;
		this.pretVanzare = pretVanzare;
	}

	public Produs(Integer idMaterial, String denumire, String categorie,
			String uM, String tipContabil, Integer id, String denumire2,
			String unitateMasura, Date dataFabricatiei,
			Integer termenValabilitate, Double pretVanzare, Float procentTVA,
			Material mat) {
		super(idMaterial, denumire, categorie, uM, tipContabil);
		this.id = id;
		denumire = denumire2;
		this.unitateMasura = unitateMasura;
		this.dataFabricatiei = dataFabricatiei;
		this.termenValabilitate = termenValabilitate;
		this.pretVanzare = pretVanzare;
		this.procentTVA = procentTVA;
		this.mat = mat;
	}
	
	
}