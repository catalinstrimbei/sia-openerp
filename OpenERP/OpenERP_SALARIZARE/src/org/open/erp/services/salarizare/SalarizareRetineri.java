package org.open.erp.services.salarizare;

import java.util.Date;

public class SalarizareRetineri {
	Integer codRetinere;
	String denRetinere;
	String tipRetinere;
	Double procentRetinere;
	Date dataRetinere;
	Double valoareRetinere;
	/**
	 * @return the codRetinere
	 */
	public Integer getCodRetinere() {
		return codRetinere;
	}
	/**
	 * @param codRetinere the codRetinere to set
	 */
	public void setCodRetinere(Integer codRetinere) {
		this.codRetinere = codRetinere;
	}
	/**
	 * @return the denRetinere
	 */
	public String getDenRetinere() {
		return denRetinere;
	}
	/**
	 * @param denRetinere the denRetinere to set
	 */
	public void setDenRetinere(String denRetinere) {
		this.denRetinere = denRetinere;
	}
	/**
	 * @return the tipRetinere
	 */
	public String getTipRetinere() {
		return tipRetinere;
	}
	/**
	 * @param tipRetinere the tipRetinere to set
	 */
	public void setTipRetinere(String tipRetinere) {
		this.tipRetinere = tipRetinere;
	}
	/**
	 * @return the procentRetinere
	 */
	public Double getProcentRetinere() {
		return procentRetinere;
	}
	/**
	 * @param procentRetinere the procentRetinere to set
	 */
	public void setProcentRetinere(Double procentRetinere) {
		this.procentRetinere = procentRetinere;
	}
	/**
	 * @return the dataRetinere
	 */
	public Date getDataRetinere() {
		return dataRetinere;
	}
	/**
	 * @param dataRetinere the dataRetinere to set
	 */
	public void setDataRetinere(Date dataRetinere) {
		this.dataRetinere = dataRetinere;
	}
	/**
	 * @return the valoareRetinere
	 */
	public Double getValoareRetinere() {
		return valoareRetinere;
	}
	/**
	 * @param valoareRetinere the valoareRetinere to set
	 */
	public void setValoareRetinere(Double valoareRetinere) {
		this.valoareRetinere = valoareRetinere;
	}
	public SalarizareRetineri(Integer codRetinere, String denRetinere,
			String tipRetinere, Double procentRetinere, Date dataRetinere,
			Double valoareRetinere) {
		super();
		this.codRetinere = codRetinere;
		this.denRetinere = denRetinere;
		this.tipRetinere = tipRetinere;
		this.procentRetinere = procentRetinere;
		this.dataRetinere = dataRetinere;
		this.valoareRetinere = valoareRetinere;
	}
	public SalarizareRetineri() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codRetinere == null) ? 0 : codRetinere.hashCode());
		result = prime * result
				+ ((dataRetinere == null) ? 0 : dataRetinere.hashCode());
		result = prime * result
				+ ((denRetinere == null) ? 0 : denRetinere.hashCode());
		result = prime * result
				+ ((procentRetinere == null) ? 0 : procentRetinere.hashCode());
		result = prime * result
				+ ((tipRetinere == null) ? 0 : tipRetinere.hashCode());
		result = prime * result
				+ ((valoareRetinere == null) ? 0 : valoareRetinere.hashCode());
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
		SalarizareRetineri other = (SalarizareRetineri) obj;
		if (codRetinere == null) {
			if (other.codRetinere != null)
				return false;
		} else if (!codRetinere.equals(other.codRetinere))
			return false;
		if (dataRetinere == null) {
			if (other.dataRetinere != null)
				return false;
		} else if (!dataRetinere.equals(other.dataRetinere))
			return false;
		if (denRetinere == null) {
			if (other.denRetinere != null)
				return false;
		} else if (!denRetinere.equals(other.denRetinere))
			return false;
		if (procentRetinere == null) {
			if (other.procentRetinere != null)
				return false;
		} else if (!procentRetinere.equals(other.procentRetinere))
			return false;
		if (tipRetinere == null) {
			if (other.tipRetinere != null)
				return false;
		} else if (!tipRetinere.equals(other.tipRetinere))
			return false;
		if (valoareRetinere == null) {
			if (other.valoareRetinere != null)
				return false;
		} else if (!valoareRetinere.equals(other.valoareRetinere))
			return false;
		return true;
	}
}
