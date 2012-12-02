package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.List;

public class Divizie extends Departament implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Departament IdDepartament;
	private String denumire;
	private String atributii;
	
	public Departament getIdDepartament() {
		return IdDepartament;
	}
	public void setIdDepartament(Departament idDepartament) {
		IdDepartament = idDepartament;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getAtributii() {
		return atributii;
	}
	public void setAtributii(String atributii) {
		this.atributii = atributii;
	}
	
	public Divizie(Integer id, String denumire, String atributii,
			List<Divizie> divizie, Departament idDepartament, String denumire2,
			String atributii2) {
		super(id, denumire, atributii, divizie);
		IdDepartament = idDepartament;
		denumire = denumire2;
		atributii = atributii2;
	}
	
	public Divizie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Divizie(Integer id, String denumire, String atributii,
			List<Divizie> divizie) {
		super(id, denumire, atributii, divizie);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((IdDepartament == null) ? 0 : IdDepartament.hashCode());
		result = prime * result
				+ ((atributii == null) ? 0 : atributii.hashCode());
		result = prime * result
				+ ((denumire == null) ? 0 : denumire.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Divizie other = (Divizie) obj;
		if (IdDepartament == null) {
			if (other.IdDepartament != null)
				return false;
		} else if (!IdDepartament.equals(other.IdDepartament))
			return false;
		if (atributii == null) {
			if (other.atributii != null)
				return false;
		} else if (!atributii.equals(other.atributii))
			return false;
		if (denumire == null) {
			if (other.denumire != null)
				return false;
		} else if (!denumire.equals(other.denumire))
			return false;
		return true;
	}
	
	
}
