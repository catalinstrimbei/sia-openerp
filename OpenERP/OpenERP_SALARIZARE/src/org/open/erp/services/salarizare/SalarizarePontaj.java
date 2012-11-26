package org.open.erp.services.salarizare;

import java.util.Date;

public class SalarizarePontaj {
	Date dataPontaj;
	Integer nrOreLucrate;
	Integer nrOreSuplimentare;
	String tipIntrerupere;
	Integer oreIntrerupere;
	Integer zileLucrare;
	/**
	 * @return the dataPontaj
	 */
	public Date getDataPontaj() {
		return dataPontaj;
	}
	/**
	 * @param dataPontaj the dataPontaj to set
	 */
	public void setDataPontaj(Date dataPontaj) {
		this.dataPontaj = dataPontaj;
	}
	/**
	 * @return the nrOreLucrate
	 */
	public Integer getNrOreLucrate() {
		return nrOreLucrate;
	}
	/**
	 * @param nrOreLucrate the nrOreLucrate to set
	 */
	public void setNrOreLucrate(Integer nrOreLucrate) {
		this.nrOreLucrate = nrOreLucrate;
	}
	/**
	 * @return the nrOreSuplimentare
	 */
	public Integer getNrOreSuplimentare() {
		return nrOreSuplimentare;
	}
	/**
	 * @param nrOreSuplimentare the nrOreSuplimentare to set
	 */
	public void setNrOreSuplimentare(Integer nrOreSuplimentare) {
		this.nrOreSuplimentare = nrOreSuplimentare;
	}
	/**
	 * @return the tipIntrerupere
	 */
	public String getTipIntrerupere() {
		return tipIntrerupere;
	}
	/**
	 * @param tipIntrerupere the tipIntrerupere to set
	 */
	public void setTipIntrerupere(String tipIntrerupere) {
		this.tipIntrerupere = tipIntrerupere;
	}
	/**
	 * @return the oreIntrerupere
	 */
	public Integer getOreIntrerupere() {
		return oreIntrerupere;
	}
	/**
	 * @param oreIntrerupere the oreIntrerupere to set
	 */
	public void setOreIntrerupere(Integer oreIntrerupere) {
		this.oreIntrerupere = oreIntrerupere;
	}
	/**
	 * @return the zileLucrare
	 */
	public Integer getZileLucrare() {
		return zileLucrare;
	}
	/**
	 * @param zileLucrare the zileLucrare to set
	 */
	public void setZileLucrare(Integer zileLucrare) {
		this.zileLucrare = zileLucrare;
	}
	public SalarizarePontaj(Date dataPontaj, Integer nrOreLucrate,
			Integer nrOreSuplimentare, String tipIntrerupere,
			Integer oreIntrerupere, Integer zileLucrare) {
		super();
		this.dataPontaj = dataPontaj;
		this.nrOreLucrate = nrOreLucrate;
		this.nrOreSuplimentare = nrOreSuplimentare;
		this.tipIntrerupere = tipIntrerupere;
		this.oreIntrerupere = oreIntrerupere;
		this.zileLucrare = zileLucrare;
	}
	public SalarizarePontaj() {
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
				+ ((dataPontaj == null) ? 0 : dataPontaj.hashCode());
		result = prime * result
				+ ((nrOreLucrate == null) ? 0 : nrOreLucrate.hashCode());
		result = prime
				* result
				+ ((nrOreSuplimentare == null) ? 0 : nrOreSuplimentare
						.hashCode());
		result = prime * result
				+ ((oreIntrerupere == null) ? 0 : oreIntrerupere.hashCode());
		result = prime * result
				+ ((tipIntrerupere == null) ? 0 : tipIntrerupere.hashCode());
		result = prime * result
				+ ((zileLucrare == null) ? 0 : zileLucrare.hashCode());
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
		SalarizarePontaj other = (SalarizarePontaj) obj;
		if (dataPontaj == null) {
			if (other.dataPontaj != null)
				return false;
		} else if (!dataPontaj.equals(other.dataPontaj))
			return false;
		if (nrOreLucrate == null) {
			if (other.nrOreLucrate != null)
				return false;
		} else if (!nrOreLucrate.equals(other.nrOreLucrate))
			return false;
		if (nrOreSuplimentare == null) {
			if (other.nrOreSuplimentare != null)
				return false;
		} else if (!nrOreSuplimentare.equals(other.nrOreSuplimentare))
			return false;
		if (oreIntrerupere == null) {
			if (other.oreIntrerupere != null)
				return false;
		} else if (!oreIntrerupere.equals(other.oreIntrerupere))
			return false;
		if (tipIntrerupere == null) {
			if (other.tipIntrerupere != null)
				return false;
		} else if (!tipIntrerupere.equals(other.tipIntrerupere))
			return false;
		if (zileLucrare == null) {
			if (other.zileLucrare != null)
				return false;
		} else if (!zileLucrare.equals(other.zileLucrare))
			return false;
		return true;
	}	
}
