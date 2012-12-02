package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Departament implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer Id;
	private String Denumire;
	private String Atributii;
	private List<Divizie> divizie = new ArrayList<Divizie>();
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getDenumire() {
		return Denumire;
	}
	public void setDenumire(String denumire) {
		Denumire = denumire;
	}
	public String getAtributii() {
		return Atributii;
	}
	public void setAtributii(String atributii) {
		Atributii = atributii;
	}
	public List<Divizie> getDivizie() {
		return divizie;
	}
	public void setDivizie(List<Divizie> divizie) {
		this.divizie = divizie;
	}
	
	public Departament(Integer id, String denumire, String atributii,
			List<Divizie> divizie) {
		super();
		Id = id;
		Denumire = denumire;
		Atributii = atributii;
		this.divizie = divizie;
	}
	
	public Departament() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Atributii == null) ? 0 : Atributii.hashCode());
		result = prime * result
				+ ((Denumire == null) ? 0 : Denumire.hashCode());
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((divizie == null) ? 0 : divizie.hashCode());
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
		Departament other = (Departament) obj;
		if (Atributii == null) {
			if (other.Atributii != null)
				return false;
		} else if (!Atributii.equals(other.Atributii))
			return false;
		if (Denumire == null) {
			if (other.Denumire != null)
				return false;
		} else if (!Denumire.equals(other.Denumire))
			return false;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (divizie == null) {
			if (other.divizie != null)
				return false;
		} else if (!divizie.equals(other.divizie))
			return false;
		return true;
	}
	
	
}
