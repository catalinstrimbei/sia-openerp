package org.open.erp.services.personal;

import java.io.Serializable;

import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Persoana;

public class Angajat extends Persoana implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer			marca;	
	private Boolean			activ;
	
	public Integer getMarca() {
		return marca;
	}
	public void setMarca(Integer marca) {
		this.marca = marca;
	}
	public Boolean getActiv() {
		return activ;
	}
	public void setActiv(Boolean activ) {
		this.activ = activ;
	}
	
	public Angajat(Integer id, Departament dep, String adresa, Integer marca,
			Boolean activ) {
		super(id, dep, adresa);
		this.marca = marca;
		this.activ = activ;
	}
	
	public Angajat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Angajat(Integer id, Departament dep, String adresa) {
		super(id, dep, adresa);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((activ == null) ? 0 : activ.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
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
		Angajat other = (Angajat) obj;
		if (activ == null) {
			if (other.activ != null)
				return false;
		} else if (!activ.equals(other.activ))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		return true;
	}
	
	
}
