package org.open.erp.services.Productie;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.Productie.Produs;

public class Reteta {
	private Integer IdReteta;
	private Produs produs;
	private Material material;
	private Semifabricat semifabricat;
	private Double cantitateM;
	private Double cantitateS;
	
	public Double getCantitateM() {
		return cantitateM;
	}
	public void setCantitateM(Double cantitateM) {
		this.cantitateM = cantitateM;
	}
	public Double getCantitateS() {
		return cantitateS;
	}
	public void setCantitateS(Double cantitateS) {
		this.cantitateS = cantitateS;
	}
	
	public Integer getIdReteta() {
		return IdReteta;
	}
	public void setIdReteta(Integer idReteta) {
		IdReteta = idReteta;
	}
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}

	public Semifabricat getSemifabricat() {
		return semifabricat;
	}
	public void setSemifabricat(Semifabricat semifabricat) {
		this.semifabricat = semifabricat;
	}
	
	public Reteta(Integer idReteta, Produs produs, Material materiePrima,
			Semifabricat semifabricat, Double cantitateM,Double cantitateS) {
		super();
		IdReteta = idReteta;
		this.produs = produs;
		this.material = materiePrima;
		this.semifabricat = semifabricat;
		this.cantitateM = cantitateM;
		this.cantitateS=cantitateS;
	}
	public Reteta() {
		super();
		// TODO Auto-generated constructor stub
	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result
//				+ ((IdReteta == null) ? 0 : IdReteta.hashCode());
//		result = prime * result
//				+ ((cantitate == null) ? 0 : cantitate.hashCode());
//		result = prime * result
//				+ ((materiePrima == null) ? 0 : materiePrima.hashCode());
//		result = prime * result + ((produs == null) ? 0 : produs.hashCode());
//		result = prime * result
//				+ ((semifabricat == null) ? 0 : semifabricat.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Reteta other = (Reteta) obj;
//		if (IdReteta == null) {
//			if (other.IdReteta != null)
//				return false;
//		} else if (!IdReteta.equals(other.IdReteta))
//			return false;
//		if (cantitate == null) {
//			if (other.cantitate != null)
//				return false;
//		} else if (!cantitate.equals(other.cantitate))
//			return false;
//		if (materiePrima == null) {
//			if (other.materiePrima != null)
//				return false;
//		} else if (!materiePrima.equals(other.materiePrima))
//			return false;
//		if (produs == null) {
//			if (other.produs != null)
//				return false;
//		} else if (!produs.equals(other.produs))
//			return false;
//		if (semifabricat == null) {
//			if (other.semifabricat != null)
//				return false;
//		} else if (!semifabricat.equals(other.semifabricat))
//			return false;
//		return true;
//	}
//	
//	
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
}
