package org.open.erp.services.productie;

import org.open.erp.services.nomgen.Divizie;

public class Utilaj {
	private Integer IdUtilaj;
	private String denumireUtilaj;
	private Divizie divizie;
	public Integer getIdUtilaj() {
		return IdUtilaj;
	}
	public void setIdUtilaj(Integer idUtilaj) {
		IdUtilaj = idUtilaj;
	}
	public String getDenumireUtilaj() {
		return denumireUtilaj;
	}
	public void setDenumireUtilaj(String denumireUtilaj) {
		this.denumireUtilaj = denumireUtilaj;
	}
	public Divizie getDivizie() {
		return divizie;
	}
	public void setDivizie(Divizie divizie) {
		this.divizie = divizie;
	}
	public Utilaj(Integer idUtilaj, String denumireUtilaj, Divizie divizie) {
		super();
		IdUtilaj = idUtilaj;
		this.denumireUtilaj = denumireUtilaj;
		this.divizie = divizie;
	}
	public Utilaj() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((IdUtilaj == null) ? 0 : IdUtilaj.hashCode());
		result = prime * result
				+ ((denumireUtilaj == null) ? 0 : denumireUtilaj.hashCode());
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
		Utilaj other = (Utilaj) obj;
		if (IdUtilaj == null) {
			if (other.IdUtilaj != null)
				return false;
		} else if (!IdUtilaj.equals(other.IdUtilaj))
			return false;
		if (denumireUtilaj == null) {
			if (other.denumireUtilaj != null)
				return false;
		} else if (!denumireUtilaj.equals(other.denumireUtilaj))
			return false;
		if (divizie == null) {
			if (other.divizie != null)
				return false;
		} else if (!divizie.equals(other.divizie))
			return false;
		return true;
	}

	
}
