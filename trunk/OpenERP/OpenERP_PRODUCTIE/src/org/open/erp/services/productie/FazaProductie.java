package org.open.erp.services.productie;

import java.util.ArrayList;
import java.util.List;

import org.open.erp.services.nomgen.Divizie;

public class FazaProductie {
	private Integer idfaza;
	private String denumirefaza;
	private FluxProductie fluxproductie;
	private Divizie divizie;
	private List<FunctiePerFaza> FunctiePerFaza = new ArrayList<FunctiePerFaza>(); 
	
	public Integer getIdfaza() {
		return idfaza;
	}
	public void setIdfaza(Integer idfaza) {
		this.idfaza = idfaza;
	}
	public String getDenumirefaza() {
		return denumirefaza;
	}
	public void setDenumirefaza(String denumirefaza) {
		this.denumirefaza = denumirefaza;
	}
	public FluxProductie getFluxproductie() {
		return fluxproductie;
	}
	public void setFluxproductie(FluxProductie fluxproductie) {
		this.fluxproductie = fluxproductie;
	}
	
	public Divizie getDivizie() {
		return divizie;
	}
	public void setDivizie(Divizie divizie) {
		this.divizie = divizie;
	}
	
	public FazaProductie(Integer idfaza, String denumirefaza,
			FluxProductie fluxproductie, Divizie divizie) {
		super();
		this.idfaza = idfaza;
		this.denumirefaza = denumirefaza;
		this.fluxproductie = fluxproductie;
		this.divizie = divizie;
	}
	public FazaProductie() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((FunctiePerFaza == null) ? 0 : FunctiePerFaza.hashCode());
		result = prime * result
				+ ((denumirefaza == null) ? 0 : denumirefaza.hashCode());
		result = prime * result + ((divizie == null) ? 0 : divizie.hashCode());
		result = prime * result
				+ ((fluxproductie == null) ? 0 : fluxproductie.hashCode());
		result = prime * result + ((idfaza == null) ? 0 : idfaza.hashCode());
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
		FazaProductie other = (FazaProductie) obj;
		if (FunctiePerFaza == null) {
			if (other.FunctiePerFaza != null)
				return false;
		} else if (!FunctiePerFaza.equals(other.FunctiePerFaza))
			return false;
		if (denumirefaza == null) {
			if (other.denumirefaza != null)
				return false;
		} else if (!denumirefaza.equals(other.denumirefaza))
			return false;
		if (divizie == null) {
			if (other.divizie != null)
				return false;
		} else if (!divizie.equals(other.divizie))
			return false;
		if (fluxproductie == null) {
			if (other.fluxproductie != null)
				return false;
		} else if (!fluxproductie.equals(other.fluxproductie))
			return false;
		if (idfaza == null) {
			if (other.idfaza != null)
				return false;
		} else if (!idfaza.equals(other.idfaza))
			return false;
		return true;
	}
	public List<FunctiePerFaza> getFunctiePerFaza() {
		return FunctiePerFaza;
	}
	public void setFunctiePerFaza(List<FunctiePerFaza> functiePerFaza) {
		FunctiePerFaza = functiePerFaza;
	}
	public FazaProductie(
			List<org.open.erp.services.productie.FunctiePerFaza> functiePerFaza) {
		super();
		FunctiePerFaza = functiePerFaza;
	}
	
	
	
	
	
}
