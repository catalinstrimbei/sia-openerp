package org.open.erp.services.stocuri;

/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Depozit {

	private Integer idDepozit;
	private String locatie;
	
	public Depozit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Depozit(Integer idDepozit, String locatie) {
		super();
		this.idDepozit = idDepozit;
		this.locatie = locatie;
	}
	public Integer getIdDepozit() {
		return idDepozit;
	}
	public void setIdDepozit(Integer idDepozit) {
		this.idDepozit = idDepozit;
	}
	public String getLocatie() {
		return locatie;
	}
	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idDepozit == null) ? 0 : idDepozit.hashCode());
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
		Depozit other = (Depozit) obj;
		if (idDepozit == null) {
			if (other.idDepozit != null)
				return false;
		} else if (!idDepozit.equals(other.idDepozit))
			return false;
		return true;
	}
	
	
}
