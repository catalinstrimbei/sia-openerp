package org.open.erp.services.salarizare;

import java.util.Date;

public class SalarizareSpor {
	Integer codspor;
	String tipspor;
	String modcalcul;
	Date dataSpor;
	Double marimespor;
		
	public Integer getcodspor() {
		return codspor;
	}

	public void setcodspor(Integer codspor) {
		this.codspor = codspor;
	}

	public String gettipspor() {
		return tipspor;
	}

	public void settipspor(String tipspor) {
		this.tipspor = tipspor;
	}

	public String getmodcalcul() {
		return modcalcul;
	}

	public void setmodcalcul(String modcalcul) {
		this.modcalcul = modcalcul;
	}
	
	public Date getdataSpor() {
		return dataSpor;
	}

	public void setdataSpor(Date dataSpor) {
		this.dataSpor = dataSpor;
	}
	
		public Double getmarimespor() {
		return marimespor;
	}


	public void setmarimespor(Double marimespor) {
		this.marimespor = marimespor;
	}

	public SalarizareSpor(Integer codspor, String tipspor, String modcalcul,
			Date dataSpor, Double marimespor) {
		super();
		this.codspor = codspor;
		this.tipspor = tipspor;
		this.modcalcul = modcalcul;
		this.dataSpor = dataSpor;
		this.marimespor = marimespor;
	}

	public SalarizareSpor() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codspor == null) ? 0 : codspor.hashCode());
		result = prime * result
				+ ((dataSpor == null) ? 0 : dataSpor.hashCode());
		result = prime * result
				+ ((marimespor == null) ? 0 : marimespor.hashCode());
		result = prime * result
				+ ((modcalcul == null) ? 0 : modcalcul.hashCode());
		result = prime * result + ((tipspor == null) ? 0 : tipspor.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalarizareSpor other = (SalarizareSpor) obj;
		if (codspor == null) {
			if (other.codspor != null)
				return false;
		} else if (!codspor.equals(other.codspor))
			return false;
		if (dataSpor == null) {
			if (other.dataSpor != null)
				return false;
		} else if (!dataSpor.equals(other.dataSpor))
			return false;
		if (marimespor == null) {
			if (other.marimespor != null)
				return false;
		} else if (!marimespor.equals(other.marimespor))
			return false;
		if (modcalcul == null) {
			if (other.modcalcul != null)
				return false;
		} else if (!modcalcul.equals(other.modcalcul))
			return false;
		if (tipspor == null) {
			if (other.tipspor != null)
				return false;
		} else if (!tipspor.equals(other.tipspor))
			return false;
		return true;
	}
}
