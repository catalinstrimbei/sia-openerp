package org.open.erp.services.nomgen;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import org.open.erp.services.nommat.Material;



@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class LinieDocument implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	protected Integer linieDoc; 
	
	//@ManyToOne @JoinColumn(name = "material_id")
	//protected Material material;
	
	@ManyToOne @JoinColumn(name = "documentParinte_nrDocument")
	Document documentParinte; 
	
	protected Double cantitate = 0.0;  
	protected Double pret = 0.0;  
	protected Double TVA = 0.0 ;
	
	public Integer getLinieDoc() {
		return linieDoc;
	}
	public void setLinieDoc(Integer linieDoc) {
		this.linieDoc = linieDoc;
	}
	//public Material getMaterial() {
	//	return material;
	//}
	//public void setMaterial(Material material) {
	//	this.material = material;
	//}
	public Document getDocumentParinte() {
		return documentParinte;
	}
	public void setDocumentParinte(Document documentParinte) {
		this.documentParinte = documentParinte;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public Double getPret() {
		return pret;
	}
	public void setPret(Double pret) {
		this.pret = pret;
	}
	public Double getTVA() {
		return TVA;
	}
	public void setTVA(Double tVA) {
		TVA = tVA;
	}
	
	public LinieDocument(Integer linieDoc, Document documentParinte, Double cantitate, Double pret, Double tVA) {
		super();
		this.linieDoc = linieDoc;
		//this.material = material;
		this.documentParinte = documentParinte;
		this.cantitate = cantitate;
		this.pret = pret;
		TVA = tVA;
	}
	
	public LinieDocument() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TVA == null) ? 0 : TVA.hashCode());
		result = prime * result
				+ ((cantitate == null) ? 0 : cantitate.hashCode());
		result = prime * result
				+ ((documentParinte == null) ? 0 : documentParinte.hashCode());
		result = prime * result
				+ ((linieDoc == null) ? 0 : linieDoc.hashCode());
		//result = prime * result
		//		+ ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((pret == null) ? 0 : pret.hashCode());
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
		LinieDocument other = (LinieDocument) obj;
		if (TVA == null) {
			if (other.TVA != null)
				return false;
		} else if (!TVA.equals(other.TVA))
			return false;
		if (cantitate == null) {
			if (other.cantitate != null)
				return false;
		} else if (!cantitate.equals(other.cantitate))
			return false;
		if (documentParinte == null) {
			if (other.documentParinte != null)
				return false;
		} else if (!documentParinte.equals(other.documentParinte))
			return false;
		if (linieDoc == null) {
			if (other.linieDoc != null)
				return false;
		} else if (!linieDoc.equals(other.linieDoc))
			return false;
	//	if (material == null) {
	//		if (other.material != null)
	//			return false;
	//	} else if (!material.equals(other.material))
	//		return false;
		if (pret == null) {
			if (other.pret != null)
				return false;
		} else if (!pret.equals(other.pret))
			return false;
		return true;
	}
	
	
}
