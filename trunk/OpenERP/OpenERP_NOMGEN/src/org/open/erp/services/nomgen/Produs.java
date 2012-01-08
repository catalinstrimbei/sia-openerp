package org.open.erp.services.nomgen;

import java.util.Date;

import javax.persistence.Entity;

/*
 * @author Echipa NomGen
 * @BusinessObject(DummyEntity)
 * @BusinessObject(Entity)
 */
@Entity
public class Produs extends Material{
	public Integer id;
	public String  denumire;
	public String  unitateMasura;
	public Date    dataFabricatiei;
	public Integer termenValabilitate;
	public Double pretVanzare= 0.0;
	public Float procentTVA;
	
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
	
}