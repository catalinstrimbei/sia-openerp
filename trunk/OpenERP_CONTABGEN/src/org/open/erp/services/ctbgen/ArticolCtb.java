package org.open.erp.services.ctbgen;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Entity)
 * 
 */

public class ArticolCtb extends SablonNC {
	private Integer idArt;
	private Integer nrLinArt;
	private String denArt;
	private Double sumaDC;

	public ArticolCtb() {
	}
	
	public ArticolCtb(Integer idSablon, Integer nrSablon, Cont contDebit, Cont contCredit, Integer idArt, Integer nrLinArt, String denArt, Double sumaDC) {
		super(idSablon, nrSablon, contDebit, contCredit);
		this.idArt = idArt;
		this.nrLinArt = nrLinArt;
		this.denArt = denArt;
		this.sumaDC = sumaDC;
	}

	public Integer getIdArt() {
		return idArt;
	}

	public void setIdArt(Integer idArt) {
		this.idArt = idArt;
	}

	public Integer getNrLinArt() {
		return nrLinArt;
	}

	public void setNrLinArt(Integer nrLinArt) {
		this.nrLinArt = nrLinArt;
	}

	public String getDenArt() {
		return denArt;
	}

	public void setDenArt(String denArt) {
		this.denArt = denArt;
	}

	public Double getSumaDC() {
		return sumaDC;
	}

	public void setSumaDC(Double sumaDC) {
		this.sumaDC = sumaDC;
	}

	@Override
	public String toString() {
		return "ArticolCtb [idArt=" + idArt + ", nrLinArt=" + nrLinArt + ", denArt=" + denArt + ", sumaDC=" + sumaDC + "]";
	}
}
