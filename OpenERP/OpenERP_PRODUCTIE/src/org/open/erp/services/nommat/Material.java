package org.open.erp.services.nommat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.open.erp.services.nomgen.LinieDocument;

public class Material implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Integer idMaterial; 
	protected String denumire; 
	protected String categorie;  
	protected String UM; 
		
	private List<LinieDocument> liniiDocumente=new ArrayList<LinieDocument>();

	public Integer getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
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

	public String getUM() {
		return UM;
	}

	public void setUM(String uM) {
		UM = uM;
	}

	public List<LinieDocument> getLiniiDocumente() {
		return liniiDocumente;
	}

	public void setLiniiDocumente(List<LinieDocument> liniiDocumente) {
		this.liniiDocumente = liniiDocumente;
	}

	public Material(Integer idMaterial, String denumire, String categorie,
			String uM, List<LinieDocument> liniiDocumente) {
		super();
		this.idMaterial = idMaterial;
		this.denumire = denumire;
		this.categorie = categorie;
		UM = uM;
		this.liniiDocumente = liniiDocumente;
	}

	public Material() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UM == null) ? 0 : UM.hashCode());
		result = prime * result
				+ ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result
				+ ((denumire == null) ? 0 : denumire.hashCode());
		result = prime * result
				+ ((idMaterial == null) ? 0 : idMaterial.hashCode());
		result = prime * result
				+ ((liniiDocumente == null) ? 0 : liniiDocumente.hashCode());
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
		if (UM == null) {
			if (other.UM != null)
				return false;
		} else if (!UM.equals(other.UM))
			return false;
		if (categorie == null) {
			if (other.categorie != null)
				return false;
		} else if (!categorie.equals(other.categorie))
			return false;
		if (denumire == null) {
			if (other.denumire != null)
				return false;
		} else if (!denumire.equals(other.denumire))
			return false;
		if (idMaterial == null) {
			if (other.idMaterial != null)
				return false;
		} else if (!idMaterial.equals(other.idMaterial))
			return false;
		if (liniiDocumente == null) {
			if (other.liniiDocumente != null)
				return false;
		} else if (!liniiDocumente.equals(other.liniiDocumente))
			return false;
		return true;
	}
	
	
}
