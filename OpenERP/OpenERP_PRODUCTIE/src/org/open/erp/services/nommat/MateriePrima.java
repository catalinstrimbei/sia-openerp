package org.open.erp.services.nommat;

import java.io.Serializable;
import java.util.Date;

public class MateriePrima implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String  denumireMateriePrima;
	protected String categorie;  
	private String  unitateMasura;
	private Date    dataFabricatiei;
	private Integer termenValabilitate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDenumireMateriePrima() {
		return denumireMateriePrima;
	}
	public void setDenumireMateriePrima(String denumireMateriePrima) {
		this.denumireMateriePrima = denumireMateriePrima;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
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
	
	public MateriePrima(Integer id, String denumireMateriePrima,
			String categorie, String unitateMasura, Date dataFabricatiei,
			Integer termenValabilitate) {
		super();
		this.id = id;
		this.denumireMateriePrima = denumireMateriePrima;
		this.categorie = categorie;
		this.unitateMasura = unitateMasura;
		this.dataFabricatiei = dataFabricatiei;
		this.termenValabilitate = termenValabilitate;
	}
	
	public MateriePrima() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result
				+ ((dataFabricatiei == null) ? 0 : dataFabricatiei.hashCode());
		result = prime
				* result
				+ ((denumireMateriePrima == null) ? 0 : denumireMateriePrima
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((termenValabilitate == null) ? 0 : termenValabilitate
						.hashCode());
		result = prime * result
				+ ((unitateMasura == null) ? 0 : unitateMasura.hashCode());
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
		MateriePrima other = (MateriePrima) obj;
		if (categorie == null) {
			if (other.categorie != null)
				return false;
		} else if (!categorie.equals(other.categorie))
			return false;
		if (dataFabricatiei == null) {
			if (other.dataFabricatiei != null)
				return false;
		} else if (!dataFabricatiei.equals(other.dataFabricatiei))
			return false;
		if (denumireMateriePrima == null) {
			if (other.denumireMateriePrima != null)
				return false;
		} else if (!denumireMateriePrima.equals(other.denumireMateriePrima))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (termenValabilitate == null) {
			if (other.termenValabilitate != null)
				return false;
		} else if (!termenValabilitate.equals(other.termenValabilitate))
			return false;
		if (unitateMasura == null) {
			if (other.unitateMasura != null)
				return false;
		} else if (!unitateMasura.equals(other.unitateMasura))
			return false;
		return true;
	}
	
	
}
