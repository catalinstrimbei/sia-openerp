package org.open.erp.services.productie;

import java.io.Serializable;

import org.open.erp.services.nomgen.MijlocFix;

public class Utilaj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Integer idUtilaj;
	
	private MijlocFix utilaj;
	
	String status;

	public Integer getIdUtilaj() {
		return idUtilaj;
	}

	public void setIdUtilaj(Integer idUtilaj) {
		this.idUtilaj = idUtilaj;
	}

	public MijlocFix getUtilaj() {
		return utilaj;
	}

	public void setUtilaj(MijlocFix utilaj) {
		this.utilaj = utilaj;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Utilaj(Integer idUtilaj, MijlocFix utilaj, String status) {
		super();
		this.idUtilaj = idUtilaj;
		this.utilaj = utilaj;
		this.status = status;
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
				+ ((idUtilaj == null) ? 0 : idUtilaj.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((utilaj == null) ? 0 : utilaj.hashCode());
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
		if (idUtilaj == null) {
			if (other.idUtilaj != null)
				return false;
		} else if (!idUtilaj.equals(other.idUtilaj))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (utilaj == null) {
			if (other.utilaj != null)
				return false;
		} else if (!utilaj.equals(other.utilaj))
			return false;
		return true;
	}
	
	
}
