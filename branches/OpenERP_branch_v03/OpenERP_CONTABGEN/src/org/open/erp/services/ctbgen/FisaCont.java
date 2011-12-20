package org.open.erp.services.ctbgen;

import java.util.Date;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Entity)
 * 
 */
public class FisaCont {
	LunaLucru luna;
	Date dataArt;
	String denumireArt;
	Double SumaDebit;
	Double SumaCredit;
	//eventual Double Sold
	Cont  contcorecpondent;
	
	public FisaCont(LunaLucru luna, Date dataArt, String denumireArt, Double sumaDebit, Double sumaCredit, Cont contcorecpondent) {
		super();
		this.luna = luna;
		this.dataArt = dataArt;
		this.denumireArt = denumireArt;
		SumaDebit = sumaDebit;
		SumaCredit = sumaCredit;
		this.contcorecpondent = contcorecpondent;
	}

	public LunaLucru getLuna() {
		return luna;
	}

	public void setLuna(LunaLucru luna) {
		this.luna = luna;
	}

	public String getDenumireArt() {
		return denumireArt;
	}

	public void setDenumireArt(String denumireArt) {
		this.denumireArt = denumireArt;
	}

	public Double getSumaCredit() {
		return SumaCredit;
	}

	public void setSumaCredit(Double sumaCredit) {
		SumaCredit = sumaCredit;
	}

	public Double getSumaDebit() {
		return SumaDebit;
	}

	public void setSumaDebit(Double sumaDebit) {
		SumaDebit = sumaDebit;
	}

	public Cont getContcorecpondent() {
		return contcorecpondent;
	}

	public void setContcorecpondent(Cont contcorecpondent) {
		this.contcorecpondent = contcorecpondent;
	}
	
}
