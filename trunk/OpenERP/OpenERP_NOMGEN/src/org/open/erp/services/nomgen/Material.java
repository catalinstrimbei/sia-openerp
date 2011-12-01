package org.open.erp.services.nomgen;

import java.util.Date;

public class Material  {

	private Integer id;
	private String  denumire;
	private String  unitateMasura;
	private Date    dataFabricatiei;
	private Integer termenValabilitate;
	
	
	
	public Material(Integer id, String denumire, String unitateMasura,
			Date dataFabricatiei, Integer termenValabilitate) {
		super();
		this.id = id;
		this.denumire = denumire;
		this.unitateMasura = unitateMasura;
		this.dataFabricatiei = dataFabricatiei;
		this.termenValabilitate = termenValabilitate;
	}
	public Material() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getUnitateMasura() {
		return unitateMasura;
	}
	public void setUnitateMasura(String unitateMasura) {
		this.unitateMasura = unitateMasura;
	}
	public Date getDataFabricatiei() {
		return dataFabricatiei;
	}
	public void setDataFabricatiei(Date dataFabricatiei) {
		this.dataFabricatiei = dataFabricatiei;
	}
	public Integer getTermenValabilitate() {
		return termenValabilitate;
	}
	public void setTermenValabilitate(Integer termenValabilitate) {
		this.termenValabilitate = termenValabilitate;
	}
	
	
	
}
