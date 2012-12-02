package org.open.erp.services.Salarizare;

import java.util.Date;

public class SalarizareStatPlata {
	Date dataStatPlata;
	Double salariuBaza;
	Double salariuOreLucrate;
	Double salariuTarifar;
	Double venitBrut;
	Double cSomaj;
	Double cSanatate;
	Double cPensie;
	Double deducereBaza;
	Double impozitSalar;
	public Double getNrOreLucrate() {
		return nrOreLucrate;
	}
	public void setNrOreLucrate(Double nrOreLucrate) {
		this.nrOreLucrate = nrOreLucrate;
	}
	Double venitNet;
	Double nrOreLucrate;
	/**
	 * @return the dataStatPlata
	 */
	public Date getDataStatPlata() {
		return dataStatPlata;
	}
	/**
	 * @param dataStatPlata the dataStatPlata to set
	 */
	public void setDataStatPlata(Date dataStatPlata) {
		this.dataStatPlata = dataStatPlata;
	}
	/**
	 * @return the salariuBaza
	 */
	public Double getSalariuBaza() {
		return salariuBaza;
	}
	/**
	 * @param salariuBaza the salariuBaza to set
	 */
	public void setSalariuBaza(Double salariuBaza) {
		this.salariuBaza = salariuBaza;
	}
	/**
	 * @return the salariuOreLucrate
	 */
	public Double getSalariuOreLucrate() {
		return salariuOreLucrate;
	}
	/**
	 * @param salariuOreLucrate the salariuOreLucrate to set
	 */
	public void setSalariuOreLucrate(Double salariuOreLucrate) {
		this.salariuOreLucrate = salariuOreLucrate;
	}
	/**
	 * @return the salariuTarifar
	 */
	public Double getSalariuTarifar() {
		return salariuTarifar;
	}
	/**
	 * @param salariuTarifar the salariuTarifar to set
	 */
	public void setSalariuTarifar(Double salariuTarifar) {
		this.salariuTarifar = salariuTarifar;
	}
	/**
	 * @return the venitBrut
	 */
	public Double getVenitBrut() {
		return venitBrut;
	}
	/**
	 * @param venitBrut the venitBrut to set
	 */
	public void setVenitBrut(Double venitBrut) {
		this.venitBrut = venitBrut;
	}
	/**
	 * @return the cSomaj
	 */
	public Double getcSomaj() {
		return cSomaj;
	}
	/**
	 * @param cSomaj the cSomaj to set
	 */
	public void setcSomaj(Double cSomaj) {
		this.cSomaj = cSomaj;
	}
	/**
	 * @return the cSanatate
	 */
	public Double getcSanatate() {
		return cSanatate;
	}
	/**
	 * @param cSanatate the cSanatate to set
	 */
	public void setcSanatate(Double cSanatate) {
		this.cSanatate = cSanatate;
	}
	/**
	 * @return the cPensie
	 */
	public Double getcPensie() {
		return cPensie;
	}
	/**
	 * @param cPensie the cPensie to set
	 */
	public void setcPensie(Double cPensie) {
		this.cPensie = cPensie;
	}
	/**
	 * @return the deducereBaza
	 */
	public Double getDeducereBaza() {
		return deducereBaza;
	}
	/**
	 * @param deducereBaza the deducereBaza to set
	 */
	public void setDeducereBaza(Double deducereBaza) {
		this.deducereBaza = deducereBaza;
	}
	/**
	 * @return the impozitSalar
	 */
	public Double getImpozitSalar() {
		return impozitSalar;
	}
	/**
	 * @param impozitSalar the impozitSalar to set
	 */
	public void setImpozitSalar(Double impozitSalar) {
		this.impozitSalar = impozitSalar;
	}
	/**
	 * @return the venitNet
	 */
	public Double getVenitNet() {
		return venitNet;
	}
	/**
	 * @param venitNet the venitNet to set
	 */
	public void setVenitNet(Double venitNet) {
		this.venitNet = venitNet;
	}
	public SalarizareStatPlata(Date dataStatPlata, Double salariuBaza,
			Double salariuOreLucrate, Double salariuTarifar, Double venitBrut,
			Double cSomaj, Double cSanatate, Double cPensie,
			Double deducereBaza, Double impozitSalar, Double venitNet) {
		super();
		this.dataStatPlata = dataStatPlata;
		this.salariuBaza = salariuBaza;
		this.salariuOreLucrate = salariuOreLucrate;
		this.salariuTarifar = salariuTarifar;
		this.venitBrut = venitBrut;
		this.cSomaj = cSomaj;
		this.cSanatate = cSanatate;
		this.cPensie = cPensie;
		this.deducereBaza = deducereBaza;
		this.impozitSalar = impozitSalar;
		this.venitNet = venitNet;
	}
	public SalarizareStatPlata() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cPensie == null) ? 0 : cPensie.hashCode());
		result = prime * result
				+ ((cSanatate == null) ? 0 : cSanatate.hashCode());
		result = prime * result + ((cSomaj == null) ? 0 : cSomaj.hashCode());
		result = prime * result
				+ ((dataStatPlata == null) ? 0 : dataStatPlata.hashCode());
		result = prime * result
				+ ((deducereBaza == null) ? 0 : deducereBaza.hashCode());
		result = prime * result
				+ ((impozitSalar == null) ? 0 : impozitSalar.hashCode());
		result = prime * result
				+ ((salariuBaza == null) ? 0 : salariuBaza.hashCode());
		result = prime
				* result
				+ ((salariuOreLucrate == null) ? 0 : salariuOreLucrate
						.hashCode());
		result = prime * result
				+ ((salariuTarifar == null) ? 0 : salariuTarifar.hashCode());
		result = prime * result
				+ ((venitBrut == null) ? 0 : venitBrut.hashCode());
		result = prime * result
				+ ((venitNet == null) ? 0 : venitNet.hashCode());
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
		SalarizareStatPlata other = (SalarizareStatPlata) obj;
		if (cPensie == null) {
			if (other.cPensie != null)
				return false;
		} else if (!cPensie.equals(other.cPensie))
			return false;
		if (cSanatate == null) {
			if (other.cSanatate != null)
				return false;
		} else if (!cSanatate.equals(other.cSanatate))
			return false;
		if (cSomaj == null) {
			if (other.cSomaj != null)
				return false;
		} else if (!cSomaj.equals(other.cSomaj))
			return false;
		if (dataStatPlata == null) {
			if (other.dataStatPlata != null)
				return false;
		} else if (!dataStatPlata.equals(other.dataStatPlata))
			return false;
		if (deducereBaza == null) {
			if (other.deducereBaza != null)
				return false;
		} else if (!deducereBaza.equals(other.deducereBaza))
			return false;
		if (impozitSalar == null) {
			if (other.impozitSalar != null)
				return false;
		} else if (!impozitSalar.equals(other.impozitSalar))
			return false;
		if (salariuBaza == null) {
			if (other.salariuBaza != null)
				return false;
		} else if (!salariuBaza.equals(other.salariuBaza))
			return false;
		if (salariuOreLucrate == null) {
			if (other.salariuOreLucrate != null)
				return false;
		} else if (!salariuOreLucrate.equals(other.salariuOreLucrate))
			return false;
		if (salariuTarifar == null) {
			if (other.salariuTarifar != null)
				return false;
		} else if (!salariuTarifar.equals(other.salariuTarifar))
			return false;
		if (venitBrut == null) {
			if (other.venitBrut != null)
				return false;
		} else if (!venitBrut.equals(other.venitBrut))
			return false;
		if (venitNet == null) {
			if (other.venitNet != null)
				return false;
		} else if (!venitNet.equals(other.venitNet))
			return false;
		return true;
	}
}
