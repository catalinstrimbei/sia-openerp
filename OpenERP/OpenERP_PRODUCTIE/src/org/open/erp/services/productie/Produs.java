package org.open.erp.services.productie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import static javax.persistence.CascadeType.ALL;

import org.open.erp.services.nomgen.LinieDocument;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Produs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	protected Integer idProdus; 
	
	protected String denumire; 
	protected String categorie;  
	private String  unitateMasura;
	private Date    dataFabricatiei;
	private Integer termenValabilitate;
	private Double pretVanzare= 0.0;
	private Float procentTVA;
	
	//@OneToMany(mappedBy="material",targetEntity=LinieDocument.class, cascade = ALL)
	//private List<LinieDocument> liniiDocumente=new ArrayList<LinieDocument>();
	
	public Integer getIdProdus() {
		return idProdus;
	}
	public void setIdProdus(Integer idProdus) {
		this.idProdus = idProdus;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
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
	public Double getPretVanzare() {
		return pretVanzare;
	}
	public void setPretVanzare(Double pretVanzare) {
		this.pretVanzare = pretVanzare;
	}
	public Float getProcentTVA() {
		return procentTVA;
	}
	public void setProcentTVA(Float procentTVA) {
		this.procentTVA = procentTVA;
	}
	//public List<LinieDocument> getLiniiDocumente() {
	//	return liniiDocumente;
	//}
	//public void setLiniiDocumente(List<LinieDocument> liniiDocumente) {
	//	this.liniiDocumente = liniiDocumente;
	//}
	
	public Produs(Integer idProdus, String denumire, String categorie,
			String unitateMasura, Date dataFabricatiei,
			Integer termenValabilitate, Double pretVanzare, Float procentTVA,
			List<LinieDocument> liniiDocumente) {
		super();
		this.idProdus = idProdus;
		this.denumire = denumire;
		this.categorie = categorie;
		this.unitateMasura = unitateMasura;
		this.dataFabricatiei = dataFabricatiei;
		this.termenValabilitate = termenValabilitate;
		this.pretVanzare = pretVanzare=0.0;
		this.procentTVA = procentTVA;
	//	this.liniiDocumente = liniiDocumente;
	}
	public Produs() {
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
		result = prime * result
				+ ((denumire == null) ? 0 : denumire.hashCode());
		result = prime * result
				+ ((idProdus == null) ? 0 : idProdus.hashCode());
	//	result = prime * result
	//			+ ((liniiDocumente == null) ? 0 : liniiDocumente.hashCode());
		result = prime * result
				+ ((pretVanzare == null) ? 0 : pretVanzare.hashCode());
		result = prime * result
				+ ((procentTVA == null) ? 0 : procentTVA.hashCode());
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
		Produs other = (Produs) obj;
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
		if (denumire == null) {
			if (other.denumire != null)
				return false;
		} else if (!denumire.equals(other.denumire))
			return false;
		if (idProdus == null) {
			if (other.idProdus != null)
				return false;
		} else if (!idProdus.equals(other.idProdus))
			return false;
	//	if (liniiDocumente == null) {
	//		if (other.liniiDocumente != null)
	//			return false;
	//	} else if (!liniiDocumente.equals(other.liniiDocumente))
	//		return false;
		if (pretVanzare == null) {
			if (other.pretVanzare != null)
				return false;
		} else if (!pretVanzare.equals(other.pretVanzare))
			return false;
		if (procentTVA == null) {
			if (other.procentTVA != null)
				return false;
		} else if (!procentTVA.equals(other.procentTVA))
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
