package org.open.erp.services.ctbgen;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Entity)
 * 
 */

public class TipContabil {
	private Integer idTipContabil;
	private String denumireTip;
	private Cont contProprietar;
	private Cont contIntrare;
	private Cont contIesire;
	
	public TipContabil(String denumireTip, Cont contProprietar, Cont contIntrare, Cont contIesire) {
		super();
		this.idTipContabil=-1;
		this.denumireTip = denumireTip;
		this.contProprietar = contProprietar;
		this.contIntrare = contIntrare;
		this.contIesire = contIesire;
	}
	
	public TipContabil(Integer idTipContabil, String denumireTip, Cont contProprietar, Cont contIntrare, Cont contIesire) {
		super();
		this.idTipContabil=idTipContabil;
		this.denumireTip = denumireTip;
		this.contProprietar = contProprietar;
		this.contIntrare = contIntrare;
		this.contIesire = contIesire;
	}

	public Integer getIdTipContabil() {
		return idTipContabil;
	}

	public void setIdTipContabil(Integer idTipContabil) {
		this.idTipContabil = idTipContabil;
	}

	public String getDenumireTip() {
		return denumireTip;
	}

	public Cont getContProprietar() {
		return contProprietar;
	}

	public Cont getContIntrare() {
		return contIntrare;
	}

	public Cont getContIesire() {
		return contIesire;
	}

	@Override
	public String toString() {
		return "TipContabil [idTipContabil=" + idTipContabil + ", denumireTip=" + denumireTip + ", contProprietar=" + contProprietar
				+ ", contIntrare=" + contIntrare + ", contIesire=" + contIesire + "]";
	}
	
}
