package org.open.erp.services.nomgen;

import java.util.*;
public class Material  {

	protected Integer id;
	protected String  denumire;
	protected String  unitateMasura;
	protected Date    dataFabricatiei;
	protected Integer termenValabilitate;
	protected String tipContabil;
	protected Float greutate;
	protected String descriere;
	
	
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
	public String getTipContabil() {
		return  tipContabil;
	}
	public void setTipContabil(String tipContabil) {
		this.tipContabil = tipContabil;
	}
	public Material(Integer id, String denumire, String unitateMasura,
			Date dataFabricatiei, Integer termenValabilitate, Float greutate, String descriere) {
		super();
		this.id = id;
		this.denumire = denumire;
		this.unitateMasura = unitateMasura;
		this.dataFabricatiei = dataFabricatiei;
		this.termenValabilitate = termenValabilitate;
		this.greutate=greutate;
		this.descriere=descriere;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}
	public Material(Integer id, String denumire, String unitateMasura) {
		super();
		this.id = id;
		this.denumire = denumire;
		this.unitateMasura = unitateMasura;
	}	
	
}
