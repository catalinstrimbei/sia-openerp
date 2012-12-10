package org.open.erp.services.stocuri;

import java.util.ArrayList;
import java.util.List;
import org.open.erp.services.personal.Angajat;

/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Gestiune {
	private Integer idGest;
	private String  id;
	private String denumireGest;
	private Depozit depozit;
	private List<Articol>  articole = new ArrayList<Articol>();
	private Angajat responsabilGestiune;
	
	public Angajat getResponsabilGestiune() {
		return responsabilGestiune;
	}

	public void setResponsabilGestiune(Angajat responsabilGestiune) {
		this.responsabilGestiune = responsabilGestiune;
	}

	public Gestiune() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Gestiune(Integer idGest, String denumireGest, Depozit depozit) {
		super();
		this.idGest = idGest;
		this.denumireGest = denumireGest;
		this.depozit = depozit;
	}
	
	public void addArticole(Articol articol){
		this.articole.add(articol);
	}
	public void removeArticole(Articol articol){
		this.articole.remove(articol);
	}
	
	public Integer getIdGest() {
		return idGest;
	}
	public void setIdGest(Integer idGest) {
		this.idGest = idGest;
	}
	public String getDenumireGest() {
		return denumireGest;
	}
	public void setDenumireGest(String denumireGest) {
		this.denumireGest = denumireGest;
	}
	public Depozit getDepozit() {
		return depozit;
	}
	public void setDepozit(Depozit depozit) {
		this.depozit = depozit;
	}
	public List<Articol> getArticole() {
		return articole;
	}
	public void setArticole(List<Articol> articole) {
		this.articole = articole;
	}

	
	public Gestiune(Integer idGest, String denumireGest) {
		this.idGest = idGest;
		this.denumireGest = denumireGest;
	}

	public Gestiune(String id, String denumireGest) {
		this.id = id;
		this.denumireGest = denumireGest;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGest == null) ? 0 : idGest.hashCode());
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
		if (idGest == null) {
			if (other.idGest != null)
				return false;
		} else if (!idGest.equals(other.idGest))
			return false;
		return true;
	}
	

}
