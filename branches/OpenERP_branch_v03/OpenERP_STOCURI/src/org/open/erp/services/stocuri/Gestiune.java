package org.open.erp.services.stocuri;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Gestiune {
	private Integer idGestiune;
	private String denumire;
	private Depozit depozit;
	private List<ArticolStoc>articole = new ArrayList<ArticolStoc>();
	public Gestiune() {
		super();
	}
	public Gestiune(Integer idGestiune, String denumire, Depozit depozit) {
		super();
		this.idGestiune = idGestiune;
		this.denumire = denumire;
		this.depozit = depozit;
	}
	
	public void addArticole(ArticolStoc art){
		this.articole.add(art);
	}
	public void removeArticole(ArticolStoc art){
		this.articole.remove(art);
	}
	
	
	public List<ArticolStoc> getArticole() {
		return articole;
	}
	public Integer getIdGestiune() {
		return idGestiune;
	}
	public void setIdGestiune(Integer idGestiune) {
		this.idGestiune = idGestiune;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public Depozit getDepozit() {
		return depozit;
	}
	public void setDepozit(Depozit depozit) {
		this.depozit = depozit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idGestiune == null) ? 0 : idGestiune.hashCode());
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
		Gestiune other = (Gestiune) obj;
		if (idGestiune == null) {
			if (other.idGestiune != null)
				return false;
		} else if (!idGestiune.equals(other.idGestiune))
			return false;
		return true;
	}
	
	
	
	
}
