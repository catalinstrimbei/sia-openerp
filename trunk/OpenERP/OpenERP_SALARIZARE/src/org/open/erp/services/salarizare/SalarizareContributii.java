package org.open.erp.services.salarizare;

public class SalarizareContributii {
	Integer idContributie;
	Double angajatSanatate;
	Double angajatorSanatate;
	Double angajatSomaj;
	Double angajatorSomaj;
	Double angajatPensie;
	Double angajatorPensie;
	/**
	 * @return the idContributie
	 */
	public Integer getIdContributie() {
		return idContributie;
	}
	/**
	 * @param idContributie the idContributie to set
	 */
	public void setIdContributie(Integer idContributie) {
		this.idContributie = idContributie;
	}
	/**
	 * @return the angajatSanatate
	 */
	public Double getAngajatSanatate() {
		return angajatSanatate;
	}
	/**
	 * @param angajatSanatate the angajatSanatate to set
	 */
	public void setAngajatSanatate(Double angajatSanatate) {
		this.angajatSanatate = angajatSanatate;
	}
	/**
	 * @return the angajatorSanatate
	 */
	public Double getAngajatorSanatate() {
		return angajatorSanatate;
	}
	/**
	 * @param angajatorSanatate the angajatorSanatate to set
	 */
	public void setAngajatorSanatate(Double angajatorSanatate) {
		this.angajatorSanatate = angajatorSanatate;
	}
	/**
	 * @return the angajatSomaj
	 */
	public Double getAngajatSomaj() {
		return angajatSomaj;
	}
	/**
	 * @param angajatSomaj the angajatSomaj to set
	 */
	public void setAngajatSomaj(Double angajatSomaj) {
		this.angajatSomaj = angajatSomaj;
	}
	/**
	 * @return the angajatorSomaj
	 */
	public Double getAngajatorSomaj() {
		return angajatorSomaj;
	}
	/**
	 * @param angajatorSomaj the angajatorSomaj to set
	 */
	public void setAngajatorSomaj(Double angajatorSomaj) {
		this.angajatorSomaj = angajatorSomaj;
	}
	/**
	 * @return the angajatPensie
	 */
	public Double getAngajatPensie() {
		return angajatPensie;
	}
	/**
	 * @param angajatPensie the angajatPensie to set
	 */
	public void setAngajatPensie(Double angajatPensie) {
		this.angajatPensie = angajatPensie;
	}
	/**
	 * @return the angajatorPensie
	 */
	public Double getAngajatorPensie() {
		return angajatorPensie;
	}
	/**
	 * @param angajatorPensie the angajatorPensie to set
	 */
	public void setAngajatorPensie(Double angajatorPensie) {
		this.angajatorPensie = angajatorPensie;
	}
	public SalarizareContributii(Integer idContributie, Double angajatSanatate,
			Double angajatorSanatate, Double angajatSomaj,
			Double angajatorSomaj, Double angajatPensie, Double angajatorPensie) {
		super();
		this.idContributie = idContributie;
		this.angajatSanatate = angajatSanatate;
		this.angajatorSanatate = angajatorSanatate;
		this.angajatSomaj = angajatSomaj;
		this.angajatorSomaj = angajatorSomaj;
		this.angajatPensie = angajatPensie;
		this.angajatorPensie = angajatorPensie;
	}
	public SalarizareContributii() {
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
				+ ((angajatPensie == null) ? 0 : angajatPensie.hashCode());
		result = prime * result
				+ ((angajatSanatate == null) ? 0 : angajatSanatate.hashCode());
		result = prime * result
				+ ((angajatSomaj == null) ? 0 : angajatSomaj.hashCode());
		result = prime * result
				+ ((angajatorPensie == null) ? 0 : angajatorPensie.hashCode());
		result = prime
				* result
				+ ((angajatorSanatate == null) ? 0 : angajatorSanatate
						.hashCode());
		result = prime * result
				+ ((angajatorSomaj == null) ? 0 : angajatorSomaj.hashCode());
		result = prime * result
				+ ((idContributie == null) ? 0 : idContributie.hashCode());
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
		SalarizareContributii other = (SalarizareContributii) obj;
		if (angajatPensie == null) {
			if (other.angajatPensie != null)
				return false;
		} else if (!angajatPensie.equals(other.angajatPensie))
			return false;
		if (angajatSanatate == null) {
			if (other.angajatSanatate != null)
				return false;
		} else if (!angajatSanatate.equals(other.angajatSanatate))
			return false;
		if (angajatSomaj == null) {
			if (other.angajatSomaj != null)
				return false;
		} else if (!angajatSomaj.equals(other.angajatSomaj))
			return false;
		if (angajatorPensie == null) {
			if (other.angajatorPensie != null)
				return false;
		} else if (!angajatorPensie.equals(other.angajatorPensie))
			return false;
		if (angajatorSanatate == null) {
			if (other.angajatorSanatate != null)
				return false;
		} else if (!angajatorSanatate.equals(other.angajatorSanatate))
			return false;
		if (angajatorSomaj == null) {
			if (other.angajatorSomaj != null)
				return false;
		} else if (!angajatorSomaj.equals(other.angajatorSomaj))
			return false;
		if (idContributie == null) {
			if (other.idContributie != null)
				return false;
		} else if (!idContributie.equals(other.idContributie))
			return false;
		return true;
	}
	
}
