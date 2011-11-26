package org.open.erp.services.ctbgen;

public class ArticolCtb  extends SablonNC{
	private Integer idArt;
	private String denArt;
	private Double sumaDC;
	
	public Integer getIdArt() {
		return idArt;
	}
	public void setIdArt(Integer idArt) {
		this.idArt = idArt;
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
	public ArticolCtb(Integer idSablon, Integer nrSablon, Cont contDebit,
			Cont contCredit, Integer idArt, String denArt, Double sumaDC) {
		super(idSablon, nrSablon, contDebit, contCredit);
		this.idArt = idArt;
		this.denArt = denArt;
		this.sumaDC = sumaDC;
	}
	public ArticolCtb(Integer idSablon, Integer nrSablon, Cont contDebit,
			Cont contCredit) {
		super(idSablon, nrSablon, contDebit, contCredit);
	}

	public ArticolCtb(){
		
	}

	
	
	
	
}
