package org.open.erp.services.nomenclatoare;
/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class Material {
	private Integer codMijlocCirculant;
	private String denumire;
	private String UM;
	public Material() {
		super();
	}
	public Material(Integer codMijlocCirculant, String denumire,
			String uM) {
		super();
		this.codMijlocCirculant = codMijlocCirculant;
		this.denumire = denumire;
		UM = uM;
	}
	public Integer getCodMijlocCirculant() {
		return codMijlocCirculant;
	}
	public void setCodMijlocCirculant(Integer codMijlocCirculant) {
		this.codMijlocCirculant = codMijlocCirculant;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getUM() {
		return UM;
	}
	public void setUM(String uM) {
		UM = uM;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codMijlocCirculant == null) ? 0 : codMijlocCirculant
						.hashCode());
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
		Material other = (Material) obj;
		if (codMijlocCirculant == null) {
			if (other.codMijlocCirculant != null)
				return false;
		} else if (!codMijlocCirculant.equals(other.codMijlocCirculant))
			return false;
		return true;
	}
	
	
	
	
	
}
