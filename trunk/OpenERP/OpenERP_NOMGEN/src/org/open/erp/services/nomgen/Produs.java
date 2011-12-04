package org.open.erp.services.nomgen;

import java.util.Date;

/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class Produs extends Material{
	private Integer id;
	private String  denumire;
	private String  unitateMasura;
	private Date    dataFabricatiei;
	private Integer termenValabilitate;
	private Float procentTVA;
	private Float greutate;
	private String descriere;
	private Double pretVanzare;
	
	public Double getPretVanzare() {
		return pretVanzare;
	}

	public void setPretVanzare(Double pretVanzare) {
		this.pretVanzare = pretVanzare;
	}

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	public Float getGreutate() {
		return greutate;
	}

	public void setGreutate(Float greutate) {
		this.greutate = greutate;
	}


	
	
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

	
	public Produs(Integer id, String denumire, String unitateMasura, 
			Date dataFabricatiei, Integer termenValabilitate,
			Float procentTVA, Float greutate, String descriere, 
			Double pretVanzare) {
		super();
		
		this.id = id;
		this.denumire = denumire;
		this.unitateMasura = unitateMasura;
		this.dataFabricatiei = dataFabricatiei;
		this.termenValabilitate = termenValabilitate;
		this.procentTVA = procentTVA;
		this.greutate = greutate;
		this.descriere = descriere;
		this.pretVanzare = pretVanzare;
	}
	
	public Produs() {
		super();
	}	
}