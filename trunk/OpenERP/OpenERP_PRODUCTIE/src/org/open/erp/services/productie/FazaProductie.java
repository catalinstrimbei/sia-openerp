package org.open.erp.services.productie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.Produs;
import org.open.erp.services.personal.Angajat;

public class FazaProductie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String faza;
	FluxProductie flux;
	Utilaj utilaj;
	Double timpFolosire;
		
	private List<FunctieNecesara> functiiNecesare = new ArrayList<FunctieNecesara>();
	
	private List<Angajat> angajati = new ArrayList<Angajat>();
	
	private List<Material> materialeReteta= new ArrayList<Material>();
	
	Semifabricat semifabricatReteta;
	
	Semifabricat semifabricatDorit;
	
	Produs produsDorit;
	
	Semifabricat semifabricatObtinut;
	
	Produs produsObtinut;
	
	Divizie sectie;
	
	FunctieNecesara functieNecesare;
	
	Material materialReteta;
	
	Integer nrOrdine;
	Boolean isFinal;
	
	public String getFaza() {
		return faza;
	}
	public void setFaza(String faza) {
		this.faza = faza;
	}
	public FluxProductie getFlux() {
		return flux;
	}
	public void setFlux(FluxProductie flux) {
		this.flux = flux;
	}
	public Utilaj getUtilaj() {
		return utilaj;
	}
	public void setUtilaj(Utilaj utilaj) {
		this.utilaj = utilaj;
	}
	public Double getTimpFolosire() {
		return timpFolosire;
	}
	public void setTimpFolosire(Double timpFolosire) {
		this.timpFolosire = timpFolosire;
	}
	public List<FunctieNecesara> getFunctiiNecesare() {
		return functiiNecesare;
	}
	public void setFunctiiNecesare(List<FunctieNecesara> functiiNecesare) {
		this.functiiNecesare = functiiNecesare;
	}
	public List<Angajat> getAngajati() {
		return angajati;
	}
	public void setAngajati(List<Angajat> angajati) {
		this.angajati = angajati;
	}
	public List<Material> getMaterialeReteta() {
		return materialeReteta;
	}
	public void setMaterialeReteta(List<Material> materialeReteta) {
		this.materialeReteta = materialeReteta;
	}
	public Semifabricat getSemifabricatReteta() {
		return semifabricatReteta;
	}
	public void setSemifabricatReteta(Semifabricat semifabricatReteta) {
		this.semifabricatReteta = semifabricatReteta;
	}
	public Semifabricat getSemifabricatDorit() {
		return semifabricatDorit;
	}
	public void setSemifabricatDorit(Semifabricat semifabricatDorit) {
		this.semifabricatDorit = semifabricatDorit;
	}
	public Produs getProdusDorit() {
		return produsDorit;
	}
	public void setProdusDorit(Produs produsDorit) {
		this.produsDorit = produsDorit;
	}
	public Semifabricat getSemifabricatObtinut() {
		return semifabricatObtinut;
	}
	public void setSemifabricatObtinut(Semifabricat semifabricatObtinut) {
		this.semifabricatObtinut = semifabricatObtinut;
	}
	public Produs getProdusObtinut() {
		return produsObtinut;
	}
	public void setProdusObtinut(Produs produsObtinut) {
		this.produsObtinut = produsObtinut;
	}
	public Divizie getSectie() {
		return sectie;
	}
	public void setSectie(Divizie sectie) {
		this.sectie = sectie;
	}
	public FunctieNecesara getFunctieNecesare() {
		return functieNecesare;
	}
	public void setFunctieNecesare(FunctieNecesara functieNecesare) {
		this.functieNecesare = functieNecesare;
	}
	public Material getMaterialReteta() {
		return materialReteta;
	}
	public void setMaterialReteta(Material materialReteta) {
		this.materialReteta = materialReteta;
	}
	public Integer getNrOrdine() {
		return nrOrdine;
	}
	public void setNrOrdine(Integer nrOrdine) {
		this.nrOrdine = nrOrdine;
	}
	public Boolean getIsFinal() {
		return isFinal;
	}
	public void setIsFinal(Boolean isFinal) {
		this.isFinal = isFinal;
	}
	
	public FazaProductie(String faza, FluxProductie flux, Utilaj utilaj,
			Double timpFolosire, List<FunctieNecesara> functiiNecesare,
			List<Angajat> angajati, List<Material> materialeReteta,
			Semifabricat semifabricatReteta, Semifabricat semifabricatDorit,
			Produs produsDorit, Semifabricat semifabricatObtinut,
			Produs produsObtinut, Divizie sectie,
			FunctieNecesara functieNecesare, Material materialReteta,
			Integer nrOrdine, Boolean isFinal) {
		super();
		this.faza = faza;
		this.flux = flux;
		this.utilaj = utilaj;
		this.timpFolosire = timpFolosire;
		this.functiiNecesare = functiiNecesare;
		this.angajati = angajati;
		this.materialeReteta = materialeReteta;
		this.semifabricatReteta = semifabricatReteta;
		this.semifabricatDorit = semifabricatDorit;
		this.produsDorit = produsDorit;
		this.semifabricatObtinut = semifabricatObtinut;
		this.produsObtinut = produsObtinut;
		this.sectie = sectie;
		this.functieNecesare = functieNecesare;
		this.materialReteta = materialReteta;
		this.nrOrdine = nrOrdine;
		this.isFinal = isFinal;
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
				+ ((angajati == null) ? 0 : angajati.hashCode());
		result = prime * result + ((faza == null) ? 0 : faza.hashCode());
		result = prime * result + ((flux == null) ? 0 : flux.hashCode());
		result = prime * result
				+ ((functieNecesare == null) ? 0 : functieNecesare.hashCode());
		result = prime * result
				+ ((functiiNecesare == null) ? 0 : functiiNecesare.hashCode());
		result = prime * result + ((isFinal == null) ? 0 : isFinal.hashCode());
		result = prime * result
				+ ((materialReteta == null) ? 0 : materialReteta.hashCode());
		result = prime * result
				+ ((materialeReteta == null) ? 0 : materialeReteta.hashCode());
		result = prime * result
				+ ((nrOrdine == null) ? 0 : nrOrdine.hashCode());
		result = prime * result
				+ ((produsDorit == null) ? 0 : produsDorit.hashCode());
		result = prime * result
				+ ((produsObtinut == null) ? 0 : produsObtinut.hashCode());
		result = prime * result + ((sectie == null) ? 0 : sectie.hashCode());
		result = prime
				* result
				+ ((semifabricatDorit == null) ? 0 : semifabricatDorit
						.hashCode());
		result = prime
				* result
				+ ((semifabricatObtinut == null) ? 0 : semifabricatObtinut
						.hashCode());
		result = prime
				* result
				+ ((semifabricatReteta == null) ? 0 : semifabricatReteta
						.hashCode());
		result = prime * result
				+ ((timpFolosire == null) ? 0 : timpFolosire.hashCode());
		result = prime * result + ((utilaj == null) ? 0 : utilaj.hashCode());
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
		if (angajati == null) {
			if (other.angajati != null)
				return false;
		} else if (!angajati.equals(other.angajati))
			return false;
		if (faza == null) {
			if (other.faza != null)
				return false;
		} else if (!faza.equals(other.faza))
			return false;
		if (flux == null) {
			if (other.flux != null)
				return false;
		} else if (!flux.equals(other.flux))
			return false;
		if (functieNecesare == null) {
			if (other.functieNecesare != null)
				return false;
		} else if (!functieNecesare.equals(other.functieNecesare))
			return false;
		if (functiiNecesare == null) {
			if (other.functiiNecesare != null)
				return false;
		} else if (!functiiNecesare.equals(other.functiiNecesare))
			return false;
		if (isFinal == null) {
			if (other.isFinal != null)
				return false;
		} else if (!isFinal.equals(other.isFinal))
			return false;
		if (materialReteta == null) {
			if (other.materialReteta != null)
				return false;
		} else if (!materialReteta.equals(other.materialReteta))
			return false;
		if (materialeReteta == null) {
			if (other.materialeReteta != null)
				return false;
		} else if (!materialeReteta.equals(other.materialeReteta))
			return false;
		if (nrOrdine == null) {
			if (other.nrOrdine != null)
				return false;
		} else if (!nrOrdine.equals(other.nrOrdine))
			return false;
		if (produsDorit == null) {
			if (other.produsDorit != null)
				return false;
		} else if (!produsDorit.equals(other.produsDorit))
			return false;
		if (produsObtinut == null) {
			if (other.produsObtinut != null)
				return false;
		} else if (!produsObtinut.equals(other.produsObtinut))
			return false;
		if (sectie == null) {
			if (other.sectie != null)
				return false;
		} else if (!sectie.equals(other.sectie))
			return false;
		if (semifabricatDorit == null) {
			if (other.semifabricatDorit != null)
				return false;
		} else if (!semifabricatDorit.equals(other.semifabricatDorit))
			return false;
		if (semifabricatObtinut == null) {
			if (other.semifabricatObtinut != null)
				return false;
		} else if (!semifabricatObtinut.equals(other.semifabricatObtinut))
			return false;
		if (semifabricatReteta == null) {
			if (other.semifabricatReteta != null)
				return false;
		} else if (!semifabricatReteta.equals(other.semifabricatReteta))
			return false;
		if (timpFolosire == null) {
			if (other.timpFolosire != null)
				return false;
		} else if (!timpFolosire.equals(other.timpFolosire))
			return false;
		if (utilaj == null) {
			if (other.utilaj != null)
				return false;
		} else if (!utilaj.equals(other.utilaj))
			return false;
		return true;
	}
	
	
}
