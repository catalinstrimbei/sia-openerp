package org.open.erp.services.Productie;

public class Semifabricat {
	private Integer IdSemifabricat;
	private String denumireSemifabricat;
	//private FazaProductie fazaProductie;
	private Integer pretSemifabricat;
	public Integer getIdSemifabricat() {
		return IdSemifabricat;
	}
	public void setIdSemifabricat(Integer idSemifabricat) {
		IdSemifabricat = idSemifabricat;
	}
	public String getDenumireSemifabricat() {
		return denumireSemifabricat;
	}
	public void setDenumireSemifabricat(String denumireSemifabricat) {
		this.denumireSemifabricat = denumireSemifabricat;
	}
//	public FazaProductie getFazaProductie() {
//		return fazaProductie;
//	}
//	public void setFazaProductie(FazaProductie fazaProductie) {
//		this.fazaProductie = fazaProductie;
//	}
//	public Semifabricat(Integer idSemifabricat, String denumireSemifabricat,
//			FazaProductie fazaProductie) {
//		super();
//		IdSemifabricat = idSemifabricat;
//		this.denumireSemifabricat = denumireSemifabricat;
//		this.fazaProductie = fazaProductie;
//	}
	public Semifabricat() {
		super();
		// TODO Auto-generated constructor stub
	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result
//				+ ((IdSemifabricat == null) ? 0 : IdSemifabricat.hashCode());
//		result = prime
//				* result
//				+ ((denumireSemifabricat == null) ? 0 : denumireSemifabricat
//						.hashCode());
//		result = prime * result
//				+ ((fazaProductie == null) ? 0 : fazaProductie.hashCode());
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
//		Semifabricat other = (Semifabricat) obj;
//		if (IdSemifabricat == null) {
//			if (other.IdSemifabricat != null)
//				return false;
//		} else if (!IdSemifabricat.equals(other.IdSemifabricat))
//			return false;
//		if (denumireSemifabricat == null) {
//			if (other.denumireSemifabricat != null)
//				return false;
//		} else if (!denumireSemifabricat.equals(other.denumireSemifabricat))
//			return false;
//		if (fazaProductie == null) {
//			if (other.fazaProductie != null)
//				return false;
//		} else if (!fazaProductie.equals(other.fazaProductie))
//			return false;
//		return true;
//	}
//	
	public Integer getPretSemifabricat() {
		return pretSemifabricat;
	}
	public void setPretSemifabricat(Integer pretSemifabricat) {
		this.pretSemifabricat = pretSemifabricat;
	}
	
}
