package org.open.erp.services.stocuri;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.open.erp.services.nomgen.Material;

/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
@NamedQuery(name = "getArticoleStocByGestiune", query = "Select o from ArticolStoc o where o.gestiune.idGestiune := idGest")
public class ArticolStoc {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idArticolStoc;
	private Integer catitateStocPeGestiune;
	private Integer cantitateMinimaStoc;

	@ManyToOne
	@JoinColumn(name = "idGestiune")
	private Gestiune gestiune;
	@ManyToOne
	@JoinColumn(name = "material")
	private Material material;
	@OneToMany(mappedBy = "articol", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<LoturiIntrari> loturiIntrariArt = new LinkedList<LoturiIntrari>();

	public ArticolStoc() {
		super();
	}

	public void addLotIntrare(LoturiIntrari lot) {
		this.loturiIntrariArt.add(lot);
		catitateStocPeGestiune += lot.getCantitate();
		lot.setArticol(this);
	}

	public void removeLotIntrare(LoturiIntrari lot) {
		this.loturiIntrariArt.remove(lot);
		catitateStocPeGestiune -= lot.getCantitate();
	}

	public void incrementeazaCantArticolPeGestiune(Integer cant) {
		this.catitateStocPeGestiune += cant;
	}

	public void decrementeazaCantArticolPeGestiune(Integer cant) {
		this.catitateStocPeGestiune -= cant;
	}

	public ArticolStoc(Integer idArticolStoc, Integer catitateStocPeGestiune,
			Gestiune gestiune, Material material) {
		super();
		this.idArticolStoc = idArticolStoc;
		this.catitateStocPeGestiune = catitateStocPeGestiune;
		this.gestiune = gestiune;
		this.material = material;
	}

	public ArticolStoc(Integer idArticolStoc, Integer catitateStocPeGestiune,
			Gestiune gestiune) {
		super();
		this.idArticolStoc = idArticolStoc;
		this.catitateStocPeGestiune = catitateStocPeGestiune;
		this.gestiune = gestiune;

	}

	public Integer getIdArticolStoc() {
		return idArticolStoc;
	}

	public void setIdArticolStoc(Integer idArticolStoc) {
		this.idArticolStoc = idArticolStoc;
	}

	public Integer getCatitateStocPeGestiune() {
		return catitateStocPeGestiune;
	}

	public void setCatitateStocPeGestiune(Integer catitateStocPeGestiune) {
		this.catitateStocPeGestiune = catitateStocPeGestiune;
	}

	public Gestiune getGestiune() {
		return gestiune;
	}

	public void setGestiune(Gestiune gestiune) {
		this.gestiune = gestiune;
	}

	public List<LoturiIntrari> getLoturiIntrariArt() {
		return loturiIntrariArt;
	}

	public void setLoturiIntrariArt(LinkedList<LoturiIntrari> preturiPeLoturi) {
		this.loturiIntrariArt = preturiPeLoturi;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Integer getCantitateMinimaStoc() {
		return cantitateMinimaStoc;
	}

	public void setCantitateMinimaStoc(Integer cantitateMinimaStoc) {
		this.cantitateMinimaStoc = cantitateMinimaStoc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idArticolStoc == null) ? 0 : idArticolStoc.hashCode());
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
		ArticolStoc other = (ArticolStoc) obj;
		if (idArticolStoc == null) {
			if (other.idArticolStoc != null)
				return false;
		} else if (!idArticolStoc.equals(other.idArticolStoc))
			return false;
		return true;
	}

}
